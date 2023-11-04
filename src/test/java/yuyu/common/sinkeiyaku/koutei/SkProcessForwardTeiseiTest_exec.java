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
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckKinouModeKengenMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzOutputProcessRecordMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzProcessForwardMockForSinkeiyaku;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.biz.koutei.CheckTaskKengenMockForSinkeiyaku;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.GetSyoruittykymdMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardTeiseiクラスのメソッド {@link SkProcessForwardTeisei#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardTeiseiTest_exec {

    @Inject
    private SkProcessForwardTeisei skProcessForwardTeisei;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String mosNo1 = "880817119";

    private final static String mosNo2 = "880817127";

    private final static String mosNo3 = "880817135";

    private final static String mosNo4 = "880817143";

    private final static String mosNo5 = "880000013";

    private final static String mosNo6 = "880000021";
    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（変更訂正）";

    private final static String sheetName = "テストデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForward.class).to(BzProcessForwardMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
                bind(GetSyoruittykymd.class).to(GetSyoruittykymdMockForSinkeiyaku.class);
                bind(CheckKinouModeKengen.class).to(CheckKinouModeKengenMockForSinkeiyaku.class);
                bind(CheckTaskKengen.class).to(CheckTaskKengenMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardTeiseiTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardTeiseiTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardTeiseiTest_exec.class;
        GetSyoruittykymdMockForSinkeiyaku.caller = SkProcessForwardTeiseiTest_exec.class;
        CheckKinouModeKengenMockForSinkeiyaku.caller = SkProcessForwardTeiseiTest_exec.class;
        CheckTaskKengenMockForSinkeiyaku.caller = SkProcessForwardTeiseiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        GetSyoruittykymdMockForSinkeiyaku.caller = null;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = null;
        CheckKinouModeKengenMockForSinkeiyaku.caller = null;
        CheckKinouModeKengenMockForSinkeiyaku.SYORIPTN = null;
        CheckTaskKengenMockForSinkeiyaku.caller = null;
        CheckTaskKengenMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardTeiseiTest_exec.class, fileName, sheetName);
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
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo1);
        skProcessForwardInBean.setTskNm("告知書入力（新規（１次））");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント１");

        skProcessForwardTeisei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), mosNo1, "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "10", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), C_UmuKbn.NONE.getContent(), "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo1, "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exClassificationEquals((C_SyoruiCdKbn)MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 1), C_SyoruiCdKbn.SK_KOKUSYO, "書類コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exStringEquals(bzProcessForwardInBean2.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIZUMI.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");
        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), mosNo1, "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "申込内容の訂正が行われたため、申込点検（１次）へ自動転送します。", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（新規（１次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.IRAI_TENKEN_1, "処理結果区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo2);
        skProcessForwardInBean.setTskNm("告知書入力（新規（２次））");
        skProcessForwardInBean.setKouteiLockkey("20");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);
        skProcessForwardInBean.setSyoriComment("処理コメント２");

        skProcessForwardTeisei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo2, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "2002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "20", "工程ロックキー");
        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.SEIHOWEB.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_TENKEN_2, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo2, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "2003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "20", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exStringEquals(bzProcessForwardInBean3.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        CheckKinouModeKengenMockForSinkeiyaku.SYORIPTN = CheckKinouModeKengenMockForSinkeiyaku.TESTPATTERN1;
        CheckTaskKengenMockForSinkeiyaku.SYORIPTN = CheckKinouModeKengenMockForSinkeiyaku.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("KYOUYOU");

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo3);
        skProcessForwardInBean.setTskNm("告知書入力（新規（３次））");
        skProcessForwardInBean.setKouteiLockkey("30");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);
        skProcessForwardInBean.setSyoriComment("処理コメント３");

        skProcessForwardTeisei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo3, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "3003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "30", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.KANRYOU.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exStringEquals(bzProcessForwardInBean3.getSaiwariateUserId(), "KYOUYOU", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), mosNo3, "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "3001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "申込内容の訂正が行われたため、申込点検（１次）へ自動転送します。", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（新規（３次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.IRAI_TENKEN_1, "処理結果区分");

        exStringEquals((String)MockObjectManager.getArgument(CheckKinouModeKengenMockForSinkeiyaku.class, "checkKengenByKinouModeIdByUserId", 0, 0), "KYOUYOU", "ユーザーＩＤ");
        exStringEquals((String)MockObjectManager.getArgument(CheckKinouModeKengenMockForSinkeiyaku.class, "checkKengenByKinouModeIdByUserId", 0, 1), "skmousikomitenken", "機能ＩＤ");
        exStringEquals((String)MockObjectManager.getArgument(CheckKinouModeKengenMockForSinkeiyaku.class, "checkKengenByKinouModeIdByUserId", 0, 2), C_SkkinouModeIdKbn.MOSTENKEN_1JI.getValue(), "機能モードID");

        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSinkeiyaku.class, "exec", 0, 0), "KYOUYOU", "ユーザーID");
        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSinkeiyaku.class, "exec", 0, 2), ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI, "タスクID");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        CheckKinouModeKengenMockForSinkeiyaku.SYORIPTN = CheckKinouModeKengenMockForSinkeiyaku.TESTPATTERN2;
        CheckTaskKengenMockForSinkeiyaku.SYORIPTN = CheckKinouModeKengenMockForSinkeiyaku.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("JUnit");

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo4);
        skProcessForwardInBean.setTskNm("告知書入力（訂正）");
        skProcessForwardInBean.setKouteiLockkey("40");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setSyoriComment("処理コメント４");

        skProcessForwardTeisei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo4, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "4002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "40", "工程ロックキー");
        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.SIRYOUSEIKYUU.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo4, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "4003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "40", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.NONE.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exStringEquals(bzProcessForwardInBean3.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), mosNo4, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "4004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "40", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.NONE.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_2B.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.HANEIMATI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), mosNo4, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "4005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "40", "工程ロックキー");
        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.NONE.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.NONE.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


    }


    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        CheckKinouModeKengenMockForSinkeiyaku.SYORIPTN = CheckKinouModeKengenMockForSinkeiyaku.TESTPATTERN1;
        CheckTaskKengenMockForSinkeiyaku.SYORIPTN = CheckKinouModeKengenMockForSinkeiyaku.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("KYOUYOU");

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo5);
        skProcessForwardInBean.setTskNm("告知書入力（新規（３次））");
        skProcessForwardInBean.setKouteiLockkey("30");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);
        skProcessForwardInBean.setSyoriComment("処理コメント３");

        skProcessForwardTeisei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo5, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "3003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "30", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.NONE.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.KANRYOU.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exStringEquals(bzProcessForwardInBean3.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), mosNo5, "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "3001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "申込内容の訂正が行われたため、申込点検（１次）へ自動転送します。", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（新規（３次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.IRAI_TENKEN_1, "処理結果区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        CheckKinouModeKengenMockForSinkeiyaku.SYORIPTN = CheckKinouModeKengenMockForSinkeiyaku.TESTPATTERN1;
        CheckTaskKengenMockForSinkeiyaku.SYORIPTN = CheckTaskKengenMockForSinkeiyaku.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("56510101");

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo6);
        skProcessForwardInBean.setTskNm("告知書入力（新規（３次））");
        skProcessForwardInBean.setKouteiLockkey("30");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);
        skProcessForwardInBean.setSyoriComment("処理コメント３");

        skProcessForwardTeisei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo6, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "3003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "30", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.NONE.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.KANRYOU.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exStringEquals(bzProcessForwardInBean3.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), mosNo6, "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "3001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "申込内容の訂正が行われたため、申込点検（１次）へ自動転送します。", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（新規（３次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.IRAI_TENKEN_1, "処理結果区分");

        exStringEquals((String)MockObjectManager.getArgument(CheckKinouModeKengenMockForSinkeiyaku.class, "checkKengenByKinouModeIdByUserId", 0, 0), "56510101", "ユーザーＩＤ");
        exStringEquals((String)MockObjectManager.getArgument(CheckKinouModeKengenMockForSinkeiyaku.class, "checkKengenByKinouModeIdByUserId", 0, 1), "skmousikomitenken", "機能ＩＤ");
        exStringEquals((String)MockObjectManager.getArgument(CheckKinouModeKengenMockForSinkeiyaku.class, "checkKengenByKinouModeIdByUserId", 0, 2), C_SkkinouModeIdKbn.MOSTENKEN_1JI.getValue(), "機能モードID");

        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSinkeiyaku.class, "exec", 0, 0), "56510101", "ユーザーID");
        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSinkeiyaku.class, "exec", 0, 2), ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI, "タスクID");
    }


}
