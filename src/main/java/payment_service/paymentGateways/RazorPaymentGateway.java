package payment_service.paymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RazorPaymentGateway implements  PaymentGateway{
    private RazorpayClient razorpayClient ;
    public RazorPaymentGateway(RazorpayClient razorpayClient){
        this.razorpayClient=razorpayClient ;
    }
    @Override
    public String geneatePaymentLink(Long Orderid, Long amount) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount); // 1000 - > 10.00
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", 1718040057);
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description","Payment for orderId " + orderId.toString());


        // CUSTOMER DETAILS
        JSONObject customer = new JSONObject();
        customer.put("name","+919123456891");
        customer.put("contact","karan bhatia");
        customer.put("email","karan.bhatia_1@scaler.com");
        paymentLinkRequest.put("customer",customer);


        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        // notify details..
        paymentLinkRequest.put("notify",notify);
//        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/academy/instructor-dashboard/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink link = razorpayClient.paymentLink.create(paymentLinkRequest);

        return link.toString();

    }
}
