package com.letscode.mongoproject.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document("shop")
@Getter
@Builder
public class Shop {

    @Id
    private String id;

    @Field
    private LocalDateTime shopDate;

    @Field
    private Float totalValue;

    @Field
    private String customerRegistration;

    @Field
    private List<ShopProduct> shopProducts;
}
