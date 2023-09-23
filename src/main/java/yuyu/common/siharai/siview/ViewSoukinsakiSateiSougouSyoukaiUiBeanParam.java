package yuyu.common.siharai.siview;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 送金先情報設定(査定総合照会)パラメータインタフェース
 */
public interface ViewSoukinsakiSateiSougouSyoukaiUiBeanParam extends CommonViewUiBeanParam {

    public C_InputShrhousiteiKbn getInputshrhousiteikbn();

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn);

    public String getBankcd();

    public void setBankcd(String pBankcd);

    public String getSitencd();

    public void setSitencd(String pSitencd);

    public C_YokinKbn getYokinkbn();

    public void setYokinkbn(C_YokinKbn pYokinkbn);

    public String getKouzano();

    public void setKouzano(String pKouzano);

    public String getKzmeiginmkn();

    public void setKzmeiginmkn(String pKzmeiginmkn);

    public String getBanknmkj();

    public void setBanknmkj(String pBanknmkj);

    public String getSitennmkj();

    public void setSitennmkj(String pSitennmkj);

}
