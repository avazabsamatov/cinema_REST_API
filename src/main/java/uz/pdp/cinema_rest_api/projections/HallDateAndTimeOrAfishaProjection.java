package uz.pdp.cinema_rest_api.projections;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

public interface HallDateAndTimeOrAfishaProjection {
    UUID getId();

    String getName();


    List<SessionTimeProjection> getTime();
}
