public abstract class OrderTemplate {
    public boolean isGift; // a hook (= optional to override)

    protected void wrapGift() {
        System.out.println("Gift wrap the item");
    }

    protected abstract void doCheckout();

    protected abstract void doPayment();

    protected abstract void doReceipt();

    protected abstract void doDelivery();

    // Template method => the process/algo is same for all orders, but the parts change
    // This isn't strategy pattern where the whole algo changes.
    public final void processOrder() {
        doCheckout();
        doPayment();
        
        // If it's a gift, wrap it else do receipt. 
        // Generally, receipt with payment is not send to customer. Though items are listed on it.
        if (isGift) {
            wrapGift();
        } else {
            doReceipt();
        }
        doDelivery();
    }
}