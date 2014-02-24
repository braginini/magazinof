package ru.ncideas.magazinof.entity;

public class OrderGoods {

    private Order order;

    private Good good;

    private Long count;

    public OrderGoods() {
    }

    public OrderGoods(Order order, Good good, Long count) {
        this.order = order;
        this.good = good;
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderGoods that = (OrderGoods) o;

        if (!count.equals(that.count)) return false;
        if (!good.equals(that.good)) return false;
        if (!order.equals(that.order)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = order.hashCode();
        result = 31 * result + good.hashCode();
        result = 31 * result + count.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "order=" + order +
                ", good=" + good +
                ", count=" + count +
                '}';
    }
}
