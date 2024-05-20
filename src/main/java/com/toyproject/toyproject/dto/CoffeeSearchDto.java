package com.toyproject.toyproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeSearchDto {
    private String searchBy;
    private String searchQuery = "";
}