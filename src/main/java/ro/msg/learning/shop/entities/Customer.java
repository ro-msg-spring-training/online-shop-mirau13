package ro.msg.learning.shop.entities;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class Customer implements Serializable {
    @Id
    @GeneratedValue()
    protected Integer id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;

    @OneToMany(mappedBy = "customer")
    private List<MyOrder> myOrders;
}
