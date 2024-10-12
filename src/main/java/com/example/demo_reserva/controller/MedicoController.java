package com.example.demo_reserva.controller;

import com.example.demo_reserva.entity.Medico;
import com.example.demo_reserva.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.getAllMedicos();
    }

    @GetMapping("/{id}")
    public Medico getMedicoById(@PathVariable Long id) {
        return medicoService.getMedicoById(id);
    }

    @GetMapping("/especialidad/{especialidadId}")
    public List<Medico> getMedicosByEspecialidad(@PathVariable Long especialidadId) {
        return medicoService.getMedicosByEspecialidad(especialidadId);
    }

    @PostMapping
    public Medico createMedico(@RequestBody Medico medico) {
        return medicoService.createMedico(medico);
    }

    @PutMapping("/{id}")
    public Medico updateMedico(@PathVariable Long id, @RequestBody Medico medicoDetails) {
        return medicoService.updateMedico(id, medicoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
    }
}