package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Dao.ShopDao;

import pl.coderslab.Entity.Shop;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/shops")

public class ShopController {
    ShopDao shopDao;

    public ShopController(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @GetMapping("/add")
    public String addShop(Model model) {
        model.addAttribute("shops", new Shop());
        return "shops/add-shops-form";
    }

    @PostMapping("/add")
    public String processFormShop(@Valid Shop shop, BindingResult result) {
        if (result.hasErrors()) {
            return "shops/add-shops-form";
        }
        shopDao.saveShop(shop);
        return "redirect:/shops/add";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Shop> shopList = shopDao.findAllShop();
        model.addAttribute("shopList", shopList);
        return "/shops/list-shops";
    }

    @GetMapping("/updateShop/{id}")
    public String updateShop(@PathVariable Integer id, Model model) {
        Shop updateShop = shopDao.findByIdShop(id);
        model.addAttribute("updateShop", updateShop);
        return "shops/update-shops";
    }

    @PostMapping("/updateShop/{id}")
    public String updateShop(@Valid Shop shop, BindingResult result) {
        if (result.hasErrors()) {
            return "shops/update-shops;";
        }
        shopDao.updateShop(shop);
        return "redirect:/shops/list";
    }

    @GetMapping("/removeShop/{id}/confirmed")
    String removeShop(@PathVariable Integer id) {
        shopDao.removeShop(shopDao.findByIdShop(id));
        return "redirect:/shops/list";
    }

    @GetMapping("/removeShop/{id}")
    public String removeShopNotConfirmed(@PathVariable Integer id, Model model) {
        model.addAttribute("shopId", id);
        return "shops/remove-shops";
    }

}
