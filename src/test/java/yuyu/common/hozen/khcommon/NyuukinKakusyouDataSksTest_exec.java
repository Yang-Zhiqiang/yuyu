package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyuuryokuKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * NyuukinKakusyouDataSksクラスのメソッド {@link NyuukinKakusyouDataSks#exec()}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class NyuukinKakusyouDataSksTest_exec {

    private final static String syono1 = "11807111129";

    private final static String syono2 = "11807111130";

    private final static String syono3 = "11807111152";

    private final static String syono4 = "11807111163";

    private final static String syono5 = "11807111174";

    @Inject
    private NyuukinKakusyouDataSks nyuukinKakusyouDataSks;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        baseUserInfo.getUser().setUserId("Junit");
        khozenCommonParam.setFunctionId("NyuukinKakusyouDataSks");

        NyuukinKakusyouDataSksParam nyuukinKakusyouDataSksParam = new NyuukinKakusyouDataSksParam();
        nyuukinKakusyouDataSksParam.setSyoNo(syono1);
        nyuukinKakusyouDataSksParam.setNykSyoriYmd(BizDate.valueOf("20171206"));
        nyuukinKakusyouDataSksParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20170413"));
        nyuukinKakusyouDataSksParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinKakusyouDataSksParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinKakusyouDataSksParam.setNykNaiyouKbn(C_NyknaiyouKbn.HARAIHENYOUP);
        nyuukinKakusyouDataSksParam.setIktNyuukinUmu(C_UmuKbn.ARI);
        nyuukinKakusyouDataSksParam.setJyutouYm(BizDateYM.valueOf("201705"));
        nyuukinKakusyouDataSksParam.setJyutouKaisuuY(6);
        nyuukinKakusyouDataSksParam.setJyutouKaisuuM(7);
        nyuukinKakusyouDataSksParam.setRyosyuGk(BizCurrency.valueOf(88888));
        nyuukinKakusyouDataSksParam.setRyosyuYmd(BizDate.valueOf("20170909"));
        nyuukinKakusyouDataSksParam.setDenrenNo("1");
        nyuukinKakusyouDataSksParam.setEdano(10);
        nyuukinKakusyouDataSksParam.setSuitouBumonCd("111");
        nyuukinKakusyouDataSksParam.setHenkousikibetukey("123456789");
        nyuukinKakusyouDataSksParam.setNykhouhoukbn(C_NykhouhouKbn.HURIKAE);
        nyuukinKakusyouDataSksParam.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        nyuukinKakusyouDataSksParam.setNykdenYmd(BizDate.valueOf("20171206"));
        nyuukinKakusyouDataSksParam.setKzHurikaeBankCd("2222");
        nyuukinKakusyouDataSksParam.setKzHurikaeSitenCd("333");
        nyuukinKakusyouDataSksParam.setTabakarikanjyono("44");
        nyuukinKakusyouDataSksParam.setSuitoSoshikiCd("444");
        nyuukinKakusyouDataSksParam.setCreditKessaiyouNo("A1B2C3D4E5F6G7H8I9J0K1L2M3");
        nyuukinKakusyouDataSksParam.setSyuudaikoCd(C_Syuudaikocd.CSS);
        nyuukinKakusyouDataSksParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.TUUJYOU);

        IT_NyuukinKakusyouData itNyuukinKakusyouData = nyuukinKakusyouDataSks.exec(khozenCommonParam, nyuukinKakusyouDataSksParam);

        exStringEquals(itNyuukinKakusyouData.getKbnkey(), "02", "区分キー");
        exStringEquals(itNyuukinKakusyouData.getSyono(), "11807111129", "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20171206"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20170413"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.HARAIHENYOUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201705"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 6, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 7, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(88888), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20170909"), "領収日");
        exStringEquals(itNyuukinKakusyouData.getDenrenno(), "1", "伝票データ連番");
        exNumericEquals(itNyuukinKakusyouData.getEdano(), 10, "枝番号");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "111", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getHenkousikibetukey(), "123456789", "変更識別キー");
        exClassificationEquals(itNyuukinKakusyouData.getNykhouhoukbn(), C_NykhouhouKbn.HURIKAE, "入金方法区分");
        exClassificationEquals(itNyuukinKakusyouData.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20171206"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getTabakarikanjyono(), "44", "束仮勘定番号");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "20171206", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getNyuuryokukbn(), C_NyuuryokuKbn.HONSYAKOUZAHRKM, "入力区分");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf(20171206), "入金伝票日付");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "444", "出納組織コード");
        exStringEquals(itNyuukinKakusyouData.getCreditkessaiyouno(), "", "クレジットカード決済用番号");
        exClassificationEquals(itNyuukinKakusyouData.getSyuudaikocd(), C_Syuudaikocd.BLNK, "収納代行社コード");
        exClassificationEquals(itNyuukinKakusyouData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.BLNK, "クレジットカード売上請求区分");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinKinou(), "NyuukinKakusyouDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        baseUserInfo.getUser().setUserId("Junit");
        khozenCommonParam.setFunctionId("NyuukinKakusyouDataSks");

        NyuukinKakusyouDataSksParam nyuukinKakusyouDataSksParam = new NyuukinKakusyouDataSksParam();
        nyuukinKakusyouDataSksParam.setSyoNo(syono2);
        nyuukinKakusyouDataSksParam.setNykSyoriYmd(BizDate.valueOf("20171206"));
        nyuukinKakusyouDataSksParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20170413"));
        nyuukinKakusyouDataSksParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinKakusyouDataSksParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinKakusyouDataSksParam.setNykNaiyouKbn(C_NyknaiyouKbn.HARAIHENYOUP);
        nyuukinKakusyouDataSksParam.setIktNyuukinUmu(C_UmuKbn.ARI);
        nyuukinKakusyouDataSksParam.setJyutouYm(BizDateYM.valueOf("201705"));
        nyuukinKakusyouDataSksParam.setJyutouKaisuuY(6);
        nyuukinKakusyouDataSksParam.setJyutouKaisuuM(7);
        nyuukinKakusyouDataSksParam.setRyosyuGk(BizCurrency.valueOf(88888));
        nyuukinKakusyouDataSksParam.setRyosyuYmd(BizDate.valueOf("20170909"));
        nyuukinKakusyouDataSksParam.setDenrenNo("2");
        nyuukinKakusyouDataSksParam.setEdano(10);
        nyuukinKakusyouDataSksParam.setSuitouBumonCd("111");
        nyuukinKakusyouDataSksParam.setKzHurikaeBankCd("2222");
        nyuukinKakusyouDataSksParam.setKzHurikaeSitenCd("333");
        nyuukinKakusyouDataSksParam.setHenkousikibetukey("123456789");
        nyuukinKakusyouDataSksParam.setNykhouhoukbn(C_NykhouhouKbn.HURIKAE);
        nyuukinKakusyouDataSksParam.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        nyuukinKakusyouDataSksParam.setNykdenYmd(BizDate.valueOf("20171010"));
        nyuukinKakusyouDataSksParam.setCreditKessaiyouNo("A1B2C3D4E5F6G7H8I9J0K1L2M3");
        nyuukinKakusyouDataSksParam.setSyuudaikoCd(C_Syuudaikocd.CSS);
        nyuukinKakusyouDataSksParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.TUUJYOU);

        IT_NyuukinKakusyouData itNyuukinKakusyouData = nyuukinKakusyouDataSks.exec(khozenCommonParam, nyuukinKakusyouDataSksParam);

        exStringEquals(itNyuukinKakusyouData.getKbnkey(), "03", "区分キー");
        exStringEquals(itNyuukinKakusyouData.getSyono(), "11807111130", "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20171206"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20170413"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.HARAIHENYOUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201705"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 6, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 7, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(88888), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20170909"), "領収日");
        exStringEquals(itNyuukinKakusyouData.getDenrenno(), "2", "伝票データ連番");
        exNumericEquals(itNyuukinKakusyouData.getEdano(), 10, "枝番号");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "111", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getHenkousikibetukey(), "123456789", "変更識別キー");
        exClassificationEquals(itNyuukinKakusyouData.getNykhouhoukbn(), C_NykhouhouKbn.HURIKAE, "入金方法区分");
        exClassificationEquals(itNyuukinKakusyouData.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf(20171010), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getUketuketencd(), "", "受付店コード");
        exStringEquals(itNyuukinKakusyouData.getCvscd(), "", "CVSコード");
        exStringEquals(itNyuukinKakusyouData.getRyousyuuhm(), "", "領収時分");
        exStringEquals(itNyuukinKakusyouData.getHurikomiyousiokyksmno(), "", "振込用紙お客さま番号");
        exStringEquals(itNyuukinKakusyouData.getHurikomiyousikakuninno(), "", "振込用紙確認番号");
        exStringEquals(itNyuukinKakusyouData.getKinyuukikankbn(), "", "金融機関区分");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getTabakarikanjyono(), "", "束仮勘定番号");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getNyuuryokukbn(), C_NyuuryokuKbn.YUUTYO_MT, "入力区分");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");
        exStringEquals(itNyuukinKakusyouData.getCreditkessaiyouno(), "A1B2C3D4E5F6G7H8I9J0K1L2M3", "クレジットカード決済用番号");
        exClassificationEquals(itNyuukinKakusyouData.getSyuudaikocd(), C_Syuudaikocd.BLNK, "収納代行社コード");
        exClassificationEquals(itNyuukinKakusyouData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.TUUJYOU, "クレジットカード売上請求区分");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinKinou(), "NyuukinKakusyouDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        baseUserInfo.getUser().setUserId("Junit");
        khozenCommonParam.setFunctionId("NyuukinKakusyouDataSks");

        NyuukinKakusyouDataSksParam nyuukinKakusyouDataSksParam = new NyuukinKakusyouDataSksParam();
        nyuukinKakusyouDataSksParam.setSyoNo(syono3);
        nyuukinKakusyouDataSksParam.setNykSyoriYmd(BizDate.valueOf("20171206"));
        nyuukinKakusyouDataSksParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20170413"));
        nyuukinKakusyouDataSksParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinKakusyouDataSksParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinKakusyouDataSksParam.setNykNaiyouKbn(C_NyknaiyouKbn.HARAIHENYOUP);
        nyuukinKakusyouDataSksParam.setIktNyuukinUmu(C_UmuKbn.ARI);
        nyuukinKakusyouDataSksParam.setJyutouYm(BizDateYM.valueOf("201705"));
        nyuukinKakusyouDataSksParam.setJyutouKaisuuY(6);
        nyuukinKakusyouDataSksParam.setJyutouKaisuuM(7);
        nyuukinKakusyouDataSksParam.setRyosyuGk(BizCurrency.valueOf(88888));
        nyuukinKakusyouDataSksParam.setRyosyuYmd(BizDate.valueOf("20170909"));
        nyuukinKakusyouDataSksParam.setDenrenNo("2");
        nyuukinKakusyouDataSksParam.setEdano(10);
        nyuukinKakusyouDataSksParam.setSuitouBumonCd("111");
        nyuukinKakusyouDataSksParam.setHenkousikibetukey("123456789");
        nyuukinKakusyouDataSksParam.setNykhouhoukbn(C_NykhouhouKbn.HURIKAE);
        nyuukinKakusyouDataSksParam.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        nyuukinKakusyouDataSksParam.setNykdenYmd(BizDate.valueOf("20171010"));
        nyuukinKakusyouDataSksParam.setKzHurikaeBankCd("2222");
        nyuukinKakusyouDataSksParam.setKzHurikaeSitenCd("333");
        nyuukinKakusyouDataSksParam.setCreditKessaiyouNo("A1B2C3D4E5F6G7H8I9J0K1L2M3");
        nyuukinKakusyouDataSksParam.setSyuudaikoCd(C_Syuudaikocd.CSS);
        nyuukinKakusyouDataSksParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.TUUJYOU);

        IT_NyuukinKakusyouData itNyuukinKakusyouData = nyuukinKakusyouDataSks.exec(khozenCommonParam, nyuukinKakusyouDataSksParam);

        exStringEquals(itNyuukinKakusyouData.getKbnkey(), "05", "区分キー");
        exStringEquals(itNyuukinKakusyouData.getSyono(), "11807111152", "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20171206"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20170413"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.HARAIHENYOUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201705"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 6, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 7, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(88888), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20170909"), "領収日");
        exStringEquals(itNyuukinKakusyouData.getDenrenno(), "2", "伝票データ連番");
        exNumericEquals(itNyuukinKakusyouData.getEdano(), 10, "枝番号");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "111", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getHenkousikibetukey(), "123456789", "変更識別キー");
        exClassificationEquals(itNyuukinKakusyouData.getNykhouhoukbn(), C_NykhouhouKbn.HURIKAE, "入金方法区分");
        exClassificationEquals(itNyuukinKakusyouData.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf(20171010), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "2222", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "333", "口座振替支店コード");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");
        exStringEquals(itNyuukinKakusyouData.getCreditkessaiyouno(), "", "クレジットカード決済用番号");
        exClassificationEquals(itNyuukinKakusyouData.getSyuudaikocd(), C_Syuudaikocd.CSS, "収納代行社コード");
        exClassificationEquals(itNyuukinKakusyouData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.BLNK, "クレジットカード売上請求区分");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinKinou(), "NyuukinKakusyouDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        baseUserInfo.getUser().setUserId("Junit");
        khozenCommonParam.setFunctionId("NyuukinKakusyouDataSks");

        NyuukinKakusyouDataSksParam nyuukinKakusyouDataSksParam = new NyuukinKakusyouDataSksParam();
        nyuukinKakusyouDataSksParam.setSyoNo(syono4);

        IT_NyuukinKakusyouData itNyuukinKakusyouData = nyuukinKakusyouDataSks.exec(khozenCommonParam, nyuukinKakusyouDataSksParam);

        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), null, "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), null, "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.BLNK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.BLNK, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), null, "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 0, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(0), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), null, "領収日");
        exStringEquals(itNyuukinKakusyouData.getDenrenno(), "", "伝票データ連番");
        exNumericEquals(itNyuukinKakusyouData.getEdano(), 0, "枝番号");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getHenkousikibetukey(), "", "変更識別キー");
        exClassificationEquals(itNyuukinKakusyouData.getNykhouhoukbn(), C_NykhouhouKbn.BLNK, "入金方法区分");
        exClassificationEquals(itNyuukinKakusyouData.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), null, "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getUketuketencd(), "", "受付店コード");
        exStringEquals(itNyuukinKakusyouData.getCvscd(), "", "CVSコード");
        exStringEquals(itNyuukinKakusyouData.getRyousyuuhm(), "", "領収時分");
        exStringEquals(itNyuukinKakusyouData.getHurikomiyousiokyksmno(), "", "振込用紙お客さま番号");
        exStringEquals(itNyuukinKakusyouData.getHurikomiyousikakuninno(), "", "振込用紙確認番号");
        exStringEquals(itNyuukinKakusyouData.getKinyuukikankbn(), "", "金融機関区分");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getTabakarikanjyono(), "", "束仮勘定番号");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getNyuuryokukbn(), C_NyuuryokuKbn.YUUTYO_MT, "入力区分");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");
        exStringEquals(itNyuukinKakusyouData.getCreditkessaiyouno(), "", "クレジットカード決済用番号");
        exClassificationEquals(itNyuukinKakusyouData.getSyuudaikocd(), C_Syuudaikocd.BLNK, "収納代行社コード");
        exClassificationEquals(itNyuukinKakusyouData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.BLNK, "クレジットカード売上請求区分");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinKinou(), "NyuukinKakusyouDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        baseUserInfo.getUser().setUserId("Junit");
        khozenCommonParam.setFunctionId("NyuukinKakusyouDataSks");

        NyuukinKakusyouDataSksParam nyuukinKakusyouDataSksParam = new NyuukinKakusyouDataSksParam();
        nyuukinKakusyouDataSksParam.setSyoNo(syono5);
        nyuukinKakusyouDataSksParam.setNykSyoriYmd(BizDate.valueOf("20171206"));
        nyuukinKakusyouDataSksParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20170413"));
        nyuukinKakusyouDataSksParam.setNykKeiro(C_Nykkeiro.CONVENI);
        nyuukinKakusyouDataSksParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinKakusyouDataSksParam.setNykNaiyouKbn(C_NyknaiyouKbn.HARAIHENYOUP);
        nyuukinKakusyouDataSksParam.setIktNyuukinUmu(C_UmuKbn.ARI);
        nyuukinKakusyouDataSksParam.setJyutouYm(BizDateYM.valueOf("201705"));
        nyuukinKakusyouDataSksParam.setJyutouKaisuuY(6);
        nyuukinKakusyouDataSksParam.setJyutouKaisuuM(7);
        nyuukinKakusyouDataSksParam.setRyosyuGk(BizCurrency.valueOf(88888));
        nyuukinKakusyouDataSksParam.setRyosyuYmd(BizDate.valueOf("20170909"));
        nyuukinKakusyouDataSksParam.setDenrenNo("2");
        nyuukinKakusyouDataSksParam.setEdano(10);
        nyuukinKakusyouDataSksParam.setSuitouBumonCd("111");
        nyuukinKakusyouDataSksParam.setHenkousikibetukey("123456789");
        nyuukinKakusyouDataSksParam.setNykhouhoukbn(C_NykhouhouKbn.HURIKAE);
        nyuukinKakusyouDataSksParam.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        nyuukinKakusyouDataSksParam.setNykdenYmd(BizDate.valueOf("20171010"));
        nyuukinKakusyouDataSksParam.setCreditKessaiyouNo("A1B2C3D4E5F6G7H8I9J0K1L2M3");
        nyuukinKakusyouDataSksParam.setSyuudaikoCd(C_Syuudaikocd.CSS);
        nyuukinKakusyouDataSksParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.TUUJYOU);

        IT_NyuukinKakusyouData itNyuukinKakusyouData = nyuukinKakusyouDataSks.exec(khozenCommonParam, nyuukinKakusyouDataSksParam);

        exStringEquals(itNyuukinKakusyouData.getKbnkey(), "07", "区分キー");
        exStringEquals(itNyuukinKakusyouData.getSyono(), "11807111174", "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20171206"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20170413"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.CONVENI, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.HARAIHENYOUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201705"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 6, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 7, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(88888), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20170909"), "領収日");
        exStringEquals(itNyuukinKakusyouData.getDenrenno(), "2", "伝票データ連番");
        exNumericEquals(itNyuukinKakusyouData.getEdano(), 10, "枝番号");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "111", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getHenkousikibetukey(), "123456789", "変更識別キー");
        exClassificationEquals(itNyuukinKakusyouData.getNykhouhoukbn(), C_NykhouhouKbn.HURIKAE, "入金方法区分");
        exClassificationEquals(itNyuukinKakusyouData.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf(20171010), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getUketuketencd(), "", "受付店コード");
        exStringEquals(itNyuukinKakusyouData.getCvscd(), "", "CVSコード");
        exStringEquals(itNyuukinKakusyouData.getRyousyuuhm(), "", "領収時分");
        exStringEquals(itNyuukinKakusyouData.getHurikomiyousiokyksmno(), "", "振込用紙お客さま番号");
        exStringEquals(itNyuukinKakusyouData.getHurikomiyousikakuninno(), "", "振込用紙確認番号");
        exStringEquals(itNyuukinKakusyouData.getKinyuukikankbn(), "", "金融機関区分");
        exStringEquals(itNyuukinKakusyouData.getCreditkessaiyouno(), "", "クレジットカード決済用番号");
        exClassificationEquals(itNyuukinKakusyouData.getSyuudaikocd(), C_Syuudaikocd.BLNK, "収納代行社コード");
        exClassificationEquals(itNyuukinKakusyouData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.BLNK, "クレジットカード売上請求区分");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinKinou(), "NyuukinKakusyouDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itNyuukinKakusyouData.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");

    }
}