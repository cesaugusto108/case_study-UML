package ces.augusto108.uml_casestudy.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.*;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = -7617412185422889741L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_brand")
    private String brand;

    @Column(name = "product_price")
    @Min(0L)
    private Double price;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    public List<Category> categories = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "product_purchase",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "purchase_id")
    )
    public List<Purchase> purchases = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.product")
    private final Set<PurchaseItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Integer id, String name, String brand, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonIgnore
    public List<Purchase> getPurchases() {
        List<Purchase> purchaseList = new ArrayList<>();

        for (PurchaseItem item : items) {
            purchaseList.add(item.getPurchase());
        }

        return purchaseList;
    }

    public Set<PurchaseItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
