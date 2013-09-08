package cousys;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class concourier {
	static Connection conn;
 

	public static boolean createconnection() {
 
            
                 try{     
	String db="jdbc:odbc:s1";
	String un="scott";
	String pass="tiger";
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           conn=DriverManager.getConnection(db,un,pass); 
	 // stmt=conn.createStatement();
         }
           catch(Exception e)
      {               System.out.println("Connection to failed@@@@");
      return false;
                 }
            
		return true;

	} 
              

	public static ResultSet getData(String query) {
		ResultSet rs = null;
		Statement s = null;
		try {
			s = conn.createStatement();
			s.execute(query); // select the data from the
			// table
			rs = s.getResultSet();
			// while (rs.next()) // this will step through our data row-by-row
			// {
			// System.out.println("Data from column_name: " + rs.getString(1));
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				s.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return rs;
	}

	public static void closeStuff(ResultSet rs) {

		Statement st;
		try {
			st = rs.getStatement();
			rs.close();
			st.close();
		} catch (Exception e) {

		}
	}

	public static void testCon() {
		// TODO Auto-generated method stub
		ResultSet data = concourier.getData("select * from ");
		try {
			while(data.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		concourier.closeStuff(data);
		
	}


public static boolean execute(String query) {
	ResultSet rs = null;
	Statement s = null;
	try {
		s = conn.createStatement();
		if(!conn.isClosed())
			System.out.println("YESSSS");
		else
			System.out.println("FAULT");
		int r = s.executeUpdate(query); // select the data from the
		 
		// table
	conn.commit(); 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {
			s.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	finally
	{
		closeStuff(rs);
	}
	return true;
}

public static void closeConnection() {
	// TODO Auto-generated method stub
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
