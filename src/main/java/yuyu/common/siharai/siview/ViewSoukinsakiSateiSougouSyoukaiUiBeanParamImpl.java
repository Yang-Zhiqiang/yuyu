package yuyu.common.siharai.siview;

import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 送金先情報設定(査定総合照会)パラメータインタフェース実装クラス
 */
public class ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl implements ViewSoukinsakiSateiSougouSyoukaiUiBeanParam {

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    private String bankcd;

    private String sitencd;

    private C_YokinKbn yokinkbn;

    private String kouzano;

    private String kzmeiginmkn;

    private String banknmkj;

    private String sitennmkj;

    @Override
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    @Override
    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    @Override
    public String getBankcd() {
        return bankcd;
    }

    @Override
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    @Override
    public String getSitencd() {
        return sitencd;
    }

    @Override
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
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
    public String getKouzano() {
        return kouzano;
    }

    @Override
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    @Override
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Override
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    @Override
    public String getBanknmkj() {
        return banknmkj;
    }

    @Override
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
    }

    @Override
    public String getSitennmkj() {
        return sitennmkj;
    }

    @Override
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
    }

}
