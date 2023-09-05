package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ProductDao;
import pl.coderslab.dao.QuantityDao;
import pl.coderslab.dao.ShopDao;
import pl.coderslab.dao.ShoppingListDao;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.ShoppingList;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/shoppingList")
public class ListController {
    ProductDao productDao;
    ShopDao shopDao;
    QuantityDao quantityDao;
    ShoppingListDao shoppingListDao;

    public ListController(ProductDao productDao, ShopDao shopDao, QuantityDao quantityDao, ShoppingListDao shoppingListDao) {
        this.productDao = productDao;
        this.shopDao = shopDao;
        this.quantityDao = quantityDao;
        this.shoppingListDao = shoppingListDao;
    }
    @GetMapping("/all")
    public String allProducts(Model model) {
        List<Product> allProducts=productDao.findAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "list/list-form";
    }
    @PostMapping("/selectAll")
    public String processAllProducts(@Valid ShoppingList shoppingList, BindingResult result) {
        if(result.hasErrors()) {
            return "list/list-form";
        }
        shoppingListDao.saveListProducts(shoppingList);
        return "redirect:/shoppingList/all";
    }


}
