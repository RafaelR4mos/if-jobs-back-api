package com.br.ifjobs.repository;

import com.br.ifjobs.entity.VagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<VagaEntity, Integer> {
}
