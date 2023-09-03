package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Dao.ProductDao;
import pl.coderslab.Dao.QuantityDao;
import pl.coderslab.Dao.ShopDao;
import pl.coderslab.Entity.Quantity;

@Controller
@RequestMapping("/shoppinglist")
public class ShoppingListController {
    ProductDao productDao;
    ShopDao shopDao;
    QuantityDao quantityDao;

    public ShoppingListController(ProductDao productDao, ShopDao shopDao, QuantityDao quantityDao) {
        this.productDao = productDao;
        this.shopDao = shopDao;
        this.quantityDao = quantityDao;
    }


}
