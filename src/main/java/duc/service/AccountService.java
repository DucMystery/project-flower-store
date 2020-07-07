package duc.service;

import duc.model.login.Account;

public interface AccountService {
    Account findAccountByUsername(String username);
}
