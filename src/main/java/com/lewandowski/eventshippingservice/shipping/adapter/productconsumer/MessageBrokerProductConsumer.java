package com.lewandowski.eventshippingservice.shipping.adapter.productconsumer;

import com.lewandowski.eventshippingservice.shipping.domain.model.Product;
import com.lewandowski.eventshippingservice.shipping.domain.port.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class MessageBrokerProductConsumer {

    private final ProductService productService;

    @KafkaListener(topics = "product-change-topic", groupId = "shipping-service", properties = {
            "spring.json.value.default.type=com.lewandowski.eventshippingservice.shipping.domain.model.Product"})
    public void consume(@Payload Product product) {
        log.info("Product event received: {}", product);
        productService.update(product);
    }
}
