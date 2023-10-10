package yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * ＤＳ目標額変更受付を行うサービスのインタフェースです。<br />
 */
@Path("/yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketuke")
public interface DwMkhgkHenkouUketuke {

    @POST
    @Path("/execPostFormInit")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostFormInit(MultivaluedMap<String, String> pMap);

    @POST
    @Path("/execPostFormCheckUktk")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostFormCheckUktk(MultivaluedMap<String, String> pMap);

    @POST
    @Path("/execPostFormCheckInput")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostFormCheckInput(MultivaluedMap<String, String> pMap);

    @POST
    @Path("/execPostFormUpdate")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap);
}
