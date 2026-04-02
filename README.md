Refatoração SOLID:

1.Princípio da Responsabilidade Única (SRP)
  Alterações Realizadas:
  
  Criação do ParticipanteRepository:
    Local: br.com.ucsal.olimpiadas.repository
    Responsabilidade: Gerenciar a persistência de dados em memória (lista de participantes e geração de IDs). A lógica de armazenamento foi isolada da interface do usuário.
  
  Criação do ParticipanteService:
    Local: br.com.ucsal.olimpiadas.service
    Responsabilidade: Regras de negócio e validações. Agora, a verificação de nomes nulos ou vazios acontece aqui, antes de chegar ao repositório.
  
  Limpeza da Classe App:
    A classe principal agora atua apenas como Interface de Usuário (CLI). Ela solicita os dados via Scanner e delega a execução para o ParticipanteService.

2.Princípio Aberto/Fechado (OCP)
  Alterações Realizadas:
  
  Abstração com Interface Questao:
    Transformei a classe concreta Questao em uma Interface. Agora, o sistema não depende de uma implementação única, mas de um contrato que define os métodos exibir() e verificarResposta().

  Especialização de Tipos:
    QuestaoMultiplaEscolha: Implementa a lógica tradicional de alternativas (A-E).
    QuestaoXadrez: Implementa a lógica de tabuleiros FEN, movendo a complexidade de renderização para dentro da própria classe.

  Polimorfismo na App:
    O método aplicarProva() foi simplificado. Ele agora percorre uma lista de interfaces Questao e chama os métodos do contrato.
    A App não precisa mais saber se está lidando com um tabuleiro de xadrez ou com letras, ela apenas "manda a questão se exibir".

3.Princípio da Substituição de Liskov (LSP)
  
  Consistência de Contrato:
    Todas as classes que implementam Questao (QuestaoMultiplaEscolha, QuestaoXadrez) honram os métodos da interface.
    Nenhuma delas lança exceções inesperadas (como UnsupportedOperationException) nos métodos principais.

  Substituibilidade:
    Na classe App, o método aplicarProva trata todos os objetos do tipo Questao de forma uniforme.
    Não existem blocos if (q instanceof QuestaoXadrez), o que prova que a abstração é robusta.

  Comportamento Previsível:
    As validações de resposta foram protegidas contra entradas nulas ou vazias,
    garantindo que o fluxo da prova nunca seja interrompido abruptamente por uma falha de lógica interna da questão.

4.Princípio da Segregação de Interface (ISP)

  Criação da Interface Exibivel:
    Isolamos o comportamento de renderização em tela. Agora, qualquer objeto
    (como um cabeçalho de prova ou aviso) pode ser exibido sem precisar ser uma questão avaliável.

  Refatoração da Interface Questao:
    Ela agora estende Exibivel, mantendo apenas os métodos de identificação e validação de resposta.

  Redução de Dependências:
    Classes que precisam apenas mostrar informações agora podem depender apenas de Exibivel,
    enquanto o motor de notas depende de Questao.
    
5.Princípio da Inversão de Dependência (DIP)
  Alterações Realizadas:
  
  Interface de Repositório:
    Criei a QuestaoRepository para definir como as questões devem ser salvas e recuperadas.
      
  Desacoplamento da App:
    Removi a List<Questao> estática que era manipulada diretamente dentro dos métodos da App. Agora, a classe principal interage apenas com a interface do repositório.
  
  Implementação em Memória:
    Criei a MemoriaQuestaoRepository, que encapsula a lista de questões. Se no futuro desejar usar um Banco de Dados (SQL) ou arquivos (JSON),
    basta criar uma nova implementação da interface sem tocar no código da App.
