package yuyu.batch.biz.bzkaikei.bzfbsoukintrkmkh;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzfbsoukintrkmkh.dba.BzFBSoukinTrkmKhDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.kaikei.BzFbSoukinTrkmHensyu;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 ＦＢ送金データ取込（契約保全）
 */
public class BzFBSoukinTrkmKhBatch implements Batch {

    @Inject
    private BzFBSoukinTrkmKhDao bzFBSoukinTrkmKhDao;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    public final String onlineShr = "RGDBD000";

    public final String tableID = "IT_KhFBSoukinData";

    public final String filterID = "Bz107";

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

        String syoriYmd = bzBatchParam.getSyoriYmd().toString();

        String message =
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd);

        batchLogger.info(message);

        try (ExDBResults<IT_KhFBSoukinData> khFBSoukinDataList =
            bzBatchParam.getIbKakutyoujobcd().equals(onlineShr) ? bzFBSoukinTrkmKhDao.getOnlineKhFBSoukinDatas(
                bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd(), C_KinouKbn.BATCH) :
                    bzFBSoukinTrkmKhDao.getBatchKhFBSoukinDatas(bzBatchParam.getIbKakutyoujobcd(),
                        bzBatchParam.getSyoriYmd(), C_KinouKbn.BATCH);
            EntityInserter<BT_FBSoukinData> fBSoukinDataLst = new  EntityInserter<>()){

            C_FbSoukinBatchKbn fbSoukinBatchKbn = null;
            if (bzBatchParam.getIbKakutyoujobcd().equals(onlineShr)) {
                fbSoukinBatchKbn = C_FbSoukinBatchKbn.NONE;
            } else {
                fbSoukinBatchKbn = C_FbSoukinBatchKbn.BATCH;
            }

            Iterator<IT_KhFBSoukinData> khFBSoukinDataIter = khFBSoukinDataList.iterator();

            if(!khFBSoukinDataIter.hasNext()) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
                return;
            }

            while (khFBSoukinDataIter.hasNext()) {


                IT_KhFBSoukinData khFBSoukinData = khFBSoukinDataIter.next();
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(tableID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(filterID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khFBSoukinData.getFbsoukindatasikibetukey());

                btFBSoukinData = bzFbSoukinTrkmHensyu.exec(khFBSoukinData, fbSoukinBatchKbn);

                BizPropertyInitializer.initialize(btFBSoukinData);

                fBSoukinDataLst.add(btFBSoukinData);

                syoriKensuu++;

            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
