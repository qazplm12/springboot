package com.bitc.xml_json_parser.controller;

import com.bitc.xml_json_parser.DTO.DailyBoxOfficeDTO;
import com.bitc.xml_json_parser.DTO.PharmacyFullDataItemDTO;
import com.bitc.xml_json_parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parse")
public class ParserController {

    @Autowired
    private ParserService parserService;

    @Value("${full505.kobis.json.DailyboxOfficeResultUrl}")
    private String serviceUrl;

    @Value("${full505.kobis.json.serviceKey}")
    private String serviceKey;

    @RequestMapping({"/", ""})
    public String index() throws Exception {

        return "index";
    }

    @GetMapping("/pharmacy/fullDataFile")
    public ModelAndView getFullDataFile() throws Exception {
        ModelAndView mv = new ModelAndView("pharmacy/fullDataFile");

        List<PharmacyFullDataItemDTO> itemList = parserService.getItemListFile("C:\\smart505\\pharmacy.xml");

        mv.addObject("itemList", itemList);

        return mv;
    }

    @GetMapping("/pharmacy/fullDataUrl")
    public String getFullDataView() throws Exception {


        return "/pharmacy/fullDataUrl";
    }

    // ResponseBody : View 없이 Object만 날릴때
    @ResponseBody
    @PostMapping("/pharmacy/fullDataUrl")
    public Object getFullDataUrl(@RequestParam("pageNo") String pageNo,
                                 @RequestParam("numOfRows") String numOfRows) throws Exception {

        String serviceUrl = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown";
        String serviceKey = "?serviceKey=";
        String key = "0wcF9m%2FywVwZIHoI%2FPPFoZe49jnbgzWgFHOEtKZEMZeej8hiEf8GUxzYcq6VTrXHTLAnDbz3sSJ6vqtqKZYO2w%3D%3D";
        String opt1 = "&pageNo=";
        String opt2 = "&numOfRows=";

        List<PharmacyFullDataItemDTO> itemList = parserService.getItemListUrl(
                serviceUrl + serviceKey + key + opt1 + pageNo + opt2 + numOfRows
        );

        return itemList;
    }

    // 영화 진흥원 일일 박스오피스 출력 View
    @GetMapping("/kobis/dailyBoxOffice")
    public String dailyBoxOfficeView() throws Exception {


        return "/kobis/dailyBoxOffice";
    }

    // 영화 진흥원 일일 박스오피스 데이터 가져오기
    @ResponseBody
    @PostMapping("/kobis/dailyBoxOffice")

    public Object dailyBoxOfficeDataProcess(@RequestParam("targetDt") String targetDt) throws Exception {
        // DTO 3개 필요
//        String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" + targetDt;
        String url = serviceUrl + "?key=" + serviceKey + "&targetDt=" + targetDt;

        List<DailyBoxOfficeDTO> dailyBoxOfficeDTOList = parserService.getDailyBoxOfficeList(url);

        return dailyBoxOfficeDTOList;
    }
}
