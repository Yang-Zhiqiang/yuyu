package yuyu.batch.sinkeiyaku.sksonota.skmosdatamaintenance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sksonota.skmosdatamaintenance.dba.SkMosDataMaintenanceDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.entity.HT_SkLincSousinData;
import yuyu.def.db.entity.HT_SkSyuunouKekkaData;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 その他 申込データメンテナンス
 */
public class SkMosDataMaintenanceBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SkMosDataMaintenanceDao skMosDataMaintenanceDao;

    private final long MAX_CNT = 10000;

    private final long MAX_COMMIT = 5000;

    private final String SKMAINDAIRITEN = "skmaindairiten";

    private final String KEYNM_MOSNO = "mosno";

    private final String KEYNM_SSTMOSNO = "sstmosno";

    private final String KEYNM_KOUTEIKANRIID = "kouteikanriid";

    private final String RENDOUMOSNOCHKNASI = "rendoumosnochknasi";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        String kakutyouJobCode = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCode));

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        long total = 0;

        long tmpKensuu = MAX_COMMIT;

        while (tmpKensuu == MAX_COMMIT && total < MAX_CNT) {

            tmpKensuu = doMaintenance(kakutyouJobCode, syoriYmd);

            total += tmpKensuu;
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(total),
            "申込データメンテナンス"));
    }

    @Transactional
    public long doMaintenance(String kakutyouJobCode, BizDate syoriYmd){

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        long syoriKensuu = 0;

        String tableId = "HT_MosnoKanri";

        String recoveryFilterId = "Sk004";

        List<String> mosnoList = new ArrayList<>();

        List<String> kykMosnoList = new ArrayList<>();

        try (ExDBUpdatableResults<HT_MosnoKanri> mosnoKanriLst = sinkeiyakuDomManager
            .getMosnoKanrisByKakutyoujobcdMossykykyoteiymd(kakutyouJobCode, syoriYmd)) {

            Iterator<HT_MosnoKanri> hTMosnoKanri = mosnoKanriLst.iterator();

            if (hTMosnoKanri.hasNext()) {

                try (EntityInserter<BT_TjtIdouNySk> tjtIdouNySkLst = new EntityInserter<>()) {

                    while (hTMosnoKanri.hasNext() && syoriKensuu < MAX_COMMIT) {
                        HT_MosnoKanri mosnoKanri = hTMosnoKanri.next();

                        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCode);

                        bzRecoveryDatasikibetuBean.setIbTableid(tableId);

                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);

                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mosnoKanri.getMosno8keta());

                        int checkdigit = MousikomiNoCheck.calcDegit(mosnoKanri.getMosno8keta());

                        String mosno = mosnoKanri.getMosno8keta() + String.valueOf(checkdigit);

                        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno);

                        if (syoriCTL != null) {

                            HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                            Long count = sinkeiyakuDomManager.getHenkinCountByMosnoHnknsyoriymd(mosno);

                            if (mosKihon != null
                                && ((C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) || C_SeirituKbn.HUSEIRITU.
                                    eq(syoriCTL.getSeiritukbn())) && count == 0)) {

                                sinkeiyakuDomManager.delete(syoriCTL);

                                List<HT_YuukoukknKykList> yuukoukknKykList = sinkeiyakuDomManager
                                    .getYuukoukknKykListsByMosno(mosno);

                                sinkeiyakuDomManager.delete(yuukoukknKykList);

                                if (C_UmuKbn.ARI.eq(syoriCTL.getMosnrkumu())) {

                                    BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit
                                        .skIdounaiyouSakujyoFileEdit(mosno);
                                    tjtIdouNySkLst.add(tjtIdouNySk);
                                }

                                delMousikomiSaibanKijyunTable(mosno);

                                mosnoList.add(mosno);
                                kykMosnoList.add(mosno);

                                updateMousikomiBangouKanriTable(mosnoKanri);

                                syoriKensuu = syoriKensuu + 1;
                            }
                        }
                        else {
                            delMousikomiSaibanKijyunTable(mosno);

                            mosnoList.add(mosno);

                            updateMousikomiBangouKanriTable(mosnoKanri);

                            syoriKensuu = syoriKensuu + 1;
                        }
                    }
                }
            }

            if(kykMosnoList.size() > 0){

                String kykMosnoArray[] = kykMosnoList.toArray(new String[0]);

                List<String> kouteiKanriIdList = skMosDataMaintenanceDao
                    .getGyoumuKouteiInfoKouteikanriidByMosnoJimutetuzukicd(kykMosnoArray, SKMAINDAIRITEN);

                String kouteiKanriIdArray[] = kouteiKanriIdList.toArray(new String[0]);


                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SkKouzahuriAnnaiData.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SkLincSousinData.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SkSyuunouKekkaData.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SkUriageData.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SmbcStyKanri.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SmbcStyKanriSsRireki.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SkDenpyoData.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SkFBSoukinData.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SkGaikaFBSoukinData.TABLE_NAME, KEYNM_MOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey( HT_SkLincJyusinData.TABLE_NAME, RENDOUMOSNOCHKNASI,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_SisyaToukeiHokan.TABLE_NAME, KEYNM_SSTMOSNO,
                    kykMosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(BT_HituyouSyoruiKanri.TABLE_NAME, KEYNM_KOUTEIKANRIID,
                    kouteiKanriIdArray);
            }

            if(mosnoList.size() > 0){
                String mosnoArray[] = mosnoList.toArray(new String[0]);


                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_MosMikakuteiJyouhouKanri.TABLE_NAME, KEYNM_MOSNO,
                    mosnoArray);

                skMosDataMaintenanceDao.delSkTableByDeleteKey(HT_MosMikakuteiSyorui.TABLE_NAME, KEYNM_MOSNO,
                    mosnoArray);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        return syoriKensuu;
    }

    private void delMousikomiSaibanKijyunTable(String pMosno) {

        HT_BosKihon bosKihon = sinkeiyakuDomManager.getBosKihon(pMosno);

        if(bosKihon != null) {
            sinkeiyakuDomManager.delete(bosKihon);
        }
    }

    private void updateMousikomiBangouKanriTable(HT_MosnoKanri pMosnoKanri) {

        pMosnoKanri.setSaibankahikbn(C_KahiKbn.KA);
        pMosnoKanri.setMossykykyoteiymd(null);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }

}