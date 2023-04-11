package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Trendlife_InnerGet_City {
    /*
    "get_city": {
        "id": 42671,
        "name": "Barrow",
        "state_id": 3920,
        "status": 1,
        "created_at": null,
        "updated_at": null
     */
    private int id;
    private String name;
    private int status_id;
    private int status;
    private String created_at;
    private String updated_at;


}
