package duc.model.login;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @Column(unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }

    public Long getRole_id() {
        return role_id;
    }

    public Role setRole_id(Long role_id) {
        this.role_id = role_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }
}
