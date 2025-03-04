
package model;


public class Password {
    
    int passwordID;
    String keyPassword;
    Account accountAll;

    public Password(int passwordID, String keyPassword, Account accountAll) {
        this.passwordID = passwordID;
        this.keyPassword = keyPassword;
        this.accountAll = accountAll;
    }

    public int getPasswordID() {
        return passwordID;
    }

    public void setPasswordID(int passwordID) {
        this.passwordID = passwordID;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public Account getAccountAll() {
        return accountAll;
    }

    public void setAccountAll(Account accountAll) {
        this.accountAll = accountAll;
    }

    @Override
    public String toString() {
        return "Password{" + "passwordID=" + passwordID + ", keyPassword=" + keyPassword + ", accountAll=" + accountAll + '}';
    }
    
    
}
