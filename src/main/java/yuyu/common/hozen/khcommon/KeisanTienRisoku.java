package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzcommon.KeisanTienrisoku;
import yuyu.common.biz.bzcommon.KeisanTienrisokuBean;
import yuyu.def.classification.C_SinsaGendoKknKbn;

/**
 * 契約保全 契約保全共通 支払遅延利息計算
 */
public class KeisanTienRisoku {

    private KeisanTienrisokuBean keisanTienrisokuBean = null;

    public BizCurrency exec(BizDate pUktkYmd, BizDate pTyakkinYmd, BizCurrency pShrGk) {

        KeisanTienrisoku keisanTienrisoku = SWAKInjector.getInstance(KeisanTienrisoku.class);

        keisanTienrisokuBean = keisanTienrisoku.exec(
            pUktkYmd,
            null,
            pTyakkinYmd,
            pShrGk,
            0,
            C_SinsaGendoKknKbn.BLNK);

        return keisanTienrisokuBean.getShrtienrsk();
    }

    public KeisanTienrisokuBean getKeisanTienrisokuBean() {
        return keisanTienrisokuBean;
    }
}