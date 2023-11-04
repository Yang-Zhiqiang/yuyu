package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号ユーティリティのメソッド {@link CreditKessaiyouNoUtil#getKeySyuruiKbn(String)}
 * テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreditKessaiyouNoUtilTest_getKeySyuruiKbn {

    @Inject
    private CreditKessaiyouNoUtil creditKessaiyouNoUtil;

    @Test
    @TestOrder(10)
    public void testGetKeySyuruiKbn_A1() {

        String pCreditcardKessaiyouNo = "12345678901234567890123456";

        String keySyuruiKbn = creditKessaiyouNoUtil.getKeySyuruiKbn(pCreditcardKessaiyouNo);

        exStringEquals(keySyuruiKbn, "2", "キー種類区分");
    }
}
