package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Quantity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class QuantityDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveQuantity(Quantity quantity) {
        entityManager.persist(quantity);
    }

    public String updateQuantity(Quantity quantity) {
        entityManager.merge(quantity);
        return "update";
    }

    public Quantity findByIdQuantity(Integer id) {
        return entityManager.find(Quantity.class, id);
    }
    public void removeQuantity(Quantity quantity) {
        entityManager.remove(entityManager.contains(quantity) ? quantity :entityManager.merge(quantity));
    }
    public List<Quantity> findAllQuantity() {
        return entityManager
                .createQuery("select c from Quantity c")
                .getResultList();
    }
}
