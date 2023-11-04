package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 UiBean設定 契約者情報設定UiBeanパラメータ
 */
public class SetKeiyakusyaExecUiBeanParamImpl implements SetKeiyakusyaExecUiBeanParam {

    private String syono = null;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    private String vkykskyknmkn;

    public String getVkykskyknmkn() {
        return vkykskyknmkn;
    }

    @Override
    public void setVkykskyknmkn(String pVkykskyknmkn){
        this.vkykskyknmkn = pVkykskyknmkn;
    }

    private String vkykskyknmkj;

    public String getVkykskyknmkj() {
        return vkykskyknmkj;
    }

    @Override
    public void setVkykskyknmkj(String pVkykskyknmkj){
        this.vkykskyknmkj = pVkykskyknmkj;
    }

    private C_KjkhukaKbn vkykskyknmkjkhukakbn;

    public C_KjkhukaKbn getVkykskyknmkjkhukakbn() {
        return vkykskyknmkjkhukakbn;
    }

    @Override
    public void setVkykskyknmkjkhukakbn(C_KjkhukaKbn pVkykskyknmkjkhukakbn){
        this.vkykskyknmkjkhukakbn = pVkykskyknmkjkhukakbn;
    }

    private BizDate vkykskykseiymd;

    public BizDate getVkykskykseiymd() {
        return vkykskykseiymd;
    }

    @Override
    public void setVkykskykseiymd(BizDate pVkykskykseiymd){
        this.vkykskykseiymd = pVkykskykseiymd;
    }

    private C_Kyksei vkykskyksei;

    public C_Kyksei getVkykskyksei() {
        return vkykskyksei;
    }

    @Override
    public void setVkykskyksei(C_Kyksei pVkykskyksei){
        this.vkykskyksei = pVkykskyksei;
    }

    private C_Tdk vkykskkkyktdk;

    public C_Tdk getVkykskkkyktdk() {
        return vkykskkkyktdk;
    }

    @Override
    public void setVkykskkkyktdk(C_Tdk pVkykskkkyktdk){
        this.vkykskkkyktdk = pVkykskkkyktdk;
    }

    private C_HjndaiykKbn vkykshjndaiykkbn;

    public C_HjndaiykKbn getVkykshjndaiykkbn() {
        return vkykshjndaiykkbn;
    }

    @Override
    public void setVkykshjndaiykkbn(C_HjndaiykKbn pVkykshjndaiykkbn){
        this.vkykshjndaiykkbn = pVkykshjndaiykkbn;
    }

    private String vkykshjndaiyknm;

    public String getVkykshjndaiyknm() {
        return vkykshjndaiyknm;
    }

    @Override
    public void setVkykshjndaiyknm(String pVkykshjndaiyknm){
        this.vkykshjndaiyknm = pVkykshjndaiyknm;
    }

    private String vkykshjndainmkn;

    public String getVkykshjndainmkn() {
        return vkykshjndainmkn;
    }

    @Override
    public void setVkykshjndainmkn(String pVkykshjndainmkn){
        this.vkykshjndainmkn = pVkykshjndainmkn;
    }

    private String vkykshjndainmkj;

    public String getVkykshjndainmkj() {
        return vkykshjndainmkj;
    }

    @Override
    public void setVkykshjndainmkj(String pVkykshjndainmkj){
        this.vkykshjndainmkj = pVkykshjndainmkj;
    }
}
