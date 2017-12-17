package se.kth.id1212.tudd.currencyconverter.integration;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import se.kth.id1212.tudd.currencyconverter.model.Currency;

/**
 *
 * @author udde
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class ConverterDAO {

    @PersistenceContext(unitName = "converterPU")
    private EntityManager em;

    public String[] getCurrencies() {
        //em.persist(new Currency("SEK", 1)); // done once so the table is created

        Query query = em.createQuery("SELECT e FROM Currency e");
        List<Currency> resultSet = query.getResultList();
        String[] result = new String[resultSet.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultSet.get(i).getName();
        }

        return result;
    }

    public double getRateSEK(String name) {
        Currency currency = em.find(Currency.class, name);
        if (currency == null) {
            throw new EntityNotFoundException("Currency not in database.");
        }

        return currency.getRateSEK();
    }

}
