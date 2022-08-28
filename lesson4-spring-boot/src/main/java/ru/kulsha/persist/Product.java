package ru.kulsha.persist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
public class Product {

    private Long id;

    @NotBlank(message = "can`t be empty")
    private String productName;

    @NotBlank
    private int cost;

    @Pattern(regexp = "^(?=.*?[0-9])(?=.*?[A-Z]).{8,}$", message = "Password is very simple")
    private String password;

    private String matchingPassword;



    public Product(String productName) {
        this.productName = productName;
    }

}
