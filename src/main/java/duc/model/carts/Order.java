package duc.model.carts;

import duc.model.login.Account;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @OneToOne
    private Account account;

    @OneToMany(targetEntity = Cart.class)
    private List<Cart> carts;

    public Long getOrder_id() {
        return order_id;
    }

    public Order setOrder_id(Long order_id) {
        this.order_id = order_id;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Order setAccount(Account account) {
        this.account = account;
        return this;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public Order setCarts(List<Cart> carts) {
        this.carts = carts;
        return this;
    }
}
