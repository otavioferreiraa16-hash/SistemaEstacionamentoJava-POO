# Sistema de Controle de Estacionamento

Trabalho final da disciplina de Programação Orientada a Objetos (POO), utilizando Java e interface gráfica com Swing.

## 👥 Integrantes da Equipe
* **Vitor Aguiar Batista**
* **Otavio Ferreira Alves**

**Instituição:** UNIUBE  
**Curso:** Sistemas de Infomação  
**Disciplina:** Programação Orientada a Objetos  
**Professor:** Dr. Camilo Barreto

---

## 📝 Descrição do Projeto
Este sistema tem como objetivo modernizar e automatizar o gerenciamento de um estacionamento. Ele permite o controle de fluxo de veículos (entrada e saída), cálculo automático de valores com base no tempo de permanência e geração de relatórios financeiros simples.

O projeto foi desenvolvido aplicando os conceitos fundamentais de POO e implementando uma interface gráfica amigável para o usuário final.


---

## 🚀 Funcionalidades
O sistema atende aos requisitos funcionais definidos na Etapa 1:

1.  **Cadastro de Entrada:** Registro de veículos informando Placa, Modelo, Cor e Tipo (Carro ou Moto).
2.  **Controle de Pátio:** Visualização em tabela de todos os veículos estacionados no momento.
3.  **Registro de Saída:** Cálculo automático do valor a pagar baseado no tempo de permanência e no tipo do veículo.
4.  **Relatórios:** Geração de um histórico de movimentações e total arrecadado.

---

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java (JDK 17 ou superior recomendado).
* **Interface Gráfica:** Java Swing (Biblioteca padrão).
* **IDE:** IntelliJ IDEA.
* **Versionamento:** GitHub.

---

## 📚 Aplicação dos Conceitos de POO
O código fonte demonstra o domínio dos seguintes pilares da orientação a objetos, conforme exigido na avaliação:

* **Classes e Objetos:** Modelagem das entidades principais (`Veiculo`, `Ticket`, `EstacionamentoService`).
* **Encapsulamento:** Todos os atributos das classes de domínio são privados (`private`) e acessados via métodos `get` e `set`.
* **Herança:** As classes `Carro` e `Moto` herdam características da classe base `Veiculo`.
* **Polimorfismo:** O método `getFatorPreco()` é sobrescrito nas subclasses. O cálculo do valor final trata `Carro` (fator 1.0) e `Moto` (fator 0.8) de formas distintas, mas transparente para a classe `Ticket`.
* **Abstração:** A classe `Veiculo` é abstrata (`abstract`), impedindo a criação de veículos genéricos sem tipo definido.
* **Interface:** Utilização da interface `Imprimivel` para padronizar a formatação de textos de relatório na classe `Ticket`.

---

## ⚙️ Como Compilar e Executar

Você pode executar o projeto de duas formas: utilizando uma IDE (recomendado para desenvolvimento) ou diretamente pelo terminal (recomendado para testes rápidos).

### Opção 1: Via IDE (NetBeans, IntelliJ, Eclipse)
1.  Faça o download do projeto ou clone o repositório:
    ```bash
    git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)
    ```
2.  Abra sua IDE e selecione a opção **Open Project** (Abrir Projeto) ou **Import Project**.
3.  Selecione a pasta do repositório clonado.
4.  Localize a classe principal em `src/app/Main.java`.
5.  Clique com o botão direito e selecione **Run** (Executar).

### Opção 2: Via Terminal (Linha de Comando)
Caso não queira usar uma IDE, certifique-se de ter o JDK instalado e configurado no seu PATH.

1.  **Clone o repositório e entre na pasta:**
    ```bash
    git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)
    cd NOME_DO_REPOSITORIO
    ```

2.  **Compile o código:**
    (Este comando cria uma pasta `bin` e compila os arquivos Java que estão em `src`)
    
    *Linux / MacOS:*
    ```bash
    javac -d bin -sourcepath src src/app/Main.java
    ```
    
    *Windows (PowerShell ou CMD):*
    ```powershell
    javac -d bin -sourcepath src src\app\Main.java
    ```

3.  **Execute a aplicação:**
    ```bash
    java -cp bin app.Main
    ```

---

## 📋 Estrutura de Pastas
O projeto está organizado nos seguintes pacotes para melhor separação de responsabilidades (Arquitetura MVC simplificada):

* `src/model`: Classes de domínio (Veiculo, Carro, Moto, Ticket).
* `src/service`: Regras de negócio e gerenciamento da lista de veículos.
* `src/view`: Classes da interface gráfica (Telas Swing).
* `src/app`: Classe inicializadora (Main).

---
