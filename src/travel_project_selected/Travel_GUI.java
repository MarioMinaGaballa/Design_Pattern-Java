
package travel_project_selected;
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Travel_GUI extends javax.swing.JFrame {

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private JFrame frame;
    private JTextField flightField;
    private JTextField hotelField;
    private JComboBox<String> packageTypeBox;
    private JTextArea outputArea;

    // Singleton Instances
    private BookingManager bookingManager = BookingManager.getInstance();
    private UserProfileManager userProfileManager = UserProfileManager.getInstance();

    // Observer Notifier
    private BookingNotifier notifier = new BookingNotifier();

    public Travel_GUI() {
        initialize();
        // Adding an Admin to receive notifications
        Admin admin1 = new Admin("Mario");
        notifier.addObserver(admin1);
         Admin admin2 = new Admin("Mario Mena");
        notifier.addObserver(admin2);
        Admin admin3 = new Admin("Abanoub");
        notifier.addObserver(admin3);
    }

    private void initialize() {
        frame = new JFrame("Travel Booking System");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblFlight = new JLabel("Flight:");
        lblFlight.setBounds(10, 10, 80, 20);
        frame.getContentPane().add(lblFlight);

        flightField = new JTextField();
        flightField.setBounds(100, 10, 200, 20);
        frame.getContentPane().add(flightField);

        JLabel lblHotel = new JLabel("Hotel:");
        lblHotel.setBounds(10, 40, 80, 20);
        frame.getContentPane().add(lblHotel);

        hotelField = new JTextField();
        hotelField.setBounds(100, 40, 200, 20);
        frame.getContentPane().add(hotelField);

        JLabel lblPackage = new JLabel("Package Type:");
        lblPackage.setBounds(10, 70, 100, 20);
        frame.getContentPane().add(lblPackage);

        String[] packageTypes = {"Luxury", "Adventure", "Cultural"};
        packageTypeBox = new JComboBox<>(packageTypes);
        packageTypeBox.setBounds(120, 70, 180, 20);
        frame.getContentPane().add(packageTypeBox);

        JButton btnBookPackage = new JButton("Book Package");
        btnBookPackage.setBounds(10, 100, 150, 30);
        frame.getContentPane().add(btnBookPackage);

        JButton btnCustomTrip = new JButton("Custom Trip");
        btnCustomTrip.setBounds(170, 100, 150, 30);
        frame.getContentPane().add(btnCustomTrip);

        JButton btnClonePackage = new JButton("Clone Package");
        btnClonePackage.setBounds(330, 100, 150, 30);
        frame.getContentPane().add(btnClonePackage);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 140, 560, 200);
        frame.getContentPane().add(outputArea);

        // Booking Package - Uses BookingManager and TravelPackage
        btnBookPackage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String flight = flightField.getText();
                String hotel = hotelField.getText();
                String type = (String) packageTypeBox.getSelectedItem();

                TravelPackage travelPackage = TravelPackage.createPackage(type, flight, hotel, type, 2000);
                travelPackage.describe();
                bookingManager.bookPackage(travelPackage.getPackageType());

                // Notify Admins
                notifier.notifyObservers("New package booked: " + type);
                outputArea.setText("Package Booked: " + travelPackage.getPackageType());
            }
        });

        // Custom Trip - Uses Trip Builder
        btnCustomTrip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Trip trip = new Trip.TripBuilder()
                        .setFlight(flightField.getText())
                        .setHotel(hotelField.getText())
                        .setPackageType((String) packageTypeBox.getSelectedItem())
                        .build();

                bookingManager.bookFlight(flightField.getText());
                outputArea.setText("Custom Trip: " + trip.toString());
            }
        });

        // Clone Package - Uses Prototype Design Pattern
        btnClonePackage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String flight = flightField.getText();
                String hotel = hotelField.getText();
                String type = (String) packageTypeBox.getSelectedItem();

                TravelPackage originalPackage = TravelPackage.createPackage(type, flight, hotel, type, 1000);
                TravelPackage clonedPackage = originalPackage.clone();

                outputArea.setText("Original Package: " + originalPackage.getPackageType() + ", Flight: " + originalPackage.getFlight() + ", Hotel: " + originalPackage.getHotel() +
                        "\nCloned Package: " + clonedPackage.getPackageType() + ", Flight: " + clonedPackage.getFlight() + ", Hotel: " + clonedPackage.getHotel());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Travel_GUI window = new Travel_GUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

