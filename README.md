# 🛡️ Java Combat Arena

Um simulador de combate em turnos desenvolvido em **Java**. Este projeto foi criado para exercitar lógica de programação, manipulação de objetos e estruturas de controle.

# 🚀 Funcionalidades

- **Combate por Turnos:** O jogador (Guerreiro) enfrenta um Boss em um duelo de vida ou morte.
- **Lógica de Atributos:** Uso de HP e Dano para calcular os resultados de cada rodada.
- **Aleatoriedade:** Implementação da classe `Random` para variar o dano dos ataques e tornar os duelos dinâmicos.
- **POO:** Estrutura baseada em classes (`Guerreiro`, `Arena`, `Boss`, `Main`) para garantir um código organizado e escalável.

### Personagens Atuais:
* **Herói:** Um soldado destemido pronto para a batalha.
* **Inimigo:** Um Orc enfurecido (substituindo o antigo Slime).

## 🚀 Progresso do Desenvolvimento
- [x] Lógica de combate funcional (Ataque/Dano).
- [x] Organização de diretórios (`src/assets`).
- [x] Implementação de Sprites (Soldier e Orc).
- [ ] Implementação de Barras de Vida (ProgressBar).
- [ ] Sistema de animações básicas (Idle/Attack).

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

### Executando via Terminal
1. Navegue até a pasta raiz do projeto.
2. Compile os arquivos (exemplo para estrutura com pacotes):
   ```bash
   javac --module-path /caminho/para/javafx/lib --add-modules javafx.controls,javafx.fxml DESAFIOGEMINI/BATALHA/*.java
