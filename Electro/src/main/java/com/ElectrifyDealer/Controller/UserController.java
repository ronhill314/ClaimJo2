package com.ElectrifyDealer.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ElectrifyDealer.Entity.User;
import com.ElectrifyDealer.Service.UserService;


@Controller
public class UserController {

@Autowired
UserService userService;
    
@GetMapping("/")
public String index(HttpSession session, Model model) {

    String email = (String) session.getAttribute("emailCookie");
    if(email != null) {

        User loggedInUser = userService.findUserByEmail(email);

        model.addAttribute("user", loggedInUser);

    }
    return "home";
}

@GetMapping("/sign-up")
// Whenever you are putting data on a page
// (like adding an object to the jsp to show or update data)
// You need a Model
public String signUp(Model model) {

    // We must set a model attribute on the page, so our form can have a 
    // blank object to contruct with the form data
    model.addAttribute("user", new User());

    return "signUp";
}

// Whenever you are submitting data, you need a postmapping
// This will grab the modelAttribute you submitted so you
// can now do whatever you need to do with it.
@PostMapping("/sign-up")
public String signUp(@ModelAttribute("user") User user, HttpSession session) {

    User loggedInUser = userService.signUp(user);

    // After i have successfully validated and signed in,
    // i store the users email on a cookie for future use to reverify.
    session.setAttribute("emailCookie", loggedInUser.getEmail());

    return "redirect:";

}

@GetMapping("/sign-in")
public String signIn(Model model) {

    model.addAttribute("user", new User());

    return "signIn";

}

@PostMapping("/sign-in")                     // HttpSession is for storing cookies for login
public String signIn(@ModelAttribute("user") User user, HttpSession session) {

    try {

        User loggedInUser = userService.signIn(user);

        // After i have successfully validated and signed in,
        // i store the users email on a cookie for future use to reverify.
        session.setAttribute("emailCookie", loggedInUser.getEmail());

        if(loggedInUser.getIsAdmin() == true) {
            return "redirect:admin-tool";
        }

        return "redirect:";

    } catch(Exception e) {

        return "signIn";

    }
}

// Logging out is simply stopping the user from accessing there data until
// they login again. Remove the cookie, and REDIRECT them
@GetMapping(value="/logout")
public String logOut(HttpSession session) {

    session.removeAttribute("emailCookie");

    return "redirect:";


}

}
