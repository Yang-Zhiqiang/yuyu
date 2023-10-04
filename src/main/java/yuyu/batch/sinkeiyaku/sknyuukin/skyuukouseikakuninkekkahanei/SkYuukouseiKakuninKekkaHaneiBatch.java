package yuyu.batch.sinkeiyaku.sknyuukin.skyuukouseikakuninkekkahanei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skyuukouseikakuninkekkahanei.dba.SkYuukouseiKakuninKekkaHaneiDao;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHurikomiNyuukin;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_YuukouKakKekkaSk;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.def.sinkeiyaku.bean.report.SkYuukouhaneikakuninkekkalistDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 新契約有効性確認結果反映
 */
public class SkYuukouseiKakuninKekkaHaneiBatch implements Batch {

    private static final String TABLEID = HT_SyoriCTL.TABLE_NAME;

    private static final String FILTERID = "Sk001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkYuukouseiKakuninKekkaHaneiDao skYuukouseiKakuninKekkaHaneiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriCnt = 0;
        long syoriCntSkYuukouseiHaneiKakuninKekkaList = 0;
        IT_YuukouKakKekkaSk yuukouKakKekkaSk = null;
        HT_MosKihon mosKihon = null;
        List<HT_MosDairiten> mosDairitenList = null;
        HT_DakuhiKettei dakuhiKettei = null;
        HT_CreditCardJyouhou creditCardJyouhou = null;
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = null;
        List<HT_SkHubi> skHubiList = null;
        List<HT_SkHubiDetail> skHubiDetailList = null;
        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanList = null;
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList = new ArrayList<>();
        String haneiErrRiyuu = "";
        C_CreditYuukoukakKbn credityuukoukakkbn = null;
        String dispAtesaki = "";
        String dispSakuseiymd = "";
        C_MossyoumetuKbn dispMosSyoumetuKbn = null;
        C_Dbhanei dispMosJyouhouHanei = null;
        List<IReportDataSouceBean> skYuukouhaneikakuninkekkaList = new ArrayList<>();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String userId = bzBatchParam.getUserId();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);
        SkSyanailistheaderBean skSyanailistheaderBean = new SkSyanailistheaderBean();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikiCd, null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            dispAtesaki = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        dispSakuseiymd = DateFormatUtil.dateKANJI(syoriYmd);

        skSyanailistheaderBean.setIrAtesakisosiki(dispAtesaki);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(dispSakuseiymd);

        try (
            ExDBUpdatableResults<HT_SyoriCTL> syoriCTLList = skYuukouseiKakuninKekkaHaneiDao
            .getSyoriCTLsByKakutyoujobcdHrkkeiroCredityuukoukakkbn(kakutyoujobCd);
            EntityUpdater<BT_GyoumuKouteiInfo> gyoumuKouteiInfoEntityUpdater = new EntityUpdater<>();
            EntityInserter<HT_SkDenpyoData> skDenpyoDataEntityInserter = new EntityInserter<>();
            EntityInserter<BT_TjtIdouNySk> tjtIdouNySkEntityInserter = new EntityInserter<>()) {

            for (HT_SyoriCTL syoriCTL : syoriCTLList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                yuukouKakKekkaSk = skYuukouseiKakuninKekkaHaneiDao.getYuukouKakKekkaSkByMosno(syoriCTL.getMosno());
                if (yuukouKakKekkaSk == null) {
                    continue;
                }

                syoriCnt++;
                haneiErrRiyuu = "";

                mosKihon = syoriCTL.getMosKihon();
                mosDairitenList = syoriCTL.getMosDairitens();
                dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(syoriCTL.getMosno());
                creditCardJyouhou = syoriCTL.getCreditCardJyouhou();

                if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {
                    haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1028, "成立済み");
                }
                else if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn()) &&
                    dakuhiKettei != null &&
                    (C_Ketkekkacd.COOLINGOFF.eq(dakuhiKettei.getKetkekkacd()) ||
                        C_Ketkekkacd.MOS_TORIKESI.eq(dakuhiKettei.getKetkekkacd()))) {
                    haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1028, "申込取消");
                }

                if (BizUtil.isBlank(haneiErrRiyuu)) {
                    if (creditCardJyouhou == null) {
                        haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1029);
                    }
                    else if (BizUtil.isBlank(creditCardJyouhou.getCreditkessaiyouno()) ||
                        (!BizUtil.isBlank(creditCardJyouhou.getCreditkessaiyouno()) &&
                            !creditCardJyouhou.getCreditkessaiyouno().equals(yuukouKakKekkaSk.getCreditkessaiyouno()))) {
                        haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1030);
                    }
                }

                if (BizUtil.isBlank(haneiErrRiyuu)) {
                    if (C_CreditTrkjkKbn.NG.eq(syoriCTL.getCredittrkjkkbn())) {
                        haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1031);
                    }
                }

                if (BizUtil.isBlank(haneiErrRiyuu)) {

                    SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
                    SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

                    if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(yuukouKakKekkaSk.getCredityuukoukakkekka())) {
                        credityuukoukakkbn = C_CreditYuukoukakKbn.OK;
                    }
                    else if (C_Yuukoukakkekka.YUUKOUKAK_NG.eq(yuukouKakKekkaSk.getCredityuukoukakkekka())) {
                        credityuukoukakkbn = C_CreditYuukoukakKbn.NG;
                    }
                    else if (C_Yuukoukakkekka.SYOUGOUERROR.eq(yuukouKakKekkaSk.getCredityuukoukakkekka())) {
                        credityuukoukakkbn = C_CreditYuukoukakKbn.SYOUGOUERR;
                    }
                    else if (C_Yuukoukakkekka.CARDKAISYAHNTIERROR.eq(yuukouKakKekkaSk.getCredityuukoukakkekka())) {
                        credityuukoukakkbn = C_CreditYuukoukakKbn.CARDKAISYAHANTEIERR;
                    }
                    else {
                        credityuukoukakkbn = C_CreditYuukoukakKbn.BLNK;
                    }
                    syoriCTL.setCredityuukoukakkbn(credityuukoukakkbn);

                    if (C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {

                        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                        bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                        String kouteiKanriId = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getKouteiKanriId();

                        gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

                        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
                        MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);

                        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
                        mosnaiCheckParam.setKinouID(kinou.getKinouId());
                        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
                        mosnaiCheckParam.setSysDate(syoriYmd);
                        mosnaiCheckParam.setKosID(userId);
                        mosnaiCheckParam.setKosTime(sysDateTime);
                        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
                        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

                        mosnaiCheck.exec(mosnaiCheckParam);

                        gyoumuKouteiInfoEntityUpdater.add(gyoumuKouteiInfo);

                        List<HT_SkDenpyoData> skDenpyoDataList = mosnaiCheckParam.getListSkDenpyoData();

                        for (HT_SkDenpyoData skDenpyoData : skDenpyoDataList) {

                            skDenpyoDataEntityInserter.add(skDenpyoData);
                        }

                        boolean hannteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

                        if (hannteiKekka) {
                            BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);

                            if (tjtIdouNySk == null) {
                                throw new BizAppException(MessageUtil.getMessage(MessageId.EHA1051,
                                    "新契約当日異動内容(ファイル)編集",
                                    "申込番号",
                                    syoriCTL.getMosno()));
                            }
                            tjtIdouNySkEntityInserter.add(tjtIdouNySk);
                        }

                        skHubiDetailList = new ArrayList<>();
                        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
                            .getInstance(SkProcessForwardForBatchInBean.class);
                        skProcessForwardForBatchInBeanList = new ArrayList<>();
                        skHubiList = syoriCTL.getSkHubis();
                        C_UmuKbn skHubiDtailUmu = null;
                        SkProcessForwardHurikomiNyuukin skProcessForwardHurikomiNyuukin = SWAKInjector
                            .getInstance(SkProcessForwardHurikomiNyuukin.class);

                        for (HT_SkHubi skHubi : skHubiList) {

                            skHubiDetailList = skHubi.getSkHubiDetails();

                            if (skHubiDetailList.size() > 0) {
                                break;
                            }
                        }

                        if (skHubiDetailList.size() > 0) {
                            skHubiDtailUmu = C_UmuKbn.ARI;
                        }
                        else {
                            skHubiDtailUmu = C_UmuKbn.NONE;
                        }

                        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL);
                        skProcessForwardForBatchInBean.setTskNm("新契約有効性確認結果反映");
                        skProcessForwardForBatchInBean.setSyoriComment("");
                        skProcessForwardForBatchInBean.setSkHubiDtailUmu(skHubiDtailUmu);

                        skProcessForwardForBatchInBeanList.add(skProcessForwardForBatchInBean);

                        skProcessForwardHurikomiNyuukin.exec(skProcessForwardForBatchInBeanList);

                        List<BzProcessUpdateForBatchInputBean> jikkouKekkaList = skProcessUpdate
                            .editProcessUpdateForBatchInfo(syoriCTL, mosKihon, mosDairitenList);

                        if (jikkouKekkaList.size() > 0) {
                            bzProcessUpdateForBatchInputBeanList.addAll(jikkouKekkaList);
                        }
                    }
                }

                syoriCntSkYuukouseiHaneiKakuninKekkaList = syoriCntSkYuukouseiHaneiKakuninKekkaList + 1;
                SkYuukouhaneikakuninkekkalistDataSourceBean skYuukouhaneikakuninkekkalistDataSourceBean =
                    new SkYuukouhaneikakuninkekkalistDataSourceBean();
                EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

                C_Ketkekkacd ketkekkacd = C_Ketkekkacd.BLNK;

                if (dakuhiKettei != null) {
                    ketkekkacd = dakuhiKettei.getKetkekkacd();
                }

                dispMosSyoumetuKbn = C_MossyoumetuKbn.valueOf(editPalRenkeiKoumoku.editMosSyoumetuKbn(
                    syoriCTL.getSeiritukbn(), ketkekkacd));

                if (BizUtil.isBlank(haneiErrRiyuu)) {
                    dispMosJyouhouHanei = C_Dbhanei.SUMI;
                } else {
                    dispMosJyouhouHanei = C_Dbhanei.NONE;
                }

                skYuukouhaneikakuninkekkalistDataSourceBean.setIrMosno(syoriCTL.getMosno());
                skYuukouhaneikakuninkekkalistDataSourceBean.setIrCreditkessaiyouno(yuukouKakKekkaSk.getCreditkessaiyouno());
                skYuukouhaneikakuninkekkalistDataSourceBean.setIrMossyoumetukbn(dispMosSyoumetuKbn);
                skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkjkkbn(syoriCTL.getCredittrkjkkbn());
                skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredityuukoukakkbn(C_CreditYuukoukakKbn.NG);
                skYuukouhaneikakuninkekkalistDataSourceBean.setIrDbhanei(dispMosJyouhouHanei);
                skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkhaneierrriyuu(haneiErrRiyuu);

                skYuukouhaneikakuninkekkaList.add(skYuukouhaneikakuninkekkalistDataSourceBean);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);
        }

        C_SyoruiCdKbn syoruiCdKb = C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST;
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKb);

        reportServicesBean.setSyoriYmd(syoriYmd);
        reportServicesBean.addParamObjects(syoruiCdKb, skYuukouhaneikakuninkekkaList, skSyanailistheaderBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCnt),
            "新契約有効性確認結果反映"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntSkYuukouseiHaneiKakuninKekkaList),
            "新契約有効性反映確認結果リスト"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
