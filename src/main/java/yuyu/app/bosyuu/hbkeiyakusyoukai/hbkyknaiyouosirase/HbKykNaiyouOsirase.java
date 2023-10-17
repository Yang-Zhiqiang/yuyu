package yuyu.app.bosyuu.hbkeiyakusyoukai.hbkyknaiyouosirase;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 生保Ｗｅｂご契約内容のお知らせサービスのインタフェースです。<br />
 */
@Path("/yuyu.app.bosyuu.hbkeiyakusyoukai.hbkyknaiyouosirase.HbKykNaiyouOsirase")
public interface HbKykNaiyouOsirase {

    @POST
    @Path("/exec")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public WsBzWebserviceResParamBean exec(MultivaluedMap<String, String> pMap) throws Exception;
}
