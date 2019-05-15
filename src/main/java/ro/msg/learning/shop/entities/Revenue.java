package ro.msg.learning.shop.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Revenue implements Serializable {
    @Id
    @GeneratedValue()
    protected Integer id;

    private LocalDate date;
    private BigDecimal sum;

    @ManyToOne
    private Location location;
    @ManyToMany
    @JoinTable(name = "order_revenue",
            joinColumns = @JoinColumn(name = "revenue_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<MyOrder> myOrders;
}
