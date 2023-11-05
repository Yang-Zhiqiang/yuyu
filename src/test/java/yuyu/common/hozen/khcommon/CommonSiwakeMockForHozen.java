package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 仕訳共通処理{@link CommonSiwake}のモッククラスです<br />
 */
public class CommonSiwakeMockForHozen extends CommonSiwake {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public CommonSiwakeOutBean exec(CommonSiwakeInBean pCommonSiwakeInBean) {

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);
                commonSiwakeOutBean.setHuridenatesakiCd("101");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.IMUSATEI);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20180118"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.YUBINHARAIDASI);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.KARIUKERSKARI);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20180129"));
                commonSiwakeOutBean.setSyoriCd("9001");
                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = new ArrayList<>();
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean1.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean1.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean2.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean2.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean3 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(400, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean3.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean3.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean3.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean3.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                bzSiwakeMeisaiBean3.setIbTaisyakutyouseiflg(true);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean1);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean2);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean3);
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(bzSiwakeMeisaiBeanList);
                return commonSiwakeOutBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);
                commonSiwakeOutBean.setHuridenatesakiCd("102");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.IMUSATEI);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20180119"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.USD);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.YUBINHARAIDASI);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.KARIUKERSKARI);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20180129"));
                commonSiwakeOutBean.setSyoriCd("9002");
                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = new ArrayList<>();
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean1.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean1.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean2.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean2.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean3 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean3.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean3.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean3.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                bzSiwakeMeisaiBean3.setIbTaisyakutyouseiflg(true);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean1);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean2);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean3);
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(bzSiwakeMeisaiBeanList);
                return commonSiwakeOutBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);
                commonSiwakeOutBean.setHuridenatesakiCd("104");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.IMUSATEI);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20180118"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.YUBINHARAIDASI);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.KARIUKERSKARI);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20180129"));
                commonSiwakeOutBean.setSyoriCd("9004");
                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = new ArrayList<>();
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean1.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean1.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean2.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean2.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean3 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(400, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean3.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean3.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean3.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean3.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                bzSiwakeMeisaiBean3.setIbTaisyakutyouseiflg(true);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean1);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean2);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean3);
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(bzSiwakeMeisaiBeanList);
                return commonSiwakeOutBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);
                commonSiwakeOutBean.setHuridenatesakiCd("105");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.IMUSATEI);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20180119"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.USD);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.YUBINHARAIDASI);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.KARIUKERSKARI);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20180129"));
                commonSiwakeOutBean.setSyoriCd("9005");
                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = new ArrayList<>();
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean1.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean1.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean2.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean2.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean3 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean3.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean3.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean3.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                bzSiwakeMeisaiBean3.setIbTaisyakutyouseiflg(true);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean1);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean2);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean3);
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(bzSiwakeMeisaiBeanList);
                return commonSiwakeOutBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);
                commonSiwakeOutBean.setHuridenatesakiCd("106");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.IMUSATEI);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20180118"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.YUBINHARAIDASI);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.KARIUKERSKARI);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20180129"));
                commonSiwakeOutBean.setSyoriCd("9006");
                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = new ArrayList<>();
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean1.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean1.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean2.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean2.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean3 = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
                bzSiwakeMeisaiBean3.setIbDenkarikanjyono("1234567");
                bzSiwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(400, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
                bzSiwakeMeisaiBean3.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
                bzSiwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
                bzSiwakeMeisaiBean3.setIbSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
                bzSiwakeMeisaiBean3.setIbSeg2cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
                bzSiwakeMeisaiBean3.setIbSuitoubumoncd("123");
                bzSiwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                bzSiwakeMeisaiBean3.setIbTaisyakutyouseiflg(true);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean1);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean2);
                bzSiwakeMeisaiBeanList.add(bzSiwakeMeisaiBean3);
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(bzSiwakeMeisaiBeanList);
                return commonSiwakeOutBean;
            }
        }

        return super.exec(pCommonSiwakeInBean);
    }

}
