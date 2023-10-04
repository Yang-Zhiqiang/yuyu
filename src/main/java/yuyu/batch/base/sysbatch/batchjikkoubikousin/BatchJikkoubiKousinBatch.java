package yuyu.batch.base.sysbatch.batchjikkoubikousin;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_BatchDate;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;

/**
 * バッチ実行日更新のバッチクラスです。
 */
public class BatchJikkoubiKousinBatch implements Batch {

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BatchJikkoubiKousinBatchParams batchParam;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        List<AT_BatchDate> batchDateList = baseDomManager.getAT_BatchDateAll();
        baseDomManager.delete(batchDateList);
        AT_BatchDate batchDate = new AT_BatchDate();
        batchDate.setBatchExecDate(BizDate.getSysDate());
        baseDomManager.insert(batchDate);

    }

}
