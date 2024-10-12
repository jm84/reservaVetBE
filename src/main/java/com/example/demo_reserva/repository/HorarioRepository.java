package com.example.demo_reserva.repository;

import com.example.demo_reserva.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByMedicoIdAndDisponibleTrue(Long medicoId);
}