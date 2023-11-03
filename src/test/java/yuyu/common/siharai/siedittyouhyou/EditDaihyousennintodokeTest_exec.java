package yuyu.common.siharai.siedittyouhyou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiDhysntdkBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 代表選任届編集のメソッド{@link EditDaihyousennintodoke#exec(EditDaihyousennintodokeBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditDaihyousennintodokeTest_exec {
    @Inject
    private EditDaihyousennintodoke editDaihyousennintodoke;

    private final static String fileName = "UT_SP_単体テスト仕様書_代表選任届編集";

    private final static String sheetName = "テストデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(EditDaihyousennintodokeTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("共通データ", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector
            .getInstance(EditDaihyousennintodokeBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editDaihyousennintodoke.exec(editDaihyousennintodokeBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector
            .getInstance(EditDaihyousennintodokeBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editDaihyousennintodoke.exec(editDaihyousennintodokeBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector
            .getInstance(EditDaihyousennintodokeBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editDaihyousennintodoke.exec(editDaihyousennintodokeBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testExec_B1_inData()  {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_B1() {

        EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector
            .getInstance(EditDaihyousennintodokeBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        editDaihyousennintodokeBean.setSyoNo("10000000001");
        editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        ReportServicesBean reportServicesBean = editDaihyousennintodoke.exec(editDaihyousennintodokeBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");
        SiDhysntdkBean siDhysntdkBean = (SiDhysntdkBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_DAIHYOU.getValue()))[0];
        exStringEquals(siDhysntdkBean.getIrMsg1(), null, "（ＩＲ）メッセージ１");
        exStringEquals(
            siDhysntdkBean.getIrMsg2(), null, "（ＩＲ）メッセージ2");
        exStringEquals(siDhysntdkBean.getIrMsg3(), null, "（ＩＲ）メッセージ3");
        exStringEquals(siDhysntdkBean.getIrMsg4(), null, "（ＩＲ）メッセージ4");
        exStringEquals(siDhysntdkBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        SiharaiDomManager mgr = SWAKInjector.getInstance(SiharaiDomManager.class);
        mgr.delete(mgr.getSiTyouhyoumsg("hk040", "ANNAI_NAIYOU", 1));
        mgr.delete(mgr.getSiTyouhyoumsg("hk040", "ANNAI_NAIYOU", 2));
        mgr.delete(mgr.getSiTyouhyoumsg("hk040", "ANNAI_NAIYOU", 3));
    }
    @Test
    @TestOrder(49)
    @Transactional
    public void testExec_B2_inData()  {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_B2() {

        EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector
            .getInstance(EditDaihyousennintodokeBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        editDaihyousennintodokeBean.setSyoNo("10000000001");
        editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        ReportServicesBean reportServicesBean = editDaihyousennintodoke.exec(editDaihyousennintodokeBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");
        SiDhysntdkBean siDhysntdkBean = (SiDhysntdkBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_DAIHYOU.getValue()))[0];
        exStringEquals(siDhysntdkBean.getIrMsg1(), "テストメッセージ１", "（ＩＲ）メッセージ１");
        exStringEquals(siDhysntdkBean.getIrMsg2(), null, "（ＩＲ）メッセージ2");
        exStringEquals(siDhysntdkBean.getIrMsg3(), null, "（ＩＲ）メッセージ3");
        exStringEquals(siDhysntdkBean.getIrMsg4(), null, "（ＩＲ）メッセージ4");
        exStringEquals(siDhysntdkBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        SiharaiDomManager mgr = SWAKInjector.getInstance(SiharaiDomManager.class);
        mgr.delete(mgr.getSiTyouhyoumsg("hk031", "ANNAI_NAIYOU", 1));
    }

    @Test
    @TestOrder(59)
    @Transactional
    public void testExec_B3_inData()  {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_B3() {

        EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector
            .getInstance(EditDaihyousennintodokeBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        editDaihyousennintodokeBean.setSyoNo("10000000001");
        editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        ReportServicesBean reportServicesBean = editDaihyousennintodoke.exec(editDaihyousennintodokeBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");
        SiDhysntdkBean siDhysntdkBean = (SiDhysntdkBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_DAIHYOU.getValue()))[0];
        exStringEquals(siDhysntdkBean.getIrMsg1(), "　下記契約の請求に当たり全員の協議により、私が代表者となりましたので、下記の個人情報取り扱いに他", "（ＩＲ）メッセージ１");
        exStringEquals(siDhysntdkBean.getIrMsg2(), "の全員とともに同意のうえお届けします。つきましては、全額を私にお支払いください。万一、本件に関し", "（ＩＲ）メッセージ2");
        exStringEquals(siDhysntdkBean.getIrMsg3(), "異議を申し立てる者がありましても、当方で解決し、貴社に対しては一切ご迷惑をおかけいたしません。", "（ＩＲ）メッセージ3");
        exStringEquals(siDhysntdkBean.getIrMsg4(), null, "（ＩＲ）メッセージ4");
        exStringEquals(siDhysntdkBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        SiharaiDomManager mgr = SWAKInjector.getInstance(SiharaiDomManager.class);
        mgr.delete(mgr.getSiTyouhyoumsg("hk031", "ANNAI_NAIYOU", 1));
        mgr.delete(mgr.getSiTyouhyoumsg("hk031", "ANNAI_NAIYOU", 2));
        mgr.delete(mgr.getSiTyouhyoumsg("hk031", "ANNAI_NAIYOU", 3));
    }

    @Test
    @TestOrder(69)
    @Transactional
    public void testExec_B4_inData()  {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }
    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_B4() {

        EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector
            .getInstance(EditDaihyousennintodokeBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        editDaihyousennintodokeBean.setSyoNo("10000000001");
        editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        ReportServicesBean reportServicesBean = editDaihyousennintodoke.exec(editDaihyousennintodokeBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");
        SiDhysntdkBean siDhysntdkBean = (SiDhysntdkBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_DAIHYOU.getValue()))[0];
        exStringEquals(siDhysntdkBean.getIrMsg1(), "テストメッセージ１", "（ＩＲ）メッセージ１");
        exStringEquals(siDhysntdkBean.getIrMsg2(), "テストメッセージ２", "（ＩＲ）メッセージ2");
        exStringEquals(siDhysntdkBean.getIrMsg3(), "テストメッセージ３", "（ＩＲ）メッセージ3");
        exStringEquals(siDhysntdkBean.getIrMsg4(), "テストメッセージ４", "（ＩＲ）メッセージ4");
        exStringEquals(siDhysntdkBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        SiharaiDomManager mgr = SWAKInjector.getInstance(SiharaiDomManager.class);
        mgr.delete(mgr.getSiTyouhyoumsg("hk031", "ANNAI_NAIYOU", 1));
        mgr.delete(mgr.getSiTyouhyoumsg("hk031", "ANNAI_NAIYOU", 2));
        mgr.delete(mgr.getSiTyouhyoumsg("hk031", "ANNAI_NAIYOU", 3));
        mgr.delete(mgr.getSiTyouhyoumsg("hk031", "ANNAI_NAIYOU", 4));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        testDataAndTblMap.clear();

    }
}
