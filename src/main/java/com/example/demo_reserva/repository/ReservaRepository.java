package com.example.demo_reserva.repository;

import com.example.demo_reserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {}