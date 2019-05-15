package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class Product implements Serializable {
    @Id
    @GeneratedValue()
    protected Integer id;

    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private String imageUrl;

    @ManyToOne
    private ProductCategory productCategory;
    @ManyToOne
    private Supplier supplier;
    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

}
