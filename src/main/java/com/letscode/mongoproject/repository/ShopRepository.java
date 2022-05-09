package com.letscode.mongoproject.repository;

import com.letscode.mongoproject.model.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {
    public List<Shop> findByCustomerRegistration(String customerRegistration);
}
