package ro.msg.learning.shop.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.models.ProductDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public ProductDTO productToProductDTO(Product product){
        return ProductDTO.builder().name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .category_name(product.getProductCategory() != null ? product.getProductCategory().getName() : null)
                .category_description(product.getProductCategory() != null ? product.getProductCategory().getDescription() : null)
                .build();
    }

    public List<ProductDTO> productListtoProductDTOList(List<Product> products){
        ArrayList<ProductDTO> productDTOList = new ArrayList<>();
        for(Product p: products){
            productDTOList.add(productToProductDTO(p));
        }
        return productDTOList;
    }
}
