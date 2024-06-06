package com.parcial.app.controllers;

import com.parcial.app.services.CoordinadorService;
import com.parcial.app.variables.Coordinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coordinador")
public class CoordinadorController {

    @Autowired
    private CoordinadorService coordinadorService;

    @GetMapping
    public String getAllCoordinadores(Model model) {
        List<Coordinador> coordinadores = coordinadorService.getAllCoordinadores();
        model.addAttribute("coordinadores", coordinadores);
        return "coordinador/coordinador-list";
    }

    @GetMapping("/form")
    public String coordinadorForm(Model model) {
        model.addAttribute("coordinador", new Coordinador());
        return "coordinador/coordinador-form";
    }

    @GetMapping("/edit/{id}")
    public String editCoordinadorForm(@PathVariable Long id, Model model) {
        Coordinador coordinador = coordinadorService.getCoordinadorById(id);
        model.addAttribute("coordinador", coordinador);
        return "coordinador/coordinador-form";
    }

    @PostMapping("/save")
    public String saveCoordinador(@ModelAttribute Coordinador coordinador) {
        coordinadorService.saveCoordinador(coordinador);
        return "redirect:/coordinador";
    }

    @GetMapping("/success")
    public String success() {
        return "coordinador/coordinador-success";
    }

    @GetMapping("/{id}")
    public String getCoordinadorById(@PathVariable Long id, Model model) {
        Coordinador coordinador = coordinadorService.getCoordinadorById(id);
        model.addAttribute("coordinador", coordinador);
        return "coordinador/coordinador-detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteCoordinador(@PathVariable Long id) {
        coordinadorService.deleteCoordinador(id);
        return "redirect:/coordinador";
    }

    @GetMapping("/incoor")
    public String incoorPage() {
        return "coordinador/incoor";
    }

    // Redirección a otras páginas
    @GetMapping("/agregar-proyecto")
    public String agregarProyecto() {
        return "coordinador/agregar-proyecto";
    }

    @GetMapping("/estudiante")
    public String estudiante() {
        return "estudiante/estudiante-list";
    }

    @GetMapping("/calendario")
    public String calendario() {
        return "calendario/calendario-view";
    }

    @GetMapping("/formatos")
    public String formatos() {
        return "formatos/formatos-view";
    }
}
