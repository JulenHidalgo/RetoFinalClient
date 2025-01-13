/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import rest.ClientRESTClient;

/**
 *
 * @author 2dam
 */
public class ClientManagerFactory {
    
    private static ClientManager clientManager;
    
    public static ClientManager get(){
        if(clientManager == null){
            clientManager = new ClientRESTClient();
        }
        return new ClientRESTClient();
    }
    
}
