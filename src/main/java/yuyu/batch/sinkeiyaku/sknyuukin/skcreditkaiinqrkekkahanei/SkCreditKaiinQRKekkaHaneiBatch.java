package yuyu.batch.sinkeiyaku.sknyuukin.skcreditkaiinqrkekkahanei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skcreditkaiinqrkekkahanei.dba.SkCreditKaiinQRKekkaHaneiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHurikomiNyuukin;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import yuyu.def.sinkeiyaku.bean.report.SkCreditqrtrkmihaneilistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;

/**
 * 新契約 入金 クレジットカード会員ＱＲ登録結果反映
 */
public class SkCreditKaiinQRKekkaHaneiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkCreditKaiinQRKekkaHaneiDao skCreditKaiinQRKekkaHaneiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Override
    public BzBatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ikakutyouJobcd = bzBatchParam.getIbKakutyoujobcd();

        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ikakutyouJobcd);
        bzRecoveryDatasikibetuBean.setIbTableid("HT_SkCreditCardQrTrkMihanei");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid("Bz112");

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ikakutyouJobcd));

        long syoriKensuu = 0;
        long genSkCreditqrtrkmihaneilistDataSourceKensuu = 0;
        String haneierrriyuu = "";
        HT_SyoriCTL syoriCTL = null;
        HT_MosKihon mosKihon = null;
        HT_DakuhiKettei dakuhiKettei = null;
        HT_CreditCardJyouhou creditCardJyouhou = null;
        List<HT_MosDairiten> mosDairitenList = null;
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = null;
        List<HT_SkHubi> skHubiList = null;
        List<HT_SkHubiDetail> skHubiDetailList = null;
        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanList = null;
        boolean creditcardinfoFlg = false;
        String sosikicd = "";
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanLst = new ArrayList<>();
        String dispAtesaki = "";
        String dispSakuseiymd = "";
        String creditQRtrkymd = "";
        String dispDatajyusinymd = "";
        List<IReportDataSouceBean> genSkCreditqrtrkmihaneilistDataSourceBeanList = new ArrayList<>();

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(YuyuSinkeiyakuConfig.getInstance()
            .getDairitenkyksosikicd(), null);

        dispAtesaki = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());

        dispSakuseiymd = DateFormatUtil.dateKANJI(syoriYmd);

        SkSyanailistheaderBean skSyanailistheaderBean = new SkSyanailistheaderBean();

        skSyanailistheaderBean.setIrAtesakisosiki(dispAtesaki);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(dispSakuseiymd);

        try (
            ExDBResults<HT_SkCreditCardQrTrkMihanei> skCreditCardQrTrkMihaneiList = skCreditKaiinQRKekkaHaneiDao.
            getSkCreditCardQrTrkMihaneiByBgUktkymdtimeKakutyoujobcd(ikakutyouJobcd,
                String.valueOf(syoriYmd.addDays(-119)) + "000000");

            EntityUpdater<HT_SyoriCTL> syoriCTLUpdater = new EntityUpdater<>();
            EntityUpdater<HT_MosKihon> mosKihonUpdater = new EntityUpdater<>();
            EntityUpdater<BT_GyoumuKouteiInfo> gyoumuKouteiInfoUpdater = new EntityUpdater<>();
            EntityUpdater<HT_MosnoKanri> mosnoKanriUpdater = new EntityUpdater<>();
            EntityInserter<HT_SkDenpyoData> skDenpyoDataInserter = new EntityInserter<>();
            EntityInserter<BT_TjtIdouNySk> tjtIdouNySkInserter = new EntityInserter<>();
            EntityInserter<HW_CreditTrkHaneierrList> creditTrkHaneierrListInserter = new EntityInserter<>();
            EntityUpdater<HT_SkCreditCardQrTrkMihanei> skCreditCardQrTrkMihaneiUpdater = new EntityUpdater<>();) {

            Integer creditTrkHaneierrListMaxDatarenno =
                skCreditKaiinQRKekkaHaneiDao.getCreditTrkHaneierrListMaxDatarennoByTyouhyouymd(syoriYmd);

            if (creditTrkHaneierrListMaxDatarenno == null) {

                creditTrkHaneierrListMaxDatarenno = 0;
            }

            SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

            for (HT_SkCreditCardQrTrkMihanei skCreditCardQrTrkMihanei : skCreditCardQrTrkMihaneiList) {

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skCreditCardQrTrkMihanei.getCreditkessaiyouno());

                syoriKensuu = syoriKensuu + 1;
                haneierrriyuu = "";
                syoriCTL = null;
                creditcardinfoFlg = false;
                sosikicd = "";

                syoriCTL = sinkeiyakuDomManager.getSyoriCTL(skCreditCardQrTrkMihanei.getNykmosno());

                if (syoriCTL == null || (syoriCTL != null && C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu()))) {

                    genSkCreditqrtrkmihaneilistDataSourceKensuu = genSkCreditqrtrkmihaneilistDataSourceKensuu + 1;
                    creditQRtrkymd = skCreditCardQrTrkMihanei.getBluegatejyusinymdtime().substring(0, 8);
                    dispDatajyusinymd = skCreditCardQrTrkMihanei.getSyoriYmd().toString();

                    SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean =
                        new SkCreditqrtrkmihaneilistDataSourceBean();

                    skCreditqrtrkmihaneilistDataSourceBean.setIrCreditqrtrkymd(creditQRtrkymd);
                    skCreditqrtrkmihaneilistDataSourceBean.setIrDatajyusinymd(dispDatajyusinymd);
                    skCreditqrtrkmihaneilistDataSourceBean.setIrMosno(skCreditCardQrTrkMihanei.getNykmosno());
                    skCreditqrtrkmihaneilistDataSourceBean.setIrCreditkessaiyouno(
                        skCreditCardQrTrkMihanei.getCreditkessaiyouno());

                    genSkCreditqrtrkmihaneilistDataSourceBeanList.add(skCreditqrtrkmihaneilistDataSourceBean);
                }

                if (syoriCTL != null && C_UmuKbn.ARI.eq(syoriCTL.getMosnrkumu())) {

                    skCreditCardQrTrkMihanei.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

                    skCreditCardQrTrkMihaneiUpdater.add(skCreditCardQrTrkMihanei);

                    mosKihon = syoriCTL.getMosKihon();
                    dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(
                        skCreditCardQrTrkMihanei.getNykmosno());
                    creditCardJyouhou = syoriCTL.getCreditCardJyouhou();
                    mosDairitenList = syoriCTL.getMosDairitens();

                    if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

                        haneierrriyuu = MessageUtil.getMessage(MessageId.EHF1021, "成立済み");
                    }
                    else if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn()) &&
                        dakuhiKettei != null &&
                        (C_Ketkekkacd.COOLINGOFF.eq(dakuhiKettei.getKetkekkacd()) ||
                            C_Ketkekkacd.MOS_TORIKESI.eq(dakuhiKettei.getKetkekkacd()))) {

                        haneierrriyuu = MessageUtil.getMessage(MessageId.EHF1021, "申込取消");
                    }

                    if (Strings.isNullOrEmpty(haneierrriyuu) && !C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {

                        haneierrriyuu = MessageUtil.getMessage(MessageId.EHF1023);
                    }

                    if (Strings.isNullOrEmpty(haneierrriyuu)) {

                        if (creditCardJyouhou != null &&
                            !BizUtil.isBlank(creditCardJyouhou.getCreditkessaiyouno())) {

                            if (skCreditCardQrTrkMihanei.getCreditkessaiyouno().equals(
                                creditCardJyouhou.getCreditkessaiyouno())) {

                                haneierrriyuu = MessageUtil.getMessage(MessageId.EHF1026);
                            }
                            else {

                                if (C_CreditTrkjkKbn.TOUROKUTYUU.eq(syoriCTL.getCredittrkjkkbn())) {

                                    haneierrriyuu = MessageUtil.getMessage(MessageId.EHF1027);
                                }
                                else {

                                    creditcardinfoFlg = true;
                                }
                            }
                        }
                    }

                    if (Strings.isNullOrEmpty(haneierrriyuu)) {

                        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(
                            SkToujituIdounaiyouEdit.class);

                        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

                        syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.SUMI);
                        syoriCTL.setCredityuukoukakkbn(C_CreditYuukoukakKbn.OK);

                        creditCardJyouhou.setCreditkessaiyouno(skCreditCardQrTrkMihanei.getCreditkessaiyouno());

                        if (creditcardinfoFlg) {

                            mosKihon.setPplessrendoucreditkousoukbn(C_PplessrendoucreditkousouKbn.NONE);

                            creditCardJyouhou.setCredittrkhoukbn(C_CreditTrkhouKbn.QR);
                        }

                        if (C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {

                            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
                            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(
                                BzGetProcessSummaryInBean.class);

                            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                            bzGetProcessSummaryInBean.setMosNo(skCreditCardQrTrkMihanei.getNykmosno());

                            String kouteiKanriId = bzGetProcessSummary.exec(
                                bzGetProcessSummaryInBean).get(0).getKouteiKanriId();
                            gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

                            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
                            MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);

                            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
                            mosnaiCheckParam.setKinouID(kinou.getKinouId());
                            mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
                            mosnaiCheckParam.setSysDate(syoriYmd);
                            mosnaiCheckParam.setKosID(bzBatchParam.getUserId());
                            mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
                            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
                            mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

                            mosnaiCheck.exec(mosnaiCheckParam);

                            List<HT_SkDenpyoData> skDenpyoDataList = mosnaiCheckParam.getListSkDenpyoData();

                            if (skDenpyoDataList != null && skDenpyoDataList.size() > 0) {

                                for (HT_SkDenpyoData skDenpyoData : skDenpyoDataList) {

                                    skDenpyoDataInserter.add(skDenpyoData);
                                }
                            }

                            gyoumuKouteiInfoUpdater.add(gyoumuKouteiInfo);

                            if (mosnaiCheckParam.getMosnoKanri() != null) {

                                mosnoKanriUpdater.add(mosnaiCheckParam.getMosnoKanri());
                            }

                            boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

                            if (hanteiKekka) {

                                BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);

                                if (tjtIdouNySk == null) {

                                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EHA1051,
                                        "新契約当日異動内容(ファイル)編集",
                                        "申込番号",
                                        syoriCTL.getMosno()));
                                }

                                tjtIdouNySkInserter.add(tjtIdouNySk);
                            }

                            skHubiDetailList = new ArrayList<>();
                            skProcessForwardForBatchInBeanList = new ArrayList<>();

                            skHubiList = syoriCTL.getSkHubis();

                            for (HT_SkHubi skHubi : skHubiList) {

                                skHubiDetailList = skHubi.getSkHubiDetails();

                                if (skHubiDetailList.size() > 0) {

                                    break;
                                }
                            }

                            SkProcessForwardForBatchInBean skProcessForwardForBatchInBean =
                                new SkProcessForwardForBatchInBean();

                            skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL);
                            skProcessForwardForBatchInBean.setTskNm("クレジットカード会員ＱＲ登録結果反映");
                            skProcessForwardForBatchInBean.setSyoriComment("");

                            if (skHubiDetailList.size() > 0) {

                                skProcessForwardForBatchInBean.setSkHubiDtailUmu(C_UmuKbn.ARI);
                            }

                            else {

                                skProcessForwardForBatchInBean.setSkHubiDtailUmu(C_UmuKbn.NONE);
                            }

                            skProcessForwardForBatchInBeanList.add(skProcessForwardForBatchInBean);

                            SkProcessForwardHurikomiNyuukin skProcessForwardHurikomiNyuukin =
                                SWAKInjector.getInstance(SkProcessForwardHurikomiNyuukin.class);

                            skProcessForwardHurikomiNyuukin.exec(skProcessForwardForBatchInBeanList);

                            List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
                                skProcessUpdate.editProcessUpdateForBatchInfo(syoriCTL, mosKihon, mosDairitenList);

                            if (bzProcessUpdateForBatchInputBeanList.size() > 0) {

                                bzProcessUpdateForBatchInputBeanLst.addAll(bzProcessUpdateForBatchInputBeanList);
                            }
                        }

                        syoriCTLUpdater.add(syoriCTL);

                        if (creditcardinfoFlg) {

                            mosKihonUpdater.add(mosKihon);
                        }
                    }

                    if (!Strings.isNullOrEmpty(haneierrriyuu)) {

                        if (mosDairitenList != null && mosDairitenList.size() > 0) {

                            sosikicd = mosDairitenList.get(0).getDrtenkanrisosikicd();
                        }

                        creditTrkHaneierrListMaxDatarenno = creditTrkHaneierrListMaxDatarenno + 1;

                        HW_CreditTrkHaneierrList creditTrkHaneierrList = new HW_CreditTrkHaneierrList();
                        creditTrkHaneierrList.setTyouhyouymd(syoriYmd);
                        creditTrkHaneierrList.setDatarenno(creditTrkHaneierrListMaxDatarenno);
                        creditTrkHaneierrList.setMosno(skCreditCardQrTrkMihanei.getNykmosno());
                        creditTrkHaneierrList.setCredittrkhoukbn(C_CreditTrkhouKbn.QR);
                        creditTrkHaneierrList.setSosikicd(sosikicd);
                        creditTrkHaneierrList.setCreditkessaiyouno(skCreditCardQrTrkMihanei.getCreditkessaiyouno());
                        creditTrkHaneierrList.setCredittrkhaneierrriyuu(haneierrriyuu);

                        BizPropertyInitializer.initialize(creditTrkHaneierrList);

                        creditTrkHaneierrListInserter.add(creditTrkHaneierrList);
                    }
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanLst);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

            reportServicesBean.setSyoriYmd(syoriYmd);

            reportServicesBean.addParamObjects(genSkCreditqrtrkmihaneilistDataSourceBeanList, skSyanailistheaderBean);

            createReport.execNoCommit(reportServicesBean);

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(syoriKensuu), "クレジットカード会員ＱＲ登録結果反映"));

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(genSkCreditqrtrkmihaneilistDataSourceKensuu),
                "クレカＱＲ登録未反映リスト（申込入力未了分）"));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}