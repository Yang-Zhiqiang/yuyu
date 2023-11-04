package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link BzSegmentCdSyutoku}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSegmentCdSyutokuTest_exec {

    @Inject
    private BzSegmentCdSyutoku bzSegmentCdSyutoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_セグメントコード取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzShiharaiDenpyouDateShutokuTest_exec.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec("ﾕA", C_Tuukasyu.JPY);

        exClassificationEquals(syouhinbetuSegmentBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(syouhinbetuSegmentBean.getSegcd1(), null, "セグメント１コード");
        exClassificationEquals(syouhinbetuSegmentBean.getSegcd2(), null, "セグメント２コード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec("ﾕD", C_Tuukasyu.JPY);

        exClassificationEquals(syouhinbetuSegmentBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(syouhinbetuSegmentBean.getSegcd1(), C_Segcd.JPYNENKIN, "セグメント１コード");
        exClassificationEquals(syouhinbetuSegmentBean.getSegcd2(), C_Segcd.BLNK, "セグメント２コード");
    }

}
