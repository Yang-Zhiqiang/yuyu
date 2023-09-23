package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_YokinKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 送金先情報Paramインターフェース
 */
public interface SiSoukinsakiParam {

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

    public C_Kzdou getKzdoukbn();

    public void setKzdoukbn(C_Kzdou pKzdoukbn);

    public String getKzmeiginmkn();

    public void setKzmeiginmkn(String pKzmeiginmkn);

}
