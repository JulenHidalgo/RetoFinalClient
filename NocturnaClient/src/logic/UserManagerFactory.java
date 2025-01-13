/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import rest.UserRESTClient;

/**
 *
 * @author 2dam
 */
public class UserManagerFactory {
    
    private static UserManager userManager;
    
    public static UserManager get(){
        if(userManager == null){
            userManager = new UserRESTClient();
        }
        return new UserRESTClient();
    }
    
}
