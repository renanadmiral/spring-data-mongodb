package com.letscode.mongoproject.service;

import com.letscode.mongoproject.dto.ProductDTO;
import com.letscode.mongoproject.dto.ShopProductDTO;
import com.letscode.mongoproject.model.Product;
import com.letscode.mongoproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO saveProduct(ProductDTO requestProduct){
        Product product = Product.convertToModel(requestProduct);
        return ProductDTO.convertToDto(productRepository.save(product));
    }

    public List<ProductDTO> listProducts(String codeNumber, Pageable pageable) {

        if (codeNumber != null) {
            List<ProductDTO> list = new ArrayList<>();
            list.add(ProductDTO.convertToDto(findByCode(codeNumber)));
            return list;
        }

        return productRepository
                .findAll(pageable)
                .stream().map(ProductDTO::convertToDto)
                .collect(Collectors.toList());
    }

    public Product findByCode(String codeNumber) {
        return productRepository.findById(codeNumber)
                .orElseThrow(RuntimeException::new);
    }

    public void decreaseStock(ShopProductDTO dto) {
        Product product = productRepository.findById(dto.getProductCodeNumber()).get();
        product.setStockAmmount(product.getStockAmmount() - dto.getAmmount());
        productRepository.save(product);
    }
}
