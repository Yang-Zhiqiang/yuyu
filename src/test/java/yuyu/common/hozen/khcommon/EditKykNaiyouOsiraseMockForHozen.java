package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.app.bosyuu.hbkeiyakusyoukai.hbkyknaiyouosirase.HbKykNaiyouOsiraseTest_exec;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;

/**
 * {@link EditKykNaiyouOsirase}のモッククラスです<br />
 */
public class EditKykNaiyouOsiraseMockForHozen extends EditKykNaiyouOsirase {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn getBizLogicErrorKbn() {

        if (caller == KykNaiyouOsiraseiSksTest_exec.class ||
            caller == KykNaiyouOsiraseiSksTest_setReportBean.class) {

            if (TESTPATTERN1.equals(SYORIPTN) ||
                TESTPATTERN3.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN) ||
                TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN6.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == HbKykNaiyouOsiraseTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)){

                return C_ErrorKbn.OK;
            }
        }

        return super.getBizLogicErrorKbn();
    }

    @Override
    public String getBizLogicErrorMsg() {

        if (caller == KykNaiyouOsiraseiSksTest_exec.class ||
            caller == KykNaiyouOsiraseiSksTest_setReportBean.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return MessageUtil.getMessage(MessageId.EBA1048);
            }
        }
        return super.getBizLogicErrorMsg();
    }

    @Override
    public ZT_GaikaKokyakuTuutiTy editInfo(
        String pSyono,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        String pSyouhnHanmeiKbn,
        String pCampaignFlg,
        KawaseRateBean pKawaseRateBean,
        int pYobidasimotoKbn) {

        if (caller == KykNaiyouOsiraseiSksTest_exec.class ||
            caller == KykNaiyouOsiraseiSksTest_setReportBean.class ||
            caller == HbKykNaiyouOsiraseTest_exec.class) {

            ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();
            gaikaKokyakuTuutiTy.setZtysyono(pSyono);
            gaikaKokyakuTuutiTy.setZtyaisyoumeikbn("702");
            gaikaKokyakuTuutiTy.setZtykyknmkj18("契約者名（漢字）（１８桁）");
            gaikaKokyakuTuutiTy.setZtyhhknnmkj18("被保険者名（漢字）（１８桁）");
            gaikaKokyakuTuutiTy.setZtykoktuutireportlayoutptn(pSyouhnHanmeiKbn);
            gaikaKokyakuTuutiTy.setZtykykymdwa("２０２０年１１月０７日");
            gaikaKokyakuTuutiTy.setZtyhrktuukatype("AUD");
            gaikaKokyakuTuutiTy.setZtydai1hknkknfromwa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(20270423)));
            gaikaKokyakuTuutiTy.setZtydai1hknkkn(BizUtil.zeroNum(String.valueOf(1), 2, 0));
            gaikaKokyakuTuutiTy.setZtydai2hknkknfromwa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(20270427)));
            gaikaKokyakuTuutiTy.setZtydai2hknkkntowa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(20320423)));
            gaikaKokyakuTuutiTy.setZtydai3hknkknfromwa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(20320424)));
            gaikaKokyakuTuutiTy.setZtydai3hknkknto("以降（終身）");


            gaikaKokyakuTuutiTy.setZtyitijibrpkyktuuka(String.valueOf(1000000));
            gaikaKokyakuTuutiTy.setZtykihonsktuuka(String.valueOf(1690900));
            gaikaKokyakuTuutiTy.setZtyyenhrkgk(String.valueOf(2690900));
            gaikaKokyakuTuutiTy.setZtystigituukahrkgk(String.valueOf(3690900));
            gaikaKokyakuTuutiTy.setZtyyenkhrikmrate("11949");
            gaikaKokyakuTuutiTy.setZtystigikwsrate("12104");
            gaikaKokyakuTuutiTy.setZtyhrkgkhyoujikbn("1");
            gaikaKokyakuTuutiTy.setZtykjnkngkkawaserate("12104");
            gaikaKokyakuTuutiTy.setZtykjnkngkhyoujikbn("2");
            gaikaKokyakuTuutiTy.setZtysakuseikijyunymdkwsrate("12231");
            gaikaKokyakuTuutiTy.setZtysbhknkngkhknkknfromwa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(20270428)));
            gaikaKokyakuTuutiTy.setZtysbhknkngkhknkkntowa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(20270429)));
            gaikaKokyakuTuutiTy.setZtysbhknkngkkyktuuka("1200000");
            gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakuktuuka("2690900");
            gaikaKokyakuTuutiTy.setZtytumitatekngkktuuka("979876");
            gaikaKokyakuTuutiTy.setZtytumitatekngkkyen("1198683");
            gaikaKokyakuTuutiTy.setZtykaiyakuhrkngakkyktuuka("624140");
            gaikaKokyakuTuutiTy.setZtykaiyakuhrkngakyen("763511");
            gaikaKokyakuTuutiTy.setZtymkhgkyen("999999");
            gaikaKokyakuTuutiTy.setZtymkhgkhyoujikbn("1");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd1("05001");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd2("05003");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd3("");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd4("05005");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd5("05006");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd6("05007");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd7("05018");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd8("05019");
            gaikaKokyakuTuutiTy.setZtyhosyouhskmsgcd9("");
            gaikaKokyakuTuutiTy.setZtytmtthaitoukinzndkyen("2198683");

            gaikaKokyakuTuutiTy.setZtynkshrstartymdstr("９９９９年１２月３１日");
            gaikaKokyakuTuutiTy.setZtynenkinstartnen("99");
            gaikaKokyakuTuutiTy.setZtynksyuruinm("確定年金");
            gaikaKokyakuTuutiTy.setZtykijyunkingakukyktuuka("2000000");
            gaikaKokyakuTuutiTy.setZtymkhgkwari("100");
            gaikaKokyakuTuutiTy.setZtysisuunm("ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）");
            gaikaKokyakuTuutiTy.setZtyhrkkaisuu("1");
            gaikaKokyakuTuutiTy.setZtytikiktbrisyuruikbn("0");
            gaikaKokyakuTuutiTy.setZtyzennouumu("1");
            gaikaKokyakuTuutiTy.setZtyhrkkeiro("1");
            gaikaKokyakuTuutiTy.setZtyphrkkkn("59");
            gaikaKokyakuTuutiTy.setZtyyenhrkgkiktnkgk("119640");
            gaikaKokyakuTuutiTy.setZtyzennoutikiktyenhrkgkkykj("1193169");
            gaikaKokyakuTuutiTy.setZtykaiyakusiharaigk("4653436");
            gaikaKokyakuTuutiTy.setZtykaiyakusiharaigkznnuzndk("1073904");
            gaikaKokyakuTuutiTy.setZtynkgnsyensyourai("110389697");
            gaikaKokyakuTuutiTy.setZtynkgnsgaikasyourai("89842676");
            gaikaKokyakuTuutiTy.setZtyytirrtitrnhskmsgcd5("05044");
            gaikaKokyakuTuutiTy.setZtyyendthnkymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(20201101)));
            gaikaKokyakuTuutiTy.setZtyyendthnkhrkngakyen("949632");
            gaikaKokyakuTuutiTy.setZtytmtthaitoukinzndkyen("300007");
            gaikaKokyakuTuutiTy.setZtygengkumu("1");

            if (TESTPATTERN1.equals(SYORIPTN)) {

                gaikaKokyakuTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd1("08012");
                gaikaKokyakuTuutiTy.setZtyaisatumsgcd1("03004");
                gaikaKokyakuTuutiTy.setZtykyktuukatype("USD");
                gaikaKokyakuTuutiTy.setZtydstourokujyou("0");

                gaikaKokyakuTuutiTy.setZtyuktmidasikbn1("02");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn2("05");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn3("01");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn4("01");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn5("01");
                gaikaKokyakuTuutiTy.setZtyuktkbn1("02");
                gaikaKokyakuTuutiTy.setZtyuktkbn2("03");
                gaikaKokyakuTuutiTy.setZtyuktkbn3("04");
                gaikaKokyakuTuutiTy.setZtyuktkbn4("05");
                gaikaKokyakuTuutiTy.setZtyuktkbn5("06");
                gaikaKokyakuTuutiTy.setZtyuktnm118("受取人名１");
                gaikaKokyakuTuutiTy.setZtyuktnm218("受取人名２");
                gaikaKokyakuTuutiTy.setZtyuktnm318("受取人名３");
                gaikaKokyakuTuutiTy.setZtyuktnm418("受取人名４");
                gaikaKokyakuTuutiTy.setZtyuktnm518("受取人名５");

                gaikaKokyakuTuutiTy.setZtytk1msgcd("04001");
                gaikaKokyakuTuutiTy.setZtytk2msgcd("04012");
                gaikaKokyakuTuutiTy.setZtytk3msgcd("04009");
                gaikaKokyakuTuutiTy.setZtytk4msgcd("04002");
                gaikaKokyakuTuutiTy.setZtytk5msgcd("04004");
                gaikaKokyakuTuutiTy.setZtytk6msgcd("04005");

                gaikaKokyakuTuutiTy.setZtytrkkzknm118("登録家族名１（１８桁）");
                gaikaKokyakuTuutiTy.setZtytrkkzknm218("登録家族名２（１８桁）");
                gaikaKokyakuTuutiTy.setZtykzktrkjk("0");

                gaikaKokyakuTuutiTy.setZtysbhknkngkhknkkn(C_HknKknKbn.DAI1HKNKKN.getValue());
                gaikaKokyakuTuutiTy.setZtykijyunkingaku("10000");
                gaikaKokyakuTuutiTy.setZtysbhknkngkyen("9999");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakukyen("10001");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakuumu("2");

                gaikaKokyakuTuutiTy.setZtysetteibairitustr("300");
                gaikaKokyakuTuutiTy.setZtytmttknzkrtjygnstr("40000");
                gaikaKokyakuTuutiTy.setZtytumitateriritustr("500");

                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx1("1");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx2("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx3("4");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx4("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx5("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx6("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx7("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx8("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx9("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx10("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx11("3");

                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix1("2017年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix2("2018年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix3("2019年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix4("2020年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix5("2021年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix6("2022年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix7("2023年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix8("2024年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix9("2025年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix10("2026年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix11("2027年11月07日");

                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix1("1");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix2("2");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix3("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix4("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix5("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix6("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix7("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix8("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix9("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix10("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix11("3");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax1("20001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax2("20002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax3("20003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax4("20004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax5("20005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax6("20006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax7("20007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax8("20008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax9("20009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax10("20010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax11("20011");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx1("30001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx2("30002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx3("30003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx4("30004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx5("30005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx6("30006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx7("30007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx8("30008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx9("30009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx10("30010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx11("30011");

                gaikaKokyakuTuutiTy.setZtysisuux1("100");
                gaikaKokyakuTuutiTy.setZtysisuux2("200");
                gaikaKokyakuTuutiTy.setZtysisuux3("300");
                gaikaKokyakuTuutiTy.setZtysisuux4("400");
                gaikaKokyakuTuutiTy.setZtysisuux5("500");
                gaikaKokyakuTuutiTy.setZtysisuux6("600");
                gaikaKokyakuTuutiTy.setZtysisuux7("700");
                gaikaKokyakuTuutiTy.setZtysisuux8("800");
                gaikaKokyakuTuutiTy.setZtysisuux9("900");
                gaikaKokyakuTuutiTy.setZtysisuux10("110");
                gaikaKokyakuTuutiTy.setZtysisuux11("120");

                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux1("1");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux2("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux3("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux4("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux5("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux6("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux7("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux8("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux9("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux10("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux11("0");

                gaikaKokyakuTuutiTy.setZtysisuuupritux1("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux2("2000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux3("3000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux4("4000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux5("5000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux6("6000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux7("7000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux8("8000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux9("9000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux10("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux11("1000");

                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx1("3100");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx2("3200");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx3("3300");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx4("3400");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx5("3500");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx6("3600");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx7("3700");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx8("3800");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx9("3900");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx10("3110");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx11("3120");

                gaikaKokyakuTuutiTy.setZtykawaseratex1("11939");
                gaikaKokyakuTuutiTy.setZtykawaseratex2("12939");
                gaikaKokyakuTuutiTy.setZtykawaseratex3("13939");
                gaikaKokyakuTuutiTy.setZtykawaseratex4("14939");
                gaikaKokyakuTuutiTy.setZtykawaseratex5("15939");
                gaikaKokyakuTuutiTy.setZtykawaseratex6("16939");
                gaikaKokyakuTuutiTy.setZtykawaseratex7("17939");
                gaikaKokyakuTuutiTy.setZtykawaseratex8("18939");
                gaikaKokyakuTuutiTy.setZtykawaseratex9("19939");
                gaikaKokyakuTuutiTy.setZtykawaseratex10("22939");
                gaikaKokyakuTuutiTy.setZtykawaseratex11("21939");

                gaikaKokyakuTuutiTy.setZtysueokikkn("1");
                gaikaKokyakuTuutiTy.setZtykaiyakusiharaigksntshrgk("49750");

                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukei("1193166");
                gaikaKokyakuTuutiTy.setZtyhrritu("98");
                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukeisyourai("1193168");
                gaikaKokyakuTuutiTy.setZtyhrritusyourai("100");

                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym1("2019年11月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym2("2019年10月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym3("2019年9月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym4("2019年8月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym5("2019年7月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym6("2019年6月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym7("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym8("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym9("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym10("2019年4月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym11("2019年3月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym12("2019年2月");

                gaikaKokyakuTuutiTy.setZtyyoteiriritu1("371");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu2("372");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu3("376");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu4("370");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu5("367");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu6("380");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu7("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu8("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu9("410");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu10("420");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu11("430");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu12("440");

                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt1("370");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt2("350");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt3("400");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt4("380");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt5("340");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt6("372");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt7("373");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt8("374");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt9("375");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt10("376");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt11("377");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt12("378");

                gaikaKokyakuTuutiTy.setZtykwsratekijyunym1("2018年10月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym2("2018年9月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym3("2018年8月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym4("2018年7月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym5("2018年6月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym6("2018年5月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym7("2018年4月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym8("2018年3月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym9("2018年2月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym10("2018年1月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym11("2018年11月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym12("2018年12月");

                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate1("12335");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate2("12297");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate3("12255");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate4("12211");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate5("12171");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate6("12107");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate7("16100");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate8("16200");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate9("16300");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate10("16400");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate11("16500");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate12("16600");

                gaikaKokyakuTuutiTy.setZtypgaika1("8108");
                gaikaKokyakuTuutiTy.setZtypgaika2("8133");
                gaikaKokyakuTuutiTy.setZtypgaika3("8160");
                gaikaKokyakuTuutiTy.setZtypgaika4("8190");
                gaikaKokyakuTuutiTy.setZtypgaika5("8217");
                gaikaKokyakuTuutiTy.setZtypgaika6("8260");
                gaikaKokyakuTuutiTy.setZtypgaika7("6212");
                gaikaKokyakuTuutiTy.setZtypgaika8("6213");
                gaikaKokyakuTuutiTy.setZtypgaika9("6214");
                gaikaKokyakuTuutiTy.setZtypgaika10("6215");
                gaikaKokyakuTuutiTy.setZtypgaika11("6216");
                gaikaKokyakuTuutiTy.setZtypgaika12("6217");

                gaikaKokyakuTuutiTy.setZtypyen1("41000");
                gaikaKokyakuTuutiTy.setZtypyen2("42000");
                gaikaKokyakuTuutiTy.setZtypyen3("43000");
                gaikaKokyakuTuutiTy.setZtypyen4("44000");
                gaikaKokyakuTuutiTy.setZtypyen5("45000");
                gaikaKokyakuTuutiTy.setZtypyen6("46000");
                gaikaKokyakuTuutiTy.setZtypyen7("47000");
                gaikaKokyakuTuutiTy.setZtypyen8("48000");
                gaikaKokyakuTuutiTy.setZtypyen9("49000");
                gaikaKokyakuTuutiTy.setZtypyen10("51000");
                gaikaKokyakuTuutiTy.setZtypyen11("52000");
                gaikaKokyakuTuutiTy.setZtypyen12("53000");

                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn1("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn2("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn3("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn4("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn5("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn6("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn7("1");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn8("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn9("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn10("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn11("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn12("");

                return gaikaKokyakuTuutiTy;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return gaikaKokyakuTuutiTy;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                gaikaKokyakuTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd1("08012");
                gaikaKokyakuTuutiTy.setZtyaisatumsgcd1("03004");
                gaikaKokyakuTuutiTy.setZtykyktuukatype("USD");
                gaikaKokyakuTuutiTy.setZtydstourokujyou("1");

                gaikaKokyakuTuutiTy.setZtyuktmidasikbn1("03");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn2("03");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn3("06");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn4("06");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn5("04");
                gaikaKokyakuTuutiTy.setZtyuktkbn1("03");
                gaikaKokyakuTuutiTy.setZtyuktkbn2("02");
                gaikaKokyakuTuutiTy.setZtyuktkbn3("06");
                gaikaKokyakuTuutiTy.setZtyuktkbn4("05");
                gaikaKokyakuTuutiTy.setZtyuktkbn5("06");
                gaikaKokyakuTuutiTy.setZtyuktnm118("受取人名１");
                gaikaKokyakuTuutiTy.setZtyuktnm218("受取人名２");
                gaikaKokyakuTuutiTy.setZtyuktnm318("受取人名３");
                gaikaKokyakuTuutiTy.setZtyuktnm418("受取人名４");
                gaikaKokyakuTuutiTy.setZtyuktnm518("受取人名５");

                gaikaKokyakuTuutiTy.setZtytk1msgcd("04006");
                gaikaKokyakuTuutiTy.setZtytk2msgcd("04011");
                gaikaKokyakuTuutiTy.setZtytk3msgcd("04007");
                gaikaKokyakuTuutiTy.setZtytk4msgcd("04008");
                gaikaKokyakuTuutiTy.setZtytk5msgcd("04010");
                gaikaKokyakuTuutiTy.setZtytk6msgcd("04013");

                gaikaKokyakuTuutiTy.setZtytrkkzknm118("登録家族名１（１８桁）");
                gaikaKokyakuTuutiTy.setZtytrkkzknm218(null);
                gaikaKokyakuTuutiTy.setZtykzktrkjk("1");

                gaikaKokyakuTuutiTy.setZtysbhknkngkhknkkn(C_HknKknKbn.DAI1HKNKKN.getValue());

                gaikaKokyakuTuutiTy.setZtykijyunkingaku("10000");
                gaikaKokyakuTuutiTy.setZtysbhknkngkyen("10001");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakukyen("9999");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakuumu("1");

                gaikaKokyakuTuutiTy.setZtysetteibairitustr("");
                gaikaKokyakuTuutiTy.setZtytmttknzkrtjygnstr(null);
                gaikaKokyakuTuutiTy.setZtytumitateriritustr("500");

                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx1("1");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx2("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx3("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx4("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx5("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx6("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx7("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx8("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx9("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx10("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx11("3");

                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix1("2017年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix2("2018年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix3("2019年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix4("2020年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix5("2021年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix6("2022年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix7("2023年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix8("2024年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix9("2025年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix10("2026年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix11("2027年11月07日");

                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix1("4");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix2("2");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix3("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix4("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix5("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix6("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix7("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix8("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix9("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix10("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix11("3");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax1("20001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax2("20002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax3("20003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax4("20004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax5("20005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax6("20006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax7("20007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax8("20008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax9("20009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax10("20010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax11("20011");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx1("30001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx2("30002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx3("30003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx4("30004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx5("30005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx6("30006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx7("30007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx8("30008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx9("30009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx10("30010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx11("30011");

                gaikaKokyakuTuutiTy.setZtysisuux1("100");
                gaikaKokyakuTuutiTy.setZtysisuux2("200");
                gaikaKokyakuTuutiTy.setZtysisuux3("300");
                gaikaKokyakuTuutiTy.setZtysisuux4("400");
                gaikaKokyakuTuutiTy.setZtysisuux5("500");
                gaikaKokyakuTuutiTy.setZtysisuux6("600");
                gaikaKokyakuTuutiTy.setZtysisuux7("700");
                gaikaKokyakuTuutiTy.setZtysisuux8("800");
                gaikaKokyakuTuutiTy.setZtysisuux9("900");
                gaikaKokyakuTuutiTy.setZtysisuux10("110");
                gaikaKokyakuTuutiTy.setZtysisuux11("120");

                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux1("1");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux2("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux3("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux4("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux5("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux6("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux7("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux8("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux9("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux10("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux11("0");

                gaikaKokyakuTuutiTy.setZtysisuuupritux1("");
                gaikaKokyakuTuutiTy.setZtysisuuupritux2("2000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux3("3000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux4("4000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux5("5000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux6("6000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux7("7000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux8("8000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux9("9000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux10("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux11("1000");

                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx1("3100");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx2("3200");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx3("3300");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx4("3400");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx5("3500");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx6("3600");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx7("3700");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx8("3800");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx9("3900");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx10("3110");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx11("3120");

                gaikaKokyakuTuutiTy.setZtykawaseratex1("11939");
                gaikaKokyakuTuutiTy.setZtykawaseratex2("12939");
                gaikaKokyakuTuutiTy.setZtykawaseratex3("13939");
                gaikaKokyakuTuutiTy.setZtykawaseratex4("14939");
                gaikaKokyakuTuutiTy.setZtykawaseratex5("15939");
                gaikaKokyakuTuutiTy.setZtykawaseratex6("16939");
                gaikaKokyakuTuutiTy.setZtykawaseratex7("17939");
                gaikaKokyakuTuutiTy.setZtykawaseratex8("18939");
                gaikaKokyakuTuutiTy.setZtykawaseratex9("19939");
                gaikaKokyakuTuutiTy.setZtykawaseratex10("22939");
                gaikaKokyakuTuutiTy.setZtykawaseratex11("21939");

                gaikaKokyakuTuutiTy.setZtysueokikkn("0");
                gaikaKokyakuTuutiTy.setZtykaiyakusiharaigksntshrgk("0");

                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukei("0");
                gaikaKokyakuTuutiTy.setZtyhrritu("0");
                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukeisyourai("0");
                gaikaKokyakuTuutiTy.setZtyhrritusyourai("0");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym1("2019年11月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym2("2019年10月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym3("2019年9月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym4("2019年8月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym5("2019年7月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym6("2019年6月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym7("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym8("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym9("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym10("2019年4月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym11("2019年3月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym12("2019年2月");

                gaikaKokyakuTuutiTy.setZtyyoteiriritu1("371");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu2("372");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu3("376");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu4("370");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu5("367");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu6("380");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu7("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu8("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu9("410");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu10("420");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu11("430");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu12("440");

                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt1("370");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt2("350");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt3("400");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt4("380");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt5("340");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt6("372");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt7("373");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt8("374");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt9("375");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt10("376");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt11("377");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt12("378");

                gaikaKokyakuTuutiTy.setZtykwsratekijyunym1("2018年10月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym2("2018年9月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym3("2018年8月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym4("2018年7月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym5("2018年6月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym6("2018年5月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym7("2018年4月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym8("2018年3月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym9("2018年2月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym10("2018年1月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym11("2018年11月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym12("2018年12月");

                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate1("12335");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate2("12297");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate3("12255");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate4("12211");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate5("12171");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate6("12107");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate7("16100");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate8("16200");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate9("16300");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate10("16400");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate11("16500");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate12("16600");

                gaikaKokyakuTuutiTy.setZtypgaika1("8108");
                gaikaKokyakuTuutiTy.setZtypgaika2("8133");
                gaikaKokyakuTuutiTy.setZtypgaika3("8160");
                gaikaKokyakuTuutiTy.setZtypgaika4("8190");
                gaikaKokyakuTuutiTy.setZtypgaika5("8217");
                gaikaKokyakuTuutiTy.setZtypgaika6("8260");
                gaikaKokyakuTuutiTy.setZtypgaika7("6212");
                gaikaKokyakuTuutiTy.setZtypgaika8("6213");
                gaikaKokyakuTuutiTy.setZtypgaika9("6214");
                gaikaKokyakuTuutiTy.setZtypgaika10("6215");
                gaikaKokyakuTuutiTy.setZtypgaika11("6216");
                gaikaKokyakuTuutiTy.setZtypgaika12("");

                gaikaKokyakuTuutiTy.setZtypyen1("41000");
                gaikaKokyakuTuutiTy.setZtypyen2("42000");
                gaikaKokyakuTuutiTy.setZtypyen3("43000");
                gaikaKokyakuTuutiTy.setZtypyen4("44000");
                gaikaKokyakuTuutiTy.setZtypyen5("45000");
                gaikaKokyakuTuutiTy.setZtypyen6("46000");
                gaikaKokyakuTuutiTy.setZtypyen7("47000");
                gaikaKokyakuTuutiTy.setZtypyen8("48000");
                gaikaKokyakuTuutiTy.setZtypyen9("49000");
                gaikaKokyakuTuutiTy.setZtypyen10("51000");
                gaikaKokyakuTuutiTy.setZtypyen11("52000");
                gaikaKokyakuTuutiTy.setZtypyen12("");

                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn1("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn2("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn3("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn4("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn5("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn6("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn7("1");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn8("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn9("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn10("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn11("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn12("");
                return gaikaKokyakuTuutiTy;

            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                gaikaKokyakuTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd1("08012");
                gaikaKokyakuTuutiTy.setZtyaisatumsgcd1("03004");
                gaikaKokyakuTuutiTy.setZtykyktuukatype("USD");
                gaikaKokyakuTuutiTy.setZtydstourokujyou("3");

                gaikaKokyakuTuutiTy.setZtyuktmidasikbn1("03");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn2("");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn3("");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn4("");
                gaikaKokyakuTuutiTy.setZtyuktmidasikbn5("");
                gaikaKokyakuTuutiTy.setZtyuktkbn1("02");
                gaikaKokyakuTuutiTy.setZtyuktkbn2("03");
                gaikaKokyakuTuutiTy.setZtyuktkbn3("04");
                gaikaKokyakuTuutiTy.setZtyuktkbn4("05");
                gaikaKokyakuTuutiTy.setZtyuktkbn5("06");
                gaikaKokyakuTuutiTy.setZtyuktnm118("受取人名１");
                gaikaKokyakuTuutiTy.setZtyuktnm218("受取人名２");
                gaikaKokyakuTuutiTy.setZtyuktnm318("受取人名３");
                gaikaKokyakuTuutiTy.setZtyuktnm418("受取人名４");
                gaikaKokyakuTuutiTy.setZtyuktnm518("受取人名５");

                gaikaKokyakuTuutiTy.setZtytk1msgcd("04001");
                gaikaKokyakuTuutiTy.setZtytk2msgcd("04012");
                gaikaKokyakuTuutiTy.setZtytk3msgcd("04009");
                gaikaKokyakuTuutiTy.setZtytk4msgcd("04002");
                gaikaKokyakuTuutiTy.setZtytk5msgcd("04004");
                gaikaKokyakuTuutiTy.setZtytk6msgcd("04005");

                gaikaKokyakuTuutiTy.setZtytrkkzknm118("登録家族名１（１８桁）");
                gaikaKokyakuTuutiTy.setZtytrkkzknm218("");
                gaikaKokyakuTuutiTy.setZtykzktrkjk("1");

                gaikaKokyakuTuutiTy.setZtysbhknkngkhknkkn(C_HknKknKbn.DAI2HKNKKN.getValue());

                gaikaKokyakuTuutiTy.setZtykijyunkingaku("10000");
                gaikaKokyakuTuutiTy.setZtysbhknkngkyen("10000");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakukyen("10000");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakuumu("2");

                gaikaKokyakuTuutiTy.setZtysetteibairitustr("300");
                gaikaKokyakuTuutiTy.setZtytmttknzkrtjygnstr("40000");
                gaikaKokyakuTuutiTy.setZtytumitateriritustr("500");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx1("1");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx2("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx3("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx4("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx5("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx6("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx7("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx8("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx9("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx10("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx11("");

                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix1("1");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix2("2");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix3("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix4("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix5("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix6("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix7("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix8("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix9("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix10("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix11("3");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax1("20001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax2("20002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax3("20003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax4("20004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax5("20005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax6("20006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax7("20007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax8("20008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax9("20009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax10("20010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax11("20011");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx1("30001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx2("30002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx3("30003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx4("30004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx5("30005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx6("30006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx7("30007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx8("30008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx9("30009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx10("30010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx11("30011");

                gaikaKokyakuTuutiTy.setZtysisuux1("100");
                gaikaKokyakuTuutiTy.setZtysisuux2("200");
                gaikaKokyakuTuutiTy.setZtysisuux3("300");
                gaikaKokyakuTuutiTy.setZtysisuux4("400");
                gaikaKokyakuTuutiTy.setZtysisuux5("500");
                gaikaKokyakuTuutiTy.setZtysisuux6("600");
                gaikaKokyakuTuutiTy.setZtysisuux7("700");
                gaikaKokyakuTuutiTy.setZtysisuux8("800");
                gaikaKokyakuTuutiTy.setZtysisuux9("900");
                gaikaKokyakuTuutiTy.setZtysisuux10("110");
                gaikaKokyakuTuutiTy.setZtysisuux11("120");

                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux1("1");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux2("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux3("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux4("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux5("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux6("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux7("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux8("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux9("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux10("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux11("0");

                gaikaKokyakuTuutiTy.setZtysisuuupritux1("");
                gaikaKokyakuTuutiTy.setZtysisuuupritux2("2000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux3("3000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux4("4000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux5("5000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux6("6000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux7("7000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux8("8000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux9("9000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux10("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux11("1000");

                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx1("3100");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx2("3200");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx3("3300");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx4("3400");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx5("3500");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx6("3600");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx7("3700");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx8("3800");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx9("3900");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx10("3110");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx11("3120");

                gaikaKokyakuTuutiTy.setZtykawaseratex1("11939");
                gaikaKokyakuTuutiTy.setZtykawaseratex2("12939");
                gaikaKokyakuTuutiTy.setZtykawaseratex3("13939");
                gaikaKokyakuTuutiTy.setZtykawaseratex4("14939");
                gaikaKokyakuTuutiTy.setZtykawaseratex5("15939");
                gaikaKokyakuTuutiTy.setZtykawaseratex6("16939");
                gaikaKokyakuTuutiTy.setZtykawaseratex7("17939");
                gaikaKokyakuTuutiTy.setZtykawaseratex8("18939");
                gaikaKokyakuTuutiTy.setZtykawaseratex9("19939");
                gaikaKokyakuTuutiTy.setZtykawaseratex10("22939");
                gaikaKokyakuTuutiTy.setZtykawaseratex11("21939");

                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix1("2017年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix2("2018年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix3("2019年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix4("2020年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix5("2021年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix6("2022年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix7("2023年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix8("");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix9("2025年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix10("2026年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix11("2027年11月07日");

                gaikaKokyakuTuutiTy.setZtysueokikkn("0");
                gaikaKokyakuTuutiTy.setZtykaiyakusiharaigksntshrgk("0");

                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukei("0");
                gaikaKokyakuTuutiTy.setZtyhrritu("0");
                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukeisyourai("0");
                gaikaKokyakuTuutiTy.setZtyhrritusyourai("0");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym1("2019年11月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym2("2019年10月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym3("2019年9月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym4("2019年8月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym5("2019年7月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym6("2019年6月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym7("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym8("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym9("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym10("2019年4月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym11("2019年3月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym12("2019年2月");

                gaikaKokyakuTuutiTy.setZtyyoteiriritu1("371");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu2("372");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu3("376");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu4("370");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu5("367");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu6("380");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu7("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu8("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu9("410");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu10("420");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu11("430");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu12("440");

                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt1("370");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt2("350");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt3("400");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt4("380");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt5("340");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt6("372");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt7("373");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt8("374");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt9("375");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt10("376");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt11("377");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt12("378");

                gaikaKokyakuTuutiTy.setZtykwsratekijyunym1("2018年10月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym2("2018年9月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym3("2018年8月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym4("2018年7月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym5("2018年6月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym6("2018年5月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym7("2018年4月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym8("2018年3月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym9("2018年2月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym10("2018年1月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym11("2018年11月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym12("2018年12月");

                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate1("12335");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate2("12297");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate3("12255");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate4("12211");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate5("12171");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate6("12107");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate7("16100");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate8("16200");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate9("16300");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate10("16400");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate11("16500");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate12("16600");

                gaikaKokyakuTuutiTy.setZtypgaika1("8108");
                gaikaKokyakuTuutiTy.setZtypgaika2("8133");
                gaikaKokyakuTuutiTy.setZtypgaika3("8160");
                gaikaKokyakuTuutiTy.setZtypgaika4("8190");
                gaikaKokyakuTuutiTy.setZtypgaika5("8217");
                gaikaKokyakuTuutiTy.setZtypgaika6("8260");
                gaikaKokyakuTuutiTy.setZtypgaika7("6212");
                gaikaKokyakuTuutiTy.setZtypgaika8("6213");
                gaikaKokyakuTuutiTy.setZtypgaika9("6214");
                gaikaKokyakuTuutiTy.setZtypgaika10("6215");
                gaikaKokyakuTuutiTy.setZtypgaika11("6216");
                gaikaKokyakuTuutiTy.setZtypgaika12("6217");

                gaikaKokyakuTuutiTy.setZtypyen1("41000");
                gaikaKokyakuTuutiTy.setZtypyen2("42000");
                gaikaKokyakuTuutiTy.setZtypyen3("43000");
                gaikaKokyakuTuutiTy.setZtypyen4("44000");
                gaikaKokyakuTuutiTy.setZtypyen5("45000");
                gaikaKokyakuTuutiTy.setZtypyen6("46000");
                gaikaKokyakuTuutiTy.setZtypyen7("47000");
                gaikaKokyakuTuutiTy.setZtypyen8("48000");
                gaikaKokyakuTuutiTy.setZtypyen9("49000");
                gaikaKokyakuTuutiTy.setZtypyen10("51000");
                gaikaKokyakuTuutiTy.setZtypyen11("52000");
                gaikaKokyakuTuutiTy.setZtypyen12("53000");

                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn1("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn2("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn3("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn4("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn5("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn6("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn7("1");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn8("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn9("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn10("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn11("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn12("");

                return gaikaKokyakuTuutiTy;

            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                gaikaKokyakuTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd1("08012");
                gaikaKokyakuTuutiTy.setZtyaisatumsgcd1("03004");
                gaikaKokyakuTuutiTy.setZtykyktuukatype("USD");
                gaikaKokyakuTuutiTy.setZtydstourokujyou("4");

                gaikaKokyakuTuutiTy.setZtyuktmidasikbn1("04");
                gaikaKokyakuTuutiTy.setZtyuktkbn1("02");
                gaikaKokyakuTuutiTy.setZtyuktkbn2("03");
                gaikaKokyakuTuutiTy.setZtyuktkbn3("04");
                gaikaKokyakuTuutiTy.setZtyuktkbn4("05");
                gaikaKokyakuTuutiTy.setZtyuktkbn5("06");
                gaikaKokyakuTuutiTy.setZtyuktnm118("受取人名１");
                gaikaKokyakuTuutiTy.setZtyuktnm218("受取人名２");
                gaikaKokyakuTuutiTy.setZtyuktnm318("受取人名３");
                gaikaKokyakuTuutiTy.setZtyuktnm418("受取人名４");
                gaikaKokyakuTuutiTy.setZtyuktnm518("受取人名５");

                gaikaKokyakuTuutiTy.setZtytk1msgcd("04001");
                gaikaKokyakuTuutiTy.setZtytk2msgcd("04012");
                gaikaKokyakuTuutiTy.setZtytk3msgcd("04009");
                gaikaKokyakuTuutiTy.setZtytk4msgcd("04002");
                gaikaKokyakuTuutiTy.setZtytk5msgcd("04004");
                gaikaKokyakuTuutiTy.setZtytk6msgcd("04005");

                gaikaKokyakuTuutiTy.setZtytrkkzknm118("登録家族名１（１８桁）");
                gaikaKokyakuTuutiTy.setZtytrkkzknm218("登録家族名２（１８桁）");
                gaikaKokyakuTuutiTy.setZtykzktrkjk("1");

                gaikaKokyakuTuutiTy.setZtysbhknkngkhknkkn(C_HknKknKbn.DAI2HKNKKN.getValue());

                gaikaKokyakuTuutiTy.setZtykijyunkingaku("10000");
                gaikaKokyakuTuutiTy.setZtysbhknkngkyen("10001");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakukyen("9999");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakuumu("2");

                gaikaKokyakuTuutiTy.setZtysetteibairitustr("300");
                gaikaKokyakuTuutiTy.setZtytmttknzkrtjygnstr("40000");
                gaikaKokyakuTuutiTy.setZtytumitateriritustr("500");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx1("1");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx2("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx3("4");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx4("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx5("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx6("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx7("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx8("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx9("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx10("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx11("3");

                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix1("1");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix2("2");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix3("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix4("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix5("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix6("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix7("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix8("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix9("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix10("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix11("3");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax1("20001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax2("20002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax3("20003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax4("20004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax5("20005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax6("20006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax7("20007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax8("20008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax9("20009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax10("20010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax11("20011");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx1("30001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx2("30002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx3("30003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx4("30004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx5("30005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx6("30006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx7("30007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx8("30008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx9("30009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx10("30010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx11("30011");

                gaikaKokyakuTuutiTy.setZtysisuux1("100");
                gaikaKokyakuTuutiTy.setZtysisuux2("200");
                gaikaKokyakuTuutiTy.setZtysisuux3("300");
                gaikaKokyakuTuutiTy.setZtysisuux4("400");
                gaikaKokyakuTuutiTy.setZtysisuux5("500");
                gaikaKokyakuTuutiTy.setZtysisuux6("600");
                gaikaKokyakuTuutiTy.setZtysisuux7("700");
                gaikaKokyakuTuutiTy.setZtysisuux8("800");
                gaikaKokyakuTuutiTy.setZtysisuux9("900");
                gaikaKokyakuTuutiTy.setZtysisuux10("110");
                gaikaKokyakuTuutiTy.setZtysisuux11("120");

                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux1("1");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux2("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux3("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux4("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux5("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux6("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux7("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux8("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux9("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux10("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux11("0");

                gaikaKokyakuTuutiTy.setZtysisuuupritux1("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux2("2000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux3("3000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux4("4000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux5("5000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux6("6000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux7("7000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux8("8000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux9("9000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux10("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux11("1000");

                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx1("3100");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx2("3200");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx3("3300");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx4("3400");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx5("3500");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx6("3600");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx7("3700");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx8("3800");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx9("3900");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx10("3110");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx11("3120");

                gaikaKokyakuTuutiTy.setZtykawaseratex1("11939");
                gaikaKokyakuTuutiTy.setZtykawaseratex2("12939");
                gaikaKokyakuTuutiTy.setZtykawaseratex3("13939");
                gaikaKokyakuTuutiTy.setZtykawaseratex4("14939");
                gaikaKokyakuTuutiTy.setZtykawaseratex5("15939");
                gaikaKokyakuTuutiTy.setZtykawaseratex6("16939");
                gaikaKokyakuTuutiTy.setZtykawaseratex7("17939");
                gaikaKokyakuTuutiTy.setZtykawaseratex8("18939");
                gaikaKokyakuTuutiTy.setZtykawaseratex9("19939");
                gaikaKokyakuTuutiTy.setZtykawaseratex10("22939");
                gaikaKokyakuTuutiTy.setZtykawaseratex11("21939");

                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix1("2017年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix2("2018年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix3("2019年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix4("2020年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix5("2021年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix6("2022年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix7("2023年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix8("");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix9("2025年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix10("2026年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix11("2027年11月07日");

                gaikaKokyakuTuutiTy.setZtysueokikkn("0");
                gaikaKokyakuTuutiTy.setZtykaiyakusiharaigksntshrgk("0");

                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukei("0");
                gaikaKokyakuTuutiTy.setZtyhrritu("0");
                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukeisyourai("0");
                gaikaKokyakuTuutiTy.setZtyhrritusyourai("0");

                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym1("2019年11月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym2("2019年10月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym3("2019年9月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym4("2019年8月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym5("2019年7月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym6("2019年6月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym7("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym8("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym9("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym10("2019年4月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym11("2019年3月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym12("");

                gaikaKokyakuTuutiTy.setZtyyoteiriritu1("371");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu2("372");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu3("376");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu4("370");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu5("367");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu6("380");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu7("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu8("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu9("410");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu10("420");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu11("430");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu12("440");

                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt1("370");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt2("350");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt3("400");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt4("380");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt5("340");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt6("372");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt7("373");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt8("374");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt9("375");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt10("376");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt11("377");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt12("378");

                gaikaKokyakuTuutiTy.setZtykwsratekijyunym1("2018年10月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym2("2018年9月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym3("2018年8月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym4("2018年7月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym5("2018年6月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym6("2018年5月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym7("2018年4月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym8("2018年3月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym9("2018年2月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym10("2018年1月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym11("2018年11月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym12("");

                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate1("12335");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate2("12297");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate3("12255");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate4("12211");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate5("12171");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate6("12107");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate7("16100");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate8("16200");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate9("16300");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate10("16400");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate11("16500");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate12("16600");

                gaikaKokyakuTuutiTy.setZtypgaika1("8108");
                gaikaKokyakuTuutiTy.setZtypgaika2("8133");
                gaikaKokyakuTuutiTy.setZtypgaika3("8160");
                gaikaKokyakuTuutiTy.setZtypgaika4("8190");
                gaikaKokyakuTuutiTy.setZtypgaika5("8217");
                gaikaKokyakuTuutiTy.setZtypgaika6("8260");
                gaikaKokyakuTuutiTy.setZtypgaika7("6212");
                gaikaKokyakuTuutiTy.setZtypgaika8("6213");
                gaikaKokyakuTuutiTy.setZtypgaika9("6214");
                gaikaKokyakuTuutiTy.setZtypgaika10("6215");
                gaikaKokyakuTuutiTy.setZtypgaika11("6216");
                gaikaKokyakuTuutiTy.setZtypgaika12("6217");

                gaikaKokyakuTuutiTy.setZtypyen1("41000");
                gaikaKokyakuTuutiTy.setZtypyen2("42000");
                gaikaKokyakuTuutiTy.setZtypyen3("43000");
                gaikaKokyakuTuutiTy.setZtypyen4("44000");
                gaikaKokyakuTuutiTy.setZtypyen5("45000");
                gaikaKokyakuTuutiTy.setZtypyen6("46000");
                gaikaKokyakuTuutiTy.setZtypyen7("47000");
                gaikaKokyakuTuutiTy.setZtypyen8("48000");
                gaikaKokyakuTuutiTy.setZtypyen9("49000");
                gaikaKokyakuTuutiTy.setZtypyen10("51000");
                gaikaKokyakuTuutiTy.setZtypyen11("52000");
                gaikaKokyakuTuutiTy.setZtypyen12("53000");

                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn1("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn2("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn3("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn4("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn5("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn6("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn7("1");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn8("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn9("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn10("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn11("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn12("");

                return gaikaKokyakuTuutiTy;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                gaikaKokyakuTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd1("08012");
                gaikaKokyakuTuutiTy.setZtyaisatumsgcd1("03004");
                gaikaKokyakuTuutiTy.setZtykyktuukatype("USD");
                gaikaKokyakuTuutiTy.setZtydstourokujyou("5");

                gaikaKokyakuTuutiTy.setZtyuktkbn1("02");
                gaikaKokyakuTuutiTy.setZtyuktkbn2("03");
                gaikaKokyakuTuutiTy.setZtyuktkbn3("04");
                gaikaKokyakuTuutiTy.setZtyuktkbn4("05");
                gaikaKokyakuTuutiTy.setZtyuktkbn5("06");
                gaikaKokyakuTuutiTy.setZtyuktnm118("受取人名１");
                gaikaKokyakuTuutiTy.setZtyuktnm218("受取人名２");
                gaikaKokyakuTuutiTy.setZtyuktnm318("受取人名３");
                gaikaKokyakuTuutiTy.setZtyuktnm418("受取人名４");
                gaikaKokyakuTuutiTy.setZtyuktnm518("受取人名５");

                gaikaKokyakuTuutiTy.setZtytk1msgcd("04001");
                gaikaKokyakuTuutiTy.setZtytk2msgcd("04012");
                gaikaKokyakuTuutiTy.setZtytk3msgcd("04009");
                gaikaKokyakuTuutiTy.setZtytk4msgcd("04002");
                gaikaKokyakuTuutiTy.setZtytk5msgcd("04004");
                gaikaKokyakuTuutiTy.setZtytk6msgcd("04005");

                gaikaKokyakuTuutiTy.setZtytrkkzknm118("登録家族名１（１８桁）");
                gaikaKokyakuTuutiTy.setZtytrkkzknm218("登録家族名２（１８桁）");
                gaikaKokyakuTuutiTy.setZtykzktrkjk("2");

                gaikaKokyakuTuutiTy.setZtysbhknkngkhknkkn(C_HknKknKbn.DAI2HKNKKN.getValue());

                gaikaKokyakuTuutiTy.setZtykijyunkingaku("10000");
                gaikaKokyakuTuutiTy.setZtysbhknkngkyen("10000");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakukyen("10000");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakuumu("2");

                gaikaKokyakuTuutiTy.setZtysetteibairitustr("300");
                gaikaKokyakuTuutiTy.setZtytmttknzkrtjygnstr("40000");
                gaikaKokyakuTuutiTy.setZtytumitateriritustr("500");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx1("1");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx2("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx3("4");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx4("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx5("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx6("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx7("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx8("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx9("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx10("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx11("3");

                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix1("1");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix2("2");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix3("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix4("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix5("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix6("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix7("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix8("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix9("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix10("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix11("3");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax1("20001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax2("20002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax3("20003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax4("20004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax5("20005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax6("20006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax7("20007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax8("20008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax9("20009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax10("20010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax11("20011");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx1("30001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx2("30002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx3("30003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx4("30004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx5("30005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx6("30006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx7("30007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx8("30008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx9("30009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx10("30010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx11("30011");

                gaikaKokyakuTuutiTy.setZtysisuux1("100");
                gaikaKokyakuTuutiTy.setZtysisuux2("200");
                gaikaKokyakuTuutiTy.setZtysisuux3("300");
                gaikaKokyakuTuutiTy.setZtysisuux4("400");
                gaikaKokyakuTuutiTy.setZtysisuux5("500");
                gaikaKokyakuTuutiTy.setZtysisuux6("600");
                gaikaKokyakuTuutiTy.setZtysisuux7("700");
                gaikaKokyakuTuutiTy.setZtysisuux8("800");
                gaikaKokyakuTuutiTy.setZtysisuux9("900");
                gaikaKokyakuTuutiTy.setZtysisuux10("110");
                gaikaKokyakuTuutiTy.setZtysisuux11("120");

                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux1("1");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux2("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux3("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux4("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux5("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux6("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux7("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux8("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux9("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux10("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux11("0");

                gaikaKokyakuTuutiTy.setZtysisuuupritux1("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux2("2000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux3("3000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux4("4000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux5("5000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux6("6000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux7("7000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux8("8000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux9("9000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux10("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux11("1000");

                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx1("3100");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx2("3200");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx3("3300");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx4("3400");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx5("3500");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx6("3600");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx7("3700");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx8("3800");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx9("3900");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx10("3110");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx11("3120");

                gaikaKokyakuTuutiTy.setZtykawaseratex1("11939");
                gaikaKokyakuTuutiTy.setZtykawaseratex2("12939");
                gaikaKokyakuTuutiTy.setZtykawaseratex3("13939");
                gaikaKokyakuTuutiTy.setZtykawaseratex4("14939");
                gaikaKokyakuTuutiTy.setZtykawaseratex5("15939");
                gaikaKokyakuTuutiTy.setZtykawaseratex6("16939");
                gaikaKokyakuTuutiTy.setZtykawaseratex7("17939");
                gaikaKokyakuTuutiTy.setZtykawaseratex8("18939");
                gaikaKokyakuTuutiTy.setZtykawaseratex9("19939");
                gaikaKokyakuTuutiTy.setZtykawaseratex10("22939");
                gaikaKokyakuTuutiTy.setZtykawaseratex11("21939");

                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix1("2017年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix2("2018年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix3("2019年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix4("2020年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix5("2021年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix6("2022年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix7("2023年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix8("2024年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix9("2025年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix10("2026年11月07日");
                gaikaKokyakuTuutiTy.setZtykeiyakuoutoubix11("2027年11月07日");

                gaikaKokyakuTuutiTy.setZtysueokikkn("0");
                gaikaKokyakuTuutiTy.setZtykaiyakusiharaigksntshrgk("0");

                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukei("0");
                gaikaKokyakuTuutiTy.setZtyhrritu("0");
                gaikaKokyakuTuutiTy.setZtyyenhrkgkgoukeisyourai("0");
                gaikaKokyakuTuutiTy.setZtyhrritusyourai("0");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym1("2019年11月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym2("2019年10月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym3("2019年9月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym4("2019年8月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym5("2019年7月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym6("2019年6月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym7("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym8("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym9("2019年5月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym10("2019年4月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym11("2019年3月");
                gaikaKokyakuTuutiTy.setZtyyoteiriritukijyunym12("2019年2月");

                gaikaKokyakuTuutiTy.setZtyyoteiriritu1("371");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu2("372");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu3("376");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu4("370");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu5("367");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu6("380");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu7("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu8("390");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu9("410");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu10("420");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu11("430");
                gaikaKokyakuTuutiTy.setZtyyoteiriritu12("");

                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt1("370");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt2("350");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt3("400");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt4("380");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt5("340");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt6("372");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt7("373");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt8("374");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt9("375");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt10("376");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt11("377");
                gaikaKokyakuTuutiTy.setZtyytirrtcalckijyunrrt12("378");

                gaikaKokyakuTuutiTy.setZtykwsratekijyunym1("2018年10月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym2("2018年9月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym3("2018年8月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym4("2018年7月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym5("2018年6月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym6("2018年5月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym7("2018年4月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym8("2018年3月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym9("2018年2月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym10("2018年1月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym11("2018年11月");
                gaikaKokyakuTuutiTy.setZtykwsratekijyunym12("2018年12月");

                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate1("12335");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate2("12297");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate3("12255");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate4("12211");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate5("12171");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate6("12107");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate7("16100");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate8("16200");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate9("16300");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate10("16400");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate11("16500");
                gaikaKokyakuTuutiTy.setZtykaknsnkwsrate12("16600");

                gaikaKokyakuTuutiTy.setZtypgaika1("8108");
                gaikaKokyakuTuutiTy.setZtypgaika2("8133");
                gaikaKokyakuTuutiTy.setZtypgaika3("8160");
                gaikaKokyakuTuutiTy.setZtypgaika4("8190");
                gaikaKokyakuTuutiTy.setZtypgaika5("8217");
                gaikaKokyakuTuutiTy.setZtypgaika6("8260");
                gaikaKokyakuTuutiTy.setZtypgaika7("6212");
                gaikaKokyakuTuutiTy.setZtypgaika8("6213");
                gaikaKokyakuTuutiTy.setZtypgaika9("6214");
                gaikaKokyakuTuutiTy.setZtypgaika10("6215");
                gaikaKokyakuTuutiTy.setZtypgaika11("6216");
                gaikaKokyakuTuutiTy.setZtypgaika12("6217");

                gaikaKokyakuTuutiTy.setZtypyen1("41000");
                gaikaKokyakuTuutiTy.setZtypyen2("42000");
                gaikaKokyakuTuutiTy.setZtypyen3("43000");
                gaikaKokyakuTuutiTy.setZtypyen4("44000");
                gaikaKokyakuTuutiTy.setZtypyen5("45000");
                gaikaKokyakuTuutiTy.setZtypyen6("46000");
                gaikaKokyakuTuutiTy.setZtypyen7("47000");
                gaikaKokyakuTuutiTy.setZtypyen8("48000");
                gaikaKokyakuTuutiTy.setZtypyen9("49000");
                gaikaKokyakuTuutiTy.setZtypyen10("51000");
                gaikaKokyakuTuutiTy.setZtypyen11("52000");
                gaikaKokyakuTuutiTy.setZtypyen12("53000");

                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn1("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn2("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn3("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn4("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn5("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn6("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn7("1");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn8("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn9("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn10("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn11("");
                gaikaKokyakuTuutiTy.setZtyfstphyoujikbn12("");

                return gaikaKokyakuTuutiTy;
            }

            else if (TESTPATTERN7.equals(SYORIPTN)) {

                gaikaKokyakuTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
                gaikaKokyakuTuutiTy.setZtyosirasemsgcd1("08012");
                gaikaKokyakuTuutiTy.setZtyaisatumsgcd1("03004");
                gaikaKokyakuTuutiTy.setZtykyktuukatype("USD");
                gaikaKokyakuTuutiTy.setZtydstourokujyou("2");
                gaikaKokyakuTuutiTy.setZtystigikwsrate("");

                gaikaKokyakuTuutiTy.setZtyuktkbn1("02");
                gaikaKokyakuTuutiTy.setZtyuktkbn2("03");
                gaikaKokyakuTuutiTy.setZtyuktkbn3("04");
                gaikaKokyakuTuutiTy.setZtyuktkbn4("05");
                gaikaKokyakuTuutiTy.setZtyuktkbn5("06");
                gaikaKokyakuTuutiTy.setZtyuktnm118("受取人名１");
                gaikaKokyakuTuutiTy.setZtyuktnm218("受取人名２");
                gaikaKokyakuTuutiTy.setZtyuktnm318("受取人名３");
                gaikaKokyakuTuutiTy.setZtyuktnm418("受取人名４");
                gaikaKokyakuTuutiTy.setZtyuktnm518("受取人名５");

                gaikaKokyakuTuutiTy.setZtytk1msgcd("04001");
                gaikaKokyakuTuutiTy.setZtytk2msgcd("04012");
                gaikaKokyakuTuutiTy.setZtytk3msgcd("04009");
                gaikaKokyakuTuutiTy.setZtytk4msgcd("04002");
                gaikaKokyakuTuutiTy.setZtytk5msgcd("04004");
                gaikaKokyakuTuutiTy.setZtytk6msgcd("04005");

                gaikaKokyakuTuutiTy.setZtytrkkzknm118("登録家族名１（１８桁）");
                gaikaKokyakuTuutiTy.setZtytrkkzknm218("登録家族名２（１８桁）");
                gaikaKokyakuTuutiTy.setZtykzktrkjk("2");

                gaikaKokyakuTuutiTy.setZtysbhknkngkhknkkn(C_HknKknKbn.DAI2HKNKKN.getValue());

                gaikaKokyakuTuutiTy.setZtykijyunkingaku("10000");
                gaikaKokyakuTuutiTy.setZtysbhknkngkyen("10000");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakukyen("10000");
                gaikaKokyakuTuutiTy.setZtysaigaisbhknkngakuumu("2");

                gaikaKokyakuTuutiTy.setZtysetteibairitustr("300");
                gaikaKokyakuTuutiTy.setZtytmttknzkrtjygnstr("40000");
                gaikaKokyakuTuutiTy.setZtytumitateriritustr("500");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx1("");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx2("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx3("4");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx4("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx5("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx6("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx7("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx8("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx9("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx10("3");
                gaikaKokyakuTuutiTy.setZtytmttknsuiirirekikbnx11("3");

                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix1("1");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix2("2");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix3("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix4("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix5("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix6("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix7("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix8("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix9("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix10("3");
                gaikaKokyakuTuutiTy.setZtytmttknjyoutaix11("3");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax1("20001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax2("20002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax3("20003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax4("20004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax5("20005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax6("20006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax7("20007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax8("20008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax9("20009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax10("20010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkktuukax11("20011");

                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx1("30001");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx2("30002");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx3("30003");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx4("30004");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx5("30005");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx6("30006");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx7("30007");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx8("30008");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx9("30009");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx10("30010");
                gaikaKokyakuTuutiTy.setZtyptumitatekngkyenx11("30011");

                gaikaKokyakuTuutiTy.setZtysisuux1("100");
                gaikaKokyakuTuutiTy.setZtysisuux2("200");
                gaikaKokyakuTuutiTy.setZtysisuux3("300");
                gaikaKokyakuTuutiTy.setZtysisuux4("400");
                gaikaKokyakuTuutiTy.setZtysisuux5("500");
                gaikaKokyakuTuutiTy.setZtysisuux6("600");
                gaikaKokyakuTuutiTy.setZtysisuux7("700");
                gaikaKokyakuTuutiTy.setZtysisuux8("800");
                gaikaKokyakuTuutiTy.setZtysisuux9("900");
                gaikaKokyakuTuutiTy.setZtysisuux10("110");
                gaikaKokyakuTuutiTy.setZtysisuux11("120");

                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux1("1");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux2("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux3("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux4("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux5("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux6("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux7("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux8("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux9("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux10("0");
                gaikaKokyakuTuutiTy.setZtysisuuuprituhugoux11("0");

                gaikaKokyakuTuutiTy.setZtysisuuupritux1("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux2("2000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux3("3000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux4("4000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux5("5000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux6("6000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux7("7000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux8("8000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux9("9000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux10("1000");
                gaikaKokyakuTuutiTy.setZtysisuuupritux11("1000");

                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx1("3100");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx2("3200");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx3("3300");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx4("3400");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx5("3500");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx6("3600");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx7("3700");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx8("3800");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx9("3900");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx10("3110");
                gaikaKokyakuTuutiTy.setZtytmttknzoukaritustrx11("3120");

                gaikaKokyakuTuutiTy.setZtykawaseratex1("11939");
                gaikaKokyakuTuutiTy.setZtykawaseratex2("12939");
                gaikaKokyakuTuutiTy.setZtykawaseratex3("13939");
                gaikaKokyakuTuutiTy.setZtykawaseratex4("14939");
                gaikaKokyakuTuutiTy.setZtykawaseratex5("15939");
                gaikaKokyakuTuutiTy.setZtykawaseratex6("16939");
                gaikaKokyakuTuutiTy.setZtykawaseratex7("17939");
                gaikaKokyakuTuutiTy.setZtykawaseratex8("18939");
                gaikaKokyakuTuutiTy.setZtykawaseratex9("19939");
                gaikaKokyakuTuutiTy.setZtykawaseratex10("22939");
                gaikaKokyakuTuutiTy.setZtykawaseratex11("21939");

                return gaikaKokyakuTuutiTy;
            }
        }

        return super.editInfo(pSyono, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pCampaignFlg, pKawaseRateBean, pYobidasimotoKbn);
    }
}
