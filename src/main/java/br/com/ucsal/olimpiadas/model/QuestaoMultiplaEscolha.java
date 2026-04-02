package br.com.ucsal.olimpiadas.model;

public class QuestaoMultiplaEscolha implements Questao {
    private long id;
    private long provaId;
    private String enunciado;
    private String[] alternativas;
    private char alternativaCorreta;

    public QuestaoMultiplaEscolha(String enunciado, String[] alternativas, char correta) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.alternativaCorreta = Character.toUpperCase(correta);
    }

    @Override
    public void exibir() {
        System.out.println("\nQuestão #" + id + " [Múltipla Escolha]");
        System.out.println(enunciado);
        for (String alt : alternativas) {
            System.out.println(alt);
        }
    }

    @Override
    public boolean verificarResposta(String resposta) {
        if (resposta == null || resposta.isEmpty()) return false;
        char marcada = Character.toUpperCase(resposta.trim().charAt(0));
        return marcada == alternativaCorreta;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public long getProvaId() { return provaId; }
    public void setProvaId(long provaId) { this.provaId = provaId; }
}