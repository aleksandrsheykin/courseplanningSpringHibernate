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
    private Integer id_plan;
    @Column(name = "plan_date")
    private Date datePlan;
    @Column(name = "plan_quantity")
    private int quantity;
    @Column(name = "plan_cost")
    private int cost;
    @Column(name = "plan_user_id")
    private int userId;

    @Column(name = "plan_product_id", columnDefinition = "integer")
    private Product product;

    public Plan(Integer id_plan, Date datePlan, int quantity, int cost, int userId, Product product) {
        this.id_plan = id_plan;
        this.datePlan = datePlan;
        this.quantity = quantity;
        this.cost = cost;
        this.userId = userId;
        this.product = product;
    }

    public Integer getId_plan() {
        return id_plan;
    }

    public void setId_plan(Integer id_plan) {
        this.id_plan = id_plan;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user) {
        this.userId = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
