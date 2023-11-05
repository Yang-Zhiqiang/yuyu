package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

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
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 分担情報取得クラスのメソッド {@link BzGetBuntanInfo#execBuntanaiteSiteinasi(String, BizDateYM, C_DrtSyouhinSikibetuKbn,
 *                                                         C_Hrkkaisuu, C_DiritenplannmKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetBuntanInfoTest_execBuntanaiteSiteinasi {

    @Inject
    private BzGetBuntanInfo bzGetBuntanInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書_分担情報取得";

    private final static String sheetName = "テストデータ_20181109";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetBuntanInfoTest_execBuntanaiteSiteinasi.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBuntanInfo());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String drtenCd = "";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 0,"分担情報テーブルリスト件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String drtenCd = null;

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 0,"分担情報テーブルリスト件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String drtenCd = "9000001";

        BizDateYM kijyunYm = null;

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 0,"分担情報テーブルリスト件数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String drtenCd = "9000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = null;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 0,"分担情報テーブルリスト件数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String drtenCd = "9000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = null;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 0,"分担情報テーブルリスト件数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String drtenCd = "9000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = null;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 0,"分担情報テーブルリスト件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String drtenCd = "9000002";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 1,"分担情報テーブルリスト件数");

        exStringEquals(buntanInfoLst.get(0).getDrtencd(), "9000002", "代理店コード");
        exStringEquals(buntanInfoLst.get(0).getDairitensyouhincd(), "64200", "代理店商品コード");
        exStringEquals(buntanInfoLst.get(0).getTesuuryoubuntandrtencd(), "A000001", "手数料分担相手代理店コード");
        exDateYMEquals(buntanInfoLst.get(0).getTesuuryoubuntanstartym(), BizDateYM.valueOf(201601), "手数料分担開始年月");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String drtenCd = "9000002";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 1,"分担情報テーブルリスト件数");

        exStringEquals(buntanInfoLst.get(0).getDrtencd(), "9000002", "代理店コード");
        exStringEquals(buntanInfoLst.get(0).getDairitensyouhincd(), "64200", "代理店商品コード");
        exStringEquals(buntanInfoLst.get(0).getTesuuryoubuntandrtencd(), "A000001", "手数料分担相手代理店コード");
        exDateYMEquals(buntanInfoLst.get(0).getTesuuryoubuntanstartym(), BizDateYM.valueOf(201601), "手数料分担開始年月");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String drtenCd = "9000002";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 1,"分担情報テーブルリスト件数");

        exStringEquals(buntanInfoLst.get(0).getDrtencd(), "9000002", "代理店コード");
        exStringEquals(buntanInfoLst.get(0).getDairitensyouhincd(), "64200", "代理店商品コード");
        exStringEquals(buntanInfoLst.get(0).getTesuuryoubuntandrtencd(), "A000001", "手数料分担相手代理店コード");
        exDateYMEquals(buntanInfoLst.get(0).getTesuuryoubuntanstartym(), BizDateYM.valueOf(201601), "手数料分担開始年月");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String drtenCd = "9000002";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 1,"分担情報テーブルリスト件数");

        exStringEquals(buntanInfoLst.get(0).getDrtencd(), "9000002", "代理店コード");
        exStringEquals(buntanInfoLst.get(0).getDairitensyouhincd(), "64100", "代理店商品コード");
        exStringEquals(buntanInfoLst.get(0).getTesuuryoubuntandrtencd(), "A000002", "手数料分担相手代理店コード");
        exDateYMEquals(buntanInfoLst.get(0).getTesuuryoubuntanstartym(), BizDateYM.valueOf(201810), "手数料分担開始年月");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String drtenCd = "9000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 0,"分担情報テーブルリスト件数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        String drtenCd = "9000003";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 0,"分担情報テーブルリスト件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        String drtenCd = "9000001";

        BizDateYM kijyunYm = BizDateYM.valueOf(201811);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(drtenCd, kijyunYm , drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        exNumericEquals(buntanInfoLst.size() , 2,"分担情報テーブルリスト件数");

        exStringEquals(buntanInfoLst.get(0).getDrtencd(), "9000001", "代理店コード");
        exStringEquals(buntanInfoLst.get(0).getDairitensyouhincd(), "64100", "代理店商品コード");
        exStringEquals(buntanInfoLst.get(0).getTesuuryoubuntandrtencd(), "A000001", "手数料分担相手代理店コード");
        exDateYMEquals(buntanInfoLst.get(0).getTesuuryoubuntanstartym(), BizDateYM.valueOf(201809), "手数料分担開始年月");
        exStringEquals(buntanInfoLst.get(1).getDrtencd(), "9000001", "代理店コード");
        exStringEquals(buntanInfoLst.get(1).getDairitensyouhincd(), "64100", "代理店商品コード");
        exStringEquals(buntanInfoLst.get(1).getTesuuryoubuntandrtencd(), "A000002", "手数料分担相手代理店コード");
        exDateYMEquals(buntanInfoLst.get(1).getTesuuryoubuntanstartym(), BizDateYM.valueOf(201810), "手数料分担開始年月");
    }

}
