package ru.aplaksin.unitvsintegrspringbootrest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import ru.aplaksin.unitvsintegrspringbootrest.model.Ticket;
import ru.aplaksin.unitvsintegrspringbootrest.repository.TicketRepository;

import java.awt.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    private TicketService ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @BeforeEach
    void initTicketService() {
        ticketService = new TicketService(ticketRepository);
    }

    @Test
    void createTicket() { //test is pointless
        Ticket ticket = new Ticket();
        ticket.setTicketId(100);
        ticket.setPassengerName("Martin");
        ticket.setSourceStation("London");
        ticket.setDestStation("Berlin");
        ticket.setBookingDate(new Date());
        ticket.setEmail("martin.s2017@gmail.com");
        when(ticketRepository.save(any(Ticket.class))).then(returnsFirstArg());
        Ticket ticket2 = ticketService.createTicket(ticket);
        assertNotNull(ticket2);
    }

    @Test
    void getTicketById() {

    }

    @Test
    void getAllTickets() {
    }

    @Test
    void deleteTicket() {
    }

    @Test
    void updateTicket() {

    }

    @Test
    void getTicketByEmail() {
    }
}
