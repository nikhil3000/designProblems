package factories;

import models.VehicleType;
import services.CostComputation.CostComputation;
import services.CostComputation.FourWheelerCostComputation;
import services.CostComputation.TwoWheelerCostComputation;

public class CostComputationFactory {

    private final TwoWheelerCostComputation twoWheelerCostComputation;
    private final FourWheelerCostComputation fourWheelerCostComputation;


    public CostComputationFactory() {
        this.twoWheelerCostComputation = new TwoWheelerCostComputation();
        this.fourWheelerCostComputation = new FourWheelerCostComputation();
    }

    public CostComputation getCostComputationByVehicleType(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> twoWheelerCostComputation;
            case FOUR_WHEELER -> fourWheelerCostComputation;
        };
    }
}
