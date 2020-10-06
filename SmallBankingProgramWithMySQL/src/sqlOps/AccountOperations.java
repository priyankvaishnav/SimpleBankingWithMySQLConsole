package sqlOps;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.userAccount.UserAccount;

public class AccountOperations extends ConnectionOpenAndClose
{
    private UserAccount ua = new UserAccount();
    private String query;
    private ResultSet rs;
    
    public float showBalance(int id)
    {
	retriveBalance(id);
	return ua.getAccountBalance();
    }
    
    private void retriveBalance(int id)
    {
	query = "SELECT user_account_balance FROM user_account WHERE user_id = "+id+" ;";
	try
	{
	    openConnection();
	    rs = getStatement().executeQuery(query);
	    rs.absolute(1);
	    ua.setAccountBalance(rs.getFloat("user_account_balance"));
	} catch (SQLException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection(rs);
	}
    }
    
    public String withdrawMoney(int id, float withdrawAmount)
    {
	if(isWithdrawPossible(id, withdrawAmount))
	{
	    float newBalance = showBalance(id) - withdrawAmount;
	    updateBalance(id, newBalance);
	    return "Withdraw Successfull";
	}
	return "not enough balance";
    }
    
    private boolean isWithdrawPossible(int id, float withdrawAmount)
    {
	float balance = showBalance(id);
	if(withdrawAmount > balance)
	    return false;
	return true;
    }
    
    private void updateBalance(int id, float newBalance)
    {
	query = "UPDATE user_account "
		+ " SET user_account_balance = "+newBalance+
		" WHERE user_id ="+id;
	
	openConnection();
	try
	{
	    getStatement().executeUpdate(query);
	    ua.setAccountBalance(newBalance);
	} catch (SQLException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection(rs);
	}
    }
    
    public String depositMoney(int id, float depositAmount)
    {
	float balance = showBalance(id);
	float newBalance = balance + depositAmount;
	updateBalance(id, newBalance);
	return "Deposit Successfull";
    }
}
