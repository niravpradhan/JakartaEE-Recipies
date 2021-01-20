package org.jakartaeerecipes.chapter03.recipe03_01

import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.RequestScoped
import jakarta.inject.Named

@Named(value = 'helloWorldController')
@RequestScoped
class HelloWorldController implements Serializable {

    String hello

    @PostConstruct
    void init() {
        println 'Instantiated helloWorldController'
        hello = 'Hello World'
    }

}
