package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Dao.QuantityDao;

import pl.coderslab.Entity.Quantity;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/quantity")


public class QuantityController {
    QuantityDao quantityDao;

    public QuantityController(QuantityDao quantityDao) {
        this.quantityDao = quantityDao;
    }

    @GetMapping("/add")
    public String addQuantity(Model model) {
        model.addAttribute("quantity", new Quantity());
        return "quantity/add-quantity-form";
    }
    @PostMapping("/add")
    public String processFormQuantity(@Valid Quantity quantity, BindingResult result) {
        if (result.hasErrors()) {
            return "quantity/add-quantity-form";
        }
        quantityDao.saveQuantity(quantity);
        return "redirect:/quantity/add";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<Quantity> quantityList = quantityDao.findAllQuantity();
        model.addAttribute("quantityList", quantityList);
        return "/quantity/list-quantity";
    }
    @GetMapping("/updateQuantity/{id}")
    public String updateQuantity(@PathVariable Integer id, Model model) {
        Quantity updateQuantity = quantityDao.findByIdQuantity(id);
        model.addAttribute("updateQuantity", updateQuantity);
        return "quantity/update-quantity";
    }
    @PostMapping("/updateQuantity/{id}")
    public String updateQuantity(@Valid Quantity quantity, BindingResult result) {
        if (result.hasErrors()) {
            return "quantity/update-quantity";
        }
        quantityDao.updateQuantity(quantity);
        return "redirect:/quantity/list";
    }

    @GetMapping("/removeQuantity/{id}/confirmed")
    String removeQuantity(@PathVariable Integer id) {
        quantityDao.removeQuantity(quantityDao.findByIdQuantity(id));
        return "redirect:/quantity/list";
    }
    @GetMapping("/removeQuantity/{id}")
    public String removeQuantityNotConfirmed(@PathVariable Integer id, Model model) {
        model.addAttribute("quantityId", id);
        return "quantity/remove-quantity";
    }

}
