package com.example.demo_reserva.controller;

import com.example.demo_reserva.entity.Horario;
import com.example.demo_reserva.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public List<Horario> getAllHorarios() {
        return horarioService.getAllHorarios();
    }

    @GetMapping("/{id}")
    public Horario getHorarioById(@PathVariable Long id) {
        return horarioService.getHorarioById(id);
    }

    @GetMapping("/medico/{medicoId}")
    public List<Horario> getHorariosByMedico(@PathVariable Long medicoId) {
        return horarioService.getHorariosByMedico(medicoId);
    }

    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioService.createHorario(horario);
    }

    @PutMapping("/{id}")
    public Horario updateHorario(@PathVariable Long id, @RequestBody Horario horarioDetails) {
        return horarioService.updateHorario(id, horarioDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteHorario(@PathVariable Long id) {
        horarioService.deleteHorario(id);
    }
}