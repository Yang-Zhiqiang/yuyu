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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
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
 * <u>実行履歴</u>
 * <ul>
 *   <li>2019/11/08 Rev.108567 王　金鵬（新規作成）</li>
 *   <li>2019/11/29 Rev.109760 王　金鵬（指摘対応）</li>
 *   <li>2020/01/19 Rev.112217 王　大中（2020年3月24日対応）</li>
 *   <li>2020/03/06 Rev.113136 田　洗銘（2020年Junit改善対応）</li>
 * </ul>
 * @author  王　金鵬
 * @version 2019/11/08 王　金鵬     新規作成<br />
 *          2020/01/19 王　大中 2020年3月24日対応<br />
 *          2020/03/06 田　洗銘 2020年Junit改善対応<br />
 */
@RunWith(OrderedRunner.class)
public class EditMinyuuTuutiTest_editTBL4 {

    /** 契約保全 契約保全共通 未入通知編集  */
    @Inject
    private EditMinyuuTuuti editMinyuuTuuti;

    /** 契約保全 DOM マネージャ */
    @Inject
    private HozenDomManager hozenDomManager;

    /** 契約保全 契約保全共通 契約保全共通パラメータ */
    @Inject
    private KhozenCommonParam khozenCommonParam;

    /** ユーザーの情報 */
    @Inject
    private BaseUserInfo baseUserInfo;

    /** ファイル名 */
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_未入通知編集";
    /** シート名 */
    private final static String sheetName = "INデータ";

    /**
     * テストデータ登録メソッド<br />
     * 各テストで使用するテストデータをテスト実行前に登録するメソッドです。<br />
     * テストデータ１件に対し、フェッチタイプが「EAGER」の関連エンティティの登録が必要です。<br />
     * 例：ユーザーマスタエンティティを１件追加する場合に必要な関連エンティティ<br />
     * 　　・ユーザーロール(Ｎ件)<br />
     * 　　・ユーザー設定(１件)<br />
     * 　　・個別情報(１件)<br />
     * 当メソッドで登録したテストデータは、テストデータ削除メソッド({@link #deleteTestData()})で削除して下さい。<br />
     */
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            // 読取Excelデータ
            testDataAndTblMap = testDataMaker.getInData(EditMinyuuTuutiTest_editTBL.class, fileName, sheetName);

            // テストデータ 登録ＤＢ
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    /**
     * テストデータ削除メソッド</br>
     * 全てのテストメソッド終了後に、テストテータ登録メソッド({@link #insertTestData()})で登録したデータを</br>
     * 当メソッドで削除します。</br>
     */
    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        // DOMマネージャのインジェクション
        // ※テストランナーの制約のため、メソッド内でのインジェクションが必要
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    /**
     * 検証ポイント４：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１　　　：テストケースNo.(1)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(10)
    public void testEditTBL_D1() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、クレジットカードのご利用額が限度額を超", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "過しており、作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "認できておりません。", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、次回のカードご利用日（２０１９年　８月　１日）に以下【保険料", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "のご案内】に記載のとおりクレジットカードにて決済させていただきます。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "次回のカードご利用日に保険料をクレジットカードにて決済できず、以下【保険料", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "のご案内】に記載の払込期限日までに保険料のお払込みもないときは、猶予期間満", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "了日の翌日からご契約が消滅します。", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "きませんので、十分にご注意ください。", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "次回決済内容", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの振替日はクレ", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　ジットカード会社によって異なり、ご利用日の翌月や翌々月となることがござい", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　ます。", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "＊払込期限日までに別途保険料のお払込みをご希望のときは、当社までご連絡をお", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "　願いいたします。", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　円換算してお支払いします。", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　ております。", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント４：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース２　　　：テストケースNo.(2)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(20)
    public void testEditTBL_D2() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント４：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース３　　　：テストケースNo.(3)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(30)
    public void testEditTBL_D3() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.NONE);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント４：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース４　　　：テストケースNo.(4)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(40)
    public void testEditTBL_D4() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "◆ご契約の効力に関する重要なお知らせにつき、つぎのいずれかでお手続き中のお", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　客さまへも本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　　・保険料のお払込方法変更手続き中のお客さま", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　　・当社からクレジットカードの変更手続きをご案内しているお客さま", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　　　（ご登録のクレジットカードが「有効期限切れ」でご利用できず、当社から", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　　　「保険料お払込方法変更のお願い」を送付しているお客さま）", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　　クレジットカードの変更書類をご返送いただいていないときは、左ページに記", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　　載の払込期限日までに当社必着でご返送ください。", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "　　手続き書類がお手元にないときは、当社あてご連絡をお願いいたします。行き", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　　違いに手続き書類をご返送いただいているときは、あしからずご了承くださ", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　　い。", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "　ております。", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント５：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース５　　　：テストケースNo.(5)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(50)
    public void testEditTBL_D5() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、ご登録のクレジットカードがご利用いただ", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "けないため、クレジットカードの変更手続きをご案内しておりましたが、本通知の", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "作成日現在、変更手続きが完了しておりません。そのため、払込期月（２０１９年", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "１０月）の保険料をお払い込みいただけておりません。", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "つきましては、以下【保険料のご案内】に記載の払込期限日までに、クレジット", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "カードの変更手続き書類を当社に到着するようご返送ください。", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "なお、払込期限日までに変更手続き書類をご返送いただけないときは、保険料をお", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "払い込みいただけないため猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "きませんので、十分にご注意ください。", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊クレジットカードの変更手続き書類がお手元にないときは、当社あてご連絡を", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　お願いします。", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　ております。", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント６：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース６　　　：テストケースNo.(6)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(60)
    public void testEditTBL_D6() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント７：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース７　　　：テストケースNo.(7)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(70)
    public void testEditTBL_D7() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KAIYAKUKIBOU);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.CREDIT);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊クレジットカードの変更手続き書類がお手元にないときは、当社あてご連絡を", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　お願いします。", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　ております。", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント８：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース８　　　：テストケースNo.(8)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(80)
    public void testEditTBL_D8() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（保険料払込方法変更をされたときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　ないときは、当社あてご連絡をお願いいたします。行き違いに手続き書類をご返", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　送いただいているときは、あしからずご了承ください。", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "◆保険料のお払込方法変更手続き中のお客さまへ", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　ご契約の効力に関する重要なお知らせにつき、保険料の払込方法変更手続きによ", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　り保険料のお払込みを停止したご契約につきましても、本通知を送付しておりま", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　す。あしからずご了承ください。", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　ております。", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント９：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース９　　　：テストケースNo.(9)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(90)
    public void testEditTBL_D9() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KAIYAKUKIBOU);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（解約の手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　ないときは、当社あてご連絡をお願いいたします。行き違いに手続き書類をご返", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　送いただいているときは、あしからずご了承ください。", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "◆解約の手続き中のお客さまへ", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　ご契約の効力に関する重要なお知らせにつき、解約の手続きを承っているご契約", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　につきましても、本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　ております。", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント１０：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１０　　　：テストケースNo.(10)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(100)
    public void testEditTBL_D10() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KEIYAKUHENKOUARI);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（契約内容の変更を手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　ないときは、当社あてご連絡をお願いいたします。行き違いに手続き書類をご返", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　送いただいているときは、あしからずご了承ください。", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "◆契約内容の変更を手続き中のお客さまへ", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　ご契約の効力に関する重要なお知らせにつき、契約内容の変更の手続きを承って", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　いるご契約につきましても、本通知を送付しております。あしからずご了承くだ", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　さい。", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "　ております。", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント１１：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１１　　　：テストケースNo.(11)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(110)
    public void testEditTBL_D11() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　ないときは、当社あてご連絡をお願いいたします。", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊ご契約の効力に関する重要なお知らせにつき、解約等の手続きを承っているご契", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　約につきましても、本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "　ております。", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント１２：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１２　　　：テストケースNo.(12)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(120)
    public void testEditTBL_D12() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_NG);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント１３：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１３　　　：テストケースNo.(13)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(130)
    public void testEditTBL_D13() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.HRHENKIBOU);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（保険料払込方法変更をされたときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "◆保険料のお払込方法変更手続き中のお客さまへ", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご契約の効力に関する重要なお知らせにつき、保険料の払込方法変更手続きによ", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　り保険料のお払込みを停止したご契約につきましても、本通知を送付しておりま", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　す。あしからずご了承ください。", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　ております。", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント１４：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１４　　　：テストケースNo.(14)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(140)
    public void testEditTBL_D14() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KAIYAKUKIBOU);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（解約の手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "◆解約の手続き中のお客さまへ", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご契約の効力に関する重要なお知らせにつき、解約の手続きを承っているご契約", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　につきましても、本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　ております。", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント１５：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１５　　　：テストケースNo.(15)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(150)
    public void testEditTBL_D15() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.KEIYAKUHENKOUARI);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。（契約内容の変更を手続き中のときは、右ページの◆をご覧ください。）", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "◆契約内容の変更を手続き中のお客さまへ", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　ご契約の効力に関する重要なお知らせにつき、契約内容の変更の手続きを承って", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "　いるご契約につきましても、本通知を送付しております。あしからずご了承くだ", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　さい。", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "　ております。", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント１６：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１６　　　：テストケースNo.(16)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(160)
    public void testEditTBL_D16() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.OTHER);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "いつもお引立てをいただきありがとうございます。", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "本通知に記載のご契約につきましては、保険料の請求を中止させていただいており", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "作成日現在、払込期月（２０１９年１０月）の保険料のお払込みを確認できており", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "ません。", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "日までに必要な金額をお払い込みくださいますようお願いします。", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "猶予期間満了日の翌日からご契約が消滅します。", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "きませんので、十分にご注意ください。", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "　ことをいいます。", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "　承くださいますようお願いします。", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "＊当社職員から電話等でご連絡させていただくことがあります。", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "　円換算してお支払いします。", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "　　その金融機関の営業日とします。", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "＊ご契約の効力に関する重要なお知らせにつき、解約等の手続きを承っているご契", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "　約につきましても、本通知を送付しております。あしからずご了承ください。", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "　ております。", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    /**
     * 検証ポイント１７：クレカ未入通知TBL編集（催告通知）の網羅テスト<br />
     * ケース１７　　　：テストケースNo.(17)<br />
     * 期待結果　　　：口座振替未入通知テーブルエンティティを返却する。<br />
     *
     * @since 2019/11/08
     */
    @Test
    @TestOrder(170)
    public void testEditTBL_D17() {

        // ユーザID
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        // 契約基本テーブルエンティティ
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        // 催告通知パラメータ
        CreditSaikokuTuutiParam creditSaikokuTuutiParam = new CreditSaikokuTuutiParam();
        // 脱退受付有無
        creditSaikokuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
        // 脱退理由区分
        creditSaikokuTuutiParam.setDattaiRiyuuKbn(C_DattairiyuuKbn.BLNK);
        // 脱退経路
        creditSaikokuTuutiParam.setDattaikeiro(C_Dattaikeiro.ONLINE);
        // 有効確認結果
        creditSaikokuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        // 売上請求NG事由
        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA);
        // 次回Ｐ充当年月
        creditSaikokuTuutiParam.setJkiPJytYm(BizDateYM.valueOf(201910));
        // 猶予期間満了日
        creditSaikokuTuutiParam.setYykknMnryYmd(BizDate.valueOf(20190701));
        // 次回売上請求日
        creditSaikokuTuutiParam.setJikaiUrskbi(BizDate.valueOf(20190801));
        // 案内月数
        creditSaikokuTuutiParam.setAnnaiGetusuu(2);
        // 案内金額
        creditSaikokuTuutiParam.setAnnaiKingaku(BizCurrency.valueOf(5000));
        // 処理日
        BizDate syouriDate = BizDate.valueOf(20190521);
        // 発送区分
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        // 通知種類コード
        String tuutisyuruicd = "0001";

        //口座振替未入通知TBL編集（催告通知）
        IT_KouzahuriMinyuTuuti itKouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam, kykKihon,
            creditSaikokuTuutiParam, syouriDate, hassouKbn, tuutisyuruicd);

        // 証券番号
        exStringEquals(itKouzahuriMinyuTuuti.getSyono(), "17806000013", "証券番号");
        // 帳票作成日
        exDateEquals(itKouzahuriMinyuTuuti.getTyouhyouymd(), BizDate.valueOf(20190521), "帳票作成日");
        // 書類コード
        exClassificationEquals(itKouzahuriMinyuTuuti.getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI, "書類コード");
        // 発送区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        // 送付先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getShskyno(), "1234567", "送付先郵便番号");
        // 送付先住所１（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）（３０桁）");
        // 送付先住所２（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）（３０桁）");
        // 送付先住所３（漢字）（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）（３０桁）");
        // 送付先氏名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        // 問合せ先組織名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        // 問合せ先郵便番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        // 問合せ先住所１（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        // 問合せ先住所２（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        // 問合せ先住所３（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        // 問合せ先電話番号
        exStringEquals(itKouzahuriMinyuTuuti.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        // 問合せ先電話受付可能時間１
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        // 問合せ先電話受付可能時間２
        exStringEquals(itKouzahuriMinyuTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        // 通知名称（３０桁）
        exStringEquals(itKouzahuriMinyuTuuti.getTuutinm30keta(), "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－", "通知名称（３０桁）");
        // 未入通知メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg1(), "", "未入通知メッセージ１");
        // 未入通知メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg2(), "", "未入通知メッセージ２");
        // 未入通知メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg3(), "", "未入通知メッセージ３");
        // 未入通知メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg4(), "", "未入通知メッセージ４");
        // 未入通知メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg5(), "", "未入通知メッセージ５");
        // 未入通知メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg6(), "", "未入通知メッセージ６");
        // 未入通知メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg7(), "", "未入通知メッセージ７");
        // 未入通知メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg8(), "", "未入通知メッセージ８");
        // 未入通知メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg9(), "", "未入通知メッセージ９");
        // 未入通知メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg10(), "", "未入通知メッセージ１０");
        // 未入通知メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg11(), "", "未入通知メッセージ１１");
        // 未入通知メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttmsg12(), "", "未入通知メッセージ１２");
        // 保険料案内名称
        exStringEquals(itKouzahuriMinyuTuuti.getPannainm(), "【保険料のご案内】", "保険料案内名称");
        // 払込方法（１２桁）
        exStringEquals(itKouzahuriMinyuTuuti.getHrkhou12keta(), "月払", "払込方法（１２桁）");
        // 被保険者名（漢字）
        exStringEquals(itKouzahuriMinyuTuuti.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        // 次回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou1(), "お払込みのない保険料", "次回振替内容１");
        // 次回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou2(), "　　　　　　　　５，０００円（２０１９年１０月から　２か月分の保険料）", "次回振替内容２");
        // 次回振替内容３
        exStringEquals(itKouzahuriMinyuTuuti.getNexthurikaenaiyou3(), "", "次回振替内容３");
        // 催告月猶予期間１
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn1(), "１０月分の保険料の払込期限日", "催告月猶予期間１");
        // 催告月猶予期間２
        exStringEquals(itKouzahuriMinyuTuuti.getSaikokutukiyykkn2(), "　　２０１９年　７月　１日", "催告月猶予期間２");
        // 振込依頼メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg1(), "", "振込依頼メッセージ１");
        // 振込依頼メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg2(), "", "振込依頼メッセージ２");
        // 振込依頼メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getHrkmirmsg3(), "", "振込依頼メッセージ３");
        // 前回振替内容１
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou1(), "", "前回振替内容１");
        // 前回振替内容２
        exStringEquals(itKouzahuriMinyuTuuti.getZenhurikaenaiyou2(), "", "前回振替内容２");
        // 前回振替内容３
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou3(), "", "前回振替内容３");
        // 前回振替内容４
        exStringEquals( itKouzahuriMinyuTuuti.getZenhurikaenaiyou4(), "", "前回振替内容４");
        // 振替口座（３７桁）１
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta1(), "", "振替口座（３７桁）１");
        // 振替口座（３７桁）２
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta2(), "", "振替口座（３７桁）２");
        // 振替口座（３７桁）３
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta3(), "", "振替口座（３７桁）３");
        // 振替口座（３７桁）４
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta4(), "", "振替口座（３７桁）４");
        // 振替口座（３７桁）５
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta5(), "", "振替口座（３７桁）５");
        // 振替口座（３７桁）６
        exStringEquals( itKouzahuriMinyuTuuti.getHurikaekz37keta6(), "", "振替口座（３７桁）６");
        // 未入通知追加メッセージ１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg1(), "", "未入通知追加メッセージ１");
        // 未入通知追加メッセージ２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg2(), "", "未入通知追加メッセージ２");
        // 未入通知追加メッセージ３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg3(), "", "未入通知追加メッセージ３");
        // 未入通知追加メッセージ４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg4(), "", "未入通知追加メッセージ４");
        // 未入通知追加メッセージ５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg5(), "", "未入通知追加メッセージ５");
        // 未入通知追加メッセージ６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg6(), "", "未入通知追加メッセージ６");
        // 未入通知追加メッセージ７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg7(), "", "未入通知追加メッセージ７");
        // 未入通知追加メッセージ８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg8(), "", "未入通知追加メッセージ８");
        // 未入通知追加メッセージ９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg9(), "", "未入通知追加メッセージ９");
        // 未入通知追加メッセージ１０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg10(), "", "未入通知追加メッセージ１０");
        // 未入通知追加メッセージ１１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg11(), "", "未入通知追加メッセージ１１");
        // 未入通知追加メッセージ１２
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg12(), "", "未入通知追加メッセージ１２");
        // 未入通知追加メッセージ１３
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg13(), "", "未入通知追加メッセージ１３");
        // 未入通知追加メッセージ１４
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg14(), "", "未入通知追加メッセージ１４");
        // 未入通知追加メッセージ１５
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg15(), "", "未入通知追加メッセージ１５");
        // 未入通知追加メッセージ１６
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg16(), "", "未入通知追加メッセージ１６");
        // 未入通知追加メッセージ１７
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg17(), "", "未入通知追加メッセージ１７");
        // 未入通知追加メッセージ１８
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg18(), "", "未入通知追加メッセージ１８");
        // 未入通知追加メッセージ１９
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg19(), "", "未入通知追加メッセージ１９");
        // 未入通知追加メッセージ２０
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg20(), "", "未入通知追加メッセージ２０");
        // 未入通知追加メッセージ２１
        exStringEquals(itKouzahuriMinyuTuuti.getMinyuttaddmsg21(), "", "未入通知追加メッセージ２１");
        // 通知種類コード
        exStringEquals(itKouzahuriMinyuTuuti.getTuutisyuruicd(), "0001", "通知種類コード");
        // 催告通知作成済フラグ
        exClassificationEquals(itKouzahuriMinyuTuuti.getSaikokutuutizumiflg(), C_Skszumiflg.SAKUSEIZUMI, "催告通知作成済フラグ");
        // 帳票記号区分
        exClassificationEquals(itKouzahuriMinyuTuuti.getTyouhyoukigoukbn(), C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI, "帳票記号区分");
        // 払込経路
        exClassificationEquals(itKouzahuriMinyuTuuti.getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        // 次回Ｐ充当年月
        exDateYMEquals(itKouzahuriMinyuTuuti.getJkipjytym(), BizDateYM.valueOf(201910), "次回Ｐ充当年月");
        // 業務用更新機能ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinKinou(), "EditMinyuuTuutiTest_editTBL4", "業務用更新機能ＩＤ");
        // 業務用更新者ＩＤ
        exStringEquals(itKouzahuriMinyuTuuti.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }
}