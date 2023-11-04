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
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardKeiyakuKakuninIraiクラスのメソッド {@link SkProcessForwardKeiyakuKakuninIrai#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardKeiyakuKakuninIraiTest_exec {

    @Inject
    private SkProcessForwardKeiyakuKakuninIrai skProcessForwardKeiyakuKakuninIrai;

    private final static String mosNo1 = "990000010";

    private final static String mosNo2 = "990000028";

    private final static String mosNo3 = "990000036";

    private final static String fileName = "UT_SP_単体テスト仕様書_新契約工程遷移（契約確認依頼入力）";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
                bind(SkProcessForwardMoschkExec.class).to(SkProcessForwardMoschkExecMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardKeiyakuKakuninIraiTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardKeiyakuKakuninIraiTest_exec.class;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = SkProcessForwardKeiyakuKakuninIraiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = null ;

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardKeiyakuKakuninIraiTest_exec.class, fileName, sheetName);
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
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo1);
        skProcessForwardInBean.setTskNm("告知書入力（新規（１次））");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント１");

        skProcessForwardKeiyakuKakuninIrai.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), mosNo1, "申込番号");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), mosNo1, "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "告知書入力（新規（１次））", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント１", "処理コメント");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo2);
        skProcessForwardInBean.setTskNm("告知書入力（新規（２次））");
        skProcessForwardInBean.setKouteiLockkey("20");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント２");

        skProcessForwardKeiyakuKakuninIrai.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), mosNo2, "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "2001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "SkMainDairiten", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント２", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class,   "exec", 0, 3), "告知書入力（新規（２次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo3);
        skProcessForwardInBean.setTskNm("告知書入力（新規（３次））");
        skProcessForwardInBean.setKouteiLockkey("30");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント３");

        skProcessForwardKeiyakuKakuninIrai.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",1, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean.getSyoNo(), "17806000013", "証券番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "3001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "SkMainDairiten", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント３", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class,   "exec", 0, 3), "告知書入力（新規（３次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

    }
}
