package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 払変完了通知編集クラスのメソッド {@link EditHrhnKanryoTuuti#editTBL(KhozenCommonParam,IT_KykKihon,EditHrhnKanryoTuutiParam,BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditHrhnKanryoTuutiTest_editTBL {

    @Inject
    private EditHrhnKanryoTuuti editHrhnKanryoTuuti;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private static String callcentersosikicd;

    private static String hokenKaisyaNmKanji;

    private static String uketimecallcenter1;

    private static String uketimecallcenter2;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_払変完了通知編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditHrhnKanryoTuutiTest_editTBL.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetCreditUriageSeikyuubi.class).to(SetCreditUriageSeikyuubiMockForKhansyuu.class);
            }
        });
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @BeforeClass
    public static void testInit() {

        SetCreditUriageSeikyuubiMockForKhansyuu.caller = EditHrhnKanryoTuutiTest_editTBL.class;

        callcentersosikicd = YuyuBizConfig.getInstance().getCallcentersosikicd();
        hokenKaisyaNmKanji = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();
        uketimecallcenter1 = YuyuBizConfig.getInstance().getUketimecallcenter1();
        uketimecallcenter2 = YuyuBizConfig.getInstance().getUketimecallcenter2();

    }

    @AfterClass
    public static void testClear() {

        SetCreditUriageSeikyuubiMockForKhansyuu.caller = null;

        YuyuBizConfig.getInstance().setCallcentersosikicd(callcentersosikicd);
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji(hokenKaisyaNmKanji);
        YuyuBizConfig.getInstance().setUketimecallcenter1(uketimecallcenter1);
        YuyuBizConfig.getInstance().setUketimecallcenter2(uketimecallcenter2);

    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(null);
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.TYOKUSOU);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(100));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170117));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111118", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170117), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、口座番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "年２回払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(100), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "札幌信用金庫", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "本店営業部", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "当座預金　口座番号　１２３４５６７８９＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ　様", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "上記口座からの振替開始年月　２０１７年　２月", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "＊次は２０１７年　６月の振替となります。ご注意ください。", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "【　お願い　】", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "せください。", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　と表示しております。", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "Z01", "本社回送理由");

    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(null);
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.TYOKUSOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170116));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111129", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170116), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "年１回払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "上記口座からの振替開始年月　２０１７年　１月", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【　お願い　】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "せください。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "Z02", "本社回送理由");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20181204));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111130", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20181204), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "６か月定期一括払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "上記口座からの振替開始年月　２０１８年１２月", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "＊次は２０１９年　６月の振替となります。ご注意ください。", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "【　お願い　】", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "せください。", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　と表示しております。", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201707));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20181204));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111141", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20181204), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "１２か月定期一括払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "上記口座からの振替開始年月　２０１８年１２月", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "＊次は２０１９年１２月の振替となります。ご注意ください。", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "【　お願い　】", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "せください。", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　と表示しております。", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111152");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201706));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170115));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111152", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170115), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "年１回払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【　お願い　】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "せください。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111163");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201702));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111163", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【　お願い　】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "せください。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "＊当通知は口座変更完了のお知らせになります。", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "　払込回数のご変更は２０１７年　１月の保険料より適用となります。", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111174");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201703));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setHrkkeiro(C_Hrkkeiro.CREDIT);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111174", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料振替予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　６月２７日（振替日）・・・２０１７年　３月から４か月分", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "○２０１７年　７月２７日（振替日）・・・２０１７年　７月から１か月分", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "○以降、毎月２７日（金融機関休日のときは翌営業日）に１か月分ずつ", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　ご指定口座から振り替えさせていただきます。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊クレジットカードによる保険料お払込み等により、保険料振替予定が", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　変更となることがございます。予めご了承願います。", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "　と表示しております。", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111185");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111185", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.DANTAI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【　お願い　】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "せください。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111196");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201702));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111196", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料振替予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　６月２７日（振替日）より、変更後のご指定口座からの", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "　振り替えが開始します。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　と表示しております。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111200");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201704));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setHrkkeiro(C_Hrkkeiro.CREDIT);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111200", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料振替予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　６月２７日（振替日）・・・２０１７年　４月から３か月分", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "○２０１７年　７月２７日（振替日）・・・２０１７年　７月から１か月分", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "○以降、毎月２７日（金融機関休日のときは翌営業日）に１か月分ずつ", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　ご指定口座から振り替えさせていただきます。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊クレジットカードによる保険料お払込み等により、保険料振替予定が", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　変更となることがございます。予めご了承願います。", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "　と表示しております。", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111211");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201705));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setHrkkeiro(C_Hrkkeiro.HURIKAE);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料振替予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　６月２７日（振替日）・・・２０１７年　５月から２か月分", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "○２０１７年　７月２７日（振替日）・・・２０１７年　７月から１か月分", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "○以降、毎月２７日（金融機関休日のときは翌営業日）に１か月分ずつ", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　ご指定口座から振り替えさせていただきます。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊なお、ご契約内容の変更等により、２０１７年　６月２７日（振替日）", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　には１か月分の保険料を、翌月には２か月分の保険料を振り替えさせ", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　ていただくことがございます。予めご了承ください。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "　と表示しております。", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111222");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201706));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setHrkkeiro(C_Hrkkeiro.HURIKAE);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111222", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料振替予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　６月２７日（振替日）・・・２０１７年　６月から１か月分", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "○以降、毎月２７日（金融機関休日のときは翌営業日）に１か月分ずつ", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "　ご指定口座から振り替えさせていただきます。", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "　と表示しております。", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111233");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201706));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111233", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料振替予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　６月２７日（振替日）より、変更後のご指定口座からの", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "　振り替えが開始します。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　と表示しております。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }


    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111222");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201707));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111222", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【　お願い　】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "せください。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A15() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111244");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(null);
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.TYOKUSOU);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(100));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170117));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111244", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170117), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、口座番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "年２回払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(100), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "札幌信用金庫", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "本店営業部", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "当座預金　口座番号　１２３４５６７８９＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ　様", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "上記口座からの振替開始年月　２０１７年　２月", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "＊次は２０１７年　６月の振替となります。ご注意ください。", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "【　お願い　】", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "せください。", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　と表示しております。", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "Z01", "本社回送理由");

    }

    @Test
    @TestOrder(160)
    public void testEditTBL_A16() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111255");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(null);
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.TYOKUSOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170116));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111255", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170116), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "年１回払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "上記口座からの振替開始年月　２０１７年　１月", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【　お願い　】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "せください。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }


    @Test
    @TestOrder(170)
    public void testEditTBL_A17() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111266");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20181204));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111266", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20181204), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "６か月定期一括払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "上記口座からの振替開始年月　２０１８年１２月", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "＊次は２０１９年　６月の振替となります。ご注意ください。", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "【　お願い　】", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "せください。", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　と表示しております。", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(180)
    public void testEditTBL_A18() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111277");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201707));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20181204));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111277", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20181204), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "１２か月定期一括払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), BizDateYM.valueOf(201701), "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "上記口座からの振替開始年月　２０１８年１２月", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "＊次は２０１９年１２月の振替となります。ご注意ください。", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "【　お願い　】", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "せください。", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　と表示しております。", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }

    @Test
    @TestOrder(190)
    public void testEditTBL_A19() {

        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForKhansyuu.SYORIPTN = SetCreditUriageSeikyuubiMockForKhansyuu.TESTPATTERN1;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111288");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setCardBrandKbn(C_CardBrandKbn.VISA);
        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4("1000100");

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20171207));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111288", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20171207), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のクレジットカード＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ＶＩＳＡ", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "カード番号　＊＊＊＊　＊＊＊＊　＊＊＊＊　１０００１００", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "います。", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "○以降、毎月１５日をご利用日として、１か月分の保険料をクレジット", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "　カードにて決済させていただきます。", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの保", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "　険料の振替日はクレジットカード会社によって異なり、ご利用日の翌", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "　月や翌々月となることがあります。", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "【　お願い　】", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "せください。", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "　と表示しております。", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
        MockObjectManager.assertArgumentPassed(SetCreditUriageSeikyuubiMockForKhansyuu.class, "exec", 0, BizDate.valueOf(20171207));
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_A20() {

        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForKhansyuu.SYORIPTN = SetCreditUriageSeikyuubiMockForKhansyuu.TESTPATTERN2;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807001114");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setCardBrandKbn(C_CardBrandKbn.VISA);
        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4("1000100");

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20171107));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807001114", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20171107), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のクレジットカード＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ＶＩＳＡ", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "カード番号　＊＊＊＊　＊＊＊＊　＊＊＊＊　１０００１００", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "います。", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料お払込予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年１１月１５日（ご利用日）：２０１７年　８月から４か月分", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "○２０１７年１１月１５日（ご利用日）：２０１７年１２月から１か月分", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "○以降、毎月１５日をご利用日として、１か月分の保険料をクレジット", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　カードにて決済させていただきます。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの保", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　険料の振替日はクレジットカード会社によって異なり、ご利用日の翌", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　月や翌々月となることがあります。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "　と表示しております。", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_A21() {

        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForKhansyuu.SYORIPTN = SetCreditUriageSeikyuubiMockForKhansyuu.TESTPATTERN3;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807001125");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setCardBrandKbn(C_CardBrandKbn.VISA);
        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4("1000100");

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20171007));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807001125", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20171007), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のクレジットカード＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ＶＩＳＡ", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "カード番号　＊＊＊＊　＊＊＊＊　＊＊＊＊　１０００１００", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "います。", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料お払込予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年１０月１５日（ご利用日）：２０１７年　８月から３か月分", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "○２０１７年１０月１５日（ご利用日）：２０１７年１１月から１か月分", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "○以降、毎月１５日をご利用日として、１か月分の保険料をクレジット", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　カードにて決済させていただきます。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの保", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　険料の振替日はクレジットカード会社によって異なり、ご利用日の翌", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　月や翌々月となることがあります。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "　と表示しております。", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
    }
    @Test
    @TestOrder(220)
    public void testEditTBL_A22() {

        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForKhansyuu.SYORIPTN = SetCreditUriageSeikyuubiMockForKhansyuu.TESTPATTERN4;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807001136");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setCardBrandKbn(C_CardBrandKbn.VISA);
        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4("1000100");

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170907));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807001136", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170907), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のクレジットカード＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ＶＩＳＡ", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "カード番号　＊＊＊＊　＊＊＊＊　＊＊＊＊　１０００１００", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "います。", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料お払込予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　９月１５日（ご利用日）：２０１７年　８月から２か月分", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "○２０１７年　９月１５日（ご利用日）：２０１７年１０月から１か月分", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "○以降、毎月１５日をご利用日として、１か月分の保険料をクレジット", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　カードにて決済させていただきます。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの保", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　険料の振替日はクレジットカード会社によって異なり、ご利用日の翌", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　月や翌々月となることがあります。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "　と表示しております。", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
    }

    @Test
    @TestOrder(230)
    public void testEditTBL_A23() {

        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForKhansyuu.SYORIPTN = SetCreditUriageSeikyuubiMockForKhansyuu.TESTPATTERN5;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807001147");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setCardBrandKbn(C_CardBrandKbn.VISA);
        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4("1000100");

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170807));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807001147", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170807), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のクレジットカード＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ＶＩＳＡ", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "カード番号　＊＊＊＊　＊＊＊＊　＊＊＊＊　１０００１００", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "います。", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料お払込予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　８月１５日（ご利用日）に、２０１７年　８月から", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "　１か月分の保険料をクレジットカードにて決済させていただきます。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "○以降、毎月１５日をご利用日として、１か月分の保険料をクレジット", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "　カードにて決済させていただきます。", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの保", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "　険料の振替日はクレジットカード会社によって異なり、ご利用日の翌", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　月や翌々月となることがあります。", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "　と表示しております。", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
    }

    @Test
    @TestOrder(240)
    public void testEditTBL_A24() {

        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForKhansyuu.SYORIPTN = SetCreditUriageSeikyuubiMockForKhansyuu.TESTPATTERN6;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807001158");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setCardBrandKbn(C_CardBrandKbn.VISA);
        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4("1000100");

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170707));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807001158", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170707), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のクレジットカード＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ＶＩＳＡ", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "カード番号　＊＊＊＊　＊＊＊＊　＊＊＊＊　１０００１００", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "います。", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "○以降、毎月１５日をご利用日として、１か月分の保険料をクレジット", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "　カードにて決済させていただきます。", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの保", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "　険料の振替日はクレジットカード会社によって異なり、ご利用日の翌", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "　月や翌々月となることがあります。", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "【　お願い　】", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "せください。", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "　と表示しております。", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
    }

    @Test
    @TestOrder(250)
    public void testEditTBL_A25() {

        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForKhansyuu.SYORIPTN = SetCreditUriageSeikyuubiMockForKhansyuu.TESTPATTERN7;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807001169");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setCardBrandKbn(C_CardBrandKbn.VISA);
        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4("1000100");

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170807));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807001169", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170807), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のクレジットカード＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ＶＩＳＡ", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "カード番号　＊＊＊＊　＊＊＊＊　＊＊＊＊　１０００１００", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "います。", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料お払込予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　８月１５日（ご利用日）より、変更後のクレジットカード", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "　での決済が開始します。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの保", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "　険料の振替日はクレジットカード会社によって異なり、ご利用日の翌", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　月や翌々月となることがあります。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
    }

    @Test
    @TestOrder(260)
    public void testEditTBL_A26() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807001170");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201708));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));
        editHrhnKanryoTuutiParam.setCardBrandKbn(C_CardBrandKbn.VISA);
        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4("1000100");

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807001170", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のクレジットカード＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ＶＩＳＡ", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "カード番号　＊＊＊＊　＊＊＊＊　＊＊＊＊　１０００１００", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "います。", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【　お願い　】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "せください。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
    }

    @Test
    @TestOrder(270)
    public void testEditTBL_A27() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807001181");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201702));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807001181", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【　お願い　】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "せください。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "●新しいご住所・電話番号", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "●ご加入いただいているすべての証券番号", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "●契約者さまのお名前", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "　と表示しております。", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");
    }

    @Test
    @TestOrder(280)
    public void testEditTBL_A28() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditHrhnKanryoTuuti");
        AM_User user = new AM_User();
        user.setUserId("JUnitTest");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111196");

        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
        editHrhnKanryoTuutiParam.setHennyuym(BizDateYM.valueOf(201701));
        editHrhnKanryoTuutiParam.setJkipJytym(BizDateYM.valueOf(201702));
        editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.HONSYAKAISOU);
        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(C_UmuKbn.NONE);
        editHrhnKanryoTuutiParam.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        editHrhnKanryoTuutiParam.setHrkp(BizCurrency.valueOf(552233));

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("住友生命保険相互会社");
        YuyuBizConfig.getInstance().setUketimecallcenter1("受付時間　　午前９時～午後６時");
        YuyuBizConfig.getInstance().setUketimecallcenter2("　　　（土・日・祝日・年末年始除く）");

        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam,
            BizDate.valueOf(20170607));

        exStringEquals(hrhnTtdkKan.getSyono(), "11807111196", "証券番号");
        exClassificationEquals(hrhnTtdkKan.getSyoruiCd(), C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP, "書類コード");
        exDateEquals(hrhnTtdkKan.getTyouhyouymd(), BizDate.valueOf(20170607), "帳票作成日");
        exStringEquals(hrhnTtdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(hrhnTtdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(hrhnTtdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(hrhnTtdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawaseadr3kj(), "", "問合せ先住所３（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(hrhnTtdkKan.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(hrhnTtdkKan.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(hrhnTtdkKan.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exStringEquals(hrhnTtdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exStringEquals(hrhnTtdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(hrhnTtdkKan.getKouzamaskingmsg(), "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "口座マスキングＭＳＧ");
        exStringEquals(hrhnTtdkKan.getHrkkaisuutkiktbrisyu(), "月払", "払込回数・定期一括払種類");
        exClassificationEquals(hrhnTtdkKan.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(hrhnTtdkKan.getHrkp(), BizCurrency.valueOf(552233), "払込保険料");
        exDateYMEquals(hrhnTtdkKan.getKouryokuhasseiym(), null, "効力発生年月");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta1(), "＜変更後のご指定口座＞", "メッセージエリア（３４桁）１");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta2(), "ゆうちょ銀行", "メッセージエリア（３４桁）２");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta3(), "通帳記号　１１０１０", "メッセージエリア（３４桁）３");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta4(), "通帳番号　１２３４５６７８９０＊＊＊", "メッセージエリア（３４桁）４");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta5(), "口座名義人　カナスセソカガグケソズツシミアイウエ", "メッセージエリア（３４桁）５");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta6(), "　　　　　　カナ　様", "メッセージエリア（３４桁）６");
        exStringEquals(hrhnTtdkKan.getMsgarea34keta7(), "", "メッセージエリア（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta1(), "", "振替予告メッセージ（３４桁）１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta2(), "【今後の保険料振替予定】", "振替予告メッセージ（３４桁）２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta3(), "○２０１７年　６月２７日（振替日）より、変更後のご指定口座からの", "振替予告メッセージ（３４桁）３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta4(), "　振り替えが開始します。", "振替予告メッセージ（３４桁）４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta5(), "", "振替予告メッセージ（３４桁）５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta6(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込", "振替予告メッセージ（３４桁）６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta7(), "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」", "振替予告メッセージ（３４桁）７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta8(), "　と表示しております。", "振替予告メッセージ（３４桁）８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta9(), "", "振替予告メッセージ（３４桁）９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta10(), "", "振替予告メッセージ（３４桁）１０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta11(), "", "振替予告メッセージ（３４桁）１１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta12(), "", "振替予告メッセージ（３４桁）１２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta13(), "", "振替予告メッセージ（３４桁）１３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta14(), "", "振替予告メッセージ（３４桁）１４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta15(), "", "振替予告メッセージ（３４桁）１５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta16(), "", "振替予告メッセージ（３４桁）１６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta17(), "", "振替予告メッセージ（３４桁）１７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta18(), "", "振替予告メッセージ（３４桁）１８");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta19(), "", "振替予告メッセージ（３４桁）１９");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta20(), "", "振替予告メッセージ（３４桁）２０");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta21(), "", "振替予告メッセージ（３４桁）２１");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta22(), "", "振替予告メッセージ（３４桁）２２");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta23(), "", "振替予告メッセージ（３４桁）２３");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta24(), "", "振替予告メッセージ（３４桁）２４");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta25(), "", "振替予告メッセージ（３４桁）２５");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta26(), "", "振替予告メッセージ（３４桁）２６");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta27(), "", "振替予告メッセージ（３４桁）２７");
        exStringEquals(hrhnTtdkKan.getHrkykkmsg34keta28(), "", "振替予告メッセージ（３４桁）２８");
        exClassificationEquals(hrhnTtdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinKinou(), "EditHrhnKanryoTuuti", "業務用更新機能ＩＤ");
        exStringEquals(hrhnTtdkKan.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hrhnTtdkKan.getHonsyakaisouriyuu(), "000", "本社回送理由");

    }
}
