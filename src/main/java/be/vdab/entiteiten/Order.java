package be.vdab.entiteiten;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private String payMethod;
    private double orderTotal;
    private Date date;
    private long customerId;
    private long eShopId;
    private double amount;
    private long productId;

    public Order(){

    }

    public Order(String payMethod, double orderTotal, Date date, long customerId, long eShopId, double amount, long productId) {
        this.payMethod = payMethod;
        this.orderTotal = orderTotal;
        this.date = date;
        this.customerId = customerId;
        this.eShopId = eShopId;
        this.amount = amount;
        this.productId = productId;
    }

    public Order(long id, String payMethod, double orderTotal, Date date, long customerId, long eShopId) {
        this.id = id;
        this.payMethod = payMethod;
        this.orderTotal = orderTotal;
        this.date = date;
        this.customerId = customerId;
        this.eShopId = eShopId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long geteShopId() {
        return eShopId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "orderId: "+ getId() +"\npayment method: "+ getPayMethod() +"\norder total: "+ getOrderTotal() +"\ndate: "+ getDate() +"\ncustomerId: "+ getCustomerId() +"\neshopId: "+ geteShopId();
    }
}
