package ces.augusto108.uml_casestudy.domain.entities;

import ces.augusto108.uml_casestudy.domain.enums.PaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = -6531120093278966078L;

    @Id
    private Integer id;

    @Column(name = "payment_status")
    private PaymentStatus status;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    @MapsId
    private Purchase purchase;

    public Payment() {
    }

    public Payment(Integer id, PaymentStatus status, Purchase purchase) {
        this.id = id;
        this.status = status;
        this.purchase = purchase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Purchase getProductOrder() {
        return purchase;
    }

    public void setProductOrder(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
