package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 案内収納用仕訳共通処理のモッククラスです。<br />
 */
public class AnsyuuCommonSiwakeMockForKhansyuu extends AnsyuuCommonSiwake {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public CommonSiwakeOutBean exec(AnsyuuCommonSiwakeInBean pAnsyuuCommonSiwakeInBean) {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                CommonSiwakeOutBean commonSiwakeOutBean =  SWAKInjector.getInstance(CommonSiwakeOutBean.class);

                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20151231"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20160105"));
                commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriCd("RG9F");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);

                commonSiwakeOutBean.setHuridenatesakiCd("1234");

                List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();

                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU);
                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));

                siwakeMeisaiBeanLst.add(siwakeMeisaiBean);

                commonSiwakeOutBean.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.CREDIT);
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

                return commonSiwakeOutBean;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                CommonSiwakeOutBean commonSiwakeOutBean =  SWAKInjector.getInstance(CommonSiwakeOutBean.class);

                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20160201"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20160201"));
                commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriCd("RG9F");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);

                commonSiwakeOutBean.setHuridenatesakiCd("1234");

                List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();

                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU);
                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));

                siwakeMeisaiBeanLst.add(siwakeMeisaiBean);

                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

                return commonSiwakeOutBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                CommonSiwakeOutBean commonSiwakeOutBean =  SWAKInjector.getInstance(CommonSiwakeOutBean.class);

                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20210226"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20160103"));
                commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriCd("RG9F");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);

                commonSiwakeOutBean.setHuridenatesakiCd("1234");

                List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();

                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU);
                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));

                siwakeMeisaiBeanLst.add(siwakeMeisaiBean);

                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

                return commonSiwakeOutBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                CommonSiwakeOutBean commonSiwakeOutBean =  SWAKInjector.getInstance(CommonSiwakeOutBean.class);

                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20151231"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20160105"));
                commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriCd("RG9F");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);

                commonSiwakeOutBean.setHuridenatesakiCd("1234");

                List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();

                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE);
                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));

                siwakeMeisaiBeanLst.add(siwakeMeisaiBean);

                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

                return commonSiwakeOutBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                CommonSiwakeOutBean commonSiwakeOutBean =  SWAKInjector.getInstance(CommonSiwakeOutBean.class);

                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20210226"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20160103"));
                commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriCd("RG9F");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);

                commonSiwakeOutBean.setHuridenatesakiCd("1234");

                List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();

                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU);
                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));

                siwakeMeisaiBeanLst.add(siwakeMeisaiBean);

                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

                return commonSiwakeOutBean;

            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                CommonSiwakeOutBean commonSiwakeOutBean =  SWAKInjector.getInstance(CommonSiwakeOutBean.class);

                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20210226"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20160103"));
                commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriCd("RG9F");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);

                commonSiwakeOutBean.setHuridenatesakiCd("1234");

                List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();

                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE);
                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));

                siwakeMeisaiBeanLst.add(siwakeMeisaiBean);

                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

                return commonSiwakeOutBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                CommonSiwakeOutBean commonSiwakeOutBean =  SWAKInjector.getInstance(CommonSiwakeOutBean.class);

                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20151231"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20160105"));
                commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriCd("RG9F");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);

                commonSiwakeOutBean.setHuridenatesakiCd("1234");

                List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();

                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU);
                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));

                siwakeMeisaiBeanLst.add(siwakeMeisaiBean);

                commonSiwakeOutBean.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.CREDIT);
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

                return commonSiwakeOutBean;

            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                CommonSiwakeOutBean commonSiwakeOutBean =  SWAKInjector.getInstance(CommonSiwakeOutBean.class);

                commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
                commonSiwakeOutBean.setDenYmd(BizDate.valueOf("20151231"));
                commonSiwakeOutBean.setTuukasyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriYmd(BizDate.valueOf("20160105"));
                commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
                commonSiwakeOutBean.setSyoriCd("RG9F");
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);

                commonSiwakeOutBean.setHuridenatesakiCd("1234");

                List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();

                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
                siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));

                siwakeMeisaiBeanLst.add(siwakeMeisaiBean);

                commonSiwakeOutBean.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.CREDIT);
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

                return commonSiwakeOutBean;

            }
        }
        return super.exec(pAnsyuuCommonSiwakeInBean);
    }
}
