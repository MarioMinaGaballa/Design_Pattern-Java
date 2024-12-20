package travel_project_selected;

// Updated TravelPackage Class with Prototype Design Pattern
public class TravelPackage implements Cloneable {
    private String flight;
    private String hotel;
    private String packageType;
    private double basePrice;

    // Constructor
    public TravelPackage(String flight, String hotel, String packageType, double basePrice) {
        this.flight = flight;
        this.hotel = hotel;
        this.packageType = packageType;
        this.basePrice = basePrice;
    }

    // Factory method to create packages
    public static TravelPackage createPackage(String type, String flight, String hotel, String packageType, double basePrice) {
        if (type.equalsIgnoreCase("Luxury")) {
            return new TravelPackage(flight, hotel, "Luxury", basePrice + 500);
        } else if (type.equalsIgnoreCase("Adventure")) {
            return new TravelPackage(flight, hotel, "Adventure", basePrice + 300);
        } else if (type.equalsIgnoreCase("Cultural")) {
            return new TravelPackage(flight, hotel, "Cultural", basePrice + 200);
        } else {
            throw new IllegalArgumentException("Invalid package type.");
        }
    }

    // Implementing Cloneable interface
    @Override
    public TravelPackage clone() {
        try {
            return (TravelPackage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported for TravelPackage", e);
        }
    }

    // Getters
    public String getFlight() {
        return flight;
    }

    public String getHotel() {
        return hotel;
    }

    public String getPackageType() {
        return packageType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Describe method
    public void describe() {
        System.out.println("Travel Package Details:");
        System.out.println("Flight: " + flight);
        System.out.println("Hotel: " + hotel);
        System.out.println("Type: " + packageType);
        System.out.println("Total Price: $" + basePrice);
    }
}