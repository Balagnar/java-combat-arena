# 🛡️ Java Combat Arena: Torre de Ossos

Um simulador de RPG que evoluiu de uma interface estática em JavaFX para um mundo explorável em 2D utilizando o motor de jogos **LibGDX**. O projeto agora foca em mecânicas de **RPG de Turno**, com mapas profissionais, câmeras dinâmicas e sistemas de seleção por grid.

---

# 🚀 Funcionalidades da Nova Era (v2.4.0+)

- **Motor Gráfico Profissional:** Migração completa para o framework **LibGDX**, permitindo alta performance e controle total do ciclo de vida do jogo.
- **Sistema de Mapas (Tiled):** Integração com o editor *Tiled*, utilizando renderização via `OrthogonalTiledMapRenderer` para múltiplas camadas.
- **Câmera e Viewport Dinâmicos:** Implementação de `OrthographicCamera` e `FitViewport` (1280x955), garantindo que o jogo mantenha a proporção e escala correta em qualquer monitor.
- **Mouse Picker (Grid System):** Sistema de conversão de coordenadas (`unproject`) que traduz o clique do mouse na tela para colunas e linhas exatas do tabuleiro (Tiles de 64x64px).
- **Animações de Sprite:** Gerenciamento de spritesheets através de `TextureRegion` e `Animation`, permitindo estados de movimento e idle fluidos para os personagens.

---

# 🪵 Histórico de Versões

## [v2.4.0] - O Despertar do Tabuleiro (Atual)
- **Sistema de Grid:** Implementação de lógica matemática para transformar cliques de pixels em coordenadas de grade inteiras.
- **Ajuste de Proporção:** Configuração de `FitViewport` para evitar distorção visual e garantir precisão no clique.
- **Tratamento de Vetores:** Otimização do uso de `Vector3` para manipulação de coordenadas de entrada, corrigindo erros de inicialização (`NullPointerException`).
- **Refatoração do Ciclo de Render:** Organização da lógica de entrada para capturar ações apenas no instante do clique, otimizando o processamento.

## [v2.0.0] - A Era LibGDX
- **Reboot do Motor:** Substituição do JavaFX pelo LibGDX (LWJGL3).
- **Arquitetura de Mapa:** Implementação de carregamento de arquivos `.tmx` e renderização de tilesets.
- **Sistema de Herói:** Criação da classe `Characters` com suporte a animação por tempo de estado (`stateTime`).

## [v1.5.0] - Legado JavaFX
- **Sistema de Inventário:** Implementação de `ArrayList` na classe `Guerreiro`.
- **Mecânica de Itens:** Base lógica para consumíveis e buffs de combate.

---

# 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Motor de Jogo:** LibGDX (Core, Lwjgl3)
* **Build Tool:** Gradle
* **Design de Mapas:** Tiled Map Editor
* **Matemática:** Álgebra vetorial com `com.badlogic.gdx.math.Vector3`

---

# 🎮 Como Executar

### Pré-requisitos
* **Java JDK 17** ou superior.
* IDE com suporte a Gradle (IntelliJ IDEA, VS Code ou Android Studio).

### Passos
1. Clone o repositório: 
   ```bash
   git clone [https://github.com/Balagnar/java-combat-arena.git](https://github.com/Balagnar/java-combat-arena.git)
