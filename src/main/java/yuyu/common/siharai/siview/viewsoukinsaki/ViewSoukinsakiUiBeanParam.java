package yuyu.common.siharai.siview.viewsoukinsaki;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 保険金給付金支払 支払画面部品 送金先口座情報表示 <br />
 */
public interface ViewSoukinsakiUiBeanParam extends CommonViewUiBeanParam {

    public C_InputShrhousiteiKbn getInputshrhousiteikbn();

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn);

    public String getBankcd();

    public void setBankcd(String pBankcd);

    public String getBanknmkj();

    public void setBanknmkj(String pBanknmkj);

    public String getSitencd();

    public void setSitencd(String pSitencd);

    public String getSitennmkj();

    public void setSitennmkj(String pSitennmkj);

    public C_YokinKbn getYokinkbn();

    public void setYokinkbn(C_YokinKbn pYokinkbn);

    public String getKouzano();

    public void setKouzano(String pKouzano);

    public C_Kzdou getKzdoukbn();

    public void setKzdoukbn(C_Kzdou pKzdoukbn);

    public String getKzmeiginmkn();

    public void setKzmeiginmkn(String pKzmeiginmkn);

    public C_SiharaiTuukaKbn getSiharaituukakbn();

    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn);

    public boolean isViewSoukinsakiInputDispFlg();

    public boolean isInputshrhousiteiSeigyo();

    public boolean isInputshrhousiteiDispFlg();

    public boolean isViewSoukinsakiSeigyo();

    public boolean isViewSoukinsakiDispFlg();
}
