package com.rbinnovative.orders.model.request;

import com.rb.innovative.client.model.Order;

public class ReservationRequest {
    private Order order;

    public ReservationRequest(){
    }

    public Order getOrder() {
        return order;
    }

    public ReservationRequest setOrder(Order order) {
        this.order = order;
        return this;
    }
}
