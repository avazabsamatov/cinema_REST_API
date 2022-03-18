package uz.pdp.cinema_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.cinema_rest_api.model.Attachment;
import uz.pdp.cinema_rest_api.model.AttachmentContent;
import uz.pdp.cinema_rest_api.model.Specialist;
import uz.pdp.cinema_rest_api.model.SpecialistType;
import uz.pdp.cinema_rest_api.projections.SpecialistProjection;
import uz.pdp.cinema_rest_api.repository.AttachmentContentRepository;
import uz.pdp.cinema_rest_api.repository.AttachmentRepository;
import uz.pdp.cinema_rest_api.repository.SpecialistRepository;


import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpecialistService {

    @Autowired
    private SpecialistRepository specialistRepository;

    @Autowired
    private AttachmentRepository attachmentRepo;

    @Autowired
    private AttachmentContentRepository attachmentContentRepo;

    public List<Specialist> getAllSpecialists() {
        return specialistRepository.findAll();
    }

    public Optional<Specialist> getSpecialistById(UUID uuid) {
        return specialistRepository.findById(uuid);
    }

    public List<SpecialistProjection> getSpecialistsByMovieId(UUID movieId) {
        return specialistRepository.findAllByMovieId(movieId);
    }

    public void saveSpecialist(Specialist specialist, MultipartFile file) throws IOException {

        Attachment attachment = new Attachment();
        attachment.setFileName(StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())));
        attachment.setContentType(file.getContentType());
        attachment.setSize(file.getSize());
        Attachment savedFile = attachmentRepo.save(attachment);

        specialist.setPhoto(savedFile);
        specialist.setCastType(SpecialistType.SPECIALIST_ACTOR);
        specialistRepository.save(specialist);

        AttachmentContent fileAttachment = new AttachmentContent();
        fileAttachment.setAttachment(savedFile);
        fileAttachment.setData(file.getBytes());
        attachmentContentRepo.save(fileAttachment);

    }

    public void updateSpecialist(UUID specialistId, Specialist specialist, MultipartFile file) throws IOException {

    }

    public void deleteSpecialist(UUID specialistId) {

        specialistRepository.deleteById(specialistId);

    }

}
