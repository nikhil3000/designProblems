package services.CostComputation;

import models.Ticket;

import java.time.Duration;
import java.time.ZonedDateTime;

public class FourWheelerCostComputation extends CostComputation{
    @Override
    public long calculateCost(Ticket ticket) {
        System.out.println("Four wheeler cost computation");
        return (long) (ticket.getAssignedParkingSpot().getPrice() * Math.ceil((float) (ZonedDateTime.now().toEpochSecond() - ticket.getEntryTime().toEpochSecond()) / 3600));
    }
}
