package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DaisinHiDaisinKbn;
import yuyu.def.classification.C_Diritenbunruicd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;
import yuyu.def.classification.C_TykatukaiyouDrtenHyouji;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 代理店情報取得（代理店コード指定）クラスのメソッド {@link BzGetAgInfo#exec(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetAgInfoTest_exec extends AbstractTest {

    @Inject
    private BzGetAgInfo bzGetAgInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_代理店情報取得（代理店コード指定）";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetAgInfoTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllDairitenSyougou());
        bizDomManager.delete(bizDomManager.getAllAddress());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String drtenCd = "";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String drtenCd = "1025121";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String drtenCd = "1135131";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String drtenCd = "2745141";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");

        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "2745141", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenNm(), "カンジダイリテンメイシイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiDairitenNm(), "漢字代理店名四一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuYmd(), BizDate.valueOf(19920403), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20150102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenTourokuYmd(), BizDate.valueOf(20000102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd1(), "1654842", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd2(), "2654842", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd3(), "3654842", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKeisyousakiDrtenCd(), "", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKsymtDrtenCd(), "1236546", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenTelNo(), "165-5844-22146", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenFaxNo(), "165-5844-22146", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "5100001", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20100102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20300102),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuCd(), "5542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuSitenCd(), "4126", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenJimCd(), "4112", "代理店事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDaiBosyuuCd(), "254262", "代表募集人コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getTkrtkKinyuuknHyouji(),
            C_TkrtkKinyuuknHyouji.TOKUREITIIKI,
            "特例地域金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getKydsskKinyuuknHyouji(),
            C_KydsskKinyuuknHyouji.BLNK,
            "協同組織金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getKydBosyuuDairitenHyouji(),
            C_KydBosyuuDairitenHyouji.KYOUDOUBOSYUU,
            "共同募集代理店表示");
        exStringEquals(bzGetAgInfoBeanList.get(0).getYuuseijimusyoCd(), "415414", "郵政事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getToukatuDairitenCd(), "4642568", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou(), "漢字法人商号四一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenBunruiCd(),
            C_Diritenbunruicd.ZEIRIKOJIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getChannelCd(),
            C_Channelcd.SMBC,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.ZEIRISI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "5100001", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenNm(), "カンジダイリテンメイシニ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiDairitenNm(), "漢字代理店名四二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuYmd(), BizDate.valueOf(19920404), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20150103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenTourokuYmd(), BizDate.valueOf(20000103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd1(), "1654843", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd2(), "2654843", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd3(), "3654843", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKeisyousakiDrtenCd(), "", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKsymtDrtenCd(), "1236547", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenTelNo(), "165-5844-22147", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenFaxNo(), "165-5844-22147", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "5101378", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20100103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20300103),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuCd(), "5543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuSitenCd(), "4127", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenJimCd(), "4113", "代理店事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDaiBosyuuCd(), "254263", "代表募集人コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getTkrtkKinyuuknHyouji(),
            C_TkrtkKinyuuknHyouji.BLNK,
            "特例地域金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getKydsskKinyuuknHyouji(),
            C_KydsskKinyuuknHyouji.BLNK,
            "協同組織金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getKydBosyuuDairitenHyouji(),
            C_KydBosyuuDairitenHyouji.BLNK,
            "共同募集代理店表示");
        exStringEquals(bzGetAgInfoBeanList.get(1).getYuuseijimusyoCd(), "415415", "郵政事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getToukatuDairitenCd(), "4642569", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou(), "漢字法人商号四二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINTOGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getChannelCd(),
            C_Channelcd.MIZUHO,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenCd(), "2745141", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenNm(), "カンジダイリテンメイシイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiDairitenNm(), "漢字代理店名四一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuYmd(), BizDate.valueOf(19920403), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20150102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenTourokuYmd(), BizDate.valueOf(20000102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd1(), "1654842", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd2(), "2654842", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd3(), "3654842", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKeisyousakiDrtenCd(), "", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKsymtDrtenCd(), "1236546", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenTelNo(), "165-5844-22146", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenFaxNo(), "165-5844-22146", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getOyadrtenCd(), "5100001", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20100102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20300102),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuCd(), "5542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuSitenCd(), "4126", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenJimCd(), "4112", "代理店事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDaiBosyuuCd(), "254262", "代表募集人コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getTkrtkKinyuuknHyouji(),
            C_TkrtkKinyuuknHyouji.TOKUREITIIKI,
            "特例地域金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getKydsskKinyuuknHyouji(),
            C_KydsskKinyuuknHyouji.BLNK,
            "協同組織金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getKydBosyuuDairitenHyouji(),
            C_KydBosyuuDairitenHyouji.KYOUDOUBOSYUU,
            "共同募集代理店表示");
        exStringEquals(bzGetAgInfoBeanList.get(2).getYuuseijimusyoCd(), "415414", "郵政事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getToukatuDairitenCd(), "4642568", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiHoujinSyougou(), "漢字法人商号四一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenBunruiCd(),
            C_Diritenbunruicd.ZEIRIKOJIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getChannelCd(),
            C_Channelcd.SMBC,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.ZEIRISI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenCd(), "5100001", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenNm(), "カンジダイリテンメイシニ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiDairitenNm(), "漢字代理店名四二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuYmd(), BizDate.valueOf(19920404), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20150103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenTourokuYmd(), BizDate.valueOf(20000103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd1(), "1654843", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd2(), "2654843", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd3(), "3654843", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKeisyousakiDrtenCd(), "", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKsymtDrtenCd(), "1236547", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenTelNo(), "165-5844-22147", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenFaxNo(), "165-5844-22147", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getOyadrtenCd(), "5101378", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20100103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20300103),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuCd(), "5543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuSitenCd(), "4127", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenJimCd(), "4113", "代理店事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDaiBosyuuCd(), "254263", "代表募集人コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getTkrtkKinyuuknHyouji(),
            C_TkrtkKinyuuknHyouji.BLNK,
            "特例地域金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getKydsskKinyuuknHyouji(),
            C_KydsskKinyuuknHyouji.BLNK,
            "協同組織金融機関表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getKydBosyuuDairitenHyouji(),
            C_KydBosyuuDairitenHyouji.BLNK,
            "共同募集代理店表示");
        exStringEquals(bzGetAgInfoBeanList.get(3).getYuuseijimusyoCd(), "415415", "郵政事務所コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getToukatuDairitenCd(), "4642569", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiHoujinSyougou(), "漢字法人商号四二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINTOGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getChannelCd(),
            C_Channelcd.MIZUHO,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String drtenCd = "5455151";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String drtenCd = "5765161";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String drtenCd = "7175171";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");

        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "7175171", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenNm(), "カンジダイリテンメイシチイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiDairitenNm(), "漢字代理店名七一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuYmd(), BizDate.valueOf(19961206), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160101), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenTourokuYmd(), BizDate.valueOf(20010101), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd1(), "1412441", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd2(), "2412441", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd3(), "3412441", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKeisyousakiDrtenCd(), "3000330", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKsymtDrtenCd(), "6658451", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenTelNo(), "658-5412-56985", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenFaxNo(), "658-5412-56985", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "5100002", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150101), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350101),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuCd(), "6541", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuSitenCd(), "6624", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenJimCd(), "7111", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(0).getToukatuDairitenCd(), "5676721", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou(), "漢字法人商号七一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenBunruiCd(),
            C_Diritenbunruicd.YUUSEIKANPO,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getChannelCd(),
            C_Channelcd.SMTB,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.YUUSEI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "5100002", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenNm(), "カンジダイリテンメイシチニ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiDairitenNm(), "漢字代理店名七二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuYmd(), BizDate.valueOf(19961207), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenTourokuYmd(), BizDate.valueOf(20010102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd1(), "1412442", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd2(), "2412442", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd3(), "3412442", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKeisyousakiDrtenCd(), "1027771", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKsymtDrtenCd(), "6658452", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenTelNo(), "658-5412-56986", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenFaxNo(), "658-5412-56986", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "3000330", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350102),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuCd(), "6542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuSitenCd(), "6625", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenJimCd(), "7112", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(1).getToukatuDairitenCd(), "5676722", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou(), "漢字法人商号七二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINTOGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getChannelCd(),
            C_Channelcd.TIGIN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenCd(), "3000330", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenNm(), "カンジダイリテンメイカンジダイリカンジダイリテンメイカシイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiDairitenNm(), "漢字代理店名漢字代理店名漢字代理店名漢字代理漢字代理店名七三", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuYmd(), BizDate.valueOf(19961208), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenTourokuYmd(), BizDate.valueOf(20010103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd1(), "1412443", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd2(), "2412443", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd3(), "3412443", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKeisyousakiDrtenCd(), "1027773", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKsymtDrtenCd(), "6658453", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenTelNo(), "658-5412-56987", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenFaxNo(), "658-5412-56987", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getOyadrtenCd(), "3000896", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350103),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuCd(), "6543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuSitenCd(), "6626", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenJimCd(), "7113", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(2).getToukatuDairitenCd(), "5676723", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiHoujinSyougou(), "漢字法人商号漢字法人商号漢字法人商号漢字法人商号漢字法人商号漢字法人商号漢字七三",
            "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenBunruiCd(),
            C_Diritenbunruicd.SENDAI,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.SENGYOUDAI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenCd(), "3000896", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenNm(), "カンジダイリテンメイシチシ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiDairitenNm(), "漢字代理店名七四", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuYmd(), BizDate.valueOf(19961209), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160104), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenTourokuYmd(), BizDate.valueOf(20010104), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd1(), "1412444", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd2(), "2412444", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd3(), "3412444", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKeisyousakiDrtenCd(), "1027774", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKsymtDrtenCd(), "6658454", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenTelNo(), "658-5412-56988", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenFaxNo(), "658-5412-56988", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getOyadrtenCd(), "7175175", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150104), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350104),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuCd(), "6544", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuSitenCd(), "6627", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenJimCd(), "7114", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(3).getToukatuDairitenCd(), "5676724", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiHoujinSyougou(), "漢字法人商号七四", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenBunruiCd(),
            C_Diritenbunruicd.SENDAI,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.SENGYOUDAI,
            "代理店チャネル種類");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String drtenCd = null;

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String drtenCd = "7135191";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String drtenCd = "0065111";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 0, "代理店情報出力Beanリスト件数");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String drtenCd = "5401101";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");

        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "5401101", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenNm(), "カンジダイリテンメイシチイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiDairitenNm(), "漢字代理店名七一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuYmd(), BizDate.valueOf(19961206), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160101), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenTourokuYmd(), BizDate.valueOf(20010101), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd1(), "1412441", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd2(), "2412441", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd3(), "3412441", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKeisyousakiDrtenCd(), "7201101", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKsymtDrtenCd(), "6658451", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenTelNo(), "658-5412-56985", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenFaxNo(), "658-5412-56985", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "5101101", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150101), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350101),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuCd(), "6541", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuSitenCd(), "6624", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenJimCd(), "7111", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(0).getToukatuDairitenCd(), "5676721", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou(), "漢字法人商号七一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINSINKIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getChannelCd(),
            C_Channelcd.SINKIN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "5101101", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenNm(), "カンジダイリテンメイシチニ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiDairitenNm(), "漢字代理店名七二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuYmd(), BizDate.valueOf(19961207), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenTourokuYmd(), BizDate.valueOf(20010102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd1(), "1412442", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd2(), "2412442", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd3(), "3412442", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKeisyousakiDrtenCd(), "1027771", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKsymtDrtenCd(), "6658452", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenTelNo(), "658-5412-56986", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenFaxNo(), "658-5412-56986", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "7201101", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350102),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuCd(), "6542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuSitenCd(), "6625", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenJimCd(), "7112", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(1).getToukatuDairitenCd(), "5676722", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou(), "漢字法人商号七二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINTOGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getChannelCd(),
            C_Channelcd.TIGIN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenCd(), "7201101", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenNm(), "カンジダイリテンメイ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiDairitenNm(), "漢字代理店名七三", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuYmd(), BizDate.valueOf(19961208), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenTourokuYmd(), BizDate.valueOf(20010103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd1(), "1412443", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd2(), "2412443", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd3(), "3412443", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKeisyousakiDrtenCd(), "1027773", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKsymtDrtenCd(), "6658453", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenTelNo(), "658-5412-56987", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenFaxNo(), "658-5412-56987", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getOyadrtenCd(), "7301101", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350103),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuCd(), "6543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuSitenCd(), "6626", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenJimCd(), "7113", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(2).getToukatuDairitenCd(), "5676723", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiHoujinSyougou(), "漢字法人商号七三", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenBunruiCd(),
            C_Diritenbunruicd.YUUSEIYUUCYO,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getChannelCd(),
            C_Channelcd.YUUSEIGINKOU,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.YUUSEI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenCd(), "7301101", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenNm(), "カンジダイリテンメイシチシ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiDairitenNm(), "漢字代理店名七四", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuYmd(), BizDate.valueOf(19961209), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160104), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenTourokuYmd(), BizDate.valueOf(20010104), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd1(), "1412444", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd2(), "2412444", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd3(), "3412444", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKeisyousakiDrtenCd(), "1027774", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKsymtDrtenCd(), "6658454", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenTelNo(), "658-5412-56988", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenFaxNo(), "658-5412-56988", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getOyadrtenCd(), "7401101", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150104), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350104),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuCd(), "6544", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuSitenCd(), "6627", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenJimCd(), "7114", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(3).getToukatuDairitenCd(), "5676724", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiHoujinSyougou(), "漢字法人商号七四", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenBunruiCd(),
            C_Diritenbunruicd.YUUSEIYUUBIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getChannelCd(),
            C_Channelcd.YUUSEIKAISYA,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.YUUSEI,
            "代理店チャネル種類");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        String drtenCd = "7401201";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");

        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "7401201", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenNm(), "カンジダイリテンメイシチイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiDairitenNm(), "漢字代理店名七一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuYmd(), BizDate.valueOf(19961206), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160101), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenTourokuYmd(), BizDate.valueOf(20010101), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd1(), "1412441", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd2(), "2412441", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd3(), "3412441", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKeisyousakiDrtenCd(), "2101201", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKsymtDrtenCd(), "6658451", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenTelNo(), "658-5412-56985", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenFaxNo(), "658-5412-56985", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "1101201", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150101), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350101),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuCd(), "6541", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuSitenCd(), "6624", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenJimCd(), "7111", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(0).getToukatuDairitenCd(), "5676721", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou(), "漢字法人商号七一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenBunruiCd(),
            C_Diritenbunruicd.YUUSEIKANI,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getChannelCd(),
            C_Channelcd.YUUSEIKANI,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.YUUSEI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "1101201", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenNm(), "カンジダイリテンメイシチニ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiDairitenNm(), "漢字代理店名七二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuYmd(), BizDate.valueOf(19961207), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenTourokuYmd(), BizDate.valueOf(20010102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd1(), "1412442", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd2(), "2412442", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd3(), "3412442", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKeisyousakiDrtenCd(), "1027771", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKsymtDrtenCd(), "6658452", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenTelNo(), "658-5412-56986", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenFaxNo(), "658-5412-56986", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "2101201", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350102),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuCd(), "6542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuSitenCd(), "6625", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenJimCd(), "7112", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(1).getToukatuDairitenCd(), "5676722", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou(), "漢字法人商号七二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINDAITOGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINKOUKEIDAI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenCd(), "2101201", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenNm(), "カンジダイリテンメイ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiDairitenNm(), "漢字代理店名七三", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuYmd(), BizDate.valueOf(19961208), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenTourokuYmd(), BizDate.valueOf(20010103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd1(), "1412443", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd2(), "2412443", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd3(), "3412443", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKeisyousakiDrtenCd(), "1027773", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKsymtDrtenCd(), "6658453", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenTelNo(), "658-5412-56987", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenFaxNo(), "658-5412-56987", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getOyadrtenCd(), "4001201", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350103),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuCd(), "6543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuSitenCd(), "6626", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenJimCd(), "7113", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(2).getToukatuDairitenCd(), "5676723", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiHoujinSyougou(), "漢字法人商号七三", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenBunruiCd(),
            C_Diritenbunruicd.SYOUKEN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.SYOUKENGAISYA,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenCd(), "4001201", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenNm(), "カンジダイリテンメイシチシ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiDairitenNm(), "漢字代理店名七四", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuYmd(), BizDate.valueOf(19961209), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160104), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenTourokuYmd(), BizDate.valueOf(20010104), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd1(), "1412444", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd2(), "2412444", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd3(), "3412444", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKeisyousakiDrtenCd(), "1027774", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKsymtDrtenCd(), "6658454", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenTelNo(), "658-5412-56988", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenFaxNo(), "658-5412-56988", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getOyadrtenCd(), "4001202", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150104), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350104),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuCd(), "6544", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuSitenCd(), "6627", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenJimCd(), "7114", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(3).getToukatuDairitenCd(), "5676724", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiHoujinSyougou(), "漢字法人商号七四", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenBunruiCd(),
            C_Diritenbunruicd.KIGYODAI,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.KIGYOUDAI,
            "代理店チャネル種類");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        String drtenCd = "9901301";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");

        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "9901301", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenNm(), "カンジダイリテンメイシチイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiDairitenNm(), "漢字代理店名七一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuYmd(), BizDate.valueOf(19961206), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160101), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenTourokuYmd(), BizDate.valueOf(20010101), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd1(), "1412441", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd2(), "2412441", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd3(), "3412441", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKeisyousakiDrtenCd(), "5301301", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKsymtDrtenCd(), "6658451", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenTelNo(), "658-5412-56985", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenFaxNo(), "658-5412-56985", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "5201301", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150101), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350101),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuCd(), "6541", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuSitenCd(), "6624", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenJimCd(), "7111", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(0).getToukatuDairitenCd(), "5676721", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou(), "漢字法人商号七一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenBunruiCd(),
            C_Diritenbunruicd.BROKER,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.BROKER,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "5201301", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenNm(), "カンジダイリテンメイシチニ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiDairitenNm(), "漢字代理店名七二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuYmd(), BizDate.valueOf(19961207), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenTourokuYmd(), BizDate.valueOf(20010102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd1(), "1412442", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd2(), "2412442", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd3(), "3412442", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKeisyousakiDrtenCd(), "1027771", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKsymtDrtenCd(), "6658452", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenTelNo(), "658-5412-56986", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenFaxNo(), "658-5412-56986", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "5301301", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350102),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuCd(), "6542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuSitenCd(), "6625", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenJimCd(), "7112", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(1).getToukatuDairitenCd(), "5676722", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou(), "漢字法人商号七二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenBunruiCd(),
            C_Diritenbunruicd.GIN1CHIGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getChannelCd(),
            C_Channelcd.TIGIN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenCd(), "5301301", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenNm(), "カンジダイリテンメイ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiDairitenNm(), "漢字代理店名七三", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuYmd(), BizDate.valueOf(19961208), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenTourokuYmd(), BizDate.valueOf(20010103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd1(), "1412443", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd2(), "2412443", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd3(), "3412443", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKeisyousakiDrtenCd(), "1027773", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKsymtDrtenCd(), "6658453", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenTelNo(), "658-5412-56987", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenFaxNo(), "658-5412-56987", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getOyadrtenCd(), "5501301", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350103),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuCd(), "6543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuSitenCd(), "6626", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenJimCd(), "7113", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(2).getToukatuDairitenCd(), "5676723", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiHoujinSyougou(), "漢字法人商号七三", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenBunruiCd(),
            C_Diritenbunruicd.GIN2CHIGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getChannelCd(),
            C_Channelcd.TIGIN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenCd(), "5501301", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenNm(), "カンジダイリテンメイシチシ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiDairitenNm(), "漢字代理店名七四", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuYmd(), BizDate.valueOf(19961209), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160104), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenTourokuYmd(), BizDate.valueOf(20010104), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd1(), "1412444", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd2(), "2412444", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd3(), "3412444", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKeisyousakiDrtenCd(), "1027774", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKsymtDrtenCd(), "6658454", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenTelNo(), "658-5412-56988", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenFaxNo(), "658-5412-56988", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getOyadrtenCd(), "5501302", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150104), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350104),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuCd(), "6544", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuSitenCd(), "6627", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenJimCd(), "7114", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(3).getToukatuDairitenCd(), "5676724", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiHoujinSyougou(), "漢字法人商号七四", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINCYOUSIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getChannelCd(),
            C_Channelcd.TIGIN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        String drtenCd = "5601401";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");

        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "5601401", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenNm(), "カンジダイリテンメイシチイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiDairitenNm(), "漢字代理店名七一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuYmd(), BizDate.valueOf(19961206), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160101), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenTourokuYmd(), BizDate.valueOf(20010101), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd1(), "1412441", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd2(), "2412441", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd3(), "3412441", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKeisyousakiDrtenCd(), "1201401", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKsymtDrtenCd(), "6658451", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenTelNo(), "658-5412-56985", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenFaxNo(), "658-5412-56985", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "5701401", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150101), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350101),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuCd(), "6541", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuSitenCd(), "6624", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenJimCd(), "7111", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(0).getToukatuDairitenCd(), "5676721", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou(), "漢字法人商号七一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINSINKUMI,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getChannelCd(),
            C_Channelcd.TIGIN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "5701401", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenNm(), "カンジダイリテンメイシチニ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiDairitenNm(), "漢字代理店名七二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuYmd(), BizDate.valueOf(19961207), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenTourokuYmd(), BizDate.valueOf(20010102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd1(), "1412442", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd2(), "2412442", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd3(), "3412442", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKeisyousakiDrtenCd(), "1027771", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKsymtDrtenCd(), "6658452", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenTelNo(), "658-5412-56986", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenFaxNo(), "658-5412-56986", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "1201401", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350102),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuCd(), "6542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuSitenCd(), "6625", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenJimCd(), "7112", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(1).getToukatuDairitenCd(), "5676722", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou(), "漢字法人商号七二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINDIRECT,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getChannelCd(),
            C_Channelcd.TIGIN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINHONTAIMADO,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenCd(), "1201401", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenNm(), "カンジダイリテンメイ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiDairitenNm(), "漢字代理店名七三", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuYmd(), BizDate.valueOf(19961208), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenTourokuYmd(), BizDate.valueOf(20010103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd1(), "1412443", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd2(), "2412443", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd3(), "3412443", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKeisyousakiDrtenCd(), "1027773", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKsymtDrtenCd(), "6658453", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenTelNo(), "658-5412-56987", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenFaxNo(), "658-5412-56987", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getOyadrtenCd(), "1301401", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350103),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuCd(), "6543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuSitenCd(), "6626", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenJimCd(), "7113", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(2).getToukatuDairitenCd(), "5676723", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiHoujinSyougou(), "漢字法人商号七三", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINDAI1CHIGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINKOUKEIDAI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenCd(), "1301401", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenNm(), "カンジダイリテンメイシチシ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiDairitenNm(), "漢字代理店名七四", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuYmd(), BizDate.valueOf(19961209), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160104), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenTourokuYmd(), BizDate.valueOf(20010104), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd1(), "1412444", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd2(), "2412444", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd3(), "3412444", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKeisyousakiDrtenCd(), "1027774", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKsymtDrtenCd(), "6658454", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenTelNo(), "658-5412-56988", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenFaxNo(), "658-5412-56988", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getOyadrtenCd(), "1301402", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150104), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350104),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuCd(), "6544", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuSitenCd(), "6627", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenJimCd(), "7114", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(3).getToukatuDairitenCd(), "5676724", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiHoujinSyougou(), "漢字法人商号七四", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINDAI2CHIGIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINKOUKEIDAI,
            "代理店チャネル種類");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        String drtenCd = "1401501";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");

        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "1401501", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenNm(), "カンジダイリテンメイシチイチ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiDairitenNm(), "漢字代理店名七一", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuYmd(), BizDate.valueOf(19961206), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(0).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160101), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenTourokuYmd(), BizDate.valueOf(20010101), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd1(), "1412441", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd2(), "2412441", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtKanrisosikiCd3(), "3412441", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKeisyousakiDrtenCd(), "1601501", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKsymtDrtenCd(), "6658451", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenTelNo(), "658-5412-56985", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDairitenFaxNo(), "658-5412-56985", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "1501501", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150101), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(0).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350101),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuCd(), "6541", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKinyuuSitenCd(), "6624", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenJimCd(), "7111", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(0).getToukatuDairitenCd(), "5676721", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getKanjiHoujinSyougou(), "漢字法人商号七一", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINDAISINKIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINKOUKEIDAI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "1501501", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenNm(), "カンジダイリテンメイシチニ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiDairitenNm(), "漢字代理店名七二", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuYmd(), BizDate.valueOf(19961207), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(1).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160102), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenTourokuYmd(), BizDate.valueOf(20010102), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd1(), "1412442", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd2(), "2412442", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtKanrisosikiCd3(), "3412442", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKeisyousakiDrtenCd(), "1027771", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKsymtDrtenCd(), "6658452", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenTelNo(), "658-5412-56986", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDairitenFaxNo(), "658-5412-56986", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "1601501", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150102), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(1).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350102),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuCd(), "6542", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKinyuuSitenCd(), "6625", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenJimCd(), "7112", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(1).getToukatuDairitenCd(), "5676722", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou(), "漢字法人商号七二", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINDAIETC,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINKOUKEIDAI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenCd(), "1601501", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenNm(), "カンジダイリテンメイ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiDairitenNm(), "漢字代理店名七三", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuYmd(), BizDate.valueOf(19961208), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(2).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160103), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenTourokuYmd(), BizDate.valueOf(20010103), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.HIDAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd1(), "1412443", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd2(), "2412443", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtKanrisosikiCd3(), "3412443", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKeisyousakiDrtenCd(), "1027773", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKsymtDrtenCd(), "6658453", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenTelNo(), "658-5412-56987", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDairitenFaxNo(), "658-5412-56987", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(2).getOyadrtenCd(), "2801501", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150103), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(2).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350103),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuCd(), "6543", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKinyuuSitenCd(), "6626", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getDrtenJimCd(), "7113", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(2).getToukatuDairitenCd(), "5676723", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(2).getKanjiHoujinSyougou(), "漢字法人商号七三", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDiritenBunruiCd(),
            C_Diritenbunruicd.GINDAISINKUMI,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(2).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.GINKOUKEIDAI,
            "代理店チャネル種類");

        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.KEISYOUOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenCd(), "2801501", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenNm(), "カンジダイリテンメイシチシ", "代理店名");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiDairitenNm(), "漢字代理店名七四", "漢字代理店名");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuYmd(), BizDate.valueOf(19961209), "委託契約年月");
        exDateEquals(bzGetAgInfoBeanList.get(3).getItakukeiyakuKaiyakuYmd(), BizDate.valueOf(20160104), "委託契約解約年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenTourokuYmd(), BizDate.valueOf(20010104), "代理店登録年月日");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDaisinHidaisinKbn(), C_DaisinHiDaisinKbn.DAISIN,
            "代申非代申区分");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd1(), "1412444", "管理組織コード（１）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd2(), "2412444", "管理組織コード（２）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtKanrisosikiCd3(), "3412444", "管理組織コード（３）");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKeisyousakiDrtenCd(), "", "継承先代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKsymtDrtenCd(), "6658454", "継承元代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenTelNo(), "658-5412-56988", "代理店電話番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDairitenFaxNo(), "658-5412-56988", "代理店ＦＡＸ番号");
        exStringEquals(bzGetAgInfoBeanList.get(3).getOyadrtenCd(), "2801502", "親代理店コード");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuKaisiYmd(), BizDate.valueOf(20150104), "代理店効力開始年月日");
        exDateEquals(bzGetAgInfoBeanList.get(3).getDairitenKouryokuSyuuryouYmd(), BizDate.valueOf(20350104),
            "代理店効力終了年月日");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuCd(), "6544", "金融機関コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKinyuuSitenCd(), "6627", "金融機関支店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getDrtenJimCd(), "7114", "代理店事務所コード");
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
        exStringEquals(bzGetAgInfoBeanList.get(3).getToukatuDairitenCd(), "5676724", "統括代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(3).getKanjiHoujinSyougou(), "漢字法人商号七四", "漢字法人商号");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDiritenBunruiCd(),
            C_Diritenbunruicd.ZEIRIHOUJIN,
            "代理店分類コード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN,
            "チャネルコード");
        exClassificationEquals(bzGetAgInfoBeanList.get(3).getDrtenChannelSyurui(),
            C_DrtenChannelSyurui.ZEIRISI,
            "代理店チャネル種類");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        String drtenCd = "2101601";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);
        List<TesuuryouInfoBean> tesuuryouInfoBeanLst = new ArrayList<>();

        exNumericEquals(bzGetAgInfoBeanList.size(), 4, "代理店情報出力Beanリスト件数");

        exClassificationEquals(bzGetAgInfoBeanList.get(0).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIKO,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtenCd(), "2101601", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getOyadrtenCd(), "1501601", "親代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(0).getDrtentrkno(), "1234567891011", "代理店登録番号");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getMdhnSchemeDrtenHyouji(),
            C_MdhnSchemeDrtenHyouji.BLNK, "窓販スキーム代理店表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getTykatukaiyouDrtenHyouji(),
            C_TykatukaiyouDrtenHyouji.BLNK, "直扱用代理店表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(0).getChannelCd(),
            C_Channelcd.SONOTAMADOHAN, "チャネルコード");
        exNumericEquals(bzGetAgInfoBeanList.get(0).getHnsituHykrankTougetu(), 11, "品質評価ランク（当月）");
        exNumericEquals(bzGetAgInfoBeanList.get(0).getHnsituHykrankYokugetu(), 12, "品質評価ランク（翌月）");

        tesuuryouInfoBeanLst = bzGetAgInfoBeanList.get(0).getTesuuryouInfoBeanLst();
        exStringEquals(tesuuryouInfoBeanLst.get(0).getDrtenSyouhncdKami3(), "000", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(0).getTsryshrkbnTougetu(), "1", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(0).getTsryshrkbnYokugetu(), "2", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(0).getBntnptnKbn(), "3", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(1).getDrtenSyouhncdKami3(), "001", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(1).getTsryshrkbnTougetu(), "4", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(1).getTsryshrkbnYokugetu(), "5", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(1).getBntnptnKbn(), "6", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(2).getDrtenSyouhncdKami3(), "002", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(2).getTsryshrkbnTougetu(), "7", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(2).getTsryshrkbnYokugetu(), "8", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(2).getBntnptnKbn(), "9", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(3).getDrtenSyouhncdKami3(), "003", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(3).getTsryshrkbnTougetu(), "1", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(3).getTsryshrkbnYokugetu(), "2", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(3).getBntnptnKbn(), "3", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(4).getDrtenSyouhncdKami3(), "004", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(4).getTsryshrkbnTougetu(), "4", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(4).getTsryshrkbnYokugetu(), "5", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(4).getBntnptnKbn(), "6", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(5).getDrtenSyouhncdKami3(), "005", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(5).getTsryshrkbnTougetu(), "7", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(5).getTsryshrkbnYokugetu(), "8", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(5).getBntnptnKbn(), "9", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(6).getDrtenSyouhncdKami3(), "006", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(6).getTsryshrkbnTougetu(), "1", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(6).getTsryshrkbnYokugetu(), "2", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(6).getBntnptnKbn(), "3", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(7).getDrtenSyouhncdKami3(), "007", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(7).getTsryshrkbnTougetu(), "4", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(7).getTsryshrkbnYokugetu(), "5", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(7).getBntnptnKbn(), "6", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(8).getDrtenSyouhncdKami3(), "008", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(8).getTsryshrkbnTougetu(), "7", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(8).getTsryshrkbnYokugetu(), "8", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(8).getBntnptnKbn(), "9", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(9).getDrtenSyouhncdKami3(), "009", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(9).getTsryshrkbnTougetu(), "1", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(9).getTsryshrkbnYokugetu(), "2", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(9).getBntnptnKbn(), "3", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(10).getDrtenSyouhncdKami3(), "010", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(10).getTsryshrkbnTougetu(), "4", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(10).getTsryshrkbnYokugetu(), "5", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(10).getBntnptnKbn(), "6", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(11).getDrtenSyouhncdKami3(), "011", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(11).getTsryshrkbnTougetu(), "7", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(11).getTsryshrkbnYokugetu(), "8", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(11).getBntnptnKbn(), "9", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(12).getDrtenSyouhncdKami3(), "012", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(12).getTsryshrkbnTougetu(), "1", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(12).getTsryshrkbnYokugetu(), "2", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(12).getBntnptnKbn(), "3", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(13).getDrtenSyouhncdKami3(), "013", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(13).getTsryshrkbnTougetu(), "4", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(13).getTsryshrkbnYokugetu(), "5", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(13).getBntnptnKbn(), "6", "分担パターン区分");
        exStringEquals(tesuuryouInfoBeanLst.get(14).getDrtenSyouhncdKami3(), "014", "代理店商品コード上3桁");
        exStringEquals(tesuuryouInfoBeanLst.get(14).getTsryshrkbnTougetu(), "7", "手数料支払区分（当月）");
        exStringEquals(tesuuryouInfoBeanLst.get(14).getTsryshrkbnYokugetu(), "8", "手数料支払区分（翌月）");
        exStringEquals(tesuuryouInfoBeanLst.get(14).getBntnptnKbn(), "9", "分担パターン区分");


        exClassificationEquals(bzGetAgInfoBeanList.get(1).getDiritenJyouhouKbn(), C_DiritenjyouhouKbn.SHITEIOYA,
            "代理店情報区分");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtenCd(), "1501601", "代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getOyadrtenCd(), "1601601", "親代理店コード");
        exStringEquals(bzGetAgInfoBeanList.get(1).getDrtentrkno(), "2222222222222", "代理店登録番号");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getMdhnSchemeDrtenHyouji(),
            C_MdhnSchemeDrtenHyouji.MDHNSCHEME, "窓販スキーム代理店表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getTykatukaiyouDrtenHyouji(),
            C_TykatukaiyouDrtenHyouji.TYKATUKAI, "直扱用代理店表示");
        exClassificationEquals(bzGetAgInfoBeanList.get(1).getChannelCd(),
            C_Channelcd.SHOP,
            "チャネルコード");
        exNumericEquals(bzGetAgInfoBeanList.get(1).getHnsituHykrankTougetu(), 21, "品質評価ランク（当月）");
        exNumericEquals(bzGetAgInfoBeanList.get(1).getHnsituHykrankYokugetu(), 22, "品質評価ランク（翌月）");


    }
}
