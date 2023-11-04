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
 * 募集人情報取得（募集人コード指定）クラスのメソッド {@link BzGetBsInfo#exec(String)}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class BzGetBsInfoTest_exec extends AbstractTest {

    @Inject
    private BzGetBsInfo bzGetBsInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_募集人情報取得（募集人コード指定）";

    private final static String sheetName = "テストデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetBsInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap,true);
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

        String bosyuuCd = "";

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);

        exBooleanEquals(bzGetBsInfoBean == null, true, "募集人情報出力Bean");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String bosyuuCd = "100102";

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);

        exBooleanEquals(bzGetBsInfoBean == null, true, "募集人情報出力Bean");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String bosyuuCd = "100103";

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);

        exStringEquals(bzGetBsInfoBean.getBosyuuCd(), "100103", "募集人コード");
        exStringEquals(bzGetBsInfoBean.getBosyuuNm(), "クロサキユイミあああああああああああああ", "募集人名");
        exStringEquals(bzGetBsInfoBean.getKanjiBosyuuninNm(), "黑咲唯三えええええええええええ", "漢字募集人名");
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
        exStringEquals(bzGetBsInfoBean.getKouinCd(), "", "行員コード");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String bosyuuCd = null;

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);

        exBooleanEquals(bzGetBsInfoBean == null, true, "募集人情報出力Bean");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String bosyuuCd = "100105";

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);

        exStringEquals(bzGetBsInfoBean.getBosyuuCd(), "100105", "募集人コード");
        exStringEquals(bzGetBsInfoBean.getBosyuuNm(), "グロサキユイシ", "募集人名");
        exStringEquals(bzGetBsInfoBean.getKanjiBosyuuninNm(), "黑咲唯四", "漢字募集人名");
        exDateEquals(bzGetBsInfoBean.getItakuYmd(), BizDate.valueOf(20011125), "委託年月日");
        exStringEquals(bzGetBsInfoBean.getDairiten1Cd(), "1234567", "代理店コード（１）");
        exStringEquals(bzGetBsInfoBean.getDairiten2Cd(), "1256874", "代理店コード（２）");
        exStringEquals(bzGetBsInfoBean.getDairiten3Cd(), "5246849", "代理店コード（３）");
        exStringEquals(bzGetBsInfoBean.getDairitenKanriSosikiCd1(), "1568745", "代理店管理組織コード（１）");
        exStringEquals(bzGetBsInfoBean.getDairitenKanriSosikiCd2(), "2315489", "代理店管理組織コード（２）");
        exStringEquals(bzGetBsInfoBean.getDairitenKanriSosikiCd3(), "1100110", "代理店管理組織コード（３）");
        exClassificationEquals(bzGetBsInfoBean.getBosyuuKbn(), C_BosyuuKbn.SYOKITI, "募集人区分");
        exDateEquals(bzGetBsInfoBean.getBosyuuninTourokuYmd(), BizDate.valueOf(20010102), "募集人登録年月日");
        exClassificationEquals(bzGetBsInfoBean.getBosyuuKahiKbn(), C_BsKahiKbn.BLNK, "募集可否区分");
        exDateEquals(bzGetBsInfoBean.getBosyuuninGyouhaiYmd(), BizDate.valueOf(20151201), "募集人業廃年月日");
        exDateEquals(bzGetBsInfoBean.getHngkHknSkkTrkYmd(), BizDate.valueOf(20200101), "変額保険資格登録年月日");
        exDateEquals(bzGetBsInfoBean.getHngkHknSkkTrkMsuYmd(), BizDate.valueOf(20200101), "変額保険資格登録抹消年月日");
        exDateEquals(bzGetBsInfoBean.getBosyuuSeiYmd(), BizDate.valueOf(19950101), "募集人生年月日");
        exDateEquals(bzGetBsInfoBean.getItakuKaiyakuYmd(), BizDate.valueOf(20200101), "委託解約年月日");
        exStringEquals(bzGetBsInfoBean.getDaiBosyuuCd(), "156294", "代表募集人コード");
        exStringEquals(bzGetBsInfoBean.getBosyuuTrkNo(), "1001001001004", "募集人登録番号");
        exStringEquals(bzGetBsInfoBean.getKouinCd(), "84300050102311111050", "行員コード");
    }
}
