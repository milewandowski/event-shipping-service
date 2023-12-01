package com.lewandowski.eventshippingservice.shipping.domain.port;

import com.lewandowski.eventshippingservice.shipping.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
