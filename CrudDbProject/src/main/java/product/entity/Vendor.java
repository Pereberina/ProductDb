package product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stasia on 23.11.16.
 */
@Entity
@Table(name = "vendor", schema = "Products")
@NamedQueries({
        @NamedQuery(name = "VendorEntity.findAll", query = "select v from Vendor v"),
        @NamedQuery(name = "VendorEntity.findById",
                query = "select distinct v from Vendor v where v.vendorId = :id")
})
public class Vendor {
    private Integer vendorId;
    private String country;
    private String name;
    private String officialUrl;
    private Set<Product> products =
            new HashSet<Product>(0);

    public Vendor() {
    }

    public Vendor(String country, String name, String officialUrl) {
        this.country = country;
        this.name = name;
        this.officialUrl = officialUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id", nullable = false)
    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 100)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "official_url", nullable = false, length = 100)
    public String getOfficialUrl() {
        return officialUrl;
    }

    public void setOfficialUrl(String officialUrl) {
        this.officialUrl = officialUrl;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vendor")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Vendor id=" + vendorId + ": " + name +
                " (" + country + ") " + officialUrl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vendor that = (Vendor) o;

        if (vendorId != null ? !vendorId.equals(that.vendorId) : that.vendorId != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return officialUrl != null ? officialUrl.equals(that.officialUrl) : that.officialUrl == null;

    }


}
