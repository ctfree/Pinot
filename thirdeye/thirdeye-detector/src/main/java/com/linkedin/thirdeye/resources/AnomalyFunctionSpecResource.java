package com.linkedin.thirdeye.resources;

import com.codahale.metrics.annotation.Timed;
import com.linkedin.thirdeye.api.AnomalyFunctionSpec;
import com.linkedin.thirdeye.db.AnomalyFunctionSpecDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/anomaly-functions")
@Produces(MediaType.APPLICATION_JSON)
public class AnomalyFunctionSpecResource {
  private final AnomalyFunctionSpecDAO dao;

  public AnomalyFunctionSpecResource(AnomalyFunctionSpecDAO dao) {
    this.dao = dao;
  }

  @POST
  @Timed
  @UnitOfWork
  public Response create(AnomalyFunctionSpec anomalyFunctionSpec) {
    Long id = dao.create(anomalyFunctionSpec);
    return Response.ok(id).build();
  }

  @DELETE
  @Timed
  @UnitOfWork
  @Path("/{id}")
  public Response delete(@PathParam("id") Long id) {
    dao.delete(id);
    return Response.noContent().build();
  }

  @GET
  @Timed
  @UnitOfWork
  @Path("/{id}")
  public AnomalyFunctionSpec find(@PathParam("id") Long id) {
    AnomalyFunctionSpec anomalyFunctionSpec = dao.findById(id);
    if (anomalyFunctionSpec == null) {
      throw new NotFoundException();
    }
    return anomalyFunctionSpec;
  }

  @GET
  @Timed
  @UnitOfWork
  public List<AnomalyFunctionSpec> findAll(@QueryParam("collection") String collection) {
    if (collection == null) {
      return dao.findAll();
    } else {
      return dao.findAllByCollection(collection);
    }
  }
}
