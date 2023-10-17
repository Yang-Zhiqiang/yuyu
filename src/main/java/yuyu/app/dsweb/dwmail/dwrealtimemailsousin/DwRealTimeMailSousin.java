package yuyu.app.dsweb.dwmail.dwrealtimemailsousin;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * ダイレクトサービス（Ｗｅｂ） メール ＤＳリアルタイムメール送信
 */
@Path("/yuyu.app.dsweb.dwmail.dwrealtimemailsousin.DwRealTimeMailSousin")
public interface DwRealTimeMailSousin {

    @POST
    @Path("/execPostFormPrepare")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public WsBzWebserviceResParamBean execPostFormPrepare(MultivaluedMap<String, String>  pMap);

    @POST
    @Path("/execPostFormUpdate")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap);
}
