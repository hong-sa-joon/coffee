package com.toyproject.toyproject.Repository;


import com.toyproject.toyproject.dto.CoffeeSearchDto;
import com.toyproject.toyproject.entity.Coffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoffeeRepositoryCustom {
    Page<Coffee> getCoffeePage(CoffeeSearchDto coffeeSearchDto, Pageable pageable);

}