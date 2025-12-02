package view;

import model.*;
import service.EstacionamentoService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {

    private EstacionamentoService service;
    private JTabbedPane tabbedPane;

    private JTextField txtPlaca, txtModelo, txtCor;
    private JRadioButton rbCarro, rbMoto;
    private ButtonGroup gpTipo;

    private JTable tabelaAtivos;
    private DefaultTableModel modeloTabelaAtivos;
    private JTextArea txtLog;

    public MainFrame() {
        service = new EstacionamentoService();
        setTitle("Sistema de Estacionamento - POO Etapa 2");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();

        JPanel panelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; panelEntrada.add(new JLabel("Placa:"), gbc);
        gbc.gridx = 1; txtPlaca = new JTextField(15); panelEntrada.add(txtPlaca, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panelEntrada.add(new JLabel("Modelo:"), gbc);
        gbc.gridx = 1; txtModelo = new JTextField(15); panelEntrada.add(txtModelo, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panelEntrada.add(new JLabel("Cor:"), gbc);
        gbc.gridx = 1; txtCor = new JTextField(15); panelEntrada.add(txtCor, gbc);

        JPanel panelTipo = new JPanel();
        rbCarro = new JRadioButton("Carro", true);
        rbMoto = new JRadioButton("Moto");
        gpTipo = new ButtonGroup();
        gpTipo.add(rbCarro); gpTipo.add(rbMoto);
        panelTipo.add(rbCarro); panelTipo.add(rbMoto);

        gbc.gridx = 1; gbc.gridy = 3; panelEntrada.add(panelTipo, gbc);

        JButton btnEntrada = new JButton("Registrar Entrada");
        btnEntrada.addActionListener(e -> acaoRegistrarEntrada());
        gbc.gridx = 1; gbc.gridy = 4; panelEntrada.add(btnEntrada, gbc);

        JPanel panelGestao = new JPanel(new BorderLayout());

        String[] colunas = {"Placa", "Modelo", "Tipo", "Hora Entrada"};
        modeloTabelaAtivos = new DefaultTableModel(colunas, 0);
        tabelaAtivos = new JTable(modeloTabelaAtivos);
        JScrollPane scrollTabela = new JScrollPane(tabelaAtivos);
        panelGestao.add(scrollTabela, BorderLayout.CENTER);

        JPanel panelBaixo = new JPanel();
        JButton btnSaida = new JButton("Registrar Saída do Selecionado");
        JButton btnAtualizar = new JButton("Atualizar Lista");

        btnSaida.addActionListener(e -> acaoRegistrarSaida());
        btnAtualizar.addActionListener(e -> atualizarTabela());

        panelBaixo.add(btnAtualizar);
        panelBaixo.add(btnSaida);
        panelGestao.add(panelBaixo, BorderLayout.SOUTH);

        JPanel panelRelatorio = new JPanel(new BorderLayout());
        txtLog = new JTextArea();
        txtLog.setEditable(false);
        panelRelatorio.add(new JScrollPane(txtLog), BorderLayout.CENTER);
        JButton btnGerarRelatorio = new JButton("Gerar Relatório Financeiro");
        btnGerarRelatorio.addActionListener(e -> acaoGerarRelatorio());
        panelRelatorio.add(btnGerarRelatorio, BorderLayout.NORTH);

        tabbedPane.addTab("Entrada", panelEntrada);
        tabbedPane.addTab("Pátio / Saída", panelGestao);
        tabbedPane.addTab("Relatórios", panelRelatorio);

        add(tabbedPane);
    }

    private void acaoRegistrarEntrada() {
        try {
            String placa = txtPlaca.getText();
            String modelo = txtModelo.getText();
            String cor = txtCor.getText();

            if(placa.isEmpty() || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            Veiculo veiculo;
            if(rbCarro.isSelected()) {
                veiculo = new Carro(placa, modelo, cor);
            } else {
                veiculo = new Moto(placa, modelo, cor);
            }

            service.registrarEntrada(veiculo);
            JOptionPane.showMessageDialog(this, "Entrada registrada com sucesso!");

            txtPlaca.setText(""); txtModelo.setText(""); txtCor.setText("");
            atualizarTabela();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void acaoRegistrarSaida() {
        int linhaSelecionada = tabelaAtivos.getSelectedRow();
        if(linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo na tabela para dar saída.");
            return;
        }

        String placa = (String) modeloTabelaAtivos.getValueAt(linhaSelecionada, 0);

        try {
            Ticket ticket = service.registrarSaida(placa);
            String msg = "Saída registrada!\n" +
                    "Veículo: " + ticket.getVeiculo().getModelo() + "\n" +
                    "Tempo Total: (Cálculo simulado)\n" +
                    "Valor a Pagar: R$ " + String.format("%.2f", ticket.getValorPago());

            JOptionPane.showMessageDialog(this, msg);
            atualizarTabela();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar saída: " + ex.getMessage());
        }
    }

    private void acaoGerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Histórico de Movimentação ===\n\n");
        double total = 0;

        for(Ticket t : service.getHistorico()) {
            sb.append(t.getResumo()).append("\n");
            total += t.getValorPago();
        }

        sb.append("\n--------------------------------\n");
        sb.append("Total Arrecadado: R$ ").append(String.format("%.2f", total));

        txtLog.setText(sb.toString());
    }

    private void atualizarTabela() {
        modeloTabelaAtivos.setRowCount(0); // Limpa tabela
        for (Ticket t : service.getTicketsAtivos()) {
            String tipo = (t.getVeiculo() instanceof Carro) ? "Carro" : "Moto";
            Object[] row = {
                    t.getVeiculo().getPlaca(),
                    t.getVeiculo().getModelo(),
                    tipo,
                    t.getDataEntrada().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"))
            };
            modeloTabelaAtivos.addRow(row);
        }
    }
}