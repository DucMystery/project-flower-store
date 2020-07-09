package duc.repository;

import duc.model.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends PagingAndSortingRepository<Flower,Long> {
    Page<Flower> findAllByNameContaining(String name, Pageable pageable);
}
