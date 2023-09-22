package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KijiKbn;

/**
 * 新契約 新契約共通 差異データ登録RegisterSaiDataKokutisyoインタフェース
 */
public interface SaiDataTourokuRegisterSaiDataKokutisyoUiBeanParam {

    String getMosno();

    BizDate getKktymd();

    Integer getSintyou();

    Integer getTaijyuu();

    C_KijiKbn getKijikbn();
}