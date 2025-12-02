package model;

public class Carro extends Veiculo {

    public Carro(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double getFatorPreco() {
        return 1.0;
    }

    @Override
    public String toString() {
        return "[Carro] " + super.toString();
    }
}