package com.letscode.mongoproject.controller;

import com.letscode.mongoproject.dto.ProductDTO;
import com.letscode.mongoproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO postProduct(@RequestBody ProductDTO product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(
            @RequestParam(name = "code-number", required = false)
                String codeNumber,
            Pageable pageable
    ) {
        return productService.listProducts(codeNumber, pageable);
    }
}
