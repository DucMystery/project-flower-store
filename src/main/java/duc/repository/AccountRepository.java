package duc.repository;

import duc.model.login.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account,Long> {
    Account findAccountByUsername(String username);
}
