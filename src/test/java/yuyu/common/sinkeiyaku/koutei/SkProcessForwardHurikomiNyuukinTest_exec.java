package yuyu.common.sinkeiyaku.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzProcessForwardForBatch;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.biz.koutei.BzProcessForwardForBatchMockForSinkeiyaku;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardHurikomiNyuukinクラスのメソッド {@link SkProcessForwardHurikomiNyuukin#exec(List<SkProcessForwardForBatchInBean>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardHurikomiNyuukinTest_exec {

    @Inject
    private SkProcessForwardHurikomiNyuukin skProcessForwardHurikomiNyuukin;

    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（振込入金処理）";

    private final static String sheetName = "テストデータ";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForwardForBatch.class).to(BzProcessForwardForBatchMockForSinkeiyaku.class);
                bind(SkProcessForwardMoschkExecBatch.class).to(SkProcessForwardMoschkExecBatchMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardHurikomiNyuukinTest_exec.class;
        BzProcessForwardForBatchMockForSinkeiyaku.caller = SkProcessForwardHurikomiNyuukinTest_exec.class;
        SkProcessForwardMoschkExecBatchMockForSinkeiyaku.caller = SkProcessForwardHurikomiNyuukinTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessForwardForBatchMockForSinkeiyaku.caller = null;
        BzProcessForwardForBatchMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardMoschkExecBatchMockForSinkeiyaku.caller = null;
        SkProcessForwardMoschkExecBatchMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardHurikomiNyuukinTest_exec.class, fileName, sheetName);
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
    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardForBatchMockForSinkeiyaku.SYORIPTN = BzProcessForwardForBatchMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecBatchMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecBatchMockForSinkeiyaku.TESTPATTERN1;

        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanlst = new ArrayList<>();

        skProcessForwardHurikomiNyuukin.exec(skProcessForwardForBatchInBeanlst);

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst = (List<BzProcessForwardForBatchInBean>)MockObjectManager.getArgument(BzProcessForwardForBatchMockForSinkeiyaku.class, "exec", 0, 0);
        exNumericEquals(bzProcessForwardForBatchInBeanLst.size(), 0, "業務共通工程遷移（バッチ用）入力Beanリストのサイズ");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardForBatchMockForSinkeiyaku.SYORIPTN = BzProcessForwardForBatchMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecBatchMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecBatchMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("870000015");

        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanlst = new ArrayList<>();
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("sinkeiyakuBatch11");
        skProcessForwardForBatchInBean.setSyoriComment("振込入金処理11");

        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean);

        skProcessForwardHurikomiNyuukin.exec(skProcessForwardForBatchInBeanlst);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "870000015", "申込番号");

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst = (List<BzProcessForwardForBatchInBean>)MockObjectManager.getArgument(BzProcessForwardForBatchMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(0).getKouteiKanriId(), "kouteikanri1", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(0).getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(0).getTaskNm(), "sinkeiyakuBatch11", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(0).getSyoriComment(), "振込入金処理11", "処理コメント");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBeanLst.get(0).getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), "あり", "成立保留不備区分");

    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardForBatchMockForSinkeiyaku.SYORIPTN = BzProcessForwardForBatchMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecBatchMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecBatchMockForSinkeiyaku.TESTPATTERN2;

        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanlst = new ArrayList<>();

        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean1 = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("870000023");
        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("870000031");
        HT_SyoriCTL syoriCTL3 = sinkeiyakuDomManager.getSyoriCTL("870000049");

        skProcessForwardForBatchInBean1.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean1.setTskNm("sinkeiyakuBatch21");
        skProcessForwardForBatchInBean1.setSyoriComment("振込入金処理21");
        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean1);

        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean2 = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        skProcessForwardForBatchInBean2.setHtSyoriCTL(syoriCTL2);
        skProcessForwardForBatchInBean2.setTskNm("sinkeiyakuBatch22");
        skProcessForwardForBatchInBean2.setSyoriComment("振込入金処理22");
        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean2);

        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean3 = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        skProcessForwardForBatchInBean3.setHtSyoriCTL(syoriCTL3);
        skProcessForwardForBatchInBean3.setTskNm("sinkeiyakuBatch23");
        skProcessForwardForBatchInBean3.setSyoriComment("振込入金処理23");
        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean3);

        skProcessForwardHurikomiNyuukin.exec(skProcessForwardForBatchInBeanlst);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "870000023", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "870000031", "申込番号");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "870000049", "申込番号");


        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean11 = (SkProcessForwardForBatchInBean)MockObjectManager.getArgument(SkProcessForwardMoschkExecBatchMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getMosno(), "870000023", "申込番号");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getMosKihon().getSntkhoukbn(), C_SntkhouKbn.KKT, "申込基本テーブル．選択方法区分");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getKktnrkumu(), C_UmuKbn.ARI, "告知書入力有無");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getKktnrkvrfjkkbn(), C_VrfjkKbn.NIJINRKMATI, "告知書入力ベリファイ状況区分");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_1, "申込点検状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getSateijtkbn(), C_SateijtKbn.SATEI_SUMI, "査定状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean11.getHtSyoriCTL().getKthhbkbn(), C_UmuKbn.ARI, "決定保留不備区分");
        exStringEquals(skProcessForwardForBatchInBean11.getTskNm(), "sinkeiyakuBatch21", "タスク名");
        exStringEquals(skProcessForwardForBatchInBean11.getSyoriComment(), "振込入金処理21", "処理コメント");

        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean12 = (SkProcessForwardForBatchInBean)MockObjectManager.getArgument(SkProcessForwardMoschkExecBatchMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getMosno(), "870000031", "申込番号");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getMosKihon().getSntkhoukbn(), C_SntkhouKbn.KKT, "申込基本テーブル．選択方法区分");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getKktnrkumu(), C_UmuKbn.ARI, "告知書入力有無");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getKktnrkvrfjkkbn(), C_VrfjkKbn.NIJINRKMATI, "告知書入力ベリファイ状況区分");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_1, "申込点検状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getSateijtkbn(), C_SateijtKbn.SATEI_SUMI, "査定状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean12.getHtSyoriCTL().getKthhbkbn(), C_UmuKbn.NONE, "決定保留不備区分");
        exStringEquals(skProcessForwardForBatchInBean12.getTskNm(), "sinkeiyakuBatch22", "タスク名");
        exStringEquals(skProcessForwardForBatchInBean12.getSyoriComment(), "振込入金処理22", "処理コメント");

        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean13 = (SkProcessForwardForBatchInBean)MockObjectManager.getArgument(SkProcessForwardMoschkExecBatchMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getMosno(), "870000049", "申込番号");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getMosKihon().getSntkhoukbn(), C_SntkhouKbn.KKT, "申込基本テーブル．選択方法区分");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getKktnrkumu(), C_UmuKbn.ARI, "告知書入力有無");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getKktnrkvrfjkkbn(), C_VrfjkKbn.NIJINRKMATI, "告知書入力ベリファイ状況区分");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_1, "申込点検状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getSateijtkbn(), C_SateijtKbn.SATEI_SUMI, "査定状態区分");
        exClassificationEquals(skProcessForwardForBatchInBean13.getHtSyoriCTL().getKthhbkbn(), C_UmuKbn.NONE, "決定保留不備区分");
        exStringEquals(skProcessForwardForBatchInBean13.getTskNm(), "sinkeiyakuBatch23", "タスク名");
        exStringEquals(skProcessForwardForBatchInBean13.getSyoriComment(), "振込入金処理23", "処理コメント");


        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst = (List<BzProcessForwardForBatchInBean>)MockObjectManager.getArgument(BzProcessForwardForBatchMockForSinkeiyaku.class, "exec", 0, 0);
        exNumericEquals(bzProcessForwardForBatchInBeanLst.size(), 7, "業務共通工程遷移（バッチ用）入力Beanリストのサイズ");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(0).getKouteiKanriId(), "kouteikanri2", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(0).getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(0).getTaskNm(), "sinkeiyakuBatch21", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(0).getSyoriComment(), "振込入金処理21", "処理コメント");
        SkMainDairitenRuleBean skMainDairitenRuleBean1 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBeanLst.get(0).getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean1.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean1.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean1.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean1.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean1.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean1.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean1.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean1.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean1.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean1.getSrhhbKbn(), "なし", "成立保留不備区分");

        exStringEquals(bzProcessForwardForBatchInBeanLst.get(1).getKouteiKanriId(), "kouteikanri3", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(1).getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(1).getTaskNm(), "sinkeiyakuBatch21", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(1).getSyoriComment(), "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");
        SkMainDairitenRuleBean skMainDairitenRuleBean2 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBeanLst.get(1).getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean2.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean2.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean2.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean2.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean2.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean2.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean2.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean2.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean2.getSateijtKbn(), "査定済", "査定状態区分");

        exStringEquals(bzProcessForwardForBatchInBeanLst.get(2).getKouteiKanriId(), "kouteikanri4", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(2).getJimuTetuzukiCd(), "SkTenken", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(2).getTaskNm(), null, "タスク名");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(2).getSyoriComment(), null, "処理コメント");
        SkTenkenRuleBean SkTenkenRuleBean3 = (SkTenkenRuleBean)bzProcessForwardForBatchInBeanLst.get(2).getIwfApiRuleBean();
        exStringEquals(SkTenkenRuleBean3.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(SkTenkenRuleBean3.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(SkTenkenRuleBean3.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(SkTenkenRuleBean3.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(SkTenkenRuleBean3.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(SkTenkenRuleBean3.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(SkTenkenRuleBean3.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");

        exStringEquals(bzProcessForwardForBatchInBeanLst.get(3).getKouteiKanriId(), "kouteikanri5", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(3).getJimuTetuzukiCd(), "SkKankyou", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(3).getTaskNm(), null, "タスク名");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(3).getSyoriComment(), null, "処理コメント");
        SkKankyouRuleBean SkKankyouRuleBean4 = (SkKankyouRuleBean)bzProcessForwardForBatchInBeanLst.get(3).getIwfApiRuleBean();
        exStringEquals(SkKankyouRuleBean4.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(SkKankyouRuleBean4.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(SkKankyouRuleBean4.getMostenkenyhKbn(), "実施不要", "申込点検要否区分");
        exStringEquals(SkKankyouRuleBean4.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(SkKankyouRuleBean4.getKnkysateijyouKbn(), null, "環境査定状態区分");
        exStringEquals(SkKankyouRuleBean4.getKthhbKbn(), "あり", "決定保留不備区分");


        exStringEquals(bzProcessForwardForBatchInBeanLst.get(4).getKouteiKanriId(), "kouteikanri2", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(4).getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(4).getTaskNm(), "sinkeiyakuBatch22", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(4).getSyoriComment(), "振込入金処理22", "処理コメント");
        SkMainDairitenRuleBean skMainDairitenRuleBean5 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBeanLst.get(4).getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean5.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean5.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean5.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean5.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean5.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean5.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean5.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean5.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean5.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean5.getSrhhbKbn(), "あり", "成立保留不備区分");

        exStringEquals(bzProcessForwardForBatchInBeanLst.get(5).getKouteiKanriId(), "kouteikanri6", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(5).getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(5).getTaskNm(), "sinkeiyakuBatch22", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(5).getSyoriComment(), "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");
        SkMainDairitenRuleBean skMainDairitenRuleBean6 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBeanLst.get(5).getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean6.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean6.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean6.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean6.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean6.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean6.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean6.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean6.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean6.getSateijtKbn(), "査定済", "査定状態区分");

        exStringEquals(bzProcessForwardForBatchInBeanLst.get(6).getKouteiKanriId(), "kouteikanri2", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(6).getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(6).getTaskNm(), "sinkeiyakuBatch23", "タスク名");
        exStringEquals(bzProcessForwardForBatchInBeanLst.get(6).getSyoriComment(), "振込入金処理23", "処理コメント");
        SkMainDairitenRuleBean skMainDairitenRuleBean7 = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBeanLst.get(6).getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean7.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean7.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean7.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean7.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean7.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean7.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean7.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean7.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean7.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean7.getSrhhbKbn(), "あり", "成立保留不備区分");

    }
}
