package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Product;
import pl.coderslab.repositories.ProductRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ItemController {
    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/add")
    String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/add")
    public String addProductForm(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "/product/create";
        }
        productRepository.save(product);
        return "redirect:/product/add";
    }


    @GetMapping("/list")
    public String listProduct(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "/product/list-product";
    }

    @GetMapping("/updateProduct/{id}")
    public String viewProductId(@PathVariable Long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        model.addAttribute("updateProduct", product);
        return "/product/edit";
    }

    @PostMapping("/updateProduct/{id}")
    public String viewProductIdForm(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/edit";
        }
        productRepository.save(product);
        return "redirect:/product/list";
    }
    @GetMapping("/remove/{id}/confirmed")
        String removeItem(@PathVariable Long id){
        productRepository.deleteById(id);
        return "redirect:/product/list";
    }


    @GetMapping("/remove/{id}")
    public String removeItemNotConfirmed (@PathVariable Long id, Model model) {
        model.addAttribute("productId", id);

        return "product/remove-product";
    }



}


