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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String nameProduct;
    public Long quantityProduct;
    public String baseOfMeasure;
    public BigDecimal priceProduct;
    public String currencyProduct;
    public String zoneProductBiedronka;
    public String zoneProductLidl;
    public String zoneProductDino;

    @ManyToOne
    public Shop shop;
    @ManyToOne
    public Quantity quantity;

}
