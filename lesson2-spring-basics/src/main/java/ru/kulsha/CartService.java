package ru.kulsha;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.kulsha.persist.Product;
import ru.kulsha.persist.ProductRepository;

import java.util.List;

@Service
@Scope("prototype")
@RequiredArgsConstructor
public class CartService {

    private final Cart cart;
    private final ProductRepository productRepository;

    public void addProductToCart(Long id){
        Product product = productRepository.findById(id);
        cart.add(product);
    }

    public void removeProductFromCart(Long id){
        Product product = productRepository.findById(id);
        cart.remove(product);
    }

    public List<Product> getCartProducts(){
        return cart.getAllProduct();
    }





}
