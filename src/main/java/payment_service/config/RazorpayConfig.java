package payment_service.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Every time my razorpay client not created so create bean from the config.
@Configuration
public class RazorpayConfig {
    @Value("${razorpay.key.id}")
    public  String razorpayid ;
    @Value("${razorpay.secret.id}")
    public  String razorpaysecret ;
    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpayid, razorpaysecret) ;
    }
}
