package pl.alex.ksiegagosci;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private final DataSource dataSource;

    public CommentDao() {
        try{
            dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    void save(Comment comment) {
        final String addQuery =
                String.format("insert into guestbook.guestbook (author, note) " +
                        "values ('%s', '%s')", comment.getAuthor(), comment.getComment());
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(addQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<Comment> findAll() {
        final String findAllQuery = "SELECT * FROM guestbook.guestbook order by id desc";
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(findAllQuery);
            while (resultSet.next()) {
                String author = resultSet.getString("author");
                String note = resultSet.getString("note");
                comments.add(new Comment(author, note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comments;
    }
}
