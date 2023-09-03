package pl.coderslab.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@ToString
@Table(name = "quantity")
public class Quantity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer id;
    public BigDecimal quantity;
    public String baseOfMeasures;

}
