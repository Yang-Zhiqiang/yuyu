package yuyu.common.siharai.siedittyouhyou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiSksBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求書編集のメソッド{@link EditSeikyuusyo#exec(EditSeikyuusyoBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeikyuusyoTest_exec {

    @Inject
    private EditSeikyuusyo editSeikyuusyo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_請求書編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSeikyuusyoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiTyouhyoumsg());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        EditSeikyuusyoBean editSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);

        editSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSeikyuusyo.exec(editSeikyuusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        EditSeikyuusyoBean editSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);

        editSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSeikyuusyo.exec(editSeikyuusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        EditSeikyuusyoBean editSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);

        editSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSeikyuusyo.exec(editSeikyuusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(null);

        try {
            editSeikyuusyo.exec(pEditSeikyuusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyaInfoBean'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        pEditSeikyuusyoBean.setSeikyuusyubetu(null);

        try {
            editSeikyuusyo.exec(pEditSeikyuusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyubetu'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        pEditSeikyuusyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.BLNK);

        try {
            editSeikyuusyo.exec(pEditSeikyuusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyubetu'", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_B1() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        pEditSeikyuusyoBean.setSyono("10000000001");
        pEditSeikyuusyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        pEditSeikyuusyoBean.setToritsugisyakjncd("123456789");
        pEditSeikyuusyoBean.setToritsugisyaKjnmei("個人名");
        pEditSeikyuusyoBean.setToritsugisyaSosikimei("組織名");

        ReportServicesBean reportServicesBean = editSeikyuusyo.exec(pEditSeikyuusyoBean);
        SiSksBean siSksBean = (SiSksBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_HOKEN_SKS.getValue()))[0];

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");
        exStringEquals(siSksBean.getIrTyouhyoutitle(), "死亡保険金請求書【住友生命提出用】", "（ＩＲ）帳票タイトル");
        exStringEquals(siSksBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exStringEquals(siSksBean.getIrTsinyno(), "1231042", "（ＩＲ）通信先郵便番号");
        exStringEquals(siSksBean.getIrTsintelno(), "03-1234-5678", "（ＩＲ）通信先電話番号");
        exStringEquals(siSksBean.getIrTsinadr1kj(), "一二三四五六七八九零一二三四五六七八九零一二三四五六七"
            , "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siSksBean.getIrTsinadr2kj(), "八九零一二三四五六七八九零一二三四通信先住所３", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siSksBean.getIrTsinadr3kj(), null, "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(siSksBean.getIrMsg1(), "死亡保険金を請求します。", "（ＩＲ）メッセージ１");
        exStringEquals(siSksBean.getIrMsg2(), "全額一時金でのお支払となります。", "（ＩＲ）メッセージ２");
        exStringEquals(siSksBean.getIrMsg3(), null, "（ＩＲ）メッセージ３");
        exStringEquals(siSksBean.getIrMsg4(), null, "（ＩＲ）メッセージ４");

        exStringEquals(siSksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSksBean.getIrToritsugisyakjncd(), "123456789", "（ＩＲ）取次者個人コード");
        exStringEquals(siSksBean.getIrToritsugisyanm(), "個人名", "（ＩＲ）取次者氏名");
        exStringEquals(siSksBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）帳票作成日");
        exStringEquals(siSksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(90)
    public void testExec_B3() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj("一二三四五六七八九零一二三四五六七八九零一二");
        seikyuusyaInfoBean.setTsinadr2kj("九八七六五四三二一零九八七六五四三二一零三二一");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        pEditSeikyuusyoBean.setSyono("10000000001");
        pEditSeikyuusyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        pEditSeikyuusyoBean.setToritsugisyakjncd("123456789");
        pEditSeikyuusyoBean.setToritsugisyaKjnmei("個人名");
        pEditSeikyuusyoBean.setToritsugisyaSosikimei("組織名");

        ReportServicesBean reportServicesBean = editSeikyuusyo.exec(pEditSeikyuusyoBean);
        SiSksBean siSksBean = (SiSksBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_HOKEN_SKS.getValue()))[0];

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");

        exStringEquals(siSksBean.getIrTyouhyoutitle(), "", "（ＩＲ）帳票タイトル");
        exStringEquals(siSksBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exStringEquals(siSksBean.getIrTsinyno(), "1231042", "（ＩＲ）通信先郵便番号");
        exStringEquals(siSksBean.getIrTsintelno(), "03-1234-5678", "（ＩＲ）通信先電話番号");
        exStringEquals(siSksBean.getIrTsinadr1kj(), "一二三四五六七八九零一二三四五六七八九零一二"
            , "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siSksBean.getIrTsinadr2kj(), "九八七六五四三二一零九八七六五四三二一零三二一", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siSksBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(siSksBean.getIrMsg1(), null, "（ＩＲ）メッセージ１");
        exStringEquals(siSksBean.getIrMsg2(), null, "（ＩＲ）メッセージ２");
        exStringEquals(siSksBean.getIrMsg3(), null, "（ＩＲ）メッセージ３");
        exStringEquals(siSksBean.getIrMsg4(), null, "（ＩＲ）メッセージ４");

        exStringEquals(siSksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSksBean.getIrToritsugisyakjncd(), "123456789", "（ＩＲ）取次者個人コード");
        exStringEquals(siSksBean.getIrToritsugisyanm(), "個人名", "（ＩＲ）取次者氏名");
        exStringEquals(siSksBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）帳票作成日");
        exStringEquals(siSksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(100)
    public void testExec_B4() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj("一二三四五六七八九零一二三四五六七八九零一二三");
        seikyuusyaInfoBean.setTsinadr2kj("九八七六五四三二一零九八七六五四三二一零三二一");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        pEditSeikyuusyoBean.setSyono("10000000001");
        pEditSeikyuusyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        pEditSeikyuusyoBean.setToritsugisyakjncd("123456789");
        pEditSeikyuusyoBean.setToritsugisyaKjnmei("個人名");
        pEditSeikyuusyoBean.setToritsugisyaSosikimei("組織名");

        ReportServicesBean reportServicesBean = editSeikyuusyo.exec(pEditSeikyuusyoBean);
        SiSksBean siSksBean = (SiSksBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue()))[0];

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");

        exStringEquals(siSksBean.getIrTyouhyoutitle(), "", "（ＩＲ）帳票タイトル");
        exStringEquals(siSksBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exStringEquals(siSksBean.getIrTsinyno(), "1231042", "（ＩＲ）通信先郵便番号");
        exStringEquals(siSksBean.getIrTsintelno(), "03-1234-5678", "（ＩＲ）通信先電話番号");
        exStringEquals(siSksBean.getIrTsinadr1kj(), "一二三四五六七八九零一二三四五六七八九零一二三"
            , "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siSksBean.getIrTsinadr2kj(), "九八七六五四三二一零九八七六五四三二一零三二一", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siSksBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(siSksBean.getIrMsg1(), null, "（ＩＲ）メッセージ１");
        exStringEquals(siSksBean.getIrMsg2(), null, "（ＩＲ）メッセージ２");
        exStringEquals(siSksBean.getIrMsg3(), null, "（ＩＲ）メッセージ３");
        exStringEquals(siSksBean.getIrMsg4(), null, "（ＩＲ）メッセージ４");

        exStringEquals(siSksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSksBean.getIrToritsugisyakjncd(), "123456789", "（ＩＲ）取次者個人コード");
        exStringEquals(siSksBean.getIrToritsugisyanm(), "個人名", "（ＩＲ）取次者氏名");
        exStringEquals(siSksBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）帳票作成日");
        exStringEquals(siSksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(110)
    public void testExec_B5() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        pEditSeikyuusyoBean.setSyono("10000000001");
        pEditSeikyuusyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        pEditSeikyuusyoBean.setToritsugisyakjncd("123456789");
        pEditSeikyuusyoBean.setToritsugisyaKjnmei("個人名");
        pEditSeikyuusyoBean.setToritsugisyaSosikimei("組織名");

        ReportServicesBean reportServicesBean = editSeikyuusyo.exec(pEditSeikyuusyoBean);
        SiSksBean siSksBean = (SiSksBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_HOKEN_SKS.getValue()))[0];

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151212"), "処理日付");

        exStringEquals(siSksBean.getIrTyouhyoutitle(), "死亡保険金請求書【住友生命提出用】", "（ＩＲ）帳票タイトル");
        exStringEquals(siSksBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exStringEquals(siSksBean.getIrTsinyno(), "1231042", "（ＩＲ）通信先郵便番号");
        exStringEquals(siSksBean.getIrTsintelno(), "03-1234-5678", "（ＩＲ）通信先電話番号");
        exStringEquals(siSksBean.getIrTsinadr1kj(), "一二三四五六七八九零一二三四五六七八九零一二三四五六七"
            , "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siSksBean.getIrTsinadr2kj(), "八九零一二三四五六七八九零一二三四五六通信先住所３", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siSksBean.getIrTsinadr3kj(), null, "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(siSksBean.getIrMsg1(), "死亡保険金を請求します。", "（ＩＲ）メッセージ１");
        exStringEquals(siSksBean.getIrMsg2(), "全額一時金でのお支払となります。", "（ＩＲ）メッセージ２");
        exStringEquals(siSksBean.getIrMsg3(), null, "（ＩＲ）メッセージ３");
        exStringEquals(siSksBean.getIrMsg4(), null, "（ＩＲ）メッセージ４");

        exStringEquals(siSksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSksBean.getIrToritsugisyakjncd(), "123456789", "（ＩＲ）取次者個人コード");
        exStringEquals(siSksBean.getIrToritsugisyanm(), "個人名", "（ＩＲ）取次者氏名");
        exStringEquals(siSksBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）帳票作成日");
        exStringEquals(siSksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(120)
    public void testExec_C1() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        pEditSeikyuusyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        pEditSeikyuusyoBean.setUktKbn(C_UktKbn.KYK);
        pEditSeikyuusyoBean.setTuukasyu(C_Tuukasyu.JPY);

        ReportServicesBean reportServicesBean = editSeikyuusyo.exec(pEditSeikyuusyoBean);
        SiSksBean siSksBean = (SiSksBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_HOKEN_SKS.getValue()))[0];

        exClassificationEquals(siSksBean.getIrShsrtdkdadrhyjumu(), C_UmuKbn.ARI, "（ＩＲ）送付先欄（届出住所）表示有無");
        exClassificationEquals(siSksBean.getIrShsrkinyuuhyjumu(), C_UmuKbn.NONE, "（ＩＲ）送付先欄（記入用）表示有無");
        exClassificationEquals(siSksBean.getIrUkthougkdthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSksBean.getIrUkthouendthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（円建）表示有無");
    }

    @Test
    @TestOrder(130)
    public void testExec_C2() {

        EditSeikyuusyoBean pEditSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");

        pEditSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        pEditSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        pEditSeikyuusyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        pEditSeikyuusyoBean.setUktKbn(C_UktKbn.HHKN);
        pEditSeikyuusyoBean.setTuukasyu(C_Tuukasyu.USD);

        ReportServicesBean reportServicesBean = editSeikyuusyo.exec(pEditSeikyuusyoBean);
        SiSksBean siSksBean = (SiSksBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_HOKEN_SKS.getValue()))[0];

        exClassificationEquals(siSksBean.getIrShsrtdkdadrhyjumu(), C_UmuKbn.NONE, "（ＩＲ）送付先欄（届出住所）表示有無");
        exClassificationEquals(siSksBean.getIrShsrkinyuuhyjumu(), C_UmuKbn.ARI, "（ＩＲ）送付先欄（記入用）表示有無");
        exClassificationEquals(siSksBean.getIrUkthougkdthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSksBean.getIrUkthouendthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（円建）表示有無");
    }
}
