package payment_service.paymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.json.JSONObject;

public class RazorPaymentgateway implements PaymentGateway {
    private RazorpayClient razorPayClient;

    public RazorPaymentgateway(RazorpayClient razorPayClient) {
        this.razorPayClient = razorPayClient;
    }

    @Override
    public String geneatePaymentLink(Long Orderid, Long amount) throws RazorpayException {
        // ORDER DETAILS
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount); // 1000 - > 10.00
        paymentLinkRequest.put("currency", "INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", 1718040057);
        paymentLinkRequest.put("reference_id", Orderid.toString());
        paymentLinkRequest.put("description", "Payment for orderId " + Orderid.toString());


        // CUSTOMER DETAILS
        JSONObject customer = new JSONObject();
        customer.put("name", "+919123456891");
        customer.put("contact", "karan bhatia");
        customer.put("email", "karan.bhatia_1@scaler.com");
        paymentLinkRequest.put("customer", customer);


        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);

        // notify details..
        paymentLinkRequest.put("notify", notify);
//        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes", notes);
        paymentLinkRequest.put("callback_url", "https://www.scaler.com/academy/instructor-dashboard/");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink link = razorPayClient.paymentLink.create(paymentLinkRequest);
        return link.toString();

    }
}

