package service;

import model.Ticket;
import model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstacionamentoService {
    private List<Ticket> ticketsAtivos;
    private List<Ticket> historico;
    private final double PRECO_BASE_HORA = 10.00;

    public EstacionamentoService() {
        this.ticketsAtivos = new ArrayList<>();
        this.historico = new ArrayList<>();
    }

    public void registrarEntrada(Veiculo veiculo) throws Exception {
        // Verifica se já existe
        boolean existe = ticketsAtivos.stream()
                .anyMatch(t -> t.getVeiculo().getPlaca().equalsIgnoreCase(veiculo.getPlaca()));

        if(existe) {
            throw new Exception("Veículo com esta placa já está no estacionamento!");
        }

        Ticket novoTicket = new Ticket(veiculo);
        ticketsAtivos.add(novoTicket);
    }

    public Ticket registrarSaida(String placa) throws Exception {
        Optional<Ticket> ticketOpt = ticketsAtivos.stream()
                .filter(t -> t.getVeiculo().getPlaca().equalsIgnoreCase(placa))
                .findFirst();

        if (ticketOpt.isPresent()) {
            Ticket ticket = ticketOpt.get();
            ticket.registrarSaida(PRECO_BASE_HORA);

            ticketsAtivos.remove(ticket);
            historico.add(ticket);
            return ticket;
        } else {
            throw new Exception("Veículo não encontrado.");
        }
    }

    public List<Ticket> getTicketsAtivos() {
        return ticketsAtivos;
    }

    public List<Ticket> getHistorico() {
        return historico;
    }
}