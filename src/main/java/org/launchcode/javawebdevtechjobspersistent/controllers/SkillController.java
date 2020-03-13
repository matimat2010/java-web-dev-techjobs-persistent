package org.launchcode.javawebdevtechjobspersistent.controllers;

        import org.launchcode.javawebdevtechjobspersistent.models.Skill;
        import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
        import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
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
    //Adding other repositories to see if it helps view after adding
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;


    //View Skills List From Data Base After Adding
    @GetMapping
    public String displaySkillList(Model model){
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title","Add Event");
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        Optional optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            // model.addAttribute("skill", skillRepository.findAll());
            return "redirect:../";
        }
    }


}
