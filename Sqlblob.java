import java.sql.*;
import java.io.*;
public class BLOBdemo1
{
    public static void main(String[] args) throws Exception
    {
        String jdbc_driver = "oracle.jdbc.OracleDriver";
        String jdbc_url    = "jdbc:oracle:thin:@localhost:1521:XE";
        String user =        "scott";
        String  pwd =        "tiger";
        Class.forName(jdbc_driver);
        Connection con = DriverManager.getConnection(jdbc_url, user, pwd );
        String sqlQuery = "select * from persons";
        PreparedStatement pst = con.prepareStatement(sqlQuery);
        FileOutputStream fos = new FileOutputStream("image1");
        ResultSet rs = pst.executeQuery();
        if(rs.next())
        {
            String name = rs.getString(1);
            InputStream is = rs.getBinaryStream(2);
            byte[] buffer =new byte(2028);
            while(is.read(buffer)>0)
            {
                fos.write(buffer);
            }
            fos.flush();
        }
        con.close();
    }
}