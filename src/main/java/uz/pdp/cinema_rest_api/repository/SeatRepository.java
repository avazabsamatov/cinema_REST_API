package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cinema_rest_api.model.Seat;

import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
}
