package Game.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class GameSavingDataBase {

    public static void CreateDataBase() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:GameSave.db");
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Ranking(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, LapTime Real NOT NULL ,LapCount INT NOT NULL,Level INT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}
