package uz.pdp.cinema_rest_api.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {

    private boolean status;

    private String message;

    private Object data;

}
