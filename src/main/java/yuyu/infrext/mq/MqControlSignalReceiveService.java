package yuyu.infrext.mq;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/yuyu.infrext.mq.MqControlSignalReceiveService")
public interface MqControlSignalReceiveService {

    @GET
    @Path("/execMqOnlineStartSignalReceive")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void execMqOnlineStartSignalReceive() throws NumberFormatException, InterruptedException;


    @GET
    @Path("/execMqOnlineEndSignalReceive")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void execMqOnlineEndSignalReceive() throws NumberFormatException, InterruptedException;

}