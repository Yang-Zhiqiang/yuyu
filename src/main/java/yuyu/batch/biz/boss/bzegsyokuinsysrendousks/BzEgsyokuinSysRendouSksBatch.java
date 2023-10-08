package yuyu.batch.biz.boss.bzegsyokuinsysrendousks;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_Livhukaumu;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouTy;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ営業職員システム連動Ｆ作成
 */
public class BzEgsyokuinSysRendouSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    private static final int MAX_LENGTH_KYKNMKN = 41;

    private static final int MAX_LENGTH_KYKNMKJ = 35;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        try (
            ExDBResults<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySeirituKbnBosyuuym(syoriYmd
                .addMonths(-1).getBizDateYM());
            EntityInserter<ZT_EgsyokuinSysRendouTy> egsyokuinSysRendouTyInserter = new EntityInserter<>();) {

            int count = 0;
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);
            GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            BizDate yenknsnKijyunymd = null;

            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
                List<HT_MosSyouhn> mosSyouhnBySyuLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                HT_NayoseKekka nayoseKekkaByHihokensya = syoriCTL.getNayoseKekkaBySntkinfotaisyousyakbnEdano(
                    C_SntkInfoTaisyousyaKbn.HIHOKENSYA, 1);
                HT_NayoseKekka nayoseKekkaByKeiyakusya = syoriCTL.getNayoseKekkaBySntkinfotaisyousyakbnEdano(
                    C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, 1);
                List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();

                BizNumber kawaserate = BizNumber.valueOf(0);
                if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                    yenknsnKijyunymd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(mosKihon.getKyktuukasyu(),
                        syoriCTL.getRyosyuymd(), mosKihon.getMosymd());
                    kawaserate = editPalRenkeiKoumoku.getEnknsnKawaseRate(mosKihon.getKyktuukasyu(), yenknsnKijyunymd,
                        mosKihon.getHrkkaisuu(),mosKihon.getZennoumousideumu(),mosKihon.getIkkatubaraikbn());
                }

                BizNumber ztykawaseraten5 = editPalRenkeiKoumoku.getNknsnPssyKwsRate(
                    mosKihon.getKyktuukasyu(),
                    mosKihon.getHrktuukasyu(),
                    yenknsnKijyunymd,
                    mosKihon.getHrkkaisuu(),
                    mosKihon.getZennoumousideumu(),
                    mosKihon.getIkkatubaraikbn());

                long ztykihons = 0;
                long ztyharaikomip = 0;
                long ztysyukeiyakup = 0;
                long syokaiharaikomip = 0;
                BizCurrency siteituukaHaraikomip = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu()));
                editPalRenkeiKoumoku.getSyuEntity(mosSyouhnLst);

                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                    BizCurrency kihons = BizCurrency.valueOf(0);
                    if (mosSyouhnLst != null) {
                        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                            kihons = kihons.add(mosSyouhn.getSeitoukihons());
                        }
                        ztykihons = new BigDecimal(kihons.toString()).longValue();
                    }
                    syokaiharaikomip = new BigDecimal(mosKihon.getFstphrkgk().toString()).longValue();
                    if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                        if (mosSyouhnBySyuLst.size() != 0) {
                            ztysyukeiyakup = new BigDecimal(mosSyouhnBySyuLst.get(0).getSyutkp().toString())
                            .longValue();
                        }
                    }
                }
                else {
                    BizCurrency kihons = BizCurrency.valueOf(0);
                    if (mosSyouhnLst != null) {
                        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                            kihons = kihons.add(keisanGaikakanzan.exec(C_Tuukasyu.JPY, mosSyouhn.getSeitoukihons(),
                                kawaserate, C_HasuusyoriKbn.SUTE));
                        }
                        ztykihons = new BigDecimal(kihons.toString()).longValue();
                    }

                    if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(editPalRenkeiKoumoku.getSyouhnZokusei().getPtratkituukasiteikbn())) {

                            syokaiharaikomip = new BigDecimal(mosKihon.getFstphrkgk().toString()).longValue();
                        }

                        else {

                            syokaiharaikomip = new BigDecimal(mosKihon.getHrktuukafstphrkgk().toString()).longValue();
                        }
                    }
                    else {
                        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(editPalRenkeiKoumoku.getSyouhnZokusei().getPtratkituukasiteikbn())
                                && !mosKihon.getHrktuukasyu().eq(mosKihon.getKyktuukasyu())){
                            siteituukaHaraikomip = mosKihon.getSeitoufstpkei();
                        }
                        else {
                            siteituukaHaraikomip = mosKihon.getFstphrkgk();
                        }
                        BizCurrency haraikomip = keisanGaikakanzan.exec(C_Tuukasyu.JPY, siteituukaHaraikomip,
                            kawaserate, C_HasuusyoriKbn.SUTE);
                        syokaiharaikomip = new BigDecimal(haraikomip.toString()).longValue();
                    }
                    if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                        if (mosSyouhnBySyuLst.size() != 0) {
                            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                                ztysyukeiyakup = new BigDecimal(mosSyouhnBySyuLst.get(0).getHrktuukasyutkp().toString())
                                .longValue();
                            }
                            else {
                                BizCurrency syukeiyakup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                    mosSyouhnBySyuLst.get(0).getSyutkp(),
                                    kawaserate, C_HasuusyoriKbn.SUTE);
                                ztysyukeiyakup = new BigDecimal(syukeiyakup.toString()).longValue();
                            }
                        }
                    }
                }
                ztykihons = chkKetasuu(ztykihons, 11);
                syokaiharaikomip = chkKetasuu(syokaiharaikomip, 11);
                ztyharaikomip = syokaiharaikomip;
                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                    ztysyukeiyakup = chkKetasuu(ztysyukeiyakup, 11);
                }
                else {
                    ztysyukeiyakup = syokaiharaikomip;
                }

                long ztygyousekiyouhosyous = 0;
                long ztysibous = 0;
                if (mosSyouhnBySyuLst.size() != 0) {
                    if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                        ztygyousekiyouhosyous = new BigDecimal(mosSyouhnBySyuLst.get(0).getSeitoukihons()
                            .toString()).longValue();
                    }
                    else {
                        BizCurrency gyousekiyouhosyous = keisanGaikakanzan.exec(C_Tuukasyu.JPY, mosSyouhnBySyuLst
                            .get(0).getSeitoukihons(), kawaserate, C_HasuusyoriKbn.SUTE);
                        ztygyousekiyouhosyous = new BigDecimal(gyousekiyouhosyous.toString()).longValue();

                    }
                }
                ztygyousekiyouhosyous = chkKetasuu(ztygyousekiyouhosyous, 11);
                ztysibous = ztygyousekiyouhosyous;

                String ztyhhknnen2keta = editPalRenkeiKoumoku.editHhknnen(mosKihon.getHhknnen());

                String ztykyksyanen = editPalRenkeiKoumoku.editKyksyanen2Keta(mosKihon.getKykkbn(),
                    mosKihon.getHhknnen(), mosKihon.getKyknen());

                long ztyjissyuup = 0;
                getRsgakukei.getHenkinsumiRsgaku(syoriCTL);
                C_Tuukasyu tuukasyu = getRsgakukei.getTuukasyu();
                BizCurrency rsgakukei = getRsgakukei.getRsgakukei();
                if (C_Tuukasyu.JPY.eq(tuukasyu)) {
                    ztyjissyuup = new BigDecimal(rsgakukei.toString()).longValue();
                }
                else {
                    if (syoriCTL.getRyosyuymd() != null) {
                        BizNumber yenknsnKawaserate = editPalRenkeiKoumoku.getEnknsnKawaseRate(tuukasyu,
                            syoriCTL.getRyosyuymd(), mosKihon.getHrkkaisuu(),mosKihon.getZennoumousideumu(),mosKihon.getIkkatubaraikbn());
                        BizCurrency jissyuup = keisanGaikakanzan.exec(C_Tuukasyu.JPY, rsgakukei, yenknsnKawaserate,
                            C_HasuusyoriKbn.SUTE);
                        ztyjissyuup = new BigDecimal(jissyuup.toString()).longValue();
                    }
                }
                ztyjissyuup = chkKetasuu(ztyjissyuup, 11);

                String hensyuuyoukyksyaseikbn = "";
                String ztyhensyuuyoukyksyaseikbn = "";
                BizDate hensyuuyoukyksyaseiymd = null;
                String ztyhensyuuyoukyksyaseiymd = "00000000";

                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                    hensyuuyoukyksyaseikbn = mosKihon.getHhknsei().getValue();
                    hensyuuyoukyksyaseiymd = mosKihon.getHhknseiymd();
                }
                else {
                    hensyuuyoukyksyaseikbn = mosKihon.getKyksei().getValue();
                    hensyuuyoukyksyaseiymd = mosKihon.getKykseiymd();
                }

                if ("1".equals(hensyuuyoukyksyaseikbn)) {
                    ztyhensyuuyoukyksyaseikbn = "1";
                }
                else if ("2".equals(hensyuuyoukyksyaseikbn)) {
                    ztyhensyuuyoukyksyaseikbn = "2";
                }
                else {
                    ztyhensyuuyoukyksyaseikbn = "0";
                }

                if (hensyuuyoukyksyaseiymd != null) {
                    ztyhensyuuyoukyksyaseiymd = hensyuuyoukyksyaseiymd.toString();
                }

                String ztyhrktuukakbn = editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getHrktuukasyu());

                String ztysiteituukakbn = editPalRenkeiKoumoku.editTuukaKbn(mosKihon.getKyktuukasyu());

                BizNumber ztyitijibaraipkyktuuka = BizNumber.valueOf(0);
                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                    if (BizNumber.valueOf(new BigDecimal(mosKihon.getSeitoufstpkei().toString())).compareTo(BizNumber.valueOf(9999999999999.99)) > 0) {
                        ztyitijibaraipkyktuuka = BizNumber.valueOf(9999999999999.99);
                    }
                    else {
                        ztyitijibaraipkyktuuka = BizNumber.valueOf(new BigDecimal(mosKihon.getSeitoufstpkei().toString()));
                    }
                }

                long ztykihonskyktuuka = 0;
                BizCurrency kihonskyktuuka = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu()));
                if (mosSyouhnLst != null) {
                    for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                        kihonskyktuuka = kihonskyktuuka.add(mosSyouhn.getSeitoukihons());
                    }
                    ztykihonskyktuuka = new BigDecimal(kihonskyktuuka.toAdsoluteString()).longValue();
                    ztykihonskyktuuka = chkKetasuu(ztykihonskyktuuka, 15);
                }
                long ztynnknsnpssysyup = 0;

                if (!C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())){

                    editPalRenkeiKoumoku.getSyuEntity(mosSyouhnLst);
                    if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(editPalRenkeiKoumoku.getSyouhnZokusei().getPtratkituukasiteikbn())) {

                        if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                            ztynnknsnpssysyup = new BigDecimal(mosKihon.getHeijyunp().toString()).longValue();
                        }

                        else {

                            ztynnknsnpssysyup = 0;
                        }
                    }

                    else {
                        ztynnknsnpssysyup = new BigDecimal(mosKihon.getHeijyunp().toAdsoluteString()).longValue();
                    }

                }

                ztynnknsnpssysyup = chkKetasuu(ztynnknsnpssysyup, 11);

                if (mosDairitenLst.size() == 0) {
                    ZT_EgsyokuinSysRendouTy egsyokuinSysRendouTy = new ZT_EgsyokuinSysRendouTy();

                    egsyokuinSysRendouTy.setZtysequenceno(count + 1);
                    egsyokuinSysRendouTy.setZtyatukaikojincd("000000");
                    egsyokuinSysRendouTy.setZtykydatkikbn("0");
                    egsyokuinSysRendouTy.setZtyatukaisosikicd("0000000");
                    egsyokuinSysRendouTy.setZtydairitenatkikeitaikbn("0");
                    egsyokuinSysRendouTy.setZtydrtenegsyokuinatkiwari(100);
                    egsyokuinSysRendouTy.setZtykjsakisosikisetteihyj("0");
                    egsyokuinSysRendouTy.setZtybsydrtencd("");
                    egsyokuinSysRendouTy.setZtycifcd("");
                    egsyokuinSysRendouTy.setZtybosdairitentsratkiwari(100);
                    egsyokuinSysRendouTy.setZtybosyuunincd("000000");

                    editEgsyokuinSysRendouTy(
                        syoriCTL,
                        mosKihon,
                        mosSyouhnBySyuLst,
                        nayoseKekkaByHihokensya,
                        nayoseKekkaByKeiyakusya,
                        mosSyouhnLst,
                        egsyokuinSysRendouTy,
                        ztykihons,
                        ztyharaikomip,
                        ztysyukeiyakup,
                        ztygyousekiyouhosyous,
                        ztysibous,
                        ztyjissyuup,
                        ztyitijibaraipkyktuuka,
                        ztykihonskyktuuka,
                        ztynnknsnpssysyup,
                        ztyhhknnen2keta,
                        ztykyksyanen,
                        ztyhensyuuyoukyksyaseikbn,
                        ztyhensyuuyoukyksyaseiymd,
                        ztyhrktuukakbn,
                        ztysiteituukakbn,
                        ztykawaseraten5);

                    BizPropertyInitializer.initialize(egsyokuinSysRendouTy);

                    BzEgsyokuinSysRendouSksConverter.convertPadding(egsyokuinSysRendouTy);

                    egsyokuinSysRendouTyInserter.add(egsyokuinSysRendouTy);

                    count++;
                }
                else {
                    for (HT_MosDairiten mosDairiten : mosDairitenLst) {
                        ZT_EgsyokuinSysRendouTy egsyokuinSysRendouTy = new ZT_EgsyokuinSysRendouTy();

                        egsyokuinSysRendouTy.setZtysequenceno(count + 1);

                        if (mosDairitenLst.size() == 1) {
                            egsyokuinSysRendouTy.setZtykydatkikbn("0");
                        }
                        else {
                            if (mosDairiten.getRenno() == 1) {
                                egsyokuinSysRendouTy.setZtykydatkikbn("1");
                            }
                            else {
                                egsyokuinSysRendouTy.setZtykydatkikbn("2");
                            }
                        }

                        if (!BizUtil.isBlank(mosDairiten.getDaibosyuucd())) {
                            egsyokuinSysRendouTy.setZtyatukaikojincd(mosDairiten.getDaibosyuucd());
                        }
                        else {
                            egsyokuinSysRendouTy.setZtyatukaikojincd("000000");
                        }

                        if (!BizUtil.isBlank(mosDairiten.getGyousekikeijyousakisosikicd())) {
                            egsyokuinSysRendouTy.setZtyatukaisosikicd(mosDairiten.getGyousekikeijyousakisosikicd());
                        }
                        else if (!BizUtil.isBlank(mosDairiten.getDrtenkanrisosikicd())) {
                            egsyokuinSysRendouTy.setZtyatukaisosikicd(mosDairiten.getDrtenkanrisosikicd());
                        }
                        else {
                            egsyokuinSysRendouTy.setZtyatukaisosikicd("0000000");
                        }

                        egsyokuinSysRendouTy.setZtydairitenatkikeitaikbn(editPalRenkeiKoumoku
                            .editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst));

                        if ("0".equals(egsyokuinSysRendouTy.getZtykydatkikbn())) {
                            egsyokuinSysRendouTy.setZtydrtenegsyokuinatkiwari(100);
                            egsyokuinSysRendouTy.setZtybosdairitentsratkiwari(100);
                        }
                        else {
                            egsyokuinSysRendouTy.setZtydrtenegsyokuinatkiwari(50);
                            egsyokuinSysRendouTy.setZtybosdairitentsratkiwari(50);
                        }

                        if (!BizUtil.isBlank(mosDairiten.getGyousekikeijyousakisosikicd())) {
                            egsyokuinSysRendouTy.setZtykjsakisosikisetteihyj("1");
                        }
                        else {
                            egsyokuinSysRendouTy.setZtykjsakisosikisetteihyj("0");
                        }

                        egsyokuinSysRendouTy.setZtybsydrtencd(mosDairiten.getTratkiagcd());
                        egsyokuinSysRendouTy.setZtycifcd(mosDairiten.getCifcd());
                        if (!BizUtil.isBlank(mosDairiten.getBosyuucd())) {
                            egsyokuinSysRendouTy.setZtybosyuunincd(mosDairiten.getBosyuucd());
                        }
                        else {
                            egsyokuinSysRendouTy.setZtybosyuunincd("000000");
                        }

                        editEgsyokuinSysRendouTy(
                            syoriCTL,
                            mosKihon,
                            mosSyouhnBySyuLst,
                            nayoseKekkaByHihokensya,
                            nayoseKekkaByKeiyakusya,
                            mosSyouhnLst,
                            egsyokuinSysRendouTy,
                            ztykihons,
                            ztyharaikomip,
                            ztysyukeiyakup,
                            ztygyousekiyouhosyous,
                            ztysibous,
                            ztyjissyuup,
                            ztyitijibaraipkyktuuka,
                            ztykihonskyktuuka,
                            ztynnknsnpssysyup,
                            ztyhhknnen2keta,
                            ztykyksyanen,
                            ztyhensyuuyoukyksyaseikbn,
                            ztyhensyuuyoukyksyaseiymd,
                            ztyhrktuukakbn,
                            ztysiteituukakbn,
                            ztykawaseraten5);

                        BizPropertyInitializer.initialize(egsyokuinSysRendouTy);

                        BzEgsyokuinSysRendouSksConverter.convertPadding(egsyokuinSysRendouTy);

                        egsyokuinSysRendouTyInserter.add(egsyokuinSysRendouTy);

                        count++;
                    }
                }

            }
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), kinou.getKinouNm()));
        }
    }

    private void editEgsyokuinSysRendouTy(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon,
        List<HT_MosSyouhn> pMosSyouhnBySyuLst, HT_NayoseKekka pNayoseKekkaByHihokensya,
        HT_NayoseKekka pNayoseKekkaByKeiyakusya, List<HT_MosSyouhn> pMosSyouhnLst,
        ZT_EgsyokuinSysRendouTy pEgsyokuinSysRendouTy, long pZtykihons, long pZtyharaikomip, long pZtysyukeiyakup,
        long pZtygyousekiyouhosyous, long pZtysibous, long pZtyjissyuup, BizNumber pZtyitijibaraipkyktuuka,
        long pZtykihonskyktuuka, long pZtynnknsnpssysyup, String pZtyhhknnen2keta, String pZtykyksyanen, String pZtyhensyuuyoukyksyaseikbn,
        String pZtyhensyuuyoukyksyaseiymd, String pZtyhrktuukakbn, String pZtysiteituukakbn, BizNumber pZtykawaseraten5) {


        EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);


        editPalRenkeiKoumoku.getSyuEntity(pMosSyouhnBySyuLst);
        editPalRenkeiKoumoku.editHknkkn(
            pMosKihon,
            editPalRenkeiKoumoku.getMosSyouhn(),
            editPalRenkeiKoumoku.getSyouhnZokusei());

        pEgsyokuinSysRendouTy.setZtysyono(pSyoriCTL.getSyono().substring(0, 11));
        if (pMosSyouhnBySyuLst.size() == 0) {
            pEgsyokuinSysRendouTy.setZtyhknsyukigou("");
            pEgsyokuinSysRendouTy.setZtyhknsyuruikigousedaikbn("");
            pEgsyokuinSysRendouTy.setZtyhknkkn("00");
            pEgsyokuinSysRendouTy.setZtysaimnkkykhyj("0");
            pEgsyokuinSysRendouTy.setZtynksyuruikbn1("0");
        }
        else {
            pEgsyokuinSysRendouTy.setZtyhknsyukigou(pMosSyouhnBySyuLst.get(0).getSyouhncd().substring(0, 2));
            pEgsyokuinSysRendouTy.setZtyhknsyuruikigousedaikbn(pMosSyouhnBySyuLst.get(0).getRyouritusdno()
                .substring(0, 1));
            pEgsyokuinSysRendouTy.setZtyhknkkn(editPalRenkeiKoumoku.getHknKkn());

            pEgsyokuinSysRendouTy.setZtysaimnkkykhyj(editPalRenkeiKoumoku.getSaiMnkKykHyj());

            pEgsyokuinSysRendouTy.setZtynksyuruikbn1(editPalRenkeiKoumoku.editNenkinsyu(pMosSyouhnBySyuLst.get(0)
                .getSknenkinsyu()));
        }

        pEgsyokuinSysRendouTy.setZtyphrkkikn(editPalRenkeiKoumoku.getHrkkkn());
        if (pMosKihon.getKykymd() != null) {
            pEgsyokuinSysRendouTy.setZtykykymd(pMosKihon.getKykymd().toString());
        }
        else {
            pEgsyokuinSysRendouTy.setZtykykymd("00000000");
        }

        if (C_Hrkkaisuu.ITIJI.eq(pMosKihon.getHrkkaisuu())) {
            pEgsyokuinSysRendouTy.setZtyannaifuyouriyuukbn("01");
        }
        else {
            pEgsyokuinSysRendouTy.setZtyannaifuyouriyuukbn("00");
        }

        pEgsyokuinSysRendouTy.setZtyhrkkaisuukbn(editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon));

        pEgsyokuinSysRendouTy.setZtyhrkkeirokbn(editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(
            pMosKihon.getHrkkeiro(), pMosKihon.getHrkkaisuu()));

        if (C_Sdpd.SD.eq(pMosKihon.getSdpdkbn())) {
            pEgsyokuinSysRendouTy.setZtysdpdkbn("1");
        }
        else if (C_Sdpd.PD.eq(pMosKihon.getSdpdkbn())) {
            pEgsyokuinSysRendouTy.setZtysdpdkbn("2");
        }
        else {
            pEgsyokuinSysRendouTy.setZtysdpdkbn("0");
        }

        pEgsyokuinSysRendouTy.setZtykihons(pZtykihons);
        pEgsyokuinSysRendouTy.setZtyharaikomip(pZtyharaikomip);
        pEgsyokuinSysRendouTy.setZtysyukeiyakup(pZtysyukeiyakup);
        pEgsyokuinSysRendouTy.setZtygyousekiyouhosyous(pZtygyousekiyouhosyous);
        pEgsyokuinSysRendouTy.setZtybsyym(pMosKihon.getBosyuuym().toString());
        pEgsyokuinSysRendouTy.setZtytsinkihontikucd(pMosKihon.getTsinyno());
        pEgsyokuinSysRendouTy.setZtyhhknseikbn(pMosKihon.getHhknsei().getValue());
        pEgsyokuinSysRendouTy.setZtyhhknnen2keta(pZtyhhknnen2keta);
        pEgsyokuinSysRendouTy.setZtyhensyuukeiyakusyamei(
            editPalRenkeiKoumoku.editKyknmkn(
                pMosKihon.getKykkbn(),
                pMosKihon.getHhknnmkn(),
                pMosKihon.getKyknmkn(),
                MAX_LENGTH_KYKNMKN));
        pEgsyokuinSysRendouTy.setZtyhnsyuknjkyksynm(
            editPalRenkeiKoumoku.editKyknmkj(
                pMosKihon.getKykkbn(),
                pMosKihon.getHhknnmkj(),
                pMosKihon.getKyknmkj(),
                MAX_LENGTH_KYKNMKJ));
        pEgsyokuinSysRendouTy.setZtykyksyanen(pZtykyksyanen);

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getMinyknkurikosiumu()) ||
            C_UmuKbn.ARI.eq(pSyoriCTL.getKettienkurikosiumu()) ||
            C_UmuKbn.ARI.eq(pSyoriCTL.getSrhkurikosiumu()) ||
            (pMosKihon.getMosym() != null &&
            BizDateUtil.compareYm(pMosKihon.getMosym(), pMosKihon.getBosyuuym()) == BizDateUtil.COMPARE_LESSER)) {
            pEgsyokuinSysRendouTy.setZtykurikosihyj("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtykurikosihyj("0");
        }

        if (C_Livhukaumu.ARI.eq(pMosKihon.getLivhukaumu())) {
            pEgsyokuinSysRendouTy.setZtylivingneedstkykarihyj("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtylivingneedstkykarihyj("0");
        }

        if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {
            pEgsyokuinSysRendouTy.setZtykyksyhhknsydouituhyouji("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtykyksyhhknsydouituhyouji("0");
        }

        if (C_HaitouKbn.YUUHAI.eq(pMosKihon.getHaitoukbn())) {
            pEgsyokuinSysRendouTy.setZtyhaitousiharaikbn("0");
        }
        else if (C_HaitouKbn.RISAHAI.eq(pMosKihon.getHaitoukbn())) {
            pEgsyokuinSysRendouTy.setZtyhaitousiharaikbn("1");
        }
        else if (C_HaitouKbn.NONE.eq(pMosKihon.getHaitoukbn())) {
            pEgsyokuinSysRendouTy.setZtyhaitousiharaikbn("2");
        }
        else {
            pEgsyokuinSysRendouTy.setZtyhaitousiharaikbn("0");
        }

        pEgsyokuinSysRendouTy.setZtysimetyokuzenbosyuuhyj("0");

        if (pSyoriCTL.getMosnrkymd() != null) {
            pEgsyokuinSysRendouTy.setZtymosnyuuryokuymd(pSyoriCTL.getMosnrkymd().toString());
        }
        else {
            pEgsyokuinSysRendouTy.setZtymosnyuuryokuymd("00000000");
        }

        if (pNayoseKekkaByHihokensya == null) {
            pEgsyokuinSysRendouTy.setZtyhhknsakuinmeino("0000000000");
        }
        else {
            if (!BizUtil.isBlank(pNayoseKekkaByHihokensya.getSakuinnmno())) {
                pEgsyokuinSysRendouTy.setZtyhhknsakuinmeino(pNayoseKekkaByHihokensya.getSakuinnmno());
            }
            else {
                pEgsyokuinSysRendouTy.setZtyhhknsakuinmeino("0000000000");
            }
        }

        pEgsyokuinSysRendouTy.setZtytokusyujimutoriatukaikbn("1");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x1(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x2(SrCommonConstants.HKNSYKGUYBI1X2_MANNENREIHOUSIKI);
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x3(SrCommonConstants.HKNSYKGUYBI1X3_SINHOKENHOUTEKIYOU);
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x4(SrCommonConstants.HKNSYKGUYBI1X4_SINTOKUJYOUTEKIYOU);
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x5("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x6("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x7("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x8("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x9("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x10("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x11("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x12("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x13("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x14("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x15("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x1("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x2("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x3("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x4("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x5("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x6("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x7("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x8("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x9("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi2x10("");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x1(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x2(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x3("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x4("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x5("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x6("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x7("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x8("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x9("0");
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x10("0");

        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getNstkhkkbn())) {
            pEgsyokuinSysRendouTy.setZtynstkarihyj("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtynstkarihyj("0");
        }

        pEgsyokuinSysRendouTy.setZtymosno(pSyoriCTL.getMosno().substring(0, 9));

        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getStdrsktkyhkkbn())) {
            pEgsyokuinSysRendouTy.setZtystdairiseikyuutkykarihyj("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtystdairiseikyuutkykarihyj("0");
        }

        pEgsyokuinSysRendouTy.setZtynenkansanp(0l);

        if (pNayoseKekkaByKeiyakusya == null) {
            pEgsyokuinSysRendouTy.setZtykyksyaskinmeino("0000000000");
        }
        else {
            if (!BizUtil.isBlank(pNayoseKekkaByKeiyakusya.getSakuinnmno())) {
                pEgsyokuinSysRendouTy.setZtykyksyaskinmeino(pNayoseKekkaByKeiyakusya.getSakuinnmno());
            }
            else {
                pEgsyokuinSysRendouTy.setZtykyksyaskinmeino("0000000000");
            }
        }

        pEgsyokuinSysRendouTy.setZtysibous(pZtysibous);
        pEgsyokuinSysRendouTy.setZtyjissyuup(pZtyjissyuup);

        if (pMosKihon.getSknnkaisiymd() != null) {
            pEgsyokuinSysRendouTy.setZtysekininkaisiymd(pMosKihon.getSknnkaisiymd().toString());
        }
        else {
            pEgsyokuinSysRendouTy.setZtysekininkaisiymd("00000000");
        }

        if (C_SntkhouKbn.NONE.eq(pMosKihon.getSntkhoukbn())) {
            pEgsyokuinSysRendouTy.setZtykokutiymd(pMosKihon.getMosymd().toString());
        }
        else {
            if (pSyoriCTL.getKktymd() != null) {
                pEgsyokuinSysRendouTy.setZtykokutiymd(pSyoriCTL.getKktymd().toString());
            }
            else {
                pEgsyokuinSysRendouTy.setZtykokutiymd("00000000");
            }
        }

        if (pSyoriCTL.getRyosyuymd() != null) {
            pEgsyokuinSysRendouTy.setZtysyokaipryosyuymd(pSyoriCTL.getRyosyuymd().toString());
        }
        else {
            pEgsyokuinSysRendouTy.setZtysyokaipryosyuymd("00000000");
        }

        if (pSyoriCTL.getSrsyoriymd() != null) {
            pEgsyokuinSysRendouTy.setZtyseirituymd(pSyoriCTL.getSrsyoriymd().toString());
        }
        else {
            pEgsyokuinSysRendouTy.setZtyseirituymd("00000000");
        }

        pEgsyokuinSysRendouTy.setZtydrtentsryhushrkykhyouji(pMosKihon.getTsryhshrkykumukbn().getValue());

        if (C_AisyoumeiKbn.BLNK.eq(pMosKihon.getAisyoumeikbn())) {
            pEgsyokuinSysRendouTy.setZtymdhnaisyoumeikbn("000");
        }
        else {
            pEgsyokuinSysRendouTy.setZtymdhnaisyoumeikbn(pMosKihon.getAisyoumeikbn().getValue());
        }

        pEgsyokuinSysRendouTy.setZtydairitenkykkanrino("00000000000");
        pEgsyokuinSysRendouTy.setZtykanjitsinkaiadr(pMosKihon.getTsinadr1kj() + pMosKihon.getTsinadr2kj()
            + pMosKihon.getTsinadr3kj());
        pEgsyokuinSysRendouTy.setZtytsintelno(pMosKihon.getTsintelno());
        pEgsyokuinSysRendouTy.setZtyhensyuuyoukyksyaseikbn(pZtyhensyuuyoukyksyaseikbn);
        pEgsyokuinSysRendouTy.setZtyhensyuuyoukyksyaseiymd(pZtyhensyuuyoukyksyaseiymd);
        pEgsyokuinSysRendouTy.setZtyhhknmei(pMosKihon.getHhknnmkn());
        pEgsyokuinSysRendouTy.setZtyknjhhknmei(pMosKihon.getHhknnmkj());

        if (pMosKihon.getHhknseiymd() != null) {
            pEgsyokuinSysRendouTy.setZtyhhknseiymd(pMosKihon.getHhknseiymd().toString());
        }
        else {
            pEgsyokuinSysRendouTy.setZtyhhknseiymd("00000000");
        }

        if (pMosKihon.getMosymd() != null) {
            pEgsyokuinSysRendouTy.setZtymusymd(pMosKihon.getMosymd().toString());
        }
        else {
            pEgsyokuinSysRendouTy.setZtymusymd("00000000");
        }

        if (pMosKihon.getMossakuseiymd() != null) {
            pEgsyokuinSysRendouTy.setZtymossyosakuseiymd(pMosKihon.getMossakuseiymd().toString());
        }
        else {
            pEgsyokuinSysRendouTy.setZtymossyosakuseiymd("00000000");
        }

        pEgsyokuinSysRendouTy.setZtyitijibaraipkyktuuka(pZtyitijibaraipkyktuuka);
        pEgsyokuinSysRendouTy.setZtykawaseraten5(pZtykawaseraten5);
        pEgsyokuinSysRendouTy.setZtyhrktuukakbn(pZtyhrktuukakbn);
        pEgsyokuinSysRendouTy.setZtysiteituukakbn(pZtysiteituukakbn);

        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getSyksbyensitihsyutkhkkbn())) {
            pEgsyokuinSysRendouTy.setZtysyksbsitihsyutkykarihyj("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtysyksbsitihsyutkykarihyj("0");
        }

        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getJyudkaigomehrtkhkkbn())) {
            pEgsyokuinSysRendouTy.setZtyskkaigomaehrtkykarihyj("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtyskkaigomaehrtkykarihyj("0");
        }

        pEgsyokuinSysRendouTy.setZtykihonskyktuuka(pZtykihonskyktuuka);

        if (C_BlnktkumuKbn.ARI.eq(pMosKihon.getZenkizennouumu())) {
            pEgsyokuinSysRendouTy.setZtyzenkizennouhyouji("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtyzenkizennouhyouji("0");
        }

        pEgsyokuinSysRendouTy.setZtynnknsnpssysyup(pZtynnknsnpssysyup);

        if (C_Hrkkaisuu.NEN.eq(pMosKihon.getHrkkaisuu())) {
            pEgsyokuinSysRendouTy.setZtynknsnpssyhrkkskbn("1");
        }
        else if (C_Hrkkaisuu.HALFY.eq(pMosKihon.getHrkkaisuu())) {
            pEgsyokuinSysRendouTy.setZtynknsnpssyhrkkskbn("2");
        }
        else if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {
            pEgsyokuinSysRendouTy.setZtynknsnpssyhrkkskbn("3");
        }
        else {
            pEgsyokuinSysRendouTy.setZtynknsnpssyhrkkskbn("0");
        }

        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getKykdrtkykhukakbn())) {
            pEgsyokuinSysRendouTy.setZtykykdrtkykarihyj("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtykykdrtkykarihyj("0");
        }

        if (C_KzktourokuserviceTourokuKbn.ARI.eq(pMosKihon.getKzktourokuservicetourokukbn())) {
            pEgsyokuinSysRendouTy.setZtykzktrkservicearihyj("1");
        }
        else {
            pEgsyokuinSysRendouTy.setZtykzktrkservicearihyj("0");
        }

    }

    private long chkKetasuu(long pChecktaisyou, int pKetasuu) {

        long result = 0;

        if (String.valueOf(pChecktaisyou).length() > pKetasuu) {
            if (pKetasuu == 11) {
                result = 99999999999l;
            }
            else if (pKetasuu == 15) {
                result = 999999999999999l;
            }
        }
        else {
            result = pChecktaisyou;
        }

        return result;

    }
}