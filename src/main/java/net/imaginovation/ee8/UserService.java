/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.imaginovation.ee8;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rakhunathan
 */
@Path("User")
public class UserService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
        return new User(12, "Rakhu", new Date());
    }
}
