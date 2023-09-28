package yuyu.common.biz.kaikei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.GengouInfo;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.FurikaeDenpyouParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HuridenYouHassouKbn;
import yuyu.def.classification.C_KanjyouKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_SeiHukuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.BM_TantouCd;

/**
 * 業務共通 経理・会計 振替伝票情報クラス
 */
public class BzFurikaeDenpyouJouhou {

    private static final String ZERO_FOURKETA = "0000";

    private static final int HURIKAEDENPYOU_COUNT = 4;

    private static final String GOUKEI_INJI = "合計";

    private static final String KURIKOSI_INJI = "繰越";

    private static final String HURIDENPYOU_HIKAE_INJI = "＊控＊";

    private static final String LAST_GROUP_HYOUJI = "L";

    private static final int KANJI_TANTOUKAMEI_LENGTH = 8;

    private static final String SITU = "室";

    private static final String YEN_KIGOU = "\u00a5";

    private static final String ZERO_THREEKETA = "000";

    private final List<FurikaeDenpyouSiwakeMeisai> kasiFurikaeDenpyouSiwakeMeisaiList;

    private final List<FurikaeDenpyouSiwakeMeisai> kariFurikaeDenpyouSiwakeMeisaiList;

    private BizDate denYmd;

    private String huriDenAtesakiCd;

    private C_KeirisysKbn keiriSysKbn;

    private boolean lastGroupDispFlg;

    private C_TantouCdKbn tantoCd;

    private String torihikiNo;

    private String kjTekiyou1;

    private String kjTekiyou2;

    private String kjTekiyou3;

    private String kjTekiyouHikae1;

    private String kjTekiyouHikae2;

    private String kjTekiyouHikae3;

    private BizDate syoriYmd;

    @Inject
    private static Logger logger;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    public void setDenYmd(BizDate pDenYmd) {
        denYmd = pDenYmd;
    }

    public void setHuriDenAtesakiCd(String pHuriDenAtesakiCd) {
        huriDenAtesakiCd = pHuriDenAtesakiCd;
    }

    public void setKeiriSysKbn(C_KeirisysKbn pKeiriSysKbn) {
        keiriSysKbn = pKeiriSysKbn;
    }

    public void setLastGroupDispFlg(boolean pLastGroupDispFlg) {
        lastGroupDispFlg = pLastGroupDispFlg;
    }

    public void setTantoCd(C_TantouCdKbn pTantoCd) {
        tantoCd = pTantoCd;
    }

    public void setTorihikiNo(String pTorihikiNo) {
        torihikiNo = pTorihikiNo;
    }

    public void setKjTekiyou1(String pKjTekiyou1) {
        kjTekiyou1 = pKjTekiyou1;
    }

    public void setKjTekiyou2(String pKjTekiyou2) {
        kjTekiyou2 = pKjTekiyou2;
    }

    public void setKjTekiyou3(String pKjTekiyou3) {
        kjTekiyou3 = pKjTekiyou3;
    }

    public void setKjTekiyouHikae1(String pKjTekiyouHikae1) {
        kjTekiyouHikae1 = pKjTekiyouHikae1;
    }

    public void setKjTekiyouHikae2(String pKjTekiyouHikae2) {
        kjTekiyouHikae2 = pKjTekiyouHikae2;
    }

    public void setKjTekiyouHikae3(String pKjTekiyouHikae3) {
        kjTekiyouHikae3 = pKjTekiyouHikae3;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public BzFurikaeDenpyouJouhou() {

        kasiFurikaeDenpyouSiwakeMeisaiList = new ArrayList<>();
        kariFurikaeDenpyouSiwakeMeisaiList = new ArrayList<>();
    }

    public void insertSiwakeMeisai(FurikaeDenpyouSiwakeMeisai pFurikaeDenpyouSiwakeMeisai, C_TaisyakuKbn pTaisyakuKbn) {

        logger.debug("▽ 振替伝票情報 仕訳明細行追加 開始");

        List<FurikaeDenpyouSiwakeMeisai> furikaeDenpyouSiwakeMeisaiLst = new ArrayList<>();

        if (C_TaisyakuKbn.KASIKATA.eq(pTaisyakuKbn)) {

            furikaeDenpyouSiwakeMeisaiLst = kasiFurikaeDenpyouSiwakeMeisaiList;
        }
        else if (C_TaisyakuKbn.KARIKATA.eq(pTaisyakuKbn)) {

            furikaeDenpyouSiwakeMeisaiLst = kariFurikaeDenpyouSiwakeMeisaiList;
        }

        furikaeDenpyouSiwakeMeisaiLst.add(pFurikaeDenpyouSiwakeMeisai);

        logger.debug("△ 振替伝票情報 仕訳明細行追加 終了");
    }

    public void seisanLastSiwakeMeisai(C_TaisyakuKbn pTaisyakuKbn, BizCurrency pKinGk) {

        logger.debug("▽ 振替伝票情報 最終仕訳明細行金額加算 開始");

        List<FurikaeDenpyouSiwakeMeisai> furikaeDenpyouSiwakeMeisaiLst = new ArrayList<>();

        if (C_TaisyakuKbn.KASIKATA.eq(pTaisyakuKbn)) {

            furikaeDenpyouSiwakeMeisaiLst = kasiFurikaeDenpyouSiwakeMeisaiList;
        }
        else if (C_TaisyakuKbn.KARIKATA.eq(pTaisyakuKbn)) {

            furikaeDenpyouSiwakeMeisaiLst = kariFurikaeDenpyouSiwakeMeisaiList;
        }

        FurikaeDenpyouSiwakeMeisai furikaeDenpyouSiwakeMeisai = furikaeDenpyouSiwakeMeisaiLst.get(furikaeDenpyouSiwakeMeisaiLst.size() - 1);

        furikaeDenpyouSiwakeMeisai.setKinGk(furikaeDenpyouSiwakeMeisai.getKinGk().add(pKinGk));

        logger.debug("△ 振替伝票情報 最終仕訳明細行金額加算 終了");
    }

    public List<FurikaeDenpyouPage> furikaeDenPageList() {

        logger.debug("▽ 振替伝票情報 振替伝票ページ情報リスト生成 開始");

        GengouInfo gengouInfo = denYmd.getLatestGengouInfo();

        String gengouKbn = gengouInfo.getGengouSymbol();

        int thyear = denYmd.getYearW(gengouInfo);
        int thmonth = denYmd.getMonth();
        int thday = denYmd.getDay();

        BM_TantouCd bTantouCd = null;
        if(tantoCd != null && !C_TantouCdKbn.BLNK0.eq(tantoCd)){
            bTantouCd = bizDomManager.getTantouCd(tantoCd);
        }

        String sosikiCd = null;
        String kanjisosikinm20 = null;

        String kanjisosikinm8 = null;

        String tantouBusitucd = null;
        int countMesai;

        if (bTantouCd == null) {
            sosikiCd = huriDenAtesakiCd + ZERO_FOURKETA;
            tantouBusitucd = huriDenAtesakiCd;
        }
        else {
            sosikiCd = bTantouCd.getBusitucd() + ZERO_FOURKETA;
            tantouBusitucd = bTantouCd.getBusitucd();
        }

        AM_Sosiki sosiki = baseDomManager.getSosiki(sosikiCd);

        if(sosiki.getKanjisosikinm20().length() > KANJI_TANTOUKAMEI_LENGTH){
            kanjisosikinm8 = sosiki.getKanjisosikinm20().substring(0,KANJI_TANTOUKAMEI_LENGTH);
        }else{
            kanjisosikinm8 = sosiki.getKanjisosikinm20();
        }
        if(kanjisosikinm8.length() > 0 && kanjisosikinm8.substring(kanjisosikinm8.length() - 1).equals(SITU)){
            kanjisosikinm8 = kanjisosikinm8.substring(0, kanjisosikinm8.length()-1);
        }

        kanjisosikinm20 = kanjisosikinm8;

        C_HuridenYouHassouKbn huridenYouHassouKbn = getHuridenYouHassouKbn(tantouBusitucd);

        String kjsystemnm = keiriSysKbn.getContent();

        if (kasiFurikaeDenpyouSiwakeMeisaiList.size() >= kariFurikaeDenpyouSiwakeMeisaiList.size()) {

            countMesai = kasiFurikaeDenpyouSiwakeMeisaiList.size();
        }
        else {

            countMesai = kariFurikaeDenpyouSiwakeMeisaiList.size();
        }

        int pageCount = countMesai / HURIKAEDENPYOU_COUNT;

        if (countMesai % HURIKAEDENPYOU_COUNT != 0) {
            pageCount++;
        }

        BizCurrency kasiKinGk = BizCurrency.valueOf(0);
        BizCurrency kariKinGk = BizCurrency.valueOf(0);
        List<FurikaeDenpyouPage> furikaeDenpyouPageLst = new ArrayList<>();

        for (int N = 0; N < pageCount; N++) {

            FurikaeDenpyouPage furikaeDenpyouPage = SWAKInjector.getInstance(FurikaeDenpyouPage.class);

            furikaeDenpyouPage.setSystemkbn(keiriSysKbn.getValue());
            furikaeDenpyouPage.setTorihikiNo(getInjiTrhkno());
            furikaeDenpyouPage.setPageNo(N + 1);
            furikaeDenpyouPage.setTorihikiYmdGengoKbn(gengouKbn);
            furikaeDenpyouPage.setTorihikiNen(thyear);
            furikaeDenpyouPage.setTorihikiTsuki(thmonth);
            furikaeDenpyouPage.setTorihikiBi(thday);
            furikaeDenpyouPage.setKjTantoukaNm(kanjisosikinm20);
            if(tantoCd != null && !C_TantouCdKbn.BLNK0.eq(tantoCd)){
                furikaeDenpyouPage.setKjTantoukaCd(tantoCd.getValue());
            }
            furikaeDenpyouPage.setKjSystemNm(kjsystemnm);
            furikaeDenpyouPage.setKasiKurikosiGk(kasiKinGk);
            furikaeDenpyouPage.setKariKurikosiGk(kariKinGk);
            furikaeDenpyouPage.setHuridenYouHassouKbn(huridenYouHassouKbn);

            String[] kjKasiKanjouKamokuNms = {"", "", "", ""};
            String[] kjKariKanjouKamokuNms = {"", "", "", ""};
            BizCurrency[] kasiGks = { BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0)};
            BizCurrency[] kariGks = { BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0)};
            String[] kasiTekiyouKms = {"", "", "", ""};
            String[] kariTekiyouKms = {"", "", "", ""};
            String[] kjKasiTekiyouKms = {"", "", "", ""};
            String[] kjKariTekiyouKms = {"", "", "", ""};
            BizCurrency kasiGoukeiGk = kasiKinGk;
            BizCurrency kariGoukeiGk = kariKinGk;

            for (int j = 0; j < HURIKAEDENPYOU_COUNT; j++) {

                int siwakeiIndex = j + N * HURIKAEDENPYOU_COUNT;

                if (kasiFurikaeDenpyouSiwakeMeisaiList.size() > siwakeiIndex) {

                    FurikaeDenpyouSiwakeMeisai furikaeDenpyouSiwakeMeisai = kasiFurikaeDenpyouSiwakeMeisaiList.get(siwakeiIndex);

                    kjKasiKanjouKamokuNms[j] = furikaeDenpyouSiwakeMeisai.getDenKanjoKamokuNm();
                    kasiGks[j] = furikaeDenpyouSiwakeMeisai.getKinGk();
                    kasiTekiyouKms[j] = furikaeDenpyouSiwakeMeisai.getTekiyouKm();
                    kjKasiTekiyouKms[j] = furikaeDenpyouSiwakeMeisai.getKjTekiyouKm();
                    kasiGoukeiGk = kasiGoukeiGk.add(furikaeDenpyouSiwakeMeisai.getKinGk());
                }

                if (kariFurikaeDenpyouSiwakeMeisaiList.size() > siwakeiIndex) {

                    FurikaeDenpyouSiwakeMeisai furikaeDenpyouSiwakeMeisai = kariFurikaeDenpyouSiwakeMeisaiList.get(siwakeiIndex);

                    kjKariKanjouKamokuNms[j] = furikaeDenpyouSiwakeMeisai.getDenKanjoKamokuNm();
                    kariGks[j] = furikaeDenpyouSiwakeMeisai.getKinGk();
                    kariTekiyouKms[j] = furikaeDenpyouSiwakeMeisai.getTekiyouKm();
                    kjKariTekiyouKms[j] = furikaeDenpyouSiwakeMeisai.getKjTekiyouKm();
                    kariGoukeiGk = kariGoukeiGk.add(furikaeDenpyouSiwakeMeisai.getKinGk());
                }
            }

            furikaeDenpyouPage.setKjKasiKanjoukamokuNms(kjKasiKanjouKamokuNms);
            furikaeDenpyouPage.setKjKariKanjoukamokuNms(kjKariKanjouKamokuNms);
            furikaeDenpyouPage.setKasiGks(kasiGks);
            furikaeDenpyouPage.setKariGks(kariGks);
            furikaeDenpyouPage.setKasiTekiyouKms(kasiTekiyouKms);
            furikaeDenpyouPage.setKaritekiyouKms(kariTekiyouKms);
            furikaeDenpyouPage.setKjKasiTekiyouKms(kjKasiTekiyouKms);
            furikaeDenpyouPage.setKjKariTekiyouKms(kjKariTekiyouKms);
            furikaeDenpyouPage.setKasiGoukeiGk(kasiGoukeiGk);
            furikaeDenpyouPage.setKariGoukeiGk(kariGoukeiGk);

            if (N == pageCount-1) {

                furikaeDenpyouPage.setKjKariKurikosiGkHyjKm(GOUKEI_INJI);
                furikaeDenpyouPage.setKjKasiKurikosiGkHyjKm(GOUKEI_INJI);

                furikaeDenpyouPage.setGoukeiFlg(true);
            }
            else {

                furikaeDenpyouPage.setKjKariKurikosiGkHyjKm(KURIKOSI_INJI);
                furikaeDenpyouPage.setKjKasiKurikosiGkHyjKm(KURIKOSI_INJI);

                kasiKinGk = kasiGoukeiGk;
                kariKinGk = kariGoukeiGk;

                furikaeDenpyouPage.setGoukeiFlg(false);
            }

            furikaeDenpyouPageLst.add(furikaeDenpyouPage);
        }

        logger.debug("△ 振替伝票情報 振替伝票ページ情報リスト生成 終了");

        return furikaeDenpyouPageLst;
    }

    public void setFurikaeDenEntity(FurikaeDenpyouParam pFurikaeDenpyouParam, FurikaeDenpyouPage pFurikaeDenpyouPage) {

        logger.debug("▽ 振替伝票情報 振替伝票エンティティ設定 開始");

        C_SyoruiCdKbn kyoutuuSyoruicd = getKyoutuuSyoruicd(C_SeiHukuKbn.SEI);

        pFurikaeDenpyouParam.setZtykytkmksyoruicd(kyoutuuSyoruicd.getValue().toUpperCase());
        pFurikaeDenpyouParam.setZtykytkmktyouhyousksymd(String.valueOf(syoriYmd));
        pFurikaeDenpyouParam.setZtykytkmksystemkbn(pFurikaeDenpyouPage.getSystemKbn());
        pFurikaeDenpyouParam.setZtykytkmktorihikino(pFurikaeDenpyouPage.getTorihikiNo());
        pFurikaeDenpyouParam.setZtykytkmktorihikinoedano(String.valueOf(pFurikaeDenpyouPage.getPageNo()));
        pFurikaeDenpyouParam.setZtykytkmkseifukukbn(C_SeiHukuKbn.SEI.getValue());
        pFurikaeDenpyouParam.setZtykytkmkfuridenhassoukbn(pFurikaeDenpyouPage.getHuridenYouHassouKbn().getValue());
        pFurikaeDenpyouParam.setZtykytkmkyobi("");
        pFurikaeDenpyouParam.setZtysystemkbn(pFurikaeDenpyouPage.getSystemKbn());
        pFurikaeDenpyouParam.setZtytorihikinoc8(pFurikaeDenpyouPage.getTorihikiNo());
        pFurikaeDenpyouParam.setZtytorihikinoedano(String.valueOf(pFurikaeDenpyouPage.getPageNo()));
        pFurikaeDenpyouParam.setZtykjhikaeinjikm("");
        pFurikaeDenpyouParam.setZtytorihikiymdgengokbn(pFurikaeDenpyouPage.getTorihikiYmdGengoKbn());
        pFurikaeDenpyouParam.setZtytorihikinen(String.valueOf(pFurikaeDenpyouPage.getTorihikiNen()));
        pFurikaeDenpyouParam.setZtytorihikituki(String.valueOf(pFurikaeDenpyouPage.getTorihikiTsuki()));
        pFurikaeDenpyouParam.setZtytorihikibi(String.valueOf(pFurikaeDenpyouPage.getTorihikiBi()));
        pFurikaeDenpyouParam.setZtykanjyoukbn(C_KanjyouKbn.BLNK.getValue());
        pFurikaeDenpyouParam.setZtykanjyoukbnnm("");
        pFurikaeDenpyouParam.setZtykjtantoukanm(pFurikaeDenpyouPage.getKjTantoukaNm());
        pFurikaeDenpyouParam.setZtykjtantoucd(pFurikaeDenpyouPage.getKjTantoukaCd());
        pFurikaeDenpyouParam.setZtykjsystemnm(pFurikaeDenpyouPage.getKjSystemNm());
        pFurikaeDenpyouParam.setZtykarikurikosikingaku(String.valueOf(pFurikaeDenpyouPage.getKariKurikosiGk()));
        pFurikaeDenpyouParam.setZtykasikurikosikingaku(String.valueOf(pFurikaeDenpyouPage.getKasiKurikosiGk()));
        pFurikaeDenpyouParam.setZtydenpyoukbnnm("");
        pFurikaeDenpyouParam.setZtykjkarikurikosigkhyjkm(pFurikaeDenpyouPage.getKjKariKurikosiGkHyjKm());
        String karikataGoukeiGk = String.valueOf(pFurikaeDenpyouPage.getKariGoukeiGk());
        if(pFurikaeDenpyouPage.isGoukeiFlg()) {
            karikataGoukeiGk = YEN_KIGOU + karikataGoukeiGk;
        }
        pFurikaeDenpyouParam.setZtykarikurikosigkkingaku(karikataGoukeiGk);
        pFurikaeDenpyouParam.setZtykjkasikurikosigkhyjkm(pFurikaeDenpyouPage.getKjKasiKurikosiGkHyjKm());
        String kasikataGoukeiGk = String.valueOf(pFurikaeDenpyouPage.getKasiGoukeiGk());
        if(pFurikaeDenpyouPage.isGoukeiFlg()) {
            kasikataGoukeiGk = YEN_KIGOU + kasikataGoukeiGk;
        }
        pFurikaeDenpyouParam.setZtykasikurikosigkkingaku(kasikataGoukeiGk);
        pFurikaeDenpyouParam.setZtykjtekiyou1(kjTekiyou1);
        pFurikaeDenpyouParam.setZtykjtekiyou2(kjTekiyou2);
        pFurikaeDenpyouParam.setZtykjtekiyou3(kjTekiyou3);
        pFurikaeDenpyouParam.setZtykjkarikanjyoukamokunm1(pFurikaeDenpyouPage.getKjKariKanjoukamokuNms()[0]);
        pFurikaeDenpyouParam.setZtykjkasikanjyoukamokunm1(pFurikaeDenpyouPage.getKjKasiKanjoukamokuNms()[0]);
        pFurikaeDenpyouParam.setZtykarikingaku1(String.valueOf(pFurikaeDenpyouPage.getKariGks()[0]));
        pFurikaeDenpyouParam.setZtykasikingaku1(String.valueOf(pFurikaeDenpyouPage.getKasiGks()[0]));
        pFurikaeDenpyouParam.setZtykaritekiyoukm1(pFurikaeDenpyouPage.getKariTekiyouKms()[0]);
        pFurikaeDenpyouParam.setZtykasitekiyoukm1(pFurikaeDenpyouPage.getKasiTekiyouKms()[0]);
        pFurikaeDenpyouParam.setZtykjkaritekiyoukm1(pFurikaeDenpyouPage.getKjKariTekiyouKms()[0]);
        pFurikaeDenpyouParam.setZtykjkasitekiyoukm1(pFurikaeDenpyouPage.getKjKasiTekiyouKms()[0]);
        pFurikaeDenpyouParam.setZtykjkarikanjyoukamokunm2(pFurikaeDenpyouPage.getKjKariKanjoukamokuNms()[1]);
        pFurikaeDenpyouParam.setZtykjkasikanjyoukamokunm2(pFurikaeDenpyouPage.getKjKasiKanjoukamokuNms()[1]);
        pFurikaeDenpyouParam.setZtykarikingaku2(String.valueOf(pFurikaeDenpyouPage.getKariGks()[1]));
        pFurikaeDenpyouParam.setZtykasikingaku2(String.valueOf(pFurikaeDenpyouPage.getKasiGks()[1]));
        pFurikaeDenpyouParam.setZtykaritekiyoukm2(pFurikaeDenpyouPage.getKariTekiyouKms()[1]);
        pFurikaeDenpyouParam.setZtykasitekiyoukm2(pFurikaeDenpyouPage.getKasiTekiyouKms()[1]);
        pFurikaeDenpyouParam.setZtykjkaritekiyoukm2(pFurikaeDenpyouPage.getKjKariTekiyouKms()[1]);
        pFurikaeDenpyouParam.setZtykjkasitekiyoukm2(pFurikaeDenpyouPage.getKjKasiTekiyouKms()[1]);
        pFurikaeDenpyouParam.setZtykjkarikanjyoukamokunm3(pFurikaeDenpyouPage.getKjKariKanjoukamokuNms()[2]);
        pFurikaeDenpyouParam.setZtykjkasikanjyoukamokunm3(pFurikaeDenpyouPage.getKjKasiKanjoukamokuNms()[2]);
        pFurikaeDenpyouParam.setZtykarikingaku3(String.valueOf(pFurikaeDenpyouPage.getKariGks()[2]));
        pFurikaeDenpyouParam.setZtykasikingaku3(String.valueOf(pFurikaeDenpyouPage.getKasiGks()[2]));
        pFurikaeDenpyouParam.setZtykaritekiyoukm3(pFurikaeDenpyouPage.getKariTekiyouKms()[2]);
        pFurikaeDenpyouParam.setZtykasitekiyoukm3(pFurikaeDenpyouPage.getKasiTekiyouKms()[2]);
        pFurikaeDenpyouParam.setZtykjkaritekiyoukm3(pFurikaeDenpyouPage.getKjKariTekiyouKms()[2]);
        pFurikaeDenpyouParam.setZtykjkasitekiyoukm3(pFurikaeDenpyouPage.getKjKasiTekiyouKms()[2]);
        pFurikaeDenpyouParam.setZtykjkarikanjyoukamokunm4(pFurikaeDenpyouPage.getKjKariKanjoukamokuNms()[3]);
        pFurikaeDenpyouParam.setZtykjkasikanjyoukamokunm4(pFurikaeDenpyouPage.getKjKasiKanjoukamokuNms()[3]);
        pFurikaeDenpyouParam.setZtykarikingaku4(String.valueOf(pFurikaeDenpyouPage.getKariGks()[3]));
        pFurikaeDenpyouParam.setZtykasikingaku4(String.valueOf(pFurikaeDenpyouPage.getKasiGks()[3]));
        pFurikaeDenpyouParam.setZtykaritekiyoukm4(pFurikaeDenpyouPage.getKariTekiyouKms()[3]);
        pFurikaeDenpyouParam.setZtykasitekiyoukm4(pFurikaeDenpyouPage.getKasiTekiyouKms()[3]);
        pFurikaeDenpyouParam.setZtykjkaritekiyoukm4(pFurikaeDenpyouPage.getKjKariTekiyouKms()[3]);
        pFurikaeDenpyouParam.setZtykjkasitekiyoukm4(pFurikaeDenpyouPage.getKjKasiTekiyouKms()[3]);

        logger.debug("△ 振替伝票情報 振替伝票エンティティ設定 終了");
    }

    public void setFurikaeDenHikaEntity(FurikaeDenpyouParam pFurikaeDenpyouParam, FurikaeDenpyouPage pFurikaeDenpyouPage) {

        logger.debug("▽ 振替伝票情報 振替伝票（控）エンティティ設定 開始");

        C_SyoruiCdKbn kyoutuuSyoruicd = getKyoutuuSyoruicd(C_SeiHukuKbn.HUKU);

        pFurikaeDenpyouParam.setZtykytkmksyoruicd(kyoutuuSyoruicd.getValue().toUpperCase());
        pFurikaeDenpyouParam.setZtykytkmktyouhyousksymd(String.valueOf(syoriYmd));
        pFurikaeDenpyouParam.setZtykytkmksystemkbn(pFurikaeDenpyouPage.getSystemKbn());
        pFurikaeDenpyouParam.setZtykytkmktorihikino(pFurikaeDenpyouPage.getTorihikiNo());
        pFurikaeDenpyouParam.setZtykytkmktorihikinoedano(String.valueOf(pFurikaeDenpyouPage.getPageNo()));
        pFurikaeDenpyouParam.setZtykytkmkseifukukbn(C_SeiHukuKbn.HUKU.getValue());
        pFurikaeDenpyouParam.setZtykytkmkfuridenhassoukbn(pFurikaeDenpyouPage.getHuridenYouHassouKbn().getValue());
        pFurikaeDenpyouParam.setZtykytkmkyobi("");
        pFurikaeDenpyouParam.setZtysystemkbn(pFurikaeDenpyouPage.getSystemKbn());
        pFurikaeDenpyouParam.setZtytorihikinoc8(pFurikaeDenpyouPage.getTorihikiNo());
        pFurikaeDenpyouParam.setZtytorihikinoedano(String.valueOf(pFurikaeDenpyouPage.getPageNo()));
        pFurikaeDenpyouParam.setZtykjhikaeinjikm(HURIDENPYOU_HIKAE_INJI);
        pFurikaeDenpyouParam.setZtytorihikiymdgengokbn(pFurikaeDenpyouPage.getTorihikiYmdGengoKbn());
        pFurikaeDenpyouParam.setZtytorihikinen(String.valueOf(pFurikaeDenpyouPage.getTorihikiNen()));
        pFurikaeDenpyouParam.setZtytorihikituki(String.valueOf(pFurikaeDenpyouPage.getTorihikiTsuki()));
        pFurikaeDenpyouParam.setZtytorihikibi(String.valueOf(pFurikaeDenpyouPage.getTorihikiBi()));
        pFurikaeDenpyouParam.setZtykanjyoukbn(C_KanjyouKbn.BLNK.getValue());
        pFurikaeDenpyouParam.setZtykanjyoukbnnm("");
        pFurikaeDenpyouParam.setZtykjtantoukanm(pFurikaeDenpyouPage.getKjTantoukaNm());
        pFurikaeDenpyouParam.setZtykjtantoucd(pFurikaeDenpyouPage.getKjTantoukaCd());
        pFurikaeDenpyouParam.setZtykjsystemnm(pFurikaeDenpyouPage.getKjSystemNm());
        pFurikaeDenpyouParam.setZtykarikurikosikingaku(String.valueOf(pFurikaeDenpyouPage.getKariKurikosiGk()));
        pFurikaeDenpyouParam.setZtykasikurikosikingaku(String.valueOf(pFurikaeDenpyouPage.getKasiKurikosiGk()));
        pFurikaeDenpyouParam.setZtydenpyoukbnnm("");
        pFurikaeDenpyouParam.setZtykjkarikurikosigkhyjkm(pFurikaeDenpyouPage.getKjKariKurikosiGkHyjKm());
        String karikataGoukeiGk = String.valueOf(pFurikaeDenpyouPage.getKariGoukeiGk());
        if(pFurikaeDenpyouPage.isGoukeiFlg()) {
            karikataGoukeiGk = YEN_KIGOU + karikataGoukeiGk;
        }
        pFurikaeDenpyouParam.setZtykarikurikosigkkingaku(karikataGoukeiGk);
        pFurikaeDenpyouParam.setZtykjkasikurikosigkhyjkm(pFurikaeDenpyouPage.getKjKasiKurikosiGkHyjKm());
        String kasikataGoukeiGk = String.valueOf(pFurikaeDenpyouPage.getKasiGoukeiGk());
        if(pFurikaeDenpyouPage.isGoukeiFlg()) {
            kasikataGoukeiGk = YEN_KIGOU + kasikataGoukeiGk;
        }
        pFurikaeDenpyouParam.setZtykasikurikosigkkingaku(kasikataGoukeiGk);
        pFurikaeDenpyouParam.setZtykjtekiyou1(kjTekiyouHikae1);
        pFurikaeDenpyouParam.setZtykjtekiyou2(kjTekiyouHikae2);
        pFurikaeDenpyouParam.setZtykjtekiyou3(kjTekiyouHikae3);
        pFurikaeDenpyouParam.setZtykjkarikanjyoukamokunm1(pFurikaeDenpyouPage.getKjKariKanjoukamokuNms()[0]);
        pFurikaeDenpyouParam.setZtykjkasikanjyoukamokunm1(pFurikaeDenpyouPage.getKjKasiKanjoukamokuNms()[0]);
        pFurikaeDenpyouParam.setZtykarikingaku1(String.valueOf(pFurikaeDenpyouPage.getKariGks()[0]));
        pFurikaeDenpyouParam.setZtykasikingaku1(String.valueOf(pFurikaeDenpyouPage.getKasiGks()[0]));
        pFurikaeDenpyouParam.setZtykaritekiyoukm1(pFurikaeDenpyouPage.getKariTekiyouKms()[0]);
        pFurikaeDenpyouParam.setZtykasitekiyoukm1(pFurikaeDenpyouPage.getKasiTekiyouKms()[0]);
        pFurikaeDenpyouParam.setZtykjkaritekiyoukm1(pFurikaeDenpyouPage.getKjKariTekiyouKms()[0]);
        pFurikaeDenpyouParam.setZtykjkasitekiyoukm1(pFurikaeDenpyouPage.getKjKasiTekiyouKms()[0]);
        pFurikaeDenpyouParam.setZtykjkarikanjyoukamokunm2(pFurikaeDenpyouPage.getKjKariKanjoukamokuNms()[1]);
        pFurikaeDenpyouParam.setZtykjkasikanjyoukamokunm2(pFurikaeDenpyouPage.getKjKasiKanjoukamokuNms()[1]);
        pFurikaeDenpyouParam.setZtykarikingaku2(String.valueOf(pFurikaeDenpyouPage.getKariGks()[1]));
        pFurikaeDenpyouParam.setZtykasikingaku2(String.valueOf(pFurikaeDenpyouPage.getKasiGks()[1]));
        pFurikaeDenpyouParam.setZtykaritekiyoukm2(pFurikaeDenpyouPage.getKariTekiyouKms()[1]);
        pFurikaeDenpyouParam.setZtykasitekiyoukm2(pFurikaeDenpyouPage.getKasiTekiyouKms()[1]);
        pFurikaeDenpyouParam.setZtykjkaritekiyoukm2(pFurikaeDenpyouPage.getKjKariTekiyouKms()[1]);
        pFurikaeDenpyouParam.setZtykjkasitekiyoukm2(pFurikaeDenpyouPage.getKjKasiTekiyouKms()[1]);
        pFurikaeDenpyouParam.setZtykjkarikanjyoukamokunm3(pFurikaeDenpyouPage.getKjKariKanjoukamokuNms()[2]);
        pFurikaeDenpyouParam.setZtykjkasikanjyoukamokunm3(pFurikaeDenpyouPage.getKjKasiKanjoukamokuNms()[2]);
        pFurikaeDenpyouParam.setZtykarikingaku3(String.valueOf(pFurikaeDenpyouPage.getKariGks()[2]));
        pFurikaeDenpyouParam.setZtykasikingaku3(String.valueOf(pFurikaeDenpyouPage.getKasiGks()[2]));
        pFurikaeDenpyouParam.setZtykaritekiyoukm3(pFurikaeDenpyouPage.getKariTekiyouKms()[2]);
        pFurikaeDenpyouParam.setZtykasitekiyoukm3(pFurikaeDenpyouPage.getKasiTekiyouKms()[2]);
        pFurikaeDenpyouParam.setZtykjkaritekiyoukm3(pFurikaeDenpyouPage.getKjKariTekiyouKms()[2]);
        pFurikaeDenpyouParam.setZtykjkasitekiyoukm3(pFurikaeDenpyouPage.getKjKasiTekiyouKms()[2]);
        pFurikaeDenpyouParam.setZtykjkarikanjyoukamokunm4(pFurikaeDenpyouPage.getKjKariKanjoukamokuNms()[3]);
        pFurikaeDenpyouParam.setZtykjkasikanjyoukamokunm4(pFurikaeDenpyouPage.getKjKasiKanjoukamokuNms()[3]);
        pFurikaeDenpyouParam.setZtykarikingaku4(String.valueOf(pFurikaeDenpyouPage.getKariGks()[3]));
        pFurikaeDenpyouParam.setZtykasikingaku4(String.valueOf(pFurikaeDenpyouPage.getKasiGks()[3]));
        pFurikaeDenpyouParam.setZtykaritekiyoukm4(pFurikaeDenpyouPage.getKariTekiyouKms()[3]);
        pFurikaeDenpyouParam.setZtykasitekiyoukm4(pFurikaeDenpyouPage.getKasiTekiyouKms()[3]);
        pFurikaeDenpyouParam.setZtykjkaritekiyoukm4(pFurikaeDenpyouPage.getKjKariTekiyouKms()[3]);
        pFurikaeDenpyouParam.setZtykjkasitekiyoukm4(pFurikaeDenpyouPage.getKjKasiTekiyouKms()[3]);

        logger.debug("△ 振替伝票情報 振替伝票（控）エンティティ設定 終了");
    }

    public String getInjiTrhkno(){

        logger.debug("▽ 振替伝票情報 印字用取引番号取得 開始");

        if (lastGroupDispFlg) {

            logger.debug("△ 振替伝票情報 印字用取引番号取得 終了");

            return torihikiNo + LAST_GROUP_HYOUJI;
        }

        logger.debug("△ 振替伝票情報 印字用取引番号取得 終了");

        return torihikiNo;
    }

    public C_SyoruiCdKbn getKyoutuuSyoruicd(C_SeiHukuKbn pSeiHukuKbn){

        logger.debug("▽ 振替伝票情報 共通項目書類コード取得 開始");

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;

        if (C_KeirisysKbn.FUHO.eq(keiriSysKbn)) {
            if (C_SeiHukuKbn.SEI.eq(pSeiHukuKbn)) {
                syoruiCdKbn = C_SyoruiCdKbn.CM_HURIDEN;
            }
            else if (C_SeiHukuKbn.HUKU.eq(pSeiHukuKbn)) {
                syoruiCdKbn = C_SyoruiCdKbn.CM_HURIDEN_HIKAE;
            }
        }
        else if (C_KeirisysKbn.SINKEIYAKU.eq(keiriSysKbn)) {
            if (C_SeiHukuKbn.SEI.eq(pSeiHukuKbn)) {
                syoruiCdKbn = C_SyoruiCdKbn.CM_SK_HURIDEN;
            }
            else if (C_SeiHukuKbn.HUKU.eq(pSeiHukuKbn)) {
                syoruiCdKbn = C_SyoruiCdKbn.CM_SK_HURIDEN_HIKAE;
            }
        }
        else if (C_KeirisysKbn.KESSANSINKEIYAKU.eq(keiriSysKbn)) {
            if (C_SeiHukuKbn.SEI.eq(pSeiHukuKbn)) {
                syoruiCdKbn = C_SyoruiCdKbn.SR_SK_KESSANHURIDEN;
            }
            else if (C_SeiHukuKbn.HUKU.eq(pSeiHukuKbn)) {
                syoruiCdKbn = C_SyoruiCdKbn.SR_SK_KESSANHURIDEN_HIKAE;
            }
        }

        logger.debug("△ 振替伝票情報 共通項目書類コード取得 終了");

        return syoruiCdKbn;
    }

    public C_HuridenYouHassouKbn getHuridenYouHassouKbn(String pTantouBusitucd){

        logger.debug("▽ 振替伝票情報 振替伝票用発送区分取得 開始");

        C_HuridenYouHassouKbn huridenYouHassouKbn = null;
        YuyuBizConfig yuyuBizConfig = YuyuBizConfig.getInstance();

        if (ZERO_THREEKETA.equals(pTantouBusitucd)) {
            if (C_KeirisysKbn.SINKEIYAKU.eq(keiriSysKbn) ||
                C_KeirisysKbn.KESSANSINKEIYAKU.eq(keiriSysKbn)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI3;
            }
            else {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI1;
            }
        }
        else {
            if (yuyuBizConfig.getHuridenyouhassoukbn1tantousitucd().equals(pTantouBusitucd)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI1;
            }
            else if (yuyuBizConfig.getHuridenyouhassoukbn2tantousitucd().equals(pTantouBusitucd)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI2;
            }
            else if (yuyuBizConfig.getHuridenyouhassoukbn3tantousitucd().equals(pTantouBusitucd)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI3;
            }
            else if (yuyuBizConfig.getHuridenyouhassoukbn4tantousitucd().equals(pTantouBusitucd)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI4;
            }
            else if (yuyuBizConfig.getHuridenyouhassoukbn5tantousitucd().equals(pTantouBusitucd)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI5;
            }
            else if (yuyuBizConfig.getHuridenyouhassoukbn6tantousitucd().equals(pTantouBusitucd)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI6;
            }
            else if (yuyuBizConfig.getHuridenyouhassoukbn7tantousitucd().equals(pTantouBusitucd)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI7;
            }
            else if (yuyuBizConfig.getHuridenyouhassoukbn8tantousitucd().equals(pTantouBusitucd)) {
                huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI8;
            }
            else {
                if (C_KeirisysKbn.SINKEIYAKU.eq(keiriSysKbn) ||
                    C_KeirisysKbn.KESSANSINKEIYAKU.eq(keiriSysKbn)) {
                    huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI3;
                }
                else {
                    huridenYouHassouKbn = C_HuridenYouHassouKbn.HASSOUSAKI1;
                }
            }
        }

        logger.debug("△ 振替伝票情報 振替伝票用発送区分取得 終了");

        return huridenYouHassouKbn;
    }
}
