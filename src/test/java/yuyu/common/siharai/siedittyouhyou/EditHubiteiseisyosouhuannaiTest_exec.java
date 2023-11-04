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
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiSouhuannaihubiBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備訂正書の送付案内編集のメソッド{@link EditHubiteiseisyosouhuannai#exec(EditHubiteiseisyosouhuannaiBean)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditHubiteiseisyosouhuannaiTest_exec {

    @Inject
    private EditHubiteiseisyosouhuannai editHubiteiseisyosouhuannai;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_不備訂正書の送付案内編集";
    private final static String sheetName = "テストデータ";
    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(EditHubiteiseisyosouhuannaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SiharaiDomManager mgr = SWAKInjector.getInstance(SiharaiDomManager.class);
        mgr.delete(mgr.getAllSiTyouhyoumsg());
        testDataAndTblMap = null;

    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);

        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);

        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);

        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editHubiteiseisyosouhuannaiBean.setSeikyuusyaInfoBean(null);

        try {
            editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyaInfoBean'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editHubiteiseisyosouhuannaiBean.setToiawaseInfoBean(null);
        editHubiteiseisyosouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        try {
            editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='toiawaseInfoBean'", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_B1() {

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("12310426");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj("請求者住所２");
        seikyuusyaInfoBean.setTsinadr3kj("請求者住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");

        ToiawaseInfoBean pToiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        pToiawaseInfoBean.setSosikiNm("組織名");
        pToiawaseInfoBean.setTsinyno("45610426");
        pToiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        pToiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        pToiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        pToiawaseInfoBean.setTsintelno("04-1234-5678");
        pToiawaseInfoBean.setTelUktkKanouTime("095959");
        pToiawaseInfoBean.setTelUktkkanouTimeHigou("135959");

        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);

        editHubiteiseisyosouhuannaiBean.setSyono("10000000001");
        editHubiteiseisyosouhuannaiBean.setHhknnmkj("被保険者名");
        editHubiteiseisyosouhuannaiBean.setRenrakuarea("123456789");
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editHubiteiseisyosouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        editHubiteiseisyosouhuannaiBean.setToiawaseInfoBean(pToiawaseInfoBean);

        ReportServicesBean reportServicesBean = editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU.getValue()))[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "12310426", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "請求者住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "請求者住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "請求者", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "45610426", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "04-1234-5678", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "",
            "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "",
            "（ＩＲ）問合せ先電話受付可能時間２");

        SiSouhuannaihubiBean siSouhuannaihubiBean = (SiSouhuannaihubiBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU.getValue()))[0];

        exStringEquals(siSouhuannaihubiBean.getIrMsg1(), null, "（ＩＲ）メッセージ１");
        exStringEquals(
            siSouhuannaihubiBean.getIrMsg2(), null, "（ＩＲ）メッセージ2");
        exStringEquals(siSouhuannaihubiBean.getIrMsg3(), null, "（ＩＲ）メッセージ3");
        exStringEquals(siSouhuannaihubiBean.getIrMsg4(), null, "（ＩＲ）メッセージ4");
        exStringEquals(siSouhuannaihubiBean.getIrMsg5(), null, "（ＩＲ）メッセージ5");
        exStringEquals(siSouhuannaihubiBean.getIrMsg6(), null, "（ＩＲ）メッセージ6");
        exStringEquals(siSouhuannaihubiBean.getIrMsg7(), null, "（ＩＲ）メッセージ7");
        exStringEquals(siSouhuannaihubiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exStringEquals(siSouhuannaihubiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSouhuannaihubiBean.getIrHubirenrakuran(), "123456789", "（ＩＲ）不備連絡欄");

    }

    @Test
    @TestOrder(69)
    @Transactional
    public void testExec_B2_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(EditHubiteiseisyosouhuannaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_B2() {

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("12310426");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj("請求者住所２");
        seikyuusyaInfoBean.setTsinadr3kj("請求者住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");

        ToiawaseInfoBean pToiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        pToiawaseInfoBean.setSosikiNm("組織名");
        pToiawaseInfoBean.setTsinyno("45610426");
        pToiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        pToiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        pToiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        pToiawaseInfoBean.setTsintelno("04-1234-5678");
        pToiawaseInfoBean.setTelUktkKanouTime("095959");
        pToiawaseInfoBean.setTelUktkkanouTimeHigou("135959");

        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);

        editHubiteiseisyosouhuannaiBean.setSyono("10000000001");
        editHubiteiseisyosouhuannaiBean.setHhknnmkj("被保険者名");
        editHubiteiseisyosouhuannaiBean.setRenrakuarea("123456789");
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editHubiteiseisyosouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        editHubiteiseisyosouhuannaiBean.setToiawaseInfoBean(pToiawaseInfoBean);

        ReportServicesBean reportServicesBean = editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU.getValue()))[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "12310426", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "請求者住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "請求者住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "請求者", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "45610426", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "04-1234-5678", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "",
            "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "",
            "（ＩＲ）問合せ先電話受付可能時間２");

        SiSouhuannaihubiBean siSouhuannaihubiBean = (SiSouhuannaihubiBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU.getValue()))[0];

        exStringEquals(siSouhuannaihubiBean.getIrMsg1(), "テストメッセージ１", "（ＩＲ）メッセージ１");
        exStringEquals(
            siSouhuannaihubiBean.getIrMsg2(), null, "（ＩＲ）メッセージ2");
        exStringEquals(siSouhuannaihubiBean.getIrMsg3(), null, "（ＩＲ）メッセージ3");
        exStringEquals(siSouhuannaihubiBean.getIrMsg4(), null, "（ＩＲ）メッセージ4");
        exStringEquals(siSouhuannaihubiBean.getIrMsg5(), null, "（ＩＲ）メッセージ5");
        exStringEquals(siSouhuannaihubiBean.getIrMsg6(), null, "（ＩＲ）メッセージ6");
        exStringEquals(siSouhuannaihubiBean.getIrMsg7(), null, "（ＩＲ）メッセージ7");
        exStringEquals(siSouhuannaihubiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exStringEquals(siSouhuannaihubiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSouhuannaihubiBean.getIrHubirenrakuran(), "123456789", "（ＩＲ）不備連絡欄");

    }

    @Test
    @TestOrder(79)
    @Transactional
    public void testExec_B3_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(EditHubiteiseisyosouhuannaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap, true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B3() {

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("12310426");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj("請求者住所２");
        seikyuusyaInfoBean.setTsinadr3kj("請求者住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");

        ToiawaseInfoBean pToiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        pToiawaseInfoBean.setSosikiNm("組織名");
        pToiawaseInfoBean.setTsinyno("45610426");
        pToiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        pToiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        pToiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        pToiawaseInfoBean.setTsintelno("04-1234-5678");
        pToiawaseInfoBean.setTelUktkKanouTime("095959");
        pToiawaseInfoBean.setTelUktkkanouTimeHigou("135959");

        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);

        editHubiteiseisyosouhuannaiBean.setSyono("10000000001");
        editHubiteiseisyosouhuannaiBean.setHhknnmkj("被保険者名");
        editHubiteiseisyosouhuannaiBean.setRenrakuarea("123456789");
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editHubiteiseisyosouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        editHubiteiseisyosouhuannaiBean.setToiawaseInfoBean(pToiawaseInfoBean);

        ReportServicesBean reportServicesBean = editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU.getValue()))[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "12310426", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "請求者住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "請求者住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "請求者", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "45610426", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "04-1234-5678", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "",
            "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "",
            "（ＩＲ）問合せ先電話受付可能時間２");

        SiSouhuannaihubiBean siSouhuannaihubiBean = (SiSouhuannaihubiBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU.getValue()))[0];

        exStringEquals(siSouhuannaihubiBean.getIrMsg1(), "拝啓　いつもお引立ていただきありがとうございます。",
            "（ＩＲ）メッセージ１");
        exStringEquals(
            siSouhuannaihubiBean.getIrMsg2(), "　このたび、ご提出いただきましたお手続につきまして、"
                + "ご整備いただく事項がございます。", "（ＩＲ）メッセージ2");
        exStringEquals(siSouhuannaihubiBean.getIrMsg3(), "お手数ですが、下記事項をご確認のうえ、"
            + "書類整備に関する回答書・必要書類を", "（ＩＲ）メッセージ3");
        exStringEquals(siSouhuannaihubiBean.getIrMsg4(), "ご送付いただきますようよろしくお願いいたします。",
            "（ＩＲ）メッセージ4");
        exStringEquals(siSouhuannaihubiBean.getIrMsg5(), "", "（ＩＲ）メッセージ5");
        exStringEquals(siSouhuannaihubiBean.getIrMsg6(), "　　　　　　　　　　　　　　　　　　　　　　"
            + "　　　　　　　　　　　　　　　　　　　　　　　　　　　敬具", "（ＩＲ）メッセージ6");
        exStringEquals(siSouhuannaihubiBean.getIrMsg7(), null, "（ＩＲ）メッセージ7");
        exStringEquals(siSouhuannaihubiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exStringEquals(siSouhuannaihubiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSouhuannaihubiBean.getIrHubirenrakuran(), "123456789", "（ＩＲ）不備連絡欄");

    }


    @Test
    @TestOrder(89)
    @Transactional
    public void testExec_B4_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(EditHubiteiseisyosouhuannaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_B4() {

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("12310426");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj("請求者住所２");
        seikyuusyaInfoBean.setTsinadr3kj("請求者住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");

        ToiawaseInfoBean pToiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        pToiawaseInfoBean.setSosikiNm("組織名");
        pToiawaseInfoBean.setTsinyno("45610426");
        pToiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        pToiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        pToiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        pToiawaseInfoBean.setTsintelno("04-1234-5678");
        pToiawaseInfoBean.setTelUktkKanouTime("095959");
        pToiawaseInfoBean.setTelUktkkanouTimeHigou("135959");

        EditHubiteiseisyosouhuannaiBean editHubiteiseisyosouhuannaiBean = SWAKInjector
            .getInstance(EditHubiteiseisyosouhuannaiBean.class);

        editHubiteiseisyosouhuannaiBean.setSyono("10000000001");
        editHubiteiseisyosouhuannaiBean.setHhknnmkj("被保険者名");
        editHubiteiseisyosouhuannaiBean.setRenrakuarea("123456789");
        editHubiteiseisyosouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editHubiteiseisyosouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        editHubiteiseisyosouhuannaiBean.setToiawaseInfoBean(pToiawaseInfoBean);

        ReportServicesBean reportServicesBean = editHubiteiseisyosouhuannai.exec(editHubiteiseisyosouhuannaiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU.getValue()))[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "12310426", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "請求者住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "請求者住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "請求者", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "45610426", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "04-1234-5678", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "",
            "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "",
            "（ＩＲ）問合せ先電話受付可能時間２");

        SiSouhuannaihubiBean siSouhuannaihubiBean = (SiSouhuannaihubiBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU.getValue()))[0];

        exStringEquals(siSouhuannaihubiBean.getIrMsg1(), "テストメッセージ１", "（ＩＲ）メッセージ１");
        exStringEquals(siSouhuannaihubiBean.getIrMsg2(), "テストメッセージ２", "（ＩＲ）メッセージ2");
        exStringEquals(siSouhuannaihubiBean.getIrMsg3(), "テストメッセージ３", "（ＩＲ）メッセージ3");
        exStringEquals(siSouhuannaihubiBean.getIrMsg4(), "テストメッセージ４", "（ＩＲ）メッセージ4");
        exStringEquals(siSouhuannaihubiBean.getIrMsg5(), "テストメッセージ５", "（ＩＲ）メッセージ5");
        exStringEquals(siSouhuannaihubiBean.getIrMsg6(), "テストメッセージ６", "（ＩＲ）メッセージ6");
        exStringEquals(siSouhuannaihubiBean.getIrMsg7(), "テストメッセージ７", "（ＩＲ）メッセージ7");
        exStringEquals(siSouhuannaihubiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exStringEquals(siSouhuannaihubiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSouhuannaihubiBean.getIrHubirenrakuran(), "123456789", "（ＩＲ）不備連絡欄");

    }

}
