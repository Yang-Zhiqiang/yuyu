package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KijiKbn;

/**
 * 新契約 新契約共通 訂正履歴情報登録RgstrKokutisyoインタフェース
 */
public interface TsRrkInfoTourokuRgstrKokutisyoUiBeanParam {

    String getMosno();

    BizDate getKktymd();

    Integer getSintyou();

    Integer getTaijyuu();

    C_KijiKbn getKijikbn();

    String getHbcmnt();
}