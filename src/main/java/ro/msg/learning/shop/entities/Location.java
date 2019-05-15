package ro.msg.learning.shop.entities;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class Location implements Serializable {
    @Id
    @GeneratedValue()
    protected Integer id;

    private String name;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreet;

    @OneToMany(mappedBy = "shippedFrom")
    private List<MyOrder> myOrders;
    @OneToMany(mappedBy = "location")
    private List<Revenue> revenues;

}
