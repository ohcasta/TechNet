package com.goruslan.socialgeeking.repository;

import com.goruslan.socialgeeking.domain.Equipos;
import com.goruslan.socialgeeking.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquiposRepository extends JpaRepository<Equipos, Long> {
}
