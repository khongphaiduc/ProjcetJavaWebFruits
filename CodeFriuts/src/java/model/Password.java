
package model;

public class Password {
  
    int passwordID;
    String keyPassword;
    Account accountID;

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

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Password{" + "passwordID=" + passwordID + ", keyPassword=" + keyPassword + ", accountID=" + accountID + '}';
    }
    
}
