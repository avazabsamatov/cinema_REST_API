package uz.pdp.cinema_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.cinema_rest_api.entity.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "attachments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attachment extends AbsEntity {

    private String fileName;

    private String contentType;

    private long size;

}
