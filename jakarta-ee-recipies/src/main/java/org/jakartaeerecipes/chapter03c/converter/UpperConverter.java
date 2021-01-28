package org.jakartaeerecipes.chapter03c.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 * @author juneau
 */
@FacesConverter("org.jakartaeerecipes.converter.UpperConverter")
public class UpperConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
                              String value) {
        // Return String value in upper case
        return value.toString().toUpperCase();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
                              Object value) {

        // Return String value
        return value.toString().toUpperCase();

    }
}
