package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
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
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約確認依頼書PDF作成クラスのメソッド {@link EditPdfKykKakuninIraisyo#exec(MosnaiCheckParam, HT_KykKak)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPdfKykKakuninIraisyoTest_exec {

    private final static String mosNo1 = "981112220";

    private final static String mosNo2 = "981112238";

    private final static String mosNo3 = "981112246";

    private final static String mosNo4 = "981112253";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約確認依頼書PDF作成";

    private final static String sheetName = "テストデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(EditTblAtukaisya.class).to(EditTblAtukaisyaMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit(){
        EditTblAtukaisyaMockForSinkeiyaku.caller = EditPdfKykKakuninIraisyoTest_exec.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPdfKykKakuninIraisyoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager =
            SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @AfterClass
    public static void testClear() {
        EditTblAtukaisyaMockForSinkeiyaku.caller = null;
        EditTblAtukaisyaMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        EditTblAtukaisyaMockForSinkeiyaku.SYORIPTN = EditTblAtukaisyaMockForSinkeiyaku.TESTPATTERN1;
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        EditPdfKykKakuninIraisyo editPdfKykKakuninIraisyo = SWAKInjector.getInstance(EditPdfKykKakuninIraisyo.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        HT_KykKak kykKak = syoriCTL1.getKykKaks().get(0);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        List<String> list = new ArrayList<>();
        list.add("契約確認ＭＳＧ１契約確認ＭＳＧ１契約確認ＭＳＧ１契約確認ＭＳＧ１契約確認ＭＳＧ１");
        list.add("契約確認ＭＳＧ２契約確認ＭＳＧ２契約確認ＭＳＧ２契約確認ＭＳＧ２契約確認ＭＳＧ２");
        list.add("契約確認ＭＳＧ３契約確認ＭＳＧ３契約確認ＭＳＧ３契約確認ＭＳＧ３契約確認ＭＳＧ３");
        list.add("契約確認ＭＳＧ４契約確認ＭＳＧ４契約確認ＭＳＧ４契約確認ＭＳＧ４契約確認ＭＳＧ４");
        list.add("契約確認ＭＳＧ５契約確認ＭＳＧ５契約確認ＭＳＧ５契約確認ＭＳＧ５契約確認ＭＳＧ５");
        list.add("契約確認ＭＳＧ６契約確認ＭＳＧ６契約確認ＭＳＧ６契約確認ＭＳＧ６契約確認ＭＳＧ６");
        list.add("契約確認ＭＳＧ７契約確認ＭＳＧ７契約確認ＭＳＧ７契約確認ＭＳＧ７契約確認ＭＳＧ７７");
        list.add("契約確認ＭＳＧ８契約確認ＭＳＧ８契約確認ＭＳＧ８契約確認ＭＳＧ８契約確認ＭＳＧ８８");
        list.add("契約確認ＭＳＧ９契約確認ＭＳＧ９契約確認ＭＳＧ９契約確認ＭＳＧ９契約確認ＭＳＧ９９");
        list.add("契約確認ＭＳＧ１０契約確認ＭＳＧ１０契約確認ＭＳＧ１０契約確認ＭＳＧ１０契約確認Ｍ");

        mosnaiCheckParam.setListKykKakuninMsg(list);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfKykKakuninIraisyo");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20151029));

        editPdfKykKakuninIraisyo.exec(mosnaiCheckParam, kykKak);

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        EditTblAtukaisyaMockForSinkeiyaku.SYORIPTN = EditTblAtukaisyaMockForSinkeiyaku.TESTPATTERN1;
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        EditPdfKykKakuninIraisyo editPdfKykKakuninIraisyo = SWAKInjector.getInstance(EditPdfKykKakuninIraisyo.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        HT_KykKak kykKak = syoriCTL.getKykKaks().get(0);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<String> list = new ArrayList<>();
        list.add("契約確認ＭＳＧ１");
        list.add("契約確認ＭＳＧ２");
        list.add("契約確認ＭＳＧ３");
        list.add("契約確認ＭＳＧ４");
        list.add("契約確認ＭＳＧ５");
        list.add("契約確認ＭＳＧ６");
        list.add("契約確認ＭＳＧ７");
        list.add("契約確認ＭＳＧ８");
        list.add("契約確認ＭＳＧ９");
        list.add("契約確認ＭＳＧ１０");
        list.add("契約確認ＭＳＧ１１");

        mosnaiCheckParam.setListKykKakuninMsg(list);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfKykKakuninIraisyo");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20151029));

        editPdfKykKakuninIraisyo.exec(mosnaiCheckParam, kykKak);

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        EditTblAtukaisyaMockForSinkeiyaku.SYORIPTN = EditTblAtukaisyaMockForSinkeiyaku.TESTPATTERN2;
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        EditPdfKykKakuninIraisyo editPdfKykKakuninIraisyo = SWAKInjector.getInstance(EditPdfKykKakuninIraisyo.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        HT_KykKak kykKak = syoriCTL.getKykKaks().get(0);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<String> list = new ArrayList<>();
        list.add("契約確認ＭＳＧ１");

        mosnaiCheckParam.setListKykKakuninMsg(list);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfKykKakuninIraisyo");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20151029));

        editPdfKykKakuninIraisyo.exec(mosnaiCheckParam, kykKak);

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        EditTblAtukaisyaMockForSinkeiyaku.SYORIPTN = EditTblAtukaisyaMockForSinkeiyaku.TESTPATTERN2;
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        EditPdfKykKakuninIraisyo editPdfKykKakuninIraisyo = SWAKInjector.getInstance(EditPdfKykKakuninIraisyo.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        HT_KykKak kykKak = syoriCTL.getKykKaks().get(0);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<String> list = new ArrayList<>();

        mosnaiCheckParam.setListKykKakuninMsg(list);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfKykKakuninIraisyo");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20151029));

        editPdfKykKakuninIraisyo.exec(mosnaiCheckParam, kykKak);
    }
}
