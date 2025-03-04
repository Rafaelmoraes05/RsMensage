package com.rsmensage.rsmensage.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsmensage.rsmensage.model.Mensagem;
import com.rsmensage.rsmensage.repository.MensagemRepository;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public Mensagem getMensagemDoDia() {
        Mensagem mensagem = mensagemRepository.findFirstByLidaFalse();
        if (mensagem == null) {
            throw new RuntimeException("Não há mensagens disponíveis.");
        }
        mensagem.setLida(true);
        mensagem.setDataLeitura(LocalDate.now());
        mensagemRepository.save(mensagem);
        return mensagem;
    }

    public List<Mensagem> getMensagensLidas() {
        return mensagemRepository.findByLidaTrue();
    }

    public List<Mensagem> getMensagensNaoLidas() {
        return mensagemRepository.findByLidaFalse();
    }

    public void marcarComoLida(Mensagem mensagem) {
        Mensagem msg = mensagemRepository.findById(mensagem.getId())
                .orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));

        msg.setLida(true);
        mensagemRepository.save(msg);
    }
}
