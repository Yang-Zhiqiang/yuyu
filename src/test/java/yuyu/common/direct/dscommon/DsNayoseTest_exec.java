package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ名寄せのメソッド{@link DsNayose#exec(String, String, BizDate, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsNayoseTest_exec {
    @Inject
    private DsNayose dsNayose;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ名寄せ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsNayoseTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567890"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567891"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567892"));
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        DsNayoseBean dsNayoseBean = SWAKInjector.getInstance(DsNayoseBean.class);
        dsNayoseBean = dsNayose.exec("カナ", "漢字", BizDate.valueOf("20151013"), "1234567");
        exClassificationEquals(dsNayoseBean.getNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUNONE,
            "名寄せ実施結果区分");
        exStringEquals(dsNayoseBean.getKokno(), "", "顧客番号");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        DsNayoseBean dsNayoseBean = SWAKInjector.getInstance(DsNayoseBean.class);
        dsNayoseBean = dsNayose.exec("カナ", "漢字", BizDate.valueOf("20151014"), "1234567");
        exClassificationEquals(dsNayoseBean.getNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI,
            "名寄せ実施結果区分");
        exStringEquals(dsNayoseBean.getKokno(), "1234567890", "顧客番号");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        DsNayoseBean dsNayoseBean = SWAKInjector.getInstance(DsNayoseBean.class);
        dsNayoseBean = dsNayose.exec("カナカナ", "漢字", BizDate.valueOf("20151014"), "1234567");
        exClassificationEquals(dsNayoseBean.getNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI,
            "名寄せ実施結果区分");
        exStringEquals(dsNayoseBean.getKokno(), "", "顧客番号");
    }
}
