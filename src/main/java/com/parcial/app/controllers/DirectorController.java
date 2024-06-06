package com.parcial.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DirectorController {

    @GetMapping("/director")
    public String directorHome() {
        return "director/indir";
    }

    @GetMapping("/director/calificar-proyecto")
    public String calificarProyecto() {
        return "director/calificar-proyecto";
    }

    @GetMapping("/director/calendario-academico")
    public String calendarioAcademico() {
        return "director/calendario-academico";
    }

    @GetMapping("/director/formato-grado")
    public String formatoGrado() {
        return "director/formato-grado";
    }
}
