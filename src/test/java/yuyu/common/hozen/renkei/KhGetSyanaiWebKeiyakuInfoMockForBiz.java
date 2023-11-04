package yuyu.common.hozen.renkei;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakunaiyouSyoukaiWebServiceTest_exec;
import yuyu.def.biz.bean.webservice.IwssnSyanaiHozenInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;

/**
 * {@link KhGetSyanaiWebKeiyakuInfo}のモッククラスです。<br />
 */
public class KhGetSyanaiWebKeiyakuInfoMockForBiz extends KhGetSyanaiWebKeiyakuInfo{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    private IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiHozenInfoOutputBean.class);

    @Override
    public C_IwssnKykSyoukaiKekkaKbn exec(String pSyono) {

        iwssnSyanaiHozenInfoOutputBean.setIwssnSyono(pSyono);

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.GAITOUKEIYAKUNASI_ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.NORMAL;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.EXCEPTION;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.CASHVALUEINFO_ERROR;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.KIOUREKI_ERROR;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.TANTOUSYAINFO_ERROR;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.TDKTYUUIINFO_ERROR;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.SOUGOUSYOUKAI_MITAIOUSYOUHN;
            }
        }

        return super.exec(pSyono);
    }

    @Override
    public IwssnSyanaiHozenInfoOutputBean getIwssnSyanaiHozenInfoOutputBean() {

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnKyknmkn("ケイヤクシヤメイカナ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKyknmkj("契約者名漢字");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyaseiymd("20180101");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyanen("10");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyasei("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykseikj("男性");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKyktdk("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKyktdkkj("契約者本人");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHhknsyanmkn("ヒホケンシヤメイカナ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHhknnmkj("被保険者名漢字");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHhknseiymd("20180601");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHhknkyknen("11");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHhknnen("12");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHhknsei("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHhknseikj("女性");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTsinyno("1001000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr1kj("通信先住所１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr2kj("通信先住所２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr3kj("通信先住所３");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTsintelno("022-2222-2222");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouuktkbn("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouuktkj("契約者のみ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari1("01");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari2("02");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari3("03");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari4("04");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana1("ユケイメイ　ニコ１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana2("ユケイメイ　ニコ２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana3("ユケイメイ　ニコ３");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana4("ユケイメイ　ニコ４");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji1("ユ契名　二こ１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji2("ユ契名　二こ２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji3("ユ契名　二こ３");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji4("ユ契名　二こ４");
            iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkbn("3");
            iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkj("年金受取人");
            iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknkbn("4");
            iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknkbnnm("指定代理請求人");
            iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknsmikanji("指定代理請求人氏名漢字");
            iwssnSyanaiHozenInfoOutputBean.setIwssnStdrskntkyhkkbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknsmikana("ユケイメイ　ニイ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyouhncd("ﾕｹ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyouhnnm("商品名");
            iwssnSyanaiHozenInfoOutputBean.setIwssnAisyoumeikj("笑顔の約束");
            iwssnSyanaiHozenInfoOutputBean.setIwssnAisyoumeikbn("702");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetujiyuu("11");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetujiyuukj("契約取消");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykjyoutaikbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykjyoutaikbnnm("払込中");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykymd("20180201");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSknnkaisiymd("20180301");
            iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuuym("201804");
            iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukj("確定年金");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKjnnkpzeitekitkhukakbn("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnPyenhrktkkbn("3");
            iwssnSyanaiHozenInfoOutputBean.setIwssnPstigihrktkkbn("4");
            iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkkbn("5");
            iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkwra("701");
            iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjiyensitihsykbn("5");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn("50");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1from("20170101");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1to("20190101");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2from("20161201");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2to("20181201");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn3("20180115");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHrkkkn("20");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHrktuuka("101");
            iwssnSyanaiHozenInfoOutputBean.setIwssnYoteiriritu("0.031");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaipnyknrate("0.0123");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykjisjkkktusirrt("0.044");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaijikkktusirrt("0.045");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTumitateriritu("0.046");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSetteibairitu("0.5");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykjiTmttknzkrtjygn("0.099");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSisuuwari("0.1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTeirituwari("0.2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSiteituuka("0.3");
            iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaika("20001");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKihonhokenkngk("10999");
            iwssnSyanaiHozenInfoOutputBean.setIwssnGenzaisbhknkngaku("50000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyen("60000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakugaika("65000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkjnkg("70000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjyensitihsykjnkg("45000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnJyudkaigomeharaitkkbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhrgaika("40000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryen("55000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeigaika("75000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeiyen("80000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekin("85000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankin("90000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnShrkwsrate("0.0123");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKwsratesyutokuymd("20180215");
            iwssnSyanaiHozenInfoOutputBean.setIwssnDairitencd1("5110001");
            iwssnSyanaiHozenInfoOutputBean.setIwssnDairitencd2("5110002");
            iwssnSyanaiHozenInfoOutputBean.setIwssnDairitenm1("代理店名１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnDairitenm2("代理店名２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnDaibosyuucd1("511001");
            iwssnSyanaiHozenInfoOutputBean.setIwssnDaibosyuucd2("511002");
            iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuunin1("募集人名１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuunin2("募集人名２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn1("01");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn2("02");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn3("03");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn4("04");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn5("05");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj1("手続中応対注意");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj2("契約者に関する捜査照会");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj3("破産および倒産");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj4("保険契約差押え");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj5("契約者行方不明");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd1("20170201");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd2("20170202");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd3("20170203");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd4("20170204");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd5("20170205");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo1("手続注意内容１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo2("手続注意内容２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo3("手続注意内容３");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo4("手続注意内容４");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo5("手続注意内容５");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyoriymd1("20170301");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyoriymd2("20170302");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyoriymd3("20170303");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyorinaiyou1("手続履歴処理内容１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyorinaiyou2("手続履歴処理内容２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyorinaiyou3("手続履歴処理内容３");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyhenkouymd("20200101");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyhenkousyorinm("最終変更処理名");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyokensakuseiymd("20150105");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyosaihkymd("20160120");
            iwssnSyanaiHozenInfoOutputBean.setIwssnYensysnhkyenhnkymd("20180120");
            iwssnSyanaiHozenInfoOutputBean.setIwssnYennknhkyenhnkymd("20170120");
            iwssnSyanaiHozenInfoOutputBean.setIwssnWarnmongon("ワーニング文言");
            iwssnSyanaiHozenInfoOutputBean.setIwssnYakkanjyuryouhoukbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnYakkanjyuryouhoukbnnm("Ｗｅｂ受取り");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSioriyakkansearchcd("しおり約款検索コード");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetuymd("20201020");
            iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnkshrstartymd("20201021");
            iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinkkn("15");
            iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpyen("25001");
            iwssnSyanaiHozenInfoOutputBean.setIwssn10nentumitateriritu("0.1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrtkykhukakbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrkbn("10");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrkbnnm("登録家族（１人目）と同じ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdairinmkj("ユユ受名　一あ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdairinmkn("ﾕﾕｳｹﾒｲ ｲﾁｱ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrseiymd("19450102");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdryno("1001001");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr1kj("住所１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr2kj("住所２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr3kj("住所３");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrknhatudoujyoutai("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm1kn("ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm1kj("ユ受名　三二き");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1seiymd("20200319");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1sei("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1seinm("男性");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tdk("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tdknm("配偶者");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1yno("1001000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr1kj("住所１１住所１１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr2kj("住所１２住所１２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr3kj("住所１３住所１３");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1telno("011-1111-1111");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm2kn("ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm2kj("ユ受名　三二く");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2seiymd("20200320");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2sei("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2seinm("女性");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tdk("3");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tdknm("親");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2yno("2002000");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr1kj("住所２１住所２１");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr2kj("住所２２住所２２");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr3kj("住所２３住所２３");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2telno("022-2222-2222");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgk("123.00");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgktuukasyu("DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukoujyoritu("2.3");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbnnm("歳満期");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhknkknsmnkbn("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhknkknsmnkbnnm("年満期");
            iwssnSyanaiHozenInfoOutputBean.setIwssnMkhynsysnnktkjnkgtuksy("YEN");
            iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaikatuukasyu("DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpyentuukasyu("YEN");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKihonhokenkngktuukasyu("DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnGenzaisbhknkngakutuksy("AU_DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyentuksyu("YEN");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakugktuksyu("DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjyensykjnkgtksy("YEN");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhrgaikatuukasyu("DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryentuukasyu("YEN");
            iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeigaikatuukasyu("DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeiyentuukasyu("YEN");
            iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankintuukasy("DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekintuukasyu("YEN");
            iwssnSyanaiHozenInfoOutputBean.setIwssnSykaipnyknratesyutkymd("20200319");
            iwssnSyanaiHozenInfoOutputBean.setIwssnHhkdrseiymd("19450102");
            iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpnykntuuka("10000.00");
            iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpnykntuukatuksy("DOLLAR");
            iwssnSyanaiHozenInfoOutputBean.setIwssnKzktrkserviceryumu("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnRendouritu("1.2345");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tsindousiteikbn("0");
            iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tsindousiteikbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnStknsetkbn("2");
            iwssnSyanaiHozenInfoOutputBean.setIwssnStknsetkbnnm("設定なし");
            iwssnSyanaiHozenInfoOutputBean.setIwssnYnkhrkmgkannittkbn("1");
            iwssnSyanaiHozenInfoOutputBean.setIwssnYnkhrkmgkannittkbnnm("希望する（メール、郵送）");
            iwssnSyanaiHozenInfoOutputBean.setIwssnDai2tsintelno("022-2222-2222");

            return iwssnSyanaiHozenInfoOutputBean;
        }

        return super.getIwssnSyanaiHozenInfoOutputBean();
    }
}