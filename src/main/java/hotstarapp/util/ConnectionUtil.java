package hotstarapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import hotstarapp.exception.DbException;

public class ConnectionUtil {
	public static Connection dbConnect() throws DbException {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// ip,username,password

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		} catch (SQLException e) {

			throw new DbException("DB Connection Error");
		} catch (ClassNotFoundException e) {

			throw new DbException("Oracle Driver Not found");
		}
		return (con);
	}

	public static Jdbi getJdbi() {
		Jdbi jdbi = null;
		try {
			Connection con = dbConnect();
			jdbi = Jdbi.create(con);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return (jdbi);
	}

}
