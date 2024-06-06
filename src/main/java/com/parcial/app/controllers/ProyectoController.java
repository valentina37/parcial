package com.parcial.app.controllers;

import com.parcial.app.services.ProyectoService;
import com.parcial.app.variables.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/agregar-proyecto")
    public String proyectoForm(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyecto/agregar-proyecto";
    }

    @PostMapping("/guardar")
    public String createProyecto(@ModelAttribute Proyecto proyecto, Model model) {
        try {
            proyectoService.saveProyecto(proyecto);
            model.addAttribute("mensaje", "Proyecto guardado exitosamente");
            return "proyecto/proyecto-success";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el proyecto: " + e.getMessage());
            return "proyecto/error";
        }
    }

    @GetMapping("/listar")
    public String listarProyectos(Model model) {
        model.addAttribute("proyectos", proyectoService.getAllProyectos());
        return "proyecto/proyecto-list";
    }
}
