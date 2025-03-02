/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Account {

    int accountID;
    String accountMail;

    public Account(int accountID, String accountMail) {
        this.accountID = accountID;
        this.accountMail = accountMail;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountMail() {
        return accountMail;
    }

    public void setAccountMail(String accountMail) {
        this.accountMail = accountMail;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", accountMail=" + accountMail + '}';
    }

}
