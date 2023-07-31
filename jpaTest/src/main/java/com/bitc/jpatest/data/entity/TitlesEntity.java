package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "jpa_titles")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TitlesEntity extends EmpBaseEntity {

//    @Id
//    private long empNo;

    @Id
    private String title;

    private LocalDateTime fromDate;

    @Id
    @ManyToOne
    @ToString.Exclude
    private EmployeesEntity employees;
}
