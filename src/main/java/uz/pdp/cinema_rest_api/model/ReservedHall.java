package uz.pdp.cinema_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.cinema_rest_api.entity.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reserved_halls")
@EqualsAndHashCode(callSuper = true)
public class ReservedHall extends AbsEntity {

    @ManyToOne
    private Hall hall;

    @OneToOne
    private Attachment attachment;

    @ManyToOne
    private SessionDate sessionDate;

    @ManyToOne
    private SessionTime start_time;

    @ManyToOne
    private SessionTime end_time;

    @ManyToOne
    private Afisha afisha;

    private String movieAnnouncements;
}
