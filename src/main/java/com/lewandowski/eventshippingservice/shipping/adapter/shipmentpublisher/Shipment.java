package com.lewandowski.eventshippingservice.shipping.adapter.shipmentpublisher;

import com.lewandowski.eventshippingservice.shipping.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Shipment {
    String id;
    String name;
    String phoneNumber;
    String emailAddress;
    String country;
    String postalCode;
    String city;
    String address;
    List<Product> products;
}
