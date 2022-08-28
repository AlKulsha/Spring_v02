package ru.kulsha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.kulsha.Cart;
import ru.kulsha.ProductService;
import ru.kulsha.persist.ProductRepository;
import ru.kulsha.persist.ProductRepositoryImpl;

@Configuration
@ComponentScan("ru.kulsha")
public class AppConfiguration {

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }

    @Bean
    @Scope("prototype")
    public Cart cart(){
        return new Cart();
    }

}
