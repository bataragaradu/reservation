package com.rbinnovative.orders.service;

import com.rb.innovative.client.ApiException;
import com.rb.innovative.client.controller.DefaultApi;
import com.rb.innovative.client.model.Order;
import com.rbinnovative.orders.exception.ReservationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationProcessorImpl implements TransactionProcessor {

    @Autowired
    private DefaultApi defaultApi;

    @Override
    public Order processOneQuery(Integer id) throws ReservationException {
        return null;
    }

    @Override
    public List<Order> processAllQuery() throws ApiException {
      return  defaultApi.ordersGet();
    }

    @Override
    public Integer createReservation(Order reservationRequest) throws ApiException{
        return defaultApi.ordersPost(reservationRequest);
    }

}