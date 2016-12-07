package product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Stasia on 23.11.16.
 */

@Entity
@Table(name = "product", schema = "Products")
@NamedQueries({
        @NamedQuery(name = "ProductEntity.findAll", query = "select p from Product p"),
        @NamedQuery(name = "ProductEntity.findById",
                query = "select distinct p from Product p where p.productId = :id")
})
public class Product {
    private Integer productId;
    private String model;
    private Integer cost;
    private Vendor vendor;
    private Info info;

    public Product() {
    }

    public Product(String model, Integer cost) {
        this.model = model;
        this.cost = cost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "model", nullable = false, length = 100)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "cost", nullable = true)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id", nullable = false)
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    public Info getInfo() {
        return this.info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        String vendorName = null;
        Integer quantity = 0;
        if (vendor != null) {
            vendorName = vendor.getName();
        }
        if (info != null) {
            quantity = info.getQuantity();
        }
        return "ProductEntity{" +
                "id=" + productId +
                ", '" + model + '\'' +
                " (" + vendorName + "), cost is $" + cost +
                ", quantity " + quantity +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        if (!productId.equals(that.productId)) return false;
        if (!model.equals(that.model)) return false;
        if (!cost.equals(that.cost)) return false;
        if (vendor != null ? !vendor.equals(that.vendor) : that.vendor != null) return false;
        return info != null ? info.equals(that.info) : that.info == null;
    }
}
