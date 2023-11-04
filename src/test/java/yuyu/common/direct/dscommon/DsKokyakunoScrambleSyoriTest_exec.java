package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ顧客番号スクランブル化処理のメソッド{@link DsKokyakunoScrambleSyori#exec(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class DsKokyakunoScrambleSyoriTest_exec {

    @Inject
    private DsKokyakunoScrambleSyori dsKokyakunoScrambleSyori;
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        String pDsKokNo = null;

        try {
            dsKokyakunoScrambleSyori.exec(pDsKokNo);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage(), "ＤＳ顧客番号スクランブル化処理中にエラーが発生しました。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        String pDsKokNo = "";

        try {
            dsKokyakunoScrambleSyori.exec(pDsKokNo);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage(), "ＤＳ顧客番号スクランブル化処理中にエラーが発生しました。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_B1() {

        String pDsKokNo = "123456789";

        try {
            dsKokyakunoScrambleSyori.exec(pDsKokNo);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage(), "ＤＳ顧客番号スクランブル化処理中にエラーが発生しました。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_B2() {

        String pDsKokNo = "1234567890";

        String zrnsclatoKokNo = dsKokyakunoScrambleSyori.exec(pDsKokNo);

        exStringEquals(zrnsclatoKokNo, "1098654321", "スクランブル化後ＤＳ顧客番号");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_B3() {

        String pDsKokNo = "12345678aA";

        try {
            dsKokyakunoScrambleSyori.exec(pDsKokNo);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage(), "ＤＳ顧客番号スクランブル化処理中にエラーが発生しました。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(60)
    public void testExec_B4() {

        String pDsKokNo = "12345678ａＡ";

        try {
            dsKokyakunoScrambleSyori.exec(pDsKokNo);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage(), "ＤＳ顧客番号スクランブル化処理中にエラーが発生しました。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(70)
    public void testExec_B5() {

        String pDsKokNo = "1234567８９０";

        try {
            dsKokyakunoScrambleSyori.exec(pDsKokNo);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage(), "ＤＳ顧客番号スクランブル化処理中にエラーが発生しました。", "エラーメッセージ");
            throw e;
        }
    }
}