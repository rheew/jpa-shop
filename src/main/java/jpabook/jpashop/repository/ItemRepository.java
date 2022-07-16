package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public Item save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
            return item;
        }
        em.merge(item);
        return item;
    }
}
