package org.jakartaeerecipes.chapter03.recipe03_13

import jakarta.enterprise.context.RequestScoped
import jakarta.inject.Named

@Named("ajaxBean")
@RequestScoped
class AjaxBean {

    String value1
    String value2
    String status

    void process() {
        status = 'Validated'
        println "Value1: ${value1}"
        println "Value2: ${value2}"
        println "Status: ${status}"
    }
}
