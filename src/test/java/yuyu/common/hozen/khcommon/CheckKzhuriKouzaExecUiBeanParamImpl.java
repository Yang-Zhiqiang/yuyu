package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 契約保全共通 保険料引去り口座用チェック時の入力パラメータクラス <br />
 */
public class CheckKzhuriKouzaExecUiBeanParamImpl implements CheckKzhuriKouzaExecUiBeanParam {

    private String bankcd;

    private String sitencd;

    private C_YokinKbn yokinkbn;

    private C_KzkykdouKbn kzkykdoukbn;

    private String vkykskyknmkn;

    private String kzmeiginmkn;

    private String kouzano;

    private String banknmkj;

    private String sitennmkj;

    @Override
    public String getBankcd() {
        return bankcd;
    }

    @Override
    public void setBankcd(String pBankcd) {
        this.bankcd = pBankcd;
    }

    @Override
    public String getSitencd() {
        return sitencd;
    }

    @Override
    public void setSitencd(String pSitencd) {
        this.sitencd = pSitencd;
    }

    @Override
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    @Override
    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    @Override
    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    @Override
    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
    }

    @Override
    public String getVkykskyknmkn() {
        return vkykskyknmkn;
    }

    @Override
    public void setVkykskyknmkn(String pVkykskyknmkn) {
        this.vkykskyknmkn = pVkykskyknmkn;
    }

    @Override
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Override
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        this.kzmeiginmkn = pKzmeiginmkn;
    }

    @Override
    public String getKouzano() {
        return kouzano;
    }

    @Override
    public void setKouzano(String pKouzano) {
        this.kouzano = pKouzano;
    }

    @Override
    public String getBanknmkj() {
        return banknmkj;
    }

    @Override
    public void setBanknmkj(String pBanknmkj) {
        this.banknmkj = pBanknmkj;
    }

    @Override
    public String getSitennmkj() {
        return sitennmkj;
    }

    @Override
    public void setSitennmkj(String pSitennmkj) {
        this.sitennmkj = pSitennmkj;
    }

}
