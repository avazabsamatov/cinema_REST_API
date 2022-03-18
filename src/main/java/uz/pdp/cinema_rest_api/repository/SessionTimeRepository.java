package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinema_rest_api.model.SessionDate;
import uz.pdp.cinema_rest_api.model.SessionTime;

import java.util.UUID;
@Repository
public interface SessionTimeRepository extends JpaRepository<SessionTime, UUID> {
}
