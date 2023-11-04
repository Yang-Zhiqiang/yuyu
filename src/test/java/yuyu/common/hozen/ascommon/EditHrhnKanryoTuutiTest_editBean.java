package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.hozen.bean.report.KhHrhnKanryoTuutiBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 払変完了通知編集クラスのメソッド {@link EditHrhnKanryoTuuti#editBean(IT_HrhnTtdkKan,BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditHrhnKanryoTuutiTest_editBean {

    @Inject
    private EditHrhnKanryoTuuti editHrhnKanryoTuuti;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_払変完了通知編集";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditHrhnKanryoTuutiTest_editBean.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testEditBean_A1() {

        IT_HrhnTtdkKan hrhnTtdkKan = hozenDomManager.getKykKihon("11807111118").getHrhnTtdkKans().get(0);
        ReportServicesBean reportServicesBean = editHrhnKanryoTuuti.editBean(hrhnTtdkKan, BizDate.valueOf(20171211));

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20171211), "処理日付");
        KhHrhnKanryoTuutiBean khHrhnKanryoTuutiBean = (KhHrhnKanryoTuutiBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI.getValue())[0]);
        exStringEquals(khHrhnKanryoTuutiBean.getIrTyouhyousakuseiymd(), "2017年 1月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khHrhnKanryoTuutiBean.getIrSyono(), "11807111118", "（ＩＲ）証券番号");
        exStringEquals(khHrhnKanryoTuutiBean.getIrKyknmkj(), "契約者名名契約者名名契約者名名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHhknnmkj(), "被保険者名被保険者名被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkkaisuutkiktbrisyu(), "12", "（ＩＲ）払込回数・定期一括払種類");
        exClassificationEquals(khHrhnKanryoTuutiBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exBizCalcbleEquals(khHrhnKanryoTuutiBean.getIrHrkp(), BizCurrency.valueOf(9999999999999l), "（ＩＲ）払込保険料");
        exDateYMEquals(khHrhnKanryoTuutiBean.getIrKouryokuhasseiym(), BizDateYM.valueOf(201702), "（ＩＲ）効力発生年月");
        exStringEquals(khHrhnKanryoTuutiBean.getIrKouzamaskingmsg(), "口座マスキングＭＳＧ口座マスキングＭＳＧ口座マスキングＭＳＧ１２", "（ＩＲ）口座マスキングＭＳＧ");
        exStringEquals(khHrhnKanryoTuutiBean.getIrMsgarea34keta1(), "上記口座からの振替開始年月００上記口座からの振替開始年月００１１１１", "（ＩＲ）メッセージエリア（３４桁）１");
        exStringEquals(khHrhnKanryoTuutiBean.getIrMsgarea34keta2(), "上記口座からの振替開始年月００上記口座からの振替開始年月００２２２２", "（ＩＲ）メッセージエリア（３４桁）２");
        exStringEquals(khHrhnKanryoTuutiBean.getIrMsgarea34keta3(), "上記口座からの振替開始年月００上記口座からの振替開始年月００３３３３", "（ＩＲ）メッセージエリア（３４桁）３");
        exStringEquals(khHrhnKanryoTuutiBean.getIrMsgarea34keta4(), "上記口座からの振替開始年月００上記口座からの振替開始年月００４４４４", "（ＩＲ）メッセージエリア（３４桁）４");
        exStringEquals(khHrhnKanryoTuutiBean.getIrMsgarea34keta5(), "上記口座からの振替開始年月００上記口座からの振替開始年月００５５５５", "（ＩＲ）メッセージエリア（３４桁）５");
        exStringEquals(khHrhnKanryoTuutiBean.getIrMsgarea34keta6(), "上記口座からの振替開始年月００上記口座からの振替開始年月００６６６６", "（ＩＲ）メッセージエリア（３４桁）６");
        exStringEquals(khHrhnKanryoTuutiBean.getIrMsgarea34keta7(), "上記口座からの振替開始年月００上記口座からの振替開始年月００７７７７", "（ＩＲ）メッセージエリア（３４桁）７");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta1(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００１", "（ＩＲ）振替予告メッセージ（３４桁）１");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta2(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００２", "（ＩＲ）振替予告メッセージ（３４桁）２");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta3(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００３", "（ＩＲ）振替予告メッセージ（３４桁）３");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta4(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００４", "（ＩＲ）振替予告メッセージ（３４桁）４");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta5(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００５", "（ＩＲ）振替予告メッセージ（３４桁）５");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta6(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００６", "（ＩＲ）振替予告メッセージ（３４桁）６");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta7(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００７", "（ＩＲ）振替予告メッセージ（３４桁）７");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta8(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００８", "（ＩＲ）振替予告メッセージ（３４桁）８");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta9(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ００００９", "（ＩＲ）振替予告メッセージ（３４桁）９");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta10(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１０", "（ＩＲ）振替予告メッセージ（３４桁）１０");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta11(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１１", "（ＩＲ）振替予告メッセージ（３４桁）１１");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta12(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１２", "（ＩＲ）振替予告メッセージ（３４桁）１２");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta13(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１３", "（ＩＲ）振替予告メッセージ（３４桁）１３");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta14(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１４", "（ＩＲ）振替予告メッセージ（３４桁）１４");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta15(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１５", "（ＩＲ）振替予告メッセージ（３４桁）１５");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta16(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１６", "（ＩＲ）振替予告メッセージ（３４桁）１６");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta17(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１７", "（ＩＲ）振替予告メッセージ（３４桁）１７");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta18(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１８", "（ＩＲ）振替予告メッセージ（３４桁）１８");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta19(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００１９", "（ＩＲ）振替予告メッセージ（３４桁）１９");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta20(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２０", "（ＩＲ）振替予告メッセージ（３４桁）２０");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta21(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２１", "（ＩＲ）振替予告メッセージ（３４桁）２１");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta22(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２２", "（ＩＲ）振替予告メッセージ（３４桁）２２");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta23(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２３", "（ＩＲ）振替予告メッセージ（３４桁）２３");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta24(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２４", "（ＩＲ）振替予告メッセージ（３４桁）２４");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta25(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２５", "（ＩＲ）振替予告メッセージ（３４桁）２５");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta26(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２６", "（ＩＲ）振替予告メッセージ（３４桁）２６");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta27(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２７", "（ＩＲ）振替予告メッセージ（３４桁）２７");
        exStringEquals(khHrhnKanryoTuutiBean.getIrHrkykkmsg34keta28(), "振替予告メッセージ０振替予告メッセージ０振替予告メッセージ０００２８", "（ＩＲ）振替予告メッセージ（３４桁）２８");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI.getValue())[1]);
        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2017年 1月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "送付先住所１送付先住所１送付先住所１送付先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "送付先住所１送付先住所２送付先住所２送付先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "送付先住所２送付先住所２送付先住所３送付先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "送付先氏名送付先氏名送付先氏名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "問合せ先会社名１２３", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "問合せ先組織名問合せ先組織名１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "12345678", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１問合せ先住所１１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所１問合せ先住所１２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所１問合せ先住所１３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "12345678901234", "（ＩＲ）問合せ先電話番号");
    }

}
