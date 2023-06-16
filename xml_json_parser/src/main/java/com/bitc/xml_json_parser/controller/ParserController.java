package com.bitc.xml_json_parser.controller;

import com.bitc.xml_json_parser.DTO.PharmacyFullDataItemDTO;
import com.bitc.xml_json_parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parse")
public class ParserController {

    @Autowired
    private ParserService parserService;

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
    public Object getFullDataUrl(@RequestParam("pageNo") String pageNo, @RequestParam("numOfRows") String numOfRows) throws Exception {

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
}
