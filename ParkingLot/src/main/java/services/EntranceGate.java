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

    public EntranceGate(ParkingSpotManagerFactory parkingSpotManagerFactory, TicketsDao ticketsDao) {
        this.id = UUID.randomUUID();
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
        this.ticketsDao = ticketsDao;
    }

    public Ticket createTicket(Vehicle vehicle) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManagerByVehicleType(vehicle.getVehicleType());
        Optional<ParkingSpot> parkingSpot = parkingSpotManager.findNearestSpot();
        if(parkingSpot.isEmpty()){
            // TODO: Create a dedicated Exception class
            System.out.printf("Can't park %s", vehicle.toString());
            throw new RuntimeException("Available Parking spot not found Ticket can't be created");
        }
        parkingSpot.get().parkVehicle(vehicle);
        Ticket ticket = new Ticket(parkingSpot.get(), vehicle);
        ticketsDao.addNewTicket(ticket);
        System.out.printf("Parked Vehicle with id %s %n", vehicle.toString());
        return ticket;
    }
}
