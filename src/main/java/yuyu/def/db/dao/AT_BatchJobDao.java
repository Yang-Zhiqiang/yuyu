package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.meta.QAT_BatchJob;
import yuyu.def.db.meta.QAT_BatchLogReport;

/**
 * バッチジョブテーブル(AT_BatchJob) テーブルアクセス用の DAO クラスです。
 *
 */
public class AT_BatchJobDao extends AbstractDao<AT_BatchJob> {

    protected AT_BatchJobDao() {
        super(AT_BatchJob.class);
    }

    public long getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn (
        String[] pBatchIds,
        BizDate pBatchSyoriYmdFrom,
        BizDate pBatchSyoriYmdTo,
        C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
        C_BatchResultKbn[] pBatchResultKbns
        ) {

        QAT_BatchJob qBatchJob = new QAT_BatchJob();


        String where = makeWhereByIdSyoriYmdJyoutaiKbnResultKbn(
            qBatchJob,
            pBatchIds,
            pBatchSyoriYmdFrom,
            pBatchSyoriYmdTo,
            pBatchJyoutaiKbns,
            pBatchResultKbns);


        StringBuilder sb = new StringBuilder();
        sb.append($SELECT);
        sb.append($COUNT(qBatchJob.batchJobId));
        sb.append($FROM);
        sb.append(qBatchJob.AT_BatchJob());

        if (where.length() > 0) {
            sb.append($WHERE);
            sb.append(where);
        }


        return em.createJPQL(sb.toString()).bind(qBatchJob).<Long>getSingleResult();
    }

    public List<AT_BatchJob> getBatchJobListByIdbatchStartTimebatchEndTimeJyoutaiKbnResultKbn (
        String[] pBatchJobIds,
        BizDate pBatchSyoriYmdFrom,
        BizDate pBatchSyoriYmdTo,
        C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
        C_BatchResultKbn[] pBatchResultKbns
        ) {

        QAT_BatchJob       batchJob  = new QAT_BatchJob();
        QAT_BatchLogReport batchRepo = new QAT_BatchLogReport();


        String where = makeWhereByIdSyoriYmdJyoutaiKbnResultKbn(
            batchJob,
            pBatchJobIds,
            pBatchSyoriYmdFrom,
            pBatchSyoriYmdTo,
            pBatchJyoutaiKbns,
            pBatchResultKbns);


        String query = $SELECT_DISTINCT + batchJob +
                       $FROM(batchJob) +
                       $LEFT_OUTER_JOIN_FETCH + batchJob.toString().trim() + ".batchLogReports" + batchRepo;

        if (where.length() > 0) {
            query += $WHERE + where;
        }

        query += $ORDER_BY(batchJob.batchEndTime.desc(),batchJob.batchStartTime.desc());


        return em.createJPQL(query).bind(batchJob, batchRepo).getResultList();
    }

    public AT_BatchJob getAT_BatchJob(String pBatchJobId){

        AT_BatchJob batchJob = new AT_BatchJob();
        batchJob.setBatchJobId(pBatchJobId);

        return selectOne(batchJob);
    }

    private String makeWhereByIdSyoriYmdJyoutaiKbnResultKbn (
        QAT_BatchJob pBatchJob,
        String[] pBatchIds,
        BizDate pBatchSyoriYmdFrom,
        BizDate pBatchSyoriYmdTo,
        C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
        C_BatchResultKbn[] pBatchResultKbns
        ) {
        StringBuilder where = new StringBuilder();

        if (pBatchIds != null && pBatchIds.length > 0) {
            where.append(pBatchJob.batchId.in(pBatchIds));
        }


        if (pBatchSyoriYmdFrom != null) {

            if (where.length() > 0) {
                where.append($AND);
            }
            where.append(pBatchJob.batchSyoriYmd.ge(pBatchSyoriYmdFrom));
        }


        if (pBatchSyoriYmdTo != null) {

            if (where.length() > 0) {
                where.append($AND);
            }
            where.append(pBatchJob.batchSyoriYmd.le(pBatchSyoriYmdTo));
        }

        boolean batcuJyoutaiIsSetteing = pBatchJyoutaiKbns != null && pBatchJyoutaiKbns.length > 0;
        boolean batcuResultIsSetteing = pBatchResultKbns != null && pBatchResultKbns.length > 0;


        if (batcuJyoutaiIsSetteing && batcuResultIsSetteing)   {

            if (where.length() > 0) {
                where.append($AND);
            }
            where.append($(
                pBatchJob.batchJyoutaiKbn.in(pBatchJyoutaiKbns) +
                $AND +
                pBatchJob.batchResultKbn.in(pBatchResultKbns)
                ));
        }

        else if (batcuJyoutaiIsSetteing && !batcuResultIsSetteing) {

            if (where.length() > 0) {
                where.append($AND);
            }
            where.append(pBatchJob.batchJyoutaiKbn.in(pBatchJyoutaiKbns));
        }

        else if (!batcuJyoutaiIsSetteing && batcuResultIsSetteing) {

            if (where.length() > 0) {
                where.append($AND);
            }
            where.append(pBatchJob.batchResultKbn.in(pBatchResultKbns));
        }


        return where.toString();
    }
}
