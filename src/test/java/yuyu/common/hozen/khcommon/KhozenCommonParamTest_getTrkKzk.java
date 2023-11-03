package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全共通パラメータクラスのメソッド {@link KhozenCommonParam#getTrkKzk(String)}
 * テスト用クラスです <br />
 */
@RunWith(OrderedRunner.class)
public class KhozenCommonParamTest_getTrkKzk {

    @Inject
    private KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約保全共通パラメータ";
    private final static String sheetName = "INデータ_20191010";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KhozenCommonParamTest_getTrkKzk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllZennouKeikaRiritu());
        bizDomManager.delete(bizDomManager.getAllZennouGenkaRitu());
    }

    @Test
    @TestOrder(10)
    public void testGetTrkKzk_A1() {

        String syoNo = "60806040047";

        List<IT_TrkKzk> trkKzkList = khozenCommonParam.getTrkKzk(syoNo);

        assertNull(trkKzkList);
    }

    @Test
    @TestOrder(20)
    public void testGetTrkKzk_A2() {

        String syoNo = "60806040057";

        List<IT_TrkKzk> trkKzkList = khozenCommonParam.getTrkKzk(syoNo);

        assertNull(trkKzkList);
    }

    @Test
    @TestOrder(30)
    public void testGetTrkKzk_A3() {

        String syoNo = "60806040068";

        List<IT_TrkKzk> trkKzkList = khozenCommonParam.getTrkKzk(syoNo);

        IT_TrkKzk trkKzk = trkKzkList.get(0);

        String kbnkey = trkKzk.getKbnkey();
        String syono = trkKzk.getSyono();
        C_TrkKzkKbn trkKzkKbn = trkKzk.getTrkkzkkbn();

        exStringEquals(kbnkey, "06", "区分キー");
        exStringEquals(syono, "60806040068", "証券番号");
        exClassificationEquals(trkKzkKbn, C_TrkKzkKbn.TRKKZK1, "登録家族区分");
        exNumericEquals(trkKzkList.size(), 1, "登録家族テーブルエンティティリスト");
    }

    @Test
    @TestOrder(40)
    public void testGetTrkKzk_A4() {

        String syoNo = "60806040079";

        List<IT_TrkKzk> trkKzkList = khozenCommonParam.getTrkKzk(syoNo);

        IT_TrkKzk trkKzk1 = trkKzkList.get(0);
        IT_TrkKzk trkKzk2 = trkKzkList.get(1);
        IT_TrkKzk trkKzk3 = trkKzkList.get(2);

        String kbnkey1 = trkKzk1.getKbnkey();
        String syono1 = trkKzk1.getSyono();
        C_TrkKzkKbn trkKzkKbn1 = trkKzk1.getTrkkzkkbn();

        String kbnkey2 = trkKzk2.getKbnkey();
        String syono2 = trkKzk2.getSyono();
        C_TrkKzkKbn trkKzkKbn2 = trkKzk2.getTrkkzkkbn();

        String kbnkey3 = trkKzk3.getKbnkey();
        String syono3 = trkKzk3.getSyono();
        C_TrkKzkKbn trkKzkKbn3 = trkKzk3.getTrkkzkkbn();

        exStringEquals(kbnkey1, "07", "区分キー");
        exStringEquals(syono1, "60806040079", "証券番号");
        exClassificationEquals(trkKzkKbn1, C_TrkKzkKbn.BLNK, "登録家族区分");

        exStringEquals(kbnkey2, "07", "区分キー");
        exStringEquals(syono2, "60806040079", "証券番号");
        exClassificationEquals(trkKzkKbn2, C_TrkKzkKbn.TRKKZK1, "登録家族区分");

        exStringEquals(kbnkey3, "07", "区分キー");
        exStringEquals(syono3, "60806040079", "証券番号");
        exClassificationEquals(trkKzkKbn3, C_TrkKzkKbn.TRKKZK2, "登録家族区分");

        exNumericEquals(trkKzkList.size(), 3, "登録家族テーブルエンティティリスト");
    }
}
