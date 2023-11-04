package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * CheckProcessKekkaクラスのメソッド {@link CheckProcessKekka#exec(String,String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckProcessKekkaTest_exec {

    @Inject
    private CheckProcessKekka checkProcessKekka;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.BLNK, "123", C_SasimodosisakiKbn.BLNK);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果を選択してください。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.TORIKESI, "", C_SasimodosisakiKbn.BLNK);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に受付取消を選択する場合は、コメントを入力してください。", "エラーメッセージ");
        }
    }


    @Test
    @TestOrder(30)
    public void testExec_A3() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.SASIMODOSI, "", C_SasimodosisakiKbn.BLNK);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に差戻しを選択する場合は、コメントを入力してください。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.HUSYOUNIN, "", C_SasimodosisakiKbn.NYUURYOKU);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不承認を選択する場合は、コメントを入力してください。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.HUSYOUNIN, "コメント123", C_SasimodosisakiKbn.BLNK);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "差戻し先を選択してください。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.TENSOU, "コメント123", C_SasimodosisakiKbn.NYUURYOKU);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不承認以外を選択する場合は、差戻し先を選択できません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        boolean result = checkProcessKekka.exec(C_SyorikekkaKbn.SASIMODOSI, "コメント123", C_SasimodosisakiKbn.BLNK);
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        boolean result = checkProcessKekka.exec(C_SyorikekkaKbn.HUSYOUNIN, "コメント123", C_SasimodosisakiKbn.TENKEN);
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.KANRYOU, "コメント123", C_SasimodosisakiKbn.NYUURYOKU);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不承認以外を選択する場合は、差戻し先を選択できません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.SYOUNIN, "コメント123", C_SasimodosisakiKbn.NYUURYOKU);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不承認以外を選択する場合は、差戻し先を選択できません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.HUBI, "コメント123", C_SasimodosisakiKbn.NYUURYOKU);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不承認以外を選択する場合は、差戻し先を選択できません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.HORYUU, "コメント123", C_SasimodosisakiKbn.NYUURYOKU);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不承認以外を選択する場合は、差戻し先を選択できません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.HUBITYUUSI, "コメント123", C_SasimodosisakiKbn.NYUURYOKU);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不承認以外を選択する場合は、差戻し先を選択できません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.KAITOUMATI, "コメント123", C_SasimodosisakiKbn.NYUURYOKU);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不承認以外を選択する場合は、差戻し先を選択できません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        try {
            checkProcessKekka.exec(C_SyorikekkaKbn.HUBI, "", C_SasimodosisakiKbn.BLNK);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "結果に不備を選択する場合は、コメントを入力してください。", "エラーメッセージ");
        }
    }
}
