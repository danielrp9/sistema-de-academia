# 🏋️ Sistema de Gestão de Academia — Java (POO)

Sistema backend desenvolvido em **Java** como projeto acadêmico da disciplina de **Programação Orientada a Objetos (POO)** na UFVJM.  
O projeto consiste na modelagem e implementação completa de um sistema de gestão para uma academia fictícia localizada em Milho Verde – MG, contemplando reservas, clientes, funcionários, controle financeiro e relatórios.

O foco principal foi aplicar **conceitos sólidos de orientação a objetos**, boas práticas de código e uso eficiente das **Collections Framework do Java**.

---

## 📌 Funcionalidades Principais

- Autenticação de usuários (Administrador e Funcionário)
- Cadastro, edição e remoção de:
  - Clientes
  - Funcionários e Administradores
- Gerenciamento de agendamentos:
  - Agendamentos preliminares e confirmação
  - Cancelamento com retenção parcial do valor
- Controle de salas de exercício:
  - Musculação
  - Pilates
  - Fit Dance
  - Spinning
- Integração lógica com sistema de **catraca** (entrada e saída de clientes)
- Controle de produtos da lojinha e estoque
- Registro de despesas da academia
- Geração de:
  - Relatórios diários e mensais
  - Balanço financeiro mensal
- Persistência de dados em arquivos **JSON**
- Testes completos de funcionalidades no método `main`

---

## 🧠 Conceitos de Programação Orientada a Objetos Aplicados

- Encapsulamento
- Herança
- Polimorfismo
- Sobrescrita de métodos (`toString`)
- Uso da palavra-chave `super`
- Classes e métodos `static`
- Interfaces (`Comparator`)
- Padrão de Projeto **Memento**
- Organização modular de responsabilidades

---

## 📊 Estruturas e Algoritmos Utilizados

- `ArrayList`, `List`
- `Iterator` e comparação com `foreach`
- Implementação de `Comparator` para:
  - Ordenação de clientes
  - Ordenação de agendamentos
- Uso de:
  - `Collections.sort()`
  - `Collections.binarySearch()`
- Implementação de método de busca manual (`find`) utilizando `Iterator`
- Comparação prática entre busca manual e `binarySearch`

---

## 🧪 Testes e Execução

Todas as funcionalidades do sistema são testadas diretamente no método `main`, incluindo:

- Percorrer listas com `Iterator` e `foreach`
- Ordenação com diferentes critérios
- Busca manual vs busca binária
- Criação, alteração e remoção de entidades
- Geração de relatórios e balanços

---

## 🗂️ Principais Classes do Sistema

- `Sistema`
- `Menu`
- `Cliente`
- `Funcionario`
- `Administrador`
- `SalaDeExercicio`
- `Reserva`
- `Produto`
- `Estoque`
- `Venda`
- `Pagamento`
- `Despesa`
- `Relatorio`
- `GerenciamentoFinanceiro`
- `Catraca`
- `Login`
- `ClienteComparatorPorCPF`
- `Memento` e `Caretaker`

---

## 📁 Persistência de Dados

- Armazenamento e recuperação de dados em arquivos **JSON**
- Uso de boas práticas para alocação e liberação de recursos
- Persistência de:
  - Clientes
  - Agendamentos
  - Produtos
  - Relatórios
  - Funcionários

---

## 📚 Documentação

- Projeto documentado com **JavaDoc**
- Modelagem UML completa:
  - Diagrama de Casos de Uso
  - Diagramas de Sequência
  - Diagrama de Estados
  - Diagrama de Classes

---

## 🛠️ Tecnologias Utilizadas

- Java
- Java Collections Framework
- JSON
- UML
- JavaDoc

---

## 🎓 Contexto Acadêmico

Projeto desenvolvido como parte da disciplina **Programação Orientada a Objetos**, ministrada pelo professor **Eduardo Pelli**, no curso de **Sistemas de Informação** da **UFVJM**.

---

## 👨‍💻 Autor

**Daniel Rodrigues Pereira**  
Desenvolvedor Full Stack | Java | POO | Backend  
[LinkedIn](https://www.linkedin.com/) • [GitHub](https://github.com/)
