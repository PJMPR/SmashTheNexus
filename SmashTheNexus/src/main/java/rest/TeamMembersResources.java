package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import domain.model.TeamMember;
import rest.dto.TeamMemberDto;

@Path("/teamMembers")
@Stateless
public class TeamMembersResources {
	
	Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager entityManager;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
    	List<TeamMemberDto> result = new ArrayList<TeamMemberDto>();
    	for(TeamMember t: entityManager.createNamedQuery("teamMember.all",TeamMember.class).getResultList()){
        	result.add(mapper.map(t, TeamMemberDto.class));
        }
        return Response.ok(new GenericEntity<List<TeamMemberDto>>(result){}).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
    	TeamMember result = entityManager.createNamedQuery("teamMember.id", TeamMember.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }
    
}
