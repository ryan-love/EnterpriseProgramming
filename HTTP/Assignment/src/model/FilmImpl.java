package model;
import java.sql.*;


public class FilmImpl
{
    {
        String urlPrefix = "jdbc:db2:";
        String user = "cbp25056";
        String password = "Givesuhell12";
        String url = "//dashdb-txn-sbox-yp-lon02-01.services.eu-gb.bluemix.net:50001/BLUDB:user=cbp25056;password=Givesuhell12;sslConnection=true;" ;
        String empNo;
        Connection con;
        Statement stmt;
        ResultSet rs;






        try
        {

            Class.forName("com.ibm.db2.jcc.DB2Driver");
            con = DriverManager.getConnection (url, user, password);
            con.setAutoCommit(false);


            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT EMPNO FROM EMPLOYEE");

            while (rs.next()) {
                empNo = rs.getString(1);
                System.out.println("Employee number = " + empNo);
            }

            rs.close();

            stmt.close();

            con.commit();

            con.close();




        }

        catch (ClassNotFoundException e)
        {
            System.err.println("Could not load JDBC driver");
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }

        catch(SQLException ex){
            System.err.println("SQLException information");
            while(ex!=null) {
                System.err.println ("Error msg: " + ex.getMessage());
                System.err.println ("SQLSTATE: " + ex.getSQLState());
                System.err.println ("Error code: " + ex.getErrorCode());
                ex.printStackTrace();
                ex = ex.getNextException(); // For drivers that support chained exceptions
            }
        }
    }
}