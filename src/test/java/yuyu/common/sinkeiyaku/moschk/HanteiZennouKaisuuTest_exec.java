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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Znnkaisuukekka;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納回数判定クラスのメソッド {@link HanteiZennouKaisuu#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiZennouKaisuuTest_exec {

    private final static String mosNo1 = "861110005";

    private final static String mosNo2 = "861110013";

    private final static String mosNo3 = "861110021";

    private final static String mosNo4 = "861110039";

    private final static String mosNo5 = "861110047";

    private final static String mosNo6 = "861110054";

    private final static String mosNo7 = "861110062";

    private final static String mosNo8 = "861110070";

    private final static String mosNo9 = "980111249";

    private final static String mosNo10 = "980111256";

    private final static String mosNo11 = "980111264";



    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private HanteiZennouKaisuu hanteizennouKaisuu;

    private final static String fileName = "UT_SP_単体テスト仕様書_前納回数判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiZennouKaisuuTest_exec.class, fileName, sheetName);
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
        MockObjectManager.initialize();
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try{
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            hanteizennouKaisuu.exec(mosnaiCheckParam);

        }catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込商品テーブルが存在しません。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_B1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.ZENKI , "前納回数判定結果区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_B2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals( hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.ITIBU , "前納回数判定結果区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_B3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.OVER , "前納回数判定結果区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_B4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.ITIBU , "前納回数判定結果区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_B5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.ITIBU , "前納回数判定結果区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_B6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.TKOVER , "前納回数判定結果区分");

    }

    @Test
    @TestOrder(90)
    public void testExec_B7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.ZENKI_ARI_HUITTI, "前納回数判定結果区分");

    }

    @Test
    @TestOrder(100)
    public void testExec_B8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.ZENKI_NASI_ITTI, "前納回数判定結果区分");

    }

    @Test
    @TestOrder(110)
    public void testExec_B9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.TKZENKI_NASI_ITTI, "前納回数判定結果区分");

    }

    @Test
    @TestOrder(120)
    public void testExec_B10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exClassificationEquals(hanteizennouKaisuu.exec(mosnaiCheckParam) ,
            C_Znnkaisuukekka.TKZENKI_ARI_HUITTI, "前納回数判定結果区分");

    }
}
