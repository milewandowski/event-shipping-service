package com.lewandowski.eventshippingservice.shipping.adapter.shipmentpublisher;

import com.lewandowski.eventshippingservice.shipping.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
class OrderToShipment {

    Shipment map(Order order) {
        return new Shipment(order.getId(),
                order.getName(),
                order.getPhoneNumber(),
                order.getEmailAddress(),
                order.getAddress().getCountry(),
                order.getAddress().getPostalCode(),
                order.getAddress().getCity(),
                order.getAddress().getAddress(),
                order.getProductIds());
    }
}
