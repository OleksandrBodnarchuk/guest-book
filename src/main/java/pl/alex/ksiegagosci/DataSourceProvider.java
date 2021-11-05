package pl.alex.ksiegagosci;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProvider {
    private static DataSource dataSource;

    private DataSourceProvider() {
    }

    static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            Context init = new InitialContext();
            Context env = (Context) init.lookup("java:comp/env/");
            dataSource = (DataSource) env.lookup("jdbc/guestbook");
        }
        return dataSource;
    }
}
