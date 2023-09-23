package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 契約保全共通 口座振替口座入力パラメータインターフェース <br />
 */
public interface CheckKzhuriKouzaExecUiBeanParam {

    String getBankcd();

    String getSitencd();

    C_YokinKbn getYokinkbn();

    C_KzkykdouKbn getKzkykdoukbn();

    String getVkykskyknmkn();

    String getKzmeiginmkn();

    String getKouzano();

    String getBanknmkj();

    String getSitennmkj();

    void setBankcd(String pBankcd);

    void setSitencd(String pSitencd);

    void setYokinkbn(C_YokinKbn pYokinkbn);

    void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn);

    void setVkykskyknmkn(String pVkykskyknmkn);

    void setKzmeiginmkn(String pKzmeiginmkn);

    void setKouzano(String pKouzano);

    void setBanknmkj(String pBanknmkj);

    void setSitennmkj(String pSitennmkj);
}
