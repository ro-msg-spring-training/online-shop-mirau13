package ro.msg.learning.shop.entities;


import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class ProductCategory  implements Serializable {
    @Id
    @GeneratedValue()
    protected Integer id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;
}
