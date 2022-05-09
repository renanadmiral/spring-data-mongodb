package com.letscode.mongoproject.dto;

import com.letscode.mongoproject.model.Shop;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ShopDTO {

    private LocalDateTime shopDate;
    private Float totalValue;
    private String customerRegistration;

    private List<ShopProductDTO> products;

    public static ShopDTO convertToDto (Shop shop) {
        return ShopDTO.builder()
                .shopDate(shop.getShopDate())
                .customerRegistration(shop.getCustomerRegistration())
                .totalValue(shop.getTotalValue())
                .products(
                        shop.getShopProducts().stream()
                                .map(ShopProductDTO::convertToDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
