# 🛡️ Java Combat Arena

Um simulador de combate em turnos desenvolvido em **Java**. Este projeto foi criado para exercitar lógica de programação, manipulação de objetos e estruturas de controle.

# 🚀 Funcionalidades

- **Combate por Turnos:** O jogador (Guerreiro) enfrenta um Boss em um duelo de vida ou morte.
- **Lógica de Atributos:** Uso de HP e Dano para calcular os resultados de cada rodada.
- **Aleatoriedade:** Implementação da classe `Random` para variar o dano dos ataques e tornar os duelos dinâmicos.
- **POO:** Estrutura baseada em classes (`Guerreiro`, `Arena`, `Boss`, `Main`) para garantir um código organizado e escalável.

# 🪵 Histórico de Versões

### [v1.0.0] - Integração com Scene Builder e FXML
- **Design Visual Profissional:** Transição do layout construído via código para o uso do **Scene Builder**, permitindo uma interface mais rica e organizada.
- **Separação de Responsabilidades:** Implementação de arquivos `.fxml` para o layout e classes `Controller` para a lógica da interface.
- **Estabilidade da UI:** Refinamento dos componentes gráficos para garantir que a janela e os elementos se comportem corretamente.

## [v0.9.0] - Identidade Visual e Interatividade (Sprites, Barras & Botão)
- **Elementos Visuais:** Inclusão das primeiras imagens (sprites) para o Guerreiro e o Boss.
- **Barras de Vida:** Implementação de `ProgressBar` para visualização rápida da saúde dos combatentes.
- **Controle do Jogador:** Adição do **Botão de Ataque**, permitindo que o utilizador controle o ritmo das rodadas em vez de uma execução automática.
- **Imersão:** O projeto passa a ter uma identidade visual de jogo de RPG funcional.

## [v0.6.0] - Correção de Lógica e Pastas (Chore)
### Correções
- **Cálculo de Dano:** Correção do bug onde os personagens não perdiam vida durante os turnos.
- **Sincronização de Atributos:** Ajuste nos métodos de *getters* e *setters* para garantir que o HP fosse atualizado corretamente na memória.
- **Correção Hierarquia de Pastas:** Foi ajustado a Hierarquia de Pastas e Arquivos para facilidade de TypeCode.
### Nova Funcionalidade:
- **Log De Eventos:** Implementação de um LOG de Eventos no Terminal.

## [v0.0.1] - Base do Sistema (Ponto Zero)
- **Core do Jogo:** Criação da lógica de combate puramente via console.
- **Mecanismo de Morte:** O sistema identifica o fim do jogo ao zerar o HP de um dos personagens.

# 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+ (Atualmente utilizando Java 21)
* **Versionamento:** Git & GitHub
* **Interface:** JavaFX & Scene Builder
