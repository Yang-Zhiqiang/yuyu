package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Taihntmdr;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 体格判定クラスのメソッド {@link HanteiTaikaku#hantei(int, int)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiTaikakuTest_hantei {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testHantei_A1() {
        C_Taihntmdr result = HanteiTaikaku.hantei( 0, 75);
        exClassificationEquals(result, C_Taihntmdr.CHK_NONE, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testHantei_B1() {
        C_Taihntmdr result = HanteiTaikaku.hantei( 181, 0);
        exClassificationEquals(result, C_Taihntmdr.CHK_NONE, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testHantei_C1() {
        C_Taihntmdr result = HanteiTaikaku.hantei( 200, 60);
        exClassificationEquals(result, C_Taihntmdr.KAKEI, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testHantei_C2() {
        C_Taihntmdr result = HanteiTaikaku.hantei( 200, 120);
        exClassificationEquals(result, C_Taihntmdr.KAJYUU, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testHantei_C3() {
        C_Taihntmdr result = HanteiTaikaku.hantei( 200, 68);
        exClassificationEquals(result, C_Taihntmdr.NORMAL, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testHantei_C4() {
        C_Taihntmdr result = HanteiTaikaku.hantei( 200, 64);
        exClassificationEquals(result, C_Taihntmdr.NORMAL, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testHantei_C5() {
        C_Taihntmdr result = HanteiTaikaku.hantei( 200, 116);
        exClassificationEquals(result, C_Taihntmdr.KAJYUU, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testHantei_C6() {
        C_Taihntmdr result = HanteiTaikaku.hantei( 200, 112);
        exClassificationEquals(result, C_Taihntmdr.NORMAL, "判定結果");
    }
}
