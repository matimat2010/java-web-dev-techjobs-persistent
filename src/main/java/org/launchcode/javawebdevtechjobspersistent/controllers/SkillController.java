package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {

        //processAddEmployerForm already takes care of sending the form back if any of the submitted
        // employer object information is invalid. However, it doesn’t yet contain the code to save a
        // valid object. Use employerRepository and the appropriate method to do so.

        if (errors.hasErrors()) {
            model.addAttribute("title","Add Event");
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewEmployer(Model model, @PathVariable int skillId) {

        Optional optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}
