package io.github.johann0301.webserviceproject.dto;

import java.util.List;

public class OrderDTO {
    private Long clientId;
    private List<OrderItemDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(Long clientId, List<OrderItemDTO> items) {
        this.clientId = clientId;
        this.items = items;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;

        public OrderItemDTO() {
        }

        public OrderItemDTO(Long productId, Integer quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
