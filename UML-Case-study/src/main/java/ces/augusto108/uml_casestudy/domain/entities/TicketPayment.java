package ces.augusto108.uml_casestudy.domain.entities;

import ces.augusto108.uml_casestudy.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class TicketPayment extends Payment{
    private static final long serialVersionUID = 7129042418317704085L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date paymentDate;

    public TicketPayment() {
    }

    public TicketPayment(Integer id, PaymentStatus status, Purchase purchase, Date dueDate, Date paymentDate) {
        super(id, status, purchase);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
