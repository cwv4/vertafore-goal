package com.vertafore.apachekafka.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Order {

    private static final Logger LOGGER = LoggerFactory.getLogger(Order.class);

    private int id;
    private String orderName;
    private double totalAmount;

    public Order() {
    }

    public Order(int id, String orderName, double totalAmount) {
        this.id = id;
        this.orderName = orderName;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void verify() {
        LOGGER.info("Order id {}, name {}, amount {} verified", id, orderName, totalAmount);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
