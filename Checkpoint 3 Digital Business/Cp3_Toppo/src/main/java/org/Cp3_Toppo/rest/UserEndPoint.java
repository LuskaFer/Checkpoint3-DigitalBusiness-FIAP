package org.Cp3_Toppo.rest;

import org.Cp3_Toppo.dao.UserDAO;
import org.Cp3_Toppo.model.User;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.*;

@Path ("/users")
public class UserEndPoint {
	
	private UserDAO dao = new UserDAO ();
	
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<User> index( ) {
	return dao.getAll();
}
	
@POST
@Consumes(MediaType.APPLICATION_JSON)
	public Response create (User user) {
	
	if (user ==null) {
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
		dao.create(user);
		return Response.status(Response.Status.CREATED).entity(user).build();
}

@GET
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") Long id) {
		User user;
		try {
			user = dao.findById(id);
			if (user ==null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(user).build();
	
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

@PUT
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response update(@PathParam("id") Long id, User user) {
	user.setId(id);
	dao.update(user);
	return Response.status(Response.Status.OK).entity(user).build();
	}

@DELETE
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
	public Response destroy(@PathParam("id") Long id, User user) {
	user.setId(id);
	dao.destroy(user);
	return Response.status(Response.Status.OK).entity(user).build();

	}
}



