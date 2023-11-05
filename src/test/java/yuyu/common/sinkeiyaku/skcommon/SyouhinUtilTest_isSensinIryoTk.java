package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#isSensinIryoTk(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_isSensinIryoTk {

    @Test
    @Transactional
    @TestOrder(10)
    public void testIsSensinIryoTk_G1() {
        String syouhnCd = null;

        boolean hanDeiFlg  = SyouhinUtil.isSensinIryoTk(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testIsSensinIryoTk_G2() {
        String syouhnCd = "";

        boolean hanDeiFlg  = SyouhinUtil.isSensinIryoTk(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testIsSensinIryoTk_G3() {
        String syouhnCd = "MD10";

        boolean hanDeiFlg  = SyouhinUtil.isSensinIryoTk(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");

        MockObjectManager.initialize();
    }
}
