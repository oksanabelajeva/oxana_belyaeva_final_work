package lu.lv.finalwork.service;

import lu.lv.finalwork.domain.Product;
import lu.lv.finalwork.domain.ProductCategory;
import lu.lv.finalwork.model.ProductData;
import lu.lv.finalwork.model.ProductInputData;
import lu.lv.finalwork.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final Repository<Product> repository;

    @Autowired
    public ProductService(Repository<Product> productOrmRepository) {
        this.repository = productOrmRepository;
    }

    public void save(ProductInputData productInputData) {
        repository.save(convertFrom(productInputData));
    }

    public List<ProductData> findAll() {
        List<ProductData> result = new ArrayList<>();
        for (Product product : repository.findAll()) {
            final ProductData productData = convertFrom(product);
            result.add(productData);
        }
        return result;
    }

    private ProductData convertFrom(Product product) {
        return new ProductData(
                product.getId().toString(),
                product.getName(),
                product.getPrice().toPlainString());
    }

    private Product convertFrom(ProductInputData productInputData) {
        Product product = new Product();
        product.setName(productInputData.getName());
        product.setPrice(BigDecimal.valueOf(productInputData.getPrice()));
        product.setCategory(ProductCategory.valueOf(productInputData.getCategory()));
        if (productInputData.getDiscount() != null) {
            product.setDiscount(BigDecimal.valueOf(productInputData.getDiscount()));
        }
        if (productInputData.getDescription() != null) {
            product.setDescription(productInputData.getDescription());
        }
        return product;
    }
}
