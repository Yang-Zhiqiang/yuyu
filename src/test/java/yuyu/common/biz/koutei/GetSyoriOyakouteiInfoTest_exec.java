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
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 処理中親工程情報取得クラスのメソッド {@link GetSyoriOyakouteiInfo#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSyoriOyakouteiInfoTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_処理中親工程情報取得";

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
        BzGetProcessSummaryMockForBiz.caller = GetSyoriOyakouteiInfoTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        BzGetProcessSummaryMockForBiz.caller = null;
        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetSyoriOyakouteiInfoTest_exec.class,
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
        String kouteiKanriId = "10000000001";

        GetSyoriOyakouteiInfo getSyoriOyakouteiInfo = SWAKInjector.getInstance(GetSyoriOyakouteiInfo.class);
        GetSyoriOyakouteiInfoOutBean getSyoriOyakouteiInfoOutBean = getSyoriOyakouteiInfo.exec(kouteiKanriId);
        exStringEquals(getSyoriOyakouteiInfoOutBean.getSyoriOyaKouteikanriId(), null, "処理中親工程管理ID");
        exStringEquals(getSyoriOyakouteiInfoOutBean.getSyoriOyaKouteiJimutetuzukiCd(), null, "処理中親工程事務手続コード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();

        String kouteiKanriId = "10000000002";

        GetSyoriOyakouteiInfo getSyoriOyakouteiInfo = SWAKInjector.getInstance(GetSyoriOyakouteiInfo.class);
        GetSyoriOyakouteiInfoOutBean getSyoriOyakouteiInfoOutBean = getSyoriOyakouteiInfo.exec(kouteiKanriId);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);

        exStringEquals(getSyoriOyakouteiInfoOutBean.getSyoriOyaKouteikanriId(), null, "処理中親工程管理ID");
        exStringEquals(getSyoriOyakouteiInfoOutBean.getSyoriOyaKouteiJimutetuzukiCd(), null, "処理中親工程事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "3000001", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "0002", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;

        String kouteiKanriId = "10000000002";

        GetSyoriOyakouteiInfo getSyoriOyakouteiInfo = SWAKInjector.getInstance(GetSyoriOyakouteiInfo.class);
        GetSyoriOyakouteiInfoOutBean getSyoriOyakouteiInfoOutBean = getSyoriOyakouteiInfo.exec(kouteiKanriId);
        exStringEquals(getSyoriOyakouteiInfoOutBean.getSyoriOyaKouteikanriId(), "3000001", "処理中親工程管理ID");
        exStringEquals(getSyoriOyakouteiInfoOutBean.getSyoriOyaKouteiJimutetuzukiCd(), "0002", "処理中親工程事務手続コード");
    }
}
