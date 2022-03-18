package uz.pdp.cinema_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.cinema_rest_api.api.ApiResponse;
import uz.pdp.cinema_rest_api.model.Genre;
import uz.pdp.cinema_rest_api.service.GenreService;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    GenreService genreService;

        @GetMapping
        public ResponseEntity<ApiResponse> getAllHalls() {
            return new ResponseEntity<>(
                    new ApiResponse(
                            true,
                            "success",
                            genreService.getAllGenres()),
                    HttpStatus.OK);
                }
         @PostMapping
    public ResponseEntity<ApiResponse> create(Genre genre){
            return new ResponseEntity<>(new ApiResponse(
                    true,
                    "Successfully added",
                    genreService.create(genre)),
                    HttpStatus.OK);
         }
}
