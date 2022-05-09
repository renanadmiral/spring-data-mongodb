package com.letscode.mongoproject.dto;

import com.letscode.mongoproject.model.ShopProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductDTO {
    private String productCodeNumber;
    private Integer ammount;

    public static ShopProductDTO convertToDto(ShopProduct sp) {
        return ShopProductDTO.builder()
                .productCodeNumber(sp.getProductCodeNumber())
                .ammount(sp.getAmmount())
                .build();
    }
}
