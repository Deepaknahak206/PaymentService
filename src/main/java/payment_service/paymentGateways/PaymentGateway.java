package payment_service.paymentGateways;

import com.razorpay.RazorpayException;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface PaymentGateway {
     String geneatePaymentLink(Long Orderid, Long amount) throws RazorpayException;
}
