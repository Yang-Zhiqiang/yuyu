package yuyu.batch.biz.boss.bzskipjissekifsks;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.ZT_SkIpJissekiTy;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ新契約インプット実績Ｆ作成
 */
public class BzSkIpJissekiFSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    private static final int MAX_LENGTH_KYKNMKN = 41;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        int kensu = 0;
        SortHT_MosSyouhn mosSyouhnSort = SWAKInjector.getInstance(SortHT_MosSyouhn.class);
        EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        BizDateYM bosyuuymFrom = syoriYmd.getBizDateYM().addMonths(-1);
        BizDateYM bosyuuymTo = syoriYmd.getBizDateYM().addMonths(3);

        try (ExDBResults<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByBosyuuymFromTo(bosyuuymFrom,
            bosyuuymTo);
            EntityInserter<ZT_SkIpJissekiTy> skIpJissekiTyInserter = new EntityInserter<>();) {
            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {
                HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
                List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
                mosSyouhnLst = mosSyouhnSort
                    .OrderHT_MosSyouhnByBM_SyouhnZokuseiSyutkkbnSyohnsortnoAsc(mosSyouhnLst);
                List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();
                HT_NayoseKekka nayoseKekkaHhkn = syoriCTL.getNayoseKekkaBySntkinfotaisyousyakbnEdano(
                    C_SntkInfoTaisyousyaKbn.HIHOKENSYA, 1);
                HT_NayoseKekka nayoseKekkaKyk = syoriCTL.getNayoseKekkaBySntkinfotaisyousyakbnEdano(
                    C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, 1);
                List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();

                long rendouyouHaraikomiP = 0;
                long syuKeiyakuP = 0;
                long gyousekiyouHosyouS = 0;
                long koukeiKihonS = 0;
                long sibouS = 0;
                BizCurrency seitouKihonSKoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long kihonsKyktuuka = 0;
                BizNumber kawaserateN5 = BizNumber.ZERO;
                BizDate yenknsnKijyunymd = null;
                long nnknsnpssysyup = 0;

                editPalRenkeiKoumoku.editDakuhiKetteiKanrenKoumoku(dakuhiKetteiLst);
                C_Ketkekkacd saisinKetkekkaCd = editPalRenkeiKoumoku.getSaisinKetkekkaCd();
                String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(syoriCTL.getSeiritukbn(),
                    saisinKetkekkaCd);

                editPalRenkeiKoumoku.getSyuEntity(mosSyouhnLst);
                HT_MosSyouhn mosSyouhnSyu = editPalRenkeiKoumoku.getMosSyouhn();
                BM_SyouhnZokusei syouhnZokusei = editPalRenkeiKoumoku.getSyouhnZokusei();

                String hknkkn = "00";
                String hrkkkn = "00";
                String saimnkkykhyj = null;
                if (mosSyouhnSyu != null) {
                    editPalRenkeiKoumoku.editHknkkn(mosKihon, mosSyouhnSyu, syouhnZokusei);
                    hknkkn = editPalRenkeiKoumoku.getHknKkn();
                    saimnkkykhyj = editPalRenkeiKoumoku.getSaiMnkKykHyj();
                    hrkkkn = editPalRenkeiKoumoku.getHrkkkn();
                }

                String hhknNen = editPalRenkeiKoumoku.editHhknnen(mosKihon.getHhknnen());

                String kyksyaNen2Keta = editPalRenkeiKoumoku.editKyksyanen2Keta(mosKihon.getKykkbn(),
                    mosKihon.getHhknnen(), mosKihon.getKyknen());

                long syokaiharaikomip = 0;
                BizCurrency siteituukaHaraikomip = BizCurrency.valueOf(0,
                        henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu()));
                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                    syokaiharaikomip = new BigDecimal(mosKihon.getFstphrkgk().toString()).longValue();
                    if (mosSyouhnSyu != null) {
                        if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                            syuKeiyakuP = new BigDecimal(mosSyouhnSyu.getSyutkp().toString()).longValue();
                        }
                        gyousekiyouHosyouS = new BigDecimal(mosSyouhnSyu.getSeitoukihons().toString()).longValue();
                    }
                    for (HT_MosSyouhn mosSyouhnTemp : mosSyouhnLst) {
                        seitouKihonSKoukei = seitouKihonSKoukei.add(mosSyouhnTemp.getSeitoukihons());
                    }
                    koukeiKihonS = new BigDecimal(seitouKihonSKoukei.toString()).longValue();
                }
                else {
                    yenknsnKijyunymd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(mosKihon.getKyktuukasyu(),
                        syoriCTL.getRyosyuymd(), mosKihon.getMosymd());

                    BizNumber kawaserate = editPalRenkeiKoumoku.getEnknsnKawaseRate(mosKihon.getKyktuukasyu(),
                        yenknsnKijyunymd, mosKihon.getHrkkaisuu(), mosKihon.getZennoumousideumu(), mosKihon.getIkkatubaraikbn());

                    if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {

                            syokaiharaikomip = new BigDecimal(mosKihon.getFstphrkgk().toString()).longValue();
                        }
                        else {
                            syokaiharaikomip = new BigDecimal(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                mosKihon.getSeitoufstpkei(),
                                syoriCTL.getNyknkwsrate(),
                                C_HasuusyoriKbn.SUTE).toString()).longValue();

                            if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())){
                                syokaiharaikomip = syokaiharaikomip + new BigDecimal(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                        mosKihon.getZennoup(),
                                        syoriCTL.getNyknkwsrate(),
                                        C_HasuusyoriKbn.SUTE).toString()).longValue();
                            }
                        }
                    }
                    else {
                        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())
                                && !mosKihon.getHrktuukasyu().eq(mosKihon.getKyktuukasyu())){
                            siteituukaHaraikomip = mosKihon.getSeitoufstpkei();
                        }
                        else {
                            siteituukaHaraikomip = mosKihon.getFstphrkgk();
                        }
                        syokaiharaikomip = new BigDecimal(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            siteituukaHaraikomip,
                            kawaserate,
                            C_HasuusyoriKbn.SUTE).toString()).longValue();
                    }

                    if (mosSyouhnSyu != null) {

                        if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                                syuKeiyakuP = new BigDecimal(mosSyouhnSyu.getHrktuukasyutkp().toString()).longValue();
                            }
                            else {

                                syuKeiyakuP = new BigDecimal(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                    mosSyouhnSyu.getSyutkp(),
                                    kawaserate,
                                    C_HasuusyoriKbn.SUTE).toString()).longValue();
                            }
                        }

                        gyousekiyouHosyouS = new BigDecimal(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            mosSyouhnSyu.getSeitoukihons(),
                            kawaserate,
                            C_HasuusyoriKbn.SUTE).toString()).longValue();
                    }

                    for (HT_MosSyouhn mosSyouhnTemp : mosSyouhnLst) {
                        seitouKihonSKoukei = seitouKihonSKoukei.add(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            mosSyouhnTemp.getSeitoukihons(),
                            kawaserate,
                            C_HasuusyoriKbn.SUTE));
                    }
                    koukeiKihonS = new BigDecimal(seitouKihonSKoukei.toString()).longValue();
                }

                syokaiharaikomip = chkKetasuu(syokaiharaikomip, 11);
                rendouyouHaraikomiP = syokaiharaikomip;
                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                    syuKeiyakuP = chkKetasuu(syuKeiyakuP, 11);
                }
                else {
                    syuKeiyakuP = syokaiharaikomip;
                }
                gyousekiyouHosyouS = chkKetasuu(gyousekiyouHosyouS, 11);
                sibouS = gyousekiyouHosyouS;
                koukeiKihonS = chkKetasuu(koukeiKihonS, 11);

                String toukeiyouSinsaKbn = editPalRenkeiKoumoku.editToukeiyouSinsaKbn(mosKihon.getSntkhoukbn());

                BizNumber itijiBaraiPKyktuuka = BizNumber.ZERO;

                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                    if (BizNumber.valueOf(new BigDecimal(mosKihon.getSeitoufstpkei().toString())).compareTo(BizNumber.valueOf(9999999999999.99)) > 0) {
                        itijiBaraiPKyktuuka = BizNumber.valueOf(9999999999999.99);
                    }
                    else {
                        itijiBaraiPKyktuuka = BizNumber.valueOf(new BigDecimal(mosKihon.getSeitoufstpkei().toString()));
                    }
                }

                kawaserateN5 = editPalRenkeiKoumoku.getNknsnPssyKwsRate(mosKihon.getKyktuukasyu(),
                    mosKihon.getHrktuukasyu(),
                    yenknsnKijyunymd,
                    mosKihon.getHrkkaisuu(),
                    mosKihon.getZennoumousideumu(),
                    mosKihon.getIkkatubaraikbn());

                String tuukaKbnHrk = editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getHrktuukasyu());

                String tuukaKbnKyk = editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getKyktuukasyu());

                BizCurrency kihonSKoukei = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu()));
                for (HT_MosSyouhn mosSyouhnTemp : mosSyouhnLst) {
                    kihonSKoukei = kihonSKoukei.add(mosSyouhnTemp.getSeitoukihons());
                }
                kihonsKyktuuka = new BigDecimal(kihonSKoukei.toAdsoluteString()).longValue();
                kihonsKyktuuka = chkKetasuu(kihonsKyktuuka, 15);

                if (!C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {

                    if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {

                        if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                            nnknsnpssysyup = new BigDecimal(mosKihon.getHeijyunp().toString()).longValue();
                        }
                    }
                    else {

                        nnknsnpssysyup = new BigDecimal(mosKihon.getHeijyunp().toAdsoluteString()).longValue();
                    }

                }
                nnknsnpssysyup = chkKetasuu(nnknsnpssysyup, 11);

                if (mosDairitenLst.size() == 0) {
                    ZT_SkIpJissekiTy skIpJissekiTy = new ZT_SkIpJissekiTy();
                    skIpJissekiTy.setZtysequenceno(kensu + 1);
                    skIpJissekiTy.setZtyatukaikojincd("000000");
                    skIpJissekiTy.setZtydairitenatkikeitaikbn("0");
                    skIpJissekiTy.setZtyatkiwari3keta(100);
                    skIpJissekiTy.setZtykjsakininisetteihyj("0");
                    skIpJissekiTy.setZtykydatkikbn("0");
                    skIpJissekiTy.setZtyatukaisosikicd("0000000");
                    skIpJissekiTy.setZtybsydrtencd("");
                    skIpJissekiTy.setZtycifcd("");

                    editSkIpJissekiTy(
                        syoriCTL
                        , mosKihon
                        , mosSyouhnLst
                        , nayoseKekkaHhkn
                        , nayoseKekkaKyk
                        , nyuukinLst
                        , mosSyouhnSyu
                        , skIpJissekiTy
                        , mosSyoumetuKbn
                        , hknkkn
                        , hrkkkn
                        , hhknNen
                        , kyksyaNen2Keta
                        , rendouyouHaraikomiP
                        , syuKeiyakuP
                        , gyousekiyouHosyouS
                        , sibouS
                        , koukeiKihonS
                        , toukeiyouSinsaKbn
                        , saimnkkykhyj
                        , itijiBaraiPKyktuuka
                        , kawaserateN5
                        , tuukaKbnHrk
                        , tuukaKbnKyk
                        , kihonsKyktuuka
                        , nnknsnpssysyup
                        );

                    BizPropertyInitializer.initialize(skIpJissekiTy);

                    BzSkIpJissekiFSksConverter.convertPadding(skIpJissekiTy);

                    skIpJissekiTyInserter.add(skIpJissekiTy);
                    kensu++;

                }
                else {
                    for (HT_MosDairiten mosDairitenTemp : mosDairitenLst) {
                        ZT_SkIpJissekiTy skIpJissekiTy = new ZT_SkIpJissekiTy();
                        skIpJissekiTy.setZtysequenceno(kensu + 1);
                        if (!BizUtil.isBlank(mosDairitenTemp.getDaibosyuucd())) {
                            skIpJissekiTy.setZtyatukaikojincd(mosDairitenTemp.getDaibosyuucd());
                        }
                        else {
                            skIpJissekiTy.setZtyatukaikojincd("000000");
                        }
                        skIpJissekiTy.setZtydairitenatkikeitaikbn(editPalRenkeiKoumoku
                            .editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst));
                        if (mosDairitenLst.size() == 1) {
                            skIpJissekiTy.setZtyatkiwari3keta(100);
                        }
                        else {
                            skIpJissekiTy.setZtyatkiwari3keta(50);
                        }
                        if (!BizUtil.isBlank(mosDairitenTemp.getGyousekikeijyousakisosikicd())) {
                            skIpJissekiTy.setZtykjsakininisetteihyj("1");
                            skIpJissekiTy.setZtyatukaisosikicd(mosDairitenTemp.getGyousekikeijyousakisosikicd());
                        }
                        else {
                            skIpJissekiTy.setZtykjsakininisetteihyj("0");
                            if (!BizUtil.isBlank(mosDairitenTemp.getDrtenkanrisosikicd())) {
                                skIpJissekiTy.setZtyatukaisosikicd(mosDairitenTemp.getDrtenkanrisosikicd());
                            }
                            else {
                                skIpJissekiTy.setZtyatukaisosikicd("0000000");
                            }

                        }
                        if (mosDairitenLst.size() == 1) {
                            skIpJissekiTy.setZtykydatkikbn("0");
                        }
                        else {
                            if (mosDairitenTemp.getRenno() == 1) {
                                skIpJissekiTy.setZtykydatkikbn("1");
                            }
                            else {
                                skIpJissekiTy.setZtykydatkikbn("2");
                            }
                        }
                        skIpJissekiTy.setZtybsydrtencd(mosDairitenTemp.getTratkiagcd());
                        skIpJissekiTy.setZtycifcd(mosDairitenTemp.getCifcd());

                        editSkIpJissekiTy(
                            syoriCTL
                            , mosKihon
                            , mosSyouhnLst
                            , nayoseKekkaHhkn
                            , nayoseKekkaKyk
                            , nyuukinLst
                            , mosSyouhnSyu
                            , skIpJissekiTy
                            , mosSyoumetuKbn
                            , hknkkn
                            , hrkkkn
                            , hhknNen
                            , kyksyaNen2Keta
                            , rendouyouHaraikomiP
                            , syuKeiyakuP
                            , gyousekiyouHosyouS
                            , sibouS
                            , koukeiKihonS
                            , toukeiyouSinsaKbn
                            , saimnkkykhyj
                            , itijiBaraiPKyktuuka
                            , kawaserateN5
                            , tuukaKbnHrk
                            , tuukaKbnKyk
                            , kihonsKyktuuka
                            , nnknsnpssysyup
                            );

                        BizPropertyInitializer.initialize(skIpJissekiTy);

                        BzSkIpJissekiFSksConverter.convertPadding(skIpJissekiTy);

                        skIpJissekiTyInserter.add(skIpJissekiTy);
                        kensu++;
                    }
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kensu), kinou.getKinouNm()));
    }

    private void editSkIpJissekiTy(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, List<HT_MosSyouhn> pMosSyouhnLst,
        HT_NayoseKekka pNayoseKekkaByHihokensya, HT_NayoseKekka pNayoseKekkaByKeiyakusya,
        List<HT_Nyuukin> pNyuukinLst, HT_MosSyouhn pMosSyouhnSyu,
        ZT_SkIpJissekiTy pSkIpJissekiTy, String pMosSyoumetuKbn, String pHknkkn, String pHrkkkn, String pHhknNen2Keta,
        String pKyksyaNen2Keta, long pRendouyouHaraikomiP, long pSyuKeiyakuP, long pGyousekiyouHosyouS, long pSibouS,
        long pKoukeiKihonS, String pToukeiyouSinsaKbn, String psaimnkkykhyj, BizNumber pItijiBaraiPKyktuuka, BizNumber pKawaserateN5,
        String pTuukaKbnHrk, String pTuukaKbnKyk, long pKihonsKyktuuka, long pNnknsnpssysyup) {

        EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

        if (pMosKihon.getMosym() != null) {
            pSkIpJissekiTy.setZtymosym(String.valueOf(pMosKihon.getMosym()));
        }
        else {
            pSkIpJissekiTy.setZtymosym("000000");
        }
        pSkIpJissekiTy.setZtymosno(pSyoriCTL.getMosno().substring(0, 9));
        pSkIpJissekiTy.setZtymossyoumetukbn(pMosSyoumetuKbn);
        pSkIpJissekiTy.setZtysaimnkkykhyj(psaimnkkykhyj);
        if (pMosSyouhnSyu != null) {
            pSkIpJissekiTy.setZtyhknsyukigou(pMosSyouhnSyu.getSyouhncd().substring(0, 2));

            pSkIpJissekiTy.setZtyhknsyuruikigousedaikbn(pMosSyouhnSyu.getRyouritusdno().substring(0, 1));

            pSkIpJissekiTy.setZtynksyuruikbn1(editPalRenkeiKoumoku.editNenkinsyu(pMosSyouhnSyu.getSknenkinsyu()));
        }
        else {
            pSkIpJissekiTy.setZtynksyuruikbn1("0");
        }
        pSkIpJissekiTy.setZtyhknkkn(pHknkkn);
        pSkIpJissekiTy.setZtyphrkkikn(pHrkkkn);
        pSkIpJissekiTy.setZtyhhknseikbn(pMosKihon.getHhknsei().getValue());
        pSkIpJissekiTy.setZtyhhknnen2keta(pHhknNen2Keta);
        pSkIpJissekiTy.setZtykyksyanen(pKyksyaNen2Keta);
        pSkIpJissekiTy.setZtyhrkkaisuukbn(editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon));
        pSkIpJissekiTy.setZtyhrkkeirokbn(editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(
            pMosKihon.getHrkkeiro(), pMosKihon.getHrkkaisuu()));
        if (C_Hrkkaisuu.ITIJI.eq(pMosKihon.getHrkkaisuu())) {
            pSkIpJissekiTy.setZtykykktaikbn("05");
            pSkIpJissekiTy.setZtyannaifuyouriyuukbn("01");
        }
        else {
            pSkIpJissekiTy.setZtykykktaikbn("00");
            pSkIpJissekiTy.setZtyannaifuyouriyuukbn("00");
        }
        pSkIpJissekiTy.setZtyryouritukbn(editPalRenkeiKoumoku.editRyourituKbn(pMosKihon.getHrkkeiro(),
            pMosKihon.getDntryouritukbn()));
        pSkIpJissekiTy.setZtyrendouyouharaikomip(pRendouyouHaraikomiP);
        pSkIpJissekiTy.setZtysyukeiyakup(pSyuKeiyakuP);
        pSkIpJissekiTy.setZtytoukeiyousinsakbn(pToukeiyouSinsaKbn);
        if (C_Sdpd.SD.eq(pMosKihon.getSdpdkbn())) {
            pSkIpJissekiTy.setZtysdpdkbn("1");
        }
        else if (C_Sdpd.PD.eq(pMosKihon.getSdpdkbn())) {
            pSkIpJissekiTy.setZtysdpdkbn("2");
        }
        else {
            pSkIpJissekiTy.setZtysdpdkbn("0");
        }
        pSkIpJissekiTy.setZtygyousekiyouhosyous(pGyousekiyouHosyouS);
        pSkIpJissekiTy.setZtygoukeikihons(pKoukeiKihonS);
        if (pMosKihon.getKykymd() != null) {
            pSkIpJissekiTy.setZtykykymd(String.valueOf(pMosKihon.getKykymd()));
        }
        else {
            pSkIpJissekiTy.setZtykykymd("00000000");
        }
        pSkIpJissekiTy.setZtymusymd(String.valueOf(pMosKihon.getMosymd()));
        if (pSyoriCTL.getMosnrkymd() != null) {
            pSkIpJissekiTy.setZtymosnyuuryokuymd(String.valueOf(pSyoriCTL.getMosnrkymd()));
        }
        else {
            pSkIpJissekiTy.setZtymosnyuuryokuymd("00000000");
        }
        if (pSyoriCTL.getRyosyuymd() != null) {
            pSkIpJissekiTy.setZtysyokaipryosyuymd(String.valueOf(pSyoriCTL.getRyosyuymd()));
        }
        else {
            pSkIpJissekiTy.setZtysyokaipryosyuymd("00000000");
        }
        if (pNyuukinLst.size() == 0) {
            pSkIpJissekiTy.setZtyfstpnyknsyoriymd("00000000");
        }
        else {
            pSkIpJissekiTy.setZtyfstpnyknsyoriymd(String.valueOf(pNyuukinLst.get(0).getNyksyoriymd()));
        }
        if (C_SntkhouKbn.NONE.eq(pMosKihon.getSntkhoukbn())) {
            pSkIpJissekiTy.setZtykokutiymd(String.valueOf(pMosKihon.getMosymd()));
        }
        else {
            if (pSyoriCTL.getKktymd() != null) {
                pSkIpJissekiTy.setZtykokutiymd(String.valueOf(pSyoriCTL.getKktymd()));
            }
            else {
                pSkIpJissekiTy.setZtykokutiymd("00000000");
            }
        }
        if (pSyoriCTL.getSrsyoriymd() != null ) {
            pSkIpJissekiTy.setZtymossyumtkktymd(String.valueOf(pSyoriCTL.getSrsyoriymd()));
        }
        else {
            pSkIpJissekiTy.setZtymossyumtkktymd("00000000");
        }
        pSkIpJissekiTy.setZtysisyaketsyoriymd(editPalRenkeiKoumoku.editSisyaketteiYmd(pSyoriCTL));
        if (pMosKihon.getMossakuseiymd() != null) {
            pSkIpJissekiTy.setZtymossyosakuseiymd(String.valueOf(pMosKihon.getMossakuseiymd()));
        }
        else {
            pSkIpJissekiTy.setZtymossyosakuseiymd("00000000");
        }
        if (pNayoseKekkaByHihokensya == null) {
            pSkIpJissekiTy.setZtyhhknsakuinmeino("0000000000");
        }
        else {
            if (!BizUtil.isBlank(pNayoseKekkaByHihokensya.getSakuinnmno())) {
                pSkIpJissekiTy.setZtyhhknsakuinmeino(pNayoseKekkaByHihokensya.getSakuinnmno());
            }
            else {
                pSkIpJissekiTy.setZtyhhknsakuinmeino("0000000000");
            }
        }

        if (C_HaitouKbn.YUUHAI.eq(pMosKihon.getHaitoukbn())) {
            pSkIpJissekiTy.setZtyhaitousiharaikbn("0");
        }
        else if (C_HaitouKbn.RISAHAI.eq(pMosKihon.getHaitoukbn())) {
            pSkIpJissekiTy.setZtyhaitousiharaikbn("1");
        }
        else if (C_HaitouKbn.NONE.eq(pMosKihon.getHaitoukbn())) {
            pSkIpJissekiTy.setZtyhaitousiharaikbn("2");
        }
        else {
            pSkIpJissekiTy.setZtyhaitousiharaikbn("0");
        }

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKthhbkbn())) {
            pSkIpJissekiTy.setZtyhubikbn("1");

        }
        else if (!C_UmuKbn.ARI.eq(pSyoriCTL.getKthhbkbn()) && C_UmuKbn.ARI.eq(pSyoriCTL.getSrhhbkbn())) {
            pSkIpJissekiTy.setZtyhubikbn("2");
        }
        else {
            pSkIpJissekiTy.setZtyhubikbn("0");

        }
        pSkIpJissekiTy.setZtytsinkihontikucd(pMosKihon.getTsinyno());
        pSkIpJissekiTy.setZtysyono(pSyoriCTL.getSyono().substring(0, 11));
        if (pMosKihon.getSeisekiym() != null) {
            pSkIpJissekiTy.setZtyseisekiym(String.valueOf(pMosKihon.getSeisekiym()));
        }
        else {
            pSkIpJissekiTy.setZtyseisekiym("000000");
        }
        pSkIpJissekiTy.setZtytokusyujimutoriatukaikbn("1");
        if (pNayoseKekkaByKeiyakusya == null) {
            pSkIpJissekiTy.setZtykyksyaskinmeino("0000000000");
        }
        else {
            if (!BizUtil.isBlank(pNayoseKekkaByKeiyakusya.getSakuinnmno())) {
                pSkIpJissekiTy.setZtykyksyaskinmeino(pNayoseKekkaByKeiyakusya.getSakuinnmno());
            }
            else {
                pSkIpJissekiTy.setZtykyksyaskinmeino("0000000000");
            }
        }
        pSkIpJissekiTy.setZtymossakuseino("000000000");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x1(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x2(SrCommonConstants.HKNSYKGUYBI1X2_MANNENREIHOUSIKI);
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x3(SrCommonConstants.HKNSYKGUYBI1X3_SINHOKENHOUTEKIYOU);
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x4(SrCommonConstants.HKNSYKGUYBI1X4_SINTOKUJYOUTEKIYOU);
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x5("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x6("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x7("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x8("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x9("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x10("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x11("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x12("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x13("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x14("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x15("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x1("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x2("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x3("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x4("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x5("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x6("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x7("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x8("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x9("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi2x10("");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x1(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x2(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x3("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x4("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x5("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x6("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x7("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x8("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x9("0");
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x10("0");
        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getNstkhkkbn())) {
            pSkIpJissekiTy.setZtynstkarihyj("1");
        }
        else {
            pSkIpJissekiTy.setZtynstkarihyj("0");
        }
        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getStdrsktkyhkkbn())) {
            pSkIpJissekiTy.setZtystdairiseikyuutkykarihyj("1");
        }
        else {
            pSkIpJissekiTy.setZtystdairiseikyuutkykarihyj("0");
        }
        if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {
            pSkIpJissekiTy.setZtydai1kyktdkkbn("0");
        }
        else {
            if (C_Tdk.HGU.eq(pMosKihon.getKyktdk())) {
                pSkIpJissekiTy.setZtydai1kyktdkkbn("1");
            }
            else if (C_Tdk.KO.eq(pMosKihon.getKyktdk())) {
                pSkIpJissekiTy.setZtydai1kyktdkkbn("2");
            }
            else if (C_Tdk.OYA.eq(pMosKihon.getKyktdk())) {
                pSkIpJissekiTy.setZtydai1kyktdkkbn("3");
            }
            else if (C_Tdk.MAGO.eq(pMosKihon.getKyktdk())) {
                pSkIpJissekiTy.setZtydai1kyktdkkbn("4");
            }
            else if (C_Tdk.SHB.eq(pMosKihon.getKyktdk())) {
                pSkIpJissekiTy.setZtydai1kyktdkkbn("5");
            }
            else if (C_Tdk.KYDSM.eq(pMosKihon.getKyktdk())) {
                pSkIpJissekiTy.setZtydai1kyktdkkbn("6");
            }
            else if (C_Tdk.KYN.eq(pMosKihon.getKyktdk())) {
                pSkIpJissekiTy.setZtydai1kyktdkkbn("7");
            }
            else {
                pSkIpJissekiTy.setZtydai1kyktdkkbn("9");
            }
        }
        pSkIpJissekiTy.setZtymossyouninymd("00000000");
        pSkIpJissekiTy.setZtynenkansanp(0l);
        pSkIpJissekiTy.setZtysibous(pSibouS);
        pSkIpJissekiTy.setZtyhensyuukeiyakusyamei(
            editPalRenkeiKoumoku.editKyknmkn(
                pMosKihon.getKykkbn(),
                pMosKihon.getHhknnmkn(),
                pMosKihon.getKyknmkn(),
                MAX_LENGTH_KYKNMKN));
        pSkIpJissekiTy.setZtykanjitsinkaiadr(pMosKihon.getTsinadr1kj() + pMosKihon.getTsinadr2kj()
            + pMosKihon.getTsinadr3kj());
        pSkIpJissekiTy.setZtytsintelno(pMosKihon.getTsintelno());
        pSkIpJissekiTy.setZtyhhknmei(pMosKihon.getHhknnmkn());
        if (pMosKihon.getHhknseiymd() != null) {
            pSkIpJissekiTy.setZtyhhknseiymd(String.valueOf(pMosKihon.getHhknseiymd()));
        }
        else {
            pSkIpJissekiTy.setZtyhhknseiymd("00000000");

        }
        if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {
            if (pMosKihon.getHhknseiymd() != null) {
                pSkIpJissekiTy.setZtyhensyuuyoukyksyaseiymd(String.valueOf(pMosKihon.getHhknseiymd()));
            }
            else {
            }
        }
        else {
            if (pMosKihon.getKykseiymd() != null) {
                pSkIpJissekiTy.setZtyhensyuuyoukyksyaseiymd(String.valueOf(pMosKihon.getKykseiymd()));
            }
            else {
            }
        }
        pSkIpJissekiTy.setZtyitijibaraipkyktuuka(pItijiBaraiPKyktuuka);
        pSkIpJissekiTy.setZtykawaseraten5(pKawaserateN5);
        pSkIpJissekiTy.setZtyhrktuukakbn(pTuukaKbnHrk);
        pSkIpJissekiTy.setZtysiteituukakbn(pTuukaKbnKyk);
        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getSyksbyensitihsyutkhkkbn())) {
            pSkIpJissekiTy.setZtysyksbsitihsyutkykarihyj("1");
        }
        else {
            pSkIpJissekiTy.setZtysyksbsitihsyutkykarihyj("0");

        }
        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getJyudkaigomehrtkhkkbn())) {
            pSkIpJissekiTy.setZtyskkaigomaehrtkykarihyj("1");
        }
        else {
            pSkIpJissekiTy.setZtyskkaigomaehrtkykarihyj("0");

        }
        pSkIpJissekiTy.setZtykihonskyktuuka(pKihonsKyktuuka);
        if (C_BlnktkumuKbn.ARI.eq(pMosKihon.getZenkizennouumu())) {
            pSkIpJissekiTy.setZtyzenkizennouhyouji("1");
        }
        else {
            pSkIpJissekiTy.setZtyzenkizennouhyouji("0");
        }

        pSkIpJissekiTy.setZtynnknsnpssysyup(pNnknsnpssysyup);

        if (C_Hrkkaisuu.NEN.eq(pMosKihon.getHrkkaisuu())) {
            pSkIpJissekiTy.setZtynknsnpssyhrkkskbn("1");
        }
        else if (C_Hrkkaisuu.HALFY.eq(pMosKihon.getHrkkaisuu())) {
            pSkIpJissekiTy.setZtynknsnpssyhrkkskbn("2");
        }
        else if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {
            pSkIpJissekiTy.setZtynknsnpssyhrkkskbn("3");
        }
        else {
            pSkIpJissekiTy.setZtynknsnpssyhrkkskbn("0");
        }

        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getKykdrtkykhukakbn())) {
            pSkIpJissekiTy.setZtykykdrtkykarihyj("1");
        }
        else {
            pSkIpJissekiTy.setZtykykdrtkykarihyj("0");
        }

        if (C_KzktourokuserviceTourokuKbn.ARI.eq(pMosKihon.getKzktourokuservicetourokukbn())) {
            pSkIpJissekiTy.setZtykzktrkservicearihyj("1");
        }
        else {
            pSkIpJissekiTy.setZtykzktrkservicearihyj("0");
        }
    }

    private long chkKetasuu(long pChecktaisyouGk, int pKetasuu) {

        long resultGk = 0;

        if (String.valueOf(pChecktaisyouGk).length() > pKetasuu) {
            if (pKetasuu == 11) {
                resultGk = 99999999999l;
            }
            else if (pKetasuu == 15) {
                resultGk = 999999999999999l;
            }
        }
        else {
            resultGk = pChecktaisyouGk;
        }

        return resultGk;

    }
}
