package payment_service.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payment_service.Dtos.PaymentRequestData;

@RestController
@RequestMapping("/payments")
public class PaymentController  {

    @PostMapping("/request")
    public  String Initiatepayment (@RequestBody PaymentRequestData request ){
      try{

      }catch(Exception e){
          return "Initiation of payment failed" ;
      }
       return null ;
    }
}
