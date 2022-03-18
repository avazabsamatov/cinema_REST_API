package uz.pdp.cinema_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cinema_rest_api.model.Attachment;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
