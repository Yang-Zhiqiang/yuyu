package yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 生保Ｗｅｂ申込状況照会サービスのインタフェースです。<br />
 */
@Path("/yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukai")
public interface HbSeihoWebMosSyoukai {

    @POST
    @Path("/execPostForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception;
}
