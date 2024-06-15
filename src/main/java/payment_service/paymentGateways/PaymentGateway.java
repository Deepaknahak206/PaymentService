package payment_service.paymentGateways;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
     String geneatePaymentLink(Long Orderid, Long amount) throws RazorpayException;
}
