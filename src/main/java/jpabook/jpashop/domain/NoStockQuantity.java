package jpabook.jpashop.domain;

public class NoStockQuantity extends RuntimeException {
    public NoStockQuantity(String message) {
        super(message);
    }
}
