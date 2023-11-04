package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号ユーティリティのメソッド {@link CreditKessaiyouNoUtil#getSyoNo(String)}
 * テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreditKessaiyouNoUtilTest_getSyoNo {

    @Inject
    private CreditKessaiyouNoUtil creditKessaiyouNoUtil;

    @Test
    @TestOrder(10)
    public void testGetSyoNo_A1() {

        String pCreditcardKessaiyouNo = "13245678901234567890123456";

        String syoNo = creditKessaiyouNoUtil.getSyoNo(pCreditcardKessaiyouNo);

        exStringEquals(syoNo, "24567890123", "証券番号");
    }

    @Test
    @TestOrder(20)
    public void testGetSyoNo_A2() {

        String pCreditcardKessaiyouNo = "12345678901234567890123456";

        String syoNo = creditKessaiyouNoUtil.getSyoNo(pCreditcardKessaiyouNo);

        exStringEquals(syoNo, "", "証券番号");
    }
}
