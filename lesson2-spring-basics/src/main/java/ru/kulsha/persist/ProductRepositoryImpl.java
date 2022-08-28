package ru.kulsha.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        addProduct(1L, new Product(1L,"tv", 300000));
        addProduct(2L, new Product(2L,"microwave oven", 20000));
        addProduct(3L, new Product(3L,"fridge", 150000));
        addProduct(4L, new Product(4L,"ipod", 30000));
        addProduct(5L, new Product(5L,"e-book", 20000));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void addProduct(Long id, Product product) {
        productMap.put(id, product);
    }


    public Product findById(long id) {
        return productMap.get(id);
    }

    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    public void delete(Long id) {
        productMap.remove(id);
    }

    @Override
    public long getCount() {
        return productMap.size();
    }
}
