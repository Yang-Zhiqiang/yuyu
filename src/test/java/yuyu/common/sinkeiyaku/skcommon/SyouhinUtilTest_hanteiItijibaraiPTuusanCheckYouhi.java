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
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 一時払Ｐ通算チェック実施要否判定 のメソッド {@link SyouhinUtil#hanteiItijibaraiPTuusanCheckYouhi(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_hanteiItijibaraiPTuusanCheckYouhi {

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
            testDataAndTblMap = testDataMaker.getInData(SyouhinUtilTest_hanteiItijibaraiPTuusanCheckYouhi.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ008", testDataAndTblMap);
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
    public void testHanteiItijibaraiPTuusanCheckYouhi_P1() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("a1", 0);
        syouhnZokusei.setSyouhncd(null);

        C_YouhiKbn cyouhikbn  = syouhinUtil.hanteiItijibaraiPTuusanCheckYouhi(syouhnZokusei);
        exClassificationEquals(cyouhikbn, C_YouhiKbn.HUYOU, "チェック要否");
    }

    @Test
    @TestOrder(20)
    public void testHanteiItijibaraiPTuusanCheckYouhi_P2() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("a1", 0);
        syouhnZokusei.setSyouhncd("");

        C_YouhiKbn cyouhikbn  = syouhinUtil.hanteiItijibaraiPTuusanCheckYouhi(syouhnZokusei);
        exClassificationEquals(cyouhikbn, C_YouhiKbn.HUYOU, "チェック要否");
    }

    @Test
    @TestOrder(30)
    public void testHanteiItijibaraiPTuusanCheckYouhi_P3() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 0);

        C_YouhiKbn cyouhikbn  = syouhinUtil.hanteiItijibaraiPTuusanCheckYouhi(syouhnZokusei);
        exClassificationEquals(cyouhikbn, C_YouhiKbn.YOU, "チェック要否");
    }

    @Test
    @TestOrder(40)
    public void testHanteiItijibaraiPTuusanCheckYouhi_P4() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾉ", 0);

        C_YouhiKbn cyouhikbn  = syouhinUtil.hanteiItijibaraiPTuusanCheckYouhi(syouhnZokusei);
        exClassificationEquals(cyouhikbn, C_YouhiKbn.HUYOU, "チェック要否");
    }

    @Test
    @TestOrder(50)
    public void testHanteiItijibaraiPTuusanCheckYouhi_P5() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｺ", 0);

        C_YouhiKbn cyouhikbn  = syouhinUtil.hanteiItijibaraiPTuusanCheckYouhi(syouhnZokusei);
        exClassificationEquals(cyouhikbn, C_YouhiKbn.HUYOU, "チェック要否");
    }

    @Test
    @TestOrder(60)
    public void testHanteiItijibaraiPTuusanCheckYouhi_P6() {

        C_YouhiKbn cyouhikbn  = syouhinUtil.hanteiItijibaraiPTuusanCheckYouhi(null);
        exClassificationEquals(cyouhikbn, C_YouhiKbn.HUYOU, "チェック要否");
    }
}