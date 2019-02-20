package dev.pigwalking.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import dev.pigwalking.dao.PersonDAO;
import dev.pigwalking.model.Person;

@Path("/person")
public class PersonResource {

  public PersonResource() {
  }

  @GET
  @Timed
  @Path("/get/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Person getPerson(@PathParam("id") int id) {
      return PersonDAO.getById(id);
  }

  @GET
  @Timed
  @Path("/remove")
  @Produces(MediaType.TEXT_PLAIN)
  public String removePerson() {
    PersonDAO.remove();
      return "Last person remove. Total count: " + PersonDAO.getCount();
  }

  @GET
  @Timed
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Person> getPersons() {
      return PersonDAO.getAll();
  }

  @POST
  @Timed
  @Path("/save")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes({MediaType.APPLICATION_JSON})
  public String addPerson(Person person) {
      return PersonDAO.save(person);
  }
}
