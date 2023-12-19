package peter.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peter.student.model.Signup;
import peter.student.services.EventService;
import peter.student.services.SignupInterface;
import peter.student.services.TicketService;

@Controller
public class SignupController {
    @Autowired
    SignupInterface signupInterface;


    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/event")
    public String homePage(Model model){
        model.addAttribute("event", signupInterface.getAllEvent());
        return "customer_view";
    }


    @GetMapping("/login")
    public String homepage(Model model){
        Signup signup=new Signup();
        model.addAttribute("login",signup);
       return "login";
    }

    @GetMapping("/Signup")
    public String registration(Model model){
        Signup signup=new Signup();
        model.addAttribute("theSignup",signup);
        return "Signup";
    }
@PostMapping("/registerAccount")
    public String saveAccount(@ModelAttribute("signup") Signup theSignup){
    Signup signup = signupInterface.saveAccount(theSignup);
    if (signup != null) {
        return "redirect:/login";

    } else {
        return "Signup";
    }
}

    @PostMapping("/authentication")
    public String userAuthentication(@RequestParam String email,@RequestParam String password){
//       boolean result=signupInterface.userCheck(email,password);
        Signup signup=signupInterface.findAccount(email);
        if (signup.getEmail()!=null && signup.getPassword()!=null){
            if(signup.getEmail().contains("admin") && signup.getPassword().contains("123")){
                return "redirect:/admin";
            }else {
                return "redirect:/event";
            }

        }else {
            return "redirect:/login";
        }

    }
}
