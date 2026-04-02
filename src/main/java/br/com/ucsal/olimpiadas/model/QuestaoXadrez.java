package br.com.ucsal.olimpiadas.model;

public class QuestaoXadrez implements Questao {
    private long id;
    private long provaId;
    private String enunciado;
    private String fen;
    private String movimentoCorreto;

    public QuestaoXadrez(String enunciado, String fen, String movimentoCorreto) {
        this.enunciado = enunciado;
        this.fen = fen;
        this.movimentoCorreto = movimentoCorreto;
    }

    @Override
    public void exibir() {
        System.out.println("\nQuestão #" + id + " [DESAFIO DE XADREZ]");
        System.out.println(enunciado);
        imprimirTabuleiro(fen);
    }

    @Override
    public boolean verificarResposta(String resposta) {
        if (resposta == null || resposta.trim().isEmpty()) {
            return false; 
        }
        return movimentoCorreto.equalsIgnoreCase(resposta.trim());
    }

    private void imprimirTabuleiro(String fen) {
        String parteTabuleiro = fen.split(" ")[0];
        String[] ranks = parteTabuleiro.split("/");
        System.out.println("    a b c d e f g h");
        System.out.println("   -----------------");
        for (int r = 0; r < 8; r++) {
            System.out.print((8 - r) + " | ");
            for (char c : ranks[r].toCharArray()) {
                if (Character.isDigit(c)) {
                    int vazios = c - '0';
                    for (int i = 0; i < vazios; i++) System.out.print(". ");
                } else {
                    System.out.print(c + " ");
                }
            }
            System.out.println("| " + (8 - r));
        }
        System.out.println("   -----------------");
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public long getProvaId() { return provaId; }
    public void setProvaId(long provaId) { this.provaId = provaId; }
}