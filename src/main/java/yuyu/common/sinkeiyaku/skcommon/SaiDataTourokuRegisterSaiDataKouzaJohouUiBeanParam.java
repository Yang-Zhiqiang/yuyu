package yuyu.common.sinkeiyaku.skcommon;

import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 新契約 新契約共通 差異データ登録RegisterSaiDataKouzaJohouインタフェース
 */
public interface SaiDataTourokuRegisterSaiDataKouzaJohouUiBeanParam {

    String getMosno();

    String getBankcd();

    String getSitencd();

    C_YokinKbn getYokinkbn();

    String getKouzano();

    C_KzkykdouKbn getKzkykdoukbn();

    String getKzmeiginmkn();
}