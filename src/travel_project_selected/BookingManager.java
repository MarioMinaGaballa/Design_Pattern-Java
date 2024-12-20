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

 // Singleton Pattern - مدير الحجز
public class BookingManager {
   

    private static BookingManager instance;

    BookingManager() {}

    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    public void bookFlight(String flightDetails) {
        System.out.println("Flight booked: " + flightDetails);
    }

    public void bookHotel(String hotelDetails) {
        System.out.println("Hotel booked: " + hotelDetails);
    }

    public void bookPackage(String packageDetails) {
        System.out.println("Package booked: " + packageDetails);
    }
}

