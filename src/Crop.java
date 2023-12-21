

import java.util.ArrayList;
import java.util.List;

class Crop {
    private String name;
    private int growthDays;
    private boolean isHarvested;

    // Constructor, getters, setters
    public Crop(String name, int growthDays) {
        this.name = name;
        this.growthDays = growthDays;
        this.isHarvested = false;
    }

    public String getName() {
        return name;
    }

    public int getGrowthDays() {
        return growthDays;
    }

    public boolean isHarvested() {
        return isHarvested;
    }

    public void setHarvested(boolean harvested) {
        isHarvested = harvested;
    }

    // Method to simulate crop growth
    public void grow() {
        growthDays--;
        if (growthDays <= 0) {
            isHarvested = true;
        }
    }

    // Harvest method
    public void harvest() {
        if (isHarvested) {
            System.out.println("Already harvested " + name);
        } else {
            System.out.println("Harvesting " + name);
            isHarvested = true;
        }
    }
}

public class Farm {
    private List<Crop> cropList;

    public Farm() {
        this.cropList = new ArrayList<>();
        cropList.add(new Crop("Wheat", 5));
        cropList.add(new Crop("Corn", 7));
    }

    // Method to simulate the passage of time and crop growth
    public void simulateTimePassing() {
        for (Crop crop : cropList) {
            crop.grow();
        }
    }

    // Harvest crops method
    public void harvestCrops() {
        for (Crop crop : cropList) {
            if (crop.isHarvested()) {
                System.out.println(crop.getName() + " is already harvested.");
            } else {
                crop.harvest();
            }
        }
    }

    public static void main(String[] args) {
        Farm farm = new Farm();

        // Simulate the passage of time
        farm.simulateTimePassing();

        // Harvest crops
        farm.harvestCrops();
    }
}
