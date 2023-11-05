package yuyu.common.biz.bznayose;

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
import yuyu.def.base.manager.BaseDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 採番名寄せのメイン処理{@link BzSaibanNayose#exec()}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSaibanNayoseTest_exec_2 {

    @Inject
    BzSaibanNayose pBzSaibanNayose;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_採番名寄せ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzSaibanNayoseTest_exec_2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());
    }

    @Test
    @TestOrder(10)
    public void testExec_A2() {
        //
        //        String pSequence = pBzSaibanNayose.exec();
        //
        //        exStringEquals(pSequence, "999999999999999980", "要求通番(初期値)");
        //
        //        pSequence = pBzSaibanNayose.exec();
        //
        //        exStringEquals(pSequence, "999999999999999990", "要求通番（連番一回）");
        //
        //        pSequence = pBzSaibanNayose.exec();
        //
        //        exStringEquals(pSequence, "999999999999999980", "要求通番（最初の戻る）");
    }
}
