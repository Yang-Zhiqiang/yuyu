package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程情報指定イメージプロパティ取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetKouteiSiteiImagePropsRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME = "GetKouteiSiteiImageProps";

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_FLOWID)
    private String sFlowid_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_FLOWIDS)
    private String[] sFlowids_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_GYOUMUKEY)
    private String sGyoumukey_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_GYOUMUKEYS)
    private String[] sGyoumukeys_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_LAST_SYORITIME_FROM)
    private String sLastsyoritimefrom_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_LAST_SYORITIME_TO)
    private String sLastsyoritimeto_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KOUTEI_KAISIBI_FROM)
    private String sKouteikaisibifrom_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KOUTEI_KAISIBI_TO)
    private String sKouteikaisibito_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KOUTEI_KANRYOUBI_FROM)
    private String sKouteikanryoubifrom_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KOUTEI_KANRYOUBI_TO)
    private String sKouteikanryoubito_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_SYORI_STATUS)
    private String[] sSyoristatus_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_NODENAME)
    private String sNodename_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_ACCOUNTWARIATEUMU)
    private String sAccountwariateumu_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KEKKA_JYOUGEN_KENSU)
    private String sKekkajyougenkensu_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_TORIKOMISYORUICD)
    private String sTorikomisyoruicd_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_SYORUITOUTYAKUYMDFROM)
    private String sSyoruitoutyakuymdfrom_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_SYORUITOUTYAKUYMDTO)
    private String sSyoruitoutyakuymdto_;

    @FormParam(IWSGetKouteiSiteiImagePropsIOKey.IN.sS_TANTOUSYA_ACCOUNTID)
    private String sTantousyaAccountid_;

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_FLOWID)
    public String getFlowid() {
        return sFlowid_;
    }

    public void setFlowid(String psFlowid) {
        sFlowid_ = psFlowid;
    }

    public String[] getFlowids() {
        return sFlowids_;
    }

    public void setFlowids(String[] sFlowids_) {
        this.sFlowids_ = sFlowids_;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_GYOUMUKEY)
    public String getGyoumukey() {
        return sGyoumukey_;
    }

    public void setGyoumukey(String psGyoumukey) {
        sGyoumukey_ = psGyoumukey;
    }

    public String[] getGyoumukeys() {
        return sGyoumukeys_;
    }

    public void setGyoumukeys(String[] psGyoumukeys) {
        this.sGyoumukeys_ = psGyoumukeys;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_LAST_SYORITIME_FROM)
    public String getLastsyoritimefrom() {
        return sLastsyoritimefrom_;
    }

    public void setLastsyoritimefrom(String psLastsyoritimefrom) {
        sLastsyoritimefrom_ = psLastsyoritimefrom;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_LAST_SYORITIME_TO)
    public String getLastsyoritimeto() {
        return sLastsyoritimeto_;
    }

    public void setLastsyoritimeto(String psLastsyoritimeto) {
        sLastsyoritimeto_ = psLastsyoritimeto;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KOUTEI_KAISIBI_FROM)
    public String getKouteikaisibifrom() {
        return sKouteikaisibifrom_;
    }

    public void setKouteikaisibifrom(String psKouteikaisibifrom) {
        sKouteikaisibifrom_ = psKouteikaisibifrom;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KOUTEI_KAISIBI_TO)
    public String getKouteikaisibito() {
        return sKouteikaisibito_;
    }

    public void setKouteikaisibito(String psKouteikaisibito) {
        sKouteikaisibito_ = psKouteikaisibito;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KOUTEI_KANRYOUBI_FROM)
    public String getKouteikanryoubifrom() {
        return sKouteikanryoubifrom_;
    }

    public void setKouteikanryoubifrom(String psKouteikanryoubifrom) {
        sKouteikanryoubifrom_ = psKouteikanryoubifrom;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KOUTEI_KANRYOUBI_TO)
    public String getKouteikanryoubito() {
        return sKouteikanryoubito_;
    }

    public void setKouteikanryoubito(String psKouteikanryoubito) {
        sKouteikanryoubito_ = psKouteikanryoubito;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_SYORI_STATUS)
    public String[] getSyoristatus() {
        return sSyoristatus_;
    }

    public void setSyoristatus(String[] psSyoristatus) {
        sSyoristatus_ = psSyoristatus;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_NODENAME)
    public String getNodename() {
        return sNodename_;
    }

    public void setNodename(String psNodename) {
        sNodename_ = psNodename;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_ACCOUNTWARIATEUMU)
    public String getAccountwariateumu() {
        return sAccountwariateumu_;
    }

    public void setAccountwariateumu(String psAccountwariateumu) {
        sAccountwariateumu_ = psAccountwariateumu;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_KEKKA_JYOUGEN_KENSU)
    public String getKekkajyougenkensu() {
        return sKekkajyougenkensu_;
    }

    public void setKekkajyougenkensu(String psKekkajyougenkensu) {
        sKekkajyougenkensu_ = psKekkajyougenkensu;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_TORIKOMISYORUICD)
    public String getTorikomisyoruicd() {
        return sTorikomisyoruicd_;
    }

    public void setTorikomisyoruicd(String psTorikomisyoruicd) {
        sTorikomisyoruicd_ = psTorikomisyoruicd;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_SYORUITOUTYAKUYMDFROM)
    public String getSyoruitoutyakuymdfrom() {
        return sSyoruitoutyakuymdfrom_;
    }

    public void setSyoruitoutyakuymdfrom(String psSyoruitoutyakuymdfrom) {
        sSyoruitoutyakuymdfrom_ = psSyoruitoutyakuymdfrom;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_SYORUITOUTYAKUYMDTO)
    public String getSyoruitoutyakuymdto() {
        return sSyoruitoutyakuymdto_;
    }

    public void setSyoruitoutyakuymdto(String psSyoruitoutyakuymdto) {
        sSyoruitoutyakuymdto_ = psSyoruitoutyakuymdto;
    }

    @JSONHint(name = IWSGetKouteiSiteiImagePropsIOKey.IN.sS_TANTOUSYA_ACCOUNTID)
    public String getTantousyaAccountid() {
        return sTantousyaAccountid_;
    }

    public void setTantousyaAccountid(String psTantousyaAccountid) {
        sTantousyaAccountid_ = psTantousyaAccountid;
    }
}
