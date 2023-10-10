package yuyu.app.dsweb.dwcommon.dwhukamojicheck;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 不可文字チェックサービスのインタフェースです。<br />
 */
@Path("/yuyu.app.dsweb.dwcommon.dwhukamojicheck.DwHukamojiCheck")
public interface DwHukamojiCheck {

    @POST
    @Path("/execPostForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap);
}
