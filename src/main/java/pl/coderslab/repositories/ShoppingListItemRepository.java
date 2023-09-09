package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.ShoppingListItem;

import java.util.List;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long> {
    @Query("select  l from ShoppingListItem l join fetch l.product p order by p.zoneProductLidl asc ")
    List<ShoppingListItem> sortedByLidlZone();

    @Query("select  b from ShoppingListItem b join fetch b.product p order by p.zoneProductBiedronka asc ")
    List<ShoppingListItem> sortedByBiedronkaZone();

    @Query("select  d from ShoppingListItem d join fetch d.product p order by p.zoneProductDino asc ")
    List<ShoppingListItem> sortedByDinoZone();


}
