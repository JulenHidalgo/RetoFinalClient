/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import rest.EventRESTClient;

/**
 *
 * @author 2dam
 */
public class EventManagerFactory {
    
    private static EventManager eventManager;
    
    public static EventManager get(){
        if(eventManager == null){
            eventManager = new EventRESTClient();
        }
        return new EventRESTClient();
    }
}
