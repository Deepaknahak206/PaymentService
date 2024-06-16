package payment_service.Dtos;

import lombok.Data;

@Data
public class PaymentRequestData {
    private Long OrderId ;
    private Long Amount ;
}
