package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#chkHengakuNenkin(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_chkHengakuNenkin {

    @Test
    @TestOrder(10)
    public void testChkHengakuNenkin_J1() {
        String syouhnCd = null;

        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkin(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @TestOrder(20)
    public void testChkHengakuNenkin_J2() {
        String syouhnCd = "";

        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkin(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @TestOrder(30)
    public void testChkHengakuNenkin_J3() {
        String syouhnCd = "ｳ2";
        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkin(syouhnCd);
        exBooleanEquals(hanDeiFlg, true, "判定区分");

    }

    @Test
    @TestOrder(40)
    public void testChkHengakuNenkin_J4() {
        String syouhnCd = "ｱ1";
        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkin(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");

        MockObjectManager.initialize();

    }
}
