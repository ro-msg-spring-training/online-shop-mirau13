package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.mappers.ProductMapper;
import ro.msg.learning.shop.models.ProductDTO;
import ro.msg.learning.shop.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final ProductMapper productMapper;

    public ProductDTO getProductById(Integer id) {
        Optional<Product> productOptional = productRepo.findById(id);

        if (productOptional.isPresent()){
            Product product = productOptional.get();
            return productMapper.productToProductDTO(product);
        }

        return null;
    }

    public void createProduct(Product product) {
        productRepo.save(product);
    }

    public void updateProduct(Product product) {
        productRepo.delete(product);
        productRepo.save(product);
    }

    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }

    public List<ProductDTO> getAllProducts() {
        return productMapper.productListtoProductDTOList(productRepo.findAll());
    }
}
