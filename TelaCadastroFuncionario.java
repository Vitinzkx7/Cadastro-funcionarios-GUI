package visao;

import modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaCadastroFuncionario extends JFrame {

    // Componentes da interface
    private JComboBox<String> cmbTipoFunc;
    private JTextField txtNome;
    private JTextField txtSalario;
    private JTextField txtDepartamento;
    private JComboBox<String> cmbNivel;
    private JTextField txtEscola;
    private JTextField txtQtMeses;
    private JTextArea txtAreaSaida;
    private JButton btnCadastrar;
    private JButton btnExibir;
    private JButton btnLimpar;


    private JLayeredPane layeredPane;
    private JPanel pnlGerente;
    private JPanel pnlDesenvolvedor;
    private JPanel pnlEstagiario;


    private ArrayList<Funcionario> listaFuncionarios;

    public TelaCadastroFuncionario() {
        listaFuncionarios = new ArrayList<>();
        initComponents();
        atualizarPainelCargo();
    }

    private void initComponents() {
        setTitle("Cadastro de Funcionários - Sistema RH");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 245));

        // Painel superior com título
        JPanel pnlTitulo = new JPanel();
        pnlTitulo.setBackground(new Color(70, 130, 180));
        pnlTitulo.setPreferredSize(new Dimension(800, 60));
        JLabel lblTitulo = new JLabel("Cadastro de Funcionários - Sistema RH");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        pnlTitulo.add(lblTitulo);
        add(pnlTitulo, BorderLayout.NORTH);

        // Painel central com formulário
        JPanel pnlCentral = new JPanel();
        pnlCentral.setLayout(new BoxLayout(pnlCentral, BoxLayout.Y_AXIS));
        pnlCentral.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnlCentral.setBackground(new Color(240, 240, 245));

        // Dados gerais
        JPanel pnlGeral = criarPainelComTitulo("Dados Gerais");
        pnlGeral.setPreferredSize(new Dimension(750, 140));

        JPanel pnlNome = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        pnlNome.setBackground(Color.WHITE);
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setPreferredSize(new Dimension(100, 25));
        lblNome.setFont(new Font("Arial", Font.BOLD, 12));
        pnlNome.add(lblNome);
        txtNome = new JTextField(35);
        txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
        pnlNome.add(txtNome);
        pnlGeral.add(pnlNome);

        JPanel pnlSalario = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        pnlSalario.setBackground(Color.WHITE);
        JLabel lblSalario = new JLabel("Salário Base:");
        lblSalario.setPreferredSize(new Dimension(100, 25));
        lblSalario.setFont(new Font("Arial", Font.BOLD, 12));
        pnlSalario.add(lblSalario);
        txtSalario = new JTextField(20);
        txtSalario.setFont(new Font("Arial", Font.PLAIN, 12));
        pnlSalario.add(txtSalario);
        pnlGeral.add(pnlSalario);

        JPanel pnlCargo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        pnlCargo.setBackground(Color.WHITE);
        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setPreferredSize(new Dimension(100, 25));
        lblCargo.setFont(new Font("Arial", Font.BOLD, 12));
        pnlCargo.add(lblCargo);
        cmbTipoFunc = new JComboBox<>(new String[]{"Gerente", "Desenvolvedor", "Estagiário"});
        cmbTipoFunc.setFont(new Font("Arial", Font.PLAIN, 12));
        cmbTipoFunc.setPreferredSize(new Dimension(200, 25));
        cmbTipoFunc.addActionListener(e -> atualizarPainelCargo());
        pnlCargo.add(cmbTipoFunc);
        pnlGeral.add(pnlCargo);

        pnlCentral.add(pnlGeral);
        pnlCentral.add(Box.createVerticalStrut(15));

        // Exercício 1: Criando JLayeredPane para sobreposição
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(750, 160));

        // Painel Gerente
        pnlGerente = criarPainelComTitulo("Dados do Gerente");
        pnlGerente.setBounds(0, 0, 750, 160);
        JPanel pnlDepContent = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        pnlDepContent.setBackground(Color.WHITE);
        JLabel lblDep = new JLabel("Departamento:");
        lblDep.setPreferredSize(new Dimension(100, 25));
        lblDep.setFont(new Font("Arial", Font.BOLD, 12));
        pnlDepContent.add(lblDep);
        txtDepartamento = new JTextField(35);
        txtDepartamento.setFont(new Font("Arial", Font.PLAIN, 12));
        pnlDepContent.add(txtDepartamento);
        pnlGerente.add(pnlDepContent);
        layeredPane.add(pnlGerente, Integer.valueOf(1));

        // Painel Desenvolvedor
        pnlDesenvolvedor = criarPainelComTitulo("Dados do Desenvolvedor");
        pnlDesenvolvedor.setBounds(0, 0, 750, 160);
        JPanel pnlNivelContent = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        pnlNivelContent.setBackground(Color.WHITE);
        JLabel lblNivel = new JLabel("Nível:");
        lblNivel.setPreferredSize(new Dimension(100, 25));
        lblNivel.setFont(new Font("Arial", Font.BOLD, 12));
        pnlNivelContent.add(lblNivel);
        // Exercício 2: Usando JComboBox em vez de JTextField
        cmbNivel = new JComboBox<>(new String[]{"Júnior", "Pleno", "Sênior"});
        cmbNivel.setFont(new Font("Arial", Font.PLAIN, 12));
        cmbNivel.setPreferredSize(new Dimension(200, 25));
        pnlNivelContent.add(cmbNivel);
        pnlDesenvolvedor.add(pnlNivelContent);
        layeredPane.add(pnlDesenvolvedor, Integer.valueOf(2));

        // Painel Estagiário
        pnlEstagiario = criarPainelComTitulo("Dados do Estagiário");
        pnlEstagiario.setBounds(0, 0, 750, 160);

        JPanel pnlEscolaContent = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        pnlEscolaContent.setBackground(Color.WHITE);
        JLabel lblEscola = new JLabel("Escola:");
        lblEscola.setPreferredSize(new Dimension(120, 25));
        lblEscola.setFont(new Font("Arial", Font.BOLD, 12));
        pnlEscolaContent.add(lblEscola);
        txtEscola = new JTextField(35);
        txtEscola.setFont(new Font("Arial", Font.PLAIN, 12));
        pnlEscolaContent.add(txtEscola);
        pnlEstagiario.add(pnlEscolaContent);

        JPanel pnlMesesContent = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        pnlMesesContent.setBackground(Color.WHITE);
        JLabel lblMeses = new JLabel("Meses de Estágio:");
        lblMeses.setPreferredSize(new Dimension(120, 25));
        lblMeses.setFont(new Font("Arial", Font.BOLD, 12));
        pnlMesesContent.add(lblMeses);
        txtQtMeses = new JTextField(10);
        txtQtMeses.setFont(new Font("Arial", Font.PLAIN, 12));
        pnlMesesContent.add(txtQtMeses);
        pnlEstagiario.add(pnlMesesContent);

        layeredPane.add(pnlEstagiario, Integer.valueOf(3));

        pnlCentral.add(layeredPane);
        pnlCentral.add(Box.createVerticalStrut(15));

        // Painel de Botões com ícones e textos
        JPanel pnlBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        pnlBotoes.setBackground(new Color(240, 240, 245));

        // Botão Cadastrar
        btnCadastrar = new JButton("💾 Cadastrar");
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCadastrar.setPreferredSize(new Dimension(150, 40));
        btnCadastrar.setBackground(new Color(60, 179, 113));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(46, 139, 87), 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(e -> cadastrarFuncionario());

        // Botão Exibir
        btnExibir = new JButton("📋 Exibir Dados");
        btnExibir.setFont(new Font("Arial", Font.BOLD, 14));
        btnExibir.setPreferredSize(new Dimension(150, 40));
        btnExibir.setBackground(new Color(70, 130, 180));
        btnExibir.setForeground(Color.WHITE);
        btnExibir.setFocusPainted(false);
        btnExibir.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(51, 102, 153), 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        btnExibir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExibir.addActionListener(e -> exibirDados());

        // Botão Limpar
        btnLimpar = new JButton("🗑️ Limpar");
        btnLimpar.setFont(new Font("Arial", Font.BOLD, 14));
        btnLimpar.setPreferredSize(new Dimension(150, 40));
        btnLimpar.setBackground(new Color(220, 20, 60));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.setFocusPainted(false);
        btnLimpar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(178, 34, 34), 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        btnLimpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(e -> limparCampos());

        pnlBotoes.add(btnCadastrar);
        pnlBotoes.add(btnExibir);
        pnlBotoes.add(btnLimpar);
        pnlCentral.add(pnlBotoes);
        pnlCentral.add(Box.createVerticalStrut(10));

        // Área de saída
        JPanel pnlSaida = criarPainelComTitulo("📊 Resultado");
        pnlSaida.setPreferredSize(new Dimension(750, 280));
        txtAreaSaida = new JTextArea(14, 60);
        txtAreaSaida.setEditable(false);
        txtAreaSaida.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtAreaSaida.setBackground(new Color(250, 250, 250));
        JScrollPane scrollPane = new JScrollPane(txtAreaSaida);
        scrollPane.setPreferredSize(new Dimension(720, 240));
        pnlSaida.add(scrollPane);
        pnlCentral.add(pnlSaida);

        add(pnlCentral, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private JPanel criarPainelComTitulo(String titulo) {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(70, 130, 180), 2),
                titulo,
                javax.swing.border.TitledBorder.LEFT,
                javax.swing.border.TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 13),
                new Color(70, 130, 180)
        ));
        return painel;
    }

    // Método responsável por atualizar a exibição dos painéis
    // conforme o tipo de funcionário selecionado no ComboBox
    private void atualizarPainelCargo() {
        String cargo = (String) cmbTipoFunc.getSelectedItem();

        // Oculta todos os painéis
        pnlGerente.setVisible(false);
        pnlDesenvolvedor.setVisible(false);
        pnlEstagiario.setVisible(false);

        // Exibe apenas o painel correspondente
        switch (cargo) {
            case "Gerente":
                pnlGerente.setVisible(true);
                layeredPane.moveToFront(pnlGerente);
                break;
            case "Desenvolvedor":
                pnlDesenvolvedor.setVisible(true);
                layeredPane.moveToFront(pnlDesenvolvedor);
                break;
            case "Estagiário":
                pnlEstagiario.setVisible(true);
                layeredPane.moveToFront(pnlEstagiario);
                break;
        }

        pack();
    }

    // Método para cadastrar um funcionário
    private void cadastrarFuncionario() {
        try {
            String nome = txtNome.getText().trim();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, informe o nome!",
                        "⚠️ Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String salarioTexto = txtSalario.getText().trim();
            if (salarioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, informe o salário!",
                        "⚠️ Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double salario = Double.parseDouble(salarioTexto);

            if (salario <= 0) {
                JOptionPane.showMessageDialog(this,
                        "O salário deve ser maior que zero!",
                        "⚠️ Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String cargo = cmbTipoFunc.getSelectedItem().toString();

            Funcionario novoFuncionario = null;

            switch (cargo.toLowerCase()) {
                case "gerente":
                    String dep = txtDepartamento.getText().trim();
                    if (dep.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                                "Por favor, informe o departamento!",
                                "⚠️ Erro de Validação",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    novoFuncionario = new Gerente(nome, salario, dep);
                    break;

                case "desenvolvedor":
                    // Exercício 2: Pegando valor do JComboBox
                    String nivel = (String) cmbNivel.getSelectedItem();
                    novoFuncionario = new Desenvolvedor(nome, salario, nivel);
                    break;

                case "estagiário":
                    String escola = txtEscola.getText().trim();
                    if (escola.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                                "Por favor, informe a escola!",
                                " Erro de Validação",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String mesesTexto = txtQtMeses.getText().trim();
                    if (mesesTexto.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                                "Por favor, informe os meses de estágio!",
                                " Erro de Validação",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int meses = Integer.parseInt(mesesTexto);

                    if (meses <= 0) {
                        JOptionPane.showMessageDialog(this,
                                "Os meses de estágio devem ser maior que zero!",
                                " Erro de Validação",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    novoFuncionario = new Estagiario(nome, salario, escola, meses);
                    break;
            }

            // Exercício 3: Adiciona à lista
            listaFuncionarios.add(novoFuncionario);

            JOptionPane.showMessageDialog(this,
                    "✅ Funcionário cadastrado com sucesso!\n\n" +
                            "Nome: " + nome + "\n" +
                            "Cargo: " + cargo + "\n" +
                            "Total de funcionários: " + listaFuncionarios.size(),
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    " Erro: Verifique os valores numéricos!\n\n" +
                            "- Salário deve conter apenas números\n" +
                            "- Meses de estágio deve ser um número inteiro",
                    "Erro de Formato",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Exercício 3: Método para exibir TODOS os funcionários cadastrados
    private void exibirDados() {
        if (listaFuncionarios.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    " Nenhum funcionário cadastrado ainda!\n\nCadastre um funcionário primeiro.",
                    "Lista Vazia",
                    JOptionPane.WARNING_MESSAGE);
            txtAreaSaida.setText("");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════╗\n");
        sb.append("║          LISTA DE FUNCIONÁRIOS CADASTRADOS - SISTEMA RH           ║\n");
        sb.append("╚════════════════════════════════════════════════════════════════════╝\n\n");

        for (int i = 0; i < listaFuncionarios.size(); i++) {
            Funcionario func = listaFuncionarios.get(i);

            sb.append("┌─────────────────────────────────────────────────────────────────┐\n");
            sb.append("│ FUNCIONÁRIO #").append(String.format("%02d", i + 1)).append("                                                  │\n");
            sb.append("└─────────────────────────────────────────────────────────────────┘\n");

            sb.append("  Nome: ").append(func.getNome()).append("\n");
            sb.append("  Tipo: ").append(func.getClass().getSimpleName()).append("\n");
            sb.append("  Salário Base: R$ ").append(String.format("%.2f", func.getSalarioBase())).append("\n");

            // Verifica se implementa Bonus
            if (func instanceof Bonus) {
                Bonus funcComBonus = (Bonus) func;
                sb.append("  Bônus: R$ ").append(String.format("%.2f", funcComBonus.calcularBonus())).append("\n");
            } else {
                sb.append("  Bônus: Não recebe\n");
            }

            sb.append("  Salário Final: R$ ").append(String.format("%.2f", func.calcularSalarioFinal())).append("\n");

            // Informações específicas
            if (func instanceof Gerente) {
                Gerente g = (Gerente) func;
                sb.append("  Departamento: ").append(g.getDepartamento()).append("\n");
            } else if (func instanceof Desenvolvedor) {
                Desenvolvedor d = (Desenvolvedor) func;
                sb.append("  Nível: ").append(d.getNivel()).append("\n");
            } else if (func instanceof Estagiario) {
                Estagiario e = (Estagiario) func;
                sb.append("  Escola: ").append(e.getEscola()).append("\n");
                sb.append("  Meses de Estágio: ").append(e.getMesesEstagio()).append("\n");
            }

            sb.append("\n");
        }

        sb.append("═══════════════════════════════════════════════════════════════════\n");
        sb.append("   TOTAL DE FUNCIONÁRIOS CADASTRADOS: ").append(listaFuncionarios.size()).append("\n");
        sb.append("═══════════════════════════════════════════════════════════════════\n");

        txtAreaSaida.setText(sb.toString());
        txtAreaSaida.setCaretPosition(0); // Rola para o topo
    }

    // Método para limpar todos os campos
    private void limparCampos() {
        int opcao = JOptionPane.showConfirmDialog(this,
                "Deseja realmente limpar todos os campos?",
                "Confirmar Limpeza",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcao == JOptionPane.YES_OPTION) {
            txtNome.setText("");
            txtSalario.setText("");
            txtDepartamento.setText("");
            cmbNivel.setSelectedIndex(0); // Exercício 2: Resetando o combo
            txtEscola.setText("");
            txtQtMeses.setText("");
            txtAreaSaida.setText("");
            cmbTipoFunc.setSelectedIndex(0);
            atualizarPainelCargo();
            txtNome.requestFocus(); // Coloca o foco no primeiro campo
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Tenta usar o Look and Feel do sistema
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            TelaCadastroFuncionario tela = new TelaCadastroFuncionario();
            tela.setVisible(true);
        });
    }
}