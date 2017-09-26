package be.vdab.entiteiten;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private String payMethod;
    private int orderTotal;
    private Date date;
    //customerId
    //eshopId

    private List<OrderDetail> details;

    public void addOrderDetail(OrderDetail orderDetail) {
        if (details == null) {
            details = new ArrayList<OrderDetail>();
        }
        details.add(orderDetail);
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
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

    public int getOrderTotal() {
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
}
