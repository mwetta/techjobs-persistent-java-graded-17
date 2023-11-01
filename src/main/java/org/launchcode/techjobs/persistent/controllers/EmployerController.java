package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// 3.2.1 Add a private field of EmployerRepository type called employerRepository; annotate with @Autowired
// 3.2.2 Add an index method that responds at /employers with a list of all employers in the database using template employers/index
// TODO 3.2.3 Use employerRepository and the appropriate method to save a valid object
// TODO 3.2.4 Replace the null under optEmployer using findById() method with the correct argument to look for the given employer object from the data layer; This variable is provided in the controller method's parameters
@Controller
@RequestMapping("employers/")
public class EmployerController {
    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping
    public String displayAllEmployers(Model model){
        model.addAttribute("employers", employerRepository.findAll());
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "employers/add";
        }
        employerRepository.save(newEmployer);
        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = null;
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

    }
}
