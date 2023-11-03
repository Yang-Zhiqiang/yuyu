package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

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
import yuyu.def.classification.C_DaisinHiDaisinKbn;
import yuyu.def.classification.C_Diritenbunruicd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 代理店情報取得（金融機関指定）クラスのメソッド {@link BzGetAgInfoKinyuuKikan#exec(String,String)}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class BzGetAgInfoKinyuuKikanTest_exec extends AbstractTest {

    @Inject
    private BzGetAgInfoKinyuuKikan bzGetAgInfoKinyuuKikan;

    private final static String fileName = "UT_SP_単体テスト仕様書_代理店情報取得（金融機関指定）";

    private final static String sheetName = "テストデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetAgInfoKinyuuKikanTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllDairitenSyougou());
        bizDomManager.delete(bizDomManager.getAllAddress());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {


        String kinyuuCd = "";


        String kinyuusitenCd = "2010";


        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfoKinyuuKikan.exec(kinyuuCd, kinyuusitenCd);


        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {


        String kinyuuCd = "2220";


        String kinyuusitenCd = "";


        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfoKinyuuKikan.exec(kinyuuCd, kinyuusitenCd);


        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {


        String kinyuuCd = "4440";


        String kinyuusitenCd = "4010";


        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfoKinyuuKikan.exec(kinyuuCd, kinyuusitenCd);


        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {


        String kinyuuCd = "5550";


        String kinyuusitenCd = "5010";


        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfoKinyuuKikan.exec(kinyuuCd, kinyuusitenCd);


        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");


        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
                "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "5155151", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenNm(), "カンジダイリテンメイゴイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiDairitenNm(), "漢字代理店名五一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuYmd(), BizDate.valueOf(19961206), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160101), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenTourokuYmd(), BizDate.valueOf(20010101), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN, "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd1(), "1412441", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd2(), "2412441", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd3(), "3412441", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKeisyousakiDrtenCd(), "5155153", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKsymtDrtenCd(), "6658451", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenTelNo(), "658-5412-56985", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenFaxNo(), "658-5412-56985", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "5155152", "金融機関コード");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150101), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuSyuuryouYmd(), null,
                "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuCd(), "5550", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuSitenCd(), "5111", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenJimCd(), "5010", "代理店事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDaiBosyuuCd(), "352121", "代表募集人コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getTkrtkKinyuuknHyouji(),
                C_TkrtkKinyuuknHyouji.TOKUREITIIKI,
                "特例地域金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getKydsskKinyuuknHyouji(),
                C_KydsskKinyuuknHyouji.KYOUDOUSOSIKI,
                "協同組織金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getKydBosyuuDairitenHyouji(),
                C_KydBosyuuDairitenHyouji.KYOUDOUBOSYUU,
                "共同募集代理店表示");
        exStringEquals(bzGetAgInfoBeanList.get(0).getYuuseijimusyoCd(), "211231", "郵政事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getToukatuDairitenCd(), "5656521", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou(), "漢字法人商号五一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenBunruiCd(),
                C_Diritenbunruicd.GINTOGIN,
                "代理店分類コード");


        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
                "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "5155152", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenNm(), "カンジダイリテンメイゴブタ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiDairitenNm(), "漢字代理店名五二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuYmd(), BizDate.valueOf(19961205), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenTourokuYmd(), BizDate.valueOf(20010102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
                "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd1(), "1412442", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd2(), "2412442", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd3(), "3412442", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKeisyousakiDrtenCd(), "1025551", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKsymtDrtenCd(), "6658452", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenTelNo(), "658-5412-56986", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenFaxNo(), "658-5412-56986", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "5155153", "金融機関コード");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuSyuuryouYmd(), null,
                "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuCd(), "6542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuSitenCd(), "6625", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenJimCd(), "5112", "代理店事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDaiBosyuuCd(), "352122", "代表募集人コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getTkrtkKinyuuknHyouji(),
                C_TkrtkKinyuuknHyouji.BLNK,
                "特例地域金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getKydsskKinyuuknHyouji(),
                C_KydsskKinyuuknHyouji.BLNK,
                "協同組織金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getKydBosyuuDairitenHyouji(),
                C_KydBosyuuDairitenHyouji.BLNK,
                "共同募集代理店表示");
        exStringEquals(bzGetAgInfoBeanList.get(1).getYuuseijimusyoCd(), "211232", "郵政事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getToukatuDairitenCd(), "5656522", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou(), "漢字法人商号五二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenBunruiCd(),
                C_Diritenbunruicd.GINTOGIN,
                "代理店分類コード");


        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUKO,
                "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenCd(), "5155153", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenNm(), "カンジダイリテンメイゴミ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiDairitenNm(), "漢字代理店名五三", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuYmd(), BizDate.valueOf(19961208), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenTourokuYmd(), BizDate.valueOf(20010103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
                "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd1(), "1412443", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd2(), "2412443", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd3(), "3412443", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKeisyousakiDrtenCd(), "1025553", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKsymtDrtenCd(), "6658453", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenTelNo(), "658-5412-56985", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenFaxNo(), "658-5412-56985", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getOyadrtenCd(), "5155154", "金融機関コード");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuSyuuryouYmd(), null,
                "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuCd(), "6543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuSitenCd(), "6626", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenJimCd(), "5113", "代理店事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDaiBosyuuCd(), "352123", "代表募集人コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getTkrtkKinyuuknHyouji(),
                C_TkrtkKinyuuknHyouji.BLNK,
                "特例地域金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getKydsskKinyuuknHyouji(),
                C_KydsskKinyuuknHyouji.KYOUDOUSOSIKI,
                "協同組織金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getKydBosyuuDairitenHyouji(),
                C_KydBosyuuDairitenHyouji.KYOUDOUBOSYUU,
                "共同募集代理店表示");
        exStringEquals(bzGetAgInfoBeanList.get(2).getYuuseijimusyoCd(), "211233", "郵政事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getToukatuDairitenCd(), "5656523", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiHoujinSyougou(), "漢字法人商号五三", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenBunruiCd(),
                C_Diritenbunruicd.GINTOGIN,
                "代理店分類コード");


        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUOYA,
                "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenCd(), "5155154", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenNm(), "カンジダイリテンメイゴヨツ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiDairitenNm(), "漢字代理店名五四", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuYmd(), BizDate.valueOf(19961209), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160104), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenTourokuYmd(), BizDate.valueOf(20010104), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
                "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd1(), "1412444", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd2(), "2412444", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd3(), "3412444", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKeisyousakiDrtenCd(), "1025554", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKsymtDrtenCd(), "6658454", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenTelNo(), "658-5412-56988", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenFaxNo(), "658-5412-56988", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getOyadrtenCd(), "5155155", "金融機関コード");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150104), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuSyuuryouYmd(), null,
                "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuCd(), "6544", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuSitenCd(), "6625", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenJimCd(), "5114", "代理店事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDaiBosyuuCd(), "352124", "代表募集人コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getTkrtkKinyuuknHyouji(),
                C_TkrtkKinyuuknHyouji.BLNK,
                "特例地域金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getKydsskKinyuuknHyouji(),
                C_KydsskKinyuuknHyouji.BLNK,
                "協同組織金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getKydBosyuuDairitenHyouji(),
                C_KydBosyuuDairitenHyouji.KYOUDOUBOSYUU,
                "共同募集代理店表示");
        exStringEquals(bzGetAgInfoBeanList.get(3).getYuuseijimusyoCd(), "211234", "郵政事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getToukatuDairitenCd(), "5656524", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiHoujinSyougou(), "漢字法人商号五四", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenBunruiCd(),
                C_Diritenbunruicd.GINTOGIN,
                "代理店分類コード");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {


        String kinyuuCd = null;


        String kinyuusitenCd = "2010";


        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfoKinyuuKikan.exec(kinyuuCd, kinyuusitenCd);


        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {


        String kinyuuCd = "2220";


        String kinyuusitenCd = null;


        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfoKinyuuKikan.exec(kinyuuCd, kinyuusitenCd);


        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }
}
