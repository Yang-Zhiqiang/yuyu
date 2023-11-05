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
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.siharai.bean.report.SiShrmeisaiSindansyoBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払明細書編集（診断書料支払）のメソッド{@link EditSiharaimeisaisyoSindansyo#exec(EditSiharaimeisaisyoSindansyoBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSiharaimeisaisyoSindansyoTest_exec {

    @Inject
    EditSiharaimeisaisyoSindansyo editSiharaimeisaisyoSindansyo;

    @Inject
    SiharaiDomManager siharaiDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_支払明細書編集（診断書料支払）";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSiharaimeisaisyoSindansyoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk003", "SINDANSYO_ANNAI_NAIYOU1"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk003", "SINDANSYO_ANNAI_NAIYOU2"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk003", "SINDANSYO_ANNAI_NAIYOU3"));
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        EditSiharaimeisaisyoSindansyoBean editSiharaimeisaisyoSindansyoBean =
            SWAKInjector.getInstance(EditSiharaimeisaisyoSindansyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editSiharaimeisaisyoSindansyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSiharaimeisaisyoSindansyo.exec(editSiharaimeisaisyoSindansyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        EditSiharaimeisaisyoSindansyoBean editSiharaimeisaisyoSindansyoBean =
            SWAKInjector.getInstance(EditSiharaimeisaisyoSindansyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editSiharaimeisaisyoSindansyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSiharaimeisaisyoSindansyo.exec(editSiharaimeisaisyoSindansyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        EditSiharaimeisaisyoSindansyoBean editSiharaimeisaisyoSindansyoBean =
            SWAKInjector.getInstance(EditSiharaimeisaisyoSindansyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editSiharaimeisaisyoSindansyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSiharaimeisaisyoSindansyo.exec(editSiharaimeisaisyoSindansyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        EditSiharaimeisaisyoSindansyoBean editSiharaimeisaisyoSindansyoBean =
            SWAKInjector.getInstance(EditSiharaimeisaisyoSindansyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        editSiharaimeisaisyoSindansyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSiharaimeisaisyoSindansyoBean.setSeikyuusyaInfoBean(null);

        try {
            editSiharaimeisaisyoSindansyo.exec(editSiharaimeisaisyoSindansyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyaInfoBean'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {
        EditSiharaimeisaisyoSindansyoBean editSiharaimeisaisyoSindansyoBean =
            SWAKInjector.getInstance(EditSiharaimeisaisyoSindansyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者（漢字）");

        editSiharaimeisaisyoSindansyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSiharaimeisaisyoSindansyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        editSiharaimeisaisyoSindansyoBean.setToiawaseInfoBean(null);

        try {
            editSiharaimeisaisyoSindansyo.exec(editSiharaimeisaisyoSindansyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='toiawaseInfoBean'", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_B1() {

        EditSiharaimeisaisyoSindansyoBean editSiharaimeisaisyoSindansyoBean =
            SWAKInjector.getInstance(EditSiharaimeisaisyoSindansyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);
        editSiharaimeisaisyoSindansyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者（漢字）");
        seikyuusyaInfoBean.setTsinyno("1122333");
        seikyuusyaInfoBean.setTsinadr1kj("通信先住所１（漢字）");
        seikyuusyaInfoBean.setTsinadr2kj("通信先住所２（漢字）");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３（漢字）");
        seikyuusyaInfoBean.setTsintelno("1122477");
        editSiharaimeisaisyoSindansyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm("組織名");
        toiawaseInfoBean.setTsinyno("1633444");
        toiawaseInfoBean.setTsinadr1kj("先住所１（漢字）");
        toiawaseInfoBean.setTsinadr2kj("先住所２（漢字）");
        toiawaseInfoBean.setTsinadr3kj("先住所３（漢字）");
        toiawaseInfoBean.setTsintelno("1122477");
        toiawaseInfoBean.setTelUktkKanouTime("");
        toiawaseInfoBean.setTelUktkkanouTimeHigou("");

        editSiharaimeisaisyoSindansyoBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSiharaimeisaisyoSindansyoBean.setSyoNo("SN000000001");
        editSiharaimeisaisyoSindansyoBean.setTyakkinYmd(BizDate.valueOf(20151211));
        editSiharaimeisaisyoSindansyoBean.setKyuuhuNameReport("診断書取得費用相当額");
        editSiharaimeisaisyoSindansyoBean.setSindansyomaisuu(99);
        editSiharaimeisaisyoSindansyoBean.setSindansyo(BizCurrency.valueOf(534600));
        editSiharaimeisaisyoSindansyoBean.setBanknmKj("銀行名（漢字）");
        editSiharaimeisaisyoSindansyoBean.setSitennmKj("支店名（漢字）");
        editSiharaimeisaisyoSindansyoBean.setYokinKbn(C_YokinKbn.HUTUU);
        editSiharaimeisaisyoSindansyoBean.setKouzaNo("556677");
        editSiharaimeisaisyoSindansyoBean.setKzmeiginmKn("カナ");

        ReportServicesBean reportServicesBean = editSiharaimeisaisyoSindansyo.exec(editSiharaimeisaisyoSindansyoBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "SN000000001", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(),BizDate.valueOf(20151212),"処理日付");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SHMEISAI_SDS.getValue())[1];
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月12日", "（ＩＲ）処理年月日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "1122333", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１（漢字）", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２（漢字）", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３（漢字）", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "請求者（漢字）", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "1633444", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "先住所１（漢字）", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "先住所２（漢字）", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "先住所３（漢字）", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "1122477", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "", "（ＩＲ）問合せ先電話受付可能時間");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "", "（ＩＲ）問合せ先電話受付可能時間備考");

        SiShrmeisaiSindansyoBean siShrmeisaiSindansyoBean = (SiShrmeisaiSindansyoBean) reportServicesBean.getParamObjectsData()
            .get(editSiharaimeisaisyoSindansyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg1(),"診断書取得費用相当額お支払いのお知らせ","（ＩＲ）メッセージ１");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg2(),"このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払",
            "（ＩＲ）メッセージ２");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg3(),"い等いたしかねるとの結論にいたりました。","（ＩＲ）メッセージ３");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg4(),"つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い",
            "（ＩＲ）メッセージ４");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg5(),"をさせていただきます。","（ＩＲ）メッセージ５");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg6(), null, "（ＩＲ）メッセージ６");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg7(),"※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該",
            "（ＩＲ）メッセージ７");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg8(),"　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、",
            "（ＩＲ）メッセージ８");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg9(),"　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい",
            "（ＩＲ）メッセージ９");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg10(),"　ただきます。","（ＩＲ）メッセージ１０");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg11(),"　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま",
            "（ＩＲ）メッセージ１１");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg12(),"　す。","（ＩＲ）メッセージ１１");
        exStringEquals(siShrmeisaiSindansyoBean.getIrMsg13(), null, "（ＩＲ）メッセージ１３");
        exStringEquals(siShrmeisaiSindansyoBean.getIrSyono(),"ＳＮ００００００００１","（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiSindansyoBean.getIrTyakkinymd(),"２０１５年１２月１１日","（ＩＲ）着金日");
        exStringEquals(siShrmeisaiSindansyoBean.getIrKyuuhuname(),"診断書取得費用相当額","（ＩＲ）給付名");
        exStringEquals(siShrmeisaiSindansyoBean.getIrShrdetailbikou(),"診断書９９枚","（ＩＲ）支払明細備考");
        exBizCalcbleEquals(siShrmeisaiSindansyoBean.getIrShrgk(),BizCurrency.valueOf(534600),"（ＩＲ）支払明細備考");
        exStringEquals(siShrmeisaiSindansyoBean.getIrBanknmkj(),"銀行名（漢字）","（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiSindansyoBean.getIrSitennmkj(),"支店名（漢字）","（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiSindansyoBean.getIrYokinknmkj(),"普通","（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiSindansyoBean.getIrKouzano(),"556677","（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiSindansyoBean.getIrKzmeiginmkn(),"カナ","（ＩＲ）口座名義人氏名（カナ）");
    }
}
