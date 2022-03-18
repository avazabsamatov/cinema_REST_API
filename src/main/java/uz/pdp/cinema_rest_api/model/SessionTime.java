package uz.pdp.cinema_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.cinema_rest_api.entity.AbsEntity;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "session_times")
@EqualsAndHashCode(callSuper = true)
public class SessionTime extends AbsEntity {

    private Timestamp time;

    private Double session_additional_fee_in_percent;
}
