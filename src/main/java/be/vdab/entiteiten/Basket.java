package be.vdab.entiteiten;

public class Basket {
    private long id;
    private double amount;
    private long orderId;
    private long productId;

    public Basket(long id, double amount, long orderId, long productId) {
        this.id = id;
        this.amount = amount;
        this.orderId = orderId;
        this.productId = productId;
    }
}
