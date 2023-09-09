package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Setter
@Getter
@ToString
@Table(name = "quantity")
public class Quantity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer id;

    public double quantity;


    public String baseOfMeasures;





}
