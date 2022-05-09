package com.letscode.mongoproject.controller;

import com.letscode.mongoproject.dto.ShopDTO;
import com.letscode.mongoproject.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @PostMapping
    public ShopDTO postShop(@RequestBody ShopDTO shop) {
        return shopService.saveShop(shop);
    }

    @GetMapping
    public List<ShopDTO> getAllShops(
            @RequestParam(name = "customer-registration", required = false)
                String customerRegistration,
            Pageable pageable
    ){
        return shopService.listShops(customerRegistration, pageable);
    }

}
