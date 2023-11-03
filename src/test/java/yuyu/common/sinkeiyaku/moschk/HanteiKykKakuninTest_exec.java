package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KykkakiraisyoyhKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約確認該当判定クラスのメソッド {@link HanteiKykKakunin#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiKykKakuninTest_exec {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約確認該当判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiKykKakuninTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetHutuuSibouS.class).to(SetHutuuSibouSMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        SetHutuuSibouSMockForSinkeiyaku.caller = HanteiKykKakuninTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        SetHutuuSibouSMockForSinkeiyaku.caller = null;
        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try{
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
            hanteiKykKakunin.exec(mosnaiCheckParam);

        } catch(CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112220", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        YuyuSinkeiyakuConfig.getInstance().setKykKakKjnSbS(BizCurrency.valueOf(-1));
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.YOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 1, "件数");
        exStringEquals(msgList.get(0), "決定前契約確認対象です。  逆選択不安判定　死亡保険金額 -1円オーバー　職業 職業名１", "契約確認ＭＳＧ");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        YuyuSinkeiyakuConfig.getInstance().setKykKakKjnSbS(BizCurrency.valueOf(-1));
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.YOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 1, "件数");
        exStringEquals(msgList.get(0), "決定前契約確認対象です。  逆選択不安判定　死亡保険金額 -1円オーバー　職業 060", "契約確認ＭＳＧ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        YuyuSinkeiyakuConfig.getInstance().setKykKakKjnSbS(BizCurrency.valueOf(3));
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        YuyuSinkeiyakuConfig.getInstance().setKykKakKjnSbS(BizCurrency.valueOf(3));
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        YuyuSinkeiyakuConfig.getInstance().setKykKakKjnSbS(BizCurrency.valueOf(-1));
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.YOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 1, "件数");
        exStringEquals(msgList.get(0), "決定前契約確認対象です。  逆選択不安判定　死亡保険金額 -1円オーバー　職業 620", "契約確認ＭＳＧ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        YuyuSinkeiyakuConfig.getInstance().setKykKakKjnSbS(BizCurrency.valueOf(-1));
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.YOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 1, "件数");
        exStringEquals(msgList.get(0), "決定前契約確認対象です。  逆選択不安判定　死亡保険金額 -1円オーバー　職業 670", "契約確認ＭＳＧ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800008");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        YuyuSinkeiyakuConfig.getInstance().setKykKakKjnSbS(BizCurrency.valueOf(-1));
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.YOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 1, "件数");
        exStringEquals(msgList.get(0), "決定前契約確認対象です。  逆選択不安判定　死亡保険金額 -1円オーバー　職業 職業名１", "契約確認ＭＳＧ");

    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800016");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800024");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KETHORYU_KAKUNIN, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800032");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.KAKUNIN_SUMI, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800040");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        HanteiKykKakunin hanteiKykKakunin = SWAKInjector.getInstance(HanteiKykKakunin.class);
        hanteiKykKakunin.exec(mosnaiCheckParam);

        exClassificationEquals(syoriCTL.getKykkakjkkbn(), C_KykkakjkKbn.SEIRITUGO_KAK_IRAISU, "契約確認状況区分");
        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

        List<String> msgList = mosnaiCheckParam.getListKykKakuninMsg();
        exNumericEquals(msgList.size(), 0, "件数");
    }
}