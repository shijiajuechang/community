package life.sl.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
//个人中心
public class ProfileController {

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action")String action, Model model){

        if (action.contains("questions")) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的问题");
        }else if (action.contains("replies")){
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "我的回复");
        }
        return "profile";
    }
}

//水 风 火 雷 土 木 兽 死
