package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 新契約 新契約共通 差異データ登録RegisterSaiDataCreditCardインタフェース
 */
public interface SaiDataTourokuRegisterSaiDataCreditCardUiBeanParam {

    String getMosno();

    String getCardkaisyacd();

    String getCreditcardno1();

    String getCreditcardno2();

    String getCreditcardno3();

    String getCreditcardno4();

    String getYkkigenmm();

    String getYkkigenyy();

    BizDate getAuthorikanryoymd();

    BizCurrency getAuthorigk();

    String getSyouninno();
}