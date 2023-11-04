package yuyu.common.hozen.ascommon;

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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未入通知編集のメソッド{@link EditMinyuuTuuti#editTBL(KhozenCommonParam, IT_KykKihon, CreditSaikokuTuutiParam, BizDate, C_HassouKbn, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditMinyuuTuutiTest_editTBL4 {

    @Inject
    private EditMinyuuTuuti editMinyuuTuuti;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_未入通知編集";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditMinyuuTuutiTest_editTBL.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    public void testEditTBL_D1() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、クレジットカードのご利用額が限度額を超", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "過しており、作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "認できておりません。", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、次回のカードご利用日（２０１９年　８月　１日）に以下【保険料", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "のご案内】に記載のとおりクレジットカードにて決済させていただきます。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "次回のカードご利用日に保険料をクレジットカードにて決済できず、以下【保険料", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "のご案内】に記載の払込期限日までに保険料のお払込みもないときは、猶予期間満", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "了日の翌日からご契約が消滅します。", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "きませんので、十分にご注意ください。", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "次回決済内容", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの振替日はクレ", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　ジットカード会社によって異なり、ご利用日の翌月や翌々月となることがござい", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　ます。", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "＊払込期限日までに別途保険料のお払込みをご希望のときは、当社までご連絡をお", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "　願いいたします。", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　円換算してお支払いします。", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　「保険料」と表示しております。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_D2() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_D3() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_D4() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "◆ご契約の効力に関する重要なお知らせにつき、つぎのいずれかでお手続き中のお", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　客さまへも本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　　・保険料のお払込方法変更手続き中のお客さま", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　　・当社からクレジットカードの変更手続きをご案内しているお客さま", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　　　（ご登録のクレジットカードが「有効期限切れ」でご利用できず、当社から", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　　　「保険料お払込方法変更のお願い」を送付しているお客さま）", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　　クレジットカードの変更書類をご返送いただいていないときは、左ページに記", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　　載の払込期限日までに当社必着でご返送ください。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "　　手続き書類がお手元にないときは、当社あてご連絡をお願いいたします。行き", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　　違いに手続き書類をご返送いただいているときは、あしからずご了承くださ", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　　い。", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "　「保険料」と表示しております。", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_D5() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、ご登録のクレジットカードがご利用いただ", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "けないため、クレジットカードの変更手続きをご案内しておりましたが、本通知の", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "作成日現在、変更手続きが完了しておりません。そのため、払込期月（２０１９年", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "１０月）の保険料をお払い込みいただけておりません。", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "つきましては、以下【保険料のご案内】に記載の払込期限日までに、クレジット", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "カードの変更手続き書類を当社に到着するようご返送ください。", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "なお、払込期限日までに変更手続き書類をご返送いただけないときは、保険料をお", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "払い込みいただけないため猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "きませんので、十分にご注意ください。", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊クレジットカードの変更手続き書類がお手元にないときは、当社あてご連絡を", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　お願いします。", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　「保険料」と表示しております。", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_D6() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_D7() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KAIYAKUKIBOU);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊クレジットカードの変更手続き書類がお手元にないときは、当社あてご連絡を", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　お願いします。", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　「保険料」と表示しております。", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_D8() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（保険料払込方法変更をされたときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　ないときは、当社あてご連絡をお願いいたします。行き違いに手続き書類をご返", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　送いただいているときは、あしからずご了承ください。", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "◆保険料のお払込方法変更手続き中のお客さまへ", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　ご契約の効力に関する重要なお知らせにつき、保険料の払込方法変更手続きによ", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　り保険料のお払込みを停止したご契約につきましても、本通知を送付しておりま", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　す。あしからずご了承ください。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　「保険料」と表示しております。", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_D9() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KAIYAKUKIBOU);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（解約の手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　ないときは、当社あてご連絡をお願いいたします。行き違いに手続き書類をご返", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　送いただいているときは、あしからずご了承ください。", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "◆解約の手続き中のお客さまへ", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　ご契約の効力に関する重要なお知らせにつき、解約の手続きを承っているご契約", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　につきましても、本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　「保険料」と表示しております。", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_D10() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KEIYAKUHENKOUARI);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（契約内容の変更を手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　ないときは、当社あてご連絡をお願いいたします。行き違いに手続き書類をご返", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　送いただいているときは、あしからずご了承ください。", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "◆契約内容の変更を手続き中のお客さまへ", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　ご契約の効力に関する重要なお知らせにつき、契約内容の変更の手続きを承って", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　いるご契約につきましても、本通知を送付しております。あしからずご了承くだ", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　さい。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　「保険料」と表示しております。", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_D11() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　ないときは、当社あてご連絡をお願いいたします。", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊ご契約の効力に関する重要なお知らせにつき、解約等の手続きを承っているご契", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　約につきましても、本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　「保険料」と表示しております。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_D12() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_D13() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（保険料払込方法変更をされたときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "◆保険料のお払込方法変更手続き中のお客さまへ", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご契約の効力に関する重要なお知らせにつき、保険料の払込方法変更手続きによ", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　り保険料のお払込みを停止したご契約につきましても、本通知を送付しておりま", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　す。あしからずご了承ください。", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　「保険料」と表示しております。", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_D14() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KAIYAKUKIBOU);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（解約の手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "◆解約の手続き中のお客さまへ", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご契約の効力に関する重要なお知らせにつき、解約の手続きを承っているご契約", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　につきましても、本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　「保険料」と表示しております。", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_D15() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KEIYAKUHENKOUARI);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（契約内容の変更を手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "◆契約内容の変更を手続き中のお客さまへ", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご契約の効力に関する重要なお知らせにつき、契約内容の変更の手続きを承って", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　いるご契約につきましても、本通知を送付しております。あしからずご了承くだ", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　さい。", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　「保険料」と表示しております。", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_D16() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊ご契約の効力に関する重要なお知らせにつき、解約等の手続きを承っているご契", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　約につきましても、本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　「保険料」と表示しております。", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_D17() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }
}