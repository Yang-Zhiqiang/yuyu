package yuyu.batch.ray.control.invalidfunctionupdatebatch;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KinouIdKinouModeIdKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 有効区分更新バッチのバッチクラスです。
 */
public class InvalidFunctionUpdateBatch implements Batch {

    @Inject
    private static Logger  log;
    @Inject
    private BatchLogger    batchLogger;
    @Inject
    private BaseDomManager baseManager;
    @Inject
    private InvalidFunctionUpdateBatchParam batchParam;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        log.debug("有効区分更新バッチ　開始");
        checkParam();

        if (!update()) {
            batchLogger.error(
                MessageUtil.getMessage(
                    MessageId.EAF1015,
                    MessageUtil.getMessage(MessageId.IAW1011),
                    MessageUtil.getMessage(MessageId.IAW1013)));
            BatchJob batchJob = SWAKInjector.getInstance(BatchJob.class);
            batchJob.setWarningStatus(200);
        }

        log.debug("有効区分更新バッチ　終了");
    }

    private void checkParam() {
        if (batchParam.getYuukouKbn() == null) {
            throw new BizAppException(MessageId.EAF1009, MessageUtil.getMessage(MessageId.IAW1011));
        }
        if (batchParam.getKinouIdKinouModeIdKbn() == null) {
            throw new BizAppException(MessageId.EAF1009, MessageUtil.getMessage(MessageId.IAW1010));
        }
        if (Strings.isNullOrEmpty(batchParam.getKousinData())) {
            throw new BizAppException(MessageId.EAF1013);
        } else {
            if (!batchParam.getKinouIdKinouModeIdKbn().equals(C_KinouIdKinouModeIdKbn.KINOUID)) {
                String[] kousinDatas = batchParam.getKousinData().split(InvalidFunctionUpdateBatchConstants.SPLITTER);
                if (kousinDatas.length % 2 != 0) {
                    throw new BizAppException(MessageId.EAF1014);
                }
            }
        }
    }

    @Transactional
    private boolean update() {
        boolean result = true;
        String[] kousinDatas = batchParam.getKousinData().split(InvalidFunctionUpdateBatchConstants.SPLITTER);

        if (batchParam.getKinouIdKinouModeIdKbn().equals(C_KinouIdKinouModeIdKbn.KINOUID)) {
            for (int i = 0; i < kousinDatas.length; i++) {
                String kinouId = kousinDatas[i];

                if (kinouId.equals(InvalidFunctionUpdateBatchConstants.KINOUID_ALL)) {
                    List<AS_Kinou> kinouList = baseManager.getAllKinous();
                    for (AS_Kinou kinou : kinouList) {

                        if(kinou.getKinouKbn().eq(C_KinouKbn.ONLINE)){
                            updateForKinouId(kinou);
                        }
                    }
                    break;
                } else {
                    AS_Kinou kinou = baseManager.getKinou(kinouId);
                    if (kinou == null) {
                        batchLogger.error(
                            MessageUtil.getMessage(
                                MessageId.EAF1012,
                                MessageUtil.getMessage(MessageId.IAW1002),
                                new AS_Kinou().getViewName(),
                                MessageUtil.getMessage(MessageId.IAW1007),
                                MessageUtil.getMessage(MessageId.IAW1002),
                                kinouId));
                        result = false;
                        continue;
                    }
                    updateForKinouId(kinou);
                }

            }
        } else {
            for (int i = 0; i < kousinDatas.length; i+=2) {
                String kinouId = kousinDatas[i];
                String kinouModeId = kousinDatas[i + 1];

                AS_Kinou kinou = baseManager.getKinou(kinouId);
                if (kinou == null) {
                    batchLogger.error(
                        MessageUtil.getMessage(
                            MessageId.EAF1012,
                            MessageUtil.getMessage(MessageId.IAW1002),
                            new AS_Kinou().getViewName(),
                            MessageUtil.getMessage(MessageId.IAW1007),
                            MessageUtil.getMessage(MessageId.IAW1002),
                            kinouId));
                    result = false;
                    continue;
                }
                AS_KinouMode kinouMode = kinou.getKinouMode(kinouModeId);
                if (kinouMode == null) {
                    batchLogger.error(
                        MessageUtil.getMessage(
                            MessageId.EAF1012,
                            MessageUtil.getMessage(MessageId.IAW1003),
                            new AS_KinouMode().getViewName(),
                            MessageUtil.getMessage(MessageId.IAW1007),
                            MessageUtil.getMessage(MessageId.IAW1003),
                            kinouModeId));
                    result = false;
                    continue;
                }
                kinouMode.setYuukouKbn(batchParam.getYuukouKbn());
                baseManager.update(kinouMode);
            }
        }
        return result;
    }

    @Transactional
    private void updateForKinouId(AS_Kinou kinou) {
        Set<AS_KinouMode> kinouModes = kinou.getKinouModes();
        if (kinouModes != null) {
            for (AS_KinouMode kinouMode : kinouModes) {
                kinouMode.setYuukouKbn(batchParam.getYuukouKbn());
                baseManager.update(kinouMode);
            }
        }
    }
}
