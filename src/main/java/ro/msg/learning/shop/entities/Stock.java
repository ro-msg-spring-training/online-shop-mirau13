package ro.msg.learning.shop.entities;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class Stock implements Serializable {
    @Id
    @GeneratedValue()
    protected Integer id;

    private Integer quantity;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Location location;
}
