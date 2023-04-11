package pojos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trendlife_AddressesBody {

    private int id;
    private int customer_Id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postal_code;
    private int is_shipping_default;
    private int is_billing_default;
    private String created_at;
    private String updated_at;
    private Trendlife_InnerGet_Country get_country;
    private Trendlife_InnerGet_State get_state;
    private Trendlife_InnerGet_City get_city;

}
