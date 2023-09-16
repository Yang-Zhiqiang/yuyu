package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_BatchLogReport;
import yuyu.def.db.meta.QAT_BatchLogReport;

/**
 * バッチログレポートテーブル(AT_BatchLogReport) テーブルアクセス用の DAO クラスです。
 *
 */
public class AT_BatchLogReportDao extends AbstractDao<AT_BatchLogReport> {

    protected AT_BatchLogReportDao() {
        super(AT_BatchLogReport.class);
    }

    public List<AT_BatchLogReport> getBatchLogReportByBatchJobId(String pBatchJobId) {

        QAT_BatchLogReport qBatchReport = new QAT_BatchLogReport();


        String query =
            $SELECT + qBatchReport +
            $FROM + qBatchReport.AT_BatchLogReport() +
            $WHERE + qBatchReport.batchJobId.eq(pBatchJobId) +
            $ORDER_BY(qBatchReport.reportKey.asc());


        return select(query, qBatchReport);
    }

}
