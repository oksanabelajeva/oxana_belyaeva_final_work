package lu.lv.finalwork;

import lu.lv.finalwork.model.Product;
import lu.lv.finalwork.repository.ProductRepository;
import lu.lv.finalwork.service.ProductService;
import lu.lv.finalwork.ui.ConsulUi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Map<Long, Product> repository = new HashMap<>();
        ProductRepository productRepository = new ProductRepository(repository);
        ProductService productService = new ProductService(productRepository);
        Scanner scanner = new Scanner(System.in);

        new ConsulUi(productService, scanner).run();
    }
}
