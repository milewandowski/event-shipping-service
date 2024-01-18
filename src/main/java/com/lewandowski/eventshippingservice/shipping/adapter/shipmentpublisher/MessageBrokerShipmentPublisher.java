package com.lewandowski.eventshippingservice.shipping.adapter.shipmentpublisher;

import com.lewandowski.eventshippingservice.shipping.domain.model.Order;
import com.lewandowski.eventshippingservice.shipping.domain.model.Product;
import com.lewandowski.eventshippingservice.shipping.domain.port.ShipmentPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
class MessageBrokerShipmentPublisher implements ShipmentPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OrderToShipment orderToShipment;

    @Override
    public void send(Order order, List<Product> products) {
        Shipment shipment = orderToShipment.map(order, products);
        kafkaTemplate.send("shipment-company", shipment);
        log.info("Shipment sent: {}", shipment);
    }
}
