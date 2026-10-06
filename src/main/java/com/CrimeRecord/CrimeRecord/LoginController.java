package com.CrimeRecord.CrimeRecord;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginPage() {
        return "index";
    }


    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        String correctUsername = "admin";
        String correctPassword = "admin123";


        if (correctUsername.equals(username)
                && correctPassword.equals(password)) {

            session.setAttribute("loggedIn", true);
            session.setAttribute("username", username);

            return "redirect:/dashboard";
        }


        model.addAttribute(
                "error",
                "Invalid username or password");

        return "index";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }

}