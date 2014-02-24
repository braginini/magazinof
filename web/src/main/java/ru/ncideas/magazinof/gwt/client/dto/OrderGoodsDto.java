package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;

//created by m.bragin
public class OrderGoodsDto implements Serializable {

    private OrderDto order;

    private GoodDto good;

    private Long count;

    public OrderGoodsDto() {
    }

    public OrderGoodsDto(OrderDto order, GoodDto good, Long count) {
        this.order = order;
        this.good = good;
        this.count = count;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public GoodDto getGood() {
        return good;
    }

    public void setGood(GoodDto good) {
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

        OrderGoodsDto that = (OrderGoodsDto) o;

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
