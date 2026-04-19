class TVObserver implements IObserver {
    @Override
    public void update(String headline) {
        displayOnScreen(headline);
    }

    private void displayOnScreen(String headline) {
        System.out.println("TV displays: " + headline);
    }
}