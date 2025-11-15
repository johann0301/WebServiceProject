package io.github.johann0301.webserviceproject.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELLED(4),
    PAID(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code: " + code);
    }

}
