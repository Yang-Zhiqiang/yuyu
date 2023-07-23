package yuyu.infrext.mq;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/yuyu.infrext.mq.MqConnectionControlService")
public interface MqConnectionControlService {

    @GET
    @Path("/execMqConn")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void execMqConn() throws NumberFormatException, InterruptedException;


    @GET
    @Path("/execMqDisConn")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void execMqDisConn() throws NumberFormatException, InterruptedException;

}