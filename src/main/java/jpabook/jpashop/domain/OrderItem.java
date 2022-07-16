package jpabook.jpashop.domain;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;
    private int count;

    public void cancel() {
        item.addStock(count);
    }

    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }

    public OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();

        orderItem.setItem(item);
        orderPrice = orderPrice;
        count = count;
        item.removeStock(count);

        return orderItem;
    }
}
