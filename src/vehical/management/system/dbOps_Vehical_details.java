package vehical.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbOps_Vehical_details {

    String url = "jdbc:mysql://localhost:3306/vehical_management";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    boolean add_vehicals(Vehical_details vd) {

        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO vehical_details VALUES(?,?,?,?,?,?,CURDATE())";
            pst = con.prepareStatement(query);
            pst.setString(1, vd.getVehical_no());
            pst.setString(2, vd.getVehical_type());
            pst.setInt(3, vd.getNoOfSeats());
            pst.setString(4, vd.getFual_Type());
            pst.setInt(5, vd.getCurrentODOReading());
            pst.setInt(6, vd.getManufacYear());
            pst.executeUpdate();
            System.out.println("inset into vehical details");
            String aveil = "INSERT INTO available_vehicals (vehical_no) VALUES ('"+vd.getVehical_no()+"')";
            pst = con.prepareStatement(aveil);
            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(dbOps_Vehical_details.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("excep add vehical----> " + ex);
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

    ResultSet get_details() {

        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM vehical_details";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            System.out.println("get details");
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(dbOps_Vehical_details.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("get details failed!");
            return null;
        }

    }

    boolean remove_vehical(Vehical_details vd) {
        try {

            con = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM vehical_details WHERE vehical_no='" + vd.getVehical_no() + "'";
            System.out.println("dbOps ----> " + vd.getVehical_no());
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("ok lets see");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(dbOps_Vehical_details.class.getName()).log(Level.SEVERE, null, ex);
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

}
