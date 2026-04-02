public class OrderTest {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor(
            new BasicOrderCalculator(),
            new StandardOrderPlacer(),
            new PdfInvoiceGenerator(),
            new SmtpEmailNotifier()
        );

        processor.processOrder(
            10.0, 2,
            "Bean Sooker", "123 Paraiso St",
            "order_123.pdf",
            "crioquebean@gmail.com"
        );
    }
}