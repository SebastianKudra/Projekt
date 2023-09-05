package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
    public double priceProduct;
    public String currencyProduct;
    public String zoneProductBiedronka;
    public String zoneProductLidl;
    public String zoneProductDino;



}
