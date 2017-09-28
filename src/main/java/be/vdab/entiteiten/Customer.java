package be.vdab.entiteiten;

public class Customer extends User {
    private String name;
    private String firstName;
    private String email;
    private String deliveryAddress;

    public Customer(long id, String username, String password, String name, String firstName, String email, String deliveryAddress) {
        super(id, username, password);
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "name: " + name + "\nfirst name: " + firstName + "\nemail: " + email + "\ndelivery address: " + deliveryAddress;
    }
}
