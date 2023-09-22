package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 新契約 新契約共通 訂正履歴情報登録RgstrCreditcardjyouhouインタフェース
 */
public interface TsRrkInfoTourokuRgstrCreditcardjyouhouUiBeanParam {

    String getMosno();

    String getCreditkaisyanm();

    String getCardkaisyacd();

    String getCreditcardno1();

    String getCreditcardno2();

    String getCreditcardno3();

    String getCreditcardno4();

    String getYkkigenmm();

    String getYkkigenyy();

    String getCreditmeiginmkn();

    String getHbcmnt();

    BizDate getAuthorikanryoymd();

    BizCurrency getAuthorigk();

    String getSyouninno();
}