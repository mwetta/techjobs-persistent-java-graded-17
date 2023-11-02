package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//3.2.5 Replicate steps from EmployerController
// 3.2.5.1 methods
// 2.2.5.2 displayAddSkillForm
// 3.2.5.3 processAddSkillForm
// 3.2.5.4 displayViewSkill
// 3.2.6 Uncomment all remaining methods in TestTaskTwo, and import the new controller
// 3.3 Test it with SQL
// 3.3.1 Start application and go to Add Jobs form
// 3.3.2 Check functionality of Add Employers and Add Skills form
// 3.3.3 Test validation requirements and error handling
// 3.3.4 In queries.sql write a query to list the names of the employers in St.Louis City, without specifying ordering
@Controller
@RequestMapping("skills/")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public String displayAllSkills(Model model){
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model){
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model){
        if (errors.hasErrors()){
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId){
        Optional optSkill = skillRepository.findById(skillId);
        if(optSkill.isPresent()){
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }


}
