package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KengenSyoriKbn;
import yuyu.def.classification.C_SansyoukngnumuKbn;
import yuyu.testinfr.TestOrder;

/**
 * データ参照権限チェッククラスのメソッド {@link CheckDataSansyou#execCheck(String ,C_KengenSyoriKbn)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CheckDataSansyouTest_execCheck {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }


    @Test
    @TestOrder(10)
    public void testExecCheck_A1(){

        C_SansyoukngnumuKbn kbn = CheckDataSansyou.execCheck( "" ,C_KengenSyoriKbn.SYORI);
        exClassificationEquals(kbn , C_SansyoukngnumuKbn.ARI, "参照権限有無区分" );
    }

    @Test
    @TestOrder(20)
    public void testExecCheck_A2(){

        C_SansyoukngnumuKbn kbn = CheckDataSansyou.execCheck("" ,C_KengenSyoriKbn.SYOUKAI);
        exClassificationEquals(kbn , C_SansyoukngnumuKbn.ARI, "参照権限有無区分_権限権限あり " );
    }

    @Test
    @TestOrder(30)
    public void testExecCheck_A3(){

        C_SansyoukngnumuKbn kbn = CheckDataSansyou.execCheck("" ,null);
        exClassificationEquals(kbn , C_SansyoukngnumuKbn.ARI, "参照権限有無区分_権限権限あり " );

    }
}
