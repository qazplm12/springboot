package com.bitc.jpatest.controller;

import com.bitc.jpatest.data.entity.EmployeesEntity;
import com.bitc.jpatest.service.EmployeesService;
import com.bitc.jpatest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class JpaTestController {

    private final ProductService productService;
    private final EmployeesService employeesService;

//    @RequestMapping("/")
//    public String index() throws Exception {
//        productService.finds();
//        productService.exists();
//        productService.count();
////        productService.delete();
////        productService.limit();
////        productService.equals();
////        productService.isNot();
////        productService.isNull();
////        productService.isNotNull();
//        productService.and();
////        productService.or();
////        productService.between();
////        productService.like();
////        productService.orderBy();
//
//
//        return "success";
//    }

    @RequestMapping("/query")
    public String query() throws Exception {
        productService.querySelectAll();
        productService.querySelectName();


        return "query success";
    }


    @RequestMapping("/employees")
    public String employees() throws Exception {
        employeesService.getEmployeeMemberInfo(10001);
        employeesService.getEmployeesMemberInfoList("Mario");


//        List<EmployeesEntity> list = employeesService.querySelectGender("M");
//        employeesService.selectFirstNameStartsWith("S");
//        int countName =  employeesService.countNameStartsWith("S");
//
//        System.out.println(list);
//        System.out.println(countName);

        return "employees success";
    }

}
