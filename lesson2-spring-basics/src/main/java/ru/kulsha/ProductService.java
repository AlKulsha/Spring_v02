package ru.kulsha;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kulsha.persist.Product;
import ru.kulsha.persist.ProductRepository;
import ru.kulsha.persist.ProductRepositoryImpl;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct method has been done");
    }

//    public void insert(Product product){
//        this.productRepository.insert(product);
//    }

    public int findAll(){
        return this.productRepository.findAll().size();
    }
}
