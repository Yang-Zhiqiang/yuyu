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
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通算総死亡Ｓチェック旧基準判定 のメソッド {@link SyouhinUtil#hanteiTuusanSousibouSKyuuKijun(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_hanteiTuusanSousibouSKyuuKijun {

    private final static String fileName = "UT_SP_単体テスト仕様書_商品属性ユーティリティ";

    private final static String sheetName = "テストデータ";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SyouhinUtil syouhinUtil;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyouhinUtilTest_hanteiTuusanSousibouSKyuuKijun.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ009", testDataAndTblMap);
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
    public void testHanteiItijibaraiPTuusanCheckYouhi_Q1() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("a1", 0);
        syouhnZokusei.setSyouhncd(null);

        C_BlnktkumuKbn blnktkumukbn  = syouhinUtil.hanteiTuusanSousibouSKyuuKijun(syouhnZokusei);
        exClassificationEquals(blnktkumukbn, C_BlnktkumuKbn.BLNK, "旧基準使用有無");
    }

    @Test
    @TestOrder(20)
    public void testHanteiItijibaraiPTuusanCheckYouhi_Q2() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("a1", 0);
        syouhnZokusei.setSyouhncd("");

        C_BlnktkumuKbn blnktkumukbn  = syouhinUtil.hanteiTuusanSousibouSKyuuKijun(syouhnZokusei);
        exClassificationEquals(blnktkumukbn, C_BlnktkumuKbn.BLNK, "旧基準使用有無");
    }

    @Test
    @TestOrder(30)
    public void testHanteiItijibaraiPTuusanCheckYouhi_Q3() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 0);

        C_BlnktkumuKbn blnktkumukbn  = syouhinUtil.hanteiTuusanSousibouSKyuuKijun(syouhnZokusei);
        exClassificationEquals(blnktkumukbn, C_BlnktkumuKbn.ARI, "旧基準使用有無");
    }

    @Test
    @TestOrder(40)
    public void testHanteiItijibaraiPTuusanCheckYouhi_Q4() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 0);

        C_BlnktkumuKbn blnktkumukbn  = syouhinUtil.hanteiTuusanSousibouSKyuuKijun(syouhnZokusei);
        exClassificationEquals(blnktkumukbn, C_BlnktkumuKbn.ARI, "旧基準使用有無");
    }

    @Test
    @TestOrder(50)
    public void testHanteiItijibaraiPTuusanCheckYouhi_Q5() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾉ", 0);

        C_BlnktkumuKbn blnktkumukbn  = syouhinUtil.hanteiTuusanSousibouSKyuuKijun(syouhnZokusei);
        exClassificationEquals(blnktkumukbn, C_BlnktkumuKbn.NONE, "旧基準使用有無");
    }

    @Test
    @TestOrder(60)
    public void testHanteiItijibaraiPTuusanCheckYouhi_Q6() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｺ", 0);

        C_BlnktkumuKbn blnktkumukbn  = syouhinUtil.hanteiTuusanSousibouSKyuuKijun(syouhnZokusei);
        exClassificationEquals(blnktkumukbn, C_BlnktkumuKbn.BLNK, "旧基準使用有無");
    }

    @Test
    @TestOrder(70)
    public void testHanteiItijibaraiPTuusanCheckYouhi_Q7() {
        C_BlnktkumuKbn blnktkumukbn  = syouhinUtil.hanteiTuusanSousibouSKyuuKijun(null);
        exClassificationEquals(blnktkumukbn, C_BlnktkumuKbn.BLNK, "旧基準使用有無");
    }
}