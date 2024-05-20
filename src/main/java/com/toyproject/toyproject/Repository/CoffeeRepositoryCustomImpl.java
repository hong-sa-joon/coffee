package com.toyproject.toyproject.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toyproject.toyproject.dto.CoffeeSearchDto;
import com.toyproject.toyproject.entity.Coffee;
import com.toyproject.toyproject.entity.QCoffee;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import java.util.List;


public class CoffeeRepositoryCustomImpl implements CoffeeRepositoryCustom {
    private JPAQueryFactory queryFactory;

    public CoffeeRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery) {
        if (StringUtils.equals("title", searchBy)) {
                    //select from board where title like ("%searchQuery%")
            return QCoffee.coffee.coffeeNm.like("%" + searchQuery + "%");//제목검색
        } else if (StringUtils.equals("content", searchBy)) {
            //select from board where content like ("%searchQuery%")
            return QCoffee.coffee.coffeeDetail.like("%" + searchQuery + "%");//내용검색
        }

        return null;
    }

    @Override
    public Page<Coffee> getCoffeePage(CoffeeSearchDto coffeeSearchDto, Pageable pageable) {

        List<Coffee> content = queryFactory
                .selectFrom(QCoffee.coffee)
                .where(searchByLike(coffeeSearchDto.getSearchBy(), coffeeSearchDto.getSearchQuery()))
                .orderBy(QCoffee.coffee.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory.select(Wildcard.count).from(QCoffee.coffee)//select count(*) from board
                .where(searchByLike(coffeeSearchDto.getSearchBy(),
                        coffeeSearchDto.getSearchQuery()))
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }
}
