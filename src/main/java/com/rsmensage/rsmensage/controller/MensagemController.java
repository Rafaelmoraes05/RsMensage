package com.rsmensage.rsmensage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsmensage.rsmensage.model.Mensagem;
import com.rsmensage.rsmensage.service.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @GetMapping("/dia")
    public Mensagem getMensagemDoDia() {
        return mensagemService.getMensagemDoDia();
    }

    @GetMapping("/lidas")
    public List<Mensagem> getMensagensLidas() {
        return mensagemService.getMensagensLidas();
    }

    @GetMapping("/nao-lidas")
    public List<Mensagem> getMensagensNaoLidas() {
    return mensagemService.getMensagensNaoLidas();
    }

    @PostMapping("/lidas")
    public ResponseEntity<String> marcarMensagemComoLida(@RequestBody Mensagem mensagem) {
        mensagemService.marcarComoLida(mensagem);
        return ResponseEntity.ok("Mensagem marcada como lida!");
    }
}
