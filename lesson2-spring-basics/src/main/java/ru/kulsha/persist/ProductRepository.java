package ru.kulsha.persist;

import org.springframework.stereotype.Repository;
import ru.kulsha.persist.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

     default void addProduct(Long id, Product product){

    }

    Product findById(long id);

    void update(Product product);

    void delete(Long id);

    long getCount();
}
