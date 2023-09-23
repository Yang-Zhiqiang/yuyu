package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 契約保全共通 口座情報入力チェックUiBeanパラメータ
 */
public interface CheckKouzaChkKouhuriKouzaUiBeanParam {

    String getBankcd();

    String getSitencd();

    C_YokinKbn getYokinkbn();

    C_Kyksei getKyksei();

    String getKyknmkn();

    String getSyono();

    String getKzmeiginmkn();

    String getKouzano10keta();

    C_Kzdou getKzdoukbn();

    void setBanknmkj(String pBanknmkj);

    void setSitennmkj(String pSitennmkj);

    void setKzmeiginmkn(String pKzmeiginmkn);

    void setKouzano10keta(String pKouzano10keta);

}
