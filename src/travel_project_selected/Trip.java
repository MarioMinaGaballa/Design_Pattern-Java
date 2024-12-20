/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_project_selected;

/**
 *
 * @author Mario Ibrahem
 */

    // Builder Pattern - بناء رحلة مخصصة
class Trip {
    private String flight;
    private String hotel;
    private String packageType;

    private Trip(TripBuilder builder) {
        this.flight = builder.flight;
        this.hotel = builder.hotel;
        this.packageType = builder.packageType;
    }

    Trip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Trip [Flight=" + flight + ", Hotel=" + hotel + ", Package=" + packageType + "]";
    }

    public static class TripBuilder {
        private String flight;
        private String hotel;
        private String packageType;

        public TripBuilder setFlight(String flight) {
            this.flight = flight;
            return this;
        }

        public TripBuilder setHotel(String hotel) {
            this.hotel = hotel;
            return this;
        }

        public TripBuilder setPackageType(String packageType) {
            this.packageType = packageType;
            return this;
        }

        public Trip build() {
            return new Trip(this);
        }
    }
}


