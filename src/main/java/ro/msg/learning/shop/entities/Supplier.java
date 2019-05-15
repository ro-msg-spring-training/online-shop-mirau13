package ro.msg.learning.shop.entities;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class Supplier implements Serializable{
    @Id
    @GeneratedValue()
    protected Integer id;

    private String name;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
}
