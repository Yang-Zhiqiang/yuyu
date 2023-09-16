package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.meta.QAT_BatchLog;

/**
 * バッチログテーブル(AT_BatchLog) テーブルアクセス用の DAO クラスです。
 *
 */
public class AT_BatchLogDao extends AbstractDao<AT_BatchLog> {

    protected AT_BatchLogDao() {
        super(AT_BatchLog.class);
    }

    public List<AT_BatchLog> getBatchLogByBatchJobId(String pBatchJobId) {

        QAT_BatchLog qBatchLog = new QAT_BatchLog();


        String query =
            $SELECT + qBatchLog +
            $FROM + qBatchLog.AT_BatchLog() +
            $WHERE + qBatchLog.batchJobId.eq(pBatchJobId) +
            $ORDER_BY(qBatchLog.batchLogEdaNo.asc());


        return select(query, qBatchLog);
    }

}
