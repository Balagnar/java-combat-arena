# 🛡️ Java Combat Arena

Um simulador de combate em turnos desenvolvido em **Java**. Este projeto foi criado para exercitar lógica de programação, manipulação de objetos e estruturas de controle.

## 🚀 Funcionalidades

- **Combate por Turnos:** O jogador (Guerreiro) enfrenta um Boss em um duelo de vida ou morte.
- **Lógica de Atributos:** Uso de HP, Dano e Defesa para calcular os resultados de cada rodada.
- **Aleatoriedade:** Implementação da classe `Random` para variar o dano dos ataques e tornar os duelos dinâmicos.
- **POO:** Estrutura baseada em classes (`Guerreiro`, `Arena`, `Boss`) para garantir um código organizado e escalável.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Versionamento:** Git & GitHub

## 🎮 Como Executar

Para rodar o simulador corretamente respeitando a estrutura de pacotes, siga estes passos no terminal:

1. **Vá para a pasta raiz do projeto:**
   ```bash
   cd /c/Angelo/Java
   
2. **Compile todos os arquivos da Arena:**
   ```bash
   javac DESAFIOGEMINI/BATALHA/*.java

3. **Execute o programa apontando o Classpath:**
   ```bash
   java -cp DESAFIOGEMINI BATALHA.Arena
