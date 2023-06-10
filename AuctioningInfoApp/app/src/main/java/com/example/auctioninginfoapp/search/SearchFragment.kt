package com.example.auctioninginfoapp.search

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.auctioninginfoapp.R
import com.example.auctioninginfoapp.database.DatabaseModule
import com.example.auctioninginfoapp.databinding.FragmentSearchBinding
import com.example.auctioninginfoapp.model.Fruits
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/* 경락 정보 검색 SearchFragment  */
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    var selectedFruit: String? = null
    var selectedDate: String? = null

    /* DatabaseModule.getDatabase(싱글톤)를 이용하여 데이터베이스를 가져오기 */
    private val database by lazy {
        DatabaseModule.getDatabase(requireContext())
    }

    /* SearchAdapter 생성  */
    private val searchAdapter by lazy { SearchAdapter(database.freshDao()) }

    /* todo2 - 사용자가 클릭할때 분류(농산물)를 선택하는 Dialog 설정
    - alertDialog를 사용하여 농산물을 선택하는 Dialog 설정
    - AlertDialog에 setItems(컬렉션, 리스너)를 사용하면 SingleChoice Dialog를 만들 수 있음
    - setItems(CharSequence[] items, final OnClickListener listener)
     */
    /* -----------------------Alert Dialog------------------------*/

    private val alertDialog by lazy {  /* 농산물 선택을 위한 Dialog 설정 */

        // Dialog의 builder 클래스를 초기화
        val builder = AlertDialog.Builder(requireContext())
        // builder에 Dialog 제목을 설정
        builder.setTitle("농산물을 선택해주세요.")

        /* 분류 Dialog에서 농산물을 선택하면, 해당 농산물의 상수명을 반환하도록 builder 설정
         - builder.setItems(p1, p2): Dialog에 리스트 추가하는 함수
            . p1: Dialog 창에 지정할 리스트(List)
            . p2: 리스트 항목을 클릭했을 때 이벤트 처리를 위한 DialogInterface.OnClickListener()를 구현한 구현체
                  (리스트 항목을 클릭하면 선택된 항목의 index가 두 번째 매개변수로 넘어옴)
          - map: 컬렉션 내 인자를 변환하여 반환
          - Fruits.values().map: Fruits의 모든 value(상수)를 가져와서 컬렉션 객체로 반환
          - toTypedArray(): 컬렉션을 배열로 변환
          - OnClickListener를 통해 선택된 아이템의 index를 넘겨 받아, Fruits.values()[index]로 선택한 농산물의 상수명을 selectedFruit에 저장
        */
        builder.setItems(Fruits.values().map { it.holder }.toTypedArray()) { _, index ->

            with(Fruits.values()[index]) {// 선택한 Enum의 키값(상수명)을 String 형태로 리턴
                selectedFruit = this.name
                binding.textType.text = this.holder // 선택한 과일명을 선택창에 표시
            }
            Log.i("FRESH", "which: $index - $selectedFruit")//0 - APPLE

            checkCondition() // 검색버튼의 색상을 변경하는 함수 호출
        }

        // builder에 취소 버튼을 설정(이벤트는 Null로 설정)
        builder.setNegativeButton("취소", null)

        // 만든 builder를 반환
        builder.create() //return 되는 value
    }
    /* -----------------------End of Alert Dialog------------------------*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 리사이클러뷰의 구분선(Divider)를 설정
        DividerItemDecoration(
            requireContext(),
            LinearLayoutManager(requireContext()).orientation
        ).run { // 리사이클러뷰(list_save)에 구분선(Divider) 추가
            binding.listSearch.addItemDecoration(this)
        }

        // 검색 농산물, 날짜 초기화
        selectedFruit= null
        selectedDate= null

        // 리사이클러뷰에 adapter, layoutManager 설정
        binding.listSearch.adapter = searchAdapter
        binding.listSearch.layoutManager = LinearLayoutManager(requireContext())

        /* todo1 - 사용자가 layout_type([분류를 선택해주세요] 레이아웃)을 클릭한 경우 이벤트 처리
        - [농산물을 선택해주세요] 레이아웃을 클릭하면 과일을 선택하는 Dialog를 출력하는 alertDialog를 실행
         */
        binding.layoutType.setOnClickListener { alertDialog.show() } // 농산물을 선택하세요 누르면 창 띄워짐.

        /* todo3 - 검색 날짜 Dialog를 띄워주기 */
        /* [날짜를 선택해주세요] 레이아웃을 클릭했을 경우 */
        binding.layoutDate.setOnClickListener {
            val currentCaldenar =
                Calendar.getInstance().apply { time = Date(System.currentTimeMillis()) } // Calender 객체 생성(현재날짜를 기준으로)

        /* 날짜 선택을 위한 DatePickerDialog 띄우기
           - DatePickerDialog(p1, p2, p3).show
             p1: context
             p2: OnDateSetListener 구현체(onDateSet() 메서드를 구현한 람다식)
                (DatePickerDialog 창에서 사용자가 날짜 정보를 선택한 뒤 완료 버튼을 클릭했을 때 실행)
             p3: Dialog 창을 처음 띄울 때 표시될 날짜 정보
        */
            DatePickerDialog(requireContext(), // p1
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth -> // p2
                    currentCaldenar.apply {
                        set(Calendar.YEAR, year)
                        set(Calendar.MONTH, month)
                        set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    }.run {
                        // 선택한 데이터를 2023-01-01와 같은 형식으로 가져오기
                        selectedDate = SimpleDateFormat("yyyy-MM-dd").format(currentCaldenar.time)
                        // 날짜 선택 여부를 체크하여 처리하기 위한 함수 호출
                        changeInputTextBydate() // 선택한 날짜를 선택창에 표시
                    }
                },
                // p3 : DatePickerDialog의 Date를 오늘 날짜로 초기화
                currentCaldenar.get(Calendar.YEAR),
                currentCaldenar.get(Calendar.MONTH),
                currentCaldenar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        /* PagingData 빌드 및 생성(LiveData)
        - 페이징 구성을 정의한 PagingConfig를 기반으로 LiveData<PagingData>를 생성
        - PagingConfig(pageSize, initialKey,...)
          pageSize: 각 페이지에 로드할 데이터 수(필수 매개변수)
        - FreshDao에 정의한 DataSource.Factory를 이용하여 생성한 DataSource를 asPagingSourceFactory()를 이용하여 LiveData<PagingData> 형태로 변환
        */
        val pageLiveData = Pager(
            PagingConfig(20), 1,
            database.freshDao().loadSaveItems().asPagingSourceFactory(Dispatchers.IO)
        ).liveData

        /* pagingData(LiveData)에 observe() 메서드로 Observer 객체 등록(데이터 변경시 자동 호출)
        - LiveData를 관찰하여 PageData에 변경이 있을 시 Adapter에 전달
        - owner : Observer를 제어하는 LifecycleOwner
        - Observer : LiveDta 로부터 이벤트를 수신하는 Observer 객체(데이터가 변경되면 호출됨)
        */
        pageLiveData.observe(viewLifecycleOwner) {
            /*
             변경된 pagingData를 NoteAdapter에 전달
              - pagingData를 submit하면 NoteAdapter 의 DIFF_CALLBACK은
                기존에 pagingData가 존재 시 그 차이를 비교한 후 리사이클러 뷰를 새로운 페이지로 갱신함.
            */
            lifecycleScope.launch { searchAdapter.submitData(it) }
        }

        /* todo4 - 사용자가 검색 버튼(btn_search)을 클릭했을 경우 이벤트 처리 */
        binding.btnSearch.setOnClickListener {
            /* 과일과 날짜를 선택했는지 검증
             - selectedFruit: 과일의 상수명(APPLE, GRAPE, WATERMELON, ...)
             - selectedDate:  날짜(YYYY-MM-DD)
            */
            if (selectedDate == null || selectedFruit == null) { // 둘 중 하나 선택이 안된 경우 에러 메세지 띄우기.
                Toast.makeText(requireContext(), "분류와 날짜를 입력해주세요.", Toast.LENGTH_LONG).show()
            } else {
                Log.i("SELECT_DATE", selectedDate!!)
                Log.i("SELECT_FRUIT", selectedFruit!!)

                /* 검색 요청을 위한 과일/일자/수량을 Bundle 객체에 ResultFragemtnt에 전달
                 - ResultFragment로 화면 전환 */
                findNavController().navigate(
                    R.id.action_searchFragment_to_resultFragment,
                    Bundle().apply { // 과일, 일자, 수량을 Bundle 객체에 적용
                        putString("SELECT_FRUIT", selectedFruit)
                        putString("SELECT_DATE", selectedDate)
                        putString("RESULT_AMOUNT", view.findViewById<RadioButton>(binding.radioLayout.checkedRadioButtonId)
                            .tag.toString()
                        )
                    }
                )
            }
        }
    }//end of onViewCreated

    /* 날짜 선택 여부를 체크하여 선택한 날짜를 선택창에 표시하는 함수*/
    private fun changeInputTextBydate() { // 분류와 날짜를 모두 선택하면 검색 버튼의 색상을 변경하는 함수 호출
        checkCondition()
        // Date이 선택되었다면 날짜 선택창에 날짜 표시
        selectedDate?.let { binding.txtGongpan.text = it }
    }

    /* 분류와 날짜를 모두 선택하면 검색버튼과 글자의 색상을 변경하는 함수 */
    private fun checkCondition() {
        if (selectedDate != null && selectedFruit != null) {
            binding.btnSearch.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.colorAccent, null))
            binding.btnSearch.setTextColor(ResourcesCompat.getColor(resources, android.R.color.white, null))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}