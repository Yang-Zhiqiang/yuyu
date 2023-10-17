package yuyu.batch.biz.bzkaikei.bzfbsoukintrkmsk;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzfbsoukintrkmsk.dba.BzFBSoukinTrkmSkDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.kaikei.BzFbSoukinTrkmHensyu;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 ＦＢ送金データ取込（新契約）
 */
public class BzFBSoukinTrkmSkBatch implements Batch {

    @Inject
    private BzFBSoukinTrkmSkDao bzFBSoukinTrkmSkDao;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    public final String onlineShr = "RGDAD000";

    public final String SkFBSoukinDataTable = "HT_SkFBSoukinData";

    public final String FBSoukinDataFilter = "Bz107";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syoriKensuu = 0;

        BT_FBSoukinData btFBSoukinData = null;
        BzFbSoukinTrkmHensyu bzFbSoukinTrkmHensyu = SWAKInjector.getInstance(BzFbSoukinTrkmHensyu.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), bzBatchParam.getSyoriYmd().toString()));

        try (ExDBResults<HT_SkFBSoukinData> skFBSoukinDataList =
            bzBatchParam.getIbKakutyoujobcd().equals(onlineShr) ? bzFBSoukinTrkmSkDao.getOnlineSkFBSoukinDatas(
                bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd(), C_KinouKbn.BATCH) :
                    bzFBSoukinTrkmSkDao.getBatchSkFBSoukinDatas(bzBatchParam.getIbKakutyoujobcd(),
                        bzBatchParam.getSyoriYmd(), C_KinouKbn.BATCH);
            EntityInserter<BT_FBSoukinData> entityInserter = new EntityInserter<>()) {

            C_FbSoukinBatchKbn fbSoukinBatchKbn = null;
            if (bzBatchParam.getIbKakutyoujobcd().equals(onlineShr)) {
                fbSoukinBatchKbn = C_FbSoukinBatchKbn.NONE;
            } else {
                fbSoukinBatchKbn = C_FbSoukinBatchKbn.BATCH;
            }

            Iterator<HT_SkFBSoukinData> iterator = skFBSoukinDataList.iterator();
            if(!iterator.hasNext()) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
                return;
            }

            while (iterator.hasNext()) {

                HT_SkFBSoukinData htSkFBSoukinData = iterator.next();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(SkFBSoukinDataTable);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FBSoukinDataFilter);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(htSkFBSoukinData.getFbsoukindatasikibetukey());

                btFBSoukinData = bzFbSoukinTrkmHensyu.exec(htSkFBSoukinData, fbSoukinBatchKbn);

                BizPropertyInitializer.initialize(btFBSoukinData);

                entityInserter.add(btFBSoukinData);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}