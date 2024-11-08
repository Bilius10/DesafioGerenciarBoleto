package com.gerenciar.boletos.REPOSITORY;

import com.gerenciar.boletos.ENTITY.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long> {
}
