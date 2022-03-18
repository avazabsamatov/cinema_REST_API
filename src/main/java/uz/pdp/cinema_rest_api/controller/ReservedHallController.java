package uz.pdp.cinema_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.cinema_rest_api.api.ApiResponse;
import uz.pdp.cinema_rest_api.service.ReservedHallService;

@RestController
@RequestMapping("/api/reserved-hall")
public class ReservedHallController {
    @Autowired
    ReservedHallService reservedHallService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllReservedHalls(){
        return new ResponseEntity<>(new ApiResponse(
                true,
                "Successfully",
                reservedHallService.getReservedHalls()),
                HttpStatus.OK);
    }
}
