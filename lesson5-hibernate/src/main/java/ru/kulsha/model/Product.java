package ru.kulsha.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "findAllProducts", query = "select p from Product p"),
        @NamedQuery(name = "countAllProducts", query = "select count(p) from Product p"),
        @NamedQuery(name = "deleteProductById", query = "delete from Product p where p.id= :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String productName;


    @Column
    private int cost;

    @Column(nullable = false, length = 1024)
    private String password;


    public Product(String productName, int cost, String password) {
        this.productName = productName;
        this.cost = cost;
        this.password = password;
    }

}

