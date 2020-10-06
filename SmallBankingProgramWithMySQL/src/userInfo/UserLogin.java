package userInfo;

import java.util.Scanner;
import sqlOps.LoginOperations;

public class UserLogin
{
    private String savedUserName;
    private String savedPassword;
    private LoginOperations loginOperations;
    public UserLogin()
    {
	loginOperations = new LoginOperations();
    }
    
    
    public String getSavedUserName()
    {
	savedUserName = loginOperations.giveUsernameToSaved(getUserName());
        return savedUserName;
    }
    
    public String getSavedPassword()
    {
	savedPassword = loginOperations.giveUserPasswordToSaved(savedUserName);
        return savedPassword;
    }
    
    private String userName;
    private String userPassword;
        
    public String getUserName()
    {
        return userName;
    }

    private void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    private void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
    
    public void loadUserNameAndPasswordFromUser()
    {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter your user name:");
	String enteredUserName = scanner.nextLine();
	System.out.println("Please enter your password:");
	String enteredPassword = scanner.nextLine();

	setUserName(enteredUserName);
	setUserPassword(enteredPassword);
    }
    
    public boolean checkUserName(String uName, String pass)
    {
	if (uName.equals(getSavedUserName()))
	{
	    return checkPassword(uName, pass);
	    
	}
	else
	{
	    System.out.println("user name does not exist");
	    return false;
	}
	    
    }
    
    private boolean checkPassword(String uName, String pass)
    {
	if(pass.equals(getSavedPassword()))
	{
	    System.out.println("Welcome "+getUserName());
	    return true;
	}
	else
	{
	    System.out.println("wrong password");
	    return false;
	}
    }
    
    
}
