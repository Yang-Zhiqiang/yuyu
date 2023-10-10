package yuyu.app.dsweb.dwninsyou.dwpasswordhenkou;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;


/**
 * パスワード変更サービスのインタフェースです。<br />
 */
@Path("/yuyu.app.dsweb.dwninsyou.dwpasswordhenkou.DwPasswordHenkou")
public interface DwPasswordHenkou {

    @POST
    @Path("/execPostForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap);

}
