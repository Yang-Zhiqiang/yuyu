package yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * ＤＳ解約受付を行うサービスのインタフェースです。<br />
 */
@Path("/yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketuke")
public interface DwKaiyakuUketuke {

    @POST
    @Path("/execPostFormPrepare")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostFormPrepare(MultivaluedMap<String, String> pMap);

    @POST
    @Path("/execPostFormUpdate")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap);

    @POST
    @Path("/execPostFormKadouhantei")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostFormKadouhantei(MultivaluedMap<String, String> pMap);

}
