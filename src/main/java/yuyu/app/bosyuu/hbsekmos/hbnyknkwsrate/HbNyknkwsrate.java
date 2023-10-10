package yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 入金用為替レート照会サービスのインタフェースです。<br />
 */
@Path("/yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrate")
public interface HbNyknkwsrate {

    @POST
    @Path("/execPostForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception;

}
