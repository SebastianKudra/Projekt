package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.ShoppingList;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
