package uz.pdp.cinema_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.cinema_rest_api.model.ReservedHall;
import uz.pdp.cinema_rest_api.repository.ReservedHallRepository;

import java.util.List;

@Service
public class ReservedHallService {
    @Autowired
    ReservedHallRepository reservedHallRepository;

    public List<ReservedHall> getReservedHalls() {
        return reservedHallRepository.findAll();
    }
}
