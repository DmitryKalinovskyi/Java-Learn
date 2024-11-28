package com.education.ztu.Task2;

public class Main {
    public static void main(String[] args){
        String invalidLogin = "Дмитро";
        String validLogin = "deeper";
        String validPassword1 = "123456789";
        String validPassword2 = "qwertyuiop";
        String invalidPassword = "Zhytomyr123$";

        assert !CredentialsChecker.checkCredentials(invalidLogin, validPassword1, validPassword1) : "Credentials should be invalid.";
        assert !CredentialsChecker.checkCredentials(validLogin, invalidPassword, invalidPassword) : "Credentials should be invalid.";
        assert !CredentialsChecker.checkCredentials(validLogin, validPassword1, validPassword2) : "Credentials should be invalid.";
        assert CredentialsChecker.checkCredentials(validLogin, validPassword1, validPassword1) : "Credentials should be valid.";
    }

}
