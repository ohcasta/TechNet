package com.goruslan.socialgeeking.service;


import com.goruslan.socialgeeking.domain.Equipos;
import com.goruslan.socialgeeking.repository.EquiposRepository;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class EquiposService {

    private final EquiposRepository equiposRepository;


    public EquiposService(EquiposRepository equiposRepository) {
        this.equiposRepository = equiposRepository;
    }

    public List<Equipos> findAll() {
        return equiposRepository.findAll();
    }

    public Optional<Equipos> findById(Long id) {
        return equiposRepository.findById(id);
    }

    public Equipos save(Equipos equipos) {
        return equiposRepository.save(equipos);
    }
}
