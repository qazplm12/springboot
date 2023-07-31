package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_employees")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false)
    private LocalDateTime hireDate;

    @OneToMany(mappedBy = "employees")
    @ToString.Exclude // 양방향 관계 설정 시 toString을 사용할 경우 상호참조가 발생
    private List<SalariesEntity> salariesList = new ArrayList<>();

    @OneToMany(mappedBy = "employees")
    @ToString.Exclude // 양방향 관계 설정 시 toString을 사용할 경우 상호참조가 발생
    private List<TitlesEntity> titlesList = new ArrayList<>();


}
