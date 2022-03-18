package uz.pdp.cinema_rest_api.projections;

import org.springframework.beans.factory.annotation.Value;
import uz.pdp.cinema_rest_api.model.Movie;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(types = { Movie.class })
public interface MovieProjection {

    String getId();

    Integer getDurationInMin();

    String getTitle();

    String getDescription();

    Double getBudget();

    @Value("#{@genreRepository.findAllByMovieId(target.id)}")
    List<GenreProjection> getGenres();

    @Value("#{@specialistRepository.findAllByMovieId(target.id)}")
    List<SpecialistProjection> getSpecialists();

    String getDistributorId();

    String getDistributor();
}
