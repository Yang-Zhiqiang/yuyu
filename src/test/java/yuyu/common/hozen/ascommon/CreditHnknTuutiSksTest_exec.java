package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditHnknTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;


/**
 * クレカ返金通知作成のメイン処理メソッド {@link CreditHnknTuutiSks#exec((KhozenCommonParam pKhozenCommonParam, CreditHnknTuutiSksParam pCreditHnknTuutiSksPara))}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreditHnknTuutiSksTest_exec extends AbstractTest {


    @Inject
    private CreditHnknTuutiSks creditHnknTuutiSks;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private CreditHnknTuutiSksParam creditHnknTuutiSksParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_クレカ返金通知作成";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CreditHnknTuutiSksTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        khozenCommonParam.setFunctionId("CreditHnknTuutiSks");
        baseUserInfo.getUser().setUserId("user001");
        changeSystemDate(BizDate.valueOf(20200908));
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        creditHnknTuutiSksParam.setKykKihon(kykKihon);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001010");
        creditHnknTuutiSksParam.setAnsyuKihon(ansyuKihon);
        creditHnknTuutiSksParam.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
        creditHnknTuutiSksParam.setShrriyuukbn(C_ShrriyuuKbn.NIZYUNYKN);
        creditHnknTuutiSksParam.setKrkriyuukbn(C_KrkriyuuKbn.SYOUMETUGONYKN);
        creditHnknTuutiSksParam.setDenrenno("12345");
        creditHnknTuutiSksParam.setEdano(1);
        creditHnknTuutiSksParam.setTyouhyouymd(BizDate.valueOf(20170427));
        creditHnknTuutiSksParam.setHenkousikibetukey("000000000000000010");
        creditHnknTuutiSksParam.setUriageseikyuuymd(BizDate.valueOf(20160111));
        creditHnknTuutiSksParam.setHnkngk(BizCurrency.valueOf(10000));
        creditHnknTuutiSksParam.setUriageymd(BizDate.valueOf(20200908));
        creditHnknTuutiSksParam.setUriagegk(BizCurrency.valueOf(1234567));
        creditHnknTuutiSksParam.setJyuutouym(BizDateYM.valueOf(202001));
        creditHnknTuutiSksParam.setJyutoukaisuuy(5);
        creditHnknTuutiSksParam.setJyutoukaisuum(2);
        creditHnknTuutiSksParam.setDenymd(BizDate.valueOf(20200701));
        creditHnknTuutiSksParam.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        creditHnknTuutiSksParam.setCreditkessaiyouno("6212263400004110112");

        creditHnknTuutiSks.exec(khozenCommonParam, creditHnknTuutiSksParam);

        IT_CreditHnknTuuti creditHnknTuuti= creditHnknTuutiSks.getCreditHnknTuuti();
        exStringEquals(creditHnknTuuti.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(creditHnknTuuti.getEdano(), 1, "枝番号");
        exDateEquals(creditHnknTuuti.getTyouhyouymd(), BizDate.valueOf(20170427), "帳票作成日");
        exStringEquals(creditHnknTuuti.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(creditHnknTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(creditHnknTuuti.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(creditHnknTuuti.getShsadr1kj(), "秋田市", "送付先住所１（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr3kj(), "東京", "送付先住所３（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsnmkj(), "ユ被名　一あ", "送付先氏名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj(), "ダイレクトサービス企画室", "問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(creditHnknTuuti.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr3kj(), "000110", "問合せ先住所３（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno(), "06-6937-1365", "問合せ先電話番号");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(creditHnknTuuti.getShrriyuukbn(), C_ShrriyuuKbn.NIZYUNYKN, "支払理由区分");
        exDateEquals(creditHnknTuuti.getUriageseikyuuymd(), BizDate.valueOf(20160111), "売上請求日");
        exBizCalcbleEquals(creditHnknTuuti.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exClassificationEquals(creditHnknTuuti.getKrkriyuukbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exDateEquals(creditHnknTuuti.getUriageymd(), BizDate.valueOf(20200908), "売上日");
        exBizCalcbleEquals(creditHnknTuuti.getUriagegk(), BizCurrency.valueOf(1234567), "売上金額");
        exDateYMEquals(creditHnknTuuti.getJyuutouym(), BizDateYM.valueOf(202001), "充当年月");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuuy(), 5, "充当回数（年）");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuum(), 2, "充当回数（月）");
        exClassificationEquals(creditHnknTuuti.getHnkntaisyouinjiflg(), C_UmuKbn.ARI, "返金対象印字フラグ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinTime().substring(0, 8), "20200908", "業務用更新時間");

        IT_SyuunouHenknRireki syuunouHenknRireki = creditHnknTuutiSks.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 1, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf(20200701), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf(20160111), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exStringEquals(syuunouHenknRireki.getBankcd(), "", "銀行コード");
        exStringEquals(syuunouHenknRireki.getSitencd(), "", "支店コード");
        exClassificationEquals(syuunouHenknRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(syuunouHenknRireki.getKouzano(), "", "口座番号");
        exStringEquals(syuunouHenknRireki.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exStringEquals(syuunouHenknRireki.getCreditcardno1(), "", "クレジットカード番号１");
        exStringEquals(syuunouHenknRireki.getCreditcardno2(), "", "クレジットカード番号２");
        exStringEquals(syuunouHenknRireki.getCreditcardno3(), "", "クレジットカード番号３");
        exStringEquals(syuunouHenknRireki.getCreditcardno4(), "", "クレジットカード番号４");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinTime().substring(0,8), "20200908", "業務用更新時間");
        exClassificationEquals(syuunouHenknRireki.getShrriyuukbn(), C_ShrriyuuKbn.NIZYUNYKN, "支払理由区分");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "6212263400004110112", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        khozenCommonParam.setFunctionId("CreditHnknTuutiSks");
        baseUserInfo.getUser().setUserId("user001");
        changeSystemDate(BizDate.valueOf(20200908));
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        creditHnknTuutiSksParam.setKykKihon(kykKihon);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001021");
        creditHnknTuutiSksParam.setAnsyuKihon(ansyuKihon);
        creditHnknTuutiSksParam.setHassoukbn(C_HassouKbn.TYOKUSOU);
        creditHnknTuutiSksParam.setShrriyuukbn(C_ShrriyuuKbn.BLNK);
        creditHnknTuutiSksParam.setKrkriyuukbn(C_KrkriyuuKbn.SYOUMETUGONYKN);
        creditHnknTuutiSksParam.setDenrenno("12345");
        creditHnknTuutiSksParam.setEdano(1);
        creditHnknTuutiSksParam.setTyouhyouymd(BizDate.valueOf(20170427));
        creditHnknTuutiSksParam.setHenkousikibetukey("000000000000000010");
        creditHnknTuutiSksParam.setUriageseikyuuymd(BizDate.valueOf(20160111));
        creditHnknTuutiSksParam.setHnkngk(BizCurrency.valueOf(10000));
        creditHnknTuutiSksParam.setUriageymd(null);
        creditHnknTuutiSksParam.setUriagegk(BizCurrency.valueOf(1234567));
        creditHnknTuutiSksParam.setJyuutouym(BizDateYM.valueOf(202001));
        creditHnknTuutiSksParam.setJyutoukaisuuy(5);
        creditHnknTuutiSksParam.setJyutoukaisuum(2);
        creditHnknTuutiSksParam.setDenymd(BizDate.valueOf(20200701));
        creditHnknTuutiSksParam.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        creditHnknTuutiSksParam.setCreditkessaiyouno("6212263400004110112");

        creditHnknTuutiSks.exec(khozenCommonParam, creditHnknTuutiSksParam);

        IT_CreditHnknTuuti creditHnknTuuti= creditHnknTuutiSks.getCreditHnknTuuti();
        exStringEquals(creditHnknTuuti.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(creditHnknTuuti.getEdano(), 1, "枝番号");
        exDateEquals(creditHnknTuuti.getTyouhyouymd(), BizDate.valueOf(20170427), "帳票作成日");
        exStringEquals(creditHnknTuuti.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(creditHnknTuuti.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exStringEquals(creditHnknTuuti.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(creditHnknTuuti.getShsadr1kj(), "秋田市", "送付先住所１（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr3kj(), "東京", "送付先住所３（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsnmkj(), "ユ被名　一い", "送付先氏名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj(), "ダイレクトサービス企画室", "問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(creditHnknTuuti.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr3kj(), "000110", "問合せ先住所３（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno(), "06-6937-1365", "問合せ先電話番号");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(creditHnknTuuti.getShrriyuukbn(), C_ShrriyuuKbn.BLNK, "支払理由区分");
        exDateEquals(creditHnknTuuti.getUriageseikyuuymd(), BizDate.valueOf(20160111), "売上請求日");
        exBizCalcbleEquals(creditHnknTuuti.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exClassificationEquals(creditHnknTuuti.getKrkriyuukbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exDateEquals(creditHnknTuuti.getUriageymd(), null, "売上日");
        exBizCalcbleEquals(creditHnknTuuti.getUriagegk(), BizCurrency.valueOf(1234567), "売上金額");
        exDateYMEquals(creditHnknTuuti.getJyuutouym(), BizDateYM.valueOf(202001), "充当年月");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuuy(), 5, "充当回数（年）");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuum(), 2, "充当回数（月）");
        exClassificationEquals(creditHnknTuuti.getHnkntaisyouinjiflg(), C_UmuKbn.NONE, "返金対象印字フラグ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinTime().substring(0, 8), "20200908", "業務用更新時間");

        IT_SyuunouHenknRireki syuunouHenknRireki = creditHnknTuutiSks.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 1, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf(20200701), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf(20160111), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exStringEquals(syuunouHenknRireki.getBankcd(), "", "銀行コード");
        exStringEquals(syuunouHenknRireki.getSitencd(), "", "支店コード");
        exClassificationEquals(syuunouHenknRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(syuunouHenknRireki.getKouzano(), "", "口座番号");
        exStringEquals(syuunouHenknRireki.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exStringEquals(syuunouHenknRireki.getCreditcardno1(), "", "クレジットカード番号１");
        exStringEquals(syuunouHenknRireki.getCreditcardno2(), "", "クレジットカード番号２");
        exStringEquals(syuunouHenknRireki.getCreditcardno3(), "", "クレジットカード番号３");
        exStringEquals(syuunouHenknRireki.getCreditcardno4(), "", "クレジットカード番号４");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinTime().substring(0,8), "20200908", "業務用更新時間");
        exClassificationEquals(syuunouHenknRireki.getShrriyuukbn(), C_ShrriyuuKbn.HARAIKOMIHUYOU, "支払理由区分");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "6212263400004110112", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        khozenCommonParam.setFunctionId("CreditHnknTuutiSks");
        baseUserInfo.getUser().setUserId("user001");
        changeSystemDate(BizDate.valueOf(20200908));
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");
        creditHnknTuutiSksParam.setKykKihon(kykKihon);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001032");
        creditHnknTuutiSksParam.setAnsyuKihon(ansyuKihon);
        creditHnknTuutiSksParam.setHassoukbn(C_HassouKbn.BLNK);
        creditHnknTuutiSksParam.setShrriyuukbn(C_ShrriyuuKbn.BLNK);
        creditHnknTuutiSksParam.setKrkriyuukbn(C_KrkriyuuKbn.KYUUSOKUTYUUNYKN);
        creditHnknTuutiSksParam.setDenrenno("12345");
        creditHnknTuutiSksParam.setEdano(1);
        creditHnknTuutiSksParam.setTyouhyouymd(BizDate.valueOf(20170427));
        creditHnknTuutiSksParam.setHenkousikibetukey("000000000000000010");
        creditHnknTuutiSksParam.setUriageseikyuuymd(BizDate.valueOf(20160111));
        creditHnknTuutiSksParam.setHnkngk(BizCurrency.valueOf(10000));
        creditHnknTuutiSksParam.setUriageymd(null);
        creditHnknTuutiSksParam.setUriagegk(BizCurrency.valueOf(1234567));
        creditHnknTuutiSksParam.setJyuutouym(BizDateYM.valueOf(202001));
        creditHnknTuutiSksParam.setJyutoukaisuuy(5);
        creditHnknTuutiSksParam.setJyutoukaisuum(2);
        creditHnknTuutiSksParam.setDenymd(BizDate.valueOf(20200701));
        creditHnknTuutiSksParam.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        creditHnknTuutiSksParam.setCreditkessaiyouno("6212263400004110112");

        creditHnknTuutiSks.exec(khozenCommonParam, creditHnknTuutiSksParam);

        IT_CreditHnknTuuti creditHnknTuuti= creditHnknTuutiSks.getCreditHnknTuuti();
        exStringEquals(creditHnknTuuti.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(creditHnknTuuti.getEdano(), 1, "枝番号");
        exDateEquals(creditHnknTuuti.getTyouhyouymd(), BizDate.valueOf(20170427), "帳票作成日");
        exStringEquals(creditHnknTuuti.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(creditHnknTuuti.getHassoukbn(), C_HassouKbn.BLNK, "発送区分");
        exStringEquals(creditHnknTuuti.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(creditHnknTuuti.getShsadr1kj(), "秋田市", "送付先住所１（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr3kj(), "東京", "送付先住所３（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsnmkj(), "ユ被名　一う", "送付先氏名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj(), "ダイレクトサービス企画室", "問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(creditHnknTuuti.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr3kj(), "000110", "問合せ先住所３（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno(), "06-6937-1365", "問合せ先電話番号");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(creditHnknTuuti.getShrriyuukbn(), C_ShrriyuuKbn.BLNK, "支払理由区分");
        exDateEquals(creditHnknTuuti.getUriageseikyuuymd(), BizDate.valueOf(20160111), "売上請求日");
        exBizCalcbleEquals(creditHnknTuuti.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exClassificationEquals(creditHnknTuuti.getKrkriyuukbn(), C_KrkriyuuKbn.KYUUSOKUTYUUNYKN, "仮受理由区分");
        exDateEquals(creditHnknTuuti.getUriageymd(), null, "売上日");
        exBizCalcbleEquals(creditHnknTuuti.getUriagegk(), BizCurrency.valueOf(1234567), "売上金額");
        exDateYMEquals(creditHnknTuuti.getJyuutouym(), BizDateYM.valueOf(202001), "充当年月");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuuy(), 5, "充当回数（年）");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuum(), 2, "充当回数（月）");
        exClassificationEquals(creditHnknTuuti.getHnkntaisyouinjiflg(), C_UmuKbn.NONE, "返金対象印字フラグ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinTime().substring(0, 8), "20200908", "業務用更新時間");

        IT_SyuunouHenknRireki syuunouHenknRireki = creditHnknTuutiSks.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 1, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf(20200701), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf(20160111), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exStringEquals(syuunouHenknRireki.getBankcd(), "", "銀行コード");
        exStringEquals(syuunouHenknRireki.getSitencd(), "", "支店コード");
        exClassificationEquals(syuunouHenknRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(syuunouHenknRireki.getKouzano(), "", "口座番号");
        exStringEquals(syuunouHenknRireki.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exStringEquals(syuunouHenknRireki.getCreditcardno1(), "", "クレジットカード番号１");
        exStringEquals(syuunouHenknRireki.getCreditcardno2(), "", "クレジットカード番号２");
        exStringEquals(syuunouHenknRireki.getCreditcardno3(), "", "クレジットカード番号３");
        exStringEquals(syuunouHenknRireki.getCreditcardno4(), "", "クレジットカード番号４");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinTime().substring(0,8), "20200908", "業務用更新時間");
        exClassificationEquals(syuunouHenknRireki.getShrriyuukbn(), C_ShrriyuuKbn.HARAIKOMIHUYOU, "支払理由区分");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "6212263400004110112", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        khozenCommonParam.setFunctionId("CreditHnknTuutiSks");
        baseUserInfo.getUser().setUserId("user001");
        changeSystemDate(BizDate.valueOf(20200908));
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001043");
        creditHnknTuutiSksParam.setKykKihon(kykKihon);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001043");
        creditHnknTuutiSksParam.setAnsyuKihon(ansyuKihon);
        creditHnknTuutiSksParam.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
        creditHnknTuutiSksParam.setShrriyuukbn(C_ShrriyuuKbn.BLNK);
        creditHnknTuutiSksParam.setKrkriyuukbn(C_KrkriyuuKbn.HENKINHITUYOU);
        creditHnknTuutiSksParam.setDenrenno("12345");
        creditHnknTuutiSksParam.setEdano(1);
        creditHnknTuutiSksParam.setTyouhyouymd(BizDate.valueOf(20170427));
        creditHnknTuutiSksParam.setHenkousikibetukey("000000000000000010");
        creditHnknTuutiSksParam.setUriageseikyuuymd(BizDate.valueOf(20160111));
        creditHnknTuutiSksParam.setHnkngk(BizCurrency.valueOf(10000));
        creditHnknTuutiSksParam.setUriageymd(null);
        creditHnknTuutiSksParam.setUriagegk(BizCurrency.valueOf(1234567));
        creditHnknTuutiSksParam.setJyuutouym(BizDateYM.valueOf(202001));
        creditHnknTuutiSksParam.setJyutoukaisuuy(5);
        creditHnknTuutiSksParam.setJyutoukaisuum(2);
        creditHnknTuutiSksParam.setDenymd(BizDate.valueOf(20200701));
        creditHnknTuutiSksParam.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        creditHnknTuutiSksParam.setCreditkessaiyouno("6212263400004110112");

        creditHnknTuutiSks.exec(khozenCommonParam, creditHnknTuutiSksParam);

        IT_CreditHnknTuuti creditHnknTuuti= creditHnknTuutiSks.getCreditHnknTuuti();
        exStringEquals(creditHnknTuuti.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(creditHnknTuuti.getEdano(), 1, "枝番号");
        exDateEquals(creditHnknTuuti.getTyouhyouymd(), BizDate.valueOf(20170427), "帳票作成日");
        exStringEquals(creditHnknTuuti.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(creditHnknTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(creditHnknTuuti.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(creditHnknTuuti.getShsadr1kj(), "秋田市", "送付先住所１（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr3kj(), "東京", "送付先住所３（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsnmkj(), "ユ被名　一え", "送付先氏名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj(), "ダイレクトサービス企画室", "問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(creditHnknTuuti.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr3kj(), "000110", "問合せ先住所３（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno(), "06-6937-1365", "問合せ先電話番号");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(creditHnknTuuti.getShrriyuukbn(), C_ShrriyuuKbn.BLNK, "支払理由区分");
        exDateEquals(creditHnknTuuti.getUriageseikyuuymd(), BizDate.valueOf(20160111), "売上請求日");
        exBizCalcbleEquals(creditHnknTuuti.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exClassificationEquals(creditHnknTuuti.getKrkriyuukbn(), C_KrkriyuuKbn.HENKINHITUYOU, "仮受理由区分");
        exDateEquals(creditHnknTuuti.getUriageymd(), null, "売上日");
        exBizCalcbleEquals(creditHnknTuuti.getUriagegk(), BizCurrency.valueOf(1234567), "売上金額");
        exDateYMEquals(creditHnknTuuti.getJyuutouym(), BizDateYM.valueOf(202001), "充当年月");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuuy(), 5, "充当回数（年）");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuum(), 2, "充当回数（月）");
        exClassificationEquals(creditHnknTuuti.getHnkntaisyouinjiflg(), C_UmuKbn.NONE, "返金対象印字フラグ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinTime().substring(0, 8), "20200908", "業務用更新時間");

        IT_SyuunouHenknRireki syuunouHenknRireki = creditHnknTuutiSks.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 1, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf(20200701), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf(20160111), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exStringEquals(syuunouHenknRireki.getBankcd(), "", "銀行コード");
        exStringEquals(syuunouHenknRireki.getSitencd(), "", "支店コード");
        exClassificationEquals(syuunouHenknRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(syuunouHenknRireki.getKouzano(), "", "口座番号");
        exStringEquals(syuunouHenknRireki.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exStringEquals(syuunouHenknRireki.getCreditcardno1(), "", "クレジットカード番号１");
        exStringEquals(syuunouHenknRireki.getCreditcardno2(), "", "クレジットカード番号２");
        exStringEquals(syuunouHenknRireki.getCreditcardno3(), "", "クレジットカード番号３");
        exStringEquals(syuunouHenknRireki.getCreditcardno4(), "", "クレジットカード番号４");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinTime().substring(0,8), "20200908", "業務用更新時間");
        exClassificationEquals(syuunouHenknRireki.getShrriyuukbn(), C_ShrriyuuKbn.HARAIKOMIHUYOU, "支払理由区分");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "6212263400004110112", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        khozenCommonParam.setFunctionId("CreditHnknTuutiSks");
        baseUserInfo.getUser().setUserId("user001");
        changeSystemDate(BizDate.valueOf(20200908));
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001054");
        creditHnknTuutiSksParam.setKykKihon(kykKihon);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001054");
        creditHnknTuutiSksParam.setAnsyuKihon(ansyuKihon);
        creditHnknTuutiSksParam.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
        creditHnknTuutiSksParam.setShrriyuukbn(C_ShrriyuuKbn.BLNK);
        creditHnknTuutiSksParam.setKrkriyuukbn(C_KrkriyuuKbn.ZYUTOUTUKISOUI);
        creditHnknTuutiSksParam.setDenrenno("12345");
        creditHnknTuutiSksParam.setEdano(1);
        creditHnknTuutiSksParam.setTyouhyouymd(BizDate.valueOf(20170427));
        creditHnknTuutiSksParam.setHenkousikibetukey("000000000000000010");
        creditHnknTuutiSksParam.setUriageseikyuuymd(BizDate.valueOf(20160111));
        creditHnknTuutiSksParam.setHnkngk(BizCurrency.valueOf(10000));
        creditHnknTuutiSksParam.setUriageymd(null);
        creditHnknTuutiSksParam.setUriagegk(BizCurrency.valueOf(1234567));
        creditHnknTuutiSksParam.setJyuutouym(BizDateYM.valueOf(202001));
        creditHnknTuutiSksParam.setJyutoukaisuuy(5);
        creditHnknTuutiSksParam.setJyutoukaisuum(2);
        creditHnknTuutiSksParam.setDenymd(BizDate.valueOf(20200701));
        creditHnknTuutiSksParam.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        creditHnknTuutiSksParam.setCreditkessaiyouno("6212263400004110112");

        creditHnknTuutiSks.exec(khozenCommonParam, creditHnknTuutiSksParam);

        IT_CreditHnknTuuti creditHnknTuuti= creditHnknTuutiSks.getCreditHnknTuuti();
        exStringEquals(creditHnknTuuti.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(creditHnknTuuti.getEdano(), 1, "枝番号");
        exDateEquals(creditHnknTuuti.getTyouhyouymd(), BizDate.valueOf(20170427), "帳票作成日");
        exStringEquals(creditHnknTuuti.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(creditHnknTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(creditHnknTuuti.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(creditHnknTuuti.getShsadr1kj(), "秋田市", "送付先住所１（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr3kj(), "東京", "送付先住所３（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsnmkj(), "ユ被名　一お", "送付先氏名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj(), "ダイレクトサービス企画室", "問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(creditHnknTuuti.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr3kj(), "000110", "問合せ先住所３（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno(), "06-6937-1365", "問合せ先電話番号");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(creditHnknTuuti.getShrriyuukbn(), C_ShrriyuuKbn.BLNK, "支払理由区分");
        exDateEquals(creditHnknTuuti.getUriageseikyuuymd(), BizDate.valueOf(20160111), "売上請求日");
        exBizCalcbleEquals(creditHnknTuuti.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exClassificationEquals(creditHnknTuuti.getKrkriyuukbn(), C_KrkriyuuKbn.ZYUTOUTUKISOUI, "仮受理由区分");
        exDateEquals(creditHnknTuuti.getUriageymd(), null, "売上日");
        exBizCalcbleEquals(creditHnknTuuti.getUriagegk(), BizCurrency.valueOf(1234567), "売上金額");
        exDateYMEquals(creditHnknTuuti.getJyuutouym(), BizDateYM.valueOf(202001), "充当年月");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuuy(), 5, "充当回数（年）");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuum(), 2, "充当回数（月）");
        exClassificationEquals(creditHnknTuuti.getHnkntaisyouinjiflg(), C_UmuKbn.NONE, "返金対象印字フラグ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinTime().substring(0, 8), "20200908", "業務用更新時間");

        IT_SyuunouHenknRireki syuunouHenknRireki = creditHnknTuutiSks.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 1, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf(20200701), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf(20160111), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exStringEquals(syuunouHenknRireki.getBankcd(), "", "銀行コード");
        exStringEquals(syuunouHenknRireki.getSitencd(), "", "支店コード");
        exClassificationEquals(syuunouHenknRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(syuunouHenknRireki.getKouzano(), "", "口座番号");
        exStringEquals(syuunouHenknRireki.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exStringEquals(syuunouHenknRireki.getCreditcardno1(), "", "クレジットカード番号１");
        exStringEquals(syuunouHenknRireki.getCreditcardno2(), "", "クレジットカード番号２");
        exStringEquals(syuunouHenknRireki.getCreditcardno3(), "", "クレジットカード番号３");
        exStringEquals(syuunouHenknRireki.getCreditcardno4(), "", "クレジットカード番号４");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinTime().substring(0,8), "20200908", "業務用更新時間");
        exClassificationEquals(syuunouHenknRireki.getShrriyuukbn(), C_ShrriyuuKbn.NIZYUNYKN, "支払理由区分");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "6212263400004110112", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        khozenCommonParam.setFunctionId("CreditHnknTuutiSks");
        baseUserInfo.getUser().setUserId("user001");
        changeSystemDate(BizDate.valueOf(20200908));
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001065");
        creditHnknTuutiSksParam.setKykKihon(kykKihon);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001065");
        creditHnknTuutiSksParam.setAnsyuKihon(ansyuKihon);
        creditHnknTuutiSksParam.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
        creditHnknTuutiSksParam.setShrriyuukbn(C_ShrriyuuKbn.BLNK);
        creditHnknTuutiSksParam.setKrkriyuukbn(C_KrkriyuuKbn.KAZYOUNYKN);
        creditHnknTuutiSksParam.setDenrenno("12345");
        creditHnknTuutiSksParam.setEdano(1);
        creditHnknTuutiSksParam.setTyouhyouymd(BizDate.valueOf(20170427));
        creditHnknTuutiSksParam.setHenkousikibetukey("000000000000000010");
        creditHnknTuutiSksParam.setUriageseikyuuymd(BizDate.valueOf(20160111));
        creditHnknTuutiSksParam.setHnkngk(BizCurrency.valueOf(10000));
        creditHnknTuutiSksParam.setUriageymd(null);
        creditHnknTuutiSksParam.setUriagegk(BizCurrency.valueOf(1234567));
        creditHnknTuutiSksParam.setJyuutouym(BizDateYM.valueOf(202001));
        creditHnknTuutiSksParam.setJyutoukaisuuy(5);
        creditHnknTuutiSksParam.setJyutoukaisuum(2);
        creditHnknTuutiSksParam.setDenymd(BizDate.valueOf(20200701));
        creditHnknTuutiSksParam.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        creditHnknTuutiSksParam.setCreditkessaiyouno("6212263400004110112");

        creditHnknTuutiSks.exec(khozenCommonParam, creditHnknTuutiSksParam);

        IT_CreditHnknTuuti creditHnknTuuti= creditHnknTuutiSks.getCreditHnknTuuti();
        exStringEquals(creditHnknTuuti.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(creditHnknTuuti.getEdano(), 1, "枝番号");
        exDateEquals(creditHnknTuuti.getTyouhyouymd(), BizDate.valueOf(20170427), "帳票作成日");
        exStringEquals(creditHnknTuuti.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(creditHnknTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(creditHnknTuuti.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(creditHnknTuuti.getShsadr1kj(), "秋田市", "送付先住所１（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr3kj(), "東京", "送付先住所３（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsnmkj(), "ユ被名　一か", "送付先氏名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj(), "ダイレクトサービス企画室", "問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(creditHnknTuuti.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr3kj(), "000110", "問合せ先住所３（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno(), "06-6937-1365", "問合せ先電話番号");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(creditHnknTuuti.getShrriyuukbn(), C_ShrriyuuKbn.BLNK, "支払理由区分");
        exDateEquals(creditHnknTuuti.getUriageseikyuuymd(), BizDate.valueOf(20160111), "売上請求日");
        exBizCalcbleEquals(creditHnknTuuti.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exClassificationEquals(creditHnknTuuti.getKrkriyuukbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exDateEquals(creditHnknTuuti.getUriageymd(), null, "売上日");
        exBizCalcbleEquals(creditHnknTuuti.getUriagegk(), BizCurrency.valueOf(1234567), "売上金額");
        exDateYMEquals(creditHnknTuuti.getJyuutouym(), BizDateYM.valueOf(202001), "充当年月");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuuy(), 5, "充当回数（年）");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuum(), 2, "充当回数（月）");
        exClassificationEquals(creditHnknTuuti.getHnkntaisyouinjiflg(), C_UmuKbn.NONE, "返金対象印字フラグ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinTime().substring(0, 8), "20200908", "業務用更新時間");

        IT_SyuunouHenknRireki syuunouHenknRireki = creditHnknTuutiSks.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 1, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf(20200701), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf(20160111), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exStringEquals(syuunouHenknRireki.getBankcd(), "", "銀行コード");
        exStringEquals(syuunouHenknRireki.getSitencd(), "", "支店コード");
        exClassificationEquals(syuunouHenknRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(syuunouHenknRireki.getKouzano(), "", "口座番号");
        exStringEquals(syuunouHenknRireki.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exStringEquals(syuunouHenknRireki.getCreditcardno1(), "", "クレジットカード番号１");
        exStringEquals(syuunouHenknRireki.getCreditcardno2(), "", "クレジットカード番号２");
        exStringEquals(syuunouHenknRireki.getCreditcardno3(), "", "クレジットカード番号３");
        exStringEquals(syuunouHenknRireki.getCreditcardno4(), "", "クレジットカード番号４");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinTime().substring(0,8), "20200908", "業務用更新時間");
        exClassificationEquals(syuunouHenknRireki.getShrriyuukbn(), C_ShrriyuuKbn.KAZYOUNYKN, "支払理由区分");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "6212263400004110112", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        khozenCommonParam.setFunctionId("CreditHnknTuutiSks");
        baseUserInfo.getUser().setUserId("user001");
        changeSystemDate(BizDate.valueOf(20200908));
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001076");
        creditHnknTuutiSksParam.setKykKihon(kykKihon);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001076");
        creditHnknTuutiSksParam.setAnsyuKihon(ansyuKihon);
        creditHnknTuutiSksParam.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
        creditHnknTuutiSksParam.setShrriyuukbn(C_ShrriyuuKbn.BLNK);
        creditHnknTuutiSksParam.setKrkriyuukbn(C_KrkriyuuKbn.BLNK);
        creditHnknTuutiSksParam.setDenrenno("12345");
        creditHnknTuutiSksParam.setEdano(1);
        creditHnknTuutiSksParam.setTyouhyouymd(BizDate.valueOf(20170427));
        creditHnknTuutiSksParam.setHenkousikibetukey("000000000000000010");
        creditHnknTuutiSksParam.setUriageseikyuuymd(BizDate.valueOf(20160111));
        creditHnknTuutiSksParam.setHnkngk(BizCurrency.valueOf(10000));
        creditHnknTuutiSksParam.setUriageymd(null);
        creditHnknTuutiSksParam.setUriagegk(BizCurrency.valueOf(1234567));
        creditHnknTuutiSksParam.setJyuutouym(BizDateYM.valueOf(202001));
        creditHnknTuutiSksParam.setJyutoukaisuuy(5);
        creditHnknTuutiSksParam.setJyutoukaisuum(2);
        creditHnknTuutiSksParam.setDenymd(BizDate.valueOf(20200701));
        creditHnknTuutiSksParam.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        creditHnknTuutiSksParam.setCreditkessaiyouno("6212263400004110112");

        creditHnknTuutiSks.exec(khozenCommonParam, creditHnknTuutiSksParam);

        IT_CreditHnknTuuti creditHnknTuuti= creditHnknTuutiSks.getCreditHnknTuuti();
        exStringEquals(creditHnknTuuti.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(creditHnknTuuti.getEdano(), 1, "枝番号");
        exDateEquals(creditHnknTuuti.getTyouhyouymd(), BizDate.valueOf(20170427), "帳票作成日");
        exStringEquals(creditHnknTuuti.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(creditHnknTuuti.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(creditHnknTuuti.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(creditHnknTuuti.getShsadr1kj(), "秋田市", "送付先住所１（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsadr3kj(), "東京", "送付先住所３（漢字）（３０桁）");
        exStringEquals(creditHnknTuuti.getShsnmkj(), "ユ被名　一き", "送付先氏名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj(), "ダイレクトサービス企画室", "問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(creditHnknTuuti.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(creditHnknTuuti.getToiawaseadr3kj(), "000110", "問合せ先住所３（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno(), "06-6937-1365", "問合せ先電話番号");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(creditHnknTuuti.getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(creditHnknTuuti.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(creditHnknTuuti.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(creditHnknTuuti.getShrriyuukbn(), C_ShrriyuuKbn.BLNK, "支払理由区分");
        exDateEquals(creditHnknTuuti.getUriageseikyuuymd(), BizDate.valueOf(20160111), "売上請求日");
        exBizCalcbleEquals(creditHnknTuuti.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exClassificationEquals(creditHnknTuuti.getKrkriyuukbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exDateEquals(creditHnknTuuti.getUriageymd(), null, "売上日");
        exBizCalcbleEquals(creditHnknTuuti.getUriagegk(), BizCurrency.valueOf(1234567), "売上金額");
        exDateYMEquals(creditHnknTuuti.getJyuutouym(), BizDateYM.valueOf(202001), "充当年月");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuuy(), 5, "充当回数（年）");
        exNumericEquals(creditHnknTuuti.getJyutoukaisuum(), 2, "充当回数（月）");
        exClassificationEquals(creditHnknTuuti.getHnkntaisyouinjiflg(), C_UmuKbn.NONE, "返金対象印字フラグ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(creditHnknTuuti.getGyoumuKousinTime().substring(0, 8), "20200908", "業務用更新時間");

        IT_SyuunouHenknRireki syuunouHenknRireki = creditHnknTuutiSks.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 1, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf(20200701), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf(20160111), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(10000), "返金額");
        exStringEquals(syuunouHenknRireki.getBankcd(), "", "銀行コード");
        exStringEquals(syuunouHenknRireki.getSitencd(), "", "支店コード");
        exClassificationEquals(syuunouHenknRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(syuunouHenknRireki.getKouzano(), "", "口座番号");
        exStringEquals(syuunouHenknRireki.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exStringEquals(syuunouHenknRireki.getCreditcardno1(), "", "クレジットカード番号１");
        exStringEquals(syuunouHenknRireki.getCreditcardno2(), "", "クレジットカード番号２");
        exStringEquals(syuunouHenknRireki.getCreditcardno3(), "", "クレジットカード番号３");
        exStringEquals(syuunouHenknRireki.getCreditcardno4(), "", "クレジットカード番号４");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinKinou(), "CreditHnknTuutiSks", "業務用更新機能ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(syuunouHenknRireki.getGyoumuKousinTime().substring(0,8), "20200908", "業務用更新時間");
        exClassificationEquals(syuunouHenknRireki.getShrriyuukbn(), C_ShrriyuuKbn.HARAIKOMIHUYOU, "支払理由区分");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "6212263400004110112", "クレジットカード決済用番号");

    }
}
