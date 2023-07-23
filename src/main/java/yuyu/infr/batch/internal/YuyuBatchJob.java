package yuyu.infr.batch.internal;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.id.PKAT_BatchJob;

/**
 * Yuyuバッチジョブ実装クラス
 */
@BatchScoped
public class YuyuBatchJob extends BatchJob {

    @Override
    public void interrupt() {
        ExDBTransactional.run(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager entityManager) {
                    AT_BatchJob jobEntity = entityManager.findByPK(new PKAT_BatchJob(getBatchJobId()));
                    if (C_BatchJyoutaiKbn.SYORI.eq(jobEntity.getBatchJyoutaiKbn())) {
                        jobEntity.setBatchJyoutaiKbn(C_BatchJyoutaiKbn.SYUURYOU_TYU);
                    }
                }
            }
        );
        super.interrupt();
    }
}
