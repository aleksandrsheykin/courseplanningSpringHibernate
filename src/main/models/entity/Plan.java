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

}
