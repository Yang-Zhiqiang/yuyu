package yuyu.common.sinkeiyaku.skcommon;

import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 新契約 新契約共通 訂正履歴情報登録RgstrKouzajyouhouインタフェース
 */
public interface TsRrkInfoTourokuRgstrKouzajyouhouUiBeanParam {

    String getMosno();

    String getBankcd();

    String getSitencd();

    C_YokinKbn getYokinkbn();

    String getKouzano();

    C_KzkykdouKbn getKzkykdoukbn();

    String getKzmeiginmkn();

    String getHbcmnt();
}