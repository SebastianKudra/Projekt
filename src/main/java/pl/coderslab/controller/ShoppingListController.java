package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.ShoppingList;
import pl.coderslab.repositories.ShoppingListRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shoppinglists")
public class ShoppingListController {
    @Autowired
    private ShoppingListRepository shoppingListRepository;


    @GetMapping("/add")
    public String addShoppingList(Model model) {
        model.addAttribute("shoppingList", new ShoppingList());
        return "shopping-list/create";
    }

    @PostMapping("/add")
    public String addShoppingListForm(@Valid ShoppingList shoppingList, BindingResult result) {
        if (result.hasErrors()) {
            return "/shopping-list/create";
        }
        shoppingListRepository.save(shoppingList);
        return "redirect:/shoppinglists/add";
    }

    @GetMapping("/list")
    public String listShoppingLists(Model model) {
        List<ShoppingList> shoppingLists = shoppingListRepository.findAll();
        model.addAttribute("shoppingLists", shoppingLists);
        return "shopping-list/list";
    }

    @GetMapping("/editlist/{id}")
    public String editShoppingList(@PathVariable Long id, Model model) {
        Optional<ShoppingList> shoppingList = shoppingListRepository.findById(id);
        model.addAttribute("editShoppingList", shoppingList);
        return "shopping-list/edit";
    }


    @PostMapping("/editlist/{id}")
    public String editShoppingListForm(@Valid ShoppingList shoppingList, BindingResult result) {
        if (result.hasErrors()) {
            return "shopping-list/edit";
        }
        shoppingListRepository.save(shoppingList);
        return "redirect:/shoppinglists/list";
    }

    @GetMapping("/remove/{id}/confirmed")
    String removeShoppingList(@PathVariable Long id) {
        shoppingListRepository.deleteById(id);
        return "redirect:/shoppinglists/list";
    }

    @GetMapping("/remove/{id}")
    public String removeShoppingListNotConfirmed(@PathVariable Long id, Model model) {
        model.addAttribute("removeShoppingListId", id);

        return "shopping-list/remove-list";
    }
}