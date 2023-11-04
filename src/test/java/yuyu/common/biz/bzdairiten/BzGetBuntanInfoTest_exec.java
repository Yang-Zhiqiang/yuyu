package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 分担情報取得クラスのメソッド {@link BzGetBuntanInfo#exec(String, String, BizDateYM, C_DrtSyouhinSikibetuKbn,
 *                                                         C_Hrkkaisuu, C_DiritenplannmKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetBuntanInfoTest_exec {

    @Inject
    private BzGetBuntanInfo bzGetBuntanInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書_分担情報取得";

    private final static String sheetName = "テストデータ_20170512";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetBuntanInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBuntanInfo());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201705);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String drtenCd = "9000002";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201705);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String drtenCd = "9000003";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201705);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String drtenCd = "9000004";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201705);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

}
