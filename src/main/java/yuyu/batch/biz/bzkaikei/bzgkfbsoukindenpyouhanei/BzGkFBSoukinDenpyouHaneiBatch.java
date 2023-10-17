package yuyu.batch.biz.bzkaikei.bzgkfbsoukindenpyouhanei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.detacher.BT_DenpyoDataDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金伝票データ反映
 */
public class BzGkFBSoukinDenpyouHaneiBatch implements Batch {

    private final String FILTERID = "Bz107";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        int count = 0;
        String sysTime = BizDate.getSysDateTimeMilli();
        String kinouId = kinou.getKinouId();
        String userId = baseUserInfo.getUserId();

        try (ExDBUpdatableResults<BT_GkFBSoukinData> gkFBSoukinDataLst =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd())) {

            for (BT_GkFBSoukinData gkFBSoukinData : gkFBSoukinDataLst) {

                BT_GkFBSoukinHukaInfo soukinHukaInfo = gkFBSoukinData.getGkFBSoukinHukaInfo();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_GkFBSoukinData.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(gkFBSoukinData.getFbsoukindatasikibetukey());

                BT_DenpyoData denpyoData = BT_DenpyoDataDetacher.detachDenpyoDatatouched(bizDomManager.getDenpyoData(
                    gkFBSoukinData.getDensyskbn(),
                    gkFBSoukinData.getDenrenno(),
                    gkFBSoukinData.getEdano()));

                soukinHukaInfo.setDengk(denpyoData.getDenyenkagk());
                // soukinHukaInfo.setGyoumuKousinKinou(kinouId);
                // soukinHukaInfo.setGyoumuKousinsyaId(userId);
                // soukinHukaInfo.setGyoumuKousinTime(sysTime);

                count++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
