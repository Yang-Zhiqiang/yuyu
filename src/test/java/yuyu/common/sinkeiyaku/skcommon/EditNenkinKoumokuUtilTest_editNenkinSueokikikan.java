package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金商品項目編集ユーティリティのメソッド
 * {@link EditNenkinKoumokuUtil#editNenkinSueokikikan(Integer, C_HknkknsmnKbn, Integer, C_HrkkknsmnKbn, Integer)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class EditNenkinKoumokuUtilTest_editNenkinSueokikikan {

    @Inject
    private EditNenkinKoumokuUtil editNenkinKoumokuUtil;

    @Test
    @TestOrder(10)
    public void testEditNenkinSueokikikan_A1() {
        Integer hknkkn = null;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = 1;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = 1;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testEditNenkinSueokikikan_A2() {
        Integer hknkkn = 1;
        C_HknkknsmnKbn hknkknsmnKbn = null;
        Integer hrkkkn = 1;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = 1;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testEditNenkinSueokikikan_A3() {
        Integer hknkkn = 1;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = null;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = 1;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test()
    @TestOrder(40)
    public void testEditNenkinSueokikikan_A4() {
        Integer hknkkn = 1;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = 1;
        C_HrkkknsmnKbn hrkkknsmnKbn = null;
        Integer hhknnen = 1;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test()
    @TestOrder(50)
    public void testEditNenkinSueokikikan_A5() {
        Integer hknkkn = 1;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = 1;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = null;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test()
    @TestOrder(60)
    public void testEditNenkinSueokikikan_A6() {

        Integer hknkkn = 11;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = 12;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = 2;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test()
    @TestOrder(70)
    public void testEditNenkinSueokikikan_A7() {
        Integer hknkkn = 12;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = 12;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = 2;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(editNenkinKoumokuUtil.getNenkinSueokikikan(), 0, "年金据置期間");
    }

    @Test()
    @TestOrder(80)
    public void testEditNenkinSueokikikan_A8() {
        Integer hknkkn = 13;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = 12;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = 2;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(editNenkinKoumokuUtil.getNenkinSueokikikan(), 1, "年金据置期間");
    }

    @Test()
    @TestOrder(90)
    public void testEditNenkinSueokikikan_A9() {
        Integer hknkkn = 13;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = 0;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = 2;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(editNenkinKoumokuUtil.getNenkinSueokikikan(), 11, "年金据置期間");
    }

    @Test()
    @TestOrder(100)
    public void testEditNenkinSueokikikan_A10() {
        Integer hknkkn = 13;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        Integer hrkkkn = -1;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;
        Integer hhknnen = 2;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(editNenkinKoumokuUtil.getNenkinSueokikikan(), 13, "年金据置期間");
    }

    @Test()
    @TestOrder(110)
    public void testEditNenkinSueokikikan_A11() {

        exNumericEquals(editNenkinKoumokuUtil.getNenkinSueokikikan(), 0, "年金据置期間");
    }

    @Test()
    @TestOrder(120)
    public void testEditNenkinSueokikikan_A12() {
        Integer hknkkn = 100;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        Integer hrkkkn = 12;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;
        Integer hhknnen = 23;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test()
    @TestOrder(130)
    public void testEditNenkinSueokikikan_A13() {
        Integer hknkkn = 23;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hrkkkn = 12;
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        Integer hhknnen = 23;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(hknkkn, hknkknsmnKbn, hrkkkn, hrkkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }
}

