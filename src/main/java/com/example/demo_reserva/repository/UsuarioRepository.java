package com.example.demo_reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_reserva.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}