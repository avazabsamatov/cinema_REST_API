package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinema_rest_api.model.Afisha;

import java.util.UUID;

@Repository
public interface AfishaRepository extends JpaRepository<Afisha, UUID> {
}
