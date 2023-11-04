package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 精算金額計算クラスのメソッド {@link CalcSeisankgk#exec(String, SiHkkingakuSisanParamBean)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CalcSeisankgkTest_exec {

    @Inject
    private CalcSeisankgk CalcSeisankgk;

    @Test
    @TestOrder(100)
    public void testExec_A01() {

        String syouhnCd = null;
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("9000009000009"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(), null, "死亡免責精算金額");
    }

    @Test
    @TestOrder(110)
    public void testExec_A02() {

        String syouhnCd = "ﾕｴ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean = null;

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(), null, "死亡免責精算金額");
    }

    @Test
    @TestOrder(200)
    public void testExec_B01() {

        String syouhnCd = "ﾕｲ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("1000001000002"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("1000001000001"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("1000001000002"), BizCurrencyTypes.DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(210)
    public void testExec_B02() {

        String syouhnCd = "ﾕｴ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("2000002000002"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("2000002000003"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("2000002000003"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(220)
    public void testExec_B03() {

        String syouhnCd = "ﾕｴ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("3000003000003"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(230)
    public void testExec_B04() {

        String syouhnCd = "ﾕｺ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("4000004000005"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("4000004000005"), BizCurrencyTypes.DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(240)
    public void testExec_B05() {

        String syouhnCd = "ﾕﾀ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("5000005000005"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("5000005000006"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("5000005000006"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(250)
    public void testExec_B06() {

        String syouhnCd = "ﾕﾀ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("6000006000006"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(260)
    public void testExec_B07() {

        String syouhnCd = "ﾕﾅ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("7000007000009"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("7000007000008"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("7000007000007"),
            BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("7000007000007"), BizCurrencyTypes.DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(270)
    public void testExec_B08() {

        String syouhnCd = "ﾕﾆ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("8000008000009"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("8000008000007"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("8000008000008"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("8000008000007"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(280)
    public void testExec_B09() {

        String syouhnCd = "ﾕﾆ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("9000009000009"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("9000009000008"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("9000009000008"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("9000009000008"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(290)
    public void testExec_B10() {

        String syouhnCd = "ﾕﾉ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("9000001000009"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("9000001000008"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(300)
    public void testExec_B11() {

        String syouhnCd = "ﾕﾊ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("8000002000007"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("8000002000008"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(310)
    public void testExec_B12() {

        String syouhnCd = "ﾕﾌ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("7000003000007"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("7000003000007"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("7000003000007"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(320)
    public void testExec_B13() {

        String syouhnCd = "ﾕﾍ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("4000004000005"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("4000004000005"), BizCurrencyTypes.DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(330)
    public void testExec_B14() {

        String syouhnCd = "ﾕﾕ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("5000005000005"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("5000005000006"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("5000005000006"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(340)
    public void testExec_B15() {

        String syouhnCd = "ﾕﾕ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("6000006000006"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(350)
    public void testExec_B16() {

        String syouhnCd = "ﾆｱ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("4000004000003"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("4000004000003"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(360)
    public void testExec_B17() {

        String syouhnCd = "ﾆｱ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("4000004000003"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("4000004000005"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("4000004000004"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

    @Test
    @TestOrder(370)
    public void testExec_B18() {

        String syouhnCd = "ﾆｱ";
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);

        siHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("4000004000005"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.AU_DOLLAR));
        siHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.AU_DOLLAR));

        C_ErrorKbn errorKbn = CalcSeisankgk.exec(syouhnCd, siHkkingakuSisanParamBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(CalcSeisankgk.getSbymdSeisankGk(),
            BizCurrency.valueOf(Long.valueOf("4000004000004"), BizCurrencyTypes.AU_DOLLAR), "死亡免責精算金額");
    }

}
