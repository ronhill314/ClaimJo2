package com.OnePercenterTravel.Controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.OnePercenterTravel.Entity.Reservation;
import com.OnePercenterTravel.Entity.User;
import com.OnePercenterTravel.Service.UserService;


// The controller is the Liason between the JSP and the Services
// When the user makes input on browser, it will correspond to
// one of the functions in the controller first
// Then the controller will use services to get whatever data needed
// for the page, and return the correct JSP
@Controller
public class UserController {
    
    @Autowired
    UserService userService;

    // get mappings are when you are going straight to a url
    // no form submission at all
    //REST - GET, PUT, POST, DELETE
    @GetMapping("/")
    // this function will run whenever someone goes to the / url (http://localhost:8080/)
    public String index(HttpSession session, Model model) {

        String email = (String) session.getAttribute("emailCookies");
        if(email != null){

           User loggedInUser = userService.findUserByEmail(email);

           model.addAttribute("user", loggedInUser);

        }

           return "home";
    }
    @GetMapping("/sign-up")
    // Whenever you are putting data on a page 
    //(like adding an object to the jsp to show or update data)
    //you need a model
    public String signUp(Model model) {

        // we must set a model attribute on the page, so our form can habe a 
        //blank object to cnstruct with the form data
        model.addAttribute("user", new User());

        return "signUp";
    }

    // whenever you are submitting data, you need a postmapping
    //this will grab the modelAttribute you submitted so you
    // can now do whatever you nee to do with it.
    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute("user") User user, Model model, HttpSession session){

        User loggedInUser = userService.signUp(user);

        session.setAttribute("emailCookies", loggedInUser.getEmail());

        model.addAttribute("user", loggedInUser);

        return "home";

    }

    @GetMapping("/sign-in")
    public String signIn(Model model) {

        model.addAttribute("user", new User());

        return "signIn";

    }

    @PostMapping("/sign-in")                                //httpsession is for storing cookies
    public String signIn(@ModelAttribute("user") User user, Model model, HttpSession session) {

        try {
        User loggedInUser = userService.signIn(user);

        // after i have succesfully validated ad signed in 
        // i store the users email on a cookie for future use to reverify
        session.setAttribute("emailCookies", loggedInUser.getEmail());

        if(loggedInUser.getIsAdmin() == true) {
            return "redirect:admin-tool";
        }

            return "redicrect:";

    } catch(Exception e) {

        return "signIn";
    }  

    }

    // Logging out is simply stopping the user form accesssing there data until
    // they login gain. remove the cookie, and redirect them
    @GetMapping(value="/logout")
    public String logOut(HttpSession session) {
        
        session.removeAttribute("emailCookie");

        return "redirect";

    }

    @GetMapping("/create-reservation")
    public String createReservation(Model model) {

        model.addAttribute("reservation", new Reservation());

        return "reservation";
    }
        
}
