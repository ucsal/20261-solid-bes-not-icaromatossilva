package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.model.Questao;
import java.util.List;

public interface QuestaoRepository {
    void salvar(Questao questao);
    List<Questao> buscarPorProva(long provaId);
    List<Questao> listarTodas();
}