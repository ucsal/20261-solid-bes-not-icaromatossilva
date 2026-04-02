package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.Participante;
import br.com.ucsal.olimpiadas.repository.ParticipanteRepository;

public class ParticipanteService {
    private final ParticipanteRepository repository;

    public ParticipanteService(ParticipanteRepository repository) {
        this.repository = repository;
    }

    public void registrarParticipante(String nome, String email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        
        Participante p = new Participante();
        p.setNome(nome);
        p.setEmail(email);
        
        repository.salvar(p);
    }
}