package model;

public class Moto extends Veiculo {

    public Moto(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double getFatorPreco() {
        return 0.8;
    }

    @Override
    public String toString() {
        return "[Moto] " + super.toString();
    }
}