package yuyu.common.hozen.khcommon;

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
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 案内収納用注意情報設定クラスのメソッド {@link AnsyuuSetTetudukityuuiInfo#exec(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class AnsyuuSetTetudukityuuiInfoTest_exec {

    @Inject
    private AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_案内収納用注意情報設定";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(AnsyuuSetTetudukityuuiInfoTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String syono = String.valueOf("60806000114");

        C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(syono);

        exClassificationEquals(kktyuitaKbn, C_KktyuitaKbn.DNGNMEMONASI, "契約管理注意取扱区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_B1() {

        String syono = String.valueOf("11809111125");

        AnsyuuSetTetudukityuuiInfoBean ausyuuSetTetudukityuuiInfoBean =
            ansyuuSetTetudukityuuiInfo.getAnsyuuSetTetudukityuuiInfo(syono);

        exClassificationEquals(ausyuuSetTetudukityuuiInfoBean.getKktyuitaKbn(),
            C_KktyuitaKbn.DNGNMEMOARI, "契約管理注意取扱区分");

        exClassificationEquals(ausyuuSetTetudukityuuiInfoBean.getKykdrknhatudoujyoutaiKbn(),
            C_KykdrknHtdjytKbn.SETTEI, "契約者代理権発動状態");
    }
}