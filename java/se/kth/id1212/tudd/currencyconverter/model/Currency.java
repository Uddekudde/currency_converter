package se.kth.id1212.tudd.currencyconverter.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author udde
 */
@Entity
public class Currency implements Serializable {

    @Id
    private String name;
    private double inSEK;

    public Currency() {
    }

    public Currency(String name, double rate) {
        this.name = name;
        this.inSEK = rate;
    }

    public String getName() {
        return name;
    }

    public double getRateSEK() {
        return inSEK;
    }

}
