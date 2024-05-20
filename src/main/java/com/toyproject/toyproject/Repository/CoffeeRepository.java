package com.toyproject.toyproject.Repository;


import com.toyproject.toyproject.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CoffeeRepository extends JpaRepository<Coffee, Long>, QuerydslPredicateExecutor<Coffee>, CoffeeRepositoryCustom  {
}