package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.cinema_rest_api.model.Hall;
import uz.pdp.cinema_rest_api.projections.Projection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HallRepository extends JpaRepository<Hall, UUID> {
    Optional<Hall> findById(UUID id);

    @Query(nativeQuery = true, value = "select s.number as number, pc.name as name, " +
            "pc.additional_fee_in_percentage as fee from seats s\n" +
            "    join price_categories pc on pc.id = s.price_category_id\n" +
            "where s.id = :rowId")
    List<Projection>findByRowId(UUID rowId);
}
