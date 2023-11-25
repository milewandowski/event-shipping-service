package com.lewandowski.eventshippingservice.shipping.adapter.orderconsumer;

import com.lewandowski.eventshippingservice.shipping.domain.model.Order;
import com.lewandowski.eventshippingservice.shipping.domain.port.ShippingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class MessageBrokerOrderConsumer {

    private final ShippingService shippingService;

    @KafkaListener(topics = "order-payment-local2", groupId = "shipping-service")
    public void consume(@Payload Order order) {
        log.info("Order event received: {}", order);
        shippingService.create(order);
    }
}
