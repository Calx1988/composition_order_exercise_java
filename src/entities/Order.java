package entities;

import util.OrderStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<OrderItem>();
    private Customer customer;

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Customer customer) {
        this.moment = moment;
        this.status = status;
        this.customer = customer;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItems(OrderItem item) {
        items.add(item);
    }

    public void removeItems(OrderItem item) {
        items.remove(item);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double calcTotal(){
        double sum = 0;
        for (OrderItem it: items
             ) {
            sum += it.calculateSubTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ").append(getMoment());
        sb.append("\nStatus: ").append(getStatus());
        sb.append("\nCustomer: ").append(getCustomer());
        sb.append("\n---Items---");
        for (OrderItem it: items
             ) {
            sb.append("\n").append(it);
        }
        sb.append("\nTotal: $").append(String.format("%.2f", calcTotal()));

        return sb.toString();
    }
}
