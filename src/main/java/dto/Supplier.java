package dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Supplier {

    private Integer ID;
    private  String name;
    private String email;
    private  String address;
    private  String telephone;

}
