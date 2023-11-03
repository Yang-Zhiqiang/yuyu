package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BosyuuKbn;
import yuyu.def.classification.C_BsKahiKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 募集人情報取得（募集人登録番号指定）クラスのメソッド {@link BzGetBsInfoBstrkno#exec(String)}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class BzGetBsInfoBstrknoTest_exec extends AbstractTest {

    @Inject
    private BzGetBsInfoBstrkno bzGetBsInfoBstrkno;

    private final static String fileName = "UT_SP_単体テスト仕様書_募集人情報取得（募集人登録番号指定）";

    private final static String sheetName = "テストデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetBsInfoBstrknoTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllBosyuunin());
        bizDomManager.delete(bizDomManager.getAllKouin());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String bosyuutrkno = "";

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfoBstrkno.exec(bosyuutrkno);

        exBooleanEquals(bzGetBsInfoBean == null, true, "募集人情報出力Bean");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String bosyuutrkno = "1001001001001";

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfoBstrkno.exec(bosyuutrkno);

        exBooleanEquals(bzGetBsInfoBean == null, true, "募集人情報出力Bean");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String bosyuutrkno = "1001001001003";

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfoBstrkno.exec(bosyuutrkno);

        exStringEquals(bzGetBsInfoBean.getBosyuuCd(), "100103", "募集人コード");
        exStringEquals(bzGetBsInfoBean.getBosyuuNm(), "クロサキユイミ", "募集人名");
        exStringEquals(bzGetBsInfoBean.getKanjiBosyuuninNm(), "黑咲唯三", "漢字募集人名");
        exDateEquals(bzGetBsInfoBean.getItakuYmd(), BizDate.valueOf(20120226), "委託年月日");
        exStringEquals(bzGetBsInfoBean.getDairiten1Cd(), "0215486", "代理店コード（１）");
        exStringEquals(bzGetBsInfoBean.getDairiten2Cd(), "0236584", "代理店コード（２）");
        exStringEquals(bzGetBsInfoBean.getDairiten3Cd(), "6548122", "代理店コード（３）");
        exStringEquals(bzGetBsInfoBean.getDairitenKanriSosikiCd1(), "2648954", "代理店管理組織コード（１）");
        exStringEquals(bzGetBsInfoBean.getDairitenKanriSosikiCd2(), "9841561", "代理店管理組織コード（２）");
        exStringEquals(bzGetBsInfoBean.getDairitenKanriSosikiCd3(), "2233550", "代理店管理組織コード（３）");
        exClassificationEquals(bzGetBsInfoBean.getBosyuuKbn(), C_BosyuuKbn.HJNDAIHYOU, "募集人区分");
        exDateEquals(bzGetBsInfoBean.getBosyuuninTourokuYmd(), BizDate.valueOf(20150326), "募集人登録年月日");
        exClassificationEquals(bzGetBsInfoBean.getBosyuuKahiKbn(), C_BsKahiKbn.BOSYUUKA, "募集可否区分");
        exDateEquals(bzGetBsInfoBean.getBosyuuninGyouhaiYmd(), BizDate.valueOf(20151201), "募集人業廃年月日");
        exDateEquals(bzGetBsInfoBean.getHngkHknSkkTrkYmd(), BizDate.valueOf(20210101), "変額保険資格登録年月日");
        exDateEquals(bzGetBsInfoBean.getHngkHknSkkTrkMsuYmd(), BizDate.valueOf(20210101), "変額保険資格登録抹消年月日");
        exDateEquals(bzGetBsInfoBean.getBosyuuSeiYmd(), BizDate.valueOf(19930321), "募集人生年月日");
        exDateEquals(bzGetBsInfoBean.getItakuKaiyakuYmd(), BizDate.valueOf(20210101), "委託解約年月日");
        exStringEquals(bzGetBsInfoBean.getDaiBosyuuCd(), "551883", "代表募集人コード");
        exStringEquals(bzGetBsInfoBean.getBosyuuTrkNo(), "1001001001003", "募集人登録番号");
        exStringEquals(bzGetBsInfoBean.getKouinCd(), "84300050102311111030", "行員コード");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String bosyuutrkno = null;

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfoBstrkno.exec(bosyuutrkno);

        exBooleanEquals(bzGetBsInfoBean == null, true, "募集人情報出力Bean");
    }
}
