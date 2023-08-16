/**
 * @project SaleManagement
 */

package fa.training.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * author Duy Bach.
 * 
 * @time 2:28:26 PM
 * @date Jun 22, 2019
 */
public class DBUtils {

  static DBUtils instance;
  private Connection connection;

  public DBUtils() {
    Properties properties = new Properties();
    try {
      properties.load(
          DBUtils.class.getResourceAsStream("/dbInfo.properties"));

      String driver = properties.getProperty("driver");
      String url = properties.getProperty("url");
      String user = properties.getProperty("user");
      String pass = properties.getProperty("pass");

      Class.forName(driver);
      connection = DriverManager.getConnection(url, user, pass);

    } catch (IOException | SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public static DBUtils getInstance() throws SQLException {
    if (instance == null) {
      instance = new DBUtils();
    } else if (instance.getConnection().isClosed())
      instance = new DBUtils();
    return instance;
  }
}
