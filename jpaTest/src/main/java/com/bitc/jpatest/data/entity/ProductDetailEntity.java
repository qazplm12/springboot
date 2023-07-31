package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

// JPA Audit : 감시하다라는 의미로 각 데이터 마다 누가 언제 데이터를 생성했고 변경했는지 감시하는 기능
// JPA Audit 기능 활성화
// 1번 방식 : Application 클래스에 @EnableJpaAuditing 어노테이션 추가
// 2번 방식 : Configuration 클래스 생성 후 @EnableJpaAuditing 어노테이션 추가

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ProductDetailEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

//    @Column(nullable = false)
//    private LocalDateTime createdAt = LocalDateTime.now(); // 등록 시간
//
//    private LocalDateTime updatedAt; // 최종 수정 시간


    // @OneToOne : 다른 Entity 객체를 필드(컬럼)으로 지정할 경우에, 1:1 관계로 설정 시 사용하는 어노테이션
    //      - mappedBy : @OneToOne 어노테이션 사용 시 메인이 되는 Entity에 설정,
    //      값은 서브가 되는 Entity에서 필드로 지정한 이름을 써야함
    //      - optional : 서브가 되는 Entity의 @OneToOne에 optional = false를 사용 시 null을 허용하지 않음
    // 양방향 매핑을 할 경우에만 메인에 @OneToOne(mappedBy )를 사용함
    // @OneToMany : 다른 Entity 객체를 필드로 지정할 경우 1:N 관계로 설정 시 사용하는 어노테이션
    // @ManyToOne : 다른 Entity 객체를 필드로 지정할 경우 N:1 관계로 설정 시 사용하는 어노테이션
    // @ManyToMany : 다른 Entity 객체를 필드로 지정할 경우 N:N 관계로 설정 시 사용하는 어노테이션

    // @JoinColumn : 외래키를 설정하는 어노테이션
    //      - name : 사용자가 원하는 이름으로 매핑, 생략 시 자동으로 입력됨
    //      - referencedColumnName : 외래키가 참조할 상대 테이블의 컬럼명 지정
    //      - foreignKey : 외래키 생성 시 제약조건을 설정 (nullable, unique 등)

    @OneToOne // (optional = false)
    @JoinColumn(name = "product_number")
    private ProductEntity product;


}
