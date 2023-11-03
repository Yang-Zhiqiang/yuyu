package yuyu.common.sinkeiyaku.koutei;

import java.util.List;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardKetteiHoryuuHubiBatchクラスのメソッド {@link SkProcessForwardKetteiHoryuuHubiBatch#exec(SkProcessForwardForBatchInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardKetteiHoryuuHubiBatchTest_exec {

    @Inject
    private SkProcessForwardKetteiHoryuuHubiBatch skProcessForwardKetteiHoryuuHubiBatch;

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

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardKetteiHoryuuHubiBatchTest_exec.class;
    }
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
    }
    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123458");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.YOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setLincjkkbn(C_LincjkKbn.SYOUKAIMATI);

        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class1");
        skProcessForwardForBatchInBean.setSyoriComment("処理1");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "890123458", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean1 = bzProcessForwardForBatchInBeanLst.get(0);
        exStringEquals(bzProcessForwardForBatchInBean1.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean1.getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean1.getTaskNm(), "class1", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBean1.getSyoriComment(),
            "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");

        SkMainDairitenRuleBean iwfApiRuleBean1 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean1.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean1.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean1.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean1.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(iwfApiRuleBean1.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(iwfApiRuleBean1.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(iwfApiRuleBean1.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(iwfApiRuleBean1.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean1.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(iwfApiRuleBean1.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "890123458", "申込番号");
        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean2 = bzProcessForwardForBatchInBeanLst.get(1);

        exStringEquals(bzProcessForwardForBatchInBean2.getKouteiKanriId(), "102", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean2.getJimuTetuzukiCd(), "SkTenken", "事務手続コード");

        SkTenkenRuleBean iwfApiRuleBean2 = (SkTenkenRuleBean)bzProcessForwardForBatchInBean2.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean2.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean2.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean2.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(iwfApiRuleBean2.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(iwfApiRuleBean1.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(iwfApiRuleBean2.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "890123458", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean3 = bzProcessForwardForBatchInBeanLst.get(2);

        exStringEquals(bzProcessForwardForBatchInBean3.getKouteiKanriId(), "103", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean3.getJimuTetuzukiCd(), "SkKankyou", "事務手続コード");

        SkKankyouRuleBean iwfApiRuleBean3 = (SkKankyouRuleBean)bzProcessForwardForBatchInBean3.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean3.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean3.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean3.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(iwfApiRuleBean3.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean3.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(iwfApiRuleBean3.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(iwfApiRuleBean3.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "890123458", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean4 = bzProcessForwardForBatchInBeanLst.get(3);

        exStringEquals(bzProcessForwardForBatchInBean4.getKouteiKanriId(), "104", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean4.getJimuTetuzukiCd(), "SkImu", "事務手続コード");

        SkImuRuleBean iwfApiRuleBean4 = (SkImuRuleBean)bzProcessForwardForBatchInBean4.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean4.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean4.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean4.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(iwfApiRuleBean4.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean4.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(iwfApiRuleBean4.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123466");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.YOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setLincjkkbn(C_LincjkKbn.SYOUKAIMATI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class2");
        skProcessForwardForBatchInBean.setSyoriComment("処理2");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean1 = bzProcessForwardForBatchInBeanLst.get(0);
        exStringEquals(bzProcessForwardForBatchInBean1.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean1.getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean1.getTaskNm(), "class2", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBean1.getSyoriComment(),
            "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");

        SkMainDairitenRuleBean iwfApiRuleBean1 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean1.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean1.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean1.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean1.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(iwfApiRuleBean1.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(iwfApiRuleBean1.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(iwfApiRuleBean1.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(iwfApiRuleBean1.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean1.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(iwfApiRuleBean1.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean2 = bzProcessForwardForBatchInBeanLst.get(1);
        exStringEquals(bzProcessForwardForBatchInBean2.getKouteiKanriId(), "102", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean2.getJimuTetuzukiCd(), "SkTenken", "事務手続コード");
        SkTenkenRuleBean iwfApiRuleBean2 = (SkTenkenRuleBean)bzProcessForwardForBatchInBean2.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean2.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean2.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean2.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(iwfApiRuleBean2.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(iwfApiRuleBean1.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(iwfApiRuleBean2.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean3 = bzProcessForwardForBatchInBeanLst.get(2);
        exStringEquals(bzProcessForwardForBatchInBean3.getKouteiKanriId(), "103", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean3.getJimuTetuzukiCd(), "SkKankyou", "事務手続コード");
        SkKankyouRuleBean iwfApiRuleBean3 = (SkKankyouRuleBean)bzProcessForwardForBatchInBean3.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean3.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean3.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean3.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(iwfApiRuleBean3.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean3.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(iwfApiRuleBean3.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(iwfApiRuleBean3.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "890123466", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean4 = bzProcessForwardForBatchInBeanLst.get(3);
        exStringEquals(bzProcessForwardForBatchInBean4.getKouteiKanriId(), "104", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean4.getJimuTetuzukiCd(), "SkImu", "事務手続コード");

        SkImuRuleBean iwfApiRuleBean4 = (SkImuRuleBean)bzProcessForwardForBatchInBean4.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean4.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean4.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean4.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(iwfApiRuleBean4.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean4.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(iwfApiRuleBean4.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123474");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.YOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setLincjkkbn(C_LincjkKbn.SYOUKAIMATI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class3");
        skProcessForwardForBatchInBean.setSyoriComment("処理3");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean1 = bzProcessForwardForBatchInBeanLst.get(0);

        exStringEquals(bzProcessForwardForBatchInBean1.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean1.getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean1.getTaskNm(), "class3", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBean1.getSyoriComment(),
            "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");

        SkMainDairitenRuleBean iwfApiRuleBean1 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean1.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean1.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean1.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean1.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(iwfApiRuleBean1.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(iwfApiRuleBean1.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(iwfApiRuleBean1.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(iwfApiRuleBean1.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean1.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(iwfApiRuleBean1.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean2 = bzProcessForwardForBatchInBeanLst.get(1);
        exStringEquals(bzProcessForwardForBatchInBean2.getKouteiKanriId(), "102", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean2.getJimuTetuzukiCd(), "SkTenken", "事務手続コード");

        SkTenkenRuleBean iwfApiRuleBean2 = (SkTenkenRuleBean)bzProcessForwardForBatchInBean2.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean2.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean2.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean2.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(iwfApiRuleBean2.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(iwfApiRuleBean1.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(iwfApiRuleBean2.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean3 = bzProcessForwardForBatchInBeanLst.get(2);
        exStringEquals(bzProcessForwardForBatchInBean3.getKouteiKanriId(), "103", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean3.getJimuTetuzukiCd(), "SkKankyou", "事務手続コード");

        SkKankyouRuleBean iwfApiRuleBean3 = (SkKankyouRuleBean)bzProcessForwardForBatchInBean3.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean3.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean3.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean3.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(iwfApiRuleBean3.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean3.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(iwfApiRuleBean3.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(iwfApiRuleBean3.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean4 = bzProcessForwardForBatchInBeanLst.get(3);
        exStringEquals(bzProcessForwardForBatchInBean4.getKouteiKanriId(), "104", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean4.getJimuTetuzukiCd(), "SkImu", "事務手続コード");

        SkImuRuleBean iwfApiRuleBean4 = (SkImuRuleBean)bzProcessForwardForBatchInBean4.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean4.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean4.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean4.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(iwfApiRuleBean4.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean4.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(iwfApiRuleBean4.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123482");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setLincjkkbn(C_LincjkKbn.SYOUKAIMATI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class4");
        skProcessForwardForBatchInBean.setSyoriComment("処理4");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean1 = bzProcessForwardForBatchInBeanLst.get(0);
        exStringEquals(bzProcessForwardForBatchInBean1.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean1.getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean1.getTaskNm(), "class4", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBean1.getSyoriComment(),
            "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");

        SkMainDairitenRuleBean iwfApiRuleBean1 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean1.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean1.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean1.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean1.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(iwfApiRuleBean1.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(iwfApiRuleBean1.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(iwfApiRuleBean1.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(iwfApiRuleBean1.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean1.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(iwfApiRuleBean1.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean2 = bzProcessForwardForBatchInBeanLst.get(1);
        exStringEquals(bzProcessForwardForBatchInBean2.getKouteiKanriId(), "102", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean2.getJimuTetuzukiCd(), "SkTenken", "事務手続コード");
        SkTenkenRuleBean iwfApiRuleBean2 = (SkTenkenRuleBean)bzProcessForwardForBatchInBean2.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean2.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean2.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean2.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(iwfApiRuleBean2.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(iwfApiRuleBean1.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(iwfApiRuleBean2.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean3 = bzProcessForwardForBatchInBeanLst.get(2);
        exStringEquals(bzProcessForwardForBatchInBean3.getKouteiKanriId(), "103", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean3.getJimuTetuzukiCd(), "SkKankyou", "事務手続コード");
        SkKankyouRuleBean iwfApiRuleBean3 = (SkKankyouRuleBean)bzProcessForwardForBatchInBean3.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean3.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean3.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean3.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(iwfApiRuleBean3.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean3.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(iwfApiRuleBean3.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(iwfApiRuleBean3.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean4 = bzProcessForwardForBatchInBeanLst.get(3);

        exStringEquals(bzProcessForwardForBatchInBean4.getKouteiKanriId(), "104", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean4.getJimuTetuzukiCd(), "SkImu", "事務手続コード");

        SkImuRuleBean iwfApiRuleBean4 = (SkImuRuleBean)bzProcessForwardForBatchInBean4.getIwfApiRuleBean();
        exStringEquals(iwfApiRuleBean4.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(iwfApiRuleBean4.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(iwfApiRuleBean4.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(iwfApiRuleBean4.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(iwfApiRuleBean4.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(iwfApiRuleBean4.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123490");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class5");
        skProcessForwardForBatchInBean.setSyoriComment("処理5");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "890123490", "申込番号");

        exNumericEquals(bzProcessForwardForBatchInBeanLst.size(), 0, "WK．業務共通工程遷移（バッチ用）入力Beanリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123508");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class6");
        skProcessForwardForBatchInBean.setSyoriComment("処理6");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "890123508", "申込番号");

        exNumericEquals(bzProcessForwardForBatchInBeanLst.size(), 0, "WK．業務共通工程遷移（バッチ用）入力Beanリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123516");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class7");
        skProcessForwardForBatchInBean.setSyoriComment("処理7");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "890123516", "申込番号");

        exNumericEquals(bzProcessForwardForBatchInBeanLst.size(), 0, "WK．業務共通工程遷移（バッチ用）入力Beanリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123524");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class8");
        skProcessForwardForBatchInBean.setSyoriComment("処理8");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "890123524", "申込番号");

        exNumericEquals(bzProcessForwardForBatchInBeanLst.size(), 0, "WK．業務共通工程遷移（バッチ用）入力Beanリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN6;
        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL();
        syoriCTL1.setMosno("890123524");
        syoriCTL1.setMostenken1jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken2jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setMostenken3jiyhkbn(C_MostenkenyhKbn.HUYOU);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
        syoriCTL1.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL1.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL1.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSntkhoukbn(C_SntkhouKbn.KKT);
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);
        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("class8");
        skProcessForwardForBatchInBean.setSyoriComment("処理8");
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst =
            skProcessForwardKetteiHoryuuHubiBatch.exec(skProcessForwardForBatchInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "890123524", "申込番号");

        exNumericEquals(bzProcessForwardForBatchInBeanLst.size(), 0, "WK．業務共通工程遷移（バッチ用）入力Beanリストのサイズ");
    }
}
