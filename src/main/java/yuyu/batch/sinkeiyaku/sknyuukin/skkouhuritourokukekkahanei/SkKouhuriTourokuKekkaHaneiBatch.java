package yuyu.batch.sinkeiyaku.sknyuukin.skkouhuritourokukekkahanei;

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
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skkouhuritourokukekkahanei.dba.SkKouhuriTourokuKekkaHaneiDao;
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
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkKouhuritourokuhaneierrlistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 口振受付登録結果反映クラス
 */
public class SkKouhuriTourokuKekkaHaneiBatch implements Batch {

    private static final String TABLEID = HT_SkKouhuriUkTrkMihanei.TABLE_NAME;

    private static final String FILTERID = "Bz114";

    private static final String BANKCD_YTGINKOU = "9900";

    private static final String BANKCD_YTGINKOUKZHURISERVICE_KINYUUCDUKE = "9900";

    private static final String BANKCD_YTGINKOUKZHURISERVICE_WEBUKE = "9901";

    private static final String BANKCD_YTGINKOUSKJHURISERVICE = "9902";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkKouhuriTourokuKekkaHaneiDao skKouhuriTourokuKekkaHaneiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriCnt = 0;
        long syoriCntKouhuriTourokuKekkaHaneiErrList = 0;
        String haneiErrRiyuu = "";
        HT_SyoriCTL syoriCTL = null;
        HT_MosKihon mosKihon = null;
        HT_DakuhiKettei dakuhiKettei = null;
        HT_KouzaJyouhou kouzaJyouhou = null;
        List<HT_MosDairiten> mosDairitenList = null;
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = null;
        List<HT_SkHubi> skHubiList = null;
        List<HT_SkHubiDetail> skHubiDetailList = null;
        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanList = null;
        String sosikiCd = "";
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList = new ArrayList<>();
        String dispAtesaki = "";
        String dispSakuseiymd = "";
        List<IReportDataSouceBean> skKouhuriTourokuKekkaHaneiErrList = new ArrayList<>();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String userId = bzBatchParam.getUserId();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        SkSyanailistheaderBean skSyanailistheaderBean = new SkSyanailistheaderBean();
        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

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
            ExDBResults<HT_SkKouhuriUkTrkMihanei> skKouhuriUkTrkMihaneiListDbResults = skKouhuriTourokuKekkaHaneiDao.
            getSkKouhuriUkTrkMihaneiByKinyuukkntratkiymdKakutyoujobcd(kakutyoujobCd, syoriYmd.addDays(-90));
            EntityUpdater<HT_SyoriCTL> syoriCTLEntityUpdater = new EntityUpdater<>();
            EntityUpdater<BT_GyoumuKouteiInfo> gyoumuKouteiInfoEntityUpdater = new EntityUpdater<>();
            EntityUpdater<HT_MosnoKanri> mosnoKanriUpdater = new EntityUpdater<>();
            EntityInserter<HT_SkDenpyoData> skDenpyoDataEntityInserter = new EntityInserter<>();
            EntityInserter<BT_TjtIdouNySk> tjtIdouNySkEntityInserter = new EntityInserter<>();
            EntityUpdater<HT_SkKouhuriUkTrkMihanei> skKouhuriUkTrkMihaneiEntityUpdater = new EntityUpdater<>();){

            for (HT_SkKouhuriUkTrkMihanei skKouhuriUkTrkMihanei : skKouhuriUkTrkMihaneiListDbResults) {

                String kouhuriokyakusamaNo = skKouhuriUkTrkMihanei.getKouhuriokyakusamano();
                String sitenCd = skKouhuriUkTrkMihanei.getSitencd5keta();
                String kouzano8Keta = skKouhuriUkTrkMihanei.getKouzano8keta();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kouhuriokyakusamaNo);

                syoriCnt++;
                haneiErrRiyuu = "";
                syoriCTL = null;
                sosikiCd = "";

                syoriCTL = sinkeiyakuDomManager.getSyoriCTL(skKouhuriUkTrkMihanei.getNykmosno());

                if (syoriCTL != null && C_UmuKbn.ARI.eq(syoriCTL.getMosnrkumu())) {

                    mosKihon = syoriCTL.getMosKihon();
                    dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(skKouhuriUkTrkMihanei.getNykmosno());
                    kouzaJyouhou = syoriCTL.getKouzaJyouhou();
                    mosDairitenList = syoriCTL.getMosDairitens();

                    String bankcd = "";
                    if (BANKCD_YTGINKOUKZHURISERVICE_KINYUUCDUKE.equals(skKouhuriUkTrkMihanei.getBankcd())
                        || BANKCD_YTGINKOUKZHURISERVICE_WEBUKE.equals(skKouhuriUkTrkMihanei.getBankcd())
                        || BANKCD_YTGINKOUSKJHURISERVICE.equals(skKouhuriUkTrkMihanei.getBankcd())) {
                        bankcd = BANKCD_YTGINKOU;
                    }
                    else {
                        bankcd = skKouhuriUkTrkMihanei.getBankcd();
                    }

                    if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

                        haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1021, "成立済み");

                    }
                    else if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn()) &&
                        dakuhiKettei != null &&
                        (C_Ketkekkacd.COOLINGOFF.eq(dakuhiKettei.getKetkekkacd()) ||
                            C_Ketkekkacd.MOS_TORIKESI.eq(dakuhiKettei.getKetkekkacd()))) {

                        haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1021, "申込取消");
                    }

                    if (BizUtil.isBlank(haneiErrRiyuu) && !C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro())) {

                        haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1034);

                    }

                    if (BizUtil.isBlank(haneiErrRiyuu) && !C_KzhuritourokuhouKbn.QR.eq(kouzaJyouhou.getKzhuritourokuhoukbn())) {

                        haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1033);

                    }

                    if (BizUtil.isBlank(haneiErrRiyuu) && C_UmuKbn.ARI.eq(syoriCTL.getKznrkumu())) {

                        haneiErrRiyuu = MessageUtil.getMessage(MessageId.EHF1032);

                    }

                    if (!BizUtil.isBlank(haneiErrRiyuu)) {


                        if (mosDairitenList != null && mosDairitenList.size() > 0) {

                            sosikiCd = mosDairitenList.get(0).getDrtenkanrisosikicd();
                        }

                        syoriCntKouhuriTourokuKekkaHaneiErrList++;

                        SkKouhuritourokuhaneierrlistDataSourceBean SkKouhuritourokuhaneierrlistDataSourceBean =
                            new SkKouhuritourokuhaneierrlistDataSourceBean();

                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrSosikicd(sosikiCd);
                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrMosno(skKouhuriUkTrkMihanei.getNykmosno());
                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrOkyakusamano(kouhuriokyakusamaNo);
                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrKouzahrketrkymd(String.valueOf(skKouhuriUkTrkMihanei.getKinyuukkntratkiymd()));
                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrKinyuucd(bankcd);
                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrSitencd(sitenCd.substring(sitenCd.length() - 3, sitenCd.length()));
                        if (YuyuSinkeiyakuConfig.getInstance().getBankcdYokinkbnEditList().contains(skKouhuriUkTrkMihanei.getBankcd())) {
                            SkKouhuritourokuhaneierrlistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
                        }
                        else {
                            SkKouhuritourokuhaneierrlistDataSourceBean.setIrYokinkbn(skKouhuriUkTrkMihanei
                                .getYokinkbn());
                        }
                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrKouzano(kouzano8Keta.substring(kouzano8Keta.length()-7, kouzano8Keta.length()));
                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrKzmeiginmkn(skKouhuriUkTrkMihanei.getKzmeiginmkn());
                        SkKouhuritourokuhaneierrlistDataSourceBean.setIrKhrtrkkekkahaneierrriyuu(haneiErrRiyuu);

                        skKouhuriTourokuKekkaHaneiErrList.add(SkKouhuritourokuhaneierrlistDataSourceBean);

                    }

                    if (BizUtil.isBlank(haneiErrRiyuu)) {

                        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
                        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

                        syoriCTL.setKznrkumu(C_UmuKbn.ARI);
                        syoriCTL.setKznrkhbumu(C_UmuKbn.NONE);

                        kouzaJyouhou.setKzmeiginmkn("");
                        kouzaJyouhou.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
                        kouzaJyouhou.setBankcd(bankcd);
                        kouzaJyouhou.setSitencd(sitenCd.substring(sitenCd.length() - 3, sitenCd.length()));

                        if (YuyuSinkeiyakuConfig.getInstance().getBankcdYokinkbnEditList().contains(skKouhuriUkTrkMihanei.getBankcd())) {
                            kouzaJyouhou.setYokinkbn(C_YokinKbn.HUTUU);
                        }
                        else if (C_YokinKbn.HUTUU.eq(skKouhuriUkTrkMihanei.getYokinkbn())) {

                            kouzaJyouhou.setYokinkbn(C_YokinKbn.HUTUU);
                        }
                        else if (C_YokinKbn.TOUZA.eq(skKouhuriUkTrkMihanei.getYokinkbn())) {

                            kouzaJyouhou.setYokinkbn(C_YokinKbn.TOUZA);
                        }
                        else {

                            kouzaJyouhou.setYokinkbn(C_YokinKbn.BLNK);
                        }

                        kouzaJyouhou.setKouzano(kouzano8Keta.substring(kouzano8Keta.length()-7, kouzano8Keta.length()));

                        kouzaJyouhou.setSinkeizkkbn(C_SinkeizkKbn.SHINKI);
                        kouzaJyouhou.setHbcmnt("");
                        kouzaJyouhou.setSyuudaikocd(C_Syuudaikocd.CSS);
                        kouzaJyouhou.setKouzakakuniniraikbn(C_YouhiblnkKbn.HUYOU);
                        kouzaJyouhou.setKouzakakuniniraiymd(null);
                        kouzaJyouhou.setKouzajyouhounyuuryokuymd(syoriYmd);

                        if (C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {

                            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                            bzGetProcessSummaryInBean.setMosNo(skKouhuriUkTrkMihanei.getNykmosno());

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

                            List<HT_SkDenpyoData> skDenpyoDataList = mosnaiCheckParam.getListSkDenpyoData();

                            for (HT_SkDenpyoData skDenpyoData : skDenpyoDataList) {

                                skDenpyoDataEntityInserter.add(skDenpyoData);
                            }

                            gyoumuKouteiInfoEntityUpdater.add(gyoumuKouteiInfo);

                            HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();

                            if (mosnoKanri != null) {

                                mosnoKanriUpdater.add(mosnoKanri);
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
                            SkProcessForwardHurikomiNyuukin skProcessForwardHurikomiNyuukin = SWAKInjector
                                .getInstance(SkProcessForwardHurikomiNyuukin.class);

                            for (HT_SkHubi skHubi : skHubiList) {

                                skHubiDetailList = skHubi.getSkHubiDetails();

                                if (skHubiDetailList.size() > 0) {
                                    break;
                                }
                            }

                            skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL);
                            skProcessForwardForBatchInBean.setTskNm("口振受付登録結果反映");
                            skProcessForwardForBatchInBean.setSyoriComment("");

                            if (skHubiDetailList.size() > 0) {

                                skProcessForwardForBatchInBean.setSkHubiDtailUmu(C_UmuKbn.ARI);

                            }
                            else {
                                skProcessForwardForBatchInBean.setSkHubiDtailUmu(C_UmuKbn.NONE);

                            }

                            skProcessForwardForBatchInBeanList.add(skProcessForwardForBatchInBean);

                            skProcessForwardHurikomiNyuukin.exec(skProcessForwardForBatchInBeanList);

                            List<BzProcessUpdateForBatchInputBean> jikkouKekkaList = skProcessUpdate
                                .editProcessUpdateForBatchInfo(syoriCTL, mosKihon, mosDairitenList);

                            if (jikkouKekkaList.size() > 0) {
                                bzProcessUpdateForBatchInputBeanList.addAll(jikkouKekkaList);
                            }
                        }

                        syoriCTLEntityUpdater.add(syoriCTL);
                    }

                    skKouhuriUkTrkMihanei.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

                    skKouhuriUkTrkMihaneiEntityUpdater.add(skKouhuriUkTrkMihanei);

                }

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);
        }

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST;
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setSyoriYmd(syoriYmd);
        reportServicesBean.addParamObjects(syoruiCdKbn, skKouhuriTourokuKekkaHaneiErrList, skSyanailistheaderBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCnt),
            "口振受付登録結果反映"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntKouhuriTourokuKekkaHaneiErrList),
            "口座振替登録反映エラーリスト"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
