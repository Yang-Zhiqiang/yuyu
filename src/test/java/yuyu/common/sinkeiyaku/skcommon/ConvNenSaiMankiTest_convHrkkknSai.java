package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年歳満期変換処理のメソッド {@link ConvNenSaiManki#convHrkkknSai(Integer, C_HrkkknsmnKbn, Integer)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvNenSaiMankiTest_convHrkkknSai {

    @Inject
    private ConvNenSaiManki convNenSaiManki;

    @Test
    @TestOrder(10)
    public void testConvHrkkknSai_A1() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(null, C_HrkkknsmnKbn.BLNK, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 0, "払込期間（歳）");
    }

    @Test
    @TestOrder(20)
    public void testConvHrkkknSai_A2() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(1, null, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 0, "払込期間（歳）");
    }

    @Test
    @TestOrder(30)
    public void testConvHrkkknSai_A3() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(1, C_HrkkknsmnKbn.BLNK, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 0, "払込期間（歳）");
    }

    @Test
    @TestOrder(40)
    public void testConvHrkkknSai_A4() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(0, C_HrkkknsmnKbn.BLNK, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 0, "払込期間（歳）");
    }

    @Test
    @TestOrder(50)
    public void testConvHrkkknSai_A5() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(-11, C_HrkkknsmnKbn.NENMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), -1, "払込期間（歳）");
    }

    @Test
    @TestOrder(60)
    public void testConvHrkkknSai_A6() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(-10, C_HrkkknsmnKbn.NENMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 0, "払込期間（歳）");
    }

    @Test
    @TestOrder(70)
    public void testConvHrkkknSai_A7() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(-9, C_HrkkknsmnKbn.NENMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 1, "払込期間（歳）");
    }
    @Test
    @TestOrder(80)
    public void testConvHrkkknSai_A8() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(88, C_HrkkknsmnKbn.NENMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 98, "払込期間（歳）");
    }

    @Test
    @TestOrder(90)
    public void testConvHrkkknSai_A9() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(99, C_HrkkknsmnKbn.SAIMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 99, "払込期間（歳）");
    }

    @Test
    @TestOrder(100)
    public void testConvHrkkknSai_A10() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknSai(100, C_HrkkknsmnKbn.SAIMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHrkkknSai(), 100, "払込期間（歳）");
    }
}
