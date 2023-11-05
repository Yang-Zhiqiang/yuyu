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
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未入通知編集のメソッド{@link EditMinyuuTuuti#editTBL(KhozenCommonParam, IT_KykKihon, SaikokuTuutiParam, BizDate, C_HassouKbn, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditMinyuuTuutiTest_editTBL2 {

    @Inject
    private EditMinyuuTuuti editMinyuuTuuti;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

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

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

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
    public void testEditTBL_B1() {

        kinou.setKinouId("EditMinyuuTuuti");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("testUser");
        changeCurrentUser(baseUserInfo, aMUser);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190801));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000057", "証券番号");
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_KOUHURIMINYUUTUUTI, "書類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234568", "送付先郵便番号");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名１１", "送付先氏名（漢字）");
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
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、払込期月（２０１９年１０月）の保険料の", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "口座振替ができず、作成日現在、別途のお払込みが確認できておりません。", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "つきましては、　８月は以下【保険料のご案内】に記載のとおり口座から振り替え", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "させていただきますので、２０１９年　７月３１日までに必要な金額を振替口座に", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "ご準備くださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "以下【保険料のご案内】に記載の払込期限日までに口座から振り替えできず", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "別途保険料のお払込みもない場合は、猶予期間満了日の翌日からご契約が消滅しま", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "す。ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすること", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "ができませんので、十分にご注意ください。", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名１１", "被保険者名（漢字）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "次回振替内容", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　８月の口座振替金額　　　　　　　　　　【振替日　２０１９年　８月　１日】", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "　　　　　　　　５，０００円（２０１９年１０月から　３か月分の保険料）", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "　＊振替日（２０１９年　８月　１日）に振替口座から振り替えできない場合は、", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "　　払込期限日（２０１９年　７月　１日）までに当社までご連絡のうえ、", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "　　必要な金額をお払い込みください。", "振込依頼メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　ことをいいます。", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　お送りしています。（左記【保険料のご案内】に記載の払込期限日までにお払", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　い込みいただければ、ご契約は有効に継続します。）", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　ご了承くださいますようお願いします。", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "　す。", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　直後に到来するその金融機関の営業日を換算基準日とします。", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "＊当社職員から電話等でご連絡させていただくことがあります。", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "　「保険料」と表示しております。", "未入通知追加メッセージ２１");
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuuti", "業務用更新機能ＩＤ");
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "testUser", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_B2() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.ARI);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190801));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "おり、作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認でき", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ておりません。", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがない", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ときは、猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "できませんので、十分にご注意ください。", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");

        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　３か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　ことをいいます。", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "　お送りしています。（左記【保険料のご案内】に記載の払込期限日までにお払", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　い込みいただければ、ご契約は有効に継続します。）", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　ご了承くださいますようお願いします。", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "＊別途『口座振替中止のお知らせ』をお送りしている場合がありますので、", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　あわせてご確認ください。", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "＊当社職員から電話等でご連絡させていただくことがあります。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "　す。", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "　直後に到来するその金融機関の営業日を換算基準日とします。", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "　「保険料」と表示しております。", "未入通知追加メッセージ２１");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_B3() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190801));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "おり、作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認でき", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ておりません。（保険料払込方法変更をされたときは、右ページの◆をご覧くださ", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "い。）", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがない", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ときは、猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "できませんので、十分にご注意ください。", "未入通知メッセージ１２");

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　ことをいいます。", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご了承くださいますようお願いします。", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　す。", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　直後に到来するその金融機関の営業日を換算基準日とします。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "◆保険料払込方法変更をされたお客さまへ", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　ご契約の効力に関する重要なお知らせにつき、保険料払込方法変更の手続き", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "　により保険料の引去りを停止したご契約につきましても、本通知を送付しており", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "　ます。あしからずご了承ください。", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "　「保険料」と表示しております。", "未入通知追加メッセージ２１");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_B4() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KAIYAKUKIBOU);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190801));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "おり、作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認でき", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ておりません。（解約の手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがない", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ときは、猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "できませんので、十分にご注意ください。", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　ことをいいます。", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご了承くださいますようお願いします。", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　す。", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　直後に到来するその金融機関の営業日を換算基準日とします。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "◆解約の手続き中のお客さまへ", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　解約の手続きを承っているご契約につきましても、払込期限日までに保険料の", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "　お払込みがないときはご契約が消滅することをお知らせするために本通知を送付", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "　しております。あしからずご了承ください。", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "　「保険料」と表示しております。", "未入通知追加メッセージ２１");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_B5() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KEIYAKUHENKOUARI);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190801));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "おり、作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認でき", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ておりません。（契約内容の変更を手続き中のときは、右ページの◆をご覧くださ", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "い。）", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがない", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ときは、猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "できませんので、十分にご注意ください。", "未入通知メッセージ１２");

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　ことをいいます。", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご了承くださいますようお願いします。", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　す。", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　直後に到来するその金融機関の営業日を換算基準日とします。", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "◆契約内容の変更を手続き中のお客さまへ", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　ご契約の効力に関する重要なお知らせにつき、契約内容の変更の手続きを承って", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "　いるご契約につきましても、本通知を送付しております。あしからず、ご了承", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "　ください。", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "　「保険料」と表示しております。", "未入通知追加メッセージ２１");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_B6() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190801));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて", "未入通知メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "おり、作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認でき", "未入通知メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ておりません。", "未入通知メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがない", "未入通知メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ときは、猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが", "未入通知メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "できませんので、十分にご注意ください。", "未入通知メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "未入通知追加メッセージ２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　ことをいいます。", "未入通知追加メッセージ３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに", "未入通知追加メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　お送りしています。（左記【保険料のご案内】に記載の払込期限日までにお払", "未入通知追加メッセージ６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　い込みいただければ、ご契約は有効に継続します。）", "未入通知追加メッセージ７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず", "未入通知追加メッセージ８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　ご了承くださいますようお願いします。", "未入通知追加メッセージ９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "＊当社職員から電話等でご連絡させていただくことがあります。", "未入通知追加メッセージ１１");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算", "未入通知追加メッセージ１３");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま", "未入通知追加メッセージ１４");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　す。", "未入通知追加メッセージ１５");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の", "未入通知追加メッセージ１６");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "　直後に到来するその金融機関の営業日を換算基準日とします。", "未入通知追加メッセージ１７");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "＊保険料円貨払込特約（円貨払込額指定型または円貨払込額変動型）の付加された", "未入通知追加メッセージ１９");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "　契約は、円貨払込額（定期一括払いの場合は、定期一括払円貨払込額）について", "未入通知追加メッセージ２０");
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "　「保険料」と表示しております。", "未入通知追加メッセージ２１");
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_B7() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "させていただきますので、２０１９年　７月２６日までに必要な金額を振替口座に", "未入通知メッセージ５");
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "年２回払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "次回振替内容", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　７月の口座振替金額　　　　　　　　　　【振替日　２０１９年　７月２９日】", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "　　　　　　　　５，０００円（２０１９年１０月から　３か月分の保険料）", "次回振替内容３");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_B8() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "次回振替内容", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　７月の口座振替金額　　　　　　　　　　【振替日　２０１９年　７月２９日】", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "　　　　　　　　５，０００円（２０１９年１０月から　３か月分の保険料）", "次回振替内容３");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_B9() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_B10() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "６か月定期一括払", "払込方法（１２桁）");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_B11() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "１２か月定期一括払", "払込方法（１２桁）");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_B12() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000116");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "振替口座（ご指定の金融機関・口座）", "振替口座（３７桁）１");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "ゆうちょ銀行", "振替口座（３７桁）２");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "通帳記号　１００８０", "振替口座（３７桁）３");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "通帳番号　１２３４１２３４１２＊＊＊", "振替口座（３７桁）４");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "口座名義人　カナ様", "振替口座（３７桁）５");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊お客さま情報保護のため、通帳番号の一部を＊にて表示しています。", "振替口座（３７桁）６");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_B13() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000127");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "振替口座（ご指定の金融機関・口座）", "振替口座（３７桁）１");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "みずほ銀行", "振替口座（３７桁）２");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "八重洲口支店", "振替口座（３７桁）３");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "普通預金　　口座番号　１２３４１２３４１＊＊＊", "振替口座（３７桁）４");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "口座名義人　カナ様", "振替口座（３７桁）５");
        exStringEquals(itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊お客さま情報保護のため、口座番号の一部を＊にて表示しています。", "振替口座（３７桁）６");
    }
    @Test
    @TestOrder(140)
    public void testEditTBL_B14() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "年１回払", "払込方法（１２桁）");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "次回振替内容", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　７月の口座振替金額　　　　　　　　　　【振替日　２０１９年　７月２９日】", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "　　　　　　　　５，０００円（２０１９年１０月から　４年分の保険料）", "次回振替内容３");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_B15() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　３か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_B16() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　３か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_B17() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　４年分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_B18() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000208");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "次回振替内容　＊前月末営業日における当社所定の為替レートで換算", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　７月の口座振替金額　　　　　　　　　　【振替日　２０１９年　７月２９日】", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "　　　　　　　　５，０００円（２０１９年１０月から　３か月分の保険料）", "次回振替内容３");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_B19() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000208");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　３か月分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "＊為替レートによって保険料は変動します", "次回振替内容３");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_B20() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000219");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "次回振替内容　＊前月末営業日における当社所定の為替レートで換算", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　７月の口座振替金額　　　　　　　　　　【振替日　２０１９年　７月２９日】", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "　　　　　　　　５，０００円（２０１９年１０月から　４年分の保険料）", "次回振替内容３");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_B21() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000219");

        SaikokuTuutiParam saikokuTuutiParam = new SaikokuTuutiParam();
        saikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        saikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(C_UmuKbn.NONE);
        saikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        saikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        saikokuTuutiParam.setJkiHurikaeYmd(BizDate.valueOf(20190729));
        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(4);
        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(3);
        saikokuTuutiParam.setJkiAnnaiKg(BizCurrency.valueOf(5000));

        BizDate syouriDate = BizDate.valueOf(20190521);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        String tuutisyuruicd = "0001";

        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            saikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　４年分の保険料）", "次回振替内容２");
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "＊為替レートによって保険料は変動します", "次回振替内容３");
    }

}