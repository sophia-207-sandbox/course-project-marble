package entity;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Owner {
    private final String fullName;
    private final String username;
    private final byte[] password;
    private HashMap<Integer, Account> accounts; // accountID Integer, Account Object
    private static ArrayList<Integer> listOfAccountsID;


    /**
     * This is a constructor method to create an Owner object. Basically when this is called, a new Owner object is
     * created. Whether if its from reading the backup txt files or called to create a new owner.
     * @param fullName The full name of the user is stored here.
     * @param username The username that the person decided to use and to login is stored here.
     * @param password The password
     */
    public Owner(String fullName, String username, String password){
        this.fullName = fullName;
        this.username = username;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        this.password = md.digest(password.getBytes(StandardCharsets.UTF_8));
    }


    public String getName(){return this.fullName;}
    public String getUsername(){return this.username;}
    public HashMap<Integer, Account> getAccounts(){return this.accounts;}


    /**
     * This method creates accounts under the owner.
     * @param accountType The type of accounts that the user wants to create: Saving, Chequing
     * @return return true if the account is successfully created, else false
     */
    public boolean createAccount(String accountType){
        if (accountType.equals("Chequing")){
            Account newAccount = new Chequing(listOfAccountsID);
            int newAccountID = newAccount.getAccountID();
            listOfAccountsID.add(newAccountID);
            this.accounts.put(newAccountID, newAccount);
            return true;
        }
        else if(accountType.equals("Saving")){
            Account newAccount = new Saving(listOfAccountsID);
            int newAccountID = newAccount.getAccountID();
            listOfAccountsID.add(newAccountID);
            this.accounts.put(newAccountID, newAccount);
            return true;
        }
        return false;
    }


    /**
     * This function comparePasswords, hashes the parameter inputPassword and
     * compare it with the Owner's hashed password.
     * @param inputPassword the password a user inputs is compared against the actual password, "hashed" comparison
     *                      still needs to be implemented
     * @return true if the password matches, else return false
     */
    public boolean comparePassword(String inputPassword){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        byte[] inputPasswordHashed = md.digest(inputPassword.getBytes(StandardCharsets.UTF_8));

        if (this.password != null) {
            return Arrays.equals(this.password, inputPasswordHashed);
        }
        return false;
    }
}