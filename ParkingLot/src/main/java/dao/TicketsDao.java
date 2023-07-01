package dao;

import dataStore.InMemoryDataStore;
import models.Ticket;

import java.util.Objects;
import java.util.UUID;

public class TicketsDao {

    public Ticket getTicketById(UUID ticketId) {
        return InMemoryDataStore.getTicketListInstance().get(ticketId);
    }

    public Ticket addNewTicket(Ticket ticket) {
        if(Objects.nonNull(getTicketById(ticket.getId()))) {
            throw new RuntimeException("Ticket id already present");
        }
        InMemoryDataStore.getTicketListInstance().put(ticket.getId(), ticket);
        return getTicketById(ticket.getId());
    }

    public Ticket updateTicket(Ticket ticket) {
        InMemoryDataStore.getTicketListInstance().put(ticket.getId(), ticket);
        return getTicketById(ticket.getId());
    }
}
