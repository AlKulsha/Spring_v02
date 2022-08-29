import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.kulsha.model.Product;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(new Product("product5", 1000, "prod1"));
        entityManager.persist(new Product("product6", 2000, "prod2"));
        entityManager.persist(new Product("product7", 3000, "prod3"));

        entityManager.getTransaction().commit();

//        Product product = entityManager.find(Product.class, 1L);
//        System.out.println();
//
//        List<Product> products = entityManager.createQuery("select p from Product p", Product.class)
//                .getResultList();
//
//        for (Product productFromDB : products) {
//            System.out.println(productFromDB);
//
//        }
//
//        entityManager.getTransaction().begin();
//        Product product = entityManager.find(Product.class, 1L);
//        product.setProductName("new productName");

//        Product product = new Product("NewProduct2", 2000, "prod2");
////      product.setId(2L);
////
//        entityManager.createQuery("delete from Product p where p.id=3").executeUpdate();

//        Product product = entityManager.find(Product.class, 1L);
//        entityManager.remove(product);
//
//        entityManager.getTransaction().commit();
//        entityManager.close();


        entityManagerFactory.close();

    }
}
