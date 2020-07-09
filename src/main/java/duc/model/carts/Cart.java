package duc.model.carts;

import duc.model.login.Account;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;


    @ManyToOne
    private Account account;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
    private Set<CartItem> cartItemList;

    public Long getCart_id() {
        return cart_id;
    }

    public Cart setCart_id(Long cart_id) {
        this.cart_id = cart_id;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Cart setAccount(Account account) {
        this.account = account;
        return this;
    }

    public Set<CartItem> getCartItemList() {
        return cartItemList;
    }

    public Cart setCartItemList(Set<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
        return this;
    }
}
