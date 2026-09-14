# Sistema de Xadrez (Java)

Jogo de xadrez completo rodando via console (terminal), desenvolvido em Java puro, orientado a objetos, sem dependências externas.

##  Conceituação

O projeto é dividido em duas camadas principais, seguindo o princípio de separação entre regras genéricas de um jogo de tabuleiro e as regras específicas do xadrez:

- **`boardgame`**: camada genérica e reutilizável, que não conhece nada sobre xadrez. Define conceitos abstratos como tabuleiro (`Board`), posição (`Position`) e peça (`Piece`). Poderia, em tese, ser reaproveitada para outro jogo de tabuleiro (damas, por exemplo).
- **`chess`**: camada que implementa as regras específicas do xadrez, estendendo as classes genéricas de `boardgame`. Contém a partida (`ChessMatch`), a peça de xadrez (`ChessPiece`), as posições no formato de xadrez (`ChessPosition`, ex: "e4") e as peças concretas (Rei, Rainha, Torre, Bispo, Cavalo, Peão) no pacote `chess.pieces`.
- **`application`**: camada de interface com o usuário. Contém o `Program` (ponto de entrada, `main`) e a `UI` (responsável por imprimir o tabuleiro, ler jogadas do teclado e exibir mensagens no terminal).

Essa separação (camadas) é um exemplo do conceito de **baixo acoplamento e alta coesão**, muito usado no ensino de POO em Java.

### Principais regras implementadas
- Movimentação de todas as peças (Rei, Rainha, Torre, Bispo, Cavalo, Peão)
- Roque (pequeno e grande)
- *En passant*
- Promoção de peão
- Xeque e xeque-mate
- Histórico de peças capturadas

##  Tecnologias utilizadas

- **Java** (JDK 25, configurado via `.classpath` do Eclipse)
- **Programação Orientada a Objetos** (herança, abstração, polimorfismo, encapsulamento)
- Sem frameworks ou bibliotecas externas — apenas a API padrão do Java (`java.util.Scanner`, `java.util.List`, etc.)
- Projeto originalmente estruturado como projeto **Eclipse IDE** (arquivos `.project` e `.classpath`)

##  Estrutura de pastas

```
sistema-xadrez/
├── src/
│   ├── application/
│   │   ├── Program.java      # Ponto de entrada (main) - loop do jogo
│   │   └── UI.java           # Interface de console (impressão e leitura)
│   ├── boardgame/
│   │   ├── Board.java        # Tabuleiro genérico
│   │   ├── Position.java     # Posição genérica (linha, coluna)
│   │   ├── Piece.java        # Peça genérica (abstrata)
│   │   └── BoardException.java
│   └── chess/
│       ├── ChessMatch.java     # Regras e fluxo da partida
│       ├── ChessPiece.java     # Peça de xadrez (abstrata)
│       ├── ChessPosition.java  # Posição no formato de xadrez (ex: a1, h8)
│       ├── Color.java          # Enum de cor (WHITE / BLACK)
│       ├── ChessException.java
│       └── pieces/
│           ├── King.java
│           ├── Queen.java
│           ├── Rook.java
│           ├── Bishop.java
│           ├── Knight.java
│           └── Pawn.java
├── bin/                # Classes compiladas (.class)
├── .classpath          # Configuração do Eclipse
└── .project            # Configuração do Eclipse
```

##  Como executar

### Opção 1 — Pela IDE (recomendado)
1. Importe a pasta do projeto no **Eclipse** (ou outra IDE Java como IntelliJ) como um projeto Java existente.
2. Localize a classe `Program.java` em `src/application/`.
3. Execute como **Java Application** (botão direito → *Run As* → *Java Application*).

### Opção 2 — Via terminal (linha de comando)

Compilar:
```bash
cd sistema-xadrez
javac -d bin -encoding UTF-8 $(find src -name "*.java")
```

Executar:
```bash
java -cp bin application.Program
```

> No Windows (PowerShell), troque o `find` por uma listagem manual dos `.java` ou compile via IDE.

##  Como gerar o JAR executável

1. Compile os arquivos `.class` (caso ainda não tenha feito):
   ```bash
   cd sistema-xadrez
   javac -d bin -encoding UTF-8 $(find src -name "*.java")
   ```

2. Crie um arquivo `manifest.txt` com o conteúdo abaixo (define a classe principal):
   ```
   Main-Class: application.Program
   ```

3. Gere o JAR a partir da pasta `bin`:
   ```bash
   cd bin
   jar cfm ../sistema-xadrez.jar ../manifest.txt .
   cd ..
   ```

4. Execute o JAR gerado:
   ```bash
   java -jar sistema-xadrez.jar
   ```

### Alternativa: gerar o JAR pelo Eclipse
1. Botão direito no projeto → **Export...**
2. Selecione **Java → Runnable JAR file**
3. Em *Launch configuration*, escolha a execução de `Program.java`
4. Escolha o destino do arquivo `.jar` e finalize

##  Como jogar

Ao executar, o tabuleiro é exibido no terminal. Basta informar a posição de origem e destino no formato de xadrez (ex: `e2` para origem e `e4` para destino) para mover uma peça. As jogadas possíveis da peça selecionada são destacadas antes de confirmar o destino.
