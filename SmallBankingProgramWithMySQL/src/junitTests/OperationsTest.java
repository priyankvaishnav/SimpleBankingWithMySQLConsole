package junitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bankingOperations.Operations;

import sqlOps.AccountOperations;
import sqlOps.LoginOperations;

class OperationsTest
{


    @Test
    void operationsMenuTest()
    {
	Operations ops = new Operations();
	ops.operationsMenu();
    }
    
    @Test
    void checkIfUsernameExistsTest()
    {
	    LoginOperations cl = new LoginOperations();
	assertEquals(true, cl.checkIfUsernameExists("priyank"));
    }
    @Test
    void getUserBalanceTest()
    {
	AccountOperations ao = new AccountOperations();
	assertEquals(100, ao.showBalance(1001));
    }
    
}
