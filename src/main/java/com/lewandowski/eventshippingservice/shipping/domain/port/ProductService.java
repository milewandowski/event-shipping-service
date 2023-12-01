package com.lewandowski.eventshippingservice.shipping.domain.port;

import com.lewandowski.eventshippingservice.shipping.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public final class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductsByIds(List<String> productIds) {
        return productIds.stream()
                .map(productRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public void update(Product product) {
        productRepository.save(product);
    }
}
