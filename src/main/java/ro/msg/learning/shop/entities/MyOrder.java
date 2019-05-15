package ro.msg.learning.shop.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class MyOrder implements Serializable {
    @Id
    @GeneratedValue()
    protected Integer id;

    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreet;
    private LocalDateTime createdAt;

    @ManyToOne
    private Location shippedFrom;
    @ManyToOne
    private Customer customer;
    @ManyToMany
    @JoinTable(name = "order_revenue",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "revenue_id"))
    private List<Revenue> revenues;
    @OneToMany(mappedBy = "myOrder")
    private List<OrderDetail> orderDetails;

}
