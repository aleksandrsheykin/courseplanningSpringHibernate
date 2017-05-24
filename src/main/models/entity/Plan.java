package main.models.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 19.04.2017.
 */
@Entity
@Table(name="Plans")
public class Plan {
    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue
    private Integer id;
    private Date datePlan;
    private int quantity;
    private int cost;

    public Plan() {
    }

    public Plan(Date datePlan, int quantity, int cost) {
        this.datePlan = datePlan;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatePlan() {
        return datePlan;
    }

    public void setDatePlan(Date datePlan) {
        this.datePlan = datePlan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
