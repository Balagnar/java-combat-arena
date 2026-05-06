# 🛡️ Java Combat Arena: Torre de Ossos

Um simulador de RPG que evoluiu de uma interface estática em JavaFX para um mundo explorável em 2D utilizando o motor de jogos **LibGDX**. O projeto agora foca em renderização de mapas profissionais, câmeras dinâmicas e sistemas de animação por frames.

---

# 🚀 Funcionalidades da Nova Era (v2.0.0+)

- **Motor Gráfico Profissional:** Migração completa para o framework **LibGDX**, permitindo alta performance e controle total do ciclo de vida do jogo.
- **Sistema de Mapas (Tiled):** Integração com o editor *Tiled*, utilizando camadas de tiles e renderização via `OrthogonalTiledMapRenderer`.
- **Câmera Dinâmica:** Implementação de `OrthographicCamera` para controle de visualização, zoom e acompanhamento do personagem.
- **Gerenciamento de Sprites:** Uso de `TextureRegion` e `Animation` para processar spritesheets de personagens com estados de **Idle** e **Run**.
- **Resolução Retrô:** Janela configurada para **640x480**, otimizada para a estética de pixel art do projeto.

---

# 🪵 Histórico de Versões

## [v2.0.0] - A Era LibGDX (Atual)
- **Reboot do Motor:** Substituição do JavaFX pelo LibGDX (LWJGL3).
- **Arquitetura de Mapa:** Implementação de carregamento de arquivos `.tmx` e gerenciamento de camadas de colisão.
- **Versionamento Profissional:** Migração do histórico para a branch `feat/v2.0.0` para isolar o novo core do jogo.
- **Sistema de Herói:** Criação da classe `Jogador` com lógica de animação por tempo de estado (`stateTime`).

## [v1.5.0] - Legado JavaFX
- **Sistema de Inventário:** Implementação de `ArrayList` na classe `Guerreiro`.
- **Mecânica de Itens:** Base lógica para consumíveis e buffs de combate.

## [v1.4.0] - Especialização de Inimigos
- **Habilidade "Remontar":** Mecânica exclusiva do inimigo Esqueleto.
- **Identidade Oculta:** Inimigos randômicos revelados apenas no início do turno de ataque.

> *Consulte o histórico de commits para detalhes das versões [v0.0.1] até [v1.3.0].*

---

# 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Motor de Jogo:** LibGDX (Core, Lwjgl3)
* **Build Tool:** Gradle
* **Design de Mapas:** Tiled Map Editor
* **Versionamento:** Git (Branching Model: `main` & `feat/v2.0.0`)

---

# 🎮 Como Executar

### Pré-requisitos
* **Java JDK 17** ou superior.
* IDE com suporte a Gradle (IntelliJ IDEA, Android Studio ou VS Code).

### Passos
1. Clone o repositório: `git clone https://github.com/Balagnar/java-combat-arena.git`
2. Acesse a branch de desenvolvimento: `git checkout feat/v2.0.0`
3. Execute o projeto via terminal:
   ```bash
   ./gradlew lwjgl3:run
