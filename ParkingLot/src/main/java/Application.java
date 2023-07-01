import dao.TicketsDao;
import factories.CostComputationFactory;
import factories.ParkingSpotManagerFactory;
import models.ParkingSpots.FourWheelerParkingSpot;
import models.ParkingSpots.ParkingSpot;
import models.ParkingSpots.TwoWheelerParkingSpot;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;
import services.EntranceGate;
import services.ExitGate;


import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        TicketsDao ticketsDao = new TicketsDao();
        CostComputationFactory costComputationFactory = new CostComputationFactory();
        List<ParkingSpot> twoWheelerParkingSpotList = new ArrayList<>();
        List<ParkingSpot> fourWheelerParkingSpotList = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();
        for(int i = 0; i< 5; i++){
            twoWheelerParkingSpotList.add(new TwoWheelerParkingSpot());
        }
        for(int i = 0; i< 3; i++){
            fourWheelerParkingSpotList.add(new FourWheelerParkingSpot());
        }

        ParkingSpotManagerFactory parkingSpotManagerFactory = new ParkingSpotManagerFactory(twoWheelerParkingSpotList, fourWheelerParkingSpotList);

        EntranceGate primaryEntryGate = new EntranceGate(parkingSpotManagerFactory, ticketsDao);
        ExitGate exitGate = new ExitGate(parkingSpotManagerFactory, costComputationFactory, ticketsDao);

        ticketList.add(primaryEntryGate.createTicket(new Vehicle("1", VehicleType.FOUR_WHEELER)));
        ticketList.add(primaryEntryGate.createTicket(new Vehicle("2", VehicleType.FOUR_WHEELER)));
        ticketList.add(primaryEntryGate.createTicket(new Vehicle("3", VehicleType.FOUR_WHEELER)));
        try {
            ticketList.add(primaryEntryGate.createTicket(new Vehicle("4", VehicleType.FOUR_WHEELER)));
        } catch (Exception ex) {
            Thread.sleep(1000);
        System.out.printf("Please pay to exit %s" , exitGate.calculateCost(ticketList.get(0)));
        exitGate.processExit(ticketList.get(0));
        }
        ticketList.add(primaryEntryGate.createTicket(new Vehicle("5", VehicleType.FOUR_WHEELER)));
        ticketList.add(primaryEntryGate.createTicket(new Vehicle("6", VehicleType.TWO_WHEELER)));
        ticketList.add(primaryEntryGate.createTicket(new Vehicle("7", VehicleType.TWO_WHEELER)));
        Thread.sleep(1000);
        System.out.printf("Please pay to exit %s" , exitGate.calculateCost(ticketList.get(4)));
        exitGate.processExit(ticketList.get(4));
        ticketList.add(primaryEntryGate.createTicket(new Vehicle("8", VehicleType.TWO_WHEELER)));






    }
}
