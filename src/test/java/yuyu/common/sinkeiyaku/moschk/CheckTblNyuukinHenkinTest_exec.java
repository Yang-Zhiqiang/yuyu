package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金TBL・返金TBLチェッククラスのメソッド {@link CheckTblNyuukinHenkin#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckTblNyuukinHenkinTest_exec {

    private final static String mosNo1 = "791112220";

    private final static String fileName = "UT-SP_単体テスト仕様書_入金TBL・返金TBLチェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private CheckTblNyuukinHenkin checkTblNyuukinHenkin;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;


    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblNyuukinHenkinTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkTblNyuukinHenkin.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "791112220", "申込番号");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.NYUUKINCHKMIRYOU, "入金状態区分");
        exStringEquals(syoriCTL.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getGyoumuKousinTime(), null, "業務用更新時間");
    }
}