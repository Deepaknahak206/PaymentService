package payment_service.paymentGateways;

public interface PaymentGateway {
     String geneatePaymentLink(Long Orderid, Long amount) ;
}
