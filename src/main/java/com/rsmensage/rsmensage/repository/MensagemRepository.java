package com.rsmensage.rsmensage.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rsmensage.rsmensage.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    List<Mensagem> findByLidaFalse();
    Mensagem findFirstByLidaFalse();

    List<Mensagem> findByLidaTrue();
}
