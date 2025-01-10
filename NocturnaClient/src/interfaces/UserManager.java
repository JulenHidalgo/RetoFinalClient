/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.User;

/**
 *
 * @author 2dam
 */
public interface UserManager {
    
    public User signUp();
    
    public User signIn();
    
    public boolean resetPass();
    
    public boolean updatePass();
    
    public boolean updateUser();
    
    public boolean deleteUser();
    
}
