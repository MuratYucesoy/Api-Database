package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trendlife_InnerGet_State {
    /*
    "get_state": {
        "id": 3920,
        "name": "Alaska",
        "country_id": 231,
        "status": 1,
        "created_at": null,
        "updated_at": null
      }
     */

    private int id;
    private String name;
    private int country_id;
    private int status;
    private String created_at;
    private String updated_at;

}
