package dataStore;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class InMemoryDataStore {
    private static Map<UUID, Ticket> ticketsList;


    private InMemoryDataStore() {
    }
    public static synchronized Map<UUID, Ticket> getTicketListInstance () {
        if (ticketsList == null) {
            ticketsList = new HashMap<>();
        }
        return ticketsList;
    }
}
