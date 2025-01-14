/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import rest.AdminRESTClient;

/**
 *
 * @author 2dam
 */
public class AdminManagerFactory {
    
    private static AdminManager adminManager;
    
    public static AdminManager get(){
        if(adminManager == null){
            adminManager = new AdminRESTClient();
        }
        return adminManager;
    }
    
}
