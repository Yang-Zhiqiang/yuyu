package yuyu.common.hozen.khcommon;

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
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全共通パラメータクラスのメソッド {@link KhozenCommonParam#getSiteiDairiSeikyuunin(String)}
 * テスト用クラスです <br />
 */
@RunWith(OrderedRunner.class)
public class KhozenCommonParamTest_getSiteiDairiSeikyuunin {

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
            testDataAndTblMap = testDataMaker.getInData(KhozenCommonParamTest_getSiteiDairiSeikyuunin.class,
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
    public void testGetSiteiDairiSeikyuunin_A1() {

        String syoNo = "60806040002";

        IT_KykUkt kykUkt = khozenCommonParam.getSiteiDairiSeikyuunin(syoNo);

        String kbnkey = kykUkt.getKbnkey();
        String syono = kykUkt.getSyono();
        C_UktsyuKbn uktsyukbn = kykUkt.getUktsyukbn();
        Integer uktsyurenno = kykUkt.getUktsyurenno();

        exStringEquals(kbnkey, "00", "区分キー");
        exStringEquals(syono, "60806040002", "証券番号");
        exClassificationEquals(uktsyukbn, C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uktsyurenno, 1, "受取人種類別連番");
    }
}
