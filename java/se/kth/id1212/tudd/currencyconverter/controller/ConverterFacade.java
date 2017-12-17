package se.kth.id1212.tudd.currencyconverter.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import se.kth.id1212.tudd.currencyconverter.integration.ConverterDAO;

/**
 *
 * @author udde
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class ConverterFacade {

    @EJB
    ConverterDAO converterDB;

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRateSek = converterDB.getRateSEK(fromCurrency);
        double toRateSek = converterDB.getRateSEK(toCurrency);
        double result = (amount * fromRateSek) / toRateSek;
        return result;
    }

    public String[] getCurrencies() {
        return converterDB.getCurrencies();
    }

}
