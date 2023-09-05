package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.ShoppingList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ShoppingListDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void  saveListProducts (ShoppingList shoppingList) {
        entityManager.persist(shoppingList);
    }
    public void updateListProducts (ShoppingList shoppingList) {
        entityManager.merge(shoppingList);
    }
    public void deleteListProducts (ShoppingList shoppingList) {
        entityManager.remove(entityManager.contains(shoppingList) ? shoppingList : entityManager.merge(shoppingList));
    }
}
