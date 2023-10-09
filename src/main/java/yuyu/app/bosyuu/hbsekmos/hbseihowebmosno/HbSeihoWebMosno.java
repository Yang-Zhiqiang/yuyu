package yuyu.app.bosyuu.hbsekmos.hbseihowebmosno;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 生保Ｗｅｂ申込番号取得サービスのインタフェースです。<br />
 */
@Path("/yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno")
public interface HbSeihoWebMosno {

    @POST
    @Path("/execPostForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception;
}
