package duc.model.login;

import javax.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;

    @Column(unique = true)
    private String username;
    private String password;

    @ManyToOne
    private Role role;

    public Long getAccount_id() {
        return account_id;
    }

    public Account setAccount_id(Long account_id) {
        this.account_id = account_id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public Account setRole(Role role) {
        this.role = role;
        return this;
    }
}
