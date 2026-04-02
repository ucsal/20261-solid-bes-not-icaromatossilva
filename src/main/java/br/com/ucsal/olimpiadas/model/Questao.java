package br.com.ucsal.olimpiadas.model;

import java.util.Scanner;

public interface Questao extends Exibivel {
    long getId();
    void setId(long id);
    long getProvaId();
    void setProvaId(long provaId);
    boolean verificarResposta(String resposta);
}