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

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiShannaiBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 送付案内編集のメソッド{@link EditSouhuannai#exec(EditSouhuannaiBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSouhuannaiTest_exec {

    @Inject
    private EditSouhuannai editSouhuannai;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_送付案内編集";

    private final static String sheetName = "テストデータ";

    @Transactional
    public void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSouhuannaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void insertTestData2() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSouhuannaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiTyouhyoumsg());
        baseDomManager.delete(baseDomManager.getAllSequences());
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editSouhuannai.exec(editSouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editSouhuannai.exec(editSouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editSouhuannai.exec(editSouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSouhuannaiBean.setSeikyuusyaInfoBean(null);
        try {
            editSouhuannai.exec(editSouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyaInfoBean'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        editSouhuannaiBean.setToiawaseInfoBean(null);
        try {
            editSouhuannai.exec(editSouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='toiawaseInfoBean'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSouhuannaiBean.setSeikyuuSyubetu(null);
        try {
            editSouhuannai.exec(editSouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuuSyubetu'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(70)
    public void testExec_A7() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSouhuannaiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.BLNK);
        try {
            editSouhuannai.exec(editSouhuannaiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuuSyubetu'", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_B1() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        seikyuusyaInfoBean.setTsinyno("8889999");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj("請求者住所２");
        seikyuusyaInfoBean.setTsinadr3kj("請求者住所３");
        seikyuusyaInfoBean.setTsintelno("08012345678");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        toiawaseInfoBean.setTsinyno("9988888");
        toiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        toiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        toiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        toiawaseInfoBean.setTsintelno("09098765432");
        toiawaseInfoBean.setTelUktkKanouTime("");
        toiawaseInfoBean.setTelUktkkanouTimeHigou("");
        editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSouhuannaiBean.setSyono("10000000001");
        editSouhuannaiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editSouhuannaiBean.setJisatuMenseki(true);
        editSouhuannaiBean.setInitsbjiyensitihsytkhukaUmu(C_UmuKbn.ARI);
        editSouhuannaiBean.setHknkknKbn(C_HknKknKbn.DAI1HKNKKN);
        editSouhuannaiBean.setKykTuukasyu(C_Tuukasyu.JPY);
        editSouhuannaiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        insertTestData();
        ReportServicesBean reportServicesBean = editSouhuannai.exec(editSouhuannaiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）処理年月日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "8889999", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "請求者住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "請求者住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "郁郁", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "9988888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "09098765432", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "", "（ＩＲ）問合せ先電話受付可能時間");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "", "（ＩＲ）問合せ先電話受付可能時間備考");
        SiShannaiBean siShannaiBean = (SiShannaiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[0];
        exStringEquals(siShannaiBean.getIrTyouhyoutitle(), "精算金振込み手続きのご案内", "（ＩＲ）帳票タイトル");
        exStringEquals(siShannaiBean.getIrMsg1(), "このたびご訃報に接し、ご一同様にはさぞかしお力落としのことと謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siShannaiBean.getIrMsg2(), "故人ご生前にはひとかたならぬご愛顧を賜り、誠にありがとうございました。", "（ＩＲ）メッセージ２");
        exStringEquals(siShannaiBean.getIrMsg3(), "下記のとおりご案内申し上げますので、請求書類をお取りそろえのうえ、ご提出くださいますよう", "（ＩＲ）メッセージ３");
        exStringEquals(siShannaiBean.getIrMsg4(), "お願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siShannaiBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siShannaiBean.getIrSyono(), "１０００００００００１", "（ＩＲ）証券番号");
        exStringEquals(siShannaiBean.getIrMsg6(), "【ご提出いただく書類】", "（ＩＲ）メッセージ６");
        exStringEquals(siShannaiBean.getIrMsg7(), "　精算金振込み手続きで必要な書類は『ご提出書類について』をご確認ください。", "（ＩＲ）メッセージ７");
        exStringEquals(siShannaiBean.getIrMsg8(), "", "（ＩＲ）メッセージ８");
        exStringEquals(siShannaiBean.getIrMsg9(), "※別添えの『ご提出書類について』に記載されている書類の他に書類をご提出いただくことが", "（ＩＲ）メッセージ９");
        exStringEquals(siShannaiBean.getIrMsg10(), "　ありますので、あらかじめご了承ください。", "（ＩＲ）メッセージ１０");
        exStringEquals(siShannaiBean.getIrMsg11(), "※戸籍関係書類につきましては、個人情報保護法遵守の観点から、必要事項確認後に廃棄させて", "（ＩＲ）メッセージ１１");
        exStringEquals(siShannaiBean.getIrMsg12(), "　いただきます。戸籍関係書類が他にご入用等の場合は、写しをご提出ください。", "（ＩＲ）メッセージ１２");
        exStringEquals(siShannaiBean.getIrMsg13(), "※主治医による証明書（診断書）の証明など請求にかかる費用につきましては、お客さまのご負", "（ＩＲ）メッセージ１３");
        exStringEquals(siShannaiBean.getIrMsg14(), "　担になりますのでご了承ください。", "（ＩＲ）メッセージ１４");
        exStringEquals(siShannaiBean.getIrMsg15(), "※請求者が未成年の場合、親権者または後見人の方からご請求ください。ご請求に際しては", "（ＩＲ）メッセージ１５");
        exStringEquals(siShannaiBean.getIrMsg16(), "　親権者および未成年者との関係が分かる戸籍謄(抄)本をご提出ください。", "（ＩＲ）メッセージ１６");
        exStringEquals(siShannaiBean.getIrMsg17(), "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　以上", "（ＩＲ）メッセージ１７");
        exStringEquals(siShannaiBean.getIrMsg18(), null, "（ＩＲ）メッセージ１８");
        exStringEquals(siShannaiBean.getIrMsg19(), null, "（ＩＲ）メッセージ１９");
        exStringEquals(siShannaiBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siShannaiBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siShannaiBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siShannaiBean.getIrMsg23(), null, "（ＩＲ）メッセージ２３");
        exStringEquals(siShannaiBean.getIrMsg24(), null, "（ＩＲ）メッセージ２４");
        exStringEquals(siShannaiBean.getIrMsg25(), null, "（ＩＲ）メッセージ２５");
        exStringEquals(siShannaiBean.getIrMsg26(), null, "（ＩＲ）メッセージ２６");
        exStringEquals(siShannaiBean.getIrMsg27(), null, "（ＩＲ）メッセージ２７");
        exStringEquals(siShannaiBean.getIrMsg28(), null, "（ＩＲ）メッセージ２８");
        exStringEquals(siShannaiBean.getIrMsg29(), null, "（ＩＲ）メッセージ２９");
        exStringEquals(siShannaiBean.getIrMsg30(), null, "（ＩＲ）メッセージ３０");
        exStringEquals(siShannaiBean.getIrMsg31(), null, "（ＩＲ）メッセージ３１");
        exStringEquals(siShannaiBean.getIrMsg32(), null, "（ＩＲ）メッセージ３２");
        exStringEquals(siShannaiBean.getIrMsg33(), null, "（ＩＲ）メッセージ３３");
        exStringEquals(siShannaiBean.getIrMsg34(), null, "（ＩＲ）メッセージ３４");
        exStringEquals(siShannaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShannaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShannaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        deleteTestData();
    }

    @Test
    @TestOrder(90)
    public void testExec_B2() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        seikyuusyaInfoBean.setTsinyno("8889999");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj("請求者住所２");
        seikyuusyaInfoBean.setTsinadr3kj(null);
        seikyuusyaInfoBean.setTsintelno("08012345678");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        toiawaseInfoBean.setTsinyno("9988888");
        toiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        toiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        toiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        toiawaseInfoBean.setTsintelno("09098765432");
        toiawaseInfoBean.setTelUktkKanouTime("");
        toiawaseInfoBean.setTelUktkkanouTimeHigou("");
        editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSouhuannaiBean.setSyono("10000000001");
        editSouhuannaiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editSouhuannaiBean.setJisatuMenseki(true);
        editSouhuannaiBean.setInitsbjiyensitihsytkhukaUmu(C_UmuKbn.ARI);
        editSouhuannaiBean.setHknkknKbn(C_HknKknKbn.DAI1HKNKKN);
        editSouhuannaiBean.setKykTuukasyu(C_Tuukasyu.USD);
        editSouhuannaiBean.setMynumbertksUmuKbn(C_UmuKbn.ARI);

        insertTestData();
        ReportServicesBean reportServicesBean = editSouhuannai.exec(editSouhuannaiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）処理年月日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "8889999", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "請求者住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), null, "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "郁郁", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "9988888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "09098765432", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "", "（ＩＲ）問合せ先電話受付可能時間");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "", "（ＩＲ）問合せ先電話受付可能時間備考");
        SiShannaiBean siShannaiBean = (SiShannaiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[0];
        exStringEquals(siShannaiBean.getIrTyouhyoutitle(), "精算金振込み手続きのご案内", "（ＩＲ）帳票タイトル");
        exStringEquals(siShannaiBean.getIrMsg1(), "このたびご訃報に接し、ご一同様にはさぞかしお力落としのことと謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siShannaiBean.getIrMsg2(), "故人ご生前にはひとかたならぬご愛顧を賜り、誠にありがとうございました。", "（ＩＲ）メッセージ２");
        exStringEquals(siShannaiBean.getIrMsg3(), "下記のとおりご案内申し上げますので、請求書類をお取りそろえのうえ、ご提出くださいますよう", "（ＩＲ）メッセージ３");
        exStringEquals(siShannaiBean.getIrMsg4(), "お願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siShannaiBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siShannaiBean.getIrSyono(), "１０００００００００１", "（ＩＲ）証券番号");
        exStringEquals(siShannaiBean.getIrMsg6(), "【ご提出いただく書類】", "（ＩＲ）メッセージ６");
        exStringEquals(siShannaiBean.getIrMsg7(), "　精算金振込み手続きで必要な書類は『ご提出書類について』をご確認ください。", "（ＩＲ）メッセージ７");
        exStringEquals(siShannaiBean.getIrMsg8(), "　また、このお手続きと合わせてマイナンバーのご提供をお願いしております。", "（ＩＲ）メッセージ８");
        exStringEquals(siShannaiBean.getIrMsg9(), "", "（ＩＲ）メッセージ９");
        exStringEquals(siShannaiBean.getIrMsg10(), "【円貨でのお支払いについて】", "（ＩＲ）メッセージ１０");
        exStringEquals(siShannaiBean.getIrMsg11(), "　・精算金を円貨によりお受け取りできます。", "（ＩＲ）メッセージ１１");
        exStringEquals(siShannaiBean.getIrMsg12(), "　　円貨でお受取りになる場合、為替レートの変動による影響を受けます。", "（ＩＲ）メッセージ１２");
        exStringEquals(siShannaiBean.getIrMsg13(), "　・円貨への換算に適用する為替レートは、請求日（整備された必要書類が当社に到着した日）", "（ＩＲ）メッセージ１３");
        exStringEquals(siShannaiBean.getIrMsg14(), "　　における、当社所定の為替レート「ＴＴＭ（対顧客電信売買相場仲値）－５０銭」となり", "（ＩＲ）メッセージ１４");
        exStringEquals(siShannaiBean.getIrMsg15(), "　　ます。", "（ＩＲ）メッセージ１５");
        exStringEquals(siShannaiBean.getIrMsg16(), "　・当社所定の為替レートは、住友生命ホームページにてご確認いただけます。", "（ＩＲ）メッセージ１６");
        exStringEquals(siShannaiBean.getIrMsg17(), "", "（ＩＲ）メッセージ１７");
        exStringEquals(siShannaiBean.getIrMsg18(), "【指定通貨（外貨）でのお支払いについて】", "（ＩＲ）メッセージ１８");
        exStringEquals(siShannaiBean.getIrMsg19(), "　・精算金を指定された通貨（外貨）でお受け取りできます。指定通貨（外貨）でのお受取りが", "（ＩＲ）メッセージ１９");
        exStringEquals(siShannaiBean.getIrMsg20(), "　　可能な日本国内にある金融機関口座をご指定ください。", "（ＩＲ）メッセージ２０");
        exStringEquals(siShannaiBean.getIrMsg21(), "　　※円貨口座を記入されると、当社から送金した指定通貨（外貨）が自動的に円貨に両替され", "（ＩＲ）メッセージ２１");
        exStringEquals(siShannaiBean.getIrMsg22(), "　　　て入金される場合があります。", "（ＩＲ）メッセージ２２");
        exStringEquals(siShannaiBean.getIrMsg23(), "", "（ＩＲ）メッセージ２３");
        exStringEquals(siShannaiBean.getIrMsg24(), "※別添えの『ご提出書類について』に記載されている書類の他に書類をご提出いただくことが", "（ＩＲ）メッセージ２４");
        exStringEquals(siShannaiBean.getIrMsg25(), "　ありますので、あらかじめご了承ください。", "（ＩＲ）メッセージ２５");
        exStringEquals(siShannaiBean.getIrMsg26(), "※戸籍関係書類につきましては、個人情報保護法遵守の観点から、必要事項確認後に廃棄させて", "（ＩＲ）メッセージ２６");
        exStringEquals(siShannaiBean.getIrMsg27(), "　いただきます。戸籍関係書類が他にご入用等の場合は、写しをご提出ください。", "（ＩＲ）メッセージ２７");
        exStringEquals(siShannaiBean.getIrMsg28(), "※主治医による証明書（診断書）の証明など請求にかかる費用につきましては、お客さまのご負", "（ＩＲ）メッセージ２８");
        exStringEquals(siShannaiBean.getIrMsg29(), "　担になりますのでご了承ください。", "（ＩＲ）メッセージ２９");
        exStringEquals(siShannaiBean.getIrMsg30(), "※請求者が未成年の場合、親権者または後見人の方からご請求ください。ご請求に際しては", "（ＩＲ）メッセージ３０");
        exStringEquals(siShannaiBean.getIrMsg31(), "　親権者および未成年者との関係が分かる戸籍謄(抄)本をご提出ください。", "（ＩＲ）メッセージ３１");
        exStringEquals(siShannaiBean.getIrMsg32(), "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　以上", "（ＩＲ）メッセージ３２");
        exStringEquals(siShannaiBean.getIrMsg33(), null, "（ＩＲ）メッセージ３３");
        exStringEquals(siShannaiBean.getIrMsg34(), null, "（ＩＲ）メッセージ３４");
        exStringEquals(siShannaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShannaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShannaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        deleteTestData();
    }

    @Test
    @TestOrder(100)
    public void testExec_B3() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        seikyuusyaInfoBean.setTsinyno("8889999");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj(null);
        seikyuusyaInfoBean.setTsinadr3kj(null);
        seikyuusyaInfoBean.setTsintelno("08012345678");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        toiawaseInfoBean.setTsinyno("9988888");
        toiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        toiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        toiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        toiawaseInfoBean.setTsintelno("09098765432");
        toiawaseInfoBean.setTelUktkKanouTime("");
        toiawaseInfoBean.setTelUktkkanouTimeHigou("");
        editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSouhuannaiBean.setSyono("10000000001");
        editSouhuannaiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editSouhuannaiBean.setJisatuMenseki(false);
        editSouhuannaiBean.setInitsbjiyensitihsytkhukaUmu(C_UmuKbn.ARI);
        editSouhuannaiBean.setHknkknKbn(C_HknKknKbn.DAI2HKNKKN);
        editSouhuannaiBean.setKykTuukasyu(C_Tuukasyu.USD);
        editSouhuannaiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        insertTestData();
        ReportServicesBean reportServicesBean = editSouhuannai.exec(editSouhuannaiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）処理年月日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "8889999", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), null, "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), null, "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "郁郁", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "9988888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "09098765432", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "", "（ＩＲ）問合せ先電話受付可能時間");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "", "（ＩＲ）問合せ先電話受付可能時間備考");
        SiShannaiBean siShannaiBean = (SiShannaiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[0];
        exStringEquals(siShannaiBean.getIrTyouhyoutitle(), "死亡保険金請求手続きのご案内", "（ＩＲ）帳票タイトル");
        exStringEquals(siShannaiBean.getIrMsg1(), "このたびご訃報に接し、ご一同様にはさぞかしお力落としのことと謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siShannaiBean.getIrMsg2(), "故人ご生前にはひとかたならぬご愛顧を賜り、誠にありがとうございました。", "（ＩＲ）メッセージ２");
        exStringEquals(siShannaiBean.getIrMsg3(), "下記のとおりご案内申し上げますので、請求書類をお取りそろえのうえ、ご提出くださいますよう", "（ＩＲ）メッセージ３");
        exStringEquals(siShannaiBean.getIrMsg4(), "お願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siShannaiBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siShannaiBean.getIrSyono(), "１０００００００００１", "（ＩＲ）証券番号");
        exStringEquals(siShannaiBean.getIrMsg6(), "【ご提出いただく書類】", "（ＩＲ）メッセージ６");
        exStringEquals(siShannaiBean.getIrMsg7(), "　死亡保険金請求手続きで必要な書類は『ご提出書類について』をご確認ください。", "（ＩＲ）メッセージ７");
        exStringEquals(siShannaiBean.getIrMsg8(), "", "（ＩＲ）メッセージ８");
        exStringEquals(siShannaiBean.getIrMsg9(), "【円貨でのお支払いについて】", "（ＩＲ）メッセージ９");
        exStringEquals(siShannaiBean.getIrMsg10(), "　・保険金を円貨によりお受け取りできます。", "（ＩＲ）メッセージ１０");
        exStringEquals(siShannaiBean.getIrMsg11(), "　　円貨でお受取りになる場合、為替レートの変動による影響を受けます。", "（ＩＲ）メッセージ１１");
        exStringEquals(siShannaiBean.getIrMsg12(), "　・円貨への換算に適用する為替レートは、請求日（整備された必要書類が当社に到着した日）", "（ＩＲ）メッセージ１２");
        exStringEquals(siShannaiBean.getIrMsg13(), "　　における、当社所定の為替レート「ＴＴＭ（対顧客電信売買相場仲値）－５０銭」となり", "（ＩＲ）メッセージ１３");
        exStringEquals(siShannaiBean.getIrMsg14(), "　　ます。", "（ＩＲ）メッセージ１４");
        exStringEquals(siShannaiBean.getIrMsg15(), "　・当社所定の為替レートは、住友生命ホームページにてご確認いただけます。", "（ＩＲ）メッセージ１５");
        exStringEquals(siShannaiBean.getIrMsg16(), "", "（ＩＲ）メッセージ１６");
        exStringEquals(siShannaiBean.getIrMsg17(), "【指定通貨（外貨）でのお支払いについて】", "（ＩＲ）メッセージ１７");
        exStringEquals(siShannaiBean.getIrMsg18(), "　・保険金を指定された通貨（外貨）でお受け取りできます。指定通貨（外貨）でのお受取りが", "（ＩＲ）メッセージ１８");
        exStringEquals(siShannaiBean.getIrMsg19(), "　　可能な日本国内にある金融機関口座をご指定ください。", "（ＩＲ）メッセージ１９");
        exStringEquals(siShannaiBean.getIrMsg20(), "　　※円貨口座を記入されると、当社から送金した指定通貨（外貨）が自動的に円貨に両替され", "（ＩＲ）メッセージ２０");
        exStringEquals(siShannaiBean.getIrMsg21(), "　　　て入金される場合があります。", "（ＩＲ）メッセージ２１");
        exStringEquals(siShannaiBean.getIrMsg22(), "", "（ＩＲ）メッセージ２２");
        exStringEquals(siShannaiBean.getIrMsg23(), "※別添えの『ご提出書類について』に記載されている書類の他に書類をご提出いただくことが", "（ＩＲ）メッセージ２３");
        exStringEquals(siShannaiBean.getIrMsg24(), "　ありますので、あらかじめご了承ください。", "（ＩＲ）メッセージ２４");
        exStringEquals(siShannaiBean.getIrMsg25(), "※戸籍関係書類につきましては、個人情報保護法遵守の観点から、必要事項確認後に廃棄させて", "（ＩＲ）メッセージ２５");
        exStringEquals(siShannaiBean.getIrMsg26(), "　いただきます。戸籍関係書類が他にご入用等の場合は、写しをご提出ください。", "（ＩＲ）メッセージ２６");
        exStringEquals(siShannaiBean.getIrMsg27(), "※主治医による証明書（診断書）の証明など請求にかかる費用につきましては、お客さまのご負", "（ＩＲ）メッセージ２７");
        exStringEquals(siShannaiBean.getIrMsg28(), "　担になりますのでご了承ください。", "（ＩＲ）メッセージ２８");
        exStringEquals(siShannaiBean.getIrMsg29(), "※請求者が未成年の場合、親権者または後見人の方からご請求ください。ご請求に際しては", "（ＩＲ）メッセージ２９");
        exStringEquals(siShannaiBean.getIrMsg30(), "　親権者および未成年者との関係が分かる戸籍謄(抄)本をご提出ください。", "（ＩＲ）メッセージ３０");
        exStringEquals(siShannaiBean.getIrMsg31(), "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　以上", "（ＩＲ）メッセージ３１");
        exStringEquals(siShannaiBean.getIrMsg32(), null, "（ＩＲ）メッセージ３２");
        exStringEquals(siShannaiBean.getIrMsg33(), null, "（ＩＲ）メッセージ３３");
        exStringEquals(siShannaiBean.getIrMsg34(), null, "（ＩＲ）メッセージ３４");
        exStringEquals(siShannaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShannaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShannaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        deleteTestData();
    }

    @Test
    @TestOrder(110)
    public void testExec_B4() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        seikyuusyaInfoBean.setTsinyno("8889999");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj("請求者住所２");
        seikyuusyaInfoBean.setTsinadr3kj("請求者住所３");
        seikyuusyaInfoBean.setTsintelno("08012345678");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        toiawaseInfoBean.setTsinyno("9988888");
        toiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        toiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        toiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        toiawaseInfoBean.setTsintelno("09098765432");
        toiawaseInfoBean.setTelUktkKanouTime("");
        toiawaseInfoBean.setTelUktkkanouTimeHigou("");
        editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSouhuannaiBean.setSyono("10000000001");
        editSouhuannaiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editSouhuannaiBean.setJisatuMenseki(false);
        editSouhuannaiBean.setInitsbjiyensitihsytkhukaUmu(C_UmuKbn.NONE);
        editSouhuannaiBean.setHknkknKbn(C_HknKknKbn.DAI1HKNKKN);
        editSouhuannaiBean.setKykTuukasyu(C_Tuukasyu.USD);
        editSouhuannaiBean.setMynumbertksUmuKbn(C_UmuKbn.ARI);

        insertTestData2();
        ReportServicesBean reportServicesBean = editSouhuannai.exec(editSouhuannaiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）処理年月日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "8889999", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "請求者住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "請求者住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "郁郁", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "9988888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "09098765432", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "", "（ＩＲ）問合せ先電話受付可能時間");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "", "（ＩＲ）問合せ先電話受付可能時間備考");
        SiShannaiBean siShannaiBean = (SiShannaiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[0];
        exStringEquals(siShannaiBean.getIrTyouhyoutitle(), "死亡保険金請求手続きのご案内", "（ＩＲ）帳票タイトル");
        exStringEquals(siShannaiBean.getIrMsg1(), "メッセージ１", "（ＩＲ）メッセージ１");
        exStringEquals(siShannaiBean.getIrMsg2(), "メッセージ２", "（ＩＲ）メッセージ２");
        exStringEquals(siShannaiBean.getIrMsg3(), "メッセージ３", "（ＩＲ）メッセージ３");
        exStringEquals(siShannaiBean.getIrMsg4(), "メッセージ４", "（ＩＲ）メッセージ４");
        exStringEquals(siShannaiBean.getIrMsg5(), "メッセージ５", "（ＩＲ）メッセージ５");
        exStringEquals(siShannaiBean.getIrSyono(), "１０００００００００１", "（ＩＲ）証券番号");
        exStringEquals(siShannaiBean.getIrMsg6(), "メッセージ６", "（ＩＲ）メッセージ６");
        exStringEquals(siShannaiBean.getIrMsg7(), "メッセージ７", "（ＩＲ）メッセージ７");
        exStringEquals(siShannaiBean.getIrMsg8(), "メッセージ８", "（ＩＲ）メッセージ８");
        exStringEquals(siShannaiBean.getIrMsg9(), "メッセージ９", "（ＩＲ）メッセージ９");
        exStringEquals(siShannaiBean.getIrMsg10(), "メッセージ１０", "（ＩＲ）メッセージ１０");
        exStringEquals(siShannaiBean.getIrMsg11(), "メッセージ１１", "（ＩＲ）メッセージ１１");
        exStringEquals(siShannaiBean.getIrMsg12(), "メッセージ１２", "（ＩＲ）メッセージ１２");
        exStringEquals(siShannaiBean.getIrMsg13(), "メッセージ１３", "（ＩＲ）メッセージ１３");
        exStringEquals(siShannaiBean.getIrMsg14(), "メッセージ１４", "（ＩＲ）メッセージ１４");
        exStringEquals(siShannaiBean.getIrMsg15(), "メッセージ１５", "（ＩＲ）メッセージ１５");
        exStringEquals(siShannaiBean.getIrMsg16(), "メッセージ１６", "（ＩＲ）メッセージ１６");
        exStringEquals(siShannaiBean.getIrMsg17(), "メッセージ１７", "（ＩＲ）メッセージ１７");
        exStringEquals(siShannaiBean.getIrMsg18(), "メッセージ１８", "（ＩＲ）メッセージ１８");
        exStringEquals(siShannaiBean.getIrMsg19(), "メッセージ１９", "（ＩＲ）メッセージ１９");
        exStringEquals(siShannaiBean.getIrMsg20(), "メッセージ２０", "（ＩＲ）メッセージ２０");
        exStringEquals(siShannaiBean.getIrMsg21(), "メッセージ２１", "（ＩＲ）メッセージ２１");
        exStringEquals(siShannaiBean.getIrMsg22(), "メッセージ２２", "（ＩＲ）メッセージ２２");
        exStringEquals(siShannaiBean.getIrMsg23(), "メッセージ２３", "（ＩＲ）メッセージ２３");
        exStringEquals(siShannaiBean.getIrMsg24(), "メッセージ２４", "（ＩＲ）メッセージ２４");
        exStringEquals(siShannaiBean.getIrMsg25(), "メッセージ２５", "（ＩＲ）メッセージ２５");
        exStringEquals(siShannaiBean.getIrMsg26(), "メッセージ２６", "（ＩＲ）メッセージ２６");
        exStringEquals(siShannaiBean.getIrMsg27(), "メッセージ２７", "（ＩＲ）メッセージ２７");
        exStringEquals(siShannaiBean.getIrMsg28(), "メッセージ２８", "（ＩＲ）メッセージ２８");
        exStringEquals(siShannaiBean.getIrMsg29(), "メッセージ２９", "（ＩＲ）メッセージ２９");
        exStringEquals(siShannaiBean.getIrMsg30(), "メッセージ３０", "（ＩＲ）メッセージ３０");
        exStringEquals(siShannaiBean.getIrMsg31(), "メッセージ３１", "（ＩＲ）メッセージ３１");
        exStringEquals(siShannaiBean.getIrMsg32(), "メッセージ３２", "（ＩＲ）メッセージ３２");
        exStringEquals(siShannaiBean.getIrMsg33(), null, "（ＩＲ）メッセージ３３");
        exStringEquals(siShannaiBean.getIrMsg34(), null, "（ＩＲ）メッセージ３４");
        exStringEquals(siShannaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShannaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShannaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        deleteTestData();
    }

    @Test
    @TestOrder(120)
    public void testExec_B5() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        seikyuusyaInfoBean.setTsinyno("8889999");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj("請求者住所２");
        seikyuusyaInfoBean.setTsinadr3kj("請求者住所３");
        seikyuusyaInfoBean.setTsintelno("08012345678");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        toiawaseInfoBean.setTsinyno("9988888");
        toiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        toiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        toiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        toiawaseInfoBean.setTsintelno("09098765432");
        toiawaseInfoBean.setTelUktkKanouTime("");
        toiawaseInfoBean.setTelUktkkanouTimeHigou("");
        editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSouhuannaiBean.setSyono("10000000001");
        editSouhuannaiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KOUSG);
        editSouhuannaiBean.setJisatuMenseki(true);
        editSouhuannaiBean.setInitsbjiyensitihsytkhukaUmu(C_UmuKbn.ARI);
        editSouhuannaiBean.setHknkknKbn(C_HknKknKbn.DAI1HKNKKN);
        editSouhuannaiBean.setKykTuukasyu(C_Tuukasyu.JPY);
        editSouhuannaiBean.setMynumbertksUmuKbn(C_UmuKbn.ARI);

        insertTestData();
        ReportServicesBean reportServicesBean = editSouhuannai.exec(editSouhuannaiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）処理年月日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "8889999", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "請求者住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "請求者住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "郁郁", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "9988888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "09098765432", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "", "（ＩＲ）問合せ先電話受付可能時間");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "", "（ＩＲ）問合せ先電話受付可能時間備考");
        SiShannaiBean siShannaiBean = (SiShannaiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[0];
        exStringEquals(siShannaiBean.getIrTyouhyoutitle(), "", "（ＩＲ）帳票タイトル");
        exStringEquals(siShannaiBean.getIrMsg1(), null, "（ＩＲ）メッセージ１");
        exStringEquals(siShannaiBean.getIrMsg2(), null, "（ＩＲ）メッセージ２");
        exStringEquals(siShannaiBean.getIrMsg3(), null, "（ＩＲ）メッセージ３");
        exStringEquals(siShannaiBean.getIrMsg4(), null, "（ＩＲ）メッセージ４");
        exStringEquals(siShannaiBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siShannaiBean.getIrSyono(), "１０００００００００１", "（ＩＲ）証券番号");
        exStringEquals(siShannaiBean.getIrMsg6(), "【ご提出いただく書類】", "（ＩＲ）メッセージ６");
        exStringEquals(siShannaiBean.getIrMsg7(), "※別添えの『ご提出書類について』に記載されている書類の他に書類をご提出いただくことが", "（ＩＲ）メッセージ７");
        exStringEquals(siShannaiBean.getIrMsg8(), "　ありますので、あらかじめご了承ください。", "（ＩＲ）メッセージ８");
        exStringEquals(siShannaiBean.getIrMsg9(), "※戸籍関係書類につきましては、個人情報保護法遵守の観点から、必要事項確認後に廃棄させて", "（ＩＲ）メッセージ９");
        exStringEquals(siShannaiBean.getIrMsg10(), "　いただきます。戸籍関係書類が他にご入用等の場合は、写しをご提出ください。", "（ＩＲ）メッセージ１０");
        exStringEquals(siShannaiBean.getIrMsg11(), "※主治医による証明書（診断書）の証明など請求にかかる費用につきましては、お客さまのご負", "（ＩＲ）メッセージ１１");
        exStringEquals(siShannaiBean.getIrMsg12(), "　担になりますのでご了承ください。", "（ＩＲ）メッセージ１２");
        exStringEquals(siShannaiBean.getIrMsg13(), "※請求者が未成年の場合、親権者または後見人の方からご請求ください。ご請求に際しては", "（ＩＲ）メッセージ１３");
        exStringEquals(siShannaiBean.getIrMsg14(), "　親権者および未成年者との関係が分かる戸籍謄(抄)本をご提出ください。", "（ＩＲ）メッセージ１４");
        exStringEquals(siShannaiBean.getIrMsg15(), "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　以上", "（ＩＲ）メッセージ１５");
        exStringEquals(siShannaiBean.getIrMsg16(), null, "（ＩＲ）メッセージ１６");
        exStringEquals(siShannaiBean.getIrMsg17(), null, "（ＩＲ）メッセージ１７");
        exStringEquals(siShannaiBean.getIrMsg18(), null, "（ＩＲ）メッセージ１８");
        exStringEquals(siShannaiBean.getIrMsg19(), null, "（ＩＲ）メッセージ１９");
        exStringEquals(siShannaiBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siShannaiBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siShannaiBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siShannaiBean.getIrMsg23(), null, "（ＩＲ）メッセージ２３");
        exStringEquals(siShannaiBean.getIrMsg24(), null, "（ＩＲ）メッセージ２４");
        exStringEquals(siShannaiBean.getIrMsg25(), null, "（ＩＲ）メッセージ２５");
        exStringEquals(siShannaiBean.getIrMsg26(), null, "（ＩＲ）メッセージ２６");
        exStringEquals(siShannaiBean.getIrMsg27(), null, "（ＩＲ）メッセージ２７");
        exStringEquals(siShannaiBean.getIrMsg28(), null, "（ＩＲ）メッセージ２８");
        exStringEquals(siShannaiBean.getIrMsg29(), null, "（ＩＲ）メッセージ２９");
        exStringEquals(siShannaiBean.getIrMsg30(), null, "（ＩＲ）メッセージ３０");
        exStringEquals(siShannaiBean.getIrMsg31(), null, "（ＩＲ）メッセージ３１");
        exStringEquals(siShannaiBean.getIrMsg32(), null, "（ＩＲ）メッセージ３２");
        exStringEquals(siShannaiBean.getIrMsg33(), null, "（ＩＲ）メッセージ３３");
        exStringEquals(siShannaiBean.getIrMsg34(), null, "（ＩＲ）メッセージ３４");
        exStringEquals(siShannaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShannaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShannaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        deleteTestData();
    }
    @Test
    @TestOrder(130)
    public void testExec_B6() {
        EditSouhuannaiBean editSouhuannaiBean = SWAKInjector.getInstance(EditSouhuannaiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("郁郁");
        seikyuusyaInfoBean.setTsinyno("8889999");
        seikyuusyaInfoBean.setTsinadr1kj("請求者住所１");
        seikyuusyaInfoBean.setTsinadr2kj(null);
        seikyuusyaInfoBean.setTsinadr3kj(null);
        seikyuusyaInfoBean.setTsintelno("08012345678");
        editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        toiawaseInfoBean.setTsinyno("9988888");
        toiawaseInfoBean.setTsinadr1kj("問合せ先住所１");
        toiawaseInfoBean.setTsinadr2kj("問合せ先住所２");
        toiawaseInfoBean.setTsinadr3kj("問合せ先住所３");
        toiawaseInfoBean.setTsintelno("09098765432");
        toiawaseInfoBean.setTelUktkKanouTime("");
        toiawaseInfoBean.setTelUktkkanouTimeHigou("");
        editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSouhuannaiBean.setSyono("10000000001");
        editSouhuannaiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editSouhuannaiBean.setJisatuMenseki(false);
        editSouhuannaiBean.setInitsbjiyensitihsytkhukaUmu(C_UmuKbn.ARI);
        editSouhuannaiBean.setHknkknKbn(C_HknKknKbn.DAI1HKNKKN);
        editSouhuannaiBean.setKykTuukasyu(C_Tuukasyu.USD);
        editSouhuannaiBean.setMynumbertksUmuKbn(C_UmuKbn.ARI);

        insertTestData();
        ReportServicesBean reportServicesBean = editSouhuannai.exec(editSouhuannaiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）処理年月日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "8889999", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "請求者住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), null, "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), null, "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "郁郁", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "9988888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "09098765432", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "", "（ＩＲ）問合せ先電話受付可能時間");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "", "（ＩＲ）問合せ先電話受付可能時間備考");
        SiShannaiBean siShannaiBean = (SiShannaiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SOUHU.getValue())[0];
        exStringEquals(siShannaiBean.getIrTyouhyoutitle(), "死亡保険金請求手続きのご案内", "（ＩＲ）帳票タイトル");
        exStringEquals(siShannaiBean.getIrMsg1(), "このたびご訃報に接し、ご一同様にはさぞかしお力落としのことと謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siShannaiBean.getIrMsg2(), "故人ご生前にはひとかたならぬご愛顧を賜り、誠にありがとうございました。", "（ＩＲ）メッセージ２");
        exStringEquals(siShannaiBean.getIrMsg3(), "下記のとおりご案内申し上げますので、請求書類をお取りそろえのうえ、ご提出くださいますよう", "（ＩＲ）メッセージ３");
        exStringEquals(siShannaiBean.getIrMsg4(), "お願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siShannaiBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siShannaiBean.getIrSyono(), "１０００００００００１", "（ＩＲ）証券番号");
        exStringEquals(siShannaiBean.getIrMsg6(), "【ご提出いただく書類】", "（ＩＲ）メッセージ６");
        exStringEquals(siShannaiBean.getIrMsg7(), "　死亡保険金請求手続きで必要な書類は『ご提出書類について』をご確認ください。", "（ＩＲ）メッセージ７");
        exStringEquals(siShannaiBean.getIrMsg8(), "　また、このお手続きと合わせてマイナンバーのご提供をお願いしております。", "（ＩＲ）メッセージ８");
        exStringEquals(siShannaiBean.getIrMsg9(), "", "（ＩＲ）メッセージ９");
        exStringEquals(siShannaiBean.getIrMsg10(), "【円貨でのお支払いについて】", "（ＩＲ）メッセージ１０");
        exStringEquals(siShannaiBean.getIrMsg11(), "　・保険金を円貨によりお受け取りできます。", "（ＩＲ）メッセージ１１");
        exStringEquals(siShannaiBean.getIrMsg12(), "　　円貨でお受取りになる場合、為替レートの変動による影響を受けます。", "（ＩＲ）メッセージ１２");
        exStringEquals(siShannaiBean.getIrMsg13(), "　・円貨への換算に適用する為替レートは、請求日（整備された必要書類が当社に到着した日）", "（ＩＲ）メッセージ１３");
        exStringEquals(siShannaiBean.getIrMsg14(), "　　における、当社所定の為替レート「ＴＴＭ（対顧客電信売買相場仲値）－５０銭」となり", "（ＩＲ）メッセージ１４");
        exStringEquals(siShannaiBean.getIrMsg15(), "　　ます。", "（ＩＲ）メッセージ１５");
        exStringEquals(siShannaiBean.getIrMsg16(), "　・当社所定の為替レートは、住友生命ホームページにてご確認いただけます。", "（ＩＲ）メッセージ１６");
        exStringEquals(siShannaiBean.getIrMsg17(), "", "（ＩＲ）メッセージ１７");
        exStringEquals(siShannaiBean.getIrMsg18(), "【指定通貨（外貨）でのお支払いについて】", "（ＩＲ）メッセージ１８");
        exStringEquals(siShannaiBean.getIrMsg19(), "　・保険金を指定された通貨（外貨）でお受け取りできます。指定通貨（外貨）でのお受取りが", "（ＩＲ）メッセージ１９");
        exStringEquals(siShannaiBean.getIrMsg20(), "　　可能な日本国内にある金融機関口座をご指定ください。", "（ＩＲ）メッセージ２０");
        exStringEquals(siShannaiBean.getIrMsg21(), "　　※円貨口座を記入されると、当社から送金した指定通貨（外貨）が自動的に円貨に両替され", "（ＩＲ）メッセージ２１");
        exStringEquals(siShannaiBean.getIrMsg22(), "　　　て入金される場合があります。", "（ＩＲ）メッセージ２２");
        exStringEquals(siShannaiBean.getIrMsg23(), "", "（ＩＲ）メッセージ２３");
        exStringEquals(siShannaiBean.getIrMsg24(), "【初期死亡時円換算支払額最低保証特約について】", "（ＩＲ）メッセージ２４");
        exStringEquals(siShannaiBean.getIrMsg25(), "　・保険金の円換算額が基準金額を下回るときは、基準金額をお支払いします。", "（ＩＲ）メッセージ２５");
        exStringEquals(siShannaiBean.getIrMsg26(), "　・指定通貨建の保険金をお支払いすることもできます。", "（ＩＲ）メッセージ２６");
        exStringEquals(siShannaiBean.getIrMsg27(), "　　この場合、基準金額の最低保証はありません。", "（ＩＲ）メッセージ２７");
        exStringEquals(siShannaiBean.getIrMsg28(), "", "（ＩＲ）メッセージ２８");
        exStringEquals(siShannaiBean.getIrMsg29(), "※別添えの『ご提出書類について』に記載されている書類の他に書類をご提出いただくことが", "（ＩＲ）メッセージ２９");
        exStringEquals(siShannaiBean.getIrMsg30(), "　ありますので、あらかじめご了承ください。", "（ＩＲ）メッセージ３０");
        exStringEquals(siShannaiBean.getIrMsg31(), "※戸籍関係書類につきましては、個人情報保護法遵守の観点から、必要事項確認後に廃棄させて", "（ＩＲ）メッセージ３１");
        exStringEquals(siShannaiBean.getIrMsg32(), "　いただきます。戸籍関係書類が他にご入用等の場合は、写しをご提出ください。", "（ＩＲ）メッセージ３２");
        exStringEquals(siShannaiBean.getIrMsg33(), "※主治医による証明書（診断書）の証明など請求にかかる費用につきましては、お客さまのご負", "（ＩＲ）メッセージ３３");
        exStringEquals(siShannaiBean.getIrMsg34(), "　担になりますのでご了承ください。", "（ＩＲ）メッセージ３４");
        exStringEquals(siShannaiBean.getIrMsg35(), "※請求者が未成年の場合、親権者または後見人の方からご請求ください。ご請求に際しては", "（ＩＲ）メッセージ３５");
        exStringEquals(siShannaiBean.getIrMsg36(), "　親権者および未成年者との関係が分かる戸籍謄(抄)本をご提出ください。", "（ＩＲ）メッセージ３６");
        exStringEquals(siShannaiBean.getIrMsg37(), "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　以上", "（ＩＲ）メッセージ３７");
        deleteTestData();
    }
}
