package dk.zealand.hw_pizzaparadise.presentation;

import dk.zealand.hw_pizzaparadise.application.service.UserService;
import dk.zealand.hw_pizzaparadise.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        return "redirect:/orders/place/" + user.getId();
    }
}