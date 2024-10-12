package com.example.demo_reserva.service;

import com.example.demo_reserva.entity.Especialidad;
import com.example.demo_reserva.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Especialidad getEspecialidadById(Long id) {
        return especialidadRepository.findById(id).orElseThrow();
    }

    public Especialidad createEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public Especialidad updateEspecialidad(Long id, Especialidad especialidadDetails) {
        Especialidad especialidad = especialidadRepository.findById(id).orElseThrow();
        especialidad.setNombre(especialidadDetails.getNombre());
        return especialidadRepository.save(especialidad);
    }

    public void deleteEspecialidad(Long id) {
        especialidadRepository.deleteById(id);
    }
}