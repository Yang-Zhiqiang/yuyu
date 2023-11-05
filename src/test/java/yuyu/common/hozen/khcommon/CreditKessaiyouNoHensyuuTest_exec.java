package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号表示編集のメソッド {@link CreditKessaiyouNoHensyuu#exec(String)}
 * テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreditKessaiyouNoHensyuuTest_exec {

    @Inject
    private CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String pCreditcardKessaiyouNo = "12345678901234567890123456";

        String dispCreditcardKessaiyouNo = creditKessaiyouNoHensyuu.exec(pCreditcardKessaiyouNo);

        exStringEquals(dispCreditcardKessaiyouNo,"12-34-567890123-456789-012345-6", "表示用クレジットカード決済用番号");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String pCreditcardKessaiyouNo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String dispCreditcardKessaiyouNo = creditKessaiyouNoHensyuu.exec(pCreditcardKessaiyouNo);

        exStringEquals(dispCreditcardKessaiyouNo,"AB-CD-EFGHIJKLM-NOPQRS-TUVWXY-Z", "表示用クレジットカード決済用番号");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String pCreditcardKessaiyouNo = "A1B2C3D4E5F6G7H8I9J0K1L2M3";

        String dispCreditcardKessaiyouNo = creditKessaiyouNoHensyuu.exec(pCreditcardKessaiyouNo);

        exStringEquals(dispCreditcardKessaiyouNo,"A1-B2-C3D4E5F6G-7H8I9J-0K1L2M-3", "表示用クレジットカード決済用番号");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String pCreditcardKessaiyouNo = null;

        String dispCreditcardKessaiyouNo = creditKessaiyouNoHensyuu.exec(pCreditcardKessaiyouNo);

        exStringEquals(dispCreditcardKessaiyouNo,"", "表示用クレジットカード決済用番号");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String pCreditcardKessaiyouNo = "";

        String dispCreditcardKessaiyouNo = creditKessaiyouNoHensyuu.exec(pCreditcardKessaiyouNo);

        exStringEquals(dispCreditcardKessaiyouNo,"", "表示用クレジットカード決済用番号");
    }
}
