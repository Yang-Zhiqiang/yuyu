package yuyu.batch.hozen.khozen.khrin1;

//import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
//import jp.co.slcs.swak.date.BizDate;
//import jp.co.slcs.swak.date.BizDateYM;
//import jp.co.slcs.swak.db.ExDBResults;
//import jp.co.slcs.swak.number.BizCurrency;
//import jp.co.slcs.swak.number.BizNumber;
//import jp.co.slcs.swak.number.currencytype.CurrencyType;
//import jp.co.slcs.swak.util.message.MessageUtil;
//import yuyu.batch.hozen.khozen.khrin1.dba.KhRin1Dao;
//import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
//import yuyu.common.biz.bzcommon.GetKawaseRate;
//import yuyu.common.biz.bzcommon.HenkanTuuka;
//import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
//import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
//import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
//import yuyu.common.hozen.khcommon.KeisanW;
//import yuyu.common.hozen.khcommon.KeisanWExt;
//import yuyu.common.hozen.khcommon.KeisanWExtBean;
//import yuyu.common.hozen.khcommon.KeisanWKijunYM;
//import yuyu.common.siharai.sicommon.CalcHkShrKngk;
//import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
//import yuyu.def.MessageId;
//import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
//import yuyu.def.classification.C_EigyoubiHoseiKbn;
//import yuyu.def.classification.C_ErrorKbn;
//import yuyu.def.classification.C_FileSyuruiCdKbn;
//import yuyu.def.classification.C_HasuusyoriKbn;
//import yuyu.def.classification.C_HokenkinsyuruiKbn;
//import yuyu.def.classification.C_KawaserateSyuruiKbn;
//import yuyu.def.classification.C_KawasetekiyoKbn;
//import yuyu.def.classification.C_KawasetsryKbn;
//import yuyu.def.classification.C_Kykjyoutai;
//import yuyu.def.classification.C_SiinKbn;
//import yuyu.def.classification.C_SyutkKbn;
//import yuyu.def.classification.C_Tuukasyu;
//import yuyu.def.classification.C_UmuKbn;
//import yuyu.def.classification.C_YouhiKbn;
//import yuyu.def.db.entity.BM_SyouhnZokusei;
//import yuyu.def.db.entity.IT_KhTtdkRireki;
//import yuyu.def.db.entity.IT_KykDairiten;
//import yuyu.def.db.entity.IT_KykKihon;
//import yuyu.def.db.entity.IT_KykSyouhn;
//import yuyu.def.db.entity.IT_NyknJissekiRireki;
//import yuyu.def.hozen.file.csv.KhItijibrHyukykInfoFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
//import yuyu.infr.batch.logger.BatchLogger;
//
//import com.google.common.collect.Lists;

/**
 * 契約保全 インターフェイス 契約保全臨時処理１
 */
public class KhRin1Batch implements Batch {

    //    private final int FILE_SAVE_MAX_LIST_COUNT = 4000;
    //
    //    private  final String RECOVERY_FILTER_ID =  "Kh001";
    //
    //    private  final String SONEKICALCHUNOUFLG_KANOU =  "0";
    //
    //    private  final String SONEKICALCHUNOUFLG_HUNOU =  "1";
    //
    //    @Inject
    //    private BatchLogger batchLogger;

    @Inject
    private KhRin1BatchParam batchParam;

    //    @Inject
    //    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;
    //
    //    @Inject
    //    private KhRin1Dao khRin1Dao;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        //        BizDate syoriYmd = batchParam.getSyoriYmd();
        //        String kakutyoujobCd = batchParam.getIbKakutyoujobcd();
        //
        //        batchLogger.info(
        //            MessageUtil.getMessage(
        //                MessageId.IBA0016,
        //                MessageUtil.getMessage(MessageId.IBW0003),
        //                String.valueOf(syoriYmd)));
        //
        //        BizDate tyusyutuYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        //        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        //        getKawaseRate.exec(
        //            tyusyutuYmd,
        //            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //            C_Tuukasyu.USD,
        //            C_Tuukasyu.JPY,
        //            C_KawasetekiyoKbn.TTM,
        //            C_KawasetsryKbn.SYUKKINRATE,
        //            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
        //            C_YouhiKbn.HUYOU);
        //
        //        BizNumber kawaseRateUsdShr = getKawaseRate.getKawaserate();
        //
        //        getKawaseRate.exec(
        //            tyusyutuYmd,
        //            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //            C_Tuukasyu.AUD,
        //            C_Tuukasyu.JPY,
        //            C_KawasetekiyoKbn.TTM,
        //            C_KawasetsryKbn.SYUKKINRATE,
        //            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
        //            C_YouhiKbn.HUYOU);
        //
        //        BizNumber kawaseRateAudShr = getKawaseRate.getKawaserate();
        //
        //        List<KhItijibrHyukykInfoFile> khItijibrHyukykInfoFileList = Lists.newArrayList();
        //        long syoriKensuu = 0;
        //
        //        try(ExDBResults<IT_KykKihon> itijibrHyukykInfoList =
        //            khRin1Dao.getItijibrHyukykInfo(kakutyoujobCd, tyusyutuYmd)) {
        //
        //            KhItijibrHyukykInfoFile khItijibrHyukykInfoFile = null;
        //
        //            for (IT_KykKihon kykKihon : itijibrHyukykInfoList) {
        //                String syono = kykKihon.getSyono();
        //                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
        //                bzRecoveryDatasikibetuBean.setIbTableid(IT_KykKihon.TABLE_NAME);
        //                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
        //                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syono);
        //
        //                String sonekicalchunouflg = SONEKICALCHUNOUFLG_KANOU;
        //                IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        //                IT_KykDairiten kykDairiten = kykKihon.getKykDairitens().get(0);
        //                C_Tuukasyu kykTuukasyu = kykSyouhn.getKyktuukasyu();
        //
        //                String tuuka = "";
        //
        //                if (C_Tuukasyu.USD.eq(kykTuukasyu)) {
        //                    tuuka = "1";
        //                }
        //                else if (C_Tuukasyu.AUD.eq(kykTuukasyu)) {
        //                    tuuka = "15";
        //                }
        //
        //                C_UmuKbn gengakuUmu = C_UmuKbn.NONE;
        //
        //                List<IT_KhTtdkRireki> ttdkRirekiList =
        //                    kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
        //                        IKhozenCommonConstants.KINOUID_GENGAKU);
        //
        //                if (ttdkRirekiList.size() > 0) {
        //                    gengakuUmu = C_UmuKbn.ARI;
        //                }
        //
        //                KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        //                KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        //                KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        //
        //                BizDateYM kaiyakuhrKeisankijyunYm =
        //                    keisanWKijunYM.exec(
        //                        kykSyouhn.getKykymd(),
        //                        tyusyutuYmd,
        //                        null,
        //                        kykKihon.getHrkkaisuu(),
        //                        C_Kykjyoutai.ITIJIBARAI);
        //
        //                C_ErrorKbn errorKbn = keisanWExt.exec(syono, tyusyutuYmd);
        //
        //                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
        //                    sonekicalchunouflg = SONEKICALCHUNOUFLG_HUNOU;
        //                }
        //
        //                KeisanWExtBean keisanWExtBean = keisanWExt.getKeisanWExtBean();
        //
        //                errorKbn =
        //                    keisanW.exec(
        //                        tyusyutuYmd,
        //                        kaiyakuhrKeisankijyunYm,
        //                        keisanWExtBean);
        //
        //                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
        //                    sonekicalchunouflg = SONEKICALCHUNOUFLG_HUNOU;
        //                }
        //
        //                BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        //
        //                CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        //                errorKbn = calcHkShrKngk.exec(
        //                    keisanWExtBean.getSyouhncd(),
        //                    keisanWExtBean.getSyouhnsdno(),
        //                    keisanWExtBean.getRyouritusdno(),
        //                    keisanWExtBean.getYoteiriritu(),
        //                    keisanWExtBean.getHrkkaisuu(),
        //                    keisanWExtBean.getHknkknsmnkbn(),
        //                    keisanWExtBean.getHknkkn(),
        //                    keisanWExtBean.getHrkkkn(),
        //                    keisanWExtBean.getHhknnen(),
        //                    keisanWExtBean.getHhknsei(),
        //                    keisanWExtBean.getKihons(),
        //                    keisanWExtBean.getKykymd(),
        //                    tyusyutuYmd,
        //                    syono,
        //                    keisanWExtBean.getTuukasyu(),
        //                    syouhnZokusei.getDai1hknkkn(),
        //                    syouhnZokusei.getMvatekikkn(),
        //                    C_SiinKbn.SP,
        //                    C_HokenkinsyuruiKbn.SBHOKENKIN,
        //                    keisanWExtBean.getHokenryou(),
        //                    keisanWExtBean.getKaiyakusjkkktyouseiriritu(),
        //                    keisanWExtBean.getKyksjkkktyouseiriritu(),
        //                    keisanWExtBean.getTmttkntaisyouym(),
        //                    keisanWExtBean.getTeiritutmttkngk(),
        //                    keisanWExtBean.getSisuurendoutmttkngk(),
        //                    keisanWExtBean.getTumitateriritu(),
        //                    keisanWExtBean.getHrkkknsmnkbn(),
        //                    keisanWExtBean.getJkipjytym(),
        //                    keisanWExtBean.getPtmttkngk(),
        //                    keisanWExtBean.getKihrkmpstgk(),
        //                    keisanWExtBean.getFstpryosyuymd(),
        //                    keisanWExtBean.getYoteirrthendohosyurrt(),
        //                    C_Kykjyoutai.ITIJIBARAI,
        //                    null);
        //
        //                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
        //
        //                    sonekicalchunouflg = SONEKICALCHUNOUFLG_HUNOU;
        //                }
        //
        //                CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();
        //
        //                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        //                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(kykTuukasyu);
        //                BizCurrency itijipGaika = BizCurrency.valueOf(0, currencyType);
        //                BizCurrency kiuktrknGaika = BizCurrency.valueOf(0, currencyType);
        //                BizCurrency kaiyakuHrGaika = BizCurrency.valueOf(0, currencyType);
        //                BizCurrency tmttKngkGaika = BizCurrency.valueOf(0, currencyType);
        //                BizCurrency kaiyakukjetcGaika = BizCurrency.valueOf(0, currencyType);
        //                BizCurrency sonekiGaika = BizCurrency.valueOf(0, currencyType);
        //                BizCurrency sbsetcGaika = BizCurrency.valueOf(0, currencyType);
        //                BizCurrency itijipYen = BizCurrency.valueOf(0);
        //                BizCurrency kiuktrknYen = BizCurrency.valueOf(0);
        //                BizCurrency kaiyakuHrYen = BizCurrency.valueOf(0);
        //                BizCurrency tmttKngkYen = BizCurrency.valueOf(0);
        //                BizCurrency kaiyakukjetcYen = BizCurrency.valueOf(0);
        //                BizCurrency sonekiYen = BizCurrency.valueOf(0);
        //                BizCurrency sbsetcYen = BizCurrency.valueOf(0);
        //
        //                if (SONEKICALCHUNOUFLG_KANOU.equals(sonekicalchunouflg)) {
        //                    itijipGaika = kykSyouhn.getHokenryou();
        //                    kaiyakuHrGaika = keisanW.getW();
        //                    tmttKngkGaika = keisanW.getV();
        //                    kaiyakukjetcGaika = tmttKngkGaika.subtract(kaiyakuHrGaika);
        //                    sonekiGaika = kaiyakuHrGaika.subtract(itijipGaika);
        //                    sbsetcGaika = calcHkShrKngkBean.getSibousGk();
        //
        //                    IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.getNyknJissekiRirekis().get(0);
        //                    BizDate ryosyuymd = nyknJissekiRireki.getRyosyuymd();
        //                    C_Tuukasyu rstuukasyu = nyknJissekiRireki.getRstuukasyu();
        //                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        //
        //                    if (C_UmuKbn.NONE.eq(gengakuUmu) && C_Tuukasyu.JPY.eq(rstuukasyu)) {
        //                        itijipYen = nyknJissekiRireki.getRsgaku();
        //                    }
        //                    else {
        //                        if (C_Tuukasyu.USD.eq(kykTuukasyu)) {
        //                            getKawaseRate.exec(
        //                                ryosyuymd,
        //                                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //                                C_Tuukasyu.USD,
        //                                C_Tuukasyu.JPY,
        //                                C_KawasetekiyoKbn.TTM,
        //                                C_KawasetsryKbn.NYUKINRATE,
        //                                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
        //                                C_YouhiKbn.HUYOU);
        //
        //                            BizNumber kawaseRateUsdNyukn = getKawaseRate.getKawaserate();
        //
        //                            itijipYen = keisanGaikakanzan.exec(
        //                                C_Tuukasyu.JPY,
        //                                itijipGaika,
        //                                kawaseRateUsdNyukn,
        //                                C_HasuusyoriKbn.SUTE);
        //                        }
        //                        else if (C_Tuukasyu.AUD.eq(kykTuukasyu)) {
        //                            getKawaseRate.exec(
        //                                ryosyuymd,
        //                                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //                                C_Tuukasyu.AUD,
        //                                C_Tuukasyu.JPY,
        //                                C_KawasetekiyoKbn.TTM,
        //                                C_KawasetsryKbn.NYUKINRATE,
        //                                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
        //                                C_YouhiKbn.HUYOU);
        //
        //                            BizNumber kawaseRateAudNyukn = getKawaseRate.getKawaserate();
        //
        //                            itijipYen = keisanGaikakanzan.exec(
        //                                C_Tuukasyu.JPY,
        //                                itijipGaika,
        //                                kawaseRateAudNyukn,
        //                                C_HasuusyoriKbn.SUTE);
        //                        }
        //                    }
        //
        //                    if (C_Tuukasyu.USD.eq(kykTuukasyu)) {
        //                        kaiyakuHrYen = keisanGaikakanzan.exec(
        //                            C_Tuukasyu.JPY,
        //                            kaiyakuHrGaika,
        //                            kawaseRateUsdShr,
        //                            C_HasuusyoriKbn.AGE);
        //
        //                        tmttKngkYen = keisanGaikakanzan.exec(
        //                            C_Tuukasyu.JPY,
        //                            tmttKngkGaika,
        //                            kawaseRateUsdShr,
        //                            C_HasuusyoriKbn.AGE);
        //
        //                        sbsetcYen = keisanGaikakanzan.exec(
        //                            C_Tuukasyu.JPY,
        //                            sbsetcGaika,
        //                            kawaseRateUsdShr,
        //                            C_HasuusyoriKbn.AGE);
        //                    }
        //                    else if (C_Tuukasyu.AUD.eq(kykTuukasyu)) {
        //                        kaiyakuHrYen = keisanGaikakanzan.exec(
        //                            C_Tuukasyu.JPY,
        //                            kaiyakuHrGaika,
        //                            kawaseRateAudShr,
        //                            C_HasuusyoriKbn.AGE);
        //
        //                        tmttKngkYen = keisanGaikakanzan.exec(
        //                            C_Tuukasyu.JPY,
        //                            tmttKngkGaika,
        //                            kawaseRateAudShr,
        //                            C_HasuusyoriKbn.AGE);
        //
        //                        sbsetcYen = keisanGaikakanzan.exec(
        //                            C_Tuukasyu.JPY,
        //                            sbsetcGaika,
        //                            kawaseRateAudShr,
        //                            C_HasuusyoriKbn.AGE);
        //                    }
        //
        //                    kaiyakukjetcYen = tmttKngkYen.subtract(kaiyakuHrYen);
        //                    sonekiYen = kaiyakuHrYen.subtract(itijipYen);
        //                }
        //
        //                khItijibrHyukykInfoFile = new KhItijibrHyukykInfoFile();
        //
        //                khItijibrHyukykInfoFile.setIfcHknkaisyacd("DT");
        //                khItijibrHyukykInfoFile.setIfcSyono(syono);
        //                khItijibrHyukykInfoFile.setIfcEdano("001");
        //                khItijibrHyukykInfoFile.setIfcTuuka(tuuka);
        //                khItijibrHyukykInfoFile.setIfcItijipyen(itijipYen.toString());
        //                khItijibrHyukykInfoFile.setIfcItijipgaika(itijipGaika.toString());
        //                khItijibrHyukykInfoFile.setIfcKiuktrknyen(kiuktrknYen.toString());
        //                khItijibrHyukykInfoFile.setIfcKiuktrkngaika(kiuktrknGaika.toString());
        //                khItijibrHyukykInfoFile.setIfcTmttknyen(tmttKngkYen.toString());
        //                khItijibrHyukykInfoFile.setIfcTmttkngaika(tmttKngkGaika.toString());
        //                khItijibrHyukykInfoFile.setIfcKaiyakukjetcyen(kaiyakukjetcYen.toString());
        //                khItijibrHyukykInfoFile.setIfcKaiyakukjetcgaika(kaiyakukjetcGaika.toString());
        //                khItijibrHyukykInfoFile.setIfcKaiyakuhrknyen(kaiyakuHrYen.toString());
        //                khItijibrHyukykInfoFile.setIfcKaiyakuhrkngaika(kaiyakuHrGaika.toString());
        //                khItijibrHyukykInfoFile.setIfcSonekiyen(sonekiYen.toString());
        //                khItijibrHyukykInfoFile.setIfcSonekigaika(sonekiGaika.toString());
        //                khItijibrHyukykInfoFile.setIfcSbsetcyen(sbsetcYen.toString());
        //                khItijibrHyukykInfoFile.setIfcSbsetcgaika(sbsetcGaika.toString());
        //                khItijibrHyukykInfoFile.setIfcSonekicalchunouflg(sonekicalchunouflg);
        //                khItijibrHyukykInfoFile.setIfcHknsyuruikigou(kykSyouhn.getSyouhncd());
        //                khItijibrHyukykInfoFile.setIfcHrkzumikurisagehyouji("0");
        //                khItijibrHyukykInfoFile.setIfcOyadrtencd(kykDairiten.getOyadrtencd());
        //                khItijibrHyukykInfoFile.setIfcAisyoumeicd(kykKihon.getAisyoumeikbn().getValue());
        //
        //                khItijibrHyukykInfoFileList.add(khItijibrHyukykInfoFile);
        //                syoriKensuu = syoriKensuu + 1;
        //            }
        //
        //            bzRecoveryDatasikibetuBean.initializeBlank();
        //        }
        //
        //        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        //
        //        int renNo = 1;
        //
        //        if (!khItijibrHyukykInfoFileList.isEmpty()) {
        //            List<List<KhItijibrHyukykInfoFile>> bunkatuList =
        //                Lists.partition(khItijibrHyukykInfoFileList, FILE_SAVE_MAX_LIST_COUNT);
        //
        //            for(List<KhItijibrHyukykInfoFile> list:bunkatuList) {
        //                bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_ITIJIBRHYUKYKINFOFILE, list, true, String.valueOf(renNo));
        //                renNo = renNo + 1;
        //            }
        //        }
        //
        //        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    //    @AppBatchExceptionTerminate
    //    private void appBatchExceptionTerminate() {
    //
    //        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
    //            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
    //
    //        bzBatchAbendCommonRecovery.exec();
    //    }
}
