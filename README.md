# Sistema de Controle de Estacionamento - Etapa 2

Trabalho final da disciplina de Programação Orientada a Objetos (POO), consistindo na implementação do sistema planejado na Etapa 1, utilizando Java e interface gráfica com Swing.

## 👥 Integrantes da Equipe
* **Vitor Aguiar Batista**
* **Otavio Ferreira**

**Instituição:** UNIUBE  
**Curso:** Grande Área de Computação  
**Disciplina:** Programação Orientada a Objetos  
**Professor:** Dr. Camilo Barreto

---

## 📝 Descrição do Projeto
Este sistema tem como objetivo modernizar e automatizar o gerenciamento de um estacionamento. Ele permite o controle de fluxo de veículos (entrada e saída), cálculo automático de valores com base no tempo de permanência e geração de relatórios financeiros simples.

O projeto foi desenvolvido aplicando os conceitos fundamentais de POO e implementando uma interface gráfica amigável para o usuário final.

> **Nota:** Conforme as instruções da Etapa 2, os dados são mantidos em memória durante a execução (não há persistência em banco de dados neste momento).

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
* **IDE Recomendada:** NetBeans, IntelliJ IDEA ou Eclipse.
* **Versionamento:** Git e GitHub.

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

1.  **Clonar o Repositório:**
    ```bash
    git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)
    ```

2.  **Importar na IDE:**
    * Abra sua IDE (NetBeans, IntelliJ, etc.).
    * Selecione a opção de "Abrir Projeto" ou "Importar Projeto" e aponte para a pasta clonada.

3.  **Executar:**
    * Localize a classe principal: `src/app/Main.java`.
    * Clique com o botão direito e selecione **Run** (Executar).
    * A janela do sistema deverá abrir automaticamente.

---

## 📋 Estrutura de Pastas
O projeto está organizado nos seguintes pacotes para melhor separação de responsabilidades:

* `model`: Classes de domínio (Veiculo, Carro, Moto, Ticket).
* `service`: Regras de negócio e gerenciamento da lista de veículos.
* `view`: Classes da interface gráfica (Swing).
* `app`: Classe inicializadora (Main).

---

**Data de Entrega:** 11/12/2025
