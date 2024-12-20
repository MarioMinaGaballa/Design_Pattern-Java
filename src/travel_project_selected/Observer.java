package travel_project_selected;
import java.util.ArrayList;
import java.util.List;



// Observer Pattern - إشعارات الحجوزات

interface Observer {
    void update(String message);
}

class Admin implements Observer {
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println("Admin " + name + " received notification: " + message);
    }
}


