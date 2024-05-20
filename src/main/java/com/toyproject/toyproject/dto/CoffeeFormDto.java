package com.toyproject.toyproject.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.toyproject.toyproject.entity.Coffee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class CoffeeFormDto {

    private Long id;

    @NotBlank(message = "상품명은 필수 입력입니다.")
    private String coffeeNm;

    @NotBlank(message = "상품 상세설명은 필수 입력입니다.")
    private String coffeeDetail;

    @NotNull(message = "가격은 필수 입력입니다.")
    private Integer price;

    //modelMapper를 사용
    private static ModelMapper modelMapper = new ModelMapper();

    //dto -> entity
    public Coffee createCoffee(){
        return modelMapper.map(this,Coffee.class);//itementity를 리턴

    }

    public static CoffeeFormDto of(Coffee coffee){
        return modelMapper.map(coffee, CoffeeFormDto.class);//itemFormDto를 리턴
    }


}
