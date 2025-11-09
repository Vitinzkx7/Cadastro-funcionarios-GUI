# Cadastro-funcionarios-GUI
 Sistema de cadastro de funcionários em Java com interface gráfica Swing.  Aplica POO (Herança, Polimorfismo, Interfaces) para gerenciar Gerentes,  Desenvolvedores e Estagiários com cálculo automático de bônus.

 # Sobre o Projeto
Sistema desenvolvido para gerenciar o cadastro de diferentes tipos de funcionários (Gerentes, Desenvolvedores e Estagiários) em uma empresa, com cálculo automático de bônus e salários finais. O projeto foi criado como parte da disciplina de Laboratório de Técnicas de Programação Orientada a Objetos.
 
 # Objetivos:

✅ Aplicar conceitos de Herança em Java
✅ Implementar Classes Abstratas e Interfaces
✅ Utilizar Polimorfismo de forma prática
✅ Criar uma Interface Gráfica intuitiva com Swing
✅ Gerenciar coleções com ArrayList
✅ Aplicar boas práticas de Encapsulamento


✨ Funcionalidades
🔹 Cadastro de Funcionários

Gerente: com departamento e bônus de 20%
Desenvolvedor: com nível (Júnior/Pleno/Sênior) e bônus variável

Júnior: 5%
Pleno: 10%
Sênior: 15%


Estagiário: com escola e meses de estágio (sem bônus)

🔹 Funcionalidades da Interface

 Cadastrar: Adiciona novos funcionários ao sistema
 Exibir Dados: Lista todos os funcionários cadastrados
 Limpar: Limpa os campos do formulário
 Atualização Dinâmica: Campos específicos aparecem conforme o cargo selecionado

🔹 Recursos Avançados

✅ Validação completa de dados
✅ Formatação monetária (R$ 0,00)
✅ Armazenamento múltiplo com ArrayList
✅ Interface responsiva com JLayeredPane
✅ Confirmação de ações críticas
✅ Mensagens informativas e de erro

# Arquitetura do Projeto
CadastroFuncionariosGUI/
│
├── src/
│   ├── modelo/                    # Camada de Modelo (Backend)
│   │   ├── Funcionario.java      # Classe abstrata base
│   │   ├── Bonus.java             # Interface para bônus
│   │   ├── Gerente.java           # Implementação de Gerente
│   │   ├── Desenvolvedor.java     # Implementação de Desenvolvedor
│   │   └── Estagiario.java        # Implementação de Estagiário
│   │
│   └── visao/                     # Camada de Visão (Frontend)
│       └── TelaCadastroFuncionario.java  # Interface gráfica
│
└── README.md

# Diagrama de Classes
Funcionario (abstract)
                    ├── nome: String
                    ├── salarioBase: double
                    └── calcularSalarioFinal(): double
                            ▲
                            │
            ┌───────────────┼───────────────┐
            │               │               │
        Gerente      Desenvolvedor    Estagiario
            │               │
            │               │
            └───────────────┴─── implements Bonus
                                  └── calcularBonus(): double

Como Usar: 

1️⃣ Cadastrar um Funcionário

Preencha o Nome e Salário Base
Selecione o Cargo desejado
Preencha os campos específicos que aparecem
Clique em Cadastrar

2️⃣ Visualizar Funcionários

Clique em Exibir Dados
A lista completa aparecerá na área de resultado
Informações incluem: nome, cargo, salários, bônus

3️⃣ Limpar Formulário

Clique em Limpar
Confirme a ação
Todos os campos serão resetados                                  
