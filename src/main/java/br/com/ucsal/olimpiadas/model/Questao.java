package br.com.ucsal.olimpiadas.model;

import java.util.Scanner;

public interface Questao {
    long getId();
    void setId(long id);
    long getProvaId();
    void setProvaId(long provaId);
    void exibir();
    boolean verificarResposta(String resposta);
}