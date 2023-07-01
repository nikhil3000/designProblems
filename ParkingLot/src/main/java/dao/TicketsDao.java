package dao;

import dataStore.InMemoryDataStore;
import models.Ticket;

import java.util.UUID;

public class TicketsDao {

    public TicketsDao(InMemoryDataStore inMemoryDataStore) {}

    public Ticket getTicketById(UUID ticketId) {
        return InMemoryDataStore.getTicketListInstance().get(ticketId);
    }

    public void addNewTicket(Ticket ticket) {
        InMemoryDataStore.getTicketListInstance().put(ticket.getId(), ticket);
    }
}
