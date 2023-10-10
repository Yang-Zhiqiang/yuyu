package yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.IwssnBzWebserviceResParamBean;

/**
 * 社内用契約内容照会Webサービスのインタフェースです。<br />
 */
//@Path("/yuyu.app.biz.bzkeiyakusyoukai.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakuNaiyouSyoukaiWebService")
//public interface BzKeiyakunaiyouSyoukaiWebService {
@Path("/yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakunaiyouSyoukaiWebService")
public interface BzKeiyakunaiyouSyoukaiWebService {

    @POST
    @Path("/exec")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)

    IwssnBzWebserviceResParamBean exec(MultivaluedMap<String, String> pMap);
    //WsBzWebserviceResParamHandmadeBean exec(MultivaluedMap<String, String> pMap);


}
