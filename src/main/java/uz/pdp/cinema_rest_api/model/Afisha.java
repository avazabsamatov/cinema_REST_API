package uz.pdp.cinema_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.cinema_rest_api.entity.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "afishalar")
@EqualsAndHashCode(callSuper = true)
public class Afisha extends AbsEntity {

    @ManyToOne
    private Movie movie;

    private Boolean is_active;
}
