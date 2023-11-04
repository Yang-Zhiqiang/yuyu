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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiMynumberCBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * マイナンバー申告書（Ｃ票）編集のメソッド{@link EditMynumberC#exec(EditMynumberCBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditMynumberCTest_exec {

    @Inject
    private EditMynumberC editMynumberC;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_マイナンバー申告書（Ｃ票）編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditMynumberCTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk082", "TITLE"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk082", "TITLE_ZOUYO"));

    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("1");

        try {
            editMynumberC.exec(editMynumberCBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("1");

        try {
            editMynumberC.exec(editMynumberCBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("1");

        try {
            editMynumberC.exec(editMynumberCBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn(null);

        try {
            editMynumberC.exec(editMynumberCBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='mntyouhyouptn'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("");

        try {
            editMynumberC.exec(editMynumberCBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='mntyouhyouptn'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("6");

        try {
            editMynumberC.exec(editMynumberCBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='mntyouhyouptn'", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_B1() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("1");

        ReportServicesBean reportServicesBean = editMynumberC.exec(editMynumberCBean);

        SiMynumberCBean siMynumberCBean = (SiMynumberCBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.getValue())[0]);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11810111118", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20160727), "処理日付");
        exStringEquals(siMynumberCBean.getIrTyouhyoutitle(), "マイナンバー（個人番号）の申告書", "（ＩＲ）帳票タイトル");
        exStringEquals(siMynumberCBean.getIrSyono(), "11810111118", "（ＩＲ）証券番号");
        exClassificationEquals(siMynumberCBean.getIrSinkokurukthyjumu(), C_UmuKbn.ARI, "（ＩＲ）申告欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrSinkokursksyahyjumu(), C_UmuKbn.NONE, "（ＩＲ）申告欄（請求者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrukthyjumu(), C_UmuKbn.ARI, "（ＩＲ）委任欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrkykhyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（契約者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrsksyahyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（請求者）表示有無");

    }

    @Test
    @TestOrder(80)
    public void testExec_B2() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("2");

        ReportServicesBean reportServicesBean = editMynumberC.exec(editMynumberCBean);

        SiMynumberCBean siMynumberCBean = (SiMynumberCBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.getValue())[0]);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11810111118", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20160727), "処理日付");
        exStringEquals(siMynumberCBean.getIrTyouhyoutitle(), "マイナンバー（個人番号）の申告書", "（ＩＲ）帳票タイトル");
        exStringEquals(siMynumberCBean.getIrSyono(), "11810111118", "（ＩＲ）証券番号");
        exClassificationEquals(siMynumberCBean.getIrSinkokurukthyjumu(), C_UmuKbn.ARI, "（ＩＲ）申告欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrSinkokursksyahyjumu(), C_UmuKbn.NONE, "（ＩＲ）申告欄（請求者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrukthyjumu(), C_UmuKbn.ARI, "（ＩＲ）委任欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrkykhyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（契約者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrsksyahyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（請求者）表示有無");
    }

    @Test
    @TestOrder(90)
    public void testExec_B3() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("4");

        ReportServicesBean reportServicesBean = editMynumberC.exec(editMynumberCBean);

        SiMynumberCBean siMynumberCBean = (SiMynumberCBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.getValue())[0]);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11810111118", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20160727), "処理日付");
        exStringEquals(siMynumberCBean.getIrTyouhyoutitle(), "マイナンバー（個人番号）の申告書", "（ＩＲ）帳票タイトル");
        exStringEquals(siMynumberCBean.getIrSyono(), "11810111118", "（ＩＲ）証券番号");
        exClassificationEquals(siMynumberCBean.getIrSinkokurukthyjumu(), C_UmuKbn.ARI, "（ＩＲ）申告欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrSinkokursksyahyjumu(), C_UmuKbn.NONE, "（ＩＲ）申告欄（請求者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrukthyjumu(), C_UmuKbn.ARI, "（ＩＲ）委任欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrkykhyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（契約者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrsksyahyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（請求者）表示有無");
    }

    @Test
    @TestOrder(100)
    public void testExec_B4() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160727));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111118");
        editMynumberCBean.setMntyouhyouptn("3");

        ReportServicesBean reportServicesBean = editMynumberC.exec(editMynumberCBean);

        SiMynumberCBean siMynumberCBean = (SiMynumberCBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.getValue())[0]);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11810111118", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20160727), "処理日付");
        exStringEquals(siMynumberCBean.getIrTyouhyoutitle(), "マイナンバー（個人番号）の申告書", "（ＩＲ）帳票タイトル");
        exStringEquals(siMynumberCBean.getIrSyono(), "11810111118", "（ＩＲ）証券番号");
        exClassificationEquals(siMynumberCBean.getIrSinkokurukthyjumu(), C_UmuKbn.ARI, "（ＩＲ）申告欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrSinkokursksyahyjumu(), C_UmuKbn.NONE, "（ＩＲ）申告欄（請求者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrukthyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrkykhyjumu(), C_UmuKbn.ARI, "（ＩＲ）委任欄（契約者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrsksyahyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（請求者）表示有無");

    }

    @Test
    @TestOrder(110)
    public void testExec_B5() {

        EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20160728));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
        editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editMynumberCBean.setSyono("11810111129");
        editMynumberCBean.setMntyouhyouptn("5");

        ReportServicesBean reportServicesBean = editMynumberC.exec(editMynumberCBean);

        SiMynumberCBean siMynumberCBean = (SiMynumberCBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.getValue())[0]);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11810111129", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20160728), "処理日付");
        exStringEquals(siMynumberCBean.getIrTyouhyoutitle(), "マイナンバー（個人番号）の申告書", "（ＩＲ）帳票タイトル");
        exStringEquals(siMynumberCBean.getIrSyono(), "11810111129", "（ＩＲ）証券番号");
        exClassificationEquals(siMynumberCBean.getIrSinkokurukthyjumu(), C_UmuKbn.NONE, "（ＩＲ）申告欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrSinkokursksyahyjumu(), C_UmuKbn.ARI, "（ＩＲ）申告欄（請求者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrukthyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（受取人）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrkykhyjumu(), C_UmuKbn.NONE, "（ＩＲ）委任欄（契約者）表示有無");
        exClassificationEquals(siMynumberCBean.getIrIninrsksyahyjumu(), C_UmuKbn.ARI, "（ＩＲ）委任欄（請求者）表示有無");

    }
}
