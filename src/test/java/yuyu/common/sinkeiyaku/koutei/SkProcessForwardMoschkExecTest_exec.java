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
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.BzTaskStartMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardMoschkExecクラスのメソッド {@link SkProcessForwardMoschkExec#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardMoschkExecTest_exec {

    @Inject
    private SkProcessForwardMoschkExec skProcessForwardMoschkExec;

    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（申込内容チェック実行）";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SkProcessForwardKetteiHoryuuHubiOnline.class).to(SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.class);
                bind(SkProcessForwardSeiritu.class).to(SkProcessForwardSeirituMockForSinkeiyaku.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForward.class).to(BzProcessForwardMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
                bind(BzTaskStart.class).to(BzTaskStartMockForSinkeiyaku.class);
            }
        });
    }
    @BeforeClass
    public static void testInit() {

        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.caller = SkProcessForwardMoschkExecTest_exec.class;
        SkProcessForwardSeirituMockForSinkeiyaku.caller = SkProcessForwardMoschkExecTest_exec.class;
        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardMoschkExecTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardMoschkExecTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardMoschkExecTest_exec.class;
        BzTaskStartMockForSinkeiyaku.caller = SkProcessForwardMoschkExecTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.caller = null;
        SkProcessForwardSeirituMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        BzTaskStartMockForSinkeiyaku.caller = null;

        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardSeirituMockForSinkeiyaku.SYORIPTN = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        BzTaskStartMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardMoschkExecTest_exec.class, fileName, sheetName);
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
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123459");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "790123459", "申込番号");
        exClassificationEquals(skProcessForwardInBean1.getMoscheckrirekiyhKbn(), C_YouhiKbn.YOU,
            "申込内容チェック履歴作成要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123459", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(), "11807111200", "証券番号");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();

        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123467");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123467", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(), "11807111211", "証券番号");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();

        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN5;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123475");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("コメント３");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1003",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "コメント３",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程",
            "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();

        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN6;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123483");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("コメント４");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1004",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "コメント４",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程",
            "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();

        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123491");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("コメント５");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1234",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "SkMainDairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "コメント５",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程",
            "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();

        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123509");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("コメント６");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5678",
            "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1),
            "SkMainDairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "コメント６",
            "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程",
            "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();

        SkProcessForwardSeirituMockForSinkeiyaku.SYORIPTN = SkProcessForwardSeirituMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123517");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardSeirituMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "790123517", "申込番号");
        exClassificationEquals(skProcessForwardInBean1.getMoscheckrirekiyhKbn(), C_YouhiKbn.HUYOU,
            "申込内容チェック履歴作成要否区分");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123525");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "790123525", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123533");
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "790123533", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN7;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzTaskStartMockForSinkeiyaku.SYORIPTN = BzTaskStartMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123541");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123541", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager
            .getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "2001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.SYOUNIN, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getKouteiKanriId(), "2001", "工程管理ＩＤ");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForSinkeiyaku.class, "exec", 0, 0), "2001", "工程管理ＩＤ");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForSinkeiyaku.class, "exec", 0, 1), "skmaindairiten", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForSinkeiyaku.class, "exec", 0, 2), ISkCommonKoumoku.NODEID_SATEI, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForSinkeiyaku.class, "exec", 0, 3), "10", "工程ロックキー");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123541", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager
            .getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "2002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.SYOUNIN, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getKouteiKanriId(), "2002", "工程管理ＩＤ");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123541", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager
            .getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "2003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.SYOUNIN, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), "ＬＩＮＣ照会中", "ＬＩＮＣ状況区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getKouteiKanriId(), "2003", "工程管理ＩＤ");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123541", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager
            .getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "2004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.SYOUNIN, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean8 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);
        exStringEquals(bzGetProcessSummaryInBean8.getKouteiKanriId(), "2004", "工程管理ＩＤ");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 8, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123541", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean) MockObjectManager
            .getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "2005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "10", "工程ロックキー");
        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.SYOUNIN, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 9, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getKouteiKanriId(), "2005", "工程管理ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN8;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123558");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123558", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123558", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123558", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123558", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123558", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN9;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123566");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123566", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123566", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123566", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123566", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123566", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN10;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123574");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123574", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123574", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123574", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123574", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123574", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN11;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123582");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123582", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123582", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123582", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123582", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123582", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN12;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123590");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123590", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123590", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123590", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123590", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123590", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN13;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123608");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123608", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123608", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123608", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123608", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123608", "申込番号");
    }
    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN14;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123616");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123616", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123616", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123616", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123616", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123616", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN15;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123624");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123624", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123624", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123624", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123624", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "790123624", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getKouteiKanriId(), "2005", "工程管理ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN16;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123632");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123632", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123632", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123632", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123632", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean9.getKouteiKanriId(), "2004", "工程管理ＩＤ");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123632", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN17;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123640");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123640", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123640", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123640", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123640", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123640", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN18;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123657");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123657", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123657", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123657", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123657", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123657", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN19;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123665");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123665", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123665", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123665", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123665", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123665", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN20;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123673");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123673", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123673", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123673", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123673", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123673", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN21;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123681");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123681", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123681", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123681", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123681", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123681", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN22;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123699");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123699", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123699", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123699", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123699", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123699", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN23;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123707");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123707", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123707", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123707", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123707", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123707", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A27() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN24;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123715");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123715", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123715", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123715", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123715", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123715", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A28() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN25;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123723");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123723", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123723", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123723", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123723", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123723", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_A29() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN24;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123731");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123731", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123731", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123731", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123731", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123731", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_A30() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN25;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123749");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123749", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123749", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123749", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123749", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123749", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_A31() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN24;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123756");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123756", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123756", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123756", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123756", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123756", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_A32() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN25;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("790123764");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.SYOUNIN);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "790123764", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "790123764", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "790123764", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), "skimu", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "790123764", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean10 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean10.getJimuTetuzukiCd(), "skhubitouroku", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean10.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況（配列可）[0]");
        exStringEquals(bzGetProcessSummaryInBean10.getMosNo(), "790123764", "申込番号");
    }
}
