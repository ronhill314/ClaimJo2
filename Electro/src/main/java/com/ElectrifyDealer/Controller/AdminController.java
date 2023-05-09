package com.ElectrifyDealer.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ElectrifyDealer.Entity.Sparks;
import com.ElectrifyDealer.Entity.User;
import com.ElectrifyDealer.Service.SparksService;
import com.ElectrifyDealer.Service.UserService;

@Controller
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    SparksService sparksService;

    @GetMapping("/admin-tool")
    public String adminToolHome(Model model, HttpSession session) {

        String email = (String) session.getAttribute("emailCookie");
        if (email != null) {

            User loggedInUser = userService.findUserByEmail(email);
            model.addAttribute("user", loggedInUser);
            if (loggedInUser.getIsAdmin() != true) {
                return "redirect:";
            }
            return "adminTools";
        }
        return "redirect:";

    }

    @GetMapping("/adminSparks")
    public String adminSparks(Model model, HttpSession session) {

        String email = (String) session.getAttribute("emailCookie");
        if (email != null) {

            User loggedInUser = userService.findUserByEmail(email);
            model.addAttribute("user", loggedInUser);
            if (loggedInUser.getIsAdmin() != true) {
                return "redirect:";
            }
            // Model attribute for my form
            model.addAttribute("sparks", new Sparks());
            // Get the list of sparkss from the DB
            List<Sparks> allSparkss = sparksService.findAll();
            model.addAttribute("", allSparkss);
            return "adminSparks";
        }
        return "redirect:";
    }

    @PostMapping("/adminSparks")
    public String adminSparkss(@ModelAttribute Sparks sparks) {

        sparksService.save(sparks);

        return "redirect:adminSparks";

    }

}
