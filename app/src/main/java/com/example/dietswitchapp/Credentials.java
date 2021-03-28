package com.example.dietswitchapp;

import java.util.HashMap;
import java.util.Map;

public class Credentials {

    HashMap<String,String> credentialsmapper = new HashMap<String,String>();

    public void addCredentials(String username, String password){
        credentialsmapper.put(username, password);
    }

    public boolean checkUsername(String username){
        return credentialsmapper.containsKey(username);
    }

    public boolean verifyCredentials(String username,String password){

        /* controllo se l'username esiste*/
        if(credentialsmapper.containsKey(username)){
            /* controllo che le password corrispondano */
            if(password.equals(credentialsmapper.get(username))){
                return true;
            }
        }

        return false;
    }

    public void loadCredentials(Map<String, ?> preferencesMap){
        for(Map.Entry<String,?> entries: preferencesMap.entrySet()){
            if(!entries.getKey().equals("RememberMeCheckBox")){
                credentialsmapper.put(entries.getKey(),entries.getValue().toString());
            }
        }
    }
}
