package yuyu.batch.suuri.srsuuritoukei.srdshrtoukeiloading;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 Ｄ支払統計ローディング情報作成クラス
 */
public class SrDshrToukeiLoadingBatch implements Batch {

    private long tableTourokuCount;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrDshrToukeiLoadingBatchParam batchParam;

    @Override
    public SrDshrToukeiLoadingBatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        SrDshrToukeiLoadingBatchDbAccess dbAccess = SWAKInjector.getInstance(SrDshrToukeiLoadingBatchDbAccess.class);
        SrDshrToukeiLoadingBatchEdit koumokuEdit = SWAKInjector.getInstance(SrDshrToukeiLoadingBatchEdit.class);

        try (
            ExDBResults<StDshrTukiTyukeiyouItzHznBean> stDshrTukiTyukeiyouItzHznBeanList = dbAccess
            .getSrDshrToukeiLoadingInfo();
            EntityInserter<ZT_DshrToukeiLoadingTy> entityInserter = new EntityInserter<>()) {

            for (StDshrTukiTyukeiyouItzHznBean stDshrTukiTyukeiyouItzHznBean : stDshrTukiTyukeiyouItzHznBeanList) {

                ZT_DshrToukeiLoadingTy dshrToukeiLoadingTy = new ZT_DshrToukeiLoadingTy();

                koumokuEdit.editKoumoku(batchParam, stDshrTukiTyukeiyouItzHznBean, dshrToukeiLoadingTy);

                BizPropertyInitializer.initialize(dshrToukeiLoadingTy);

                entityInserter.add(dshrToukeiLoadingTy);

                tableTourokuCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "Ｄ支払統計ローディングＦテーブル（中）",
            String.valueOf(tableTourokuCount)));
    }
}
