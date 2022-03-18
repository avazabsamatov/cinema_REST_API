package uz.pdp.cinema_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.cinema_rest_api.entity.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "halls")
public class Hall extends AbsEntity {

    @Column(nullable = false, length = 50)
    private String name;

    private Double vip_additional_fee_in_percent;

    public Hall(String name) {
        this.name = name;
    }

}
