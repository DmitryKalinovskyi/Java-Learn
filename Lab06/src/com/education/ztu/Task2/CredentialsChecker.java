package com.education.ztu.Task2;

import com.education.ztu.Task2.Exceptions.WrongLoginException;
import com.education.ztu.Task2.Exceptions.WrongPasswordException;

public class CredentialsChecker {
    private static boolean isLoginValid(String login){
        if(login.length() >= 20) return false;

        String allowedCharacters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";
        for(char c : login.toCharArray()){
            if(allowedCharacters.indexOf(c) == -1) return false;
        }

        return true;
    }

    private static boolean isPasswordValid(String password){
        if(password.length() >= 20) return false;

        String allowedCharacters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";
        for(char c : password.toCharArray()){
            if(allowedCharacters.indexOf(c) == -1) return false;
        }

        return true;
    }

    public static boolean checkCredentials(String login, String password, String confirmPassword){
        try{
            if(!isLoginValid(login)){
                throw new WrongLoginException("Login is invalid.");
            }

            if(!isPasswordValid(password) || !password.equals(confirmPassword)){
                throw new WrongPasswordException("Password is invalid.");
            }
        }catch(WrongLoginException | WrongPasswordException e){
            return false;
        }

        return true;
    }
}
