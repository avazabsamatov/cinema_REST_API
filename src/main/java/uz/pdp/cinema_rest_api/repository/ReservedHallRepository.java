package uz.pdp.cinema_rest_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.cinema_rest_api.model.ReservedHall;
import uz.pdp.cinema_rest_api.projections.HallDateAndTimeOrAfishaProjection;

import java.util.UUID;

public interface ReservedHallRepository extends JpaRepository<ReservedHall, UUID> {
    @Query(nativeQuery = true,name = "select cast(rh.id as varchar) as id,sd.date as startedDate,\n" +
            "cast(a.id as varchar) as movieCoverImgId,\n" +
            "cast(m.id as varchar) as  movieId,\n" +
            "m.title as movieTitle,\n" +
            "json_agg(json_build_object('id',cast(h.id as varchar),'name',h.name)),\n" +
            "cast(sd.id as varchar) as  startedDateId\n" +
            "from reserved_halls rh join afishalar a on a.id = rh.afisha_id\n" +
            "join halls h on h.id = rh.hall_id\n" +
            "join movies m on m.id = a.movie_id\n" +
            "join attachments a2 on a2.id = m.poster_img_id\n" +
            "cross join session_dates sd\n" +
            "group by sd.date, cast(rh.id as varchar), a.id, m.id, m.title,sd.id\n")
    HallDateAndTimeOrAfishaProjection findByHallId(UUID reservedHallId);
}
