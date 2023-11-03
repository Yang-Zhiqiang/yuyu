package yuyu.common.sinkeiyaku.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzOutputProcessRecordMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzProcessForwardMockForSinkeiyaku;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.GetSyoruittykymdMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardKokutisyoNyuuryokuクラスのメソッド {@link SkProcessForwardKokutisyoNyuuryoku#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardKokutisyoNyuuryokuTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（告知書入力）";

    private final static String sheetName = "テストデータ";

    @Inject
    private SkProcessForwardKokutisyoNyuuryoku skProcessForwardKokutisyoNyuuryoku;

    private final static String mosNo1 = "860817113";

    private final static String mosNo2 = "860817121";

    private final static String mosNo3 = "860817139";

    private final static String mosNo4 = "860817147";

    private final static String mosNo5 = "860817154";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForward.class).to(BzProcessForwardMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
                bind(GetSyoruittykymd.class).to(GetSyoruittykymdMockForSinkeiyaku.class);
                bind(SkProcessForwardTeisei.class).to(SkProcessForwardTeiseiMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardKokutisyoNyuuryokuTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardKokutisyoNyuuryokuTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardKokutisyoNyuuryokuTest_exec.class;
        GetSyoruittykymdMockForSinkeiyaku.caller = SkProcessForwardKokutisyoNyuuryokuTest_exec.class;
        SkProcessForwardTeiseiMockForSinkeiyaku.caller = SkProcessForwardKokutisyoNyuuryokuTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        GetSyoruittykymdMockForSinkeiyaku.caller = null;
        SkProcessForwardTeiseiMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardTeiseiMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardHenkinNyuuryokuTest_exec.class, fileName, sheetName);
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
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo1);
        skProcessForwardInBean.setTskNm("告知書入力（新規（１次））");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント１");

        skProcessForwardKokutisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.MOSKIT.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント１", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（新規（１次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo2);
        skProcessForwardInBean.setTskNm("告知書入力（新規（２次））");
        skProcessForwardInBean.setKouteiLockkey("20");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);
        skProcessForwardInBean.setSyoriComment("処理コメント２");

        skProcessForwardKokutisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817121", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "2001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "20", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817121", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "2001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント２", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（新規（２次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.TENSOU_TENKEN_2, "処理結果区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo3);
        skProcessForwardInBean.setTskNm("告知書入力（新規（３次））");
        skProcessForwardInBean.setKouteiLockkey("30");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);
        skProcessForwardInBean.setSyoriComment("処理コメント３");

        skProcessForwardKokutisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817139", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "3001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "30", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817139", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "3001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント３", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（新規（３次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.TENSOU_TENKEN_2, "処理結果区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardTeiseiMockForSinkeiyaku.SYORIPTN=SkProcessForwardTeiseiMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo4);
        skProcessForwardInBean.setTskNm("告知書入力（訂正）");
        skProcessForwardInBean.setKouteiLockkey("40");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setSyoriComment("処理コメント４");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        skProcessForwardInBean.setMostenkentnsketsyaCd("5021");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setKnktnsketsyaCd("5022");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setImutnsketsyaCd("5023");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardInBean.setHnkninputTorikesiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardKokutisyoNyuuryoku.exec(skProcessForwardInBean);

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardKokutisyoNyuuryoku.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860817147", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "告知書入力（訂正）", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "40", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント４", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getMostenkenkekkaKbn(),C_SyorikekkaKbn.TENSOU_TENKEN_1 , "申込点検結果区分");
        exStringEquals(skProcessForwardInBean1.getMostenkentnsketsyaCd(), "5021", "申込点検転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(),C_SyorikekkaKbn.TENSOU_KANKYOU_1 , "環境査定結果区分");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "5022", "環境査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exStringEquals(skProcessForwardInBean1.getImutnsketsyaCd(), "5023", "医務査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");
        exClassificationEquals(skProcessForwardInBean1.getHnkninputTorikesiyhKbn(), C_YouhiKbn.YOU, "返金入力取消要否区分");

        BzGetProcessSummaryInBean  bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817147", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "4001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント４", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（訂正）", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.HORYUU, "処理結果区分");



    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN5;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo5);
        skProcessForwardInBean.setTskNm("告知書入力（削除）");
        skProcessForwardInBean.setKouteiLockkey("50");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_MOSTORIKESI);
        skProcessForwardInBean.setSyoriComment("処理コメント５");

        skProcessForwardKokutisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean  bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817154", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント５", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（削除）", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.TENSOU_MOSTORIKESI, "処理結果区分");

    }

}
