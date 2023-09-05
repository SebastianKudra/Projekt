package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name="shoppingList")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @ManyToOne
    @JoinColumn (name = "product_id", nullable = false)
    public Product product;
    @ManyToOne
    @JoinColumn (name = "quantity_id",nullable = false)
    public Quantity quantity;


}
