package yuyu.common.hozen.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 工程 契約保全必要書類判定入力Bean
 */
public class KhHituyousyoruiHanteiInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kouteikanriId;

    private String jimutetuzukiCd;

    private C_UmuKbn hrkkeirohnkUmuKbn;

    private C_UmuKbn hrkkaisuuhnkUmuKbn;

    private C_UmuKbn daisennintdkUmuKbn;

    private C_UmuKbn trhkjikakUmuKbn;

    private C_Hubidataumu hubidataUmu;

    private C_Hrkkeiro henkougoHrkkeiro;

    public KhHituyousyoruiHanteiInBean() {
        super();
    }

    public String getKouteikanriId(){
        return kouteikanriId;
    }

    public void setKouteikanriId(String pKouteikanriId){
        kouteikanriId = pKouteikanriId;
    }

    public String getJimutetuzukiCd(){
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd){
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    public C_UmuKbn getHrkkeirohnkUmuKbn(){
        return hrkkeirohnkUmuKbn;
    }

    public void setHrkkeirohnkUmuKbn(C_UmuKbn pJimutetuzukiCd){
        hrkkeirohnkUmuKbn = pJimutetuzukiCd;
    }

    public C_UmuKbn getHrkkaisuuhnkUmuKbn(){
        return hrkkaisuuhnkUmuKbn;
    }

    public void setHrkkaisuuhnkUmuKbn(C_UmuKbn pHrkkaisuuhnkUmuKbn){
        hrkkaisuuhnkUmuKbn = pHrkkaisuuhnkUmuKbn;
    }

    public C_UmuKbn getDaisennintdkUmuKbn(){
        return daisennintdkUmuKbn;
    }

    public void setDaisennintdkUmuKbn(C_UmuKbn pDaisennintdkUmuKbn){
        daisennintdkUmuKbn = pDaisennintdkUmuKbn;
    }

    public C_UmuKbn getTrhkjikakUmuKbn(){
        return trhkjikakUmuKbn;
    }

    public void setTrhkjikakUmuKbn(C_UmuKbn pTrhkjikakUmuKbn){
        trhkjikakUmuKbn = pTrhkjikakUmuKbn;
    }

    public C_Hubidataumu getHubidataUmu(){
        return hubidataUmu;
    }

    public void setHubidataUmu(C_Hubidataumu pHubidataUmu){
        hubidataUmu = pHubidataUmu;
    }

    public C_Hrkkeiro getHenkougoHrkkeiro() {
        return henkougoHrkkeiro;
    }

    public void setHenkougoHrkkeiro(C_Hrkkeiro pHenkougoHrkkeiro) {
        this.henkougoHrkkeiro = pHenkougoHrkkeiro;
    }
}
