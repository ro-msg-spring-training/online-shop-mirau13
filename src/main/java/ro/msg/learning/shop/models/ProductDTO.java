package ro.msg.learning.shop.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;

    private String category_name;
    private String category_description;
}
