package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class US01_TC01 {

           /*
        {
  "first_name": "abc",
  "last_name": "bcd",
  "username":"efg",
  "email": "jjksjd@gmail.com",
  "password": "As.23123123",
  "password_confirmation": "As.23123123",
  "user_type": "customer",
  "phone":"12112312233",
  "referral_code": "4454653445464546"
}
            */
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String user_type;
    private String phone;
    private String referral_code;

}
