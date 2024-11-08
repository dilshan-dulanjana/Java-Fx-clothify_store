package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor


public class Product {
    private String barcode;
    private String productID;
    private String name;
    private Double qty;
    private String size;
    private Double unitPrice;
    private LocalDate enterdate;
    private String category;



}
