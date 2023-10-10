package yuyu.app.bosyuu.hbkeiyakusyoukai.hbkeiyakusyoukaiwebservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 生保Ｗｅｂ契約内容照会サービスのインタフェースです。<br />
 */
@Path("/yuyu.app.bosyuu.hbkeiyakusyoukai.hbkeiyakusyoukaiwebservice.HbKeiyakuSyoukaiWebService")
public interface HbKeiyakuSyoukaiWebService {

    @POST
    @Path("/exec")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean exec(MultivaluedMap<String, String> pMap) throws Exception;
}
