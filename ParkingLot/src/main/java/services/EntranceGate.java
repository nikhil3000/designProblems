package services;

import dao.TicketsDao;
import factories.ParkingSpotManagerFactory;
import models.ParkingSpots.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import services.ParkingSpotManager.ParkingSpotManager;

import java.util.Optional;
import java.util.UUID;

public class EntranceGate {
    private final UUID id;
    private final ParkingSpotManagerFactory parkingSpotManagerFactory;
    private final TicketsDao ticketsDao;

    public EntranceGate(UUID id, ParkingSpotManagerFactory parkingSpotManagerFactory, TicketsDao ticketsDao) {
        this.id = id;
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
        this.ticketsDao = ticketsDao;
    }

    public Ticket createTicket(Vehicle vehicle) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManagerByVehicleType(vehicle.getVehicleType());
        Optional<ParkingSpot> parkingSpot = parkingSpotManager.findNearestSpot();
        if(parkingSpot.isEmpty()){
            // TODO: Create a dedicated Exception class
            throw new RuntimeException("Available Parking spot not found. Ticket can't be created");
        }
        parkingSpot.get().parkVehicle(vehicle);
        Ticket ticket = new Ticket(parkingSpot.get());
        ticketsDao.addNewTicket(ticket);
        return ticket;
    }
}
