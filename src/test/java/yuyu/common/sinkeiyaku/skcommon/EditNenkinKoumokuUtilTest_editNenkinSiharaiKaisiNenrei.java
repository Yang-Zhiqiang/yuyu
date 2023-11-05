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
 * 年金商品項目編集ユーティリティのメソッド
 * {@link EditNenkinKoumokuUtil#editNenkinSiharaiKaisiNenrei(Integer, C_HknkknsmnKbn, Integer)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class EditNenkinKoumokuUtilTest_editNenkinSiharaiKaisiNenrei {

    @Inject
    private EditNenkinKoumokuUtil editNenkinKoumokuUtil;

    @Test
    @TestOrder(10)
    public void testEditNenkinSiharaiKaisiNenrei_A1() {
        Integer hknkkn = null;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hhknnen = 1;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(hknkkn, hknkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testEditNenkinSiharaiKaisiNenrei_A2() {
        Integer hknkkn = 1;
        C_HknkknsmnKbn hknkknsmnKbn = null;
        Integer hhknnen = 1;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(hknkkn, hknkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testEditNenkinSiharaiKaisiNenrei_A3() {
        Integer hknkkn = 1;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hhknnen = null;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(hknkkn, hknkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test()
    @TestOrder(40)
    public void testEditNenkinSiharaiKaisiNenrei_A4() {
        Integer hknkkn = 100;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hhknnen = 2;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(hknkkn, hknkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test()
    @TestOrder(50)
    public void testEditNenkinSiharaiKaisiNenrei_A5() {
        Integer hknkkn = 1;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        Integer hhknnen = 2;
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(hknkkn, hknkknsmnKbn, hhknnen);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(editNenkinKoumokuUtil.getNenkinSiharaiKaisiNenrei(), 3, "年金支払開始年齢");
    }

    @Test()
    @TestOrder(60)
    public void testEditNenkinSiharaiKaisiNenrei_A6() {

        exNumericEquals(editNenkinKoumokuUtil.getNenkinSiharaiKaisiNenrei(), 0, "年金支払開始年齢");
    }
}

