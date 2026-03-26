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

    @GetMapping
    public String getAllUsers(Model model) {
        // TODO: Hent alle brugere og send til view – return "user/login"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        // TODO: Hent bruger og send til view – return "user/login"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        // TODO: Vis formular til oprettelse af bruger – return "user/register"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        // TODO: Opret bruger og redirect til brugerliste – return "redirect:/users"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/{id}/history")
    public String getOrderHistory(@PathVariable int id, Model model) {
        // TODO: Hent ordrehistorik for bruger og send til view – return "order/order-history"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, Model model) {
        User user = userService.getUserByEmail(email);
        model.addAttribute("besked", "Velkommen " + user.getName() + "!");
        return "success";
    }
}