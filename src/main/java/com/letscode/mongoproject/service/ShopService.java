package com.letscode.mongoproject.service;

import com.letscode.mongoproject.dto.ShopDTO;
import com.letscode.mongoproject.dto.ShopProductDTO;
import com.letscode.mongoproject.model.Product;
import com.letscode.mongoproject.model.Shop;
import com.letscode.mongoproject.model.ShopProduct;
import com.letscode.mongoproject.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final ProductService productService;

    public ShopDTO saveShop(ShopDTO requestShop){
       Float totalValue = calculateTotalValue(requestShop);

       Shop shop = Shop.builder()
               .id(UUID.randomUUID().toString())
               .shopDate(LocalDateTime.now())
               .totalValue(totalValue)
               .customerRegistration(requestShop.getCustomerRegistration())
               .shopProducts(
                       requestShop.getProducts().stream().map(ShopProduct::convertToModel)
                               .collect(Collectors.toList())
               )
               .build();

       shopRepository.save(shop);

       requestShop.getProducts().forEach(productService::decreaseStock);

       return ShopDTO.convertToDto(shop);
    }

    private Float calculateTotalValue(ShopDTO shopDTO) {
        Float totalValue = 0F;
        for (ShopProductDTO shopProductDTO: shopDTO.getProducts()) {
            Product product = productService.findByCode(shopProductDTO.getProductCodeNumber());
            totalValue += product.getPrice() * shopProductDTO.getAmmount();
        }
        return totalValue;
    }

    public List<ShopDTO> listShops(String customerRegistration, Pageable pageable) {

        if (customerRegistration != null) {
            return shopRepository.findByCustomerRegistration(customerRegistration).stream()
                    .map(ShopDTO::convertToDto)
                    .collect(Collectors.toList());
        }

        return shopRepository
                .findAll(pageable)
                .stream().map(ShopDTO::convertToDto)
                .collect(Collectors.toList());
    }
}
