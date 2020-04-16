package ru.aplaksin.unitvsintegrspringbootrest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aplaksin.unitvsintegrspringbootrest.model.Ticket;
import ru.aplaksin.unitvsintegrspringbootrest.repository.TicketRepository;

@Service
@RequiredArgsConstructor //lombok adds constructor for repo instead @Autowired
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Integer ticketId) {
        return ticketRepository.findById(ticketId).get();
    }

    public Iterable<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void deleteTicket(Integer ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    public Ticket updateTicket(Integer ticketId, String newEmail) {
        Ticket ticket = ticketRepository.findById(ticketId).get();
        ticket.setEmail(newEmail);
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketByEmail(String email) {
        return ticketRepository.findByEmail(email);
    }
}
