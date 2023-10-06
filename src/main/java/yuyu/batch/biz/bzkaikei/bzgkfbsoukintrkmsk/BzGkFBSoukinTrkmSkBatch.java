package yuyu.batch.biz.bzkaikei.bzgkfbsoukintrkmsk;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.kaikei.BzGkFbSoukinTrkmHensyu;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金データ取込（新契約）クラス
 */
public class BzGkFBSoukinTrkmSkBatch implements Batch {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    public final String SkFBSoukinDataTable = "HT_SkGaikaFBSoukinData";

    public final String FBSoukinDataFilter = "Bz107";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syoriKensuu = 0;

        BT_GkFBSoukinData btGkFBSoukinData = null;
        BzGkFbSoukinTrkmHensyu bzGkFbSoukinTrkmHensyu = SWAKInjector.getInstance(BzGkFbSoukinTrkmHensyu.class);

        String syoriYmd = bzBatchParam.getSyoriYmd().toString();

        String message =
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd);

        batchLogger.info(message);

        try (ExDBResults<HT_SkGaikaFBSoukinData> htSkGaikaFBSoukinDataList = sinkeiyakuDomManager.
            getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd());
            EntityInserter<BT_GkFBSoukinData> gkFBSoukinDataLst = new EntityInserter<>()) {

            Iterator<HT_SkGaikaFBSoukinData> iterator = htSkGaikaFBSoukinDataList.iterator();

            if (!iterator.hasNext()) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
                return;
            }

            while (iterator.hasNext()) {

                HT_SkGaikaFBSoukinData htSkGaikaFBSoukinData = iterator.next();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(SkFBSoukinDataTable);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FBSoukinDataFilter);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(
                    htSkGaikaFBSoukinData.getFbsoukindatasikibetukey());

                btGkFBSoukinData = bzGkFbSoukinTrkmHensyu.exec(htSkGaikaFBSoukinData);

                BizPropertyInitializer.initialize(btGkFBSoukinData);

                gkFBSoukinDataLst.add(btGkFBSoukinData);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)) );
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}