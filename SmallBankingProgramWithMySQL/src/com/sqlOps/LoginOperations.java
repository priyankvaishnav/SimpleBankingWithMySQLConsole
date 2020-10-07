package com.sqlOps;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.userAccount.UserAccount;

public class LoginOperations extends ConnectionOpenAndClose
{
    
    private String query;
    private ResultSet rs;
    
    public String giveUsernameToSaved(String name)
    {
	if(checkIfUsernameExists(name))
	    return name;
	return null;
    }
    
    public String giveUserPasswordToSaved(String username)
    {
	String upass=null;
	try
	{
	    openConnection();
	    query = "SELECT user_userpassword FROM user_info WHERE user_username = \""+username+"\"";
	    rs = getStatement().executeQuery(query);    
	    rs.absolute(1);
	    upass= rs.getString("user_userpassword");
	    
	    return upass;
	}
	catch (SQLException e)
	{
	    System.out.println("Cannot connect to db");
	    e.printStackTrace();
	    return null;
	}
	finally
	{
	    closeConnection(rs);
	}
	
    }
    
    public boolean checkIfUsernameExists(String name)
    {
	
	String uname=null; 
	try
	{
	    openConnection();
	    query = "SELECT user_username, USER_ID FROM user_info "
	    	+ "WHERE user_username = \""+name+"\";";
	    rs = getStatement().executeQuery(query);

	    rs.absolute(1);
	    uname= rs.getString("user_username");
	    if(uname.matches(name))
	    {	
		UserAccount.setId(rs.getInt("user_id"));
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
	catch (SQLException e)
	{
	    System.out.println("Cannot connect to db");
	    e.printStackTrace();
	    return false;
	}
	finally
	{
	    closeConnection(rs);
	}
	
    }
    
}
