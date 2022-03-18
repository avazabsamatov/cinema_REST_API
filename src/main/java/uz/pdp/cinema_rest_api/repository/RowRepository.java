package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cinema_rest_api.model.Row;

import java.util.UUID;

public interface RowRepository extends JpaRepository<Row, UUID> {
}
