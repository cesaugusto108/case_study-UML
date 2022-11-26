package ces.augusto108.uml_casestudy.domain.entities;

import ces.augusto108.uml_casestudy.domain.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
public class CreditCardPayment extends Payment {
    private static final long serialVersionUID = -4620790814766914708L;

    private Integer numberOfInstallments;

    public CreditCardPayment() {
    }

    public CreditCardPayment(Integer id, PaymentStatus status, Purchase purchase, Integer numberOfInstallments) {
        super(id, status, purchase);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }
}
