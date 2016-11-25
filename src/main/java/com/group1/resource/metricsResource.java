package com.group1.resource;

import com.group1.database.metrics;
import com.group1.process.metricsProcess;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


@Path("/metrics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class metricsResource {

    private metricsProcess metricProcess;

    public metricsResource(metricsProcess metricProcess) {
        this.metricProcess = checkNotNull(metricProcess);
    }

    @GET
    public List<metrics> listmetrics() {
        return this.metricProcess.list();
    }

    @GET
    @Path("/{hostname}/{type}")
    public List<metrics> getmetrics(@PathParam("hostname") String hostname, @PathParam("type") String type) {
        return this.metricProcess.find(hostname,type);
    }

    @POST
    public metrics createmetrics(metrics metric) {
        return this.metricProcess.create(metric);
    }

    @DELETE
    @Path("/{hostname}/{type}")
    public void deletemetrics(@PathParam("hostname") String hostname, @PathParam("type") String type ) {
        this.metricProcess.delete(hostname, type);
    }

    @DELETE
    @Path("/{hostname}")
    public void deletemetrics(@PathParam("hostname") String hostname) {this.metricProcess.delete(hostname);}

}
