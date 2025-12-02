package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Ticket implements Imprimivel {
    private Veiculo veiculo;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private double valorPago;

    public Ticket(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.dataEntrada = LocalDateTime.now();
    }

    public void registrarSaida(double valorBaseHora) {
        this.dataSaida = LocalDateTime.now();
        long minutos = Duration.between(dataEntrada, dataSaida).toMinutes();
        double horas = Math.max(1, Math.ceil(minutos / 60.0));

        // Uso do Polimorfismo: getFatorPreco() muda se for Moto ou Carro
        this.valorPago = horas * valorBaseHora * veiculo.getFatorPreco();
    }

    public Veiculo getVeiculo() { return veiculo; }
    public LocalDateTime getDataEntrada() { return dataEntrada; }
    public LocalDateTime getDataSaida() { return dataSaida; }
    public double getValorPago() { return valorPago; }

    @Override
    public String getResumo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM HH:mm");
        String saidaStr = (dataSaida != null) ? dataSaida.format(fmt) : "Em aberto";
        return veiculo.getPlaca() + " | Ent: " + dataEntrada.format(fmt) + " | Sai: " + saidaStr + " | R$ " + String.format("%.2f", valorPago);
    }
}