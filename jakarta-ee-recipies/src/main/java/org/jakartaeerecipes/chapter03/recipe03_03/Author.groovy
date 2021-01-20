package org.jakartaeerecipes.chapter03.recipe03_03

import groovy.transform.Canonical

@Canonical
class Author implements Serializable {

    String first;
    String last;
    String bio;
}
