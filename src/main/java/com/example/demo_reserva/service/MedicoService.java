package com.example.demo_reserva.service;

import com.example.demo_reserva.entity.Medico;
import com.example.demo_reserva.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Medico getMedicoById(Long id) {
        return medicoRepository.findById(id).orElseThrow();
    }

    public List<Medico> getMedicosByEspecialidad(Long especialidadId) {
        return medicoRepository.findByEspecialidadId(especialidadId);
    }

    public Medico createMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, Medico medicoDetails) {
        Medico medico = medicoRepository.findById(id).orElseThrow();
        medico.setUsuario(medicoDetails.getUsuario());
        medico.setEspecialidad(medicoDetails.getEspecialidad());
        return medicoRepository.save(medico);
    }

    public void deleteMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}