package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 不備未解消リストＣＳＶ作成のメソッド {@link EditCsvHubiMikai#exec(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditCsvHubiMikaiTest_exec_3 {

    @Inject
    private EditCsvHubiMikai editCsvHubiMikai;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_不備未解消リストＣＳＶ作成";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditCsvHubiMikaiTest_exec_3.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileSyuruis());
    }

    @BeforeClass
    public static void testInit(){
        BzGetProcessSummaryMockForSinkeiyaku.caller = EditCsvHubiMikaiTest_exec_3.class;
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_C1() {
        MockObjectManager.initialize();

        int totalCount = editCsvHubiMikai.exec(BizDate.valueOf("20160412"));

        exNumericEquals(totalCount, 3, "出力件数");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "861110013", "申込番号");

    }
}
