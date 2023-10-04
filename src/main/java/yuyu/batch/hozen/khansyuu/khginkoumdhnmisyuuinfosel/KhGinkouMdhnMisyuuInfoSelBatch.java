package yuyu.batch.hozen.khansyuu.khginkoumdhnmisyuuinfosel;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khginkoumdhnmisyuuinfosel.dba.AnnaiSyunouDataBean;
import yuyu.batch.hozen.khansyuu.khginkoumdhnmisyuuinfosel.dba.AnnaiSyunouRirekiBean;
import yuyu.batch.hozen.khansyuu.khginkoumdhnmisyuuinfosel.dba.KhGinkouMdhnMisyuuInfoSelDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.interf.IGWKoumoku;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SeihokisyacdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 銀行窓販未収情報抽出
 */
public class KhGinkouMdhnMisyuuInfoSelBatch implements Batch {

    private static final String TABLEID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERYFILTERID = "Kh001";

    private static final String GUNMABANKKNYUUCD = "0128";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhGinkouMdhnMisyuuInfoSelDao khGinkouMdhnMisyuuInfoSelDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        long syoriKensuu = 0;
        BizDateYM syoriYmdYm = syoriYmd.getBizDateYM();
        BizDateYM syoriYmPreMonth = syoriYmdYm.getPreviousMonth();
        BizDate tougetuDai7Eigyoubi = syoriYmPreMonth.getLastDay().addBusinessDays(7);
        String kinouID = khozenCommonParam.getFunctionId();
        String userID = khozenCommonParam.getUserID();
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        BizDate tougetu12Bi = null;

        if (syoriYmPreMonth.getLastDay().addDays(12).isBusinessDay()) {
            tougetu12Bi = syoriYmPreMonth.getLastDay().addDays(12);
        }
        else {
            tougetu12Bi = syoriYmPreMonth.getLastDay().addDays(12).getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }

        BizDate dai1SitufuriHanteibi = null;

        if (BizDateUtil.compareYmd(tougetuDai7Eigyoubi, tougetu12Bi) == BizDateUtil.COMPARE_LESSER) {
            dai1SitufuriHanteibi = tougetuDai7Eigyoubi;
        }
        else {
            dai1SitufuriHanteibi = tougetu12Bi;
        }

        try (ExDBResults<AnnaiSyunouDataBean> annaiSyunouDataBeanList =
            khGinkouMdhnMisyuuInfoSelDao.getAnnaiSyunouDataBeans(kakutyouJobCd, syoriYmPreMonth);
            EntityInserter<IT_KhGinkouMdhnMisyuuInfo> entityInserter = new EntityInserter<>();) {

            SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);
            long cnt = 0;

            setHurikaebi.exec(syoriYmd);

            BizDate tyokuzenHurikaebi = setHurikaebi.getTyokuzenHurikaebi();

            BizDate tyokuzenHurikaebi5BusinessDay = tyokuzenHurikaebi.addBusinessDays(5);

            if (BizDateUtil.compareYmd(syoriYmd, tyokuzenHurikaebi5BusinessDay) == BizDateUtil.COMPARE_EQUAL) {

                cnt = khGinkouMdhnMisyuuInfoSelDao.getAnsyuKihonCount(tyokuzenHurikaebi, GUNMABANKKNYUUCD);
            }

            if (BizDateUtil.compareYmd(syoriYmd, tyokuzenHurikaebi5BusinessDay) != BizDateUtil.COMPARE_EQUAL || cnt != 0) {

                AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks =
                    SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
                ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(100);

                for (AnnaiSyunouDataBean annaiSyunouDataBean : annaiSyunouDataBeanList) {

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(annaiSyunouDataBean.getKbnkey());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(annaiSyunouDataBean.getSyono());

                    BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                        annaiSyunouDataBean.getSyouhncd(), annaiSyunouDataBean.getSyouhnsdno());

                    String misyuuJiyuu = null;

                    if (!C_Hrkkeiro.KOUHURI.eq(annaiSyunouDataBean.getHrkkeiro())) {
                        misyuuJiyuu = IGWKoumoku.GW_MISYUUJIYUU_SONOTA;
                    }
                    else {
                        List<AnnaiSyunouRirekiBean> annaiSyunouRirekiBeanList = khGinkouMdhnMisyuuInfoSelDao
                            .getAnnaiSyuunouRirekiBeans(annaiSyunouDataBean.getSyono(), syoriYmPreMonth);

                        if (annaiSyunouRirekiBeanList.size() == 0) {
                            misyuuJiyuu = IGWKoumoku.GW_MISYUUJIYUU_SONOTA;
                        }
                        else {
                            AnnaiSyunouRirekiBean annaiSyunouRirekiBean = annaiSyunouRirekiBeanList.get(0);

                            BizDateYM saisyuuAnnaiJyutouYm = annaiSyunouRirekiBean.getJyuutouym()
                                .addYears(annaiSyunouRirekiBean.getJyutoukaisuuy())
                                .addMonths(annaiSyunouRirekiBean.getJyutoukaisuum());

                            if (BizDateUtil.compareYm(saisyuuAnnaiJyutouYm, syoriYmPreMonth) == BizDateUtil.COMPARE_GREATER) {
                                if (!C_HurihunoKbn.BLNK.eq(annaiSyunouRirekiBean.getHurihunokbn())) {
                                    if (annaiSyunouRirekiBean.getHrkkaisuu().eq(annaiSyunouDataBean.getHrkkaisuu())) {
                                        if (C_HurihunoKbn.SIKINHUSOKU.eq(annaiSyunouRirekiBean.getHurihunokbn())) {
                                            misyuuJiyuu = IGWKoumoku.GW_MISYUUJIYUU_ZANDAKAHUSOKU;
                                        }
                                        else if(C_HurihunoKbn.NOKOZA.eq(annaiSyunouRirekiBean.getHurihunokbn())){
                                            misyuuJiyuu = IGWKoumoku.GW_MISYUUJIYUU_KOUZAHUMEI;
                                        }
                                        else {
                                            misyuuJiyuu = IGWKoumoku.GW_MISYUUJIYUU_SONOTA;
                                        }
                                    }
                                    else {
                                        misyuuJiyuu = IGWKoumoku.GW_MISYUUJIYUU_SONOTA;
                                    }
                                }
                                else {
                                    misyuuJiyuu = IGWKoumoku.GW_MISYUUJIYUU_SONOTA;
                                }
                            }
                            else {
                                misyuuJiyuu = IGWKoumoku.GW_MISYUUJIYUU_SONOTA;
                            }

                        }
                    }

                    BizCurrency misyuukg = BizCurrency.valueOf(0, annaiSyunouDataBean.getHokenryou().getType());
                    C_Nykkeiro nykkeiro = null;
                    BizDate ryousyuuYmd = null;
                    int jyuutouTukisuu = 0;
                    int jyuutouNensuu = 0;

                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(annaiSyunouDataBean.getSyono());

                    if (C_Hrkkeiro.KOUHURI.eq(annaiSyunouDataBean.getHrkkeiro())) {

                        nykkeiro = C_Nykkeiro.KZHRK;

                        setHurikaebi.exec(syoriYmd);

                        ryousyuuYmd = setHurikaebi.getTyokugoHurikaebi();
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(annaiSyunouDataBean.getHrkkeiro())) {

                        nykkeiro = C_Nykkeiro.CREDIT;

                        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);
                        setCreditUriageSeikyuubi.exec(syoriYmd);

                        ryousyuuYmd = setCreditUriageSeikyuubi.getJikaiUrskbi();
                    }

                    int misyuuKikan = BizDateUtil.calcDifferenceMonths(syoriYmdYm, annaiSyunouDataBean.getJkipjytym());

                    if (C_Hrkkaisuu.TUKI.eq(annaiSyunouDataBean.getHrkkaisuu())) {

                        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(annaiSyunouDataBean.getTikiktbrisyuruikbn())) {

                            if (misyuuKikan < 7) {

                                jyuutouTukisuu = Integer.parseInt(annaiSyunouDataBean.getTikiktbrisyuruikbn().getValue());
                            }
                            else {

                                jyuutouTukisuu = Integer.parseInt(annaiSyunouDataBean.getTikiktbrisyuruikbn().getValue()) * 2;
                            }
                        }
                        else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(annaiSyunouDataBean.getTikiktbrisyuruikbn())) {

                            jyuutouTukisuu = Integer.parseInt(annaiSyunouDataBean.getTikiktbrisyuruikbn().getValue());
                        }
                        else {

                            jyuutouTukisuu = misyuuKikan;
                        }
                    }
                    else if (C_Hrkkaisuu.HALFY.eq(annaiSyunouDataBean.getHrkkaisuu())) {

                        if (misyuuKikan < 7) {

                            jyuutouTukisuu = Integer.parseInt(annaiSyunouDataBean.getHrkkaisuu().getValue());
                        }
                        else {

                            jyuutouTukisuu = Integer.parseInt(annaiSyunouDataBean.getHrkkaisuu().getValue()) * 2;
                        }
                    }
                    else if (C_Hrkkaisuu.NEN.eq(annaiSyunouDataBean.getHrkkaisuu())) {

                        jyuutouNensuu = 1;
                    }

                    KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                    C_ErrorKbn resultKbn = keisanRsgaku.exec(
                        kykKihon,
                        nykkeiro,
                        C_NyknaiyouKbn.KEIZOKUP,
                        ryousyuuYmd,
                        annaiSyunouDataBean.getJkipjytym(),
                        jyuutouNensuu,
                        jyuutouTukisuu);

                    if (C_ErrorKbn.ERROR.eq(resultKbn)) {

                        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kykKihon.getSyono(),
                            MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                        kykKihon.detach();

                        continue;
                    }

                    KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();

                    misyuukg = keisanRsgkOutBean.getRsgakuGoukei();

                    C_IkkatubaraiKbn  ikkatubaraiKbn  = C_IkkatubaraiKbn.BLNK;
                    C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.BLNK;

                    if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu()) &&
                        C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                        ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                        ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;
                    }
                    else if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu()) &&
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                        ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                        ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;
                    }

                    String drtencd = null;

                    List<IT_KykDairiten> kykDairitenList = kykKihon.getKykDairitens();

                    for (IT_KykDairiten kykDairiten : kykDairitenList) {

                        if (!BizUtil.isBlank(drtencd) && drtencd.equals(kykDairiten.getDrtencd())) {
                            break;
                        }

                        khozenCommonParam.setSikibetuKey(null);
                        String henkousikibetukey = khozenCommonParam.getSikibetuKey(annaiSyunouDataBean.getSyono());

                        IT_KhGinkouMdhnMisyuuInfo khGinkouMdhnMisyuuInfo =
                            new IT_KhGinkouMdhnMisyuuInfo(syoriYmd, annaiSyunouDataBean.getSyono(), henkousikibetukey);

                        khGinkouMdhnMisyuuInfo.setGwbsydrtencd(kykDairiten.getDrtencd());
                        khGinkouMdhnMisyuuInfo.setGwdatakbn(IGWKoumoku.GW_MISYUUDATAKBN_HASSEI);

                        if (BizDateUtil.compareYmd(syoriYmd, dai1SitufuriHanteibi) == BizDateUtil.COMPARE_EQUAL) {
                            khGinkouMdhnMisyuuInfo.setGwdatasakuseiymd(String.valueOf(tougetu12Bi));
                        }
                        else {
                            khGinkouMdhnMisyuuInfo.setGwdatasakuseiymd(String.valueOf(syoriYmd));
                        }

                        khGinkouMdhnMisyuuInfo.setGwhknkaisyacd(C_SeihokisyacdKbn.SUMITOMO.getValue());
                        khGinkouMdhnMisyuuInfo.setGwhknsyuruicd(syouhnZokusei.getGwhknsyurui());
                        khGinkouMdhnMisyuuInfo.setGwsyonosyuban(annaiSyunouDataBean.getSyono());
                        khGinkouMdhnMisyuuInfo.setGwmisyuutatekaekbn(IGWKoumoku.GW_MISYUUTATEKAEKBN_MISYUU);
                        khGinkouMdhnMisyuuInfo.setGwmisyuutatekaeym(String.valueOf(syoriYmPreMonth));
                        khGinkouMdhnMisyuuInfo.setGwmisyuukg(String.valueOf(misyuukg));

                        if (C_Hrkkaisuu.TUKI.eq(annaiSyunouDataBean.getHrkkaisuu())) {
                            khGinkouMdhnMisyuuInfo.setGwbnkaisuu(IGWKoumoku.GW_BNKAISUU_TUKI);
                        }
                        else if (C_Hrkkaisuu.NEN.eq(annaiSyunouDataBean.getHrkkaisuu())) {
                            khGinkouMdhnMisyuuInfo.setGwbnkaisuu(IGWKoumoku.GW_BNKAISUU_NEN);
                        }
                        else if (C_Hrkkaisuu.ITIJI.eq(annaiSyunouDataBean.getHrkkaisuu())) {
                            khGinkouMdhnMisyuuInfo.setGwbnkaisuu(IGWKoumoku.GW_BNKAISUU_ITIJI);
                        }
                        else if (C_Hrkkaisuu.HALFY.eq(annaiSyunouDataBean.getHrkkaisuu())) {
                            khGinkouMdhnMisyuuInfo.setGwbnkaisuu(IGWKoumoku.GW_BNKAISUU_HALFY);
                        }

                        khGinkouMdhnMisyuuInfo.setGwmisyuujiyuu(misyuuJiyuu);

                        khGinkouMdhnMisyuuInfo.setGwjikaidatakousinymd(
                            String.valueOf(syoriYmd.addMonths(3).getRekijyou()));

                        khGinkouMdhnMisyuuInfo.setIkkatubaraikbn(ikkatubaraiKbn);
                        khGinkouMdhnMisyuuInfo.setIkkatubaraikaisuu(ikkatubaraikaisuu);

                        khGinkouMdhnMisyuuInfo.setGyoumuKousinKinou(kinouID);
                        khGinkouMdhnMisyuuInfo.setGyoumuKousinsyaId(userID);
                        khGinkouMdhnMisyuuInfo.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(khGinkouMdhnMisyuuInfo);

                        entityInserter.add(khGinkouMdhnMisyuuInfo);

                        syoriKensuu = syoriKensuu + 1;

                        drtencd =  kykDairiten.getDrtencd();
                    }

                    kykKihon.detach();
                }

                if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {
                    ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYmd);
                }
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
