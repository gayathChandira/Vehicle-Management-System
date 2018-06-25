package vehical.management.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBops_Occupying {

    String url = "jdbc:mysql://localhost:3306/vehical_management";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Occupied_vehicals occ = new Occupied_vehicals();
    String comboNames;

    boolean occupying_vehical(Occupied_vehicals oc) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO departing_vehicals VALUES (?,?,?,?,?, NOW())";//Insert data into "departing vehicals" table

            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, oc.getVehical_no());
            pst.setString(2, oc.getDriver_name());
            pst.setInt(3, oc.getMeter_reading());
            pst.setString(4, oc.getPurpose());
            pst.setString(5, oc.getReceivedBy());
            pst.executeUpdate();

            String adoo = "DELETE FROM available_vehicals WHERE vehical_no='" + oc.getVehical_no() + "'";
            pst = (PreparedStatement) con.prepareStatement(adoo); // delete data of regarding departing 
            //vehical from "available vehicals" table

            pst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DBops_Occupying.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("excepOccupyingVehical---> " + ex);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    boolean arriving_vehicals(Available_Vehicals av) {

        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO available_vehicals VALUES(?,?,?,NOW())";//insert data into "available vehicals" table.
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, av.getVehical_No());
            pst.setString(2, av.getDriver_name());
            pst.setInt(3, av.getMeter_reading());
            pst.executeUpdate();

            String dog = "DELETE FROM departing_vehicals WHERE  vehical_no='" + av.getVehical_No() + "'";
            pst = (PreparedStatement) con.prepareStatement(dog);           //delete data from "departing vehicals" table.
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBops_Occupying.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("excepArrivingVehical---> " + ex);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    boolean occuping_drivers(Occupied_vehicals oc) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String occupying_driv = "INSERT INTO departing_drivers VALUES (?,?,?,null)";
            pst = (PreparedStatement) con.prepareStatement(occupying_driv);

            pst.setString(1, oc.getDriverID());
            pst.setString(2, oc.getDriver_name());
            pst.setString(3, oc.getVehical_no());
            pst.executeUpdate();
            System.out.println("insert diver to departing table");

            String deleteDri = "DELETE FROM available_drivers WHERE driver_id='" + oc.getDriverID() + "'";
            pst = (PreparedStatement) con.prepareStatement(deleteDri);
            pst.executeUpdate();
            System.out.println("delete dirver from available table");

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBops_Occupying.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    ResultSet aveilVehi_table() {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT vehical_details.vehical_no, vehical_details.vehical_type,vehical_details.no_of_seats, vehical_details.fual_type FROM vehical_details"
                    + " INNER JOIN available_vehicals ON vehical_details.vehical_no=available_vehicals.vehical_no";
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(DBops_Occupying.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not working");
            return null;
        }

    }

    

}
/*String query = "SELECT vehical_details.vehical_no, vehical_details.vehical_type,vehical_details.no_of_seats, vehical_details.fual_type FROM vehical_details"
                    + " INNER JOIN available_vehicals ON vehical_details.vehical_no=available_vehicals.vehical_no";*/
