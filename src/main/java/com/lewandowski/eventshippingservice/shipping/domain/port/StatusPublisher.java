package com.lewandowski.eventshippingservice.shipping.domain.port;

import com.lewandowski.eventshippingservice.shipping.domain.model.Order;

public interface StatusPublisher {

    void send(Order order);
}
