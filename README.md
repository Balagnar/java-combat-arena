# 🛡️ Java Combat Arena

Um simulador de combate em turnos desenvolvido em **Java**. Este projeto foi criado para exercitar lógica de programação, manipulação de objetos e estruturas de controle.

# 🚀 Funcionalidades

- **Combate por Turnos:** O jogador (Guerreiro) enfrenta inimigos em um duelo de vida ou morte.
- **Lógica de Atributos:** Uso de HP e Dano para calcular os resultados de cada rodada.
- **Sistema de Sorteio:** Agora a arena utiliza a classe `Random` para sortear dinamicamente qual inimigo você enfrentará ao iniciar o combate.
- **Habilidades Especiais:** Implementação de mecânicas únicas, como a ressurreição automática de certos inimigos.
- **POO Avançado:** Uso de Herança e Polimorfismo (`Inimigo` -> `Esqueleto` / `Slime`) para facilitar a expansão do bestiário.

### Personagens Atuais:
* **Herói:** Um soldado destemido pronto para a batalha.
* **Inimigos:** Esqueleto (Guerreiro Morto-Vivo) e Slime (Criatura viscosa).

## 🚀 Progresso do Desenvolvimento
- [x] Lógica de combate funcional (Ataque/Dano).
- [x] Organização de diretórios (`src/assets`).
- [x] Implementação de Sprites (Soldier, Esqueleto, Slime).
- [x] Implementação de Barras de Vida (ProgressBar).
- [x] Sistema de Sorteio de Inimigos (Randomização de Arena).
- [ ] Sistema de animações básicas (Idle/Attack).
- [ ] Sistema de itens e cura.

## [v1.3.0] - Sistema de Sorteio e Novos Inimigos (Feat)
- **Sorteio de Arena:** Implementada lógica para instanciar inimigos aleatórios no início do jogo.
- **Mecânica de Ressurreição:** Classe `Esqueleto` agora possui lógica própria para reviver após a primeira derrota.
- **Polimorfismo de UI:** O controlador identifica o tipo de inimigo e atualiza a imagem e status dinamicamente.
- **Bugfix (Sanitização):** Proteção contra HP negativo nas barras de vida usando `Math.max`.

## [v1.2.1] - Reset de Instância e Morte Dinâmica (Atual)
- **Sistema de Reset:** Implementação da lógica de reiniciar o jogo sem fechar a aplicação, criando uma nova instância limpa da `Arena`.
- **Feedback Visual de Derrota:** Adição de estados visuais para morte (Guerreiro vira lápide e Slime vira poça).
- **Botão Inteligente:** O botão de "Atacar" agora transforma-se em "Reiniciar" automaticamente ao fim do combate.
- **Refatoração de Código:** Limpeza de variáveis globais para evitar bugs ao reiniciar a partida.

## [v1.0.0] - Integração com Scene Builder e FXML
- **Design Visual Profissional:** Transição do layout construído via código para o uso do **Scene Builder**.
- **Separação de Responsabilidades:** Implementação de arquivos `.fxml` e classes `Controller`.

## [v0.9.0] - Identidade Visual e Interatividade
- **Elementos Visuais:** Inclusão das primeiras imagens (sprites) e `ProgressBar`.
- **Controle do Jogador:** Adição do Botão de Ataque manual.

## [v0.6.0] - Correção de Lógica e Pastas (Chore)
- **Cálculo de Dano:** Correção do bug onde os personagens não perdiam vida.
- **Hierarquia de Pastas:** Ajuste organizacional para facilidade de desenvolvimento.
- **Log de Eventos:** Implementação do histórico de combate no terminal.

## [v0.0.1] - Base do Sistema (Ponto Zero)
- **Core do Jogo:** Lógica base de combate e morte via console.


# 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+ (Recomendado Java 21)
* **Interface:** JavaFX & Scene Builder
* **Versionamento:** Git & GitHub

# 🎮 Como Executar

### Pré-requisitos
* Ter o **Java JDK** (17 ou superior) instalado.
* (Opcional) **IntelliJ IDEA** ou **VS Code** com extensões para Java/JavaFX.

### Executando via IDE (Mais fácil)
1. Clone o repositório ou baixe o código.
2. Abra o projeto na sua IDE.
3. Certifique-se de que a biblioteca **JavaFX** está configurada no seu Classpath.
4. Execute a classe `Main.java` dentro do pacote correspondente.
