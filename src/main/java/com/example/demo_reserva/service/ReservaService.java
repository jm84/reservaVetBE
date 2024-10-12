package com.example.demo_reserva.service;

import com.example.demo_reserva.entity.Horario;
import com.example.demo_reserva.entity.Reserva;
import com.example.demo_reserva.repository.HorarioRepository;
import com.example.demo_reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id).orElseThrow();
    }

    public Reserva createReserva(Reserva reserva) {
        Horario horario = horarioRepository.findById(reserva.getHorario().getId()).orElseThrow();
        horario.setDisponible(false);
        horarioRepository.save(horario);

        reserva.setFechaReserva(new Timestamp(System.currentTimeMillis()));
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Long id, Reserva reservaDetails) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow();
        reserva.setUsuario(reservaDetails.getUsuario());
        reserva.setHorario(reservaDetails.getHorario());
        reserva.setFechaReserva(reservaDetails.getFechaReserva());
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}