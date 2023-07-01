package services;

import dao.TicketsDao;
import factories.CostComputationFactory;
import factories.ParkingSpotManagerFactory;
import models.Ticket;

public class ExitGate {
    private final ParkingSpotManagerFactory parkingSpotManagerFactory;
    private final CostComputationFactory costComputationFactory;
    private final TicketsDao ticketsDao;

    public ExitGate(ParkingSpotManagerFactory parkingSpotManagerFactory, CostComputationFactory costComputationFactory, TicketsDao ticketsDao) {
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
        this.costComputationFactory = costComputationFactory;
        this.ticketsDao = ticketsDao;
    }

    public long calculateCost(Ticket ticket) {
        return costComputationFactory.getCostComputationByVehicleType(ticket.getVehicle().getVehicleType()).calculateCost(ticket);
    }

    public void processExit(Ticket ticket) {
        parkingSpotManagerFactory.getParkingSpotManagerByVehicleType(ticket.getVehicle().getVehicleType()).freeSpot(ticket.getAssignedParkingSpot());
        ticket.markTicketExit();
        ticketsDao.updateTicket(ticket);
    }
}
