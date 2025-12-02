package model;

// Classe Abstrata (Requisito 7)
public abstract class Veiculo {
    private String placa;
    private String modelo;
    private String cor;

    // Construtor (Requisito 3)
    public Veiculo(String placa, String modelo, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    // Getters e Setters (Requisito 4)
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public abstract double getFatorPreco();

    @Override
    public String toString() {
        return modelo + " (" + cor + ") - " + placa;
    }
}