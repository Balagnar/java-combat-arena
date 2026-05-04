# 🛡️ Java Combat Arena

Um simulador de combate em turnos desenvolvido em **Java**. Este projeto foi criado para exercitar lógica de programação, manipulação de objetos e a integração de interfaces gráficas com o motor de jogo.

# 🚀 Funcionalidades

- **Combate por Turnos:** O jogador (Guerreiro) enfrenta inimigos em um duelo de vida ou morte.
- **Sistema de Spawn Misterioso:** A arena utiliza a classe `Random` para sortear o inimigo, mas a identidade dele só é revelada ao iniciar o ataque.
- **Habilidades de Classe:** Implementação de mecânicas únicas, como a **Ressurreição** do Esqueleto (habilidade `remontar`).
- **POO Avançado:** Uso intenso de Herança e Polimorfismo (`Inimigo` -> `Esqueleto` / `Slime`) para comportamentos dinâmicos na UI.
- **Interface Reativa:** Barras de vida e logs de combate que se atualizam em tempo real via JavaFX.

### Personagens Atuais:
* **Herói:** Soldado destemido com mecânicas de defesa.
* **Esqueleto:** Guerreiro morto-vivo que possui a capacidade de se remontar uma vez após cair.
* **Slime:** Criatura viscosa básica, ideal para testes de dano.

## 🚀 Progresso do Desenvolvimento
- [x] Lógica de combate funcional (Ataque/Dano/Esquiva).
- [x] Implementação de Barras de Vida dinâmicas (ProgressBar).
- [x] Sistema de Sorteio de Inimigos (Randomização de Arena).
- [x] Mecânica de Ressurreição Lógica.
- [ ] Sistema de animações básicas (Idle/Attack).
- [ ] Sistema de itens e inventário de cura.

# 🪵 Histórico de Versões

## [v1.5.0] - Inventário e Mecânicas de Itens (Atual)
- **Sistema de Inventário:** Implementação de `ArrayList` na classe `Guerreiro` para gestão de itens.
- **Hierarquia POO Avançada:** Uso de herança entre `Guerreiro` e `Inimigo` para otimização de código.
- **Mecânica de Itens:** Preparação do método `usoItem` para interações de cura e buffs.
  
## [v1.4.0] - Mecânicas de Especialização (Novo / Atual)
- **Habilidade "Remontar":** Implementação lógica na classe `Esqueleto` que permite reviver com parte do HP após a primeira derrota.
- **Identidade Oculta:** O inimigo sorteado agora permanece em "mistério" até o primeiro comando de ataque do jogador.
- **Sorteio Dinâmico:** Implementação de spawn aleatório usando a classe `Random` na lógica da Arena.
- **Versionamento de Branch:** Criação da branch `feat/v1.4.0` para isolar o desenvolvimento dessas novas mecânicas.

## [v1.3.0] - Sistema de Sorteio e Novos Inimigos
- **Sorteio de Arena:** Lógica inicial para instanciar inimigos aleatórios no início do jogo.
- **Polimorfismo de UI:** O controlador identifica o tipo de inimigo e atualiza a imagem e status dinamicamente.
- **Bugfix (Sanitização):** Proteção contra HP negativo nas barras de vida usando `Math.max`.

## [v1.2.1] - Reset de Instância e Morte Dinâmica
- **Sistema de Reset:** Lógica para reiniciar o jogo criando uma nova instância limpa da Arena.
- **Feedback Visual de Derrota:** Adição de estados visuais para morte (Guerreiro vira lápide e Slime vira poça).
- **Botão Inteligente:** O botão de "Atacar" transforma-se em "Reiniciar" automaticamente ao fim do combate.

## [v1.0.0] - Integração com Scene Builder e FXML
- **Design Visual:** Transição do layout construído via código para o uso de arquivos `.fxml`.
- **Separação de Responsabilidades:** Implementação do padrão MVC com classes `Controller`.

## [v0.6.0] - Correção de Lógica e Estrutura
- **Cálculo de Dano:** Ajustes na fórmula de combate.
- **Hierarquia de Pastas:** Organização de diretórios (`src/assets`) para facilitar o desenvolvimento.

## [v0.0.1] - Base do Sistema (Ponto Zero)
- **Core do Jogo:** Lógica base de combate via console.

# 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+ (Recomendado Java 21)
* **Interface:** JavaFX & Scene Builder
* **Versionamento:** Git (Branching Model)

# 🎮 Como Executar

### Pré-requisitos
* Ter o **Java JDK** (17 ou superior) instalado.
* Biblioteca **JavaFX** configurada no seu ambiente de desenvolvimento.

### Execução
1. Clone o repositório.
2. Certifique-se de que as imagens em `/assets/` estão no caminho correto.
3. Execute a classe principal que carrega o FXML.
