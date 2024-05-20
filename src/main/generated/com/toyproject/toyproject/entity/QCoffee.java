package com.toyproject.toyproject.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCoffee is a Querydsl query type for Coffee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCoffee extends EntityPathBase<Coffee> {

    private static final long serialVersionUID = -1337750454L;

    public static final QCoffee coffee = new QCoffee("coffee");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath coffeeDetail = createString("coffeeDetail");

    public final StringPath coffeeNm = createString("coffeeNm");

    //inherited
    public final StringPath createBy = _super.createBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final NumberPath<Long> price = createNumber("price", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public QCoffee(String variable) {
        super(Coffee.class, forVariable(variable));
    }

    public QCoffee(Path<? extends Coffee> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCoffee(PathMetadata metadata) {
        super(Coffee.class, metadata);
    }

}

