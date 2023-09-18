package yuyu.common.workflowcore.iwfcommon.extension.decisionhandler.entry;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * {サービス名を書く}のWebサービスのエントリーポイントです。
 * http://{servername}:{portno}/{context}/ws/{path1}/{path2}
 */
@Path("/Rule")
public class WSRule {

    public WSRule() throws Exception {
        super();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response exec() throws Exception {

        try {
            try {

                String json = "";

                return Response.ok(json).build();

            } finally {
            }
        } catch (Throwable e) {
        }
        return null;
    }

}
