package payment_service.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payment_service.Dtos.PaymentRequestData;
import payment_service.Service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController  {

    public PaymentService paymentService ;
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService ;
    }
    @PostMapping("/request")
    public  String Initiatepayment (@RequestBody PaymentRequestData request ){
        try{
            return this.paymentService.initiatepayment(request.getOrderId(), request.getAmount());
        } catch (Exception e){
            System.out.println("error is"+ e.getMessage());
            return "ERROR";
        }

    }
}
