package com.letscode.mongoproject.model;

import com.letscode.mongoproject.dto.ShopProductDTO;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
public class ShopProduct {

    @Field
    private  String productCodeNumber;

    @Field
    private Integer ammount;

    public static ShopProduct convertToModel(ShopProductDTO dto) {
        return ShopProduct.builder()
                .productCodeNumber(dto.getProductCodeNumber())
                .ammount(dto.getAmmount())
                .build();
    }
}
