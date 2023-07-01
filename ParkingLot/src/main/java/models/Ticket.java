package models;

import models.ParkingSpots.ParkingSpot;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Ticket {
    private final UUID id;
    private final ZonedDateTime entryTime;
    private ZonedDateTime exitTime;
    private final ParkingSpot assignedParkingSpot;
    private final Vehicle vehicle;

    public Ticket(ParkingSpot assignedParkingSpot, Vehicle vehicle) {
        id = UUID.randomUUID();
        this.assignedParkingSpot = assignedParkingSpot;
        this.entryTime = ZonedDateTime.now();

        this.vehicle = vehicle;
    }

    public ZonedDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getAssignedParkingSpot() {
        return assignedParkingSpot;
    }

    public UUID getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void markTicketExit() {
        this.exitTime = ZonedDateTime.now();
    }

    public ZonedDateTime getExitTime() {
        return exitTime;
    }
}
