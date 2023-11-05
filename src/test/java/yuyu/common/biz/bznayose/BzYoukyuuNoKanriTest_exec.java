package yuyu.common.biz.bznayose;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 要求通番発番クラスのメソッド {@link BzYoukyuuNoKanri#exec(BzYoukyuuNoKanriBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzYoukyuuNoKanriTest_exec extends AbstractTest{

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_要求通番発番";

    private final static String sheetName = "INデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzSaibanNayose.class).to(BzSaibanNayoseMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzYoukyuuNoKanriTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());
    }

    @BeforeClass
    @Transactional
    public static void testInit() {
        BzSaibanNayoseMockForSinkeiyaku.caller = BzYoukyuuNoKanriTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzSaibanNayoseMockForSinkeiyaku.caller = null;
        BzSaibanNayoseMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzSaibanNayoseMockForSinkeiyaku.SYORIPTN = BzSaibanNayoseMockForSinkeiyaku.TESTPATTERN1;
        BzYoukyuuNoKanriBean bzYoukyuuNoKanriBean = SWAKInjector.getInstance(BzYoukyuuNoKanriBean.class);
        BzYoukyuuNoKanri bzYoukyuuNoKanri = SWAKInjector.getInstance(BzYoukyuuNoKanri.class);
        bzYoukyuuNoKanriBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.MOSNO);
        bzYoukyuuNoKanriBean.setHuho2KykNo("780123451");
        bzYoukyuuNoKanriBean = bzYoukyuuNoKanri.exec(bzYoukyuuNoKanriBean);
        exClassificationEquals(bzYoukyuuNoKanriBean.getHuho2KykNoKbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzYoukyuuNoKanriBean.getHuho2KykNo(), "780123451", "普保Ⅱ契約番号");
        exStringEquals(bzYoukyuuNoKanriBean.getYoukyuuNo(), "000000000000000010", "要求通番");
    }
}
