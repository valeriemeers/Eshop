package be.vdab.entiteiten;

public class Eshop {
    private long id;
    private String info;
    private String address;

    public Eshop(long id, String address) {
        this(id, null, address);
    }

    public Eshop(long id, String info, String address) {
        this.id = id;
        this.info = info;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Eshop eshop = (Eshop) o;

        return id == eshop.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return id + " " + "info: " + info + "\taddress: " + address;
    }
}
