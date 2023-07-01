package services.CostComputation;

import models.Ticket;

import java.time.Duration;
import java.time.ZonedDateTime;

public class TwoWheelerCostComputation extends CostComputation{
    @Override
    public long calculateCost(Ticket ticket) {
        System.out.println("Two wheeler cost computation");
        return (long) (ticket.getAssignedParkingSpot().getPrice() * Math.ceil((float)(ZonedDateTime.now().toEpochSecond() - ticket.getEntryTime().toEpochSecond()) / 3600));
    }
}
