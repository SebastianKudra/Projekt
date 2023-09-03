package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Dao.ProductDao;
import pl.coderslab.Dao.QuantityDao;
import pl.coderslab.Dao.ShopDao;
import pl.coderslab.Entity.Product;
import pl.coderslab.Entity.Quantity;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/build")
    public String buildList(Model model) {
        model.addAttribute("productList", productDao.findAllProducts());
        return "list/build-list-form";
    }
    @PostMapping("/build")
    public String processBuildList(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "list/build-list-form";
        }
        productDao.saveProducts(product);
        return "redirect:/shoppinglist/build";
    }

@ModelAttribute("amount")
    public List<Quantity> getQuantity() {return quantityDao.findAllQuantity();}
}
