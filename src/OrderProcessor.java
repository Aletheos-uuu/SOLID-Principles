public class OrderProcessor {
    private final OrderCalculator calculator;
    private final OrderPlacer placer;
    private final InvoiceGenerator invoiceGenerator;
    private final EmailNotifier emailNotifier;

    public OrderProcessor(OrderCalculator calculator,
                          OrderPlacer placer,
                          InvoiceGenerator invoiceGenerator,
                          EmailNotifier emailNotifier) {
        this.calculator = calculator;
        this.placer = placer;
        this.invoiceGenerator = invoiceGenerator;
        this.emailNotifier = emailNotifier;
    }

    public void processOrder(double price, int quantity,
                             String customerName, String address,
                             String invoiceFile, String email) {
        calculator.calculateTotal(price, quantity);
        placer.placeOrder(customerName, address);
        invoiceGenerator.generateInvoice(invoiceFile);
        emailNotifier.sendEmailNotification(email);
    }
}