package com.rsmensage.rsmensage.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rsmensage.rsmensage.model.Mensagem;

@Repository
public interface MensagemRepository extends MongoRepository<Mensagem, String> {

    List<Mensagem> findByLidaFalse();
    Mensagem findFirstByLidaFalse();

    List<Mensagem> findByLidaTrue();
}
