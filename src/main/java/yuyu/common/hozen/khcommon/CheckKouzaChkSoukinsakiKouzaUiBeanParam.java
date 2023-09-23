package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 契約保全共通 口座情報入力チェックUiBeanパラメータ（送金先口座）クラス
 */
public interface CheckKouzaChkSoukinsakiKouzaUiBeanParam {

    String getSyono();

    C_Tuukasyu getShrtuukasyu();

    String getBankcd();

    String getSitencd();

    C_YokinKbn getYokinkbn();

    C_Kzdou getKzdoukbn();

    String getKyknmkn();

    String getKzmeiginmkn();

    String getKouzano();

    C_SoukinsakiKbn getSoukinsakikbn();

    void setSyono(String pSyono);

    void setShrtuukasyu(C_Tuukasyu pShrtuukasyu);

    void setBankcd(String pBankcd);

    void setSitencd(String pSitencd);

    void setYokinkbn(C_YokinKbn pYokinkbn);

    void setKzdoukbn(C_Kzdou pKzdoukbn);

    void setKyknmkn(String pKyknmkn);

    void setKzmeiginmkn(String pKzmeiginmkn);

    void setKouzano(String pKouzano);

    void setSoukinsakikbn(C_SoukinsakiKbn pSoukinsakikbn);
}
