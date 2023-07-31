package com.bitc.jpatest.service;

import com.bitc.jpatest.data.entity.EmployeesEntity;
import com.bitc.jpatest.data.dto.EmployeesDTO;

import java.util.List;

public interface EmployeesService {

    EmployeesEntity getEmployeeMemberInfo(int empNo);

    List<EmployeesEntity> getEmployeesMemberInfoList(String firstName);

//    void selectFirstNameStartsWith(String Name) throws Exception;
//
//    int countNameStartsWith(String Name)throws Exception;
//
//    List<EmployeesEntity> querySelectGender(String gender)throws Exception;

    // 사원 1명의 정보를 사원 번호로 가져옴
    EmployeesDTO getMemberInfoEmpNo(int empNo) ;

    // 사원 정보를 사원 이름을 기반으로 해서 모두 가져옴
    List<EmployeesDTO> getMemberInfoEmpName(String empName);

//    List<EmployeesDTO> getMemberInfoListEmpName(String empName);
}
