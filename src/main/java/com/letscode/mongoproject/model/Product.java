package com.letscode.mongoproject.model;

import com.letscode.mongoproject.dto.ProductDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("product")
@Getter @Setter
@Builder
public class Product {

    @Id
    private String codeNumber;

    @Field
    private Float price;

    @Field
    private Integer stockAmmount;

    public static Product convertToModel(ProductDTO dto) {
        return Product.builder()
                .codeNumber(dto.getCodeNumber())
                .price(dto.getPrice())
                .stockAmmount(dto.getStockAmmount())
                .build();
    }
}
