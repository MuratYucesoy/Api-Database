package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Trendlife_InnerGet_Country {
    /*
    "get_country": {
        "id": 231,
        "code": "US",
        "name": "United States",
        "phonecode": "1",
        "flag": "/flags/flag-of-United-States-of-America.jpg",
        "status": 1,
        "created_at": null,
        "updated_at": null
     */
    private int id;
    private String code;
    private String name;
    private String phonecode;
    private String flag;
    private int status;
    private String created_at;
    private String updated_at;
}
