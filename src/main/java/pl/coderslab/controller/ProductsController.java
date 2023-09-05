package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ProductDao;
import pl.coderslab.entity.Product;


import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductsController {
    ProductDao productDao;


    public ProductsController(ProductDao productsDao) {
        this.productDao = productsDao;


    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("products", new Product());
        return "products/add-products-form";
    }

    @PostMapping("/add")
    public String processFormProduct(@Valid Product products, BindingResult result) {
        if (result.hasErrors()) {
            return "products/add-products-form";
        }
        productDao.saveProducts(products);
        return "redirect:/products/add";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productsList = productDao.findAllProducts();
        model.addAttribute("productsList", productsList);
        return "/products/list-products";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable Integer id, Model model) {
        Product updateProduct = productDao.findByIdProducts(id);
        model.addAttribute("updateProduct", updateProduct);
        return "products/update-products";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "products/update-products";
        }
        productDao.updateProducts(product);
        return "redirect:/products/list";
    }

    @GetMapping("/removeProduct/{id}/confirmed")
    String removeProduct(@PathVariable Integer id) {
        productDao.removeProducts(productDao.findByIdProducts(id));
        return "redirect:/products/list";
    }

    @GetMapping("/removeProduct/{id}")
    public String removeProductNotConfirmed(@PathVariable Integer id, Model model) {
        model.addAttribute("productId", id);
        return "products/remove-products";
    }


}
