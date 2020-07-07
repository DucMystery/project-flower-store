package duc.repository;

import duc.model.login.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role,Long> {
}
