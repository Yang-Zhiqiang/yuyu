package yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 生保Ｗｅｂ解約返戻金推移表作成サービスのインタフェースです。<br />
 */
@Path("/yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii")
public interface HbSeihoWebKaiyakuhrSuii {

    @POST
    @Path("/execPostForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception;
}
