class PhoneObserver implements IObserver {
    @Override
    public void update(String message) {
        displayAsNotificationPopup(message);
    }

    private void displayAsNotificationPopup(String message) {
        System.out.println("Phone notification: " + message);
    }
}