package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
 * 申込内容チェック実施要否判定のメソッド {@link HanteiMoschk#hanteiYoteirirituHendouGetTumitateriritu(BM_SyouhnZokusei, List<BM_SyouhnZokusei>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiMoschkTest_hanteiYoteirirituHendouGetTumitateriritu {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込内容チェック実施要否判定";

    private final static String sheetName = "INデータ";

    @Inject
    private HanteiMoschk hanteiMoschk;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiMoschkTest_hanteiYoteirirituHendouGetTumitateriritu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
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
    @Transactional
    @TestOrder(10)
    public void testHanteiYoteirirituHendouGetTumitateriritu_A1() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｺ", 1);

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiYoteirirituHendouGetTumitateriritu(syouhnZokusei, null);

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "チェック要否");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testHanteiYoteirirituHendouGetTumitateriritu_A2() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｲ1", 1);

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiYoteirirituHendouGetTumitateriritu(syouhnZokusei,
            new ArrayList<BM_SyouhnZokusei>());

        exClassificationEquals(youhiKbn, C_YouhiKbn.HUYOU, "チェック要否");
    }
}
