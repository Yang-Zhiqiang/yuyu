package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備帳票ＰＤＦ作成クラスのメソッド {@link EditPdfHubiTyouhyou#exec(String, MosnaiCheckParam, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPdfHubiTyouhyouTest_exec {

    private final static String mosNo1 = "980000012";

    private final static String mosNo2 = "980000020";

    private final static String mosNo3 = "980000038";

    private final static String mosNo4 = "980000046";

    private final static String mosNo5 = "980000053";

    private final static String mosNo6 = "980000061";

    private final static String mosNo7 = "980000079";

    private final static String mosNo8 = "980000087";

    private final static String mosNo9 = "980000095";

    private final static String mosNo10 = "980000103";

    private final static String mosNo12 = "980000111";

    private final static String mosNo13 = "860000017";

    private final static String mosNo14 = "860000025";

    private final static String mosNo15 = "860000090";

    private final static String key1 = "00000000001";

    private final static String key2 = "00000000002";

    private final static String key3 = "00000000003";

    private final static String key4 = "00000000004";

    private final static String key5 = "00000000005";

    private final static String key6 = "00000000006";

    private final static String key7 = "00000000007";

    private final static String key8 = "00000000008";

    private final static String key9 = "00000000009";

    private final static String key10 = "00000000010";

    private final static String key12 = "00000000012";

    private final static String key13 = "00000000013";

    private final static String key14 = "00000000014";

    private final static String key15 = "00000000015";

    private final static BizDate hasinymd = BizDate.valueOf(20160508);

    @Inject
    private EditPdfHubiTyouhyou editPdfHubiTyouhyou;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_不備帳票ＰＤＦ作成";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPdfHubiTyouhyouTest_exec.class, fileName, sheetName);
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
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHubiNaiyou());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHubiKoumoku());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkSeibiSijiNaiyou());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        String tyouhyouKey =editPdfHubiTyouhyou.exec(key1, mosnaiCheckParam, hasinymd);


        exStringEquals(tyouhyouKey, "", "帳票キー");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        String tyouhyouKey = editPdfHubiTyouhyou.exec(key2, mosnaiCheckParam, hasinymd);


        exStringEquals(tyouhyouKey, "", "帳票キー");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        String tyouhyouKey = editPdfHubiTyouhyou.exec(key3, mosnaiCheckParam, hasinymd);

        HT_SkHubi skHubi = syoriCTL1.getSkHubiByHubisikibetukey("00000000003");

        List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetails();

        exNumericEquals(0, skHubiDetailLst.size(), "新契約不備詳細テーブルリスト件数");


        exStringEquals(tyouhyouKey, "", "帳票キー");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key4, mosnaiCheckParam, hasinymd);

        HT_SkHubi skHubi = syoriCTL1.getSkHubiByHubisikibetukey("00000000004");

        List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetails();

        exNumericEquals(1, skHubiDetailLst.size(), "新契約不備詳細テーブルリスト件数");
        exDateEquals(hasinymd, skHubiDetailLst.get(0).getHasinymd(), "発信日");
        exStringEquals("20160508111100000", skHubiDetailLst.get(0).getGyoumuKousinTime(), "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("SkHubiTouroku");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key5, mosnaiCheckParam, hasinymd);
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("SkHubiTouroku");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key6, mosnaiCheckParam, BizDate.valueOf(20161020));

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key7, mosnaiCheckParam, hasinymd);

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key8, mosnaiCheckParam, hasinymd);

        HT_SkHubi skHubi = syoriCTL1.getSkHubiByHubisikibetukey("00000000008");

        List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetails();

        exNumericEquals(3, skHubiDetailLst.size(), "新契約不備詳細テーブルリスト件数");
        exDateEquals(hasinymd, skHubiDetailLst.get(0).getHasinymd(), "発信日");
        exStringEquals("20160508111100000", skHubiDetailLst.get(0).getGyoumuKousinTime(), "業務用更新時間");
        exDateEquals(hasinymd, skHubiDetailLst.get(1).getHasinymd(), "発信日");
        exStringEquals("20160508111100000", skHubiDetailLst.get(1).getGyoumuKousinTime(), "業務用更新時間");
        exDateEquals(hasinymd, skHubiDetailLst.get(2).getHasinymd(), "発信日");
        exStringEquals("20160508111100000", skHubiDetailLst.get(2).getGyoumuKousinTime(), "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key9, mosnaiCheckParam, hasinymd);

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key10, mosnaiCheckParam, hasinymd);
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.execBatch(key2, mosnaiCheckParam, hasinymd);
    }


    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo12);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key12, mosnaiCheckParam, hasinymd);

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo13);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key13, mosnaiCheckParam, hasinymd);

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo14);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key14, mosnaiCheckParam, hasinymd);

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo15);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHubiTyouhyou");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160508111100000");
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());

        editPdfHubiTyouhyou.exec(key15, mosnaiCheckParam, hasinymd);

    }
}
