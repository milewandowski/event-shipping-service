package com.lewandowski.eventshippingservice.shipping.domain.port;

import com.lewandowski.eventshippingservice.shipping.domain.model.Order;
import com.lewandowski.eventshippingservice.shipping.domain.model.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class ShippingService {

    private final StatusPublisher statusPublisher;
    private final ShipmentPublisher shipmentPublisher;
    private final ProductService productService;

    public void create(Order order) {
        shipmentPublisher.send(order, productService.getProductsByIds(order.getProductIds()));
        order.setStatus(Status.SENT);
        statusPublisher.send(order);
    }
}
