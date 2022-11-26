package ces.augusto108.uml_casestudy.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Purchase implements Serializable {
    private static final long serialVersionUID = 9060631776706217791L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    @Column(name = "purchase_instant")
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "purchase")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;

    @OneToMany(mappedBy = "id.purchase")
    private final Set<PurchaseItem> items = new HashSet<>();

    public Purchase() {
    }

    public Purchase(Integer id, Date instant, Client client, Address shippingAddress) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        this.shippingAddress = shippingAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstant() {
        return instant;
    }

    public void setInstant(Date instant) {
        this.instant = instant;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Set<PurchaseItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id.equals(purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
