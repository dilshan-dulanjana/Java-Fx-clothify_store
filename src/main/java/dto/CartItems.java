package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItems {

    private String OrderID;
    private String productID;
    private String description;
    private Double qty;
    private Double total;
    private String paymentType;
    private String Emp_ID;
}
