package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HuridenYouHassouKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振替伝票情報クラスのメソッド {@link BzFurikaeDenpyouJouhou#setFurikaeDenEntity()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFurikaeDenpyouJouhouTest_setFurikaeDenEntity{

    @Inject
    private BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou;

    @Test
    @TestOrder(10)
    public void testSetFurikaeDenEntity_A1() {
        FurikaeDenpyouPage furikaeDenpyouPage = new FurikaeDenpyouPage();

        furikaeDenpyouPage.setSystemkbn("64");

        furikaeDenpyouPage.setTorihikiNo("10001");

        furikaeDenpyouPage.setPageNo(101);

        furikaeDenpyouPage.setTorihikiYmdGengoKbn("2");

        furikaeDenpyouPage.setTorihikiNen(3);

        furikaeDenpyouPage.setTorihikiTsuki(12);

        furikaeDenpyouPage.setTorihikiBi(20);

        furikaeDenpyouPage.setKjTantoukaNm("subject");

        furikaeDenpyouPage.setKjTantoukaCd("01");

        furikaeDenpyouPage.setKjSystemNm("漢字名");

        furikaeDenpyouPage.setKariKurikosiGk(BizCurrency.valueOf(100));

        furikaeDenpyouPage.setKasiKurikosiGk(BizCurrency.valueOf(200));

        furikaeDenpyouPage.setHuridenYouHassouKbn(C_HuridenYouHassouKbn.HASSOUSAKI1);

        furikaeDenpyouPage.setKjKariKurikosiGkHyjKm("漢字借方表示項目");

        furikaeDenpyouPage.setKariGoukeiGk(BizCurrency.valueOf(300));

        furikaeDenpyouPage.setKjKasiKurikosiGkHyjKm("漢字貸方表示項目");

        furikaeDenpyouPage.setKasiGoukeiGk(BizCurrency.valueOf(400));

        furikaeDenpyouPage.setGoukeiFlg(false);

        String[] kjkarikanjoukamokunms = new String[4];
        kjkarikanjoukamokunms[0] = "漢字借方勘定科目名一";
        kjkarikanjoukamokunms[1] = "漢字借方勘定科目名二";
        kjkarikanjoukamokunms[2] = "漢字借方勘定科目名三";
        kjkarikanjoukamokunms[3] = "漢字借方勘定科目名四";

        String[] kjkasikanjoukamokunms = new String[4];
        kjkasikanjoukamokunms[0] = "漢字貸方勘定科目名一";
        kjkasikanjoukamokunms[1] = "漢字貸方勘定科目名二";
        kjkasikanjoukamokunms[2] = "漢字貸方勘定科目名三";
        kjkasikanjoukamokunms[3] = "漢字貸方勘定科目名四";

        furikaeDenpyouPage.setKjKariKanjoukamokuNms(kjkarikanjoukamokunms);

        furikaeDenpyouPage.setKjKasiKanjoukamokuNms(kjkasikanjoukamokunms);

        BizCurrency[] karigks = new BizCurrency[4];
        karigks[0] = BizCurrency.valueOf(500);
        karigks[1] = BizCurrency.valueOf(700);
        karigks[2] = BizCurrency.valueOf(900);
        karigks[3] = BizCurrency.valueOf(1100);

        BizCurrency[] kasigks = new BizCurrency[4];
        kasigks[0] = BizCurrency.valueOf(600);
        kasigks[1] = BizCurrency.valueOf(800);
        kasigks[2] = BizCurrency.valueOf(1000);
        kasigks[3] = BizCurrency.valueOf(1200);

        furikaeDenpyouPage.setKariGks(karigks);

        furikaeDenpyouPage.setKasiGks(kasigks);

        String[] kasitekiyoukms = new String[4];
        kasitekiyoukms[0] = "Kari1";
        kasitekiyoukms[1] = "Kari2";
        kasitekiyoukms[2] = "Kari3";
        kasitekiyoukms[3] = "Kari4";

        String[] karitekiyoukms = new String[4];
        karitekiyoukms[0] = "Kasi1";
        karitekiyoukms[1] = "Kasi2";
        karitekiyoukms[2] = "Kasi3";
        karitekiyoukms[3] = "Kasi4";

        furikaeDenpyouPage.setKaritekiyouKms(karitekiyoukms);

        furikaeDenpyouPage.setKasiTekiyouKms(kasitekiyoukms);

        String[] kjkaritekiyoukms = new String[4];
        kjkaritekiyoukms[0] = "借方漢字摘要項目一";
        kjkaritekiyoukms[1] = "借方漢字摘要項目二";
        kjkaritekiyoukms[2] = "借方漢字摘要項目三";
        kjkaritekiyoukms[3] = "借方漢字摘要項目四";

        String[] kjkasitekiyoukms = new String[4];
        kjkasitekiyoukms[0] = "貸方漢字摘要項目一";
        kjkasitekiyoukms[1] = "貸方漢字摘要項目二";
        kjkasitekiyoukms[2] = "貸方漢字摘要項目三";
        kjkasitekiyoukms[3] = "貸方漢字摘要項目四";

        furikaeDenpyouPage.setKjKariTekiyouKms(kjkaritekiyoukms);

        furikaeDenpyouPage.setKjKasiTekiyouKms(kjkasitekiyoukms);

        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.FUHO);

        bzFurikaeDenpyouJouhou.setSyoriYmd(BizDate.valueOf(20160810));

        bzFurikaeDenpyouJouhou.setKjTekiyou1("漢字摘要一");

        bzFurikaeDenpyouJouhou.setKjTekiyou2("漢字摘要二");

        bzFurikaeDenpyouJouhou.setKjTekiyou3("漢字摘要三");

        FurikaeDenpyouParamImpl impl = SWAKInjector.getInstance(FurikaeDenpyouParamImpl.class);

        bzFurikaeDenpyouJouhou.setFurikaeDenEntity(impl, furikaeDenpyouPage);

        exStringEquals(impl.getZtykytkmksyoruicd(), "CM036", "（中継用）共通項目書類コード");
        exStringEquals(impl.getZtykytkmktyouhyousksymd(), "20160810", "（中継用）共通項目帳票作成年月日");
        exStringEquals(impl.getZtykytkmksystemkbn(), "64", "（中継用）共通項目システム区分");
        exStringEquals(impl.getZtykytkmktorihikino(), "10001", "（中継用）共通項目取引番号");
        exStringEquals(impl.getZtykytkmktorihikinoedano(), "101", "（中継用）共通項目取引番号枝番号");
        exStringEquals(impl.getZtykytkmkseifukukbn(), "1", "（中継用）共通項目正副区分");
        exStringEquals(impl.getZtykytkmkfuridenhassoukbn(), "01", "（中継用）共通項目振替伝票用発送区分");
        exStringEquals(impl.getZtykytkmkyobi(), "", "（中継用）共通項目予備項目");
        exStringEquals(impl.getZtysystemkbn(), "64", "（中継用）システム区分");
        exStringEquals(impl.getZtytorihikinoc8(), "10001", "（中継用）取引番号Ｃ８");
        exStringEquals(impl.getZtytorihikinoedano(), "101", "（中継用）取引番号枝番号");
        exStringEquals(impl.getZtykjhikaeinjikm(), "", "（中継用）漢字控印字項目");
        exStringEquals(impl.getZtytorihikiymdgengokbn(), "2", "（中継用）取引年月日元号区分");
        exStringEquals(impl.getZtytorihikinen(), "3", "（中継用）取引年");
        exStringEquals(impl.getZtytorihikituki(), "12", "（中継用）取引月");
        exStringEquals(impl.getZtytorihikibi(), "20", "（中継用）取引日");
        exStringEquals(impl.getZtykanjyoukbn(), "0", "（中継用）勘定区分");
        exStringEquals(impl.getZtykanjyoukbnnm(), "", "（中継用）勘定区分名");
        exStringEquals(impl.getZtykjtantoukanm(), "subject", "（中継用）漢字担当課名");
        exStringEquals(impl.getZtykjtantoucd(), "01", "（中継用）漢字担当コード");
        exStringEquals(impl.getZtykjsystemnm(), "漢字名", "（中継用）漢字システム名");
        exStringEquals(impl.getZtykarikurikosikingaku(), "100", "（中継用）借方繰越金額");
        exStringEquals(impl.getZtykasikurikosikingaku(), "200", "（中継用）貸方繰越金額");
        exStringEquals(impl.getZtydenpyoukbnnm(), "", "（中継用）伝票区分名");
        exStringEquals(impl.getZtykjkarikurikosigkhyjkm(), "漢字借方表示項目", "（中継用）漢字借方繰越合計表示項目");
        exStringEquals(impl.getZtykarikurikosigkkingaku(), "300", "（中継用）借方繰越合計金額");
        exStringEquals(impl.getZtykjkasikurikosigkhyjkm(), "漢字貸方表示項目", "（中継用）漢字貸方繰越合計表示項目");
        exStringEquals(impl.getZtykasikurikosigkkingaku(), "400", "（中継用）貸方繰越合計金額");
        exStringEquals(impl.getZtykjtekiyou1(), "漢字摘要一", "（中継用）漢字摘要１");
        exStringEquals(impl.getZtykjtekiyou2(), "漢字摘要二", "（中継用）漢字摘要２");
        exStringEquals(impl.getZtykjtekiyou3(), "漢字摘要三", "（中継用）漢字摘要３");
        exStringEquals(impl.getZtykjkarikanjyoukamokunm1(), "漢字借方勘定科目名一", "（中継用）漢字借方勘定科目名１");
        exStringEquals(impl.getZtykjkasikanjyoukamokunm1(), "漢字貸方勘定科目名一", "（中継用）漢字貸方勘定科目名１");
        exStringEquals(impl.getZtykaritekiyoukm1(), "Kasi1", "（中継用）借方摘要項目１");
        exStringEquals(impl.getZtykarikingaku1(), "500", "（中継用）借方金額１");
        exStringEquals(impl.getZtykasitekiyoukm1(), "Kari1", "（中継用）貸方摘要項目１");
        exStringEquals(impl.getZtykasikingaku1(), "600", "（中継用）貸方金額１");
        exStringEquals(impl.getZtykjkaritekiyoukm1(), "借方漢字摘要項目一", "（中継用）漢字借方摘要項目１");
        exStringEquals(impl.getZtykjkasitekiyoukm1(), "貸方漢字摘要項目一", "（中継用）漢字貸方摘要項目１");
        exStringEquals(impl.getZtykjkarikanjyoukamokunm2(), "漢字借方勘定科目名二", "（中継用）漢字借方勘定科目名２");
        exStringEquals(impl.getZtykjkasikanjyoukamokunm2(), "漢字貸方勘定科目名二", "（中継用）漢字貸方勘定科目名２");
        exStringEquals(impl.getZtykaritekiyoukm2(), "Kasi2", "（中継用）借方摘要項目２");
        exStringEquals(impl.getZtykarikingaku2(), "700", "（中継用）借方金額２");
        exStringEquals(impl.getZtykasitekiyoukm2(), "Kari2", "（中継用）貸方摘要項目２");
        exStringEquals(impl.getZtykasikingaku2(), "800", "（中継用）貸方金額２");
        exStringEquals(impl.getZtykjkaritekiyoukm2(), "借方漢字摘要項目二", "（中継用）漢字借方摘要項目２");
        exStringEquals(impl.getZtykjkasitekiyoukm2(), "貸方漢字摘要項目二", "（中継用）漢字貸方摘要項目２");
        exStringEquals(impl.getZtykjkarikanjyoukamokunm3(), "漢字借方勘定科目名三", "（中継用）漢字借方勘定科目名３");
        exStringEquals(impl.getZtykjkasikanjyoukamokunm3(), "漢字貸方勘定科目名三", "（中継用）漢字貸方勘定科目名３");
        exStringEquals(impl.getZtykaritekiyoukm3(), "Kasi3", "（中継用）借方摘要項目３");
        exStringEquals(impl.getZtykarikingaku3(), "900", "（中継用）借方金額３");
        exStringEquals(impl.getZtykasitekiyoukm3(), "Kari3", "（中継用）貸方摘要項目３");
        exStringEquals(impl.getZtykasikingaku3(), "1000", "（中継用）貸方金額３");
        exStringEquals(impl.getZtykjkaritekiyoukm3(), "借方漢字摘要項目三", "（中継用）漢字借方摘要項目３");
        exStringEquals(impl.getZtykjkasitekiyoukm3(), "貸方漢字摘要項目三", "（中継用）漢字貸方摘要項目３");
        exStringEquals(impl.getZtykjkarikanjyoukamokunm4(), "漢字借方勘定科目名四", "（中継用）漢字借方勘定科目名４");
        exStringEquals(impl.getZtykjkasikanjyoukamokunm4(), "漢字貸方勘定科目名四", "（中継用）漢字貸方勘定科目名４");
        exStringEquals(impl.getZtykaritekiyoukm4(), "Kasi4", "（中継用）借方摘要項目４");
        exStringEquals(impl.getZtykarikingaku4(), "1100", "（中継用）借方金額４");
        exStringEquals(impl.getZtykasitekiyoukm4(), "Kari4", "（中継用）貸方摘要項目４");
        exStringEquals(impl.getZtykasikingaku4(), "1200", "（中継用）貸方金額４");
        exStringEquals(impl.getZtykjkaritekiyoukm4(), "借方漢字摘要項目四", "（中継用）漢字借方摘要項目４");
        exStringEquals(impl.getZtykjkasitekiyoukm4(), "貸方漢字摘要項目四", "（中継用）漢字貸方摘要項目４");
    }
    @Test
    @TestOrder(20)
    public void testSetFurikaeDenEntity_A2() {
        FurikaeDenpyouPage furikaeDenpyouPage = new FurikaeDenpyouPage();

        furikaeDenpyouPage.setSystemkbn("64");

        furikaeDenpyouPage.setTorihikiNo("10001");

        furikaeDenpyouPage.setPageNo(101);

        furikaeDenpyouPage.setTorihikiYmdGengoKbn("2");

        furikaeDenpyouPage.setTorihikiNen(3);

        furikaeDenpyouPage.setTorihikiTsuki(12);

        furikaeDenpyouPage.setTorihikiBi(20);

        furikaeDenpyouPage.setKjTantoukaNm("subject");

        furikaeDenpyouPage.setKjTantoukaCd("01");

        furikaeDenpyouPage.setKjSystemNm("漢字名");

        furikaeDenpyouPage.setKariKurikosiGk(BizCurrency.valueOf(100));

        furikaeDenpyouPage.setKasiKurikosiGk(BizCurrency.valueOf(200));

        furikaeDenpyouPage.setHuridenYouHassouKbn(C_HuridenYouHassouKbn.HASSOUSAKI1);

        furikaeDenpyouPage.setKjKariKurikosiGkHyjKm("漢字借方表示項目");

        furikaeDenpyouPage.setKariGoukeiGk(BizCurrency.valueOf(300));

        furikaeDenpyouPage.setKjKasiKurikosiGkHyjKm("漢字貸方表示項目");

        furikaeDenpyouPage.setKasiGoukeiGk(BizCurrency.valueOf(400));

        furikaeDenpyouPage.setGoukeiFlg(true);

        String[] kjkarikanjoukamokunms = new String[4];
        kjkarikanjoukamokunms[0] = "漢字借方勘定科目名一";
        kjkarikanjoukamokunms[1] = "漢字借方勘定科目名二";
        kjkarikanjoukamokunms[2] = "漢字借方勘定科目名三";
        kjkarikanjoukamokunms[3] = "漢字借方勘定科目名四";

        String[] kjkasikanjoukamokunms = new String[4];
        kjkasikanjoukamokunms[0] = "漢字貸方勘定科目名一";
        kjkasikanjoukamokunms[1] = "漢字貸方勘定科目名二";
        kjkasikanjoukamokunms[2] = "漢字貸方勘定科目名三";
        kjkasikanjoukamokunms[3] = "漢字貸方勘定科目名四";

        furikaeDenpyouPage.setKjKariKanjoukamokuNms(kjkarikanjoukamokunms);

        furikaeDenpyouPage.setKjKasiKanjoukamokuNms(kjkasikanjoukamokunms);

        BizCurrency[] karigks = new BizCurrency[4];
        karigks[0] = BizCurrency.valueOf(500);
        karigks[1] = BizCurrency.valueOf(700);
        karigks[2] = BizCurrency.valueOf(900);
        karigks[3] = BizCurrency.valueOf(1100);

        BizCurrency[] kasigks = new BizCurrency[4];
        kasigks[0] = BizCurrency.valueOf(600);
        kasigks[1] = BizCurrency.valueOf(800);
        kasigks[2] = BizCurrency.valueOf(1000);
        kasigks[3] = BizCurrency.valueOf(1200);

        furikaeDenpyouPage.setKariGks(karigks);

        furikaeDenpyouPage.setKasiGks(kasigks);

        String[] kasitekiyoukms = new String[4];
        kasitekiyoukms[0] = "Kari1";
        kasitekiyoukms[1] = "Kari2";
        kasitekiyoukms[2] = "Kari3";
        kasitekiyoukms[3] = "Kari4";

        String[] karitekiyoukms = new String[4];
        karitekiyoukms[0] = "Kasi1";
        karitekiyoukms[1] = "Kasi2";
        karitekiyoukms[2] = "Kasi3";
        karitekiyoukms[3] = "Kasi4";

        furikaeDenpyouPage.setKaritekiyouKms(karitekiyoukms);

        furikaeDenpyouPage.setKasiTekiyouKms(kasitekiyoukms);

        String[] kjkaritekiyoukms = new String[4];
        kjkaritekiyoukms[0] = "借方漢字摘要項目一";
        kjkaritekiyoukms[1] = "借方漢字摘要項目二";
        kjkaritekiyoukms[2] = "借方漢字摘要項目三";
        kjkaritekiyoukms[3] = "借方漢字摘要項目四";

        String[] kjkasitekiyoukms = new String[4];
        kjkasitekiyoukms[0] = "貸方漢字摘要項目一";
        kjkasitekiyoukms[1] = "貸方漢字摘要項目二";
        kjkasitekiyoukms[2] = "貸方漢字摘要項目三";
        kjkasitekiyoukms[3] = "貸方漢字摘要項目四";

        furikaeDenpyouPage.setKjKariTekiyouKms(kjkaritekiyoukms);

        furikaeDenpyouPage.setKjKasiTekiyouKms(kjkasitekiyoukms);

        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.FUHO);

        bzFurikaeDenpyouJouhou.setSyoriYmd(BizDate.valueOf(20160810));

        bzFurikaeDenpyouJouhou.setKjTekiyou1("漢字摘要一");

        bzFurikaeDenpyouJouhou.setKjTekiyou2("漢字摘要二");

        bzFurikaeDenpyouJouhou.setKjTekiyou3("漢字摘要三");

        FurikaeDenpyouParamImpl impl = SWAKInjector.getInstance(FurikaeDenpyouParamImpl.class);

        bzFurikaeDenpyouJouhou.setFurikaeDenEntity(impl, furikaeDenpyouPage);

        exStringEquals(impl.getZtykytkmksyoruicd(), "CM036", "（中継用）共通項目書類コード");
        exStringEquals(impl.getZtykytkmktyouhyousksymd(), "20160810", "（中継用）共通項目帳票作成年月日");
        exStringEquals(impl.getZtykytkmksystemkbn(), "64", "（中継用）共通項目システム区分");
        exStringEquals(impl.getZtykytkmktorihikino(), "10001", "（中継用）共通項目取引番号");
        exStringEquals(impl.getZtykytkmktorihikinoedano(), "101", "（中継用）共通項目取引番号枝番号");
        exStringEquals(impl.getZtykytkmkseifukukbn(), "1", "（中継用）共通項目正副区分");
        exStringEquals(impl.getZtykytkmkfuridenhassoukbn(), "01", "（中継用）共通項目振替伝票用発送区分");
        exStringEquals(impl.getZtykytkmkyobi(), "", "（中継用）共通項目予備項目");
        exStringEquals(impl.getZtysystemkbn(), "64", "（中継用）システム区分");
        exStringEquals(impl.getZtytorihikinoc8(), "10001", "（中継用）取引番号Ｃ８");
        exStringEquals(impl.getZtytorihikinoedano(), "101", "（中継用）取引番号枝番号");
        exStringEquals(impl.getZtykjhikaeinjikm(), "", "（中継用）漢字控印字項目");
        exStringEquals(impl.getZtytorihikiymdgengokbn(), "2", "（中継用）取引年月日元号区分");
        exStringEquals(impl.getZtytorihikinen(), "3", "（中継用）取引年");
        exStringEquals(impl.getZtytorihikituki(), "12", "（中継用）取引月");
        exStringEquals(impl.getZtytorihikibi(), "20", "（中継用）取引日");
        exStringEquals(impl.getZtykanjyoukbn(), "0", "（中継用）勘定区分");
        exStringEquals(impl.getZtykanjyoukbnnm(), "", "（中継用）勘定区分名");
        exStringEquals(impl.getZtykjtantoukanm(), "subject", "（中継用）漢字担当課名");
        exStringEquals(impl.getZtykjtantoucd(), "01", "（中継用）漢字担当コード");
        exStringEquals(impl.getZtykjsystemnm(), "漢字名", "（中継用）漢字システム名");
        exStringEquals(impl.getZtykarikurikosikingaku(), "100", "（中継用）借方繰越金額");
        exStringEquals(impl.getZtykasikurikosikingaku(), "200", "（中継用）貸方繰越金額");
        exStringEquals(impl.getZtykjkarikurikosigkhyjkm(), "漢字借方表示項目", "（中継用）漢字借方繰越合計表示項目");
        exStringEquals(impl.getZtykarikurikosigkkingaku(), "¥300", "（中継用）借方繰越合計金額");
        exStringEquals(impl.getZtykjkasikurikosigkhyjkm(), "漢字貸方表示項目", "（中継用）漢字貸方繰越合計表示項目");
        exStringEquals(impl.getZtykasikurikosigkkingaku(), "¥400", "（中継用）貸方繰越合計金額");
        exStringEquals(impl.getZtykjtekiyou1(), "漢字摘要一", "（中継用）漢字摘要１");
        exStringEquals(impl.getZtykjtekiyou2(), "漢字摘要二", "（中継用）漢字摘要２");
        exStringEquals(impl.getZtykjtekiyou3(), "漢字摘要三", "（中継用）漢字摘要３");
        exStringEquals(impl.getZtykjkarikanjyoukamokunm1(), "漢字借方勘定科目名一", "（中継用）漢字借方勘定科目名１");
        exStringEquals(impl.getZtykjkasikanjyoukamokunm1(), "漢字貸方勘定科目名一", "（中継用）漢字貸方勘定科目名１");
        exStringEquals(impl.getZtykaritekiyoukm1(), "Kasi1", "（中継用）借方摘要項目１");
        exStringEquals(impl.getZtykarikingaku1(), "500", "（中継用）借方金額１");
        exStringEquals(impl.getZtykasitekiyoukm1(), "Kari1", "（中継用）貸方摘要項目１");
        exStringEquals(impl.getZtykasikingaku1(), "600", "（中継用）貸方金額１");
        exStringEquals(impl.getZtykjkaritekiyoukm1(), "借方漢字摘要項目一", "（中継用）漢字借方摘要項目１");
        exStringEquals(impl.getZtykjkasitekiyoukm1(), "貸方漢字摘要項目一", "（中継用）漢字貸方摘要項目１");
        exStringEquals(impl.getZtykjkarikanjyoukamokunm2(), "漢字借方勘定科目名二", "（中継用）漢字借方勘定科目名２");
        exStringEquals(impl.getZtykjkasikanjyoukamokunm2(), "漢字貸方勘定科目名二", "（中継用）漢字貸方勘定科目名２");
        exStringEquals(impl.getZtykaritekiyoukm2(), "Kasi2", "（中継用）借方摘要項目２");
        exStringEquals(impl.getZtykarikingaku2(), "700", "（中継用）借方金額２");
        exStringEquals(impl.getZtykasitekiyoukm2(), "Kari2", "（中継用）貸方摘要項目２");
        exStringEquals(impl.getZtykasikingaku2(), "800", "（中継用）貸方金額２");
        exStringEquals(impl.getZtykjkaritekiyoukm2(), "借方漢字摘要項目二", "（中継用）漢字借方摘要項目２");
        exStringEquals(impl.getZtykjkasitekiyoukm2(), "貸方漢字摘要項目二", "（中継用）漢字貸方摘要項目２");
        exStringEquals(impl.getZtykjkarikanjyoukamokunm3(), "漢字借方勘定科目名三", "（中継用）漢字借方勘定科目名３");
        exStringEquals(impl.getZtykjkasikanjyoukamokunm3(), "漢字貸方勘定科目名三", "（中継用）漢字貸方勘定科目名３");
        exStringEquals(impl.getZtykaritekiyoukm3(), "Kasi3", "（中継用）借方摘要項目３");
        exStringEquals(impl.getZtykarikingaku3(), "900", "（中継用）借方金額３");
        exStringEquals(impl.getZtykasitekiyoukm3(), "Kari3", "（中継用）貸方摘要項目３");
        exStringEquals(impl.getZtykasikingaku3(), "1000", "（中継用）貸方金額３");
        exStringEquals(impl.getZtykjkaritekiyoukm3(), "借方漢字摘要項目三", "（中継用）漢字借方摘要項目３");
        exStringEquals(impl.getZtykjkasitekiyoukm3(), "貸方漢字摘要項目三", "（中継用）漢字貸方摘要項目３");
        exStringEquals(impl.getZtykjkarikanjyoukamokunm4(), "漢字借方勘定科目名四", "（中継用）漢字借方勘定科目名４");
        exStringEquals(impl.getZtykjkasikanjyoukamokunm4(), "漢字貸方勘定科目名四", "（中継用）漢字貸方勘定科目名４");
        exStringEquals(impl.getZtykaritekiyoukm4(), "Kasi4", "（中継用）借方摘要項目４");
        exStringEquals(impl.getZtykarikingaku4(), "1100", "（中継用）借方金額４");
        exStringEquals(impl.getZtykasitekiyoukm4(), "Kari4", "（中継用）貸方摘要項目４");
        exStringEquals(impl.getZtykasikingaku4(), "1200", "（中継用）貸方金額４");
        exStringEquals(impl.getZtykjkaritekiyoukm4(), "借方漢字摘要項目四", "（中継用）漢字借方摘要項目４");
        exStringEquals(impl.getZtykjkasitekiyoukm4(), "貸方漢字摘要項目四", "（中継用）漢字貸方摘要項目４");
    }
}
