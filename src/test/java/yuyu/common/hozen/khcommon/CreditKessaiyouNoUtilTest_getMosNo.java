package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号ユーティリティのメソッド {@link CreditKessaiyouNoUtil#getMosNo(String)}
 * テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreditKessaiyouNoUtilTest_getMosNo {

    @Inject
    private CreditKessaiyouNoUtil creditKessaiyouNoUtil;

    @Test
    @TestOrder(10)
    public void testGetMosNo_A1() {

        String pCreditcardKessaiyouNo = "12345678901234567890123456";

        String mosNo = creditKessaiyouNoUtil.getMosNo(pCreditcardKessaiyouNo);

        exStringEquals(mosNo, "567890123", "申込番号");
    }

    @Test
    @TestOrder(20)
    public void testGetMosNo_A2() {

        String pCreditcardKessaiyouNo = "13345678901234567890123456";

        String mosNo = creditKessaiyouNoUtil.getMosNo(pCreditcardKessaiyouNo);

        exStringEquals(mosNo, "", "申込番号");
    }
}
