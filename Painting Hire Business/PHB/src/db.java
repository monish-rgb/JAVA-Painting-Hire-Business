import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class db {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static  int save(String name,String contact,String address){
		int status=0;
		try{
			Connection con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into person(name,contact,address) values(?,?,?)");
			ps.setString(1,name);
			ps.setString(2,contact);
			ps.setString(3,address);
			
			
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
}

	public static int delete(int contact) {
		// TODO Auto-generated method stub
		int status=0;
		try{
			Connection con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from person where contact=?");
			ps.setInt(1,contact);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}