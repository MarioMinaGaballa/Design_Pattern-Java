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

 // Singleton Pattern - مدير بيانات المستخدم
public class UserProfileManager {
   

    private static UserProfileManager instance;

    private String preferences;
    private int loyaltyPoints;

    UserProfileManager() {}

    public static UserProfileManager getInstance() {
        if (instance == null) {
            instance = new UserProfileManager();
        }
        return instance;
    }

    public void updatePreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getPreferences() {
        return preferences;
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    void manageUserProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

