package yuyu.common.sinkeiyaku.koutei;

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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.TuikaParamForBatchInputBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessUpdateクラスのメソッド {@link SkProcessUpdate#editProcessUpdateForBatchInfo(HT_SyoriCTL, HT_MosKihon, List<HT_MosDairiten>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessUpdateTest_editProcessUpdateForBatchInfo {

    @Inject
    private SkProcessUpdate skProcessUpdate;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約工程情報更新";

    private final static String sheetName = "INデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit() {
        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessUpdateTest_editProcessUpdateForBatchInfo.class;

    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessUpdateTest_editProcessUpdateForBatchInfo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test
    @TestOrder(10)
    public void testEditProcessUpdateForBatchInfo_A1() {
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
            skProcessUpdate.editProcessUpdateForBatchInfo(syoriCTL, mosKihon, mosDairitenLst);

        exNumericEquals(bzProcessUpdateForBatchInputBeanList.size(), 0, "件数");

    }

    @Test
    @TestOrder(20)
    public void testEditProcessUpdateForBatchInfo_A2() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
            skProcessUpdate.editProcessUpdateForBatchInfo(syoriCTL, mosKihon, mosDairitenLst);

        exNumericEquals(bzProcessUpdateForBatchInputBeanList.size(), 1, "件数");

        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(0).getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(0).getKouteiKanriId(), "5201", "工程管理ID");
        exClassificationEquals(bzProcessUpdateForBatchInputBeanList.get(0).getKokouteiUpdumu(), C_UmuKbn.ARI, "子工程更新有無区分");

        TuikaParamForBatchInputBean TuikaParamForBatchInputBean = bzProcessUpdateForBatchInputBeanList.get(0).getTuikaParamForBatchInputBean();

        exClassificationEquals(TuikaParamForBatchInputBean.getSkeijimukbn(), C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals(TuikaParamForBatchInputBean.getMosuketukekbn(), C_MosUketukeKbn.SIRYOUSEIKYUU, "申込受付区分");
        exClassificationEquals(TuikaParamForBatchInputBean.getHknsyuruiNo(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, "保険種類番号");
        exStringEquals(TuikaParamForBatchInputBean.getDairitencd1(), "5101001", "代理店コード１");
        exStringEquals(TuikaParamForBatchInputBean.getDairitencd2(), null, "代理店コード２");
        exStringEquals(TuikaParamForBatchInputBean.getJimuyoucd(), "102", "事務用コード");
        exClassificationEquals(TuikaParamForBatchInputBean.getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exDateEquals(TuikaParamForBatchInputBean.getMosymd(), BizDate.valueOf(20160813), "申込日");
        exStringEquals(TuikaParamForBatchInputBean.getJimustartymd(), null, "事務開始日");
        exStringEquals(TuikaParamForBatchInputBean.getSyono(), "17810000027", "証券番号");
        exStringEquals(TuikaParamForBatchInputBean.getNksysyno(), null, "年金証書番号");
        exStringEquals(TuikaParamForBatchInputBean.getMosno(), "791112238", "申込番号");
        exClassificationEquals(TuikaParamForBatchInputBean.getKetteiKbn(), C_KetteiKbn.KETTEI_MATI, "決定状態区分");
        exClassificationEquals(TuikaParamForBatchInputBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI, "成立区分");
        exClassificationEquals(TuikaParamForBatchInputBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI, "ＬＩＮＣ状況区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "791112238", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skhenkin", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "791112238", "申込番号");

    }

    @Test
    @TestOrder(30)
    public void testEditProcessUpdateForBatchInfo_A3() {

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
            skProcessUpdate.editProcessUpdateForBatchInfo(syoriCTL, mosKihon, mosDairitenLst);

        exNumericEquals(bzProcessUpdateForBatchInputBeanList.size(), 2, "件数");

        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(0).getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(0).getKouteiKanriId(), "5301", "工程管理ID");
        exClassificationEquals(bzProcessUpdateForBatchInputBeanList.get(0).getKokouteiUpdumu(), C_UmuKbn.ARI, "子工程更新有無区分");

        TuikaParamForBatchInputBean TuikaParamForBatchInputBean1 = bzProcessUpdateForBatchInputBeanList.get(0).getTuikaParamForBatchInputBean();
        exClassificationEquals(TuikaParamForBatchInputBean1.getSkeijimukbn(), C_SkeijimuKbn.SMTB, "新契約事務区分");
        exClassificationEquals(TuikaParamForBatchInputBean1.getMosuketukekbn(), C_MosUketukeKbn.PAPERLESS, "申込受付区分");
        exClassificationEquals(TuikaParamForBatchInputBean1.getHknsyuruiNo(), C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, "保険種類番号");
        exStringEquals(TuikaParamForBatchInputBean1.getDairitencd1(), "5102001", "代理店コード１");
        exStringEquals(TuikaParamForBatchInputBean1.getDairitencd2(), "5102002", "代理店コード２");
        exStringEquals(TuikaParamForBatchInputBean1.getJimuyoucd(), "103", "事務用コード");
        exClassificationEquals(TuikaParamForBatchInputBean1.getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exDateEquals(TuikaParamForBatchInputBean1.getMosymd(), BizDate.valueOf(20160814), "申込日");
        exStringEquals(TuikaParamForBatchInputBean1.getJimustartymd(), null, "事務開始日");
        exStringEquals(TuikaParamForBatchInputBean1.getSyono(), "17810000038", "証券番号");
        exStringEquals(TuikaParamForBatchInputBean1.getNksysyno(), null, "年金証書番号");
        exStringEquals(TuikaParamForBatchInputBean1.getMosno(), "791112246", "申込番号");
        exClassificationEquals(TuikaParamForBatchInputBean1.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");
        exClassificationEquals(TuikaParamForBatchInputBean1.getSeirituKbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exClassificationEquals(TuikaParamForBatchInputBean1.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");

        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(1).getJimuTetuzukiCd(), "skhenkin", "事務手続コード");
        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(1).getKouteiKanriId(), "5302", "工程管理ID");
        exClassificationEquals(bzProcessUpdateForBatchInputBeanList.get(1).getKokouteiUpdumu(), C_UmuKbn.ARI, "子工程更新有無区分");

        TuikaParamForBatchInputBean TuikaParamForBatchInputBean2 = bzProcessUpdateForBatchInputBeanList.get(1).getTuikaParamForBatchInputBean();
        exClassificationEquals(TuikaParamForBatchInputBean2.getSkeijimukbn(), C_SkeijimuKbn.SMTB, "新契約事務区分");
        exClassificationEquals(TuikaParamForBatchInputBean2.getMosuketukekbn(), C_MosUketukeKbn.PAPERLESS, "申込受付区分");
        exClassificationEquals(TuikaParamForBatchInputBean2.getHknsyuruiNo(), C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, "保険種類番号");
        exStringEquals(TuikaParamForBatchInputBean2.getDairitencd1(), "5102001", "代理店コード１");
        exStringEquals(TuikaParamForBatchInputBean2.getDairitencd2(), "5102002", "代理店コード２");
        exStringEquals(TuikaParamForBatchInputBean2.getJimuyoucd(), "103", "事務用コード");
        exClassificationEquals(TuikaParamForBatchInputBean2.getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exDateEquals(TuikaParamForBatchInputBean2.getMosymd(), BizDate.valueOf(20160814), "申込日");
        exStringEquals(TuikaParamForBatchInputBean2.getJimustartymd(), null, "事務開始日");
        exStringEquals(TuikaParamForBatchInputBean2.getSyono(), "17810000038", "証券番号");
        exStringEquals(TuikaParamForBatchInputBean2.getNksysyno(), null, "年金証書番号");
        exStringEquals(TuikaParamForBatchInputBean2.getMosno(), "791112246", "申込番号");
        exClassificationEquals(TuikaParamForBatchInputBean2.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");
        exClassificationEquals(TuikaParamForBatchInputBean2.getSeirituKbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exClassificationEquals(TuikaParamForBatchInputBean2.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");

    }
}
