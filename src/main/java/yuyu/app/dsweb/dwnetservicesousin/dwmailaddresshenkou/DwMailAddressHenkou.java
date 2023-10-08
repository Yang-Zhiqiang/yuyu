package yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * ダイレクトサービス（Ｗｅｂ） ネットサービス入力情報送信 メール変更
 */
@Path("/yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou.DwMailAddressHenkou")
public interface DwMailAddressHenkou {

    @POST
    @Path("/execPostFormForPrepare")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public WsBzWebserviceResParamBean execPostFormForPrepare(MultivaluedMap<String, String>  pMap);

    @POST
    @Path("/execPostFormUpdate")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap);
}
