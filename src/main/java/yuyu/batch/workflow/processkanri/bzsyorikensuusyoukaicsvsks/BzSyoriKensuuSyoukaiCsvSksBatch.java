package yuyu.batch.workflow.processkanri.bzsyorikensuusyoukaicsvsks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.workflow.workflowutility.CountOfTaskSummaryByJimutetuzukiBean;
import yuyu.common.workflow.workflowutility.CountOfTaskSummaryByTaskBean;
import yuyu.common.workflow.workflowutility.GetCountOfTaskSummaryByJimutetuzukiResultBean;
import yuyu.common.workflow.workflowutility.GetCountOfTaskSummaryByTaskResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.common.workflow.workflowutility.dba4workflowutility.WorkFlowUtilityDao;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.file.csv.BzHozenSyoriKensuuSyoukaiCsvfFile;
import yuyu.def.biz.file.csv.BzSiharaiSyoriKensuuSyoukaiCsvfFile;
import yuyu.def.biz.file.csv.BzSinkeiyakuSyoriKensuuSyoukaiCsvfFile;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * ワークフロー プロセス管理 処理件数照会ＣＳＶ作成
 */
public class BzSyoriKensuuSyoukaiCsvSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private WorkFlowUtilityDao workFlowUtilityDao;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
                String.valueOf(syoriYmd)));

        String[] subsystemId = new String[] { "sinkeiyaku", "siharai", "hozen" };
        List<BzSinkeiyakuSyoriKensuuSyoukaiCsvfFile> bzSinkeiyakuSyoriKensuuSyoukaiCsvfFileLst = Lists.newArrayList();
        List<BzSiharaiSyoriKensuuSyoukaiCsvfFile> bzSiharaiSyoriKensuuSyoukaiCsvfFileLst = Lists.newArrayList();
        List<BzHozenSyoriKensuuSyoukaiCsvfFile> bzHozenSyoriKensuuSyoukaiCsvfFileLst = Lists.newArrayList();

        for (int m = 0; m < subsystemId.length; m++) {

            AS_SubSystem subSystem = baseDomManager.getSubSystem(subsystemId[m]);
            String subSystemNm = subSystem.getSubSystemNm();

            String[] newSubsystemId = new String[] {subsystemId[m]};
            List<DM_JimutetuzukiRireki> jimuTetuzukiRirekiLst = workFlowUtilityDao
                    .getJimutetuzukiRirekisBySyoriYmdSubSystemIds(syoriYmd, newSubsystemId);
            if (jimuTetuzukiRirekiLst.size() == 0) {
                continue;
            }

            String[] jimuTetuzukiCd = new String[jimuTetuzukiRirekiLst.size()];
            Map<String, String> jimuTetuzukiNmMap = new HashMap<String, String>();

            int n = 0;
            for (DM_JimutetuzukiRireki jimuTetuzukiRireki :jimuTetuzukiRirekiLst) {
                jimuTetuzukiCd[n] = jimuTetuzukiRireki.getJimutetuzukicd();
                jimuTetuzukiNmMap.put(jimuTetuzukiRireki.getJimutetuzukicd(), jimuTetuzukiRireki.getJimutetuzukinm());

                n++;
            }

            for (int o = 0; o < jimuTetuzukiCd.length; o++) {

                String userId = "";

                GetCountOfTaskSummaryByJimutetuzukiResultBean countOfTaskSummaryByJimutetuzukiResultBean =
                        WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(newSubsystemId, syoriYmd,
                                jimuTetuzukiCd[o], userId);

                if (WorkFlowResultConstants.RESULT_NODATA.equals(
                        countOfTaskSummaryByJimutetuzukiResultBean.getSyorikekkaStatus())) {
                    continue;
                }

                List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
                        countOfTaskSummaryByJimutetuzukiResultBean.getCountOfTaskSummaryBean();

                String[] taskId = new String[countOfTaskSummaryByJimutetuzukiBeanLst.size()];
                int p = 0;
                for (CountOfTaskSummaryByJimutetuzukiBean countOfTaskSummaryByJimutetuzukiBean :
                    countOfTaskSummaryByJimutetuzukiBeanLst) {
                    taskId[p] = countOfTaskSummaryByJimutetuzukiBean.getTaskNm();

                    p++;
                }

                if (taskId.length == 0) {

                    continue;
                }

                GetCountOfTaskSummaryByTaskResultBean countOfTaskSummaryByTaskResultBean =
                        WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByTask(
                                syoriYmd, jimuTetuzukiCd[o], taskId, userId);
                if (!WorkFlowResultConstants.RESULT_OK.equals(
                        countOfTaskSummaryByTaskResultBean.getSyorikekkaStatus())) {
                    continue;
                }

                List<CountOfTaskSummaryByTaskBean> countOfTaskSummaryByTaskBeanLst =
                        countOfTaskSummaryByTaskResultBean.getCountOfTaskSummaryBean();

                for (CountOfTaskSummaryByJimutetuzukiBean countOfJimuBean : countOfTaskSummaryByJimutetuzukiBeanLst) {
                    for (CountOfTaskSummaryByTaskBean countOfTaskBean : countOfTaskSummaryByTaskBeanLst) {

                        if (countOfJimuBean.getJimutetuzukiCd().equals(countOfTaskBean.getJimutetuzukiCd()) &&
                                countOfJimuBean.getTaskNm().equals(countOfTaskBean.getTaskNm())) {
                            if ("sinkeiyaku".equals(subsystemId[m])) {

                                BzSinkeiyakuSyoriKensuuSyoukaiCsvfFile bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile =
                                        new BzSinkeiyakuSyoriKensuuSyoukaiCsvfFile();

                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcSubsystem(subSystemNm);
                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcSyoriymd2(
                                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoriYmd));
                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcJimutetuzukinm(jimuTetuzukiNmMap.get(
                                        countOfJimuBean.getJimutetuzukiCd()));
                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcWorkflowTskNm(
                                        countOfJimuBean.getDispTaskNm());
                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcUserId(
                                        countOfTaskBean.getUserId());
                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcUsernm(
                                        countOfTaskBean.getDispUserNm());
                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcZenjituzanKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessStartToday()));
                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcZanKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessLeftToday()));
                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile.setIfcKanryoKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessFinToday()));

                                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFileLst.add(bzSinkeiyakuSyoriKensuuSyoukaiCsvfFile);
                            }
                            else if ("siharai".equals(subsystemId[m])) {

                                BzSiharaiSyoriKensuuSyoukaiCsvfFile bzSiharaiSyoriKensuuSyoukaiCsvfFile =
                                        new BzSiharaiSyoriKensuuSyoukaiCsvfFile();

                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcSubsystem(subSystemNm);
                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcSyoriymd2(
                                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoriYmd));
                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcJimutetuzukinm(jimuTetuzukiNmMap.get(
                                        countOfJimuBean.getJimutetuzukiCd()));
                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcWorkflowTskNm(
                                        countOfJimuBean.getDispTaskNm());
                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcUserId(
                                        countOfTaskBean.getUserId());
                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcUsernm(
                                        countOfTaskBean.getDispUserNm());
                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcZenjituzanKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessStartToday()));
                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcZanKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessLeftToday()));
                                bzSiharaiSyoriKensuuSyoukaiCsvfFile.setIfcKanryoKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessFinToday()));

                                bzSiharaiSyoriKensuuSyoukaiCsvfFileLst.add(bzSiharaiSyoriKensuuSyoukaiCsvfFile);
                            }
                            else if ("hozen".equals(subsystemId[m])) {

                                BzHozenSyoriKensuuSyoukaiCsvfFile bzHozenSyoriKensuuSyoukaiCsvfFile =
                                        new BzHozenSyoriKensuuSyoukaiCsvfFile();

                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcSubsystem(subSystemNm);
                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcSyoriymd2(
                                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoriYmd));
                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcJimutetuzukinm(jimuTetuzukiNmMap.get(
                                        countOfJimuBean.getJimutetuzukiCd()));
                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcWorkflowTskNm(
                                        countOfJimuBean.getDispTaskNm());
                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcUserId(
                                        countOfTaskBean.getUserId());
                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcUsernm(
                                        countOfTaskBean.getDispUserNm());
                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcZenjituzanKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessStartToday()));
                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcZanKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessLeftToday()));
                                bzHozenSyoriKensuuSyoukaiCsvfFile.setIfcKanryoKensuu(
                                        String.valueOf(countOfTaskBean.getCountOfprocessFinToday()));

                                bzHozenSyoriKensuuSyoukaiCsvfFileLst.add(bzHozenSyoriKensuuSyoukaiCsvfFile);
                            }
                        }
                    }
                }
            }
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn sinkeiyakuErrorKbn = bzFileUploadUtil.exec( C_FileSyuruiCdKbn.BZ_SINKEIYAKUSYORIKENSUUSYOUKAICSVF,
                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFileLst, true);
        if (C_ErrorKbn.ERROR.eq(sinkeiyakuErrorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        C_ErrorKbn siharaiSyoriErrorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.BZ_SIHARAISYORIKENSUUSYOUKAICSVF,
                bzSiharaiSyoriKensuuSyoukaiCsvfFileLst, true);
        if (C_ErrorKbn.ERROR.eq(siharaiSyoriErrorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        C_ErrorKbn hozenSyoriErrorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.BZ_HOZENSYORIKENSUUSYOUKAICSVF,
                bzHozenSyoriKensuuSyoukaiCsvfFileLst, true);
        if (C_ErrorKbn.ERROR.eq(hozenSyoriErrorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(
                bzSinkeiyakuSyoriKensuuSyoukaiCsvfFileLst.size()),
                "（共通）新契約処理件数照会ＣＳＶＦファイル"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(
                bzSiharaiSyoriKensuuSyoukaiCsvfFileLst.size()),
                "（共通）保険金給付金支払処理件数照会ＣＳＶＦファイル"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(
                bzHozenSyoriKensuuSyoukaiCsvfFileLst.size()),
                "（共通）契約保全処理件数照会ＣＳＶＦファイル"));
    }
}
