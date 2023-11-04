package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.def.classification.C_LincdatasousinKbn;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * LINC該当判定クラスのメソッド {@link LINC該当判定#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiLINCTest_exec {

    private final static String mosNo1 = "971112222";
    private final static String mosNo2 = "971112230";
    private final static String mosNo3 = "971112248";
    private final static String mosNo4 = "971112255";
    private final static String mosNo5 = "971112263";
    private final static String mosNo6 = "971112271";
    private final static String mosNo7 = "971112289";
    private final static String mosNo8 = "971112297";
    private final static String mosNo9 = "971112305";
    private final static String mosNo10 = "971112313";
    private final static String mosNo11 = "971112321";
    private final static String mosNo12 = "971112339";
    private final static String mosNo13 = "971112347";
    private final static String mosNo14 = "971112354";
    private final static String mosNo15 = "971112362";
    private final static String mosNo16 = "971112370";
    private final static String mosNo17 = "971112388";
    private final static String mosNo18 = "971112396";
    private final static String mosNo19 = "971112404";
    private final static String mosNo20 = "971112412";
    private final static String mosNo21 = "971112420";
    private final static String mosNo22 = "971112438";
    private final static String mosNo23 = "971112446";
    private final static String mosNo24 = "971112453";
    private final static String mosNo25 = "971112461";
    private final static String mosNo26 = "971112479";
    private final static String mosNo27 = "971112487";
    private final static String mosNo28 = "971112495";
    private final static String mosNo29 = "971112503";
    private final static String mosNo30 = "971112511";
    private final static String mosNo31 = "860002005";
    private final static String mosNo32 = "860002088";
    private final static String mosNo33 = "860000041";
    private final static String mosNo34 = "860000058";
    private final static String mosNo35 = "860000066";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_LINC該当判定";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HanteiZennouKaisuu.class).to(HanteiZennouKaisuuMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        HanteiZennouKaisuuMockForSinkeiyaku.caller = HanteiLINCTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.caller = null;
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiLINCTest_exec.class, fileName, sheetName);
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

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.TOUROKU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN =HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINHUYOU, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.TOUROKU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);


        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINHUYOU, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.SAITOUROKU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);


        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINHUYOU, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.SAITOUROKU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);


        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);


        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);


        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAI, "ＬＩＮＣ状況区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);


        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINHUYOU, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.SAKUJO, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.NONE);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.MIHANTEI, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), null, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.MISETTEI, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);


        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINHUYOU, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.MISETTEI, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.TOUROKU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo12);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);


        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.HANEIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), null, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(121)
    public void testExec_A13() {
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo31);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.MIHANTEI, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), null, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.MISETTEI, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(122)
    public void testExec_A14() {
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo33);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), null, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(123)
    public void testExec_A15() {
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo34);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), null, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(124)
    public void testExec_A16() {
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo35);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), null, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_B1() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo13);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_B2() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo14);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_B3() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo15);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_B4() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo16);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_B5() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo17);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_B6() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo18);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_B7() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo19);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(200)
    public void testExec_B8() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo20);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_B9() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo21);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_B10() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo22);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(230)
    public void testExec_B11() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo23);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(240)
    public void testExec_B12() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo24);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(250)
    public void testExec_B13() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo25);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(260)
    public void testExec_B14() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo26);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(270)
    public void testExec_B15() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo27);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), null, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(280)
    public void testExec_B16() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo28);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINHUYOU, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.SAITOUROKU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(290)
    public void testExec_B17() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo29);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINHUYOU, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.SAITOUROKU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(300)
    public void testExec_B18() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo30);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }

    @Test
    @TestOrder(310)
    public void testExec_B19() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo32);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINC hanteiLINC = SWAKInjector.getInstance(HanteiLINC.class);
        hanteiLINC.exec(mosnaiCheckParam);
        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        exClassificationEquals(syoriCTL.getLincgthtkekkbn(), C_LincgthtkekKbn.SYOUKAITAISYOU, "ＬＩＮＣ該当判定結果区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLincdatasousinkbn(), C_LincdatasousinKbn.HENKOU, "ＬＩＮＣデータ送信区分");
    }
}
