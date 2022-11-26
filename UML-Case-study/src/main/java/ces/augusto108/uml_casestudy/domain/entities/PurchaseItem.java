package ces.augusto108.uml_casestudy.domain.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class PurchaseItem implements Serializable {
    private static final long serialVersionUID = -8443956323323554493L;

    @EmbeddedId
    private final PurchaseItemPrimaryKey id = new PurchaseItemPrimaryKey();

    private Double discount;
    private Integer amount;
    private Double price;

    public PurchaseItem() {
    }

    public PurchaseItem(Purchase purchase, Product product, Double discount, Integer amount, Double price) {
        id.setPurchase(purchase);
        id.setProduct(product);
        this.discount = discount;
        this.amount = amount;
        this.price = price;
    }

    public Purchase getPurchase() {
        return id.getPurchase();
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public PurchaseItemPrimaryKey getId() {
        return id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItem that = (PurchaseItem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
