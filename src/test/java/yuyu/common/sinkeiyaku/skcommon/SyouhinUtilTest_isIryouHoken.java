package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#isIryouHoken(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_isIryouHoken {

    @Test
    @Transactional
    @TestOrder(10)
    public void testIsIryouHoken_H1() {
        String syouhnCd = null;

        boolean hanDeiFlg  = SyouhinUtil.isIryouHoken(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testIsIryouHoken_H2() {
        String syouhnCd = "";

        boolean hanDeiFlg  = SyouhinUtil.isIryouHoken(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testIsIryouHoken_H3() {
        String syouhnCd = "M110";

        boolean hanDeiFlg  = SyouhinUtil.isIryouHoken(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");

        MockObjectManager.initialize();

    }
}
