package com.lewandowski.eventshippingservice.shipping.adapter.shipmentpublisher;

import com.lewandowski.eventshippingservice.shipping.domain.model.Order;
import com.lewandowski.eventshippingservice.shipping.domain.port.ShipmentPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class MessageBrokerShipmentPublisher implements ShipmentPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OrderToShipment orderToShipment;

    @Override
    public void send(Order order) {
        Shipment shipment = orderToShipment.map(order);
        kafkaTemplate.send("shipment-local", shipment);
        log.info("Shipment sent: {}", shipment);
    }
}
