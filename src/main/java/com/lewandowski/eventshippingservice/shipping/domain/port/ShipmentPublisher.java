package com.lewandowski.eventshippingservice.shipping.domain.port;

import com.lewandowski.eventshippingservice.shipping.domain.model.Order;
import com.lewandowski.eventshippingservice.shipping.domain.model.Product;

import java.util.List;

public interface ShipmentPublisher {

    void send(Order order, List<Product> products);
}
