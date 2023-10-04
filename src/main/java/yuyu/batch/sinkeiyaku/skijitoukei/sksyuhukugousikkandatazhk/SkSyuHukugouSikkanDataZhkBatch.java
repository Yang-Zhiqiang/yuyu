package yuyu.batch.sinkeiyaku.skijitoukei.sksyuhukugousikkandatazhk;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skijitoukei.sksyuhukugousikkandatazhk.dba.SkSyuHukugouSikkanDataZhkDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IjitoukeiHokensyuruiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KokutiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_SiinBunrui;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.HW_SyuHukugouSikkanZhkWk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約　医事統計　主契約複合疾患データ増幅
 */
public class SkSyuHukugouSikkanDataZhkBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkSyuHukugouSikkanDataZhkDao skSyuHukugouSikkanDataZhkDao;

    @Inject
    private BizDomManager bizDomManager;

    private long syoriCnt;

    private long kykCnt;

    private static final String [] SIINCDSYOKITI = { "0", "00", "000" };

    private static final String DAISIINCDBYOUSI = "1";

    private static final String TYUUSIINCDSONOTABYOUSI = "11";

    private static final String SYOUSIINCDSONOTA = "800";

    private static final String DAISIINCDSYOKITI = "0";

    private static final String TYUUSIINCDSYOKITI = "00";

    private static final String SYOUSIINCDSYOKITI = "000";

    private static final String BLANK = "";


    private String lastSyono = "";

    private static final int MAX_CNT = 100000;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }


    @Execute
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        deleteSyuHukugouSikkanZhkWk();

        syoriCnt = 0;
        kykCnt = 0;
        lastSyono = "0";

        boolean endFlg = false;

        while(endFlg == false){
            endFlg = insertSyuHukugouSikkanZhkWk(lastSyono, syoriYmd);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "処理対象契約",String.valueOf(kykCnt)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "増幅後データ",String.valueOf(syoriCnt)));


    }

    @Transactional
    void deleteSyuHukugouSikkanZhkWk(){
        skSyuHukugouSikkanDataZhkDao.deleteSyuHukugouSikkanDataZhk();
    }

    @Transactional
    boolean insertSyuHukugouSikkanZhkWk(String pSyono, BizDate pSyoriYmd){


        boolean endFlg = true;
        int tmpCnt = 0;
        BizDateMD lastDay = BizDateMD.valueOf("0331");
        BizDate syoriKijyunYmdFrom = BizDate.valueOf(pSyoriYmd.getYear() - 30, lastDay);
        BizDate syoriKijyunYmdTo = BizDate.valueOf(pSyoriYmd.getYear(), lastDay);

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        int sokuhouNendo = setKessanNensibi.exec(syoriKijyunYmdTo).getYear();

        try (EntityInserter<HW_SyuHukugouSikkanZhkWk> entityInserter = new EntityInserter<>();
            ExDBResults <HT_IjitoukeiMeisai> ijitoukeiMeisaiList = skSyuHukugouSikkanDataZhkDao.
                getIjitoukeiMeisaisBySyuHukugouSikkanDataZhkSyoriTaisyou(pSyono, syoriKijyunYmdFrom, syoriKijyunYmdTo); ) {
            for(HT_IjitoukeiMeisai ijitoukeiMeisai:ijitoukeiMeisaiList){
                int kykNendo =0;
                int maxHknNendo = 0;
                int minHknNendo = 0;
                int syoumetuHknNendo = 99;
                BizDate syoumetuYmd = ijitoukeiMeisai.getSyoumetuymd();
                BizDate kykYmd = ijitoukeiMeisai.getKykymd();

                kykNendo = setKessanNensibi.exec(kykYmd).getYear();

                int wkNeno = calcNendo2Keta(kykYmd, syoriKijyunYmdTo);

                if(wkNeno > 20){
                    maxHknNendo = 20;
                }else {
                    maxHknNendo = wkNeno;
                }

                minHknNendo = wkNeno - 10;

                if(minHknNendo <= 0){
                    minHknNendo = 1;
                }else if(minHknNendo > 20){
                    minHknNendo = 20;
                }

                if(syoumetuYmd != null){
                    if(BizDateUtil.compareYmd(syoumetuYmd,kykYmd)==BizDateUtil.COMPARE_LESSER){
                        syoumetuHknNendo = 1;
                    }else{
                        syoumetuHknNendo = calcNendo2Keta(kykYmd, syoumetuYmd);
                    }
                }

                if (syoumetuHknNendo < minHknNendo){
                    continue;
                }else if (syoumetuHknNendo < maxHknNendo){
                    maxHknNendo = syoumetuHknNendo;
                }

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(ijitoukeiMeisai.getSyouhncd(), ijitoukeiMeisai.getSyouhnsdno());

                for(int hknNendo = minHknNendo; hknNendo <= maxHknNendo ; hknNendo++){

                    BizNumber keikaN = BizNumber.valueOf(0);
                    int sibouN = 0;

                    boolean sokuhouFlg = false;
                    if(sokuhouNendo == (kykNendo + hknNendo - 1)){
                        sokuhouFlg = true;
                    }

                    if(syoumetuYmd != null){
                        if(syoumetuHknNendo == hknNendo){
                            if(ijitoukeiMeisai.getSymtgenincd().equals("415")||
                                ijitoukeiMeisai.getSymtgenincd().equals("425")||
                                ijitoukeiMeisai.getSymtgenincd().equals("435")||
                                ijitoukeiMeisai.getSymtgenincd().equals("505")){
                                keikaN = BizNumber.valueOf(1);
                                sibouN = 1;
                            }else{
                                int yuukouKknGessuu = calcKeikaGessuu(kykYmd, syoumetuYmd);

                                if(yuukouKknGessuu > 12 * (hknNendo - 1)){
                                    if(hknNendo == 1){
                                        keikaN = BizNumber.valueOf(yuukouKknGessuu).divide(12, 6, RoundingMode.HALF_UP);
                                    }else{
                                        if(sokuhouFlg){
                                            keikaN = BizNumber.valueOf(0.25);
                                        }else{
                                            keikaN = BizNumber.valueOf(0.5);
                                        }
                                    }
                                }
                            }
                        }else if(syoumetuHknNendo > hknNendo){
                            keikaN = BizNumber.valueOf(1);
                        }
                    }else{
                        if(sokuhouFlg){
                            if(hknNendo == 1){
                                keikaN = calcKeikaN(kykNendo, kykYmd);
                            }else{
                                keikaN = BizNumber.valueOf(0.5);
                            }
                        }else{
                            keikaN = BizNumber.valueOf(1);
                        }
                    }

                    BizDate kijyunYmd = null;
                    BizCurrency wkSibouS;
                    BizNumber sibouSYen;
                    BizNumber sibouSManyen;

                    GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);

                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                    C_Tuukasyu imustiyusbusTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(ijitoukeiMeisai.getImustiyusbus().getType());

                    if (!C_Tuukasyu.JPY.eq(imustiyusbusTuukasyu)){
                        if(syoumetuYmd != null && hknNendo == syoumetuHknNendo){
                            kijyunYmd = syoumetuYmd;
                        }else{
                            kijyunYmd = kykYmd.addYears(hknNendo - 1).getBusinessDay(CHolidayAdjustingMode.NONE);
                        }
                        wkSibouS = getKiteiCheckYenkansangk.exec(kijyunYmd, ijitoukeiMeisai.getImustiyusbus(), ijitoukeiMeisai.getKyktuukasyu());
                        sibouSYen = BizNumber.valueOf(new BigDecimal(wkSibouS.toString()));

                        sibouSManyen = sibouSYen.divide(10000).round(0, RoundingMode.HALF_UP);
                    }
                    else {
                        sibouSManyen = BizNumber.valueOf(new BigDecimal(ijitoukeiMeisai.getImustiyusbusmanen().toString()));
                    }


                    BizNumber keikaS = sibouSManyen.multiply(keikaN).round(5, RoundingMode.HALF_UP);
                    BizNumber sibouS = sibouSManyen.multiply(sibouN);


                    String jisituhosyouSRank = BLANK;
                    BizCurrency wkJisituhosyouSKyktuuka;
                    BizNumber jissituhosyouSRankGkYen;
                    BizNumber jissituhosyouSRankGkManyen;
                    BizCurrency wkJissituhosyouSRankGkYen;

                    if (C_Hrkkaisuu.ITIJI.eq(ijitoukeiMeisai.getHrkkaisuu())){

                        wkJisituhosyouSKyktuuka = ijitoukeiMeisai.getImustiyusbus().subtract(ijitoukeiMeisai.getSyutkp());

                    }
                    else {
                        wkJisituhosyouSKyktuuka = ijitoukeiMeisai.getImustiyusbus();
                    }

                    if(wkJisituhosyouSKyktuuka.compareTo(BizCurrency.valueOf(0, ijitoukeiMeisai.getImustiyusbus().getType())) < 0){
                        jisituhosyouSRank = "01";
                    }else if(wkJisituhosyouSKyktuuka.compareTo(BizCurrency.valueOf(0, ijitoukeiMeisai.getImustiyusbus().getType())) == 0){
                        jisituhosyouSRank = "02";
                    }else{
                        C_Tuukasyu wkJisituhosyouSTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(wkJisituhosyouSKyktuuka.getType());

                        if (!C_Tuukasyu.JPY.eq(wkJisituhosyouSTuukasyu)){
                            wkJissituhosyouSRankGkYen = getKiteiCheckYenkansangk.exec(
                                kijyunYmd, wkJisituhosyouSKyktuuka, ijitoukeiMeisai.getKyktuukasyu());
                            jissituhosyouSRankGkYen = BizNumber.valueOf(new BigDecimal(wkJissituhosyouSRankGkYen.toString()));
                            jissituhosyouSRankGkManyen = jissituhosyouSRankGkYen.divide(10000).round(0, RoundingMode.HALF_UP);
                        }
                        else {
                            jissituhosyouSRankGkManyen = BizNumber.valueOf(new BigDecimal(ijitoukeiMeisai.getImustiyusbusmanen().toString()));
                        }
                        jisituhosyouSRank = convJisituhosyouSRank(jissituhosyouSRankGkManyen);

                    }

                    String htDaisiinCd = BLANK;
                    String htTyuuSiinCd = BLANK;
                    String siincd = ijitoukeiMeisai.getSiincd();

                    if(syoumetuYmd != null && hknNendo == syoumetuHknNendo){

                        String symtgenincd1keta = BLANK;

                        if (!BizUtil.isBlank(ijitoukeiMeisai.getSymtgenincd())) {
                            symtgenincd1keta = ijitoukeiMeisai.getSymtgenincd().substring(0, 1);
                        }

                        if (BLANK.equals(siincd) || Arrays.asList(SIINCDSYOKITI).contains(siincd)) {
                            if ("4".equals(symtgenincd1keta) ||
                                "5".equals(symtgenincd1keta) ||
                                "9".equals(symtgenincd1keta)) {

                                htDaisiinCd = DAISIINCDBYOUSI;
                                htTyuuSiinCd = TYUUSIINCDSONOTABYOUSI;
                                siincd = SYOUSIINCDSONOTA;

                            }else{
                                htDaisiinCd = DAISIINCDSYOKITI;
                                htTyuuSiinCd = TYUUSIINCDSYOKITI;
                                siincd = SYOUSIINCDSYOKITI;
                            }
                        }else{
                            HM_SiinBunrui siinBunrui = ijitoukeiMeisai.getSiinBunrui();
                            if (siinBunrui != null) {
                                htDaisiinCd = siinBunrui.getDaisiincd();
                                htTyuuSiinCd = siinBunrui.getTyuusiincd();
                            }
                            else {
                                htDaisiinCd = DAISIINCDBYOUSI;
                                htTyuuSiinCd = TYUUSIINCDSONOTABYOUSI;
                            }
                        }
                    }else{
                        htDaisiinCd = DAISIINCDSYOKITI;
                        htTyuuSiinCd = TYUUSIINCDSYOKITI;
                        siincd = SYOUSIINCDSYOKITI;
                    }

                    HW_SyuHukugouSikkanZhkWk syuHukugouSikkanZhkWk = new HW_SyuHukugouSikkanZhkWk();

                    syuHukugouSikkanZhkWk.setSyono(ijitoukeiMeisai.getSyono());

                    syuHukugouSikkanZhkWk.setHknnendo(hknNendo);

                    syuHukugouSikkanZhkWk.setIjitoukeidaihyousyurui(
                        syouhnZokusei.getIjitoukeihokensyuruikbn().getContent(C_IjitoukeiHokensyuruiKbn.PATTERN_DAIHYOUSYURUI));
                    syuHukugouSikkanZhkWk.setKyknendo(String.valueOf(kykNendo));

                    syuHukugouSikkanZhkWk.setHhknsei(convHhknsei(ijitoukeiMeisai.getHhknsei()));

                    syuHukugouSikkanZhkWk.setKykage(ijitoukeiMeisai.getHhknnen());

                    syuHukugouSikkanZhkWk.setToutatunenrei(ijitoukeiMeisai.getHhknnen() + hknNendo - 1);

                    syuHukugouSikkanZhkWk.setAtukaibetu(convAtukaibetu(ijitoukeiMeisai.getSntkhoukbn()));

                    syuHukugouSikkanZhkWk.setIjitoukeisinsahouhou(
                        convIjitoukeisinsahouhou(ijitoukeiMeisai.getSntkhoukbn(), ijitoukeiMeisai.getKokutikbn()));

                    syuHukugouSikkanZhkWk.setKetteikekkaa(convKetteikekkaa(ijitoukeiMeisai.getDakuhiktkekkacd()));

                    syuHukugouSikkanZhkWk.setSibousrank(convSibouSRank(sibouSManyen));

                    syuHukugouSikkanZhkWk.setJissituhosyousrank(jisituhosyouSRank);

                    syuHukugouSikkanZhkWk.setSirajikykkbn(ijitoukeiMeisai.getSirajikykkbn());

                    syuHukugouSikkanZhkWk.setHrkhouhoukbn(convHrkhouhoukbn(
                        ijitoukeiMeisai.getHrkkaisuu(), ijitoukeiMeisai.getTikiktbrisyuruikbn(), ijitoukeiMeisai.getHrkkeiro()));

                    syuHukugouSikkanZhkWk.setIjitoukeihokensyuruikbn(syouhnZokusei.getIjitoukeihokensyuruikbn());

                    syuHukugouSikkanZhkWk.setDaisiincd(htDaisiinCd);

                    syuHukugouSikkanZhkWk.setTyuusiincd(htTyuuSiinCd);

                    syuHukugouSikkanZhkWk.setSiincd(siincd);

                    syuHukugouSikkanZhkWk.setNenreihousikikbn("2");

                    syuHukugouSikkanZhkWk.setHhknsykgycd(ijitoukeiMeisai.getHhknsykgycd());

                    syuHukugouSikkanZhkWk.setHhkntodouhukencd(ijitoukeiMeisai.getHhkntodouhukencd());

                    syuHukugouSikkanZhkWk.setBotaisisyaeigyouhonbu(ijitoukeiMeisai.getAatsukaishasoshikicd().substring(0,3));

                    syuHukugouSikkanZhkWk.setSisyaeigyoubu(ijitoukeiMeisai.getAatsukaishasoshikicd().substring(0,3));

                    syuHukugouSikkanZhkWk.setAatsukaishasoshikicd(ijitoukeiMeisai.getAatsukaishasoshikicd());

                    syuHukugouSikkanZhkWk.setHhknnensyuukbn(ijitoukeiMeisai.getHhknnensyuukbn());

                    syuHukugouSikkanZhkWk.setHanbaikeirokbn(convHanbaikeirokbn(ijitoukeiMeisai.getSkeijimukbn()));

                    syuHukugouSikkanZhkWk.setOyadrtencd(ijitoukeiMeisai.getOyadrtencd());

                    syuHukugouSikkanZhkWk.setTratkiagcd(ijitoukeiMeisai.getTratkiagcd());

                    syuHukugouSikkanZhkWk.setBosyuudairitenatkikeitaikbn(ijitoukeiMeisai.getBosyuudairitenatkikeitaikbn());

                    syuHukugouSikkanZhkWk.setKyktuukasyu(ijitoukeiMeisai.getKyktuukasyu());

                    syuHukugouSikkanZhkWk.setHrktuukasyu(ijitoukeiMeisai.getHrktuukasyu());

                    syuHukugouSikkanZhkWk.setSyouhncd(ijitoukeiMeisai.getSyouhncd());

                    syuHukugouSikkanZhkWk.setInitsbjiyensitihsytkhukaumu(
                        convTkhukaumu(ijitoukeiMeisai.getSyksbyensitihsyutkhkkbn()));

                    syuHukugouSikkanZhkWk.setJyudkaigomeharaitkhukaumu(
                        convTkhukaumu(ijitoukeiMeisai.getJyudkaigomehrtkhkkbn()));

                    syuHukugouSikkanZhkWk.setIjitoukeizennoukbn(ijitoukeiMeisai.getIjitoukeizennoukbn());

                    syuHukugouSikkanZhkWk.setDai1hknkkn(ijitoukeiMeisai.getDai1hknkkn());

                    syuHukugouSikkanZhkWk.setIjitoukeitikshrtkykkbn(ijitoukeiMeisai.getIjitoukeitikshrtkykkbn());

                    syuHukugouSikkanZhkWk.setIjitoukeikeikan(keikaN);

                    syuHukugouSikkanZhkWk.setIjitoukeisiboun(sibouN);

                    syuHukugouSikkanZhkWk.setIjitoukeikeikas(keikaS);

                    syuHukugouSikkanZhkWk.setIjitoukeisibous(Integer.parseInt(sibouS.toString()));

                    BizPropertyInitializer.initialize(syuHukugouSikkanZhkWk);

                    entityInserter.add(syuHukugouSikkanZhkWk);

                    syoriCnt++;
                    tmpCnt++;
                }
                kykCnt++;

                if(tmpCnt > MAX_CNT){
                    lastSyono = ijitoukeiMeisai.getSyono();
                    endFlg = false;
                    break;
                }
            }
        }
        return endFlg;
    }

    private BizDateSpan calcBizDateSpan(BizDate pDateFrom, BizDate pDateTo){

        int pDateFromDay = pDateFrom.getDay();
        int pDateToDay = pDateTo.getDay();
        int pDateFromDaysInMonth = pDateFrom.getBizDateYM().getDaysInMonth();
        int pDateToDaysInMonth = pDateTo.getBizDateYM().getDaysInMonth();

        BizDate pDateFromForCalcDif = pDateFrom;

        if (pDateToDaysInMonth < pDateFromDay &&
            (pDateFromDay == pDateFromDaysInMonth && pDateToDay == pDateToDaysInMonth)) {

            pDateFromForCalcDif = BizDate.valueOf(pDateFromForCalcDif.getBizDateYM(), pDateToDay);
        }

        BizDateSpan span = BizDateUtil.calcDifference(pDateFromForCalcDif, pDateTo);

        return span;
    }

    private int calcNendo2Keta(BizDate pDateFrom, BizDate pDateTo){

        int nendo2Keta = 0;

        BizDateSpan span = calcBizDateSpan(pDateFrom, pDateTo);

        int spanY = span.getYears();

        nendo2Keta = spanY + 1;

        return nendo2Keta;
    }

    private int calcKeikaGessuu(BizDate pDateFrom, BizDate pDateTo){

        BizDateSpan span = calcBizDateSpan(pDateFrom, pDateTo);
        int spanY = span.getYears();
        int spanM = span.getMonths();

        int keikaGessuu = (spanY * 12) + spanM;

        if(keikaGessuu <= 0){
            keikaGessuu = 1;
        }

        return keikaGessuu;
    }

    private BizNumber calcKeikaN(int pKykNendo, BizDate pKykYmd){

        BizDateMD lastDay = BizDateMD.valueOf("0331");
        BizDate pKykNendoMatu = BizDate.valueOf(pKykNendo + 1, lastDay);

        BizNumber keikaGessuu = BizNumber.valueOf(calcKeikaGessuu(pKykYmd, pKykNendoMatu));

        BizNumber keikaN = keikaGessuu.divide(12, 6, RoundingMode.HALF_UP);

        return keikaN;
    }

    private C_Hhknsei convHhknsei(C_Hhknsei pHhknsei){
        if(pHhknsei.eq(C_Hhknsei.FEMALE)){
            return C_Hhknsei.FEMALE;
        }
        return C_Hhknsei.MALE;
    }

    private String convAtukaibetu(C_SntkhouKbn pSntkhouKbn){
        if(pSntkhouKbn.eq(C_SntkhouKbn.KKT)||
            pSntkhouKbn.eq(C_SntkhouKbn.SYOKUGYOU)){
            return "2";
        }else if(pSntkhouKbn.eq(C_SntkhouKbn.NONE)){
            return "3";
        }
        return BLANK;
    }

    private String convIjitoukeisinsahouhou(C_SntkhouKbn pSntkhouKbn, C_KokutiKbn pKokutiKbn){
        if(pSntkhouKbn.eq(C_SntkhouKbn.NONE)){
            return "17";
        }else if(pSntkhouKbn.eq(C_SntkhouKbn.SYOKUGYOU)){
            return "12";
        }else if(pSntkhouKbn.eq(C_SntkhouKbn.KKT)){
            if(pKokutiKbn.eq(C_KokutiKbn.KANIKOKUTI)){
                return "10";
            }
            return "08";
        }
        return BLANK;
    }

    private String convKetteikekkaa(C_Ketkekkacd pKetkekkacd){
        if(pKetkekkacd.eq(C_Ketkekkacd.MUJYOUKEN)){
            return "1";
        }else if(pKetkekkacd.eq(C_Ketkekkacd.GENKAITAI_SYOUDAKU)){
            return "3";
        }
        return BLANK;
    }

    private String convHrkhouhoukbn(C_Hrkkaisuu pHrkkaisuu, C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn, C_Hrkkeiro pC_Hrkkeiro){

        if(C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)){
            return "1";
        }
        else if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)){
            if ((C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pTkiktbrisyuruiKbn))||
                (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pTkiktbrisyuruiKbn))){
                return "3";
            }

            if (C_Hrkkeiro.CREDIT.eq(pC_Hrkkeiro)){
                return "6";
            }

            return "5";

        }
        else if ((C_Hrkkaisuu.HALFY.eq(pHrkkaisuu)) || (C_Hrkkaisuu.NEN.eq(pHrkkaisuu))){
            return "3";
        }
        else {
            return "0";
        }
    }

    private String convHanbaikeirokbn(C_SkeijimuKbn pSkeijimuKbn){
        if(pSkeijimuKbn.eq(C_SkeijimuKbn.NIHONYUUBIN)||
            pSkeijimuKbn.eq(C_SkeijimuKbn.KANPOSEIMEI)){
            return "1";
        }else if(pSkeijimuKbn.eq(C_SkeijimuKbn.TIGINSINKIN)||
            pSkeijimuKbn.eq(C_SkeijimuKbn.SMBC)||
            pSkeijimuKbn.eq(C_SkeijimuKbn.SMTB)||
            pSkeijimuKbn.eq(C_SkeijimuKbn.MIZUHO)||
            pSkeijimuKbn.eq(C_SkeijimuKbn.YUUTYO)){
            return "3";
        }else if(pSkeijimuKbn.eq(C_SkeijimuKbn.SHOP)){
            return "5";
        }
        return "0";
    }

    private C_UmuKbn convTkhukaumu(C_Tkhukaumu pTkhukaumu){
        if(pTkhukaumu.eq(C_Tkhukaumu.HUKA)){
            return C_UmuKbn.ARI;
        }
        return C_UmuKbn.NONE;
    }

    private String convSibouSRank(BizNumber pSibouS){

        int wkSibouSMan = Integer.parseInt(pSibouS.toString());
        String sibouSRank = "";

        if (100 >= wkSibouSMan) {
            sibouSRank = "01";
        }
        else if (100 < wkSibouSMan && 300 >= wkSibouSMan) {
            sibouSRank = "02";
        }
        else if (300 < wkSibouSMan && 500 >= wkSibouSMan) {
            sibouSRank = "03";
        }
        else if (500 < wkSibouSMan && 800 > wkSibouSMan) {
            sibouSRank = "04";
        }
        else if (800 == wkSibouSMan) {
            sibouSRank = "05";
        }
        else if (800 < wkSibouSMan && 1000 > wkSibouSMan) {
            sibouSRank = "06";
        }
        else if (1000 == wkSibouSMan) {
            sibouSRank = "07";
        }
        else if (1000 < wkSibouSMan && 1200 >= wkSibouSMan) {
            sibouSRank = "08";
        }
        else if (1200 < wkSibouSMan && 1500 >= wkSibouSMan) {
            sibouSRank = "09";
        }
        else if (1500 < wkSibouSMan && 2000 >= wkSibouSMan) {
            sibouSRank = "10";
        }
        else if (2000 < wkSibouSMan && 3000 > wkSibouSMan) {
            sibouSRank = "11";
        }
        else if (3000 == wkSibouSMan) {
            sibouSRank = "12";
        }
        else if (3000 < wkSibouSMan && 4000 >= wkSibouSMan) {
            sibouSRank = "13";
        }
        else if (4000 < wkSibouSMan && 5000 > wkSibouSMan) {
            sibouSRank = "14";
        }
        else if (5000 == wkSibouSMan) {
            sibouSRank = "15";
        }
        else if (5000 < wkSibouSMan && 7000 > wkSibouSMan) {
            sibouSRank = "16";
        }
        else if (7000 == wkSibouSMan) {
            sibouSRank = "17";
        }
        else if (7000 < wkSibouSMan && 8000 >= wkSibouSMan) {
            sibouSRank = "18";
        }
        else if (8000 < wkSibouSMan && 10000 >= wkSibouSMan) {
            sibouSRank = "19";
        }
        else if (10000 < wkSibouSMan && 20000 >= wkSibouSMan) {
            sibouSRank = "20";
        }
        else if (20000 < wkSibouSMan && 50000 >= wkSibouSMan) {
            sibouSRank = "21";
        }
        else if (50000 < wkSibouSMan && 70000 >= wkSibouSMan) {
            sibouSRank = "22";
        }
        else if (70000 < wkSibouSMan && 90000 >= wkSibouSMan) {
            sibouSRank = "23";
        }
        else if (90000 < wkSibouSMan) {
            sibouSRank = "24";
        }

        return sibouSRank;
    }

    private String convJisituhosyouSRank(BizNumber pJisituhosyouS){

        int wkJisituhosyouS = Integer.parseInt(pJisituhosyouS.toString());
        String jissituhosyouSRank = "";

        if (0 > wkJisituhosyouS) {
            jissituhosyouSRank = "01";
        }
        else if (0 <= wkJisituhosyouS && 100 >= wkJisituhosyouS) {
            jissituhosyouSRank = "02";
        }
        else if (100 < wkJisituhosyouS && 300 >= wkJisituhosyouS) {
            jissituhosyouSRank = "03";
        }
        else if (300 < wkJisituhosyouS && 500 >= wkJisituhosyouS) {
            jissituhosyouSRank = "04";
        }
        else if (500 < wkJisituhosyouS && 800 > wkJisituhosyouS) {
            jissituhosyouSRank = "05";
        }
        else if (800 == wkJisituhosyouS) {
            jissituhosyouSRank = "06";
        }
        else if (800 < wkJisituhosyouS && 1000 > wkJisituhosyouS) {
            jissituhosyouSRank = "07";
        }
        else if (1000 == wkJisituhosyouS) {
            jissituhosyouSRank = "08";
        }
        else if (1000 < wkJisituhosyouS && 1200 >= wkJisituhosyouS) {
            jissituhosyouSRank = "09";
        }
        else if (1200 < wkJisituhosyouS && 1500 >= wkJisituhosyouS) {
            jissituhosyouSRank = "10";
        }
        else if (1500 < wkJisituhosyouS && 2000 >= wkJisituhosyouS) {
            jissituhosyouSRank = "11";
        }
        else if (2000 < wkJisituhosyouS && 3000 > wkJisituhosyouS) {
            jissituhosyouSRank = "12";
        }
        else if (3000 == wkJisituhosyouS) {
            jissituhosyouSRank = "13";
        }
        else if (3000 < wkJisituhosyouS && 4000 >= wkJisituhosyouS) {
            jissituhosyouSRank = "14";
        }
        else if (4000 < wkJisituhosyouS && 5000 > wkJisituhosyouS) {
            jissituhosyouSRank = "15";
        }
        else if (5000 == wkJisituhosyouS) {
            jissituhosyouSRank = "16";
        }
        else if (5000 < wkJisituhosyouS && 7000 > wkJisituhosyouS) {
            jissituhosyouSRank = "17";
        }
        else if (7000 == wkJisituhosyouS) {
            jissituhosyouSRank = "18";
        }
        else if (7000 < wkJisituhosyouS && 8000 >= wkJisituhosyouS) {
            jissituhosyouSRank = "19";
        }
        else if (8000 < wkJisituhosyouS && 10000 >= wkJisituhosyouS) {
            jissituhosyouSRank = "20";
        }
        else if (10000 < wkJisituhosyouS && 20000 >= wkJisituhosyouS) {
            jissituhosyouSRank = "21";
        }
        else if (20000 < wkJisituhosyouS && 50000 >= wkJisituhosyouS) {
            jissituhosyouSRank = "22";
        }
        else if (50000 < wkJisituhosyouS && 70000 >= wkJisituhosyouS) {
            jissituhosyouSRank = "23";
        }
        else if (70000 < wkJisituhosyouS && 90000 >= wkJisituhosyouS) {
            jissituhosyouSRank = "24";
        }
        else if (90000 < wkJisituhosyouS) {
            jissituhosyouSRank = "25";
        }
        return jissituhosyouSRank;
    }

}
