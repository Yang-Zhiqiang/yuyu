package yuyu.common.siharai.sicommon;


import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_GeninKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 災害該当判定クラスの災害該当判定（原因区分）メソッド {@link SaigaiGaitouHantei#chkGeninkbn(C_GeninKbn)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SaigaiGaitouHanteiTest_chkGeninkbn {

    @Inject
    private SaigaiGaitouHantei saigaiGaitouHantei;

    @Test
    @TestOrder(10)
    public void testChkGeninkbn_A1() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(null);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(20)
    public void testChkGeninkbn_A2() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.BLNK);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(30)
    public void testChkGeninkbn_A3() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.JS);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(40)
    public void testChkGeninkbn_A4() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.KTJK);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(50)
    public void testChkGeninkbn_A5() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.TENTOU);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(60)
    public void testChkGeninkbn_A6() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.DKS);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(70)
    public void testChkGeninkbn_A7() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.KKOKS);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(80)
    public void testChkGeninkbn_A8() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.TSK);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(90)
    public void testChkGeninkbn_A9() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.TDK);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(100)
    public void testChkGeninkbn_A10() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.SONOTAFR);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(110)
    public void testChkGeninkbn_A11() {

        boolean result = saigaiGaitouHantei.chkGeninkbn(C_GeninKbn.TST);

        exBooleanEquals(result, true, "判定結果フラグ");
    }


}
