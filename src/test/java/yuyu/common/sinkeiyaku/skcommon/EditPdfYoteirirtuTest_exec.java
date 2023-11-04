
package yuyu.common.sinkeiyaku.skcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 予定利率変更連絡票PDF作成クラスのメソッド {@link EditPdfYoteirirtu#exec(MosnaiCheckParam,
 * BizNumber, BizNumber, C_UmuKbn, BizNumber, BizNumber, BizNumber, BizNumber, C_UmuKbn, BizNumber, BizNumber, C_UmuKbn,
 * BizNumber, BizNumber, C_UmuKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPdfYoteirirtuTest_exec extends AbstractTest{

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_予定利率変更連絡票PDF作成";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPdfYoteirirtuTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllTyouhyourenrakusaki());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(EditDairitenAtesaki.class).to(EditDairitenAtesakiMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {
        EditDairitenAtesakiMockForSinkeiyaku.caller = EditPdfYoteirirtuTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        EditDairitenAtesakiMockForSinkeiyaku.caller = null;

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = null;
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20170424));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.ARI,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.ARI,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.ARI,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20170424));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.ARI,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.ARI,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.ARI,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20170424));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.ARI,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.ARI,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.ARI,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.ARI,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.ARI,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.ARI,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

        EditDairitenAtesakiBean editDairitenAtesakiBean = (EditDairitenAtesakiBean) MockObjectManager.getArgument(EditDairitenAtesakiMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(editDairitenAtesakiBean.getSyoruiCdKbn(), C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU, "書類コード区分");
        assertNull(editDairitenAtesakiBean.getMosDairiten());
        exDateEquals(editDairitenAtesakiBean.getHassouYmd(), BizDate.valueOf(20180319), "発送年月日");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.NONE,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.ARI,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.ARI,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            null, null, C_UmuKbn.ARI,
            null, null,
            null, null, C_UmuKbn.ARI,
            null, null, C_UmuKbn.ARI,
            null, null, C_UmuKbn.ARI,
            null, null, C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.ARI,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.ARI,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.NONE,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.ARI,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.NONE,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.ARI,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.ARI,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.NONE,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.NONE,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.NONE,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.ARI,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.ARI,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.1), BizNumber.valueOf(0.2), C_UmuKbn.ARI,
            BizNumber.valueOf(0.2), BizNumber.valueOf(0.3),
            BizNumber.valueOf(0.1), BizNumber.valueOf(0.2), C_UmuKbn.NONE,
            BizNumber.valueOf(0.3), BizNumber.valueOf(0.4), C_UmuKbn.ARI,
            BizNumber.valueOf(0.4), BizNumber.valueOf(0.5), C_UmuKbn.NONE,
            BizNumber.valueOf(0.5), BizNumber.valueOf(0.6), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.1), BizNumber.valueOf(0.2), C_UmuKbn.ARI,
            BizNumber.valueOf(0.2), BizNumber.valueOf(0.3),
            BizNumber.valueOf(0.1), BizNumber.valueOf(0.2), C_UmuKbn.NONE,
            BizNumber.valueOf(0.3), BizNumber.valueOf(0.4), C_UmuKbn.NONE,
            BizNumber.valueOf(0.4), BizNumber.valueOf(0.5), C_UmuKbn.ARI,
            BizNumber.valueOf(0.5), BizNumber.valueOf(0.6), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.NONE,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.NONE,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.NONE,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.ARI,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.ARI,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.ARI,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000181");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.NONE,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.NONE,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.NONE,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000199");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.NONE,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.NONE,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.NONE,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000264");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.NONE,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.NONE,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.NONE,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.155), BizNumber.valueOf(0.255), C_UmuKbn.ARI,
            BizNumber.valueOf(0.255), BizNumber.valueOf(0.355),
            BizNumber.valueOf(0.254), BizNumber.valueOf(0.354), C_UmuKbn.NONE,
            BizNumber.valueOf(0.354), BizNumber.valueOf(0.454), C_UmuKbn.ARI,
            BizNumber.valueOf(0.454), BizNumber.valueOf(0.554), C_UmuKbn.ARI,
            BizNumber.valueOf(0.554), BizNumber.valueOf(0.654), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            null, null, C_UmuKbn.ARI,
            null, null,
            null, null, C_UmuKbn.ARI,
            null, null, C_UmuKbn.ARI,
            null, null, C_UmuKbn.ARI,
            null, null, C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.NONE,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.NONE,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.NONE,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.NONE,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.ARI);

    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.ARI,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.ARI,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.ARI,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.ARI);

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.NONE,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.ARI,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.ARI,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.ARI);

    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.ARI,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.ARI,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.ARI,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.ARI);

    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.ARI,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.ARI,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.ARI,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.NONE);

    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000215");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.NONE,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.ARI,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.ARI,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.ARI);

    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {

        MockObjectManager.initialize();

        EditDairitenAtesakiMockForSinkeiyaku.SYORIPTN = EditDairitenAtesakiMockForSinkeiyaku.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180317));
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000223");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20180317));
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfYoteirirtu");
        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

        editPdfYoteirirtu.exec(mosnaiCheckParam,
            BizNumber.valueOf(0.15), BizNumber.valueOf(0.25), C_UmuKbn.ARI,
            BizNumber.valueOf(0.25), BizNumber.valueOf(0.35),
            BizNumber.valueOf(0.24), BizNumber.valueOf(0.34), C_UmuKbn.NONE,
            BizNumber.valueOf(0.35), BizNumber.valueOf(0.45), C_UmuKbn.ARI,
            BizNumber.valueOf(0.45), BizNumber.valueOf(0.55), C_UmuKbn.ARI,
            BizNumber.valueOf(0.55), BizNumber.valueOf(0.65), C_UmuKbn.NONE);

    }

}