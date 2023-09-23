package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 契約保全 契約保全共通 解約返戻金データ作成内部Beanクラス
 */
public class KaiyakuHenreikinDataSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency ssyPTumitatekin;

    private BizCurrency ssyKaiyakuhr;

    public BizCurrency getSsyPTumitatekin() {
        return ssyPTumitatekin;
    }

    public void setSsyPTumitatekin(BizCurrency pSsyPTumitatekin) {
        ssyPTumitatekin = pSsyPTumitatekin;
    }

    public BizCurrency getSsyKaiyakuhr() {
        return ssyKaiyakuhr;
    }

    public void setSsyKaiyakuhr(BizCurrency pSsyKaiyakuhr) {
        ssyKaiyakuhr = pSsyKaiyakuhr;
    }
}
