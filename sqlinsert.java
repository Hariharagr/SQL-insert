import java.sql.*;
import java.util.*;
import java.text.*;
public class sqlinsert 
{
	public static void main(String[] args) throws Exception
	{
	String jdbc_driver = "oracle.jdbc.OracleDriver";
    String jdbc_url    = "jdbc:oracle:thin:@localhost:1521:XE";
	String user =        "scott";
	String  pwd =        "tiger";
    class.forName(jdbc_driver);
	Connection con = DriverManager.getConnection(jdbc_url, user, pwd );
	PreparedStatement pst = con.prepareStatement(sqlQuery);
    String sqlQuery = "insert into users values(?,?)"; 
	Scanner sc = new Scanner(System.in);
	System.out.println("enter name:");
	String  ename = sc.next();
	System.out.println("enter date dd-MM-yyyy");
	String  dob = sc.next();
	SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date udate = sfd.parse(dob);
	long l = udate.getTime();
	java.sql.Date sdate = new java.sql.Date(l);
    pst.setString(1,uname);
	pst.setDate  (2,sdate);
	int resultcount = pst.executeupdate();
    if (resultcount == 0)
    System.out.println("not inserted");
	else
    System.out.println("inserted");
	con.close();
	}
}



	}
}
