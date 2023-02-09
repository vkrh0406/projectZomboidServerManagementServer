package projectzomboid.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projectzomboid.demo.utils.ProjectZomboidServerManagement;

@Controller
public class DefaultController {

    @Autowired
    ProjectZomboidServerManagement projectZomboidServerManagement;

    @GetMapping("home")
    public String home(Model model){

        model.addAttribute("serverStatus", projectZomboidServerManagement.getServerStatus());

        return "home";
    }

    @GetMapping("/api/serverRestart")
    public String serverRestart(){

    }






}
