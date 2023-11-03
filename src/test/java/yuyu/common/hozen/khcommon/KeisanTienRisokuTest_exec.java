package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.KeisanTienrisokuBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払遅延利息計算クラスのメソッド {@link KeisanTienRisoku#exec(BizDate, BizDate, BizCurrency)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanTienRisokuTest_exec {

    @Inject
    KeisanTienRisoku keisanTienRisoku;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizCurrency shrtienrsk = keisanTienRisoku.exec(BizDate.valueOf(20160321), BizDate.valueOf(20160401),
            BizCurrency.valueOf(153000, BizCurrencyTypes.YEN));

        exBizCalcbleEquals(shrtienrsk, BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "支払遅延利息");

        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienRisoku.getKeisanTienrisokuBean();

        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf(20160329), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf(20160401), "遅延利息終了日");
        exNumericEquals( keisanTienrisokuBean.getShrtienNissuu(), 4, "遅延日数");

    }
    @Test
    @TestOrder(20)
    public void testExec_A2() {
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienRisoku.getKeisanTienrisokuBean();
        assertNull(keisanTienrisokuBean);
    }
}
