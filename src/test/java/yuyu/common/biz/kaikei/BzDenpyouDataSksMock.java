package yuyu.common.biz.kaikei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec3;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec5;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.common.siharai.sicommon.SiCommonSiwakeTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_exec;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.JT_SiDenpyoData;

/**
 * {@link BzDenpyouDataSks}のモッククラスです。<br />
 */
public class BzDenpyouDataSksMock extends BzDenpyouDataSks {

    @Inject
    private  BaseUserInfo baseUserInfo;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<HT_SkDenpyoData> execSk(BzSinkeiyakuDenpyouDataTourokuBean pBzSinkeiyakuDenpyouDataTourokuBean) {
        if (caller == HenkinTest_exec.class && SYORIPTN == TESTPATTERN1) {
            super.execSk(pBzSinkeiyakuDenpyouDataTourokuBean);
            List<HT_SkDenpyoData> skDenpyoDataLst = new ArrayList<>();
            HT_SkDenpyoData skDenpyoData = new HT_SkDenpyoData();
            skDenpyoData.setDenrenno("D001");
            skDenpyoDataLst.add(skDenpyoData);
            return skDenpyoDataLst;
        }

        return super.execSk(pBzSinkeiyakuDenpyouDataTourokuBean);
    }

    @Override
    public int getEdano() {
        if (caller == SiCommonSiwakeTest_exec.class) {
            return 1;
        }
        else if(caller == EditKaiyakuTblUpdateTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 10;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return 11;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return 14;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return 15;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return 16;
            }
        }
        else if (caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec3.class){
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return 10;
            }
        }
        return super.getEdano();
    }

    @Override
    public List<JT_SiDenpyoData> execSi(BzDenpyouDataTourokuBean pBzDenpyouDataTourokuBean) {
        List<JT_SiDenpyoData> listResult = new ArrayList<>();
        if (caller == SiCommonSiwakeTest_exec.class && SYORIPTN == TESTPATTERN1) {
            JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
            siDenpyoData.setSyono("11807111118");
            siDenpyoData.setHuridenatesakicd("353");
            siDenpyoData.setTantocd(C_TantouCdKbn.KAIYAKU);
            siDenpyoData.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
            siDenpyoData.setSuitoubumoncd("521");
            siDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
            siDenpyoData.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoData.setDenyenkagk(BizCurrency.valueOf(-2));
            siDenpyoData.setHuridenskskbn(C_HuridensksKbn.ONLINEFB);
            siDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKINYOKU);
            siDenpyoData.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoData.setSyoricd("0001");
            siDenpyoData.setSyorisosikicd("438");
            siDenpyoData.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoData.setSeg2cd(C_Segcd.BLNK);
            siDenpyoData.setKakokawaserateshiteiflg(true);
            siDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoData);
            return listResult;
        }
        if (caller == SiCommonSiwakeTest_exec.class && SYORIPTN == TESTPATTERN2) {
            JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
            siDenpyoData.setSyono("11807111118");
            siDenpyoData.setHuridenatesakicd("353");
            siDenpyoData.setTantocd(C_TantouCdKbn.KAIYAKU);
            siDenpyoData.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siDenpyoData.setSuitoubumoncd("516");
            siDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
            siDenpyoData.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoData.setDenyenkagk(BizCurrency.valueOf(1000));
            siDenpyoData.setHuridenskskbn(C_HuridensksKbn.ONLINEFB);
            siDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKINYOKU);
            siDenpyoData.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoData.setSyoricd("0001");
            siDenpyoData.setSyorisosikicd("438");
            siDenpyoData.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoData.setSeg2cd(C_Segcd.BLNK);
            siDenpyoData.setKakokawaserateshiteiflg(true);
            siDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoData);
            JT_SiDenpyoData siDenpyoDataSecond = new JT_SiDenpyoData();
            siDenpyoDataSecond.setSyono("11807111118");
            siDenpyoDataSecond.setHuridenatesakicd("353");
            siDenpyoDataSecond.setTantocd(C_TantouCdKbn.KAIYAKU);
            siDenpyoDataSecond.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataSecond.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siDenpyoDataSecond.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
            siDenpyoDataSecond.setSuitoubumoncd("521");
            siDenpyoDataSecond.setTuukasyu(C_Tuukasyu.JPY);
            siDenpyoDataSecond.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoDataSecond.setDenyenkagk(BizCurrency.valueOf(1000));
            siDenpyoDataSecond.setHuridenskskbn(C_HuridensksKbn.ONLINEFB);
            siDenpyoDataSecond.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataSecond.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKINYOKU);
            siDenpyoDataSecond.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataSecond.setSyoricd("0001");
            siDenpyoDataSecond.setSyorisosikicd("438");
            siDenpyoDataSecond.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataSecond.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataSecond.setKakokawaserateshiteiflg(true);
            siDenpyoDataSecond.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataSecond.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataSecond);
            return listResult;
        }
        if (caller == SiCommonSiwakeTest_exec.class && SYORIPTN == TESTPATTERN3) {
            JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
            siDenpyoData.setSyono("11807111118");
            siDenpyoData.setHuridenatesakicd("353");
            siDenpyoData.setTantocd(C_TantouCdKbn.KAIYAKU);
            siDenpyoData.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siDenpyoData.setSuitoubumoncd("516");
            siDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
            siDenpyoData.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoData.setDenyenkagk(BizCurrency.valueOf(30000));
            siDenpyoData.setHuridenskskbn(C_HuridensksKbn.ONLINEFB);
            siDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKINYOKU);
            siDenpyoData.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoData.setSyoricd("0001");
            siDenpyoData.setSyorisosikicd("438");
            siDenpyoData.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoData.setSeg2cd(C_Segcd.BLNK);
            siDenpyoData.setKakokawaserateshiteiflg(true);
            siDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoData);
            JT_SiDenpyoData siDenpyoDataSecond = new JT_SiDenpyoData();
            siDenpyoDataSecond.setSyono("11807111118");
            siDenpyoDataSecond.setHuridenatesakicd("353");
            siDenpyoDataSecond.setTantocd(C_TantouCdKbn.KAIYAKU);
            siDenpyoDataSecond.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataSecond.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataSecond.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
            siDenpyoDataSecond.setSuitoubumoncd("516");
            siDenpyoDataSecond.setTuukasyu(C_Tuukasyu.JPY);
            siDenpyoDataSecond.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoDataSecond.setDenyenkagk(BizCurrency.valueOf(2000));
            siDenpyoDataSecond.setHuridenskskbn(C_HuridensksKbn.ONLINEFB);
            siDenpyoDataSecond.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataSecond.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKINYOKU);
            siDenpyoDataSecond.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataSecond.setSyoricd("0001");
            siDenpyoDataSecond.setSyorisosikicd("438");
            siDenpyoDataSecond.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataSecond.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataSecond.setKakokawaserateshiteiflg(true);
            siDenpyoDataSecond.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataSecond.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataSecond);
            JT_SiDenpyoData siDenpyoDataThird = new JT_SiDenpyoData();
            siDenpyoDataThird.setSyono("11807111118");
            siDenpyoDataThird.setHuridenatesakicd("353");
            siDenpyoDataThird.setTantocd(C_TantouCdKbn.KAIYAKU);
            siDenpyoDataThird.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataThird.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataThird.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD);
            siDenpyoDataThird.setSuitoubumoncd("516");
            siDenpyoDataThird.setTuukasyu(C_Tuukasyu.JPY);
            siDenpyoDataThird.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoDataThird.setDenyenkagk(BizCurrency.valueOf(100));
            siDenpyoDataThird.setHuridenskskbn(C_HuridensksKbn.ONLINEFB);
            siDenpyoDataThird.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataThird.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKINYOKU);
            siDenpyoDataThird.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataThird.setSyoricd("0001");
            siDenpyoDataThird.setSyorisosikicd("438");
            siDenpyoDataThird.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataThird.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataThird.setKakokawaserateshiteiflg(true);
            siDenpyoDataThird.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataThird.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataThird);
            JT_SiDenpyoData siDenpyoDataFourth = new JT_SiDenpyoData();
            siDenpyoDataFourth.setSyono("11807111118");
            siDenpyoDataFourth.setHuridenatesakicd("353");
            siDenpyoDataFourth.setTantocd(C_TantouCdKbn.KAIYAKU);
            siDenpyoDataFourth.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataFourth.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siDenpyoDataFourth.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
            siDenpyoDataFourth.setSuitoubumoncd("521");
            siDenpyoDataFourth.setTuukasyu(C_Tuukasyu.JPY);
            siDenpyoDataFourth.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoDataFourth.setDenyenkagk(BizCurrency.valueOf(32100));
            siDenpyoDataFourth.setHuridenskskbn(C_HuridensksKbn.ONLINEFB);
            siDenpyoDataFourth.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataFourth.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKINYOKU);
            siDenpyoDataFourth.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataFourth.setSyoricd("0001");
            siDenpyoDataFourth.setSyorisosikicd("438");
            siDenpyoDataFourth.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataFourth.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataFourth.setKakokawaserateshiteiflg(true);
            siDenpyoDataFourth.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataFourth.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataFourth);
            return listResult;
        }
        if (caller == SiCommonSiwakeTest_exec.class && SYORIPTN == TESTPATTERN4) {
            JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
            siDenpyoData.setSyono("11807111118");
            siDenpyoData.setHuridenatesakicd("415");
            siDenpyoData.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoData.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siDenpyoData.setSuitoubumoncd("564");
            siDenpyoData.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoData.setDengaikagk(BizCurrency.valueOf(40000,BizCurrencyTypes.DOLLAR));
            siDenpyoData.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoData.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKARI);
            siDenpyoData.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoData.setSyoricd("0001");
            siDenpyoData.setSyorisosikicd("438");
            siDenpyoData.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoData.setSeg2cd(C_Segcd.BLNK);
            siDenpyoData.setKakokawaserateshiteiflg(true);
            siDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoData);
            JT_SiDenpyoData siDenpyoDataSecond = new JT_SiDenpyoData();
            siDenpyoDataSecond.setSyono("11807111118");
            siDenpyoDataSecond.setHuridenatesakicd("415");
            siDenpyoDataSecond.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataSecond.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataSecond.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataSecond.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
            siDenpyoDataSecond.setSuitoubumoncd("564");
            siDenpyoDataSecond.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataSecond.setDengaikagk(BizCurrency.valueOf(20000,BizCurrencyTypes.DOLLAR));
            siDenpyoDataSecond.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataSecond.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataSecond.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataSecond.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKARI);
            siDenpyoDataSecond.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataSecond.setSyoricd("0001");
            siDenpyoDataSecond.setSyorisosikicd("438");
            siDenpyoDataSecond.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataSecond.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataSecond.setKakokawaserateshiteiflg(true);
            siDenpyoDataSecond.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataSecond.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataSecond);
            JT_SiDenpyoData siDenpyoDataThird = new JT_SiDenpyoData();
            siDenpyoDataThird.setSyono("11807111118");
            siDenpyoDataThird.setHuridenatesakicd("415");
            siDenpyoDataThird.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataThird.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataThird.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataThird.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
            siDenpyoDataThird.setSuitoubumoncd("564");
            siDenpyoDataThird.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataThird.setDengaikagk(BizCurrency.valueOf(2000,BizCurrencyTypes.DOLLAR));
            siDenpyoDataThird.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataThird.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataThird.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataThird.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKARI);
            siDenpyoDataThird.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataThird.setSyoricd("0001");
            siDenpyoDataThird.setSyorisosikicd("438");
            siDenpyoDataThird.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataThird.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataThird.setKakokawaserateshiteiflg(true);
            siDenpyoDataThird.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataThird.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataThird);
            JT_SiDenpyoData siDenpyoDataFourth = new JT_SiDenpyoData();
            siDenpyoDataFourth.setSyono("11807111118");
            siDenpyoDataFourth.setHuridenatesakicd("415");
            siDenpyoDataFourth.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataFourth.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataFourth.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataFourth.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD);
            siDenpyoDataFourth.setSuitoubumoncd("564");
            siDenpyoDataFourth.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataFourth.setDengaikagk(BizCurrency.valueOf(100,BizCurrencyTypes.DOLLAR));
            siDenpyoDataFourth.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataFourth.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataFourth.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataFourth.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKARI);
            siDenpyoDataFourth.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataFourth.setSyoricd("0001");
            siDenpyoDataFourth.setSyorisosikicd("438");
            siDenpyoDataFourth.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataFourth.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataFourth.setKakokawaserateshiteiflg(true);
            siDenpyoDataFourth.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataFourth.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataFourth);
            JT_SiDenpyoData siDenpyoDataFifth = new JT_SiDenpyoData();
            siDenpyoDataFifth.setSyono("11807111118");
            siDenpyoDataFifth.setHuridenatesakicd("415");
            siDenpyoDataFifth.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataFifth.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataFifth.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siDenpyoDataFifth.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO);
            siDenpyoDataFifth.setSuitoubumoncd("564");
            siDenpyoDataFifth.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataFifth.setDengaikagk(BizCurrency.valueOf(62100,BizCurrencyTypes.DOLLAR));
            siDenpyoDataFifth.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataFifth.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataFifth.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataFifth.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKARI);
            siDenpyoDataFifth.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataFifth.setSyoricd("0001");
            siDenpyoDataFifth.setSyorisosikicd("438");
            siDenpyoDataFifth.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataFifth.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataFifth.setKakokawaserateshiteiflg(true);
            siDenpyoDataFifth.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataFifth.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataFifth);
            return listResult;
        }
        if (caller == SiCommonSiwakeTest_exec.class && SYORIPTN == TESTPATTERN5) {
            JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
            siDenpyoData.setSyono("11807111118");
            siDenpyoData.setHuridenatesakicd("415");
            siDenpyoData.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoData.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siDenpyoData.setSuitoubumoncd("564");
            siDenpyoData.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoData.setDengaikagk(BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR));
            siDenpyoData.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoData.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKNASI);
            siDenpyoData.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoData.setSyoricd("0001");
            siDenpyoData.setSyorisosikicd("438");
            siDenpyoData.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoData.setSeg2cd(C_Segcd.BLNK);
            siDenpyoData.setKakokawaserateshiteiflg(true);
            siDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoData);
            JT_SiDenpyoData siDenpyoDataSecond = new JT_SiDenpyoData();
            siDenpyoDataSecond.setSyono("11807111118");
            siDenpyoDataSecond.setHuridenatesakicd("415");
            siDenpyoDataSecond.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataSecond.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataSecond.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataSecond.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
            siDenpyoDataSecond.setSuitoubumoncd("564");
            siDenpyoDataSecond.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataSecond.setDengaikagk(BizCurrency.valueOf(20000,BizCurrencyTypes.DOLLAR));
            siDenpyoDataSecond.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataSecond.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataSecond.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataSecond.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKNASI);
            siDenpyoDataSecond.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataSecond.setSyoricd("0001");
            siDenpyoDataSecond.setSyorisosikicd("438");
            siDenpyoDataSecond.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataSecond.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataSecond.setKakokawaserateshiteiflg(true);
            siDenpyoDataSecond.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataSecond.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataSecond);
            JT_SiDenpyoData siDenpyoDataThird = new JT_SiDenpyoData();
            siDenpyoDataThird.setSyono("11807111118");
            siDenpyoDataThird.setHuridenatesakicd("415");
            siDenpyoDataThird.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataThird.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataThird.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataThird.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
            siDenpyoDataThird.setSuitoubumoncd("564");
            siDenpyoDataThird.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataThird.setDengaikagk(BizCurrency.valueOf(3000,BizCurrencyTypes.DOLLAR));
            siDenpyoDataThird.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataThird.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataThird.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataThird.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKNASI);
            siDenpyoDataThird.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataThird.setSyoricd("0001");
            siDenpyoDataThird.setSyorisosikicd("438");
            siDenpyoDataThird.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataThird.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataThird.setKakokawaserateshiteiflg(true);
            siDenpyoDataThird.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataThird.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataThird);
            JT_SiDenpyoData siDenpyoDataFourth = new JT_SiDenpyoData();
            siDenpyoDataFourth.setSyono("11807111118");
            siDenpyoDataFourth.setHuridenatesakicd("415");
            siDenpyoDataFourth.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataFourth.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataFourth.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataFourth.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
            siDenpyoDataFourth.setSuitoubumoncd("564");
            siDenpyoDataFourth.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataFourth.setDengaikagk(BizCurrency.valueOf(2000,BizCurrencyTypes.DOLLAR));
            siDenpyoDataFourth.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataFourth.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataFourth.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataFourth.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKNASI);
            siDenpyoDataFourth.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataFourth.setSyoricd("0001");
            siDenpyoDataFourth.setSyorisosikicd("438");
            siDenpyoDataFourth.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataFourth.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataFourth.setKakokawaserateshiteiflg(true);
            siDenpyoDataFourth.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataFourth.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataFourth);
            JT_SiDenpyoData siDenpyoDataFifth = new JT_SiDenpyoData();
            siDenpyoDataFifth.setSyono("11807111118");
            siDenpyoDataFifth.setHuridenatesakicd("415");
            siDenpyoDataFifth.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataFifth.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataFifth.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataFifth.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD);
            siDenpyoDataFifth.setSuitoubumoncd("564");
            siDenpyoDataFifth.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataFifth.setDengaikagk(BizCurrency.valueOf(100,BizCurrencyTypes.DOLLAR));
            siDenpyoDataFifth.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataFifth.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataFifth.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataFifth.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKNASI);
            siDenpyoDataFifth.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataFifth.setSyoricd("0001");
            siDenpyoDataFifth.setSyorisosikicd("438");
            siDenpyoDataFifth.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataFifth.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataFifth.setKakokawaserateshiteiflg(true);
            siDenpyoDataFifth.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataFifth.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataFifth);
            JT_SiDenpyoData siDenpyoDataSixth = new JT_SiDenpyoData();
            siDenpyoDataSixth.setSyono("11807111118");
            siDenpyoDataSixth.setHuridenatesakicd("415");
            siDenpyoDataSixth.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataSixth.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataSixth.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siDenpyoDataSixth.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO);
            siDenpyoDataSixth.setSuitoubumoncd("564");
            siDenpyoDataSixth.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataSixth.setDengaikagk(BizCurrency.valueOf(62100,BizCurrencyTypes.DOLLAR));
            siDenpyoDataSixth.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siDenpyoDataSixth.setHuridenskskbn(C_HuridensksKbn.KOBETU);
            siDenpyoDataSixth.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataSixth.setDenshrhoukbn(C_DenshrhouKbn.KARIUKERSKNASI);
            siDenpyoDataSixth.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataSixth.setSyoricd("0001");
            siDenpyoDataSixth.setSyorisosikicd("438");
            siDenpyoDataSixth.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataSixth.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataSixth.setKakokawaserateshiteiflg(true);
            siDenpyoDataSixth.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataSixth.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataSixth);
            return listResult;
        }
        if (caller == SiCommonSiwakeTest_exec.class && SYORIPTN == TESTPATTERN6) {
            JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
            siDenpyoData.setSyono("11807111118");
            siDenpyoData.setHuridenatesakicd("415");
            siDenpyoData.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoData.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siDenpyoData.setSuitoubumoncd("564");
            siDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
            siDenpyoData.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoData.setDenyenkagk(BizCurrency.valueOf(10000));
            siDenpyoData.setHuridenskskbn(C_HuridensksKbn.HOZENYAKAN);
            siDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKIN);
            siDenpyoData.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoData.setSyoricd("0001");
            siDenpyoData.setSyorisosikicd("438");
            siDenpyoData.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoData.setSeg2cd(C_Segcd.BLNK);
            siDenpyoData.setKakokawaserateshiteiflg(true);
            siDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoData);
            JT_SiDenpyoData siDenpyoDataSecond = new JT_SiDenpyoData();
            siDenpyoDataSecond.setSyono("11807111118");
            siDenpyoDataSecond.setHuridenatesakicd("415");
            siDenpyoDataSecond.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataSecond.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataSecond.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataSecond.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
            siDenpyoDataSecond.setSuitoubumoncd("564");
            siDenpyoDataSecond.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataSecond.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoDataSecond.setDenyenkagk(BizCurrency.valueOf(2000));
            siDenpyoDataSecond.setHuridenskskbn(C_HuridensksKbn.HOZENYAKAN);
            siDenpyoDataSecond.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataSecond.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKIN);
            siDenpyoDataSecond.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataSecond.setSyoricd("0001");
            siDenpyoDataSecond.setSyorisosikicd("438");
            siDenpyoDataSecond.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataSecond.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataSecond.setKakokawaserateshiteiflg(true);
            siDenpyoDataSecond.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataSecond.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataSecond);
            JT_SiDenpyoData siDenpyoDataThird = new JT_SiDenpyoData();
            siDenpyoDataThird.setSyono("11807111118");
            siDenpyoDataThird.setHuridenatesakicd("415");
            siDenpyoDataThird.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataThird.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataThird.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siDenpyoDataThird.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD);
            siDenpyoDataThird.setSuitoubumoncd("564");
            siDenpyoDataThird.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataThird.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoDataThird.setDenyenkagk(BizCurrency.valueOf(100));
            siDenpyoDataThird.setHuridenskskbn(C_HuridensksKbn.HOZENYAKAN);
            siDenpyoDataThird.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataThird.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKIN);
            siDenpyoDataThird.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataThird.setSyoricd("0001");
            siDenpyoDataThird.setSyorisosikicd("438");
            siDenpyoDataThird.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataThird.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataThird.setKakokawaserateshiteiflg(true);
            siDenpyoDataThird.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataThird.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataThird);
            JT_SiDenpyoData siDenpyoDataFourth = new JT_SiDenpyoData();
            siDenpyoDataFourth.setSyono("11807111118");
            siDenpyoDataFourth.setHuridenatesakicd("415");
            siDenpyoDataFourth.setTantocd(C_TantouCdKbn.SIBOUTETUZUKI);
            siDenpyoDataFourth.setDenymd(BizDate.valueOf("20160303"));
            siDenpyoDataFourth.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siDenpyoDataFourth.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU);
            siDenpyoDataFourth.setSuitoubumoncd("564");
            siDenpyoDataFourth.setTuukasyu(C_Tuukasyu.USD);
            siDenpyoDataFourth.setDengaikagk(BizCurrency.valueOf(0));
            siDenpyoDataFourth.setDenyenkagk(BizCurrency.valueOf(12100));
            siDenpyoDataFourth.setHuridenskskbn(C_HuridensksKbn.HOZENYAKAN);
            siDenpyoDataFourth.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            siDenpyoDataFourth.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKIN);
            siDenpyoDataFourth.setSyoriYmd(BizDate.valueOf("20160302"));
            siDenpyoDataFourth.setSyoricd("0001");
            siDenpyoDataFourth.setSyorisosikicd("438");
            siDenpyoDataFourth.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            siDenpyoDataFourth.setSeg2cd(C_Segcd.BLNK);
            siDenpyoDataFourth.setKakokawaserateshiteiflg(true);
            siDenpyoDataFourth.setKakokawaserateshiteiymd(BizDate.valueOf("20160301"));
            siDenpyoDataFourth.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            listResult.add(siDenpyoDataFourth);
            return listResult;
        }
        if (caller == SiCommonSiwakeTest_exec.class && SYORIPTN == TESTPATTERN7) {
            return listResult;
        }
        return super.execSi(pBzDenpyouDataTourokuBean);
    }

    @Override
    public List<IT_KhDenpyoData> execKh(BzDenpyouDataTourokuBean pBzDenpyouDataTourokuBean) {

        if(caller == EditKaiyakuTblUpdateTest_exec.class){
            List<IT_KhDenpyoData> khDenpyoDataList = new ArrayList<>();
            IT_KhDenpyoData khDenpyoData = new IT_KhDenpyoData();
            if (TESTPATTERN1.equals(SYORIPTN)) {
                khDenpyoData.setDenrenno("100001");
                khDenpyoData.setEdano(10);
                khDenpyoData.setDengyoumucd("90001");
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                khDenpyoData.setDenrenno("100002");
                khDenpyoData.setEdano(11);
                khDenpyoData.setDengyoumucd("90002");
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                khDenpyoData.setDenrenno("100004");
                khDenpyoData.setEdano(14);
                khDenpyoData.setDengyoumucd("90004");
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                khDenpyoData.setDenrenno("100005");
                khDenpyoData.setEdano(15);
                khDenpyoData.setDengyoumucd("90005");
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                khDenpyoData.setDenrenno("100006");
                khDenpyoData.setEdano(16);
                khDenpyoData.setDengyoumucd("90006");
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }
        }
        else if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec5.class){
            List<IT_KhDenpyoData> khDenpyoDataList = new ArrayList<>();
            IT_KhDenpyoData khDenpyoData = new IT_KhDenpyoData();
            if (TESTPATTERN1.equals(SYORIPTN)) {
                khDenpyoData.setDenrenno("100001");
                khDenpyoData.setEdano(10);
                khDenpyoData.setDengyoumucd("90001");
                khDenpyoData.setDenymd(BizDate.valueOf(20151231));
                khDenpyoData.setDensyskbn(C_DensysKbn.HOZEN);
                khDenpyoData.setSuitoubumoncd("001");
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                khDenpyoData.setSyono(pBzDenpyouDataTourokuBean.getIbSyono());
                khDenpyoData.setDenrenno("100001");
                khDenpyoData.setEdano(10);
                khDenpyoData.setDengyoumucd("90001");
                khDenpyoData.setDenymd(BizDate.valueOf(20151231));
                khDenpyoData.setHuridenatesakicd("1234");
                khDenpyoData.setDensyskbn(C_DensysKbn.HOZEN);
                khDenpyoData.setTantocd(C_TantouCdKbn.KAIYAKU);
                khDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                khDenpyoData.setSuitoubumoncd("1234");
                khDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
                khDenpyoData.setDengaikagk(BizCurrency.valueOf(0));
                khDenpyoData.setDenkawaserate(BizNumber.valueOf(0));
                khDenpyoData.setDenyenkagk(BizCurrency.valueOf(0));
                khDenpyoData.setHuridenskskbn(C_HuridensksKbn.BLNK);
                khDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
                khDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.BLNK);
                khDenpyoData.setSyoriYmd(BizDate.valueOf("20160105"));
                khDenpyoData.setSyoricd("RG9F");
                khDenpyoData.setSyorisosikicd("12340000");
                khDenpyoData.setKakokawaserateshiteiflg(false);
                khDenpyoData.setKakokawaserateshiteiymd(null);
                khDenpyoData.setKyktuukasyu(C_Tuukasyu.JPY);
                khDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(0));
                khDenpyoData.setGyoumuKousinsyaId("JUnit");
                khDenpyoData.setSyusyouhncd("001");
                khDenpyoData.setSyouhnsdno(1);
                khDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU);
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }

        }
        return super.execKh(pBzDenpyouDataTourokuBean);
    }

}
