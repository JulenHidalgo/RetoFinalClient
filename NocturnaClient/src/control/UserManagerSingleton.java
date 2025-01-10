/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import interfaces.UserManager;

/**
 *
 * @author 2dam
 */
public class UserManagerSingleton {

    private static UserManager manager = null;

    private UserManagerSingleton() {

    }

    public synchronized static UserManager getRest() {
        if (manager == null) {
            //manager = new UserRest();
        }
        return manager;
    }

}
