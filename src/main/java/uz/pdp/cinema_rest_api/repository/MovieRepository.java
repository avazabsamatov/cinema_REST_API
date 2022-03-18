package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.cinema_rest_api.model.Movie;
import uz.pdp.cinema_rest_api.projections.MovieProjection;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

    @Query(nativeQuery = true, value =
            "select cast(m.id as varchar) as id, cast(d.id as varchar) as distributorId," +
            " m.duration_in_min as durationInMin, m.title as title,\n" +
            "       m.description, m.budget, d.name as distributor from movies m\n" +
            "           join distributors d on d.id = m.distributor_id\n" +
            "\n" +
            "where m.id = :movieId")
    MovieProjection findByMovieId(UUID movieId);



    @Query(nativeQuery = true, value =
            "select cast(m.id as varchar) as id," +
            " cast(d.id as varchar) as distributorId, m.duration_in_min as durationInMin, " +
            "m.title as title, m.description, m.budget, d.name as distributor from movies m\n" +
            "           join distributors d on d.id = m.distributor_id\n")
    Page<MovieProjection> findAllByPage(Pageable pageable);
}
