package uz.pdp.cinema_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cinema_rest_api.api.ApiResponse;
import uz.pdp.cinema_rest_api.model.Hall;
import uz.pdp.cinema_rest_api.service.HallService;


import java.util.UUID;

@Controller
@RequestMapping("/api/halls")
public class HallController {

    @Autowired
    private HallService hallService;


    @GetMapping
    public ResponseEntity<ApiResponse> getAllHalls() {
        return new ResponseEntity<>(
                new ApiResponse(
                        true,
                        "success",
                        hallService.getAllHall()),
                        HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ApiResponse> saveHall(Hall hall) {
        try {
            hallService.saveHall(hall);
            return new ResponseEntity<>(new ApiResponse(true, "created", hall), HttpStatus.OK);
        } catch (Exception e) {
        }
        return new ResponseEntity<>(new ApiResponse(false, "error", hall), HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/{hallId}")
    public ResponseEntity<ApiResponse> updateDistributor(@PathVariable UUID hallId, Hall hall) {
        try {
            hallService.updateHall(hallId, hall);
            return new ResponseEntity<>(new ApiResponse(true, "updated", hall),
                    HttpStatus.OK);
        } catch (Exception e) {
        }

        return new ResponseEntity<>(new ApiResponse(false, "error", hall),
                HttpStatus.BAD_REQUEST);
    }

    //delete
    @DeleteMapping("/{hallId}")
    public ResponseEntity<ApiResponse> deleteDistributor(@PathVariable UUID hallId) {
        try {
            hallService.deleteHall(hallId);
            return new ResponseEntity<>(new ApiResponse(true, "deleted", hallId), HttpStatus.OK);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<>(new ApiResponse(false, "error", hallId), HttpStatus.BAD_REQUEST);
    }

}
