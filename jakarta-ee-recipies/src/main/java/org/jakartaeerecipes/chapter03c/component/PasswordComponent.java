package org.jakartaeerecipes.chapter03c.component;


import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UIComponentBase;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;

import java.io.IOException;

/**
 * @author juneau
 */
@FacesComponent("components.PasswordComponent")
public class PasswordComponent extends UIComponentBase {

    UIInput password = null;
    UIInput confirmPassword = null;

    @Override
    public String getFamily() {
        return "org.javaee8recipes.chapter06.component";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {

        String value = (String) getAttributes().get("value");

        if (value != null) {
            ResponseWriter writer = context.getResponseWriter();
            //   writer.write(password);
            writer.write("<br/><br/>");
            // writer.write(confirmPassword);

        }
    }
}
