package yuyu.app.dsweb.dwninsyou.dwtktitrhkyuansyoubangouninsyou;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * ＤＳ特定取引用暗証番号認証サービスのインタフェースです。<br />
 */
@Path("/yuyu.app.dsweb.dwninsyou.dwtktitrhkyuansyoubangouninsyou.DwTktiTrhkyuAnsyoubangouNinsyou")
public interface DwTktiTrhkyuAnsyoubangouNinsyou {

    @POST
    @Path("/execPostForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap);

}
