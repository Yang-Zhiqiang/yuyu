package yuyu.batch.hozen.khansyuu.khkawaseratetuutidatasks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.collect.Lists;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkawaseratetuutidatasks.dba.KawaseRateTuutiDataSksBean;
import yuyu.batch.hozen.khansyuu.khkawaseratetuutidatasks.dba.KhKawaseRateTuutiDataSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KawaseRateTuutiData;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.hozen.file.csv.KhKawaseRateTuutiCsvfFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KykDairitensMinDrtenrennoBySyonoBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
/**
 * 契約保全 案内収納 為替レート通知データ作成
 */
public class KhKawaseRateTuutiDataSksBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_AnsyuRireki.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private List<KhKawaseRateTuutiCsvfFile> khKawaseRateTuutiCsvfFileLst = new ArrayList<>();

    private final int CSV_OUT_MAX = 1000;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhKawaseRateTuutiDataSksDao khKawaseRateTuutiDataSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobcd));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        long count = 0;
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks =
            SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        int errerLimit = 50;
        ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(errerLimit);

        hozenDomManager.delete(hozenDomManager.getAllKawaseRateTuutiData());
        hozenDomManager.flush();

        try (ExDBResults<KawaseRateTuutiDataSksBean> kawaseRateTuutiDataSksBeanExDBResults =
            khKawaseRateTuutiDataSksDao.getKawaseRateTuutiDataSks(syoriYmd, kakutyoujobcd);

            EntityInserter<IT_KawaseRateTuutiData> kawaseRateTuutiDataIns = new EntityInserter<>();) {

            for (KawaseRateTuutiDataSksBean kawaseRateTuutiDataSksBean : kawaseRateTuutiDataSksBeanExDBResults) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kawaseRateTuutiDataSksBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kawaseRateTuutiDataSksBean.getSyono());

                Integer jyuutounensuu = 0;
                Integer jyuutoutukisuu = 0;
                String dairitenANm = "";
                String dairitenACd = "";

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(kawaseRateTuutiDataSksBean.getSyono());

                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(kawaseRateTuutiDataSksBean.getSyono());
                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    checkYuukouJyoutai.detachAllEntities(kawaseRateTuutiDataSksBean.getSyono());
                    continue;
                }

                if (C_Hrkkaisuu.NEN.eq(kawaseRateTuutiDataSksBean.getHrkkaisuu())) {
                    jyuutounensuu = 1;
                }
                else {
                    jyuutoutukisuu = Integer.valueOf(kawaseRateTuutiDataSksBean.getHrkkaisuu().getValue());
                }

                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);
                C_ErrorKbn keisanRsgakuErrorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
                    syoriYmd, kawaseRateTuutiDataSksBean.getJkipjytym(), jyuutounensuu, jyuutoutukisuu);
                KeisanRsgkOutBean keisanRsgkOutBean = null;
                if (C_ErrorKbn.OK.eq(keisanRsgakuErrorKbn)) {
                    keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();
                }
                else {
                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kawaseRateTuutiDataSksBean.getSyono(),
                        MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                    checkYuukouJyoutai.detachAllEntities(kawaseRateTuutiDataSksBean.getSyono());
                    continue;

                }

                IT_KykSya kykSya = kykKihon.getKykSya();
                IT_HhknSya hhknSya = kykKihon.getHhknSya();
                IT_Kouza kouza = kykKihon.getKouza();
                List<KykDairitensMinDrtenrennoBySyonoBean> kykDairitensMinDrtenrennoBySyonoBeanLst = hozenDomManager.
                    getKykDairitensDrtencdMinDrtenrennoBySyono(kawaseRateTuutiDataSksBean.getSyono());

                if (kykDairitensMinDrtenrennoBySyonoBeanLst.size() != 0) {
                    dairitenACd = kykDairitensMinDrtenrennoBySyonoBeanLst.get(0).getDrtencd();

                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(dairitenACd);

                    if (bzGetAgInfoBeanLst != null && bzGetAgInfoBeanLst.size() != 0 &&
                        !BizUtil.isBlank(bzGetAgInfoBeanLst.get(0).getKanjiHoujinSyougou())) {

                        dairitenANm = bzGetAgInfoBeanLst.get(0).getKanjiHoujinSyougou();
                    }
                }
                IT_KawaseRateTuutiData kawaseRateTuutiData = new IT_KawaseRateTuutiData(kawaseRateTuutiDataSksBean.getSyono(), syoriYmd, 1);
                kawaseRateTuutiData.setShskyno(kykSya.getTsinyno());
                kawaseRateTuutiData.setShsadr1kj(kykSya.getTsinadr1kj());
                kawaseRateTuutiData.setShsadr2kj(kykSya.getTsinadr2kj());
                kawaseRateTuutiData.setShsadr3kj(kykSya.getTsinadr3kj());
                kawaseRateTuutiData.setShsnmkj(kykSya.getKyknmkj());
                kawaseRateTuutiData.setHhknnmkj(hhknSya.getHhknnmkj());
                kawaseRateTuutiData.setBankcd(kouza.getBankcd());
                kawaseRateTuutiData.setSitencd(kouza.getSitencd());
                kawaseRateTuutiData.setYokinkbn(kouza.getYokinkbn());
                kawaseRateTuutiData.setKouzano(kouza.getKouzano());
                kawaseRateTuutiData.setKzmeiginmkn(kouza.getKzmeiginmkn());
                kawaseRateTuutiData.setAnnaiym(syoriYmd.getBizDateYM());
                kawaseRateTuutiData.setKwsratekjymd(
                    keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().get(0).getRyosyukwsratekjymd());
                kawaseRateTuutiData.setKawaserate(
                    keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().get(0).getRyosyukwsrate());
                kawaseRateTuutiData.setKyktuukasyu(kawaseRateTuutiDataSksBean.getKyktuukasyu());
                kawaseRateTuutiData.setHrkp(keisanRsgkOutBean.getRsgakuGoukei());
                kawaseRateTuutiData.setSiteituukap(kawaseRateTuutiDataSksBean.getHrkp());
                kawaseRateTuutiData.setBosyuujiaatukaidrtencd(dairitenACd);
                kawaseRateTuutiData.setBosyuujiaatukaidrtenkj(dairitenANm);
                kawaseRateTuutiData.setAisyoumeikbn(kawaseRateTuutiDataSksBean.getAisyoumeikbn());
                kawaseRateTuutiData.setKykymd(kawaseRateTuutiDataSksBean.getKykymd());
                kawaseRateTuutiData.setYnkhrkmgkannituutikbn(kawaseRateTuutiDataSksBean.getYnkhrkmgkannituutikbn());
                kawaseRateTuutiData.setGyoumuKousinKinou(kinouId);
                kawaseRateTuutiData.setGyoumuKousinsyaId(userId);
                kawaseRateTuutiData.setGyoumuKousinTime(sysDateTimeMilli);
                BizPropertyInitializer.initialize(kawaseRateTuutiData);

                khKawaseRateTuutiDataSksDao.addInserterEntity(kawaseRateTuutiDataIns, kawaseRateTuutiData);

                KhKawaseRateTuutiCsvfFile csvfFile = makeKawaseRateTuutiCsvf(syoriYmd, kawaseRateTuutiDataSksBean, kykSya, hhknSya, kouza, dairitenANm, keisanRsgkOutBean);
                khKawaseRateTuutiCsvfFileLst.add(csvfFile);

                count = count + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            outputKhKawaseRateTuutiCsvf();

            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {
                ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYmd);
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private KhKawaseRateTuutiCsvfFile makeKawaseRateTuutiCsvf(BizDate pSyoriYmd,
        KawaseRateTuutiDataSksBean pKawaseRateTuutiDataSksBean, IT_KykSya pKykSya, IT_HhknSya pHhknSya,
        IT_Kouza pKouza, String pdairitenANm, KeisanRsgkOutBean pKeisanRsgkOutBean) {

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pKouza.getBankcd(), pKouza.getSitencd());
        String bankNmKj = bzGetBankDataBean.getBankNmKj();
        String reportSitenNm = bzGetBankDataBean.getReportSitenNm();

        String yuutiyusouumu = C_UmuKbn.NONE.getContent(C_UmuKbn.PATTERN_DEFAULT);
        if (C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOU.eq(pKawaseRateTuutiDataSksBean.getYnkhrkmgkannituutikbn())) {
            yuutiyusouumu = C_UmuKbn.ARI.getContent(C_UmuKbn.PATTERN_DEFAULT);
        }

        String yokinkj = pKouza.getYokinkbn().getContent(C_YokinKbn.PATTERN_DEFAULT);
        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pKouza.getBankcd())) {
            yokinkj = "";
        }

        KhKawaseRateTuutiCsvfFile khKawaseRateTuutiCsvfFile = new KhKawaseRateTuutiCsvfFile();
        khKawaseRateTuutiCsvfFile.setIfcTuutiyusouumu(yuutiyusouumu);
        khKawaseRateTuutiCsvfFile.setIfcSyono(pKawaseRateTuutiDataSksBean.getSyono());
        khKawaseRateTuutiCsvfFile.setIfcShskyno(pKykSya.getTsinyno());
        khKawaseRateTuutiCsvfFile.setIfcShskadr1kj(pKykSya.getTsinadr1kj());
        khKawaseRateTuutiCsvfFile.setIfcShskadr2kj(pKykSya.getTsinadr2kj());
        khKawaseRateTuutiCsvfFile.setIfcShskadr3kj(pKykSya.getTsinadr3kj());
        khKawaseRateTuutiCsvfFile.setIfcShsknmkj(pKykSya.getKyknmkj());
        khKawaseRateTuutiCsvfFile.setIfcHhknnmkj(pHhknSya.getHhknnmkj());
        khKawaseRateTuutiCsvfFile.setIfcBanknm(bankNmKj);
        khKawaseRateTuutiCsvfFile.setIfcSitennmtuutyoukigou(reportSitenNm);
        khKawaseRateTuutiCsvfFile.setIfcYokinkj(yokinkj);
        khKawaseRateTuutiCsvfFile.setIfcKouzanotuutyouno(pKouza.getKouzano());
        khKawaseRateTuutiCsvfFile.setIfcKzmeiginmknkana(pKouza.getKzmeiginmkn());
        if (pSyoriYmd != null) {
            khKawaseRateTuutiCsvfFile.setIfcAnnaiym(String.valueOf(pSyoriYmd.getBizDateYM()));
        }
        khKawaseRateTuutiCsvfFile.setIfcKnsnkjymd(
            pKeisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().get(0).getRyosyukwsratekjymd());
        khKawaseRateTuutiCsvfFile.setIfcKktikawaserate(
            pKeisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().get(0).getRyosyukwsrate());
        khKawaseRateTuutiCsvfFile.setIfcKyktuukasyu(pKawaseRateTuutiDataSksBean.getKyktuukasyu().getContent());
        khKawaseRateTuutiCsvfFile.setIfcEnknsnp(pKeisanRsgkOutBean.getRsgakuGoukei());
        khKawaseRateTuutiCsvfFile.setIfcSiteituukap(pKawaseRateTuutiDataSksBean.getHrkp().toFormatString().replace(",", ""));
        khKawaseRateTuutiCsvfFile.setIfcSakuseiymd(pSyoriYmd);
        khKawaseRateTuutiCsvfFile.setIfcBosyuujiaatukaidrtenkj(pdairitenANm);
        khKawaseRateTuutiCsvfFile.setIfcAisyoumei(pKawaseRateTuutiDataSksBean.getAisyoumeikbn().getContent());
        khKawaseRateTuutiCsvfFile.setIfcKykymd(pKawaseRateTuutiDataSksBean.getKykymd());

        return khKawaseRateTuutiCsvfFile;
    }

    private void outputKhKawaseRateTuutiCsvf() {

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        String pExFileNm = "";

        if (khKawaseRateTuutiCsvfFileLst.size() > 0) {
            int renno = 1;

            List<List<KhKawaseRateTuutiCsvfFile>> bunkatuList = Lists.partition(khKawaseRateTuutiCsvfFileLst,
                CSV_OUT_MAX);

            for (List<KhKawaseRateTuutiCsvfFile> csvFileLst : bunkatuList) {

                if (renno != 1) {
                    pExFileNm = String.valueOf(renno);
                }

                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                    C_FileSyuruiCdKbn.AS_KAWASERATETUUTIDATA,
                    csvFileLst,
                    true,
                    pExFileNm);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                }

                renno = renno + 1;
            }
        }
        else {
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.AS_KAWASERATETUUTIDATA,
                khKawaseRateTuutiCsvfFileLst,
                true,
                pExFileNm);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }
    }
}
