package lu.lv.finalwork;

import lu.lv.finalwork.model.Product;
import lu.lv.finalwork.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductRepositoryTest {

    private Map<Long, Product> repoMock;
    private ProductRepository victim;

    @Before
    public void setUp() throws Exception {
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);
    }

    @Test
    public void shouldFindAllProducts() {
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);

        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        List<Product> result = victim.findAll();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(orange));
        assertTrue(result.contains(fish)          );
    }
}