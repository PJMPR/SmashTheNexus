package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import domain.model.Team;
import rest.dto.TeamDto;

@Path("/teams")
@Stateless
public class TeamsResources {
	
	Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager entityManager;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
    	List<TeamDto> result = new ArrayList<TeamDto>();
    	for(Team t: entityManager.createNamedQuery("team.all",Team.class).getResultList()){
        	result.add(mapper.map(t, TeamDto.class));
        }
        return Response.ok(new GenericEntity<List<TeamDto>>(result){}).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
    	Team result = entityManager.createNamedQuery("team.id", Team.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(Team team) {
        entityManager.persist(team);
        return Response.ok(team.getId()).build();
    }
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Team t){
		Team result = entityManager.createNamedQuery("team.id", Team.class).setParameter("id", id).getSingleResult();
		if(result==null){
			return Response.status(404).build();
		}
		result.setName(t.getName());
		entityManager.persist(result);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Team result = entityManager.createNamedQuery("team.id", Team.class).setParameter("id", id).getSingleResult();
		if(result==null){
			return Response.status(404).build();
		}
		entityManager.remove(result);
		return Response.ok().build();
	}
    
}
