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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 取消請求書PDF作成クラスのメソッド {@link EditPdfTrksseikyu#exec(MosnaiCheckParam, C_KouzasyuruiKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPdfTrksseikyuTest_exec {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_取消請求書PDF作成";

    private final static String sheetName = "テストデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(EditDairitenAtesaki.class).to(EditDairitenAtesakiMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit(){
        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.caller = EditPdfTrksseikyuTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        EditDairitenAtesakiMockForSinkeiyaku.caller = null;
        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPdfTrksseikyuTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);

        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        try {
            editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);
        } catch(CommonBizAppException e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112220", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {
        MockObjectManager.initialize();
        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);

        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160203"));
        editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);

        EditDairitenAtesakiBean editDairitenAtesakiBean= (EditDairitenAtesakiBean)MockObjectManager.getArgument(EditDairitenAtesakiMockForSinkeiyaku.class, "exec", 0);
        exClassificationEquals(editDairitenAtesakiBean.getSyoruiCdKbn(), C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU, "書類コード区分");
        exStringEquals(editDairitenAtesakiBean.getMosDairiten().getMosno(), "791112238", "申込番号");
        exNumericEquals(editDairitenAtesakiBean.getMosDairiten().getRenno(), 1, "連番");
        exDateEquals(editDairitenAtesakiBean.getHassouYmd(), BizDate.valueOf(20160203), "発送年月日");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);

        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160203"));
        editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {
        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);

        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160203"));
        editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("981112220");
        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);
        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20200220"));
        editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("981112238");
        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);
        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20200220"));
        editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("981112246");
        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);
        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20200220"));
        editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("981112261");
        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);
        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20200220"));
        editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("981112279");

        EditPdfTrksseikyu editPdfTrksseikyu = SWAKInjector.getInstance(EditPdfTrksseikyu.class);
        C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20200220"));
        editPdfTrksseikyu.exec(mosnaiCheckParam, kouzasyuruiKbn);
    }
}