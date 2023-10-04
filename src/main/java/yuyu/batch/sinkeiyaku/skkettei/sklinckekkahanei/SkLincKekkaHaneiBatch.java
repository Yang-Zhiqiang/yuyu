package yuyu.batch.sinkeiyaku.skkettei.sklinckekkahanei;

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
import yuyu.batch.sinkeiyaku.skkettei.sklinckekkahanei.dba.SkLincKekkaHaneiDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
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
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 決定 新契約ＬＩＮＣ結果反映
 */
public class SkLincKekkaHaneiBatch implements Batch {

    public final String TABLE_ID = "HT_SkLincJyusinData";

    public final String FILTER_ID = "Sk008";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkLincKekkaHaneiDao skLincKekkaHaneiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ikakutyouJobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), syoriYmd.toString()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), ikakutyouJobcd));

        long syoriKesuu = 0;
        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanLst = new ArrayList<>();

        try (
            ExDBResults<HT_SkLincJyusinData> skLincJyusinDataLst = skLincKekkaHaneiDao.
            getSkLincJyusinDatasByKakutyoujobcdSyoriymd(ikakutyouJobcd, syoriYmd);

            EntityUpdater<HT_SyoriCTL> syoriCTLEntityUpdater = new EntityUpdater<>();
            EntityInserter<HT_SkDenpyoData> skDenpyoDataEntityInserter = new EntityInserter<>();
            EntityUpdater<BT_GyoumuKouteiInfo> gyoumuKouteiInfoEntityUpdater = new EntityUpdater<>();
            EntityUpdater<HT_MosnoKanri> mosnoKanriEntityUpdater = new EntityUpdater<>();
            EntityInserter<BT_TjtIdouNySk> tjtIdouNySkEntityInserter = new EntityInserter<>();) {

            for (HT_SkLincJyusinData skLincJyusinData : skLincJyusinDataLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ikakutyouJobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(String.valueOf(syoriYmd));
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(skLincJyusinData.getLinckyknaiykekdatarenno());

                HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(skLincJyusinData.getRendoumosnochknasi());

                if (syoriCTL == null) {

                    batchLogger.info(MessageUtil.getMessage(MessageId.IHF1047, skLincJyusinData.getRendoumosnochknasi()));

                    continue;
                }
                else if (!C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {

                    continue;
                }

                SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

                SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

                syoriCTL.setLincjkkbn(C_LincjkKbn.HANEIMATI);

                BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                String kouteikanriid = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getKouteiKanriId();

                BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteikanriid);

                MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
                mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
                mosnaiCheckParam.setKinouID(kinou.getKinouId());
                mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
                mosnaiCheckParam.setSysDate(syoriYmd);
                mosnaiCheckParam.setKosID(bzBatchParam.getUserId());
                mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
                mosnaiCheckParam.setDataSyoriControl(syoriCTL);
                mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

                MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
                mosnaiCheck.exec(mosnaiCheckParam);

                syoriCTLEntityUpdater.add(syoriCTL);

                List<HT_SkDenpyoData> skDenpyoDataLst  = mosnaiCheckParam.getListSkDenpyoData();

                if (skDenpyoDataLst != null && skDenpyoDataLst.size() > 0) {

                    for (HT_SkDenpyoData skDenpyoData : skDenpyoDataLst) {

                        skDenpyoDataEntityInserter.add(skDenpyoData);
                    }
                }

                gyoumuKouteiInfoEntityUpdater.add(gyoumuKouteiInfo);

                if (mosnaiCheckParam.getMosnoKanri() != null) {

                    mosnoKanriEntityUpdater.add(mosnaiCheckParam.getMosnoKanri());
                }

                boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

                if (hanteiKekka) {

                    BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);

                    if (tjtIdouNySk == null) {

                        throw new BizAppException(MessageUtil.getMessage(MessageId.EHA1051,
                            "新契約当日異動内容(ファイル)編集",
                            "申込番号",
                            syoriCTL.getMosno()));
                    }

                    tjtIdouNySkEntityInserter.add(tjtIdouNySk);
                }

                List<HT_SkHubiDetail> skHubiDetailList = new ArrayList<>();
                List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanList = new ArrayList<>();

                List<HT_SkHubi> skHubiList = syoriCTL.getSkHubis();

                for (HT_SkHubi skHubi : skHubiList) {

                    skHubiDetailList.addAll(skHubi.getSkHubiDetails());

                    if (skHubiDetailList.size() > 0) {

                        break;
                    }
                }

                SkProcessForwardForBatchInBean skProcessForwardForBatchInBean =
                    SWAKInjector.getInstance(SkProcessForwardForBatchInBean.class);

                skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL);
                skProcessForwardForBatchInBean.setTskNm("新契約ＬＩＮＣ結果反映");
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
                    skProcessUpdate.editProcessUpdateForBatchInfo(syoriCTL, syoriCTL.getMosKihon(), syoriCTL.getMosDairitens());

                if (bzProcessUpdateForBatchInputBeanList.size() > 0) {

                    bzProcessUpdateForBatchInputBeanLst.addAll(bzProcessUpdateForBatchInputBeanList);
                }

                syoriKesuu = syoriKesuu + 1;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanLst);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKesuu), "新契約ＬＩＮＣ結果反映"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
