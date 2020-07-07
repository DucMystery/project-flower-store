package duc.service.Impl;

import duc.model.Flower;
import duc.repository.FlowerRepository;
import duc.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;
    @Override
    public Iterable<Flower> findAll() {
        return flowerRepository.findAll();
    }

    @Override
    public Flower findById(Long id) {
        return flowerRepository.findOne(id);
    }

    @Override
    public void save(Flower flower) {
        flowerRepository.save(flower);
    }

    @Override
    public Flower remove(Long id) {
        flowerRepository.delete(id);
        return flowerRepository.findOne(id);
    }

    @Override
    public Page<Flower> findAll(Pageable pageable) {
        return flowerRepository.findAll(pageable);
    }

    @Override
    public Page<Flower> findAllByNameContaining(String name, Pageable pageable) {
        return flowerRepository.findAllByNameContaining(name,pageable);
    }
}
