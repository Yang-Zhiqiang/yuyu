package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 処理中子工程情報取得クラスのメソッド {@link GetSyoriKokouteiInfo#exec(String,String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSyoriKokouteiInfoTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_処理中子工程情報取得";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        BzGetProcessSummaryMockForBiz.caller = GetSyoriKokouteiInfoTest_exec.class;
    }
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.caller = null;
        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetSyoriKokouteiInfoTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String pKouteiKanriId = "G";

        String pJimutetuzukiCd = "T";

        GetSyoriKokouteiInfo getSyoriKokouteiInfo = SWAKInjector.getInstance(GetSyoriKokouteiInfo.class);
        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst = getSyoriKokouteiInfo.exec(pKouteiKanriId,
            pJimutetuzukiCd);

        exNumericEquals(getSyoriKokouteiInfoOutBeanLst.size(), 0, "処理中子工程情報リストのサイズ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String pKouteiKanriId = "G1";

        String pJimutetuzukiCd = "T1";

        GetSyoriKokouteiInfo getSyoriKokouteiInfo = SWAKInjector.getInstance(GetSyoriKokouteiInfo.class);
        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst = getSyoriKokouteiInfo.exec(pKouteiKanriId,
            pJimutetuzukiCd);

        exNumericEquals(getSyoriKokouteiInfoOutBeanLst.size(), 0, "処理中子工程情報リストのサイズ");
    }


    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String pKouteiKanriId = "G2";

        String pJimutetuzukiCd = "T2";

        GetSyoriKokouteiInfo getSyoriKokouteiInfo = SWAKInjector.getInstance(GetSyoriKokouteiInfo.class);
        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst = getSyoriKokouteiInfo.exec(pKouteiKanriId,
            pJimutetuzukiCd);

        exNumericEquals(getSyoriKokouteiInfoOutBeanLst.size(), 0, "処理中子工程情報リストのサイズ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String pKouteiKanriId = "G3";

        String pJimutetuzukiCd = "T3";

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;

        GetSyoriKokouteiInfo getSyoriKokouteiInfo = SWAKInjector.getInstance(GetSyoriKokouteiInfo.class);
        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst = getSyoriKokouteiInfo.exec(pKouteiKanriId,
            pJimutetuzukiCd);

        exNumericEquals(getSyoriKokouteiInfoOutBeanLst.size(), 1, "処理中子工程情報リストのサイズ");
        exStringEquals(getSyoriKokouteiInfoOutBeanLst.get(0).getSyoriKokouteikanriId(), "G31", "処理中子工程管理ID");
        exStringEquals(getSyoriKokouteiInfoOutBeanLst.get(0).getSyoriKokouteiJimutetuzukiCd(), "T3",
            "処理中子工程事務手続コード");
        exClassificationEquals(getSyoriKokouteiInfoOutBeanLst.get(0).getDouJimutetuzukicdUmuKbn(), C_UmuKbn.NONE,
            "同一事務手続コード有無区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String pKouteiKanriId = "G4";

        String pJimutetuzukiCd = "T4";

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;

        GetSyoriKokouteiInfo getSyoriKokouteiInfo = SWAKInjector.getInstance(GetSyoriKokouteiInfo.class);
        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst = getSyoriKokouteiInfo.exec(pKouteiKanriId,
            pJimutetuzukiCd);

        exNumericEquals(getSyoriKokouteiInfoOutBeanLst.size(), 3, "処理中子工程情報リストのサイズ");
        exStringEquals(getSyoriKokouteiInfoOutBeanLst.get(0).getSyoriKokouteikanriId(), "G41", "処理中子工程管理ID");
        exStringEquals(getSyoriKokouteiInfoOutBeanLst.get(0).getSyoriKokouteiJimutetuzukiCd(), "T41",
            "処理中子工程事務手続コード");
        exClassificationEquals(getSyoriKokouteiInfoOutBeanLst.get(0).getDouJimutetuzukicdUmuKbn(), C_UmuKbn.NONE,
            "同一事務手続コード有無区分");
        exStringEquals(getSyoriKokouteiInfoOutBeanLst.get(1).getSyoriKokouteikanriId(), "G42", "処理中子工程管理ID");
        exStringEquals(getSyoriKokouteiInfoOutBeanLst.get(1).getSyoriKokouteiJimutetuzukiCd(), "T42",
            "処理中子工程事務手続コード");
        exClassificationEquals(getSyoriKokouteiInfoOutBeanLst.get(1).getDouJimutetuzukicdUmuKbn(), C_UmuKbn.ARI,
            "同一事務手続コード有無区分");
        exStringEquals(getSyoriKokouteiInfoOutBeanLst.get(2).getSyoriKokouteikanriId(), "G43", "処理中子工程管理ID");
        exStringEquals(getSyoriKokouteiInfoOutBeanLst.get(2).getSyoriKokouteiJimutetuzukiCd(), "T42",
            "処理中子工程事務手続コード");
        exClassificationEquals(getSyoriKokouteiInfoOutBeanLst.get(2).getDouJimutetuzukicdUmuKbn(), C_UmuKbn.ARI,
            "同一事務手続コード有無区分");
    }
}
