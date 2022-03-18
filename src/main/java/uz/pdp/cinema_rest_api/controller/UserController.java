package uz.pdp.cinema_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.cinema_rest_api.model.Row;
import uz.pdp.cinema_rest_api.model.Seat;
import uz.pdp.cinema_rest_api.projections.Projection;
import uz.pdp.cinema_rest_api.repository.HallRepository;
import uz.pdp.cinema_rest_api.repository.RowRepository;
import uz.pdp.cinema_rest_api.repository.SeatRepository;
import uz.pdp.cinema_rest_api.repository.UserRepository;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    RowRepository rowRepository;

    @Autowired
    HallRepository hallRepository;

    @GetMapping("/seats")
    public ResponseEntity<List<Seat>> getSeats() {
        return ResponseEntity.ok().body(seatRepository.findAll());
    }

    @GetMapping("/rows")
    public ResponseEntity<List<Row>> getRows() {
        return ResponseEntity.ok().body(rowRepository.findAll());
    }

    @GetMapping("/seats/{id}")
    public HttpEntity<List<Projection>> getRow(@PathVariable UUID id){
       List<Projection> byRowId = hallRepository.findByRowId(id);

        return ResponseEntity.ok().body(byRowId);
    }

//    public List<CastProjection> getAllCastsByMovieId(@PathVariable(required = true) UUID movieId) {
//        return castRepository.findByMovieId(movieId);
//    }
//
//    @GetMapping("/{movieId}")
//    public HttpEntity getAllCastsByMovieId(@PathVariable(required = true) UUID movieId) {
//        List<CastProjection> allCastsByMovieId = castService.getAllCastsByMovieId(movieId);
//
//        ApiResponse res = new ApiResponse("success", true, allCastsByMovieId);
//
//        return ResponseEntity.ok(res);
//
//
//    }
//

}
