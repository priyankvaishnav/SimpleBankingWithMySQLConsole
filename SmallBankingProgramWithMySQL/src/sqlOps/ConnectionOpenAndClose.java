package sqlOps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionOpenAndClose
{
    final String url = "jdbc:mysql://localhost:3306/banking_app";
    final String dbUser = "root";
    final String dbPass = "root";
    Connection con;
    Statement statement;   

    protected void openConnection()
    {
	try
	{
	    con = DriverManager.getConnection(url, dbUser, dbPass);
	    statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	}
	catch (SQLException e)
	{
	    System.out.println("Cannot connect to db");
	    e.printStackTrace();
	}
    }
    
    public Statement getStatement()
    {
	return statement;
    }
    protected void closeConnection(ResultSet rs)
    {
	try
	{
	    rs.close();
	    statement.close();
	    con.close();
	}
	catch (SQLException e)
	{
	    System.out.println("Cannot close");
	    e.printStackTrace();
	}
    }    
}
