package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private List<Category> categories;

    public void addStock(int count) {
        stockQuantity += count;
    }

    public void removeStock(int count) {
        if (stockQuantity - count < 0) {
            throw new NoStockQuantity("재고가 없습니다.");
        }
        stockQuantity -= count;
    }
}
