package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 契約保全 契約保全共通 未経過保険料データ作成内部Bean
 */
public class MikeikaPDataSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency ssyMikeikap;

    private BizCurrency ssyZennouseisankin;

    public BizCurrency getSsyMikeikap() {
        return ssyMikeikap;
    }

    public void setSsyMikeikap(BizCurrency pSsyMikeikap) {
        ssyMikeikap = pSsyMikeikap;
    }

    public BizCurrency getSsyZennouseisankin() {
        return ssyZennouseisankin;
    }

    public void setSsyZennouseisankin(BizCurrency pSsyZennouseisankin) {
        ssyZennouseisankin = pSsyZennouseisankin;
    }
}
