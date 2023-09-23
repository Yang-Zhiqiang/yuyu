package yuyu.common.siharai.siview.viewsoukinsaki;

import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 保険金給付金支払 支払画面部品 送金先口座情報表示 <br />
 */
public class ViewSoukinsakiUiBeanParamImpl implements ViewSoukinsakiUiBeanParam{

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    private String bankcd;

    private String banknmkj;

    private String sitencd;

    private String sitennmkj;

    private C_YokinKbn yokinkbn;

    private String kouzano;

    private C_Kzdou kzdoukbn;

    private String kzmeiginmkn;

    private C_SiharaiTuukaKbn siharaituukakbn;

    private boolean viewSoukinsakiInputDispFlg;

    private boolean inputshrhousiteiSeigyo;

    private boolean inputshrhousiteiDispFlg;

    private boolean viewSoukinsakiSeigyo;

    private boolean viewSoukinsakiDispFlg;

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
    public String getBanknmkj() {
        return banknmkj;
    }

    @Override
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
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
    public String getSitennmkj() {
        return sitennmkj;
    }

    @Override
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
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
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    @Override
    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
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
    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return siharaituukakbn;
    }

    @Override
    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn) {
        siharaituukakbn = pSiharaituukakbn;
    }

    @Override
    public boolean isViewSoukinsakiInputDispFlg() {
        return viewSoukinsakiInputDispFlg;
    }

    @Override
    public boolean isInputshrhousiteiSeigyo() {
        return inputshrhousiteiSeigyo;
    }

    @Override
    public boolean isInputshrhousiteiDispFlg() {
        return inputshrhousiteiDispFlg;
    }

    @Override
    public boolean isViewSoukinsakiSeigyo() {
        return viewSoukinsakiSeigyo;
    }

    @Override
    public boolean isViewSoukinsakiDispFlg() {
        return viewSoukinsakiDispFlg;
    }
}
