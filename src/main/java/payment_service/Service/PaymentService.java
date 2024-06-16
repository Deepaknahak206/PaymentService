package payment_service.Service;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;
import payment_service.paymentGateways.PaymentGateway;


@Service
public class PaymentService {

    private PaymentGateway paymentGateway;
 public  PaymentService (PaymentGateway paymentGateway ){
     this.paymentGateway = paymentGateway ;
 }
public String initiatepayment( Long orderId  , Long Amount) throws RazorpayException {
 return paymentGateway.geneatePaymentLink(orderId,Amount) ;
}
}
