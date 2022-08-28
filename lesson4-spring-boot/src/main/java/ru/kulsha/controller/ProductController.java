package ru.kulsha.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kulsha.persist.Product;
import ru.kulsha.persist.ProductRepository;

import javax.validation.Valid;


@Slf4j   //библиотека для логирования
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }

    @GetMapping("/new")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product(""));
        System.out.println("Product was added");
        return "product_form";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductById(@PathVariable long id) {
        productRepository.delete(id);
        return "redirect:/product";
    }

    @PostMapping
    public String saveProduct(@RequestBody @Valid Product product, BindingResult bindingResult) { //valid  для работы с NotBlank
        if(bindingResult.hasErrors()){
            return "product_form";
        }
        if(!product.getPassword().equals(product.getMatchingPassword())){
            return "product_form";
        }
       log.info("saveProduct method was accomlished");
        productRepository.save(product);
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        productRepository.save(product);
        return "redirect:/product";
    }

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String notFoundExceptionHandler(Model model, EntityNotFoundException e) {
//        model.addAttribute("message", e.getMessage());
//        return "not_found";
//    }
//

}


