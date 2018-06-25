package vehical.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbOps_Driver_details {

    String url = "jdbc:mysql://localhost:3306/vehical_management";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
String comboNames;
    boolean add_driver(Driver_Details dd) {
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO driver_details VALUES(?,?,?,?,?,CURDATE())";// Insert data into "drivet_details" table. 
            pst = con.prepareStatement(query);
            pst.setInt(1, dd.getDriver_id());
            pst.setString(2, dd.getDriver_name());
            pst.setInt(3, dd.getPhone_number());
            pst.setInt(4, dd.getAge());
            pst.setString(5, dd.getAddress());
            pst.executeUpdate();
            
            String driver = "INSERT INTO available_drivers (driver_id,name) VALUES ("+dd.getDriver_id()+",'"+dd.getDriver_name()+"')";
            pst = con.prepareStatement(driver);
            pst.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(dbOps_Driver_details.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    boolean remove_driver(Driver_Details dd) {
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM driver_details WHERE driver_id=" + dd.getDriver_id();
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(dbOps_Driver_details.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    ResultSet get_details() {
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM driver_details";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(dbOps_Driver_details.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }



}
