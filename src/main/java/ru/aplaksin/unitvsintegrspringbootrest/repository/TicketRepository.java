package ru.aplaksin.unitvsintegrspringbootrest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aplaksin.unitvsintegrspringbootrest.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    Ticket findByEmail(String email);
}
