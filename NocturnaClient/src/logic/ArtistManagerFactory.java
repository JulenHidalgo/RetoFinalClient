/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import rest.ArtistRESTClient;

/**
 *
 * @author 2dam
 */
public class ArtistManagerFactory {

    private static ArtistManager artistManager;

    public static ArtistManager get() {
        if (artistManager == null) {
            artistManager = new ArtistRESTClient();
        }
        return new ArtistRESTClient();
    }
}
