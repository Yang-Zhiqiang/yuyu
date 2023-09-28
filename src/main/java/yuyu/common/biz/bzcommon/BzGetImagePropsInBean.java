package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 業務共通 共通 業務共通イメージプロパティ取得入力Bean
 */
public class BzGetImagePropsInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jimuTetuzukiCd = null;

    private String kouteiKanriId = null;

    private C_SyoruiCdKbn syoruiCd = null;

    private String syoruiTtykYmdTimeFrom = null;

    private String syoruiTtykYmdTimeTo = null;

    private C_Kouteikanristatus kouteiKanriStatus = null;

    public String getJimuTetuzukiCd(){
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimutetuzukiCd){
        jimuTetuzukiCd = pJimutetuzukiCd;
    }

    public String getKouteiKanriId(){
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId){
        kouteiKanriId = pKouteiKanriId;
    }

    public C_SyoruiCdKbn getSyoruiCd(){
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd){
        syoruiCd = pSyoruiCd;
    }

    public String getSyoruiTtykYmdTimeFrom(){
        return syoruiTtykYmdTimeFrom;
    }

    public void setSyoruiTtykYmdTimeFrom(String pSyoruiTtykYmdTimeFrom){
        syoruiTtykYmdTimeFrom = pSyoruiTtykYmdTimeFrom;
    }

    public String getSyoruiTtykYmdTimeTo(){
        return syoruiTtykYmdTimeTo;
    }

    public void setSyoruiTtykYmdTimeTo(String pSyoruiTtykYmdTimeTo){
        syoruiTtykYmdTimeTo = pSyoruiTtykYmdTimeTo;
    }

    public C_Kouteikanristatus getKouteiKanriStatus(){
        return kouteiKanriStatus;
    }

    public void setKouteiKanriStatus(C_Kouteikanristatus pKouteikanristatus){
        kouteiKanriStatus = pKouteikanristatus;
    }
}
