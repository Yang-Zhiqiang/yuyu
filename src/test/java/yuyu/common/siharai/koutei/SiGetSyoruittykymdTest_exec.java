package yuyu.common.siharai.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsMockForSiharai;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForSiharai;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.id.PKBT_GyoumuKouteiInfo;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 支払書類到着日取得のメソッド{@link SiGetSyoruittykymd#exec(String, String, String, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiGetSyoruittykymdTest_exec {

    @Inject
    private SiGetSyoruittykymd siGetSyoruittykymd;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払書類到着日取得";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetImageProps.class).to(BzGetImagePropsMockForSiharai.class);
                bind(IwfImageClient.class).to(IwfImageClientMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzGetImagePropsMockForSiharai.caller = SiGetSyoruittykymdTest_exec.class;
        IwfImageClientMockForSiharai.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.caller = null;
        IwfImageClientMockForSiharai.caller = null;
        BzGetImagePropsMockForSiharai.SYORIPTN = null;
        IwfImageClientMockForSiharai.mode = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiGetSyoruittykymdTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager domManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        domManager.delete(new PKBT_GyoumuKouteiInfo("1"));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();

        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN1;
        IwfImageClientMockForSiharai.mode = "20-01";
        BizDate ymd = siGetSyoruittykymd.exec(null, "123", "11810111118", C_SyoruiCdKbn.BLNK);
        exDateEquals(ymd, null, "書類到着日");

        BzGetImagePropsInBean args = (BzGetImagePropsInBean) MockObjectManager.getArgument(BzGetImageProps.class,
            "exec", 0);
        exStringEquals(args.getKouteiKanriId(), "100010", "工程管理ID");
        exClassificationEquals(args.getSyoruiCd(), C_SyoruiCdKbn.BLNK, "書類コード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();

        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN2;
        IwfImageClientMockForSiharai.mode = "20-01";
        BizDate ymd = siGetSyoruittykymd.exec(null, "123", "11810111118", C_SyoruiCdKbn.BLNK);
        exDateEquals(ymd, BizDate.valueOf("20150716"), "書類到着日");

        BzGetImagePropsInBean args = (BzGetImagePropsInBean) MockObjectManager.getArgument(BzGetImageProps.class,
            "exec", 0);
        exStringEquals(args.getKouteiKanriId(), "100010", "工程管理ID");
        exClassificationEquals(args.getSyoruiCd(), C_SyoruiCdKbn.BLNK, "書類コード");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();

        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN3;
        IwfImageClientMockForSiharai.mode = "20-01";
        BizDate ymd = siGetSyoruittykymd.exec("", "123", "11810111118", C_SyoruiCdKbn.BLNK);
        exDateEquals(ymd, BizDate.valueOf("20150715"), "書類到着日");

        BzGetImagePropsInBean args = (BzGetImagePropsInBean) MockObjectManager.getArgument(BzGetImageProps.class,
            "exec", 0);
        exStringEquals(args.getKouteiKanriId(), "100010", "工程管理ID");
        exClassificationEquals(args.getSyoruiCd(), C_SyoruiCdKbn.BLNK, "書類コード");
    }

    @Test(expected = BizException.class)
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();

        try {
            BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN4;
            IwfImageClientMockForSiharai.mode = "20-01";
            siGetSyoruittykymd.exec("10012", "123", "11810111118", C_SyoruiCdKbn.BLNK);
        } catch (BizException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝支払書類到着日取得、API＝イメージプロパティ取得、エラーコード＝IWF0002", "IWFエラー");

            BzGetImagePropsInBean args = (BzGetImagePropsInBean) MockObjectManager.getArgument(
                BzGetImageProps.class, "exec", 0);
            exStringEquals(args.getKouteiKanriId(), "10012", "工程管理ID");
            exClassificationEquals(args.getSyoruiCd(), C_SyoruiCdKbn.BLNK, "書類コード");

            throw e;
        }
    }
}
