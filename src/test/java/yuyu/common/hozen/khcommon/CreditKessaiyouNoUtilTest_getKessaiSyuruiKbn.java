package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号ユーティリティのメソッド {@link CreditKessaiyouNoUtil#getKessaiSyuruiKbn(String)
 * テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreditKessaiyouNoUtilTest_getKessaiSyuruiKbn {

    @Inject
    private CreditKessaiyouNoUtil creditKessaiyouNoUtil;

    @Test
    @TestOrder(10)
    public void testGetKessaiSyuruiKbn_A1() {

        String pCreditcardKessaiyouNo = "12345678901234567890123456";

        String kessaiSyuruiKbn = creditKessaiyouNoUtil.getKessaiSyuruiKbn(pCreditcardKessaiyouNo);

        exStringEquals(kessaiSyuruiKbn, "1", "決済種類区分");
    }
}

