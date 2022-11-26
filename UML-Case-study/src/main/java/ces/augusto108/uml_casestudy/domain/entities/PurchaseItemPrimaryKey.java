package ces.augusto108.uml_casestudy.domain.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseItemPrimaryKey implements Serializable {
    private static final long serialVersionUID = -7687618744713686683L;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItemPrimaryKey that = (PurchaseItemPrimaryKey) o;
        return purchase.equals(that.purchase) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchase, product);
    }
}
