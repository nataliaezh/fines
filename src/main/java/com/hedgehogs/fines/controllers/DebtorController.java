package com.hedgehogs.fines.controllers;

import com.hedgehogs.fines.entitties.Debtor;
import com.hedgehogs.fines.entitties.Letter;
import com.hedgehogs.fines.services.DebtorService;
import com.hedgehogs.fines.services.LetterService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Controller
@RequestMapping("/debtors")
public class DebtorController {

    private DebtorService debtorService;
    @Autowired
    public void setDebtorService(DebtorService debtorService) {
        this.debtorService = debtorService; }

        private LetterService letterService;
    @Autowired
    public void setLetterService(LetterService letterService) {
        this.letterService = letterService;
    }

    @GetMapping("/")
    public String showAllDebtors(Model model) {
        Debtor debtor = new Debtor();
        model.addAttribute("debtor", debtor);
        model.addAttribute("debtors", debtorService.findAll());
        return "debtors";
    }
    @GetMapping("/selectnotification")
    public String performNotification(Model model, @RequestParam(name = "id", required = false) Long id) throws IOException {
        Debtor debtor = debtorService.findById(id);

        Letter letter = letterService.findOneByTitle("notification");
        model.addAttribute("name", debtor.getFirstname());
        model.addAttribute("lastname", debtor.getLastname());
        model.addAttribute("letter", letter.getContent());
        model.addAttribute("sum", debtor.getSumdebt());
            return "notification";
    }
    @GetMapping("/selectreminder")
    public String performReminder(Model model, @RequestParam(name = "id", required = false) Long id) {


        Debtor debtor = debtorService.findById(id);

        Letter letter = letterService.findOneByTitle("reminder");
        model.addAttribute("name", debtor.getFirstname());
        model.addAttribute("lastname", debtor.getLastname());
        model.addAttribute("letter", letter.getContent());
        model.addAttribute("sum", debtor.getSumdebt());
        return "reminder";
    }

    @GetMapping("/selectfine")
    public String performFine(Model model, @RequestParam(name = "id", required = false) Long id) {

        Debtor debtor = debtorService.findById(id);

        Letter letter = letterService.findOneByTitle("fine");
        model.addAttribute("name", debtor.getFirstname());
        model.addAttribute("lastname", debtor.getLastname());
        model.addAttribute("letter", letter.getContent());
        return "fine";
    }


    @GetMapping("/documentationnotification")
    public String generateNotification(Model model, @RequestParam(name = "id", required = false) Long id) throws IOException {
        Debtor debtor = debtorService.findById(id);
        List<Debtor> list = debtorService.findAll();
        Letter letter = letterService.findOneByTitle("notification");
        File file = new File("file.doc");
            if (!file.exists()) ;
            file.createNewFile();

        FileWriter writer = new FileWriter(file);
        String greeting="Получатель:";
        String name = debtor.getFirstname().toString();
        String lastname = debtor.getLastname().toString();
        String content = letter.getContent().toString();
        String sum = debtor.getSumdebt().toString();
        writer.write(greeting);
        writer.append("\n");
        writer.write(name);
        writer.append("\n");
        writer.write(lastname);
        writer.append("\n");
        writer.write(content);
        writer.append("\n");
        writer.write(sum);
        writer.write(" рублей");
        writer.close();
        return "success";
    }

    @GetMapping("/documentationreminder")
    public String generateReminder(Model model, @RequestParam(name = "id", required = false) Long id) throws IOException {
        Debtor debtor = debtorService.findById(id);
        List<Debtor> list = debtorService.findAll();
        Letter letter = letterService.findOneByTitle("reminder");
        File file = new File("file.doc");
        if (!file.exists()) ;
        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        String greeting="Получатель:";
        String name = debtor.getFirstname().toString();
        String lastname = debtor.getLastname().toString();
        String content = letter.getContent().toString();
        String sum = debtor.getSumdebt().toString();
        writer.write(greeting);
        writer.append("\n");
        writer.write(name);
        writer.append("\n");
        writer.write(lastname);
        writer.append("\n");
        writer.write(content);
        writer.append("\n");
        writer.write(sum);
        writer.write(" рублей");
        writer.close();
        return "success";
    }


    @GetMapping("/documentationfine")
    public String generateFine(Model model, @RequestParam(name = "id", required = false) Long id) throws IOException {
        Debtor debtor = debtorService.findById(id);
        List<Debtor> list = debtorService.findAll();
        Letter letter = letterService.findOneByTitle("fine");
        File file = new File("file.doc");
        if (!file.exists()) ;
        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        String greeting="Получатель:";
        String name = debtor.getFirstname().toString();
        String lastname = debtor.getLastname().toString();
        String content = letter.getContent().toString();
        String sum = debtor.getSumdebt().toString();
        writer.write(greeting);
        writer.append("\n");
        writer.write(name);
        writer.append("\n");
        writer.write(lastname);
        writer.append("\n");
        writer.write(content);
        writer.close();
        return "success";
    }
}
