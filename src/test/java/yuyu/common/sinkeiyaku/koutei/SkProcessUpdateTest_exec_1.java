package yuyu.common.sinkeiyaku.koutei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatch;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessUpdateクラスのメソッド {@link SkProcessUpdate#exec(HT_SyoriCTL, String, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessUpdateTest_exec_1 {

    @Inject
    private SkProcessUpdate skProcessUpdate;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約工程情報更新";

    private final static String sheetName = "INデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessUpdateForBatch.class).to(BzProcessUpdateForBatchMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit() {
        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessUpdateTest_exec_1.class;
        BzProcessUpdateForBatchMockForSinkeiyaku.caller = SkProcessUpdateTest_exec_1.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessUpdateForBatchMockForSinkeiyaku.caller = null;
        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessUpdateTest_exec_1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = BzProcessUpdateForBatchMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");

        String skDrtenKouteiLockKey = "1234567";

        String skHenkinKouteiLockKey = "123456789";

        skProcessUpdate.exec(syoriCTL, skDrtenKouteiLockKey, skHenkinKouteiLockKey);

        MockObjectManager.assertCalled(SkProcessUpdate.class, "editProcessUpdateForBatchInfo");
        MockObjectManager.assertCalled(SkProcessUpdate.class, "execForBatch");

        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");

        System.out.println("*********************** ***********************");
        System.out.println(syoriCTL);

        String skDrtenKouteiLockKey = "1234567";

        String skHenkinKouteiLockKey = "123456789";

        skProcessUpdate.exec(syoriCTL, skDrtenKouteiLockKey, skHenkinKouteiLockKey);

        MockObjectManager.assertNotCalled(SkProcessUpdate.class, "editProcessUpdateForBatchInfo");
        MockObjectManager.assertNotCalled(SkProcessUpdate.class, "execForBatch");

    }

}
