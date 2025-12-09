package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2Database {

    private static final String URL = "jdbc:h2:mem:productos;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static void init() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            conn.createStatement().execute("""
                CREATE TABLE productos (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100),
                    price DOUBLE
                );
            """);

            conn.createStatement().execute("""
                INSERT INTO productos (name, price) VALUES
                ('Teclado mecánico', 59.99),
                ('Ratón inalámbrico', 19.90),
                ('Auriculares gaming', 79.90),
                ('Alfombrilla XL', 10.00),
                ('Webcam HD', 29.95);
            """);

            System.out.println("[H2] Base de datos inicializada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
