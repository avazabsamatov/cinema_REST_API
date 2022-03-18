package uz.pdp.cinema_rest_api.service;

import org.springframework.stereotype.Service;
import uz.pdp.cinema_rest_api.model.Row;
import uz.pdp.cinema_rest_api.repository.RowRepository;

import java.util.List;

@Service
public class RowService {
    final RowRepository repository;

    public RowService(RowRepository repository) {
        this.repository = repository;
    }

    public List<Row> getAllRow(){
        return repository.findAll();
    }
}
