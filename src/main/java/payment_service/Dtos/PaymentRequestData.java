package payment_service.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentRequestData {
    @JsonProperty("OrderId")
    private Long OrderId ;
    @JsonProperty("Amount")
    private Long Amount ;
}
