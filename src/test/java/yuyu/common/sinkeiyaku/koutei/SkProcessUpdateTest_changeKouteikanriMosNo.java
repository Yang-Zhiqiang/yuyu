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
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatch;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchMockForSinkeiyaku;
import yuyu.common.biz.bzcommon.TuikaParamForBatchInputBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessUpdateクラスのメソッド {@link SkProcessUpdate#changeKouteikanriMosNo}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessUpdateTest_changeKouteikanriMosNo {

    @Inject
    private SkProcessUpdate skProcessUpdate;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約工程情報更新";

    private final static String sheetName = "INデータ";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessUpdateForBatch.class).to(BzProcessUpdateForBatchMockForSinkeiyaku.class);
            }
        });
    }
    @BeforeClass
    @Transactional
    public static void testInit() {
        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessUpdateTest_changeKouteikanriMosNo.class;
        BzProcessUpdateForBatchMockForSinkeiyaku.caller = SkProcessUpdateTest_changeKouteikanriMosNo.class;
    }

    @AfterClass
    @Transactional
    public static void testClear() {
        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessUpdateForBatchMockForSinkeiyaku.caller = null;
        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessUpdateTest_changeKouteikanriMosNo.class, fileName, sheetName);
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
    @Transactional
    public void testEditProcessUpdateForBatchInfo_A1() {
        List<BT_GyoumuKouteiInfo> btGyoumuKouteiInfoList =
            skProcessUpdate.changeKouteikanriMosNo(null, "0052il0wblaq0xa1pn", null ,null);
        exBooleanEquals(btGyoumuKouteiInfoList == null, true, "戻り値がnull");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditProcessUpdateForBatchInfo_A2() {
        List<BT_GyoumuKouteiInfo> btGyoumuKouteiInfoList =
            skProcessUpdate.changeKouteikanriMosNo(new HT_SyoriCTL() , null, null ,null);
        exBooleanEquals(btGyoumuKouteiInfoList == null, true, "戻り値がnull");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditProcessUpdateForBatchInfo_A3() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = BzProcessUpdateForBatchMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");

        String kouteiKanriId1 = "SKTKRID01";

        List<BT_GyoumuKouteiInfo> btGyoumuKouteiInfoList =
            skProcessUpdate.changeKouteikanriMosNo(syoriCTL1 , kouteiKanriId1, null ,null);

        exNumericEquals(btGyoumuKouteiInfoList.size(), 1, "件数");

        exStringEquals(btGyoumuKouteiInfoList.get(0).getMosno(), "791112220", "申込番号");
        exStringEquals(btGyoumuKouteiInfoList.get(0).getSyono(), "17810000016", "証券番号");

        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
            (List<BzProcessUpdateForBatchInputBean>)MockObjectManager.getArgument(SkProcessUpdate.class, "execForBatch", 0, 0);

        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(0).getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(0).getKouteiKanriId(), "5301", "工程管理ID");
        exClassificationEquals(bzProcessUpdateForBatchInputBeanList.get(0).getKokouteiUpdumu(), C_UmuKbn.ARI, "子工程更新有無区分");

        TuikaParamForBatchInputBean TuikaParamForBatchInputBean1 = bzProcessUpdateForBatchInputBeanList.get(0).getTuikaParamForBatchInputBean();
        exStringEquals(TuikaParamForBatchInputBean1.getSyono(), "17810000016", "証券番号");
        exStringEquals(TuikaParamForBatchInputBean1.getMosno(), "791112220", "申込番号");

    }

}
