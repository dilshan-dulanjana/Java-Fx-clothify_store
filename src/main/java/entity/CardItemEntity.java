package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardItemEntity {
    private String OrderID;
    private String productID;
    private Double qty;
    private Double total;
    private String paymentType;
    private String Emp_ID;
}
