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

import com.google.inject.AbstractModule;

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
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * SkProcessForwardMousikomisyoNyuuryokuクラスのメソッド {@link SkProcessForwardMousikomisyoNyuuryoku#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardMousikomisyoNyuuryokuTest_exec {

    @Inject
    private SkProcessForwardMousikomisyoNyuuryoku skProcessForwardMousikomisyoNyuuryoku;

    private final static String mosNo1 = "780123451";

    private final static String mosNo2 = "780123469";

    private final static String mosNo3 = "780123477";

    private final static String mosNo4 = "780123485";

    private final static String mosNo5 = "780123493";

    private final static String mosNo6 = "780123501";

    private final static String mosNo7 = "780123519";

    private final static String mosNo8 = "780123527";

    private final static String mosNo9 = "780123535";

    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（申込書入力）";

    private final static String sheetName = "テストデータ_20170808";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForward.class).to(BzProcessForwardMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
                bind(GetSyoruittykymd.class).to(GetSyoruittykymdMockForSinkeiyaku.class);
                bind(SkProcessForwardMoschkExec.class).to(SkProcessForwardMoschkExecMockForSinkeiyaku.class);
                bind(SkProcessForwardTeisei.class).to(SkProcessForwardTeiseiMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardMousikomisyoNyuuryokuTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardMousikomisyoNyuuryokuTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardMousikomisyoNyuuryokuTest_exec.class;
        GetSyoruittykymdMockForSinkeiyaku.caller = SkProcessForwardMousikomisyoNyuuryokuTest_exec.class;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = SkProcessForwardMousikomisyoNyuuryokuTest_exec.class;
        SkProcessForwardTeiseiMockForSinkeiyaku.caller = SkProcessForwardMousikomisyoNyuuryokuTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        GetSyoruittykymdMockForSinkeiyaku.caller = null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = null;
        SkProcessForwardTeiseiMockForSinkeiyaku.caller = null;

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardTeiseiMockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardMousikomisyoNyuuryokuTest_exec.class,
                fileName, sheetName);
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
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo1);
        skProcessForwardInBean.setTskNm("申込書入力（新規（１次））");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "780123451", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean) bzProcessForwardInBean1
            .getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), "あり", "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "780123451", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        SkInputMosRuleBean skInputMosRuleBean = (SkInputMosRuleBean) bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputMosRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputMosRuleBean.getMosuketukeKbn(), "申込キット", "申込受付区分");
        exStringEquals(skInputMosRuleBean.getMosnrkvrfjkKbn(), "２次入力待ち", "申込書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "780123451", "申込番号");

        exStringEquals((String) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exClassificationEquals((C_SyoruiCdKbn) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 1),
            C_SyoruiCdKbn.SK_KOKUSYO, "書類コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "780123451", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean) bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "sktorikesi", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "780123451", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "780123451", "申込番号");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3),
            "申込書入力（新規（１次））", "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123451", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "申込書入力（新規（１次））", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo2);
        skProcessForwardInBean.setTskNm("申込書入力（新規（１次））");
        skProcessForwardInBean.setKouteiLockkey("20");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "780123469", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "20", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean) bzProcessForwardInBean1
            .getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), "あり", "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "780123469", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "20", "工程ロックキー");
        SkInputMosRuleBean skInputMosRuleBean = (SkInputMosRuleBean) bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputMosRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputMosRuleBean.getMosuketukeKbn(), "申込キット", "申込受付区分");
        exStringEquals(skInputMosRuleBean.getMosnrkvrfjkKbn(), "２次入力待ち", "申込書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "780123469", "申込番号");

        exStringEquals((String) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exClassificationEquals((C_SyoruiCdKbn) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 1),
            C_SyoruiCdKbn.SK_KOKUSYO, "書類コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "780123469", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "20", "工程ロックキー");
        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean) bzProcessForwardInBean3
            .getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), "申込キット", "告知書入力有無");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "780123469", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "20", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean) bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), "sktorikesi", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "780123469", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), "sktorikesi", "事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "20", "工程ロックキー");
        SkTorikesiRuleBean skTorikesiRuleBean = (SkTorikesiRuleBean) bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTorikesiRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "780123469", "申込番号");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3),
            "申込書入力（新規（１次））", "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123469", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "申込書入力（新規（１次））", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "20", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo3);
        skProcessForwardInBean.setTskNm("申込書入力（新規（２次））");
        skProcessForwardInBean.setKouteiLockkey("30");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "780123477", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "30", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean) bzProcessForwardInBean1
            .getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), "あり", "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "780123477", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "30", "工程ロックキー");
        SkInputMosRuleBean skInputMosRuleBean = (SkInputMosRuleBean) bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputMosRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputMosRuleBean.getMosuketukeKbn(), "申込キット", "申込受付区分");
        exStringEquals(skInputMosRuleBean.getMosnrkvrfjkKbn(), "２次入力待ち", "申込書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "780123477", "申込番号");

        exStringEquals((String) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exClassificationEquals((C_SyoruiCdKbn) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 1),
            C_SyoruiCdKbn.SK_KOKUSYO, "書類コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "780123477", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "30", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean) bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), "sktorikesi", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "780123477", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), "sktorikesi1", "事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "30", "工程ロックキー");
        SkTorikesiRuleBean skTorikesiRuleBean = (SkTorikesiRuleBean) bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTorikesiRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "780123477", "申込番号");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3),
            "申込書入力（新規（２次））", "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123477", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "申込書入力（新規（２次））", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "30", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo4);
        skProcessForwardInBean.setTskNm("申込書入力（新規（２次））");
        skProcessForwardInBean.setKouteiLockkey("40");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "780123485", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "40", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean) bzProcessForwardInBean1
            .getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), "なし", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), "決定待ち", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), "特条承諾書待ち", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), "なし", "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "780123485", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "40", "工程ロックキー");
        SkInputMosRuleBean skInputMosRuleBean = (SkInputMosRuleBean) bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputMosRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputMosRuleBean.getMosuketukeKbn(), "申込キット", "申込受付区分");
        exStringEquals(skInputMosRuleBean.getMosnrkvrfjkKbn(), "２次入力待ち", "申込書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "780123485", "申込番号");

        exStringEquals((String) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exClassificationEquals((C_SyoruiCdKbn) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 1),
            C_SyoruiCdKbn.SK_KOKUSYO, "書類コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "780123485", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "40", "工程ロックキー");
        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean) bzProcessForwardInBean3
            .getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), "なし", "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), "申込キット", "告知書入力有無");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "780123485", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "40", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean) bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "なし", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "780123485", "申込番号");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3),
            "申込書入力（新規（２次））", "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123485", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "申込書入力（新規（２次））", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "40", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo5);
        skProcessForwardInBean.setTskNm("申込書入力（新規（３次））");
        skProcessForwardInBean.setKouteiLockkey("50");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "780123493", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "50", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean) bzProcessForwardInBean1
            .getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), "あり", "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "780123493", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "50", "工程ロックキー");
        SkInputMosRuleBean skInputMosRuleBean = (SkInputMosRuleBean) bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputMosRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputMosRuleBean.getMosuketukeKbn(), "申込キット", "申込受付区分");
        exStringEquals(skInputMosRuleBean.getMosnrkvrfjkKbn(), "２次入力待ち", "申込書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "780123493", "申込番号");

        exStringEquals((String) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exClassificationEquals((C_SyoruiCdKbn) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 1),
            C_SyoruiCdKbn.SK_KOKUSYO, "書類コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "780123493", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "50", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean) bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "sktorikesi", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "780123493", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "780123493", "申込番号");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3),
            "申込書入力（新規（３次））", "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123493", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "申込書入力（新規（３次））", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "50", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo6);
        skProcessForwardInBean.setTskNm("申込書入力（新規（３次））");
        skProcessForwardInBean.setKouteiLockkey("60");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "780123501", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "60", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean) bzProcessForwardInBean1
            .getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), "未成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), "なし", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), "なし", "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "780123501", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "skinputmos", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "60", "工程ロックキー");
        SkInputMosRuleBean skInputMosRuleBean = (SkInputMosRuleBean) bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputMosRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputMosRuleBean.getMosuketukeKbn(), "生保Ｗｅｂ", "申込受付区分");
        exStringEquals(skInputMosRuleBean.getMosnrkvrfjkKbn(), "２次入力待ち", "申込書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "780123501", "申込番号");

        exStringEquals((String) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exClassificationEquals((C_SyoruiCdKbn) MockObjectManager.getArgument(GetSyoruittykymdMockForSinkeiyaku.class, "exec", 0, 1),
            C_SyoruiCdKbn.SK_KOKUSYO, "書類コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "780123501", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "skinputkokuti", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "60", "工程ロックキー");
        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean) bzProcessForwardInBean3
            .getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), "未成立", "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), "なし", "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), "生保Ｗｅｂ", "告知書入力有無");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "780123501", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "60", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean) bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "未成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "なし", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "告知扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "２次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), "点検待ち（１次）", "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(
                BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "780123501", "申込番号");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3),
            "申込書入力（新規（３次））", "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123501", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "申込書入力（新規（３次））", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "60", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();

        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardTeiseiMockForSinkeiyaku.SYORIPTN = SkProcessForwardTeiseiMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo7);
        skProcessForwardInBean.setTskNm("申込書入力（変更訂正）");
        skProcessForwardInBean.setKouteiLockkey("70");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardTeiseiMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123519", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "申込書入力（変更訂正）", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "70", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        SkProcessForwardInBean skProcessForwardInBean2 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean2.getMosNo(), "780123519", "申込番号");
        exStringEquals(skProcessForwardInBean2.getTskNm(), "申込書入力（変更訂正）", "タスク名");
        exStringEquals(skProcessForwardInBean2.getKouteiLockkey(), "70", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean2.getSyoriComment(), "処理コメント", "処理コメント");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();

        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardTeiseiMockForSinkeiyaku.SYORIPTN = SkProcessForwardTeiseiMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo8);
        skProcessForwardInBean.setTskNm("申込書入力（入力訂正）");
        skProcessForwardInBean.setKouteiLockkey("80");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardTeiseiMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123527", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "申込書入力（入力訂正）", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "80", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        SkProcessForwardInBean skProcessForwardInBean2 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean2.getMosNo(), "780123527", "申込番号");
        exStringEquals(skProcessForwardInBean2.getTskNm(), "申込書入力（入力訂正）", "タスク名");
        exStringEquals(skProcessForwardInBean2.getKouteiLockkey(), "80", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean2.getSyoriComment(), "処理コメント", "処理コメント");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();

        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo9);
        skProcessForwardInBean.setTskNm("デフォルト");
        skProcessForwardInBean.setKouteiLockkey("90");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");

        skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "780123535", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "デフォルト", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "90", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
    }
}
