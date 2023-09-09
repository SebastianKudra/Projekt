package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.ShoppingListItem;
import pl.coderslab.repositories.ProductRepository;
import pl.coderslab.repositories.ShoppingListItemRepository;
import pl.coderslab.repositories.ShoppingListRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/listitem")

public class ShoppingListItemController {
    @Autowired
    private ShoppingListItemRepository shoppingListItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @GetMapping("/add")
    public String addShoppingListItem(Model model) {
        model.addAttribute("shoppingListItem", new ShoppingListItem());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("shoppingLists", shoppingListRepository.findAll());
        return "shopping-list-item/create";
    }

    @PostMapping("/add")
    public String addShoppingListItem(@Valid ShoppingListItem shoppingListItem, BindingResult result) {
        if (result.hasErrors()) {
            return "shopping-list-item/create";
        }
        shoppingListItemRepository.save(shoppingListItem);
        return "redirect:/listitem/add";
    }

    @GetMapping("/list")
    public String listShoppingItem(Model model) {
        List<ShoppingListItem> shoppingListItems = shoppingListItemRepository.findAll();
        model.addAttribute("shoppingListItems", shoppingListItems);
        return "shopping-list-item/list";
    }
    @GetMapping("/sortLidl")
    public String sortListLidl(Model model) {
        List<ShoppingListItem> shoppingListItemsLidl = shoppingListItemRepository.sortedByLidlZone();
        model.addAttribute("listLidl", shoppingListItemsLidl);
        return "shopping-list-item/list-lidl";
    }
    @GetMapping("/sortBiedronka")
    public String sortListBiedronka(Model model) {
        List<ShoppingListItem> shoppingListItemsBiedronka = shoppingListItemRepository.sortedByBiedronkaZone();
        model.addAttribute("listBiedronka", shoppingListItemsBiedronka);
        return "shopping-list-item/list-biedronka";
    }
    @GetMapping("/sortDino")
    public String sortListDino(Model model) {
        List<ShoppingListItem> shoppingListItemsDino = shoppingListItemRepository.sortedByDinoZone();
        model.addAttribute("listDino", shoppingListItemsDino);
        return "shopping-list-item/list-dino";
    }


    @GetMapping("/update/{id}")
    public String viewShoppingListItem(@PathVariable Long id, Model model) {
        Optional<ShoppingListItem> shoppingListItem = shoppingListItemRepository.findById(id);
        model.addAttribute("updateShoppingListItem", shoppingListItem.orElse(null));
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("shoppingLists", shoppingListRepository.findAll());
        return "shopping-list-item/edit";
    }

    @PostMapping("/update/{id}")
    public String viewShoppingListItemForm(@PathVariable Long id, @Valid ShoppingListItem shoppingListItem, BindingResult result) {
        if (result.hasErrors()) {
            return "shopping-list-item/edit";
        }
        shoppingListItemRepository.save(shoppingListItem);
        return "redirect:/listitem/list";
    }

    @GetMapping("/remove/{id}/confirmed")
    String removeShoppingListItem(@PathVariable Long id) {
        shoppingListItemRepository.deleteById(id);
        return "redirect:/listitem/list";
    }

    @GetMapping("/remove/{id}")
    public String removeShoppingListItemNotConfirmed(@PathVariable Long id, Model model) {
        model.addAttribute("shoppingListItemId", id);
        return "shopping-list-item/remove";
    }
}
