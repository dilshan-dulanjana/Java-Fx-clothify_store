package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierEntity {
     private Integer ID;
    private  String name;
    private String email;
    private  String address;
    private  String telephone;

}