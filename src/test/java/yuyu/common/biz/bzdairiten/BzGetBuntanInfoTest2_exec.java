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
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.manager.impl.BizDomManagerImpl;
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
public class BzGetBuntanInfoTest2_exec {

    @Inject
    private BzGetBuntanInfo bzGetBuntanInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書_分担情報取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetBuntanInfoTest2_exec.class, fileName, sheetName);
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

        MockObjectManager.initialize();

        String drtenCd = "";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

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

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();

        String drtenCd = null;

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

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

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

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

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = null;

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

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

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = null;

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

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = null;

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

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = null;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = null;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        String pDrtenCd = (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 0);
        exStringEquals(pDrtenCd, "9000001", "代理店コード");

        String dairitenSyouhinCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 1);
        exStringEquals(dairitenSyouhinCd, "64200", "代理店商品コード");

        String pTesuuryouBuntanAiteDrtenCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 2);
        exStringEquals(pTesuuryouBuntanAiteDrtenCd, "A000001", "手数料分担相手代理店コード");

        BizDateYM pKijyunYm =
            (BizDateYM) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 3);
        exDateYMEquals(pKijyunYm, BizDateYM.valueOf(201601), "取得基準年月");

        exBizCalcbleEquals(bzGetBuntanInfo.getTesuuryouBuntanWariaiJibun()
            , BizNumber.valueOf(66), "手数料分担割合（自分）");

        exBizCalcbleEquals(bzGetBuntanInfo.getTesuuryouBuntanWariaiAite()
            , BizNumber.valueOf(34), "手数料分担割合（相手）");

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        String pDrtenCd = (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 0);
        exStringEquals(pDrtenCd, "9000001", "代理店コード");

        String dairitenSyouhinCd = (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 1);
        exStringEquals(dairitenSyouhinCd, "64200", "代理店商品コード");

        String pTesuuryouBuntanAiteDrtenCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 2);
        exStringEquals(pTesuuryouBuntanAiteDrtenCd, "A000001", "手数料分担相手代理店コード");

        BizDateYM pKijyunYm =
            (BizDateYM) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 3);
        exDateYMEquals(pKijyunYm, BizDateYM.valueOf(201601), "取得基準年月");

        exBizCalcbleEquals(bzGetBuntanInfo.getTesuuryouBuntanWariaiJibun()
            , BizNumber.valueOf(66), "手数料分担割合（自分）");

        exBizCalcbleEquals(bzGetBuntanInfo.getTesuuryouBuntanWariaiAite()
            , BizNumber.valueOf(34), "手数料分担割合（相手）");

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        String pDrtenCd = (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 0);
        exStringEquals(pDrtenCd, "9000001", "代理店コード");

        String dairitenSyouhinCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 1);
        exStringEquals(dairitenSyouhinCd, "64200", "代理店商品コード");

        String pTesuuryouBuntanAiteDrtenCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 2);
        exStringEquals(pTesuuryouBuntanAiteDrtenCd, "A000001", "手数料分担相手代理店コード");

        BizDateYM pKijyunYm =
            (BizDateYM) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 3);
        exDateYMEquals(pKijyunYm, BizDateYM.valueOf(201601), "取得基準年月");

        exBizCalcbleEquals(bzGetBuntanInfo.getTesuuryouBuntanWariaiJibun()
            , BizNumber.valueOf(66), "手数料分担割合（自分）");

        exBizCalcbleEquals(bzGetBuntanInfo.getTesuuryouBuntanWariaiAite()
            , BizNumber.valueOf(34), "手数料分担割合（相手）");

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        String pDrtenCd = (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 0);
        exStringEquals(pDrtenCd, "9000001", "代理店コード");

        String dairitenSyouhinCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 1);
        exStringEquals(dairitenSyouhinCd, "64100", "代理店商品コード");

        String pTesuuryouBuntanAiteDrtenCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 2);
        exStringEquals(pTesuuryouBuntanAiteDrtenCd, "A000001", "手数料分担相手代理店コード");

        BizDateYM pKijyunYm =
            (BizDateYM) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 3);
        exDateYMEquals(pKijyunYm, BizDateYM.valueOf(201601), "取得基準年月");

        exBizCalcbleEquals(bzGetBuntanInfo.getTesuuryouBuntanWariaiJibun()
            , BizNumber.valueOf(66), "手数料分担割合（自分）");

        exBizCalcbleEquals(bzGetBuntanInfo.getTesuuryouBuntanWariaiAite()
            , BizNumber.valueOf(34), "手数料分担割合（相手）");

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();

        String drtenCd = "9000002";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        String pDrtenCd = (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 0);
        exStringEquals(pDrtenCd, "9000002", "代理店コード");

        String dairitenSyouhinCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 1);
        exStringEquals(dairitenSyouhinCd, "64100", "代理店商品コード");

        String pTesuuryouBuntanAiteDrtenCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 2);
        exStringEquals(pTesuuryouBuntanAiteDrtenCd, "A000001", "手数料分担相手代理店コード");

        BizDateYM pKijyunYm =
            (BizDateYM) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 3);
        exDateYMEquals(pKijyunYm, BizDateYM.valueOf(201601), "取得基準年月");

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();

        String drtenCd = "9000001";

        String tesuuryouBuntanAiteDrtenCd = "A000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201508);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetBuntanInfo.exec(drtenCd
            , tesuuryouBuntanAiteDrtenCd
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        String pDrtenCd = (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 0);
        exStringEquals(pDrtenCd, "9000001", "代理店コード");

        String dairitenSyouhinCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 1);
        exStringEquals(dairitenSyouhinCd, "64100", "代理店商品コード");

        String pTesuuryouBuntanAiteDrtenCd =
            (String) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 2);
        exStringEquals(pTesuuryouBuntanAiteDrtenCd, "A000001", "手数料分担相手代理店コード");

        BizDateYM pKijyunYm =
            (BizDateYM) MockObjectManager.getArgument(BizDomManagerImpl.class, "getBuntanInfosByPK", 0, 3);
        exDateYMEquals(pKijyunYm, BizDateYM.valueOf(201508), "取得基準年月");

        exClassificationEquals(bzGetBuntanInfo.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

}
