package yuyu.common.biz.bzdairiten;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_HanbaiJyoukyouKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 代理店委託商品情報取得クラスのメソッド {@link BzGetDairitenItakuSyouhn#exec(String, C_DrtSyouhinSikibetuKbn, String, String, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetDairitenItakuSyouhnTest_exec extends AbstractTest {

    @Inject
    private BzGetDairitenItakuSyouhn bzGetDairitenItakuSyouhn;

    private final static String fileName = "UT_SP_単体テスト仕様書_代理店委託商品情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetDairitenItakuSyouhnTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairitenItakuSyouhn());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String drtenCd = "";
        String hrkhouhoukbn = "1";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20190801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), null, "販売状況区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String drtenCd = null;
        String hrkhouhoukbn = "1";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20190801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), null, "販売状況区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String drtenCd = "A001";
        C_DrtSyouhinSikibetuKbn syouhinSikibetuKbn = null;
        String hrkhouhoukbn = "1";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20190801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            syouhinSikibetuKbn, hrkhouhoukbn, plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), null, "販売状況区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String drtenCd = "A001";
        String hrkhouhoukbn = "";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20190801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), null, "販売状況区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String drtenCd = "A001";
        String hrkhouhoukbn = null;
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20190801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), null, "販売状況区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String drtenCd = "A001";
        String hrkhouhoukbn = "1";
        String plannmkbn = "";
        BizDate kijyunymd = BizDate.valueOf("20190801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), null, "販売状況区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String drtenCd = "A001";
        String hrkhouhoukbn = "1";
        String plannmkbn = null;
        BizDate kijyunymd = BizDate.valueOf("20190801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), null, "販売状況区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String drtenCd = "A001";
        String hrkhouhoukbn = "1";
        String plannmkbn = "11";
        BizDate kijyunymd = null;

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), null, "販売状況区分");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String drtenCd = "A010";
        String hrkhouhoukbn = "1";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20200801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), null, "代理店コード");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn(), null, "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), null, "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), null, "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), null, "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), C_HanbaiJyoukyouKbn.TORIATUKAINASI, "販売状況区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String drtenCd = "A003";
        String hrkhouhoukbn = "1";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20200801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), "A003", "代理店コード");
        exStringEquals(String.valueOf(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn()), "64", "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), "1", "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), "11", "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), BizDate.valueOf("20190801"), "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), null, "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), C_HanbaiJyoukyouKbn.HANBAITYUU, "販売状況区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String drtenCd = "A005";
        String hrkhouhoukbn = "2";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20200803");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI19, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), "A005", "代理店コード");
        exStringEquals(String.valueOf(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn()), "65", "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), "2", "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), "11", "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), BizDate.valueOf("20200804"), "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), BizDate.valueOf("20200805"), "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(), C_HanbaiJyoukyouKbn.HANBAIKAISIMAE, "販売状況区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        String drtenCd = "A006";
        String hrkhouhoukbn = "2";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20200801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI19, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), "A006", "代理店コード");
        exStringEquals(String.valueOf(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn()), "65", "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), "2", "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), "11", "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), BizDate.valueOf("20200731"), "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), BizDate.valueOf("20200802"), "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(),C_HanbaiJyoukyouKbn.HANBAITYUU, "販売状況区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        String drtenCd = "A007";
        String hrkhouhoukbn = "2";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20200801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI19, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), "A007", "代理店コード");
        exStringEquals(String.valueOf(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn()), "65", "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), "2", "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), "11", "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), BizDate.valueOf("20200801"), "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), BizDate.valueOf("20200802"), "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(),C_HanbaiJyoukyouKbn.HANBAITYUU, "販売状況区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        String drtenCd = "A008";
        String hrkhouhoukbn = "2";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20220801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI19, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), "A008", "代理店コード");
        exStringEquals(String.valueOf(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn()), "65", "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), "2", "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), "11", "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), BizDate.valueOf("20220731"), "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), BizDate.valueOf("20220801"), "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(),C_HanbaiJyoukyouKbn.HANBAITYUU, "販売状況区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        String drtenCd = "A009";
        String hrkhouhoukbn = "2";
        String plannmkbn = "11";
        BizDate kijyunymd = BizDate.valueOf("20200801");

        BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(drtenCd,
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI19, hrkhouhoukbn,
            plannmkbn, kijyunymd);

        exStringEquals(bzGetDairitenItakuSyouhnBean.getDairitenCd(), "A009", "代理店コード");
        exStringEquals(String.valueOf(bzGetDairitenItakuSyouhnBean.getDrtsyouhinsikibetuKbn()), "65", "代理店商品識別区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrthrkhouhouKbn(), "2", "代理店払込方法区分");
        exStringEquals(bzGetDairitenItakuSyouhnBean.getDrtplannmKbn(), "11", "代理店プラン名区分");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbkaisiYmd(), BizDate.valueOf("20200730"), "委託保険販売開始年月日");
        exDateEquals(bzGetDairitenItakuSyouhnBean.getItakuhknhnbsyuuryouYmd(), BizDate.valueOf("20200731"), "委託保険販売終了年月日");
        exClassificationEquals(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn(),C_HanbaiJyoukyouKbn.HANBAIKYUUSI, "販売状況区分");
    }

}
