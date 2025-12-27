package com.mathtrainer.api.repository;

import com.mathtrainer.api.model.Equacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquacaoRepository extends JpaRepository<Equacao, UUID> {
}
