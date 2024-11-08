package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEntity {
    private String barcode;
    private String productID;
    private String name;
    private Double qty;
    private String size;
    private Double unitPrice;
    private LocalDate enterdate;
    private String category;
}
