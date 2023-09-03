package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entity.Product;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveProducts(Product products) {
        entityManager.persist(products);
    }

    public void updateProducts(Product products) {
        entityManager.merge(products);

    }

    public Product findByIdProducts(Integer id) {
        return entityManager.find(Product.class, id);
    }

    public void removeProducts(Product products) {
        entityManager.remove(entityManager.contains(products) ? products : entityManager.merge(products));
    }

    public List<Product> findAllProducts() {
        return entityManager
                .createQuery("select pr from Product pr")
                .getResultList();
    }

}
