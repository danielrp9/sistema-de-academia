# 🏋️ Sistema de Gestão de Academia

Sistema backend desenvolvido em **Java** com foco em **Programação Orientada a Objetos**, simulando a operação completa de uma academia (clientes, reservas, financeiro e controle de acesso).

> 💡 Projeto focado em modelagem de domínio, organização de código e aplicação prática de padrões de projeto.

---

## 🚀 Visão Geral

Este sistema foi projetado para resolver problemas comuns de gestão de academias, como:

* Controle de acesso de clientes
* Gerenciamento de reservas de aulas
* Organização de funcionários
* Controle financeiro e relatórios

Toda a lógica foi estruturada com base em **boas práticas de orientação a objetos**, priorizando **manutenibilidade e clareza de código**.

---

## ⚙️ Funcionalidades

* 🔐 Autenticação de usuários (Administrador e Funcionário)
* 👥 Gestão completa de clientes e equipe
* 📅 Sistema de agendamento com confirmação e cancelamento
* 🏋️ Controle de salas (Musculação, Pilates, Spinning, etc.)
* 🚪 Simulação de integração com catraca
* 🛒 Controle de produtos e estoque
* 💰 Gestão financeira (receitas, despesas e balanços)
* 📊 Relatórios diários e mensais
* 💾 Persistência de dados em JSON

---

## 🧩 Arquitetura e Decisões Técnicas

* Separação de responsabilidades por domínio (Clientes, Financeiro, Reservas)
* Uso de **Collections Framework** para gerenciamento eficiente de dados
* Implementação de ordenação e busca:

  * `Collections.sort`
  * `binarySearch`
  * busca manual com `Iterator`
* Aplicação do padrão de projeto **Memento** para controle de estado
* Estrutura pensada para fácil extensão (novas funcionalidades)

---

## 🧠 Conceitos Aplicados

* Orientação a Objetos (encapsulamento, herança, polimorfismo)
* Interfaces e uso de `Comparator`
* Manipulação de estruturas de dados
* Persistência em arquivos JSON
* Modelagem UML

---

## ▶️ Como Executar

```bash
# Clone o repositório
git clone https://github.com/seu-repo.git

# Compile o projeto
javac Main.java

# Execute
java Main
```

---

## 📌 Exemplos de Uso

O sistema permite simular:

* Cadastro e autenticação de usuários
* Criação e gerenciamento de reservas
* Geração de relatórios financeiros
* Controle de entrada e saída via catraca

---

## 📁 Estrutura do Projeto

Principais entidades:

* Cliente, Funcionário, Administrador
* Reserva, SalaDeExercicio
* Produto, Estoque, Venda
* Pagamento, Despesa
* Relatório, GerenciamentoFinanceiro

---

## 📚 Documentação

* JavaDoc completo
* Diagramas UML:

  * Casos de uso
  * Classes
  * Sequência
  * Estados

---

## 🎓 Contexto

Projeto desenvolvido na disciplina de **Programação Orientada a Objetos**
Curso de **Sistemas de Informação — UFVJM**

---

## 👨‍💻 Autor

**Daniel Rodrigues Pereira**
Desenvolvedor Backend | Java | POO


