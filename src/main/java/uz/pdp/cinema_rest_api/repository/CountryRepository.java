package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cinema_rest_api.model.Country;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
}
