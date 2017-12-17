package se.kth.id1212.tudd.currencyconverter.view;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import se.kth.id1212.tudd.currencyconverter.controller.ConverterFacade;

/**
 *
 * @author udde
 */
@Named("viewManager")
@RequestScoped
public class ViewManager {

    private double result;

    @EJB
    private ConverterFacade controller;

    public String[] getCurrencies() {
        return controller.getCurrencies();
    }

    public void convert() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String fromCurrency = request.getParameter("form:fromCurrency");
            String toCurrency = request.getParameter("form:toCurrency");
            double amount = new Double(request.getParameter("form:amount"));
            result = controller.convert(amount, fromCurrency, toCurrency);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public double getResult() {
        return result;
    }

}
