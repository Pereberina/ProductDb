package product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Stasia on 23.11.16.
 */
@Entity
@Table(name = "info", schema = "Products")
@NamedQueries({
        @NamedQuery(name = "InfoEntity.findAll", query = "select i from Info i"),
        @NamedQuery(name = "InfoEntity.findById",
                query = "select distinct i from Info i where i.infoId = :id")
})
public class Info {
    private Integer infoId;
    private Integer quantity;
    private String line;
    private Integer cores;
    private Product product;

    public Info() {
    }

    public Info(Integer quantity, String line, Integer cores) {
        this.quantity = quantity;
        this.line = line;
        this.cores = cores;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id", unique = true, nullable = false)
    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "line", nullable = true, length = 100)
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Basic
    @Column(name = "cores", nullable = true)
    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "info", cascade = CascadeType.ALL)
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        String model = null;
        if (product != null) {
            model = product.getModel();
        }

        return "InfoEntity{" +
                "id=" + infoId +
                ", product: " + model +
                ", line: " + line + ", quantity: " + quantity +
                ", cores: " + cores + "}";
    }
}
