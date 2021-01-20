package org.jakartaeerecipes.chapter02.recipe02_12;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Recipe 1-20
 *
 * @author juneau
 */
public class AuthorBean implements java.io.Serializable {

    public List<Author> queryAuthors() {
        String sql = "select id, firstname, lastname from book_author";
        List<Author> authorList = new ArrayList<>();
        try (Connection conn = ((DataSource) new InitialContext().lookup("jdbc/__npmydbpool")).getConnection();
             PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();) {

            // Returns row-count or 0 if not successful
            System.out.println("executing statement");
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setFirst((rs.getString("firstname")));
                author.setLast(rs.getString("lastname"));
                authorList.add(author);
                System.out.println("got author: " + author);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public List getAuthorList() {
        List<Author> authorList = queryAuthors();
        System.out.println("authorlist: " + authorList);
        return authorList;
    }
}
