public class Main {
    public static void main(String[] args) {
      Notification notification = new SMSNotification();
      NotificationManager manager = new NotificationManager(notification);

      manager.sendNotification("New email in your inbox");

      System.out.println("\nNotification History:");
      for (String message : manager.getNotificationHistory()){
          System.out.println(message);
      }
    }
}