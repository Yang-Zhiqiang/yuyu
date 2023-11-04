package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link Siinhantei}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiinhanteiTest_exec {

    @Inject
    private Siinhantei siinhantei;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_死因判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiinhanteiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllByoumei());
        siharaiDomManager.delete(siharaiDomManager.getAllSiinHantei());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_SiinKbn result = siinhantei.hanteiGeninKbn(null);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_SiinKbn result = siinhantei.hanteiGeninKbn(C_GeninKbn.SP);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_SiinKbn result = siinhantei.hanteiGeninKbn(C_GeninKbn.SG);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_SiinKbn result = siinhantei.hanteiGeninKbn(C_GeninKbn.JS);

        exClassificationEquals(result, C_SiinKbn.JS, "死因区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_SiinKbn result = siinhantei.hanteiGeninKbn(C_GeninKbn.BLNK);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_B1() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000001");

        C_SiinKbn result = siinhantei.hanteiSkuke(null, C_GeninKbn.BSSS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_B2() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000001");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, null,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_B3() {

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.BSSS,
            null, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_B4() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000001");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.BSSS,
            byoumeiTourokuNoList, null, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_B5() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000001");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.BSSS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, null);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_B6() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000001");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.BSSS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_B7() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.KTJK,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_B8() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000003");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.TENTOU,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.JS, "死因区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_B9() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000001");
        byoumeiTourokuNoList.add("000002");
        byoumeiTourokuNoList.add("000003");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.DKS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_B10() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000004");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.KKOKS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_B11() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.TSK,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_B12() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.TDK,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_B13() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.SONOTAFR,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_B14() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.JS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(200)
    public void testExec_B15() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.TST,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.JS, "死因区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_B16() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.SONOTAFS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.JS, "死因区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_B17() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.FSS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.JS, "死因区分");
    }

    @Test
    @TestOrder(230)
    public void testExec_B18() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.BLNK,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(240)
    public void testExec_B19() {

        List<String> byoumeiTourokuNoList = new ArrayList<>();
        byoumeiTourokuNoList.add("000002");

        C_SiinKbn result = siinhantei.hanteiSkuke(C_GeninKbn.SP, C_GeninKbn.BSSS,
            byoumeiTourokuNoList, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(250)
    public void testExec_C1() {

        C_SiinKbn result = siinhantei.hanteiSatei(null, C_SyorikekkaKbn.SIHARAI);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(260)
    public void testExec_C2() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.SP, null);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }

    @Test
    @TestOrder(270)
    public void testExec_C3() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.SP, C_SyorikekkaKbn.SIHARAI);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(280)
    public void testExec_C4() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.SP, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(290)
    public void testExec_C5() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.SP, C_SyorikekkaKbn.SATEI_3);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(300)
    public void testExec_C6() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.SG, C_SyorikekkaKbn.SIHARAI);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(310)
    public void testExec_C7() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.SG, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(320)
    public void testExec_C8() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.SG, C_SyorikekkaKbn.SATEI_3);

        exClassificationEquals(result, C_SiinKbn.SG, "死因区分");
    }

    @Test
    @TestOrder(330)
    public void testExec_C9() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.JS, C_SyorikekkaKbn.SIHARAI);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(340)
    public void testExec_C10() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.JS, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);

        exClassificationEquals(result, C_SiinKbn.SP, "死因区分");
    }

    @Test
    @TestOrder(350)
    public void testExec_C11() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.JS, C_SyorikekkaKbn.SATEI_3);

        exClassificationEquals(result, C_SiinKbn.JS, "死因区分");
    }

    @Test
    @TestOrder(360)
    public void testExec_C12() {

        C_SiinKbn result = siinhantei.hanteiSatei(C_SiinKbn.BLNK, C_SyorikekkaKbn.SIHARAI);

        exClassificationEquals(result, C_SiinKbn.BLNK, "死因区分");
    }
}
