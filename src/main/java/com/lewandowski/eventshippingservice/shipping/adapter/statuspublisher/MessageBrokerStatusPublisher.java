package com.lewandowski.eventshippingservice.shipping.adapter.statuspublisher;

import com.lewandowski.eventshippingservice.shipping.domain.model.Order;
import com.lewandowski.eventshippingservice.shipping.domain.port.StatusPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
class MessageBrokerStatusPublisher implements StatusPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(Order order) {
        kafkaTemplate.send("order-status-changed", order);
    }
}
