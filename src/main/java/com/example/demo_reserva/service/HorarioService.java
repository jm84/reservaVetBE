package com.example.demo_reserva.service;

import com.example.demo_reserva.entity.Horario;
import com.example.demo_reserva.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    public Horario getHorarioById(Long id) {
        return horarioRepository.findById(id).orElseThrow();
    }

    public List<Horario> getHorariosByMedico(Long medicoId) {
        return horarioRepository.findByMedicoIdAndDisponibleTrue(medicoId);
    }

    public Horario createHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario updateHorario(Long id, Horario horarioDetails) {
        Horario horario = horarioRepository.findById(id).orElseThrow();
        horario.setMedico(horarioDetails.getMedico());
        horario.setFecha(horarioDetails.getFecha());
        horario.setHora(horarioDetails.getHora());
        horario.setDisponible(horarioDetails.getDisponible());
        return horarioRepository.save(horario);
    }

    public void deleteHorario(Long id) {
        horarioRepository.deleteById(id);
    }
}