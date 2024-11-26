import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private Notification notification;
    private List<String> notificationHistory = new ArrayList<>();
    public NotificationManager(Notification notification){
        this.notification = notification;
    }
    public void sendNotification(String message){
        notification.send(message);
        notificationHistory.add(message);
    }
    public List<String> getNotificationHistory(){
        return new ArrayList<>(notificationHistory);
    }
}

