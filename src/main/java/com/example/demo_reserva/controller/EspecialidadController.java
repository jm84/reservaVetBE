package com.example.demo_reserva.controller;

import com.example.demo_reserva.entity.Especialidad;
import com.example.demo_reserva.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "*") // Permitir todos los orígenes
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> getAllEspecialidades() {
        return especialidadService.getAllEspecialidades();
    }

    @GetMapping("/{id}")
    public Especialidad getEspecialidadById(@PathVariable Long id) {
        return especialidadService.getEspecialidadById(id);
    }

    @PostMapping
    public Especialidad createEspecialidad(@RequestBody Especialidad especialidad) {
        return especialidadService.createEspecialidad(especialidad);
    }

    @PutMapping("/{id}")
    public Especialidad updateEspecialidad(@PathVariable Long id, @RequestBody Especialidad especialidadDetails) {
        return especialidadService.updateEspecialidad(id, especialidadDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEspecialidad(@PathVariable Long id) {
        especialidadService.deleteEspecialidad(id);
    }
}
