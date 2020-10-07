package com.main;


import com.bankingOperations.Operations;
import com.userInfo.UserLogin;

public class MainClass
{

    public static void main(String[] args)
    {
	UserLogin newUserLogin = new UserLogin();
	newUserLogin.loadUserNameAndPasswordFromUser();
	boolean resultLogin = newUserLogin.checkUserName(newUserLogin.getUserName(), newUserLogin.getUserPassword());
	if (resultLogin)
	{
	    Operations operations = new Operations();
	    operations.operationsMenu();
	}
    }

}
