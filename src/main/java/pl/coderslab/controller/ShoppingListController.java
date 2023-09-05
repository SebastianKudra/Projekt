package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ProductDao;
import pl.coderslab.dao.QuantityDao;
import pl.coderslab.dao.ShopDao;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.Quantity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/shoppinglist")
public class ShoppingListController {
    @PersistenceContext
    private EntityManager entityManager;
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
        List<Product> productList = productDao.findAllProducts();
        List<Quantity> quantityList = quantityDao.findAllQuantity();
        List<Quantity> BaseOfMeasures=entityManager.createQuery("select distinct baseOfMeasures from Quantity ")
                        .getResultList();
        model.addAttribute("productList", productList);
        model.addAttribute("quantityList", quantityList);
        model.addAttribute("uniqueBaseOfMeasures",BaseOfMeasures);
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
    public List<Quantity> getQuantity() {
        return quantityDao.findAllQuantity();
    }



}
