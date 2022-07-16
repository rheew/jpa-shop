package jpabook.jpashop.domain;

import jpabook.jpashop.domain.Item;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter
public class Movie extends Item {

    private String director;
    private String actor;
}
