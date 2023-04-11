package pojos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trendlife_Expected_Body {

    private Trendlife_AddressesBody[] addresses;
    private String message;
}
