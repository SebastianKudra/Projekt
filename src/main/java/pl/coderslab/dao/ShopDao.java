package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Shop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class ShopDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void saveShop(Shop shop) {entityManager.persist(shop);
    }
    public String updateShop(Shop shop) {
        entityManager.merge(shop);
        return "update date";
    }
    public Shop findByIdShop(Integer id) {return entityManager.find(Shop.class, id);}
    public void removeShop(Shop shop) {
        entityManager.remove(entityManager.contains(shop) ? shop:entityManager.merge(shop));
    }

    public List<Shop> findAllShop() {
        return entityManager
                .createQuery("select s from Shop s")
                .getResultList();
    }
}


