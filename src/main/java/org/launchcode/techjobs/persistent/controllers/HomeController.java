package org.launchcode.techjobs.persistent.controllers;

// 3.3.1 Add a field employerRepository annotated with @Autowired
// 3.3.2 Add employer data from employerRepository into the form template, making sure variable matches template
// 3.3.3 Review templates/add.html, and note variable used to pass id on form submission
/* 3.3.4 Add code inside of processAddJobForm to select the employer object that has been affiliated with the new job
       You will need to select the employer using the request parameter you've added to the method*/

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	    model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId) {

        Employer aEmployer = employerRepository.findById(employerId).orElse(new Employer());
        newJob.setEmployer(aEmployer);
        // on errors, the list of employers isn't displayed unless you re-add everything to the model
        if (errors.hasErrors()) {
            model.addAttribute(new Job());
            model.addAttribute("employers", employerRepository.findAll());
	        model.addAttribute("title", "Add Job");
            return "add";
        }
        jobRepository.save(newJob);
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

            return "view";
    }

}
