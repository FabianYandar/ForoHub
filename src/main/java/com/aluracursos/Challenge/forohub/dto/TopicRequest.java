package com.aluracursos.Challenge.forohub.dto;

import lombok.Data;

@Data
public class TopicRequest {
    private Long idUsuario;
    private String nombreCurso;
    private String mensaje;
    private String titulo;

}
