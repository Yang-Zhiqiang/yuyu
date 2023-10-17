package yuyu.app.dsweb.dwhozeninfo.dwgethozentrkkzkinfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 保全登録家族情報取得サービスのインタフェースです。<br />
 */
@Path("/yuyu.app.dsweb.dwhozeninfo.dwgethozentrkkzkinfo.DwGetHozenTrkkzkInfo")
public interface DwGetHozenTrkkzkInfo {

    @POST
    @Path("/execPostForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap);

}
