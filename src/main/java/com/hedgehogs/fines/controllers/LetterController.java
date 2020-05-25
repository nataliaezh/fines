package com.hedgehogs.fines.controllers;

import com.hedgehogs.fines.entitties.Debtor;
import com.hedgehogs.fines.entitties.Letter;
import com.hedgehogs.fines.services.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Controller
@RequestMapping("/letters")
public class LetterController {
    private LetterService letterService;
    @Autowired
    public void setLetterService(LetterService letterService) {
        this.letterService = letterService;
    }

    @GetMapping("/")
    public String showAllLetters(Model model) {
        Letter letter = new Letter();
        model.addAttribute("letter", letter);
        model.addAttribute("letters", letterService.findAll());
        return "letters";
    }
}
