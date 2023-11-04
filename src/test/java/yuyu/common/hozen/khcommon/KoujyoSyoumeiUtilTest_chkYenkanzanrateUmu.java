package yuyu.common.hozen.khcommon;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明ユーティリティクラスのメソッド {@link KoujyoSyoumeiUtil#chkYenkanzanrateUmu(BizDate, C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KoujyoSyoumeiUtilTest_chkYenkanzanrateUmu {

    @Inject
    private KoujyoSyoumeiUtil koujyoSyoumeiUtil;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_控除証明ユーティリティ";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(KoujyoSyoumeiUtilTest_chkYenkanzanrateUmu.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());

    }

    @Test
    @TestOrder(10)
    public void testChkYenkanzanrateUmu_A1() {

        BizDate yenkanzanrateYmd = BizDate.valueOf(20210811);

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_UmuKbn umuKbn = koujyoSyoumeiUtil.chkYenkanzanrateUmu(yenkanzanrateYmd, pTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "有無区分");
    }

    @Test
    @TestOrder(20)
    public void testChkYenkanzanrateUmu_A2() {

        BizDate yenkanzanrateYmd = BizDate.valueOf(20200811);

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_UmuKbn umuKbn = koujyoSyoumeiUtil.chkYenkanzanrateUmu(yenkanzanrateYmd, pTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "有無区分");
    }
}
