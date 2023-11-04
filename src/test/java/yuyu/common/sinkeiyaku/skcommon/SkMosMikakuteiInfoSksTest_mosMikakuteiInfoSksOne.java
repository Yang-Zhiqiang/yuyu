package yuyu.common.sinkeiyaku.skcommon;
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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 新契約申込未確定情報作成クラスのメソッド {@link SkMosMikakuteiInfoSks#mosMikakuteiInfoSksOne(SkMosMikakuteiJyouhouKanriSksInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkMosMikakuteiInfoSksTest_mosMikakuteiInfoSksOne extends AbstractTest {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkMosMikakuteiInfoSks skMosMikakuteiInfoSks;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約申込未確定情報作成";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertDate() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkMosMikakuteiInfoSksTest_mosMikakuteiInfoSksOne.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiSyorui());

    }
    @Test
    @Transactional
    @TestOrder(10)
    public void testMosMikakuteiInfoSksOne_A1() {
        SkMosMikakuteiJyouhouKanriSksInBean skMosMikakuteiJyouhouKanriSksInBean = SWAKInjector.getInstance(SkMosMikakuteiJyouhouKanriSksInBean.class);
        skMosMikakuteiJyouhouKanriSksInBean.setMosNo("791112220");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuTetuzukiCd(null);
        skMosMikakuteiJyouhouKanriSksInBean.setSkeijimuKbn(null);
        skMosMikakuteiJyouhouKanriSksInBean.setMosUketukeKbn(null);
        skMosMikakuteiJyouhouKanriSksInBean.setHknsyuruiNo(null);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd1(null);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd2(null);
        skMosMikakuteiJyouhouKanriSksInBean.setJimuyouCd(null);
        skMosMikakuteiJyouhouKanriSksInBean.setDoujiMosUmu(null);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoNo(null);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoriYmd(BizDate.valueOf("20150101"));
        skMosMikakuteiJyouhouKanriSksInBean.setSetMosno1(null);
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinsyaId(null);
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinTime(null);

        skMosMikakuteiJyouhouKanriSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(new ArrayList<SkMosMikakuteiSyoruiSksInBean>());
        skMosMikakuteiInfoSks.mosMikakuteiInfoSksOne(skMosMikakuteiJyouhouKanriSksInBean);
        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("791112220");
        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("791112220");

        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "791112220", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.BLNK, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.BLNK, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd2(), "", "代理店コード２");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimuyoucd(), "", "事務用コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exStringEquals(mosMikakuteiJyouhouKanri.getSyono(), "", "証券番号");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSyorizumiflg(), C_Syorizumiflg.MISYORI, "処理済フラグ");
        exDateEquals(mosMikakuteiJyouhouKanri.getSakujoyoteiymd(), BizDate.valueOf("20150411"), "削除予定日");
        exStringEquals(mosMikakuteiJyouhouKanri.getSetmosno1(), "", "セット申込番号１");
        exStringEquals(mosMikakuteiJyouhouKanri.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiJyouhouKanri.getGyoumuKousinTime(), "", "業務用更新時間");

        exNumericEquals(mosMikakuteiSyoruiLst.size(), 0, "申込未確定書類テーブルリストの件数");
        deleteTestData1();
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testMosMikakuteiInfoSksOne_A2() {
        SkMosMikakuteiJyouhouKanriSksInBean skMosMikakuteiJyouhouKanriSksInBean = SWAKInjector.getInstance(SkMosMikakuteiJyouhouKanriSksInBean.class);
        skMosMikakuteiJyouhouKanriSksInBean.setMosNo("791112238");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuTetuzukiCd("1000000000000000001");
        skMosMikakuteiJyouhouKanriSksInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        skMosMikakuteiJyouhouKanriSksInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skMosMikakuteiJyouhouKanriSksInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd1("1000001");
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd2("1000001");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuyouCd("101");
        skMosMikakuteiJyouhouKanriSksInBean.setDoujiMosUmu(C_UmuKbn.ARI);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoNo("11807111118");
        skMosMikakuteiJyouhouKanriSksInBean.setSyoriYmd(BizDate.valueOf("20150101"));
        skMosMikakuteiJyouhouKanriSksInBean.setSetMosno1("989800008");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinsyaId("user00100000000");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinTime("20150101111000000");

        SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean = new SkMosMikakuteiSyoruiSksInBean();
        ArrayList<SkMosMikakuteiSyoruiSksInBean> skMosMikakuteiSyoruiSksInBeanLst = new ArrayList<>();
        skMosMikakuteiSyoruiSksInBean.setSyoruiCd(C_SyoruiCdKbn.SK_MOSSYO);
        skMosMikakuteiSyoruiSksInBean.setDocumentId("111111111111111111111111");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean);
        skMosMikakuteiJyouhouKanriSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMikakuteiSyoruiSksInBeanLst);
        skMosMikakuteiInfoSks.mosMikakuteiInfoSksOne(skMosMikakuteiJyouhouKanriSksInBean);
        sinkeiyakuDomManager.flush();
        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("791112238");
        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("791112238");

        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "791112238", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "1000000000000000001", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "1000001", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd2(), "1000001", "代理店コード２");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimuyoucd(), "101", "事務用コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exStringEquals(mosMikakuteiJyouhouKanri.getSyono(), "11807111118", "証券番号");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSyorizumiflg(), C_Syorizumiflg.MISYORI, "処理済フラグ");
        exDateEquals(mosMikakuteiJyouhouKanri.getSakujoyoteiymd(), BizDate.valueOf("20150411"), "削除予定日");
        exStringEquals(mosMikakuteiJyouhouKanri.getSetmosno1(), "989800008", "セット申込番号１");
        exStringEquals(mosMikakuteiJyouhouKanri.getGyoumuKousinsyaId(), "user00100000000", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiJyouhouKanri.getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        exNumericEquals(mosMikakuteiSyoruiLst.size(), 1, "申込未確定書類テーブルリストの件数");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getDocumentid(), "111111111111111111111111", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getMosno(), "791112238", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinsyaId(), "user00100000000", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");
        deleteTestData1();

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testMosMikakuteiInfoSksOne_A3() {
        SkMosMikakuteiJyouhouKanriSksInBean skMosMikakuteiJyouhouKanriSksInBean = SWAKInjector.getInstance(SkMosMikakuteiJyouhouKanriSksInBean.class);
        skMosMikakuteiJyouhouKanriSksInBean.setMosNo("791112246");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuTetuzukiCd("1000000000000000001");
        skMosMikakuteiJyouhouKanriSksInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        skMosMikakuteiJyouhouKanriSksInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skMosMikakuteiJyouhouKanriSksInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd1("1000001");
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd2("1000001");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuyouCd("101");
        skMosMikakuteiJyouhouKanriSksInBean.setDoujiMosUmu(C_UmuKbn.ARI);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoNo("11807111118");
        skMosMikakuteiJyouhouKanriSksInBean.setSyoriYmd(BizDate.valueOf("20150101"));
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinsyaId("user001");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinTime("20150101111000000");

        SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean = new SkMosMikakuteiSyoruiSksInBean();
        ArrayList<SkMosMikakuteiSyoruiSksInBean> skMosMikakuteiSyoruiSksInBeanLst = new ArrayList<>();
        skMosMikakuteiSyoruiSksInBean.setSyoruiCd(C_SyoruiCdKbn.SK_MOSSYO);
        skMosMikakuteiSyoruiSksInBean.setDocumentId("111111111111111111111111");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean);
        skMosMikakuteiSyoruiSksInBean = new SkMosMikakuteiSyoruiSksInBean();
        skMosMikakuteiSyoruiSksInBean.setSyoruiCd(C_SyoruiCdKbn.SK_IKOUKAKSYO);
        skMosMikakuteiSyoruiSksInBean.setDocumentId("111111111111111111111112");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean);
        skMosMikakuteiSyoruiSksInBean  = new SkMosMikakuteiSyoruiSksInBean();
        skMosMikakuteiSyoruiSksInBean.setSyoruiCd(C_SyoruiCdKbn.SK_TORIHOUSYO);
        skMosMikakuteiSyoruiSksInBean.setDocumentId("111111111111111111111113");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean);
        skMosMikakuteiJyouhouKanriSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMikakuteiSyoruiSksInBeanLst);
        skMosMikakuteiInfoSks.mosMikakuteiInfoSksOne(skMosMikakuteiJyouhouKanriSksInBean);
        sinkeiyakuDomManager.flush();

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("791112246");
        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getAllMosMikakuteiSyorui();
        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "791112246", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "1000000000000000001", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "1000001", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd2(), "1000001", "代理店コード２");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimuyoucd(), "101", "事務用コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exStringEquals(mosMikakuteiJyouhouKanri.getSyono(), "11807111118", "証券番号");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSyorizumiflg(), C_Syorizumiflg.MISYORI, "処理済フラグ");
        exDateEquals(mosMikakuteiJyouhouKanri.getSakujoyoteiymd(), BizDate.valueOf("20150411"), "削除予定日");
        exStringEquals(mosMikakuteiJyouhouKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiJyouhouKanri.getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        exNumericEquals(mosMikakuteiSyoruiLst.size(), 3, "申込未確定書類テーブルリストの件数");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getDocumentid(), "111111111111111111111111", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getMosno(), "791112246", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        exStringEquals(mosMikakuteiSyoruiLst.get(1).getDocumentid(), "111111111111111111111112", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(1).getMosno(), "791112246", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_IKOUKAKSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(1).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        exStringEquals(mosMikakuteiSyoruiLst.get(2).getDocumentid(), "111111111111111111111113", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(2).getMosno(), "791112246", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_TORIHOUSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(2).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");
        deleteTestData1();
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testMosMikakuteiInfoSksOne_A4() {
        SkMosMikakuteiJyouhouKanriSksInBean skMosMikakuteiJyouhouKanriSksInBean = SWAKInjector.getInstance(SkMosMikakuteiJyouhouKanriSksInBean.class);
        skMosMikakuteiJyouhouKanriSksInBean.setMosNo("791112253");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuTetuzukiCd("1000000000000000001");
        skMosMikakuteiJyouhouKanriSksInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        skMosMikakuteiJyouhouKanriSksInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skMosMikakuteiJyouhouKanriSksInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd1("1000001");
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd2("1000001");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuyouCd("101");
        skMosMikakuteiJyouhouKanriSksInBean.setDoujiMosUmu(C_UmuKbn.ARI);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoNo("11807111118");
        skMosMikakuteiJyouhouKanriSksInBean.setSyoriYmd(BizDate.valueOf("20150101"));
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinsyaId(null);
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinTime(null);

        SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean = new SkMosMikakuteiSyoruiSksInBean();
        ArrayList<SkMosMikakuteiSyoruiSksInBean> skMosMikakuteiSyoruiSksInBeanLst = new ArrayList<>();
        skMosMikakuteiSyoruiSksInBean.setSyoruiCd(null);
        skMosMikakuteiSyoruiSksInBean.setDocumentId("111111111111111111111111");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean);
        skMosMikakuteiJyouhouKanriSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMikakuteiSyoruiSksInBeanLst);
        skMosMikakuteiInfoSks.mosMikakuteiInfoSksOne(skMosMikakuteiJyouhouKanriSksInBean);
        sinkeiyakuDomManager.flush();

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getAllMosMikakuteiSyorui();

        exNumericEquals(mosMikakuteiSyoruiLst.size(), 1, "申込未確定書類テーブルリストの件数");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getDocumentid(), "111111111111111111111111", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getMosno(), "791112253", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.BLNK, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinTime(), "", "業務用更新時間");
    }

    @Transactional
    public static void deleteTestData1() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiSyorui());

    }
}
