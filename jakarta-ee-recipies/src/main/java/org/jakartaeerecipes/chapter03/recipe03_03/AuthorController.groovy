package org.jakartaeerecipes.chapter03.recipe03_03


import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named

@Named(value = "authorController")
@SessionScoped
class AuthorController implements Serializable {

    String newAuthorFirst
    String newAuthorLast
    String bio
    List<Author> authorList

    @PostConstruct
    void populateAuthorList() {
        println 'initializng authors'
        authorList = []
        authorList << new Author("Josh", "Juneau", null)
        authorList << new Author("Carl", "Dea", null)
        authorList << new Author("Mark", "Beaty", null)
        authorList << new Author("John", "O'Conner", null)
        authorList << new Author("Freddy", "Guime", null)
        println "AuthorList size: ${authorList.size()}"
    }

    void addAuthor() {
        authorList << new Author(newAuthorFirst, newAuthorLast, bio)
    }

    void deleteAuthor(Author author) {
        authorList -= author
    }
}
