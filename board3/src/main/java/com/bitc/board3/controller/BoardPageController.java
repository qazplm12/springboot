package com.bitc.board3.controller;

import com.bitc.board3.DTO.AddressDTO;
import com.bitc.board3.service.AddressService;
import com.bitc.board3.service.BoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardPageController {

    // PageInfo : PageHelper 라이브러리에서 제공하는 클래스
    // 아래와 같이 페이징에 관련된 정보 제공

    // pageNum : 현재 페이지 번호
    // pageSize : 페이지당 수량
    // size : 현재 페이지 수
    // startRow : 현재 페이지의 첫번쨰 요소가 데이터베이스에 있는 줄 번호
    // endRow : 현재 페이지의 마지막 요소가 데이터베이스에 있는 줄 번호
    // pages : 전체 페이지 수
    // prePage : 이전 페이지
    // nextPage : 다음 페이지
    // isFirstPage : 현재 페이지가 첫 페이지인지 여부 확인
    // isLastPage : 현재 페이지가 마지막 페이지인지 여부 확인
    // hasPreviousPage : 이전 페이지 유무 확인
    // hasNextPage : 다음 페이지 유무 확인
    // navigatePages : 네비게이션바에서 보여줄 페이지 수
    // navigatePageNums : 현재 페이지의 네비게이션바에서 보여줄 페이지 번호 (배열)
    // navigateFirstPage : 현재 페이지 네비게이션 바의 첫 페이지 (firstIndex 의 value)
    // navigateLastPage : 현재 페이지 네비게이션 바의 마지막 페이지 (lastIndex 의 value)

    @Autowired
    private AddressService addressService;


    // required : 파라미터 값 여부 설정, true/false, true면 파라미터 값이 반드시 존재해야 함,
    // false면 파라미터 값이 없어도 오류가 발생하지 않음(false로 사용할 경우 defaultValue 속성 필수)
    // defaultValue : 사용자가 입력한 파라미터 값이 없을 경우 지정된 기본값 사용
    @RequestMapping("/page/addressList")
    public ModelAndView addressList(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("page/addressList");

        // 첫번째 매개변수는 서비스를 사용하여 DB에서 데이터 가져오기
        // 두번째 매개변수가 한 페이지에 출력할 페이지 버튼 수
        PageInfo<AddressDTO> p = new PageInfo<>(addressService.getAddressList(pageNum), 5);

        mv.addObject("addressList", p);

        return mv;
    }
}
