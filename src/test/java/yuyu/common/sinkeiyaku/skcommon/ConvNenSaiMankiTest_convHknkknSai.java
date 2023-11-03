package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年歳満期変換処理のメソッド {@link ConvNenSaiManki#convHknkknSai(Integer, C_HknkknsmnKbn, Integer)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvNenSaiMankiTest_convHknkknSai {

    @Inject
    private ConvNenSaiManki convNenSaiManki;

    @Test
    @TestOrder(10)
    public void testconvHknkknSai_A1() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(null, C_HknkknsmnKbn.BLNK, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 0, "保険期間（歳）");
    }

    @Test
    @TestOrder(20)
    public void testconvHknkknSai_A2() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(1, null, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 0, "保険期間（歳）");
    }

    @Test
    @TestOrder(30)
    public void testconvHknkknSai_A3() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(1, C_HknkknsmnKbn.BLNK, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 0, "保険期間（歳）");
    }

    @Test
    @TestOrder(40)
    public void testconvHknkknSai_A4() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(99, C_HknkknsmnKbn.BLNK, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 99, "保険期間（歳）");
    }

    @Test
    @TestOrder(50)
    public void testconvHknkknSai_A5() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(-1, C_HknkknsmnKbn.SAIMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), -1, "保険期間（歳）");
    }

    @Test
    @TestOrder(60)
    public void testconvHknkknSai_A6() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(0, C_HknkknsmnKbn.SAIMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 0, "保険期間（歳）");
    }

    @Test
    @TestOrder(70)
    public void testconvHknkknSai_A7() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(-9, C_HknkknsmnKbn.NENMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 1, "保険期間（歳）");
    }
    @Test
    @TestOrder(80)
    public void testconvHknkknSai_A8() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(88, C_HknkknsmnKbn.NENMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 98, "保険期間（歳）");
    }

    @Test
    @TestOrder(90)
    public void testconvHknkknSai_A9() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(89, C_HknkknsmnKbn.NENMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 99, "保険期間（歳）");
    }

    @Test
    @TestOrder(100)
    public void testconvHknkknSai_A10() {

        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknSai(90, C_HknkknsmnKbn.NENMANKI, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exNumericEquals(convNenSaiManki.getHknkknSai(), 100, "保険期間（歳）");
    }
}
