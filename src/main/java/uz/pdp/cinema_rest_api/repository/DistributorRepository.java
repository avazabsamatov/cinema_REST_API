package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cinema_rest_api.model.Distributor;

import java.util.UUID;

public interface DistributorRepository extends JpaRepository<Distributor, UUID> {
}
