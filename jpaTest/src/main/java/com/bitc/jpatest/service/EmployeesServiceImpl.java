package com.bitc.jpatest.service;

import com.bitc.jpatest.data.entity.EmployeesEntity;
import com.bitc.jpatest.data.repository.EmployeesRepository;
import com.bitc.jpatest.data.dto.EmployeesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeesServiceImpl implements EmployeesService{

    private final EmployeesRepository employeesRepository;

    @Override
    public EmployeesEntity getEmployeeMemberInfo(int empNo) {
        Optional<EmployeesEntity> empInfo = employeesRepository.findByEmpNo(10001);

        if (empInfo.isPresent()) {
            EmployeesEntity emp = empInfo.get();
            return emp;
        } else {
            return null;
        }
    }

    @Override
    public List<EmployeesEntity> getEmployeesMemberInfoList(String firstName) {
        List<EmployeesEntity> empList = employeesRepository.findAllByFirstName("Mario");
        return empList;
    }

    @Override
    public EmployeesDTO getMemberInfoEmpNo(int empNo) {
        Optional<EmployeesEntity> empInfo = employeesRepository.findByEmpNo(empNo);

        EmployeesDTO member = new EmployeesDTO();
        member.setEmpNo(empInfo.get().getEmpNo());
        member.setEmpName(empInfo.get().getFirstName() + empInfo.get().getLastName());
        member.setEmpGender(empInfo.get().getGender());

        return member;
    }

    @Override
    public List<EmployeesDTO> getMemberInfoEmpName(String empName) {
        List<EmployeesDTO> memberList = new ArrayList<>();

        List<EmployeesEntity> empList = employeesRepository.findAllByFirstName(empName);

        for (EmployeesEntity item : empList) {
            EmployeesDTO member = new EmployeesDTO();
            member.setEmpNo(item.getEmpNo());
            member.setEmpName(item.getFirstName() + item.getLastName());
            member.setEmpGender(item.getGender());

            memberList.add(member);
        }
        return memberList;
    }



//    @Override
//    public void selectFirstNameStartsWith(String Name) throws Exception {
//
//        employeesRepository.findByFirstNameStartsWith(Name);
//    }
//
//    @Override
//    public int countNameStartsWith(String Name) throws Exception {
//
//        return employeesRepository.countByFirstNameStartsWith(Name);
//    }
//
//    @Override
//    public List<EmployeesEntity> querySelectGender(String gender) throws Exception {
//        return employeesRepository.querySelectGender(gender);
//    }
}
