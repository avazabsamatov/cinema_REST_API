package uz.pdp.cinema_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.cinema_rest_api.api.ApiResponse;
import uz.pdp.cinema_rest_api.service.RowService;

@RestController
@RequestMapping("/api/row")
public class RowController {
    @Autowired
    RowService rowService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRow(){
        return new ResponseEntity<>(
                new ApiResponse(
                        true,
                        "Successfully",
                        rowService.getAllRow()),
                        HttpStatus.OK);
    }
}
