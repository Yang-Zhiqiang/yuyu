package yuyu.common.hozen.setuibean;

import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 UiBean設定 定期支払金支払先口座情報設定UiBean
 */
public class SetKhTkshrSiharaiKouzaExecUiBeanParamImpl implements SetKhTkshrSiharaiKouzaExecUiBeanParam {

    private String syono;

    private C_KouzasyuruiKbn vktikskzkzsyuruikbn;

    private String vktikskzbankcd;

    private String vktikskzbanknmkj;

    private String vktikskzsitencd;

    private String vktikskzsitennmkj;

    private C_YokinKbn vktikskzyokinkbn;

    private String vktikskzkouzano;

    private String vktikskzkzmeiginmkn;

    private C_UmuKbn teikishrtkykhukaumu;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_KouzasyuruiKbn getVktikskzkzsyuruikbn() {
        return vktikskzkzsyuruikbn;
    }

    @Override
    public void setVktikskzkzsyuruikbn(C_KouzasyuruiKbn pVktikskzkzsyuruikbn) {
        vktikskzkzsyuruikbn = pVktikskzkzsyuruikbn;
    }

    public String getVktikskzbankcd() {
        return vktikskzbankcd;
    }

    @Override
    public void setVktikskzbankcd(String pVktikskzbankcd) {
        vktikskzbankcd = pVktikskzbankcd;
    }

    public String getVktikskzbanknmkj() {
        return vktikskzbanknmkj;
    }

    @Override
    public void setVktikskzbanknmkj(String pVktikskzbanknmkj) {
        vktikskzbanknmkj = pVktikskzbanknmkj;
    }

    public String getVktikskzsitencd() {
        return vktikskzsitencd;
    }

    @Override
    public void setVktikskzsitencd(String pVktikskzsitencd) {
        vktikskzsitencd = pVktikskzsitencd;
    }

    public String getVktikskzsitennmkj() {
        return vktikskzsitennmkj;
    }

    @Override
    public void setVktikskzsitennmkj(String pVktikskzsitennmkj) {
        vktikskzsitennmkj = pVktikskzsitennmkj;
    }

    public C_YokinKbn getVktikskzyokinkbn() {
        return vktikskzyokinkbn;
    }

    @Override
    public void setVktikskzyokinkbn(C_YokinKbn pVktikskzyokinkbn) {
        vktikskzyokinkbn = pVktikskzyokinkbn;
    }

    public String getVktikskzkouzano() {
        return vktikskzkouzano;
    }

    @Override
    public void setVktikskzkouzano(String pVktikskzkouzano) {
        vktikskzkouzano = pVktikskzkouzano;
    }

    public String getVktikskzkzmeiginmkn() {
        return vktikskzkzmeiginmkn;
    }

    @Override
    public void setVktikskzkzmeiginmkn(String pVktikskzkzmeiginmkn) {
        vktikskzkzmeiginmkn = pVktikskzkzmeiginmkn;
    }

    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    @Override
    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }
}
