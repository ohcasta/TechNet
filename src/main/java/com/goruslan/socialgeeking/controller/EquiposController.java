package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.domain.Comment;
import com.goruslan.socialgeeking.domain.Post;
import com.goruslan.socialgeeking.domain.Equipos;
import com.goruslan.socialgeeking.repository.CommentRepository;
import com.goruslan.socialgeeking.repository.PostRepository;
import com.goruslan.socialgeeking.service.PostService;
import com.goruslan.socialgeeking.service.EquiposService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


//@RestController
//@RequestMapping("/posts")

@Controller
//lista de equipos equipos dañados

public class EquiposController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private EquiposService equiposService;

    public EquiposController(EquiposService equiposService) {
        this.equiposService = equiposService;
    }
    @GetMapping("equipos/list")
    public String list(Model model) {
        model.addAttribute("equipos", equiposService.findAll());
        return "/equipos/list";
    }

    @GetMapping("/equipos/{id}")
    public String read(@PathVariable Long id, Model model) {
        Optional<Equipos> equipos = equiposService.findById(id);
        if( equipos.isPresent() ) {
            Equipos currentEquipos = equipos.get();

            model.addAttribute("equipo", currentEquipos);
            model.addAttribute("success", model.containsAttribute("success"));
            return "equipos/view";

        } else {
            return "redirect:/ ";
        }
    }
    @GetMapping("/equipos/submit")
    public String newEquiposForm(Model model){
        model.addAttribute("equipos", new Equipos());
        return "equipos/submit";
    }

    @PostMapping("/equipos/submit")
    public String createEquipo(@Valid Equipos equipo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors()){
            logger.info("Validation error while submitting a new equipment.");
            model.addAttribute("equipos", equipo);
            return "equipos/submit";
        } else {
            equiposService.save(equipo);
            logger.info("nuevo equipo guardado con exito.");
            redirectAttributes
                    .addAttribute("id", equipo.getId())
                    .addFlashAttribute("success", true);
            return "redirect:/equipos/{id}";

        }
    }



}
