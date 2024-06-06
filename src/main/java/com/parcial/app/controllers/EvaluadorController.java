package com.parcial.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EvaluadorController {

    @GetMapping("/evaluador")
    public String evaluadorHome() {
        return "evaluador/ineva";
    }

    @GetMapping("/evaluador/proyectos")
    public String proyectos() {
        return "evaluador/proyectos";
    }

    @GetMapping("/evaluador/calendario-academico")
    public String calendarioAcademico() {
        return "evaluador/calendario-academico";
    }

    @GetMapping("/evaluador/formato-grado")
    public String formatoGrado() {
        return "evaluador/formato-grado";
    }
}
