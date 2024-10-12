package com.example.demo_reserva.repository;

import com.example.demo_reserva.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findByEspecialidadId(Long especialidadId);
}