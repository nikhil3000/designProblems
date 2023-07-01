package models;

import models.ParkingSpots.ParkingSpot;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Ticket {
    private final UUID Id;
    private final ZonedDateTime entryTime;
    private final ParkingSpot assignedParkingSpot;

    public Ticket(ParkingSpot assignedParkingSpot) {
        Id = UUID.randomUUID();
        this.assignedParkingSpot = assignedParkingSpot;
        this.entryTime = ZonedDateTime.now();
    }

    public ZonedDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getAssignedParkingSpot() {
        return assignedParkingSpot;
    }

    public UUID getId() {
        return Id;
    }
}
