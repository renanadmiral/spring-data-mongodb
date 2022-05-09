package com.letscode.mongoproject.dto;

import com.letscode.mongoproject.model.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDTO {

    private String codeNumber;
    private Float price;
    private Integer stockAmmount;

    public static ProductDTO convertToDto(Product product) {
        return ProductDTO.builder()
                .codeNumber(product.getCodeNumber())
                .price(product.getPrice())
                .stockAmmount(product.getStockAmmount())
                .build();
    }
}
