package duc.service;

import duc.model.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

public interface FlowerService {
    Iterable<Flower> findAll();
    Flower findById(Long id);

    void save(Flower flower);
    Flower remove(Long id);
    Page<Flower> findAll(Pageable pageable);
    Page<Flower> findAllByNameContaining(String name,Pageable pageable);
}
