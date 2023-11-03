package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#chkHengakuNenkinSyouhnZokusei(BM_SyouhnZokusei)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_chkHengakuNenkinSyouhnZokusei {

    private final static String fileName = "UT_SP_単体テスト仕様書_商品属性ユーティリティ";

    private final static String sheetName = "テストデータ";

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyouhinUtilTest_chkHengakuNenkinSyouhnZokusei.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ007", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testChkHengakuNenkinSyouhnZokusei_K1() {

        BM_SyouhnZokusei syouhnZokusei = null;
        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkinSyouhnZokusei(syouhnZokusei);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @TestOrder(20)
    public void testChkHengakuNenkinSyouhnZokusei_K2() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 0);
        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkinSyouhnZokusei(syouhnZokusei);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @TestOrder(30)
    public void testChkHengakuNenkinSyouhnZokusei_K3() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("M120", 0);
        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkinSyouhnZokusei(syouhnZokusei);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @TestOrder(40)
    public void testChkHengakuNenkinSyouhnZokusei_K4() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("M121", 0);
        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkinSyouhnZokusei(syouhnZokusei);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @TestOrder(50)
    public void testChkHengakuNenkinSyouhnZokusei_K5() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("M122", 0);
        boolean hanDeiFlg  = SyouhinUtil.chkHengakuNenkinSyouhnZokusei(syouhnZokusei);
        exBooleanEquals(hanDeiFlg, true, "判定区分");
    }
}
