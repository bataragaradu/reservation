package com.rbinnovative.orders.service;

import com.rb.innovative.client.ApiException;
import com.rb.innovative.client.model.Order;
import com.rbinnovative.orders.model.request.ReservationRequest;
import com.rbinnovative.orders.exception.ReservationException;

import java.util.List;

public interface TransactionProcessor {

    Order processOneQuery(Integer id) throws ReservationException;
    List<Order> processAllQuery() throws ApiException;

    Integer createReservation(Order reservationRequest) throws ApiException;
//    void removeReservation(Integer id) throws ReservationException;
}
