public abstract class OrderTemplate {
    public boolean isGift; // a hook (optional tho)
    protected void wrapGift() {
        System.out.println("Gift wrap the item");
    }
    protected abstract void doCheckout();
    protected abstract void doPayment();
    protected abstract void doReceipt();
    protected abstract void doDelivery();

    // template method - so the process/algo is same for all orders, but the parts/implementation changes != strategy, where the whole algo changes.
    public final void processOrder() {
        doCheckout();
        doPayment();
        // if it's a gift, wrap it else do receipt
        if (isGift) {
            wrapGift();
        } else {
            doReceipt();
        }
        doDelivery();
    }
}
