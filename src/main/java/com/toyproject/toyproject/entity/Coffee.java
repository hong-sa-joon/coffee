package com.toyproject.toyproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "coffee")
@Getter
@Setter
@ToString
public class Coffee extends BaseEntity {
    @Id
    @Column(name = "coffee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //상품코드

    @Column(nullable = false, length = 50)
    private String coffeeNm;

    @Column(nullable = false)
    private long price;

    @Lob
    @Column(nullable = false, columnDefinition = "longtext")
    private String coffeeDetail;

}
