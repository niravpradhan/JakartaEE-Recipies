package org.jakartaeerecipes.chapter03.recipe03_02

import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.SessionScoped
import jakarta.faces.application.FacesMessage
import jakarta.faces.context.FacesContext
import jakarta.faces.model.SelectItem
import jakarta.inject.Named

import static org.jakartaeerecipes.chapter03.recipe03_02.CalculationType.*

@Named('calculationController')
@SessionScoped
class CalculationController implements Serializable {

    List<SelectItem> calculationList;
    BigDecimal num1;
    BigDecimal num2;
    BigDecimal result;
    CalculationType calculationType;

    @PostConstruct
    void init() {
        calculationList = []
        CalculationType.values().each { it ->
            calculationList << new SelectItem(it.name(), it.name())
        }
    }

    void performCalculation() {
        switch (calculationType) {
            case ADDITION:
                setResult(num1 + num2)
                break
            case SUBTRACTION:
                setResult(num1 - num2)
                break
            case MULTIPLICATION:
                setResult(num1 * num2)
                break
            case DIVISION:
                try {
                    setResult(num1 / num2)
                } catch (Exception ex) {
                    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 'Invalid Calculation', 'Invalid Calculation')
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg)
                }
                break
            default:
                break
        }
    }
}
