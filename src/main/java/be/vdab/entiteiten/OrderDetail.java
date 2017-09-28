package be.vdab.entiteiten;

public class OrderDetail  {
    private long id;
    private double amount;
    private long productId;

    public OrderDetail(long id, double amount, long productId) {
        this.id = id;
        this.amount = amount;
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }
}
