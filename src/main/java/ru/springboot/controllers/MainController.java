package ru.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.springboot.model.Article;
import ru.springboot.service.ArticleService;

@Controller
@RequestMapping("/blog")
public class MainController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("articles", articleService.getAll());
        return "main";
    }

    @RequestMapping("/editor")
    public String editorPage(Model model) {
        model.addAttribute("article", new Article());
        return "editor";
    }

    @RequestMapping(value = "/editor/submit", method = RequestMethod.POST)
    public String editorPage(@ModelAttribute Article article) {
        articleService.save(article);
        return "redirect:../";
    }

    @RequestMapping(value = "/login")
    public String editorPage() {
        return "login";
    }


}
