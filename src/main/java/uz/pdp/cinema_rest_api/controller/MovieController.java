package uz.pdp.cinema_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.cinema_rest_api.api.ApiResponse;
import uz.pdp.cinema_rest_api.model.Movie;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cinema_rest_api.projections.MovieProjection;
import uz.pdp.cinema_rest_api.service.MovieService;


import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<ApiResponse> saveMovie(@RequestPart("attachment") MultipartFile multipartFile,

                                                 @RequestPart("json") Movie movie) {
        try {
            movieService.saveOrUpdateMovie(null, movie, multipartFile);
            return new ResponseEntity<>(new ApiResponse(true, "created", movie), HttpStatus.OK);
        } catch (IOException ignored) {
        }
        return new ResponseEntity<>(new ApiResponse(false, "error", movie), HttpStatus.BAD_REQUEST);
    }


    @GetMapping
    public HttpEntity getAllMovie(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        Pageable paging =  PageRequest.of(page, size);
        Page<MovieProjection> movies = movieService.movieList(paging);

        ApiResponse res = new ApiResponse(true, "success", movies);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<ApiResponse> getMovieInfo(@PathVariable UUID movieId) {

        return new ResponseEntity<>(new ApiResponse(true, "success", movieService.getMovieInfo(movieId)), HttpStatus.OK);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<ApiResponse> updateMovie(@RequestPart("attachment") MultipartFile multipartFile,
                                                         @RequestPart("json") Movie movie,
                                                         @PathVariable UUID movieId) {
        try {
            movieService.saveOrUpdateMovie(movieId, movie, multipartFile);
            return new ResponseEntity<>(new ApiResponse(true, "updated", movie), HttpStatus.OK);
        } catch (IOException ignored) {
        }

        return new ResponseEntity<>(new ApiResponse(false, "error", movie), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<ApiResponse> deleteMovie(@PathVariable UUID movieId) {
        try {
            movieService.deleteMovie(movieId);
            return new ResponseEntity<>(new ApiResponse(true, "deleted", movieId), HttpStatus.OK);
        } catch (Exception ignored) {
            ignored.getMessage();
        }

        return new ResponseEntity<>(new ApiResponse(false, "error", movieId), HttpStatus.BAD_REQUEST);
    }

}
