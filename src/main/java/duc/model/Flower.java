package duc.model;

import javax.persistence.*;

@Entity
@Table
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flower_id;

    private String name;

    @ManyToOne
    @JoinColumn(columnDefinition = "category_id")
    private Category category;

    private int price;
    private int amount;
    private String image;
    private String description;

    public String getDescription() {
        return description;
    }

    public Flower setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Flower setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Flower setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Flower setImage(String image) {
        this.image = image;
        return this;
    }

    public Long getFlower_id() {
        return flower_id;
    }

    public Flower setFlower_id(Long flower_id) {
        this.flower_id = flower_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Flower setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Flower setCategory(Category category) {
        this.category = category;
        return this;
    }
}
