package com.rsmensage.rsmensage.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "mensagens")
public class Mensagem {

    @Id
    private String id;
    private String texto;
    private boolean lida;
    private LocalDate dataLeitura;

}
