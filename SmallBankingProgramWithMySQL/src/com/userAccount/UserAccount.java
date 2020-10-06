package com.userAccount;

public class UserAccount
{
    private float accountBalance;
    private static int user_id;
    public float getAccountBalance()
    {
	return accountBalance;
    }

    public void setAccountBalance(float accountBalance)
    {
	this.accountBalance = accountBalance;
    }

    public int getId()
    {
        return user_id;
    }

    public static void setId(int id)
    {
        user_id = id;
    }
    
    
}
