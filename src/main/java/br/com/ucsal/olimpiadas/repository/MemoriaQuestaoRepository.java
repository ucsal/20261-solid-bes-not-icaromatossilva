package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.model.Questao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoriaQuestaoRepository implements QuestaoRepository {
    private final List<Questao> bancoDeDados = new ArrayList<>();

    @Override
    public void salvar(Questao q) {
        bancoDeDados.add(q);
    }

    @Override
    public List<Questao> buscarPorProva(long provaId) {
        return bancoDeDados.stream()
                .filter(q -> q.getProvaId() == provaId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Questao> listarTodas() {
        return new ArrayList<>(bancoDeDados);
    }
}