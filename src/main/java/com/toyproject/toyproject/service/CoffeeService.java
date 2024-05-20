package com.toyproject.toyproject.service;


import com.toyproject.toyproject.Repository.CoffeeRepository;
import com.toyproject.toyproject.dto.CoffeeFormDto;
import com.toyproject.toyproject.entity.Coffee;
import com.toyproject.toyproject.entity.ItemImg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CoffeeService {

private final CoffeeRepository coffeeRepository;
    private final ItemImgService itemImgService;

public Long saveCoffee(CoffeeFormDto coffeeFormDto, List<MultipartFile> itemImgFileList) throws Exception{

    Coffee coffee = coffeeFormDto.createCoffee();
    coffeeRepository.save(coffee);

    // 2. 이미지 등록(5개의 이미지를 등록해야 하므로 for문으로 하나씩 저장)
    for (int i = 0; i < itemImgFileList.size(); i++) {
        ItemImg itemImg = new ItemImg();
        itemImg.setCoffee(coffee); // ★ itemImg가 item을 참조하므로 insert 하기 전 반드시 item 객체를 넣어준다

        // 첫번째 이미지일 때 대표 이미지로 지정
        if (i == 0) {
            itemImg.setRepImgYn("Y");
        } else {
            itemImg.setRepImgYn("N");
        }

        // 이미지 파일을 하나씩 저장
        itemImgService.savedItemImg(itemImg, itemImgFileList.get(i));
    }


    return coffee.getId();
}

}
