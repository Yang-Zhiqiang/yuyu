package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.meta.QAT_AccessLog;

/**
 * アクセスログテーブル ( AT_AccessLog ) アクセス用の DAO クラスです。
 */
public class AT_AccessLogExDao extends AbstractDao<AT_AccessLog> {

    public AT_AccessLogExDao() {
        super(AT_AccessLog.class);
    }

    public ExDBResults<AT_AccessLog> getAccessLogsByTimeStamp(Long pSyoriYmdFrom, Long pSyoriYmdTo) {


        QAT_AccessLog qAccessLog = new QAT_AccessLog();

        String queryStr = $SELECT + qAccessLog +
            $FROM + qAccessLog.AT_AccessLog() +
            $WHERE + qAccessLog.timeStamp.ge(pSyoriYmdFrom) +
            $AND + qAccessLog.timeStamp.le(pSyoriYmdTo) +
            $ORDER_BY(qAccessLog.timeStamp.asc());

        return em.createJPQL(queryStr).bind(qAccessLog).getResults();

    }

    public ExDBResults<AT_AccessLog> getAccessLogsBySyoriYmdFromSyoriYmdTo(Long pSyoriYmdFrom, Long pSyoriYmdTo) {


        QAT_AccessLog qAccessLog = new QAT_AccessLog();

        String queryStr = $SELECT + qAccessLog +
            $FROM + qAccessLog.AT_AccessLog() +
            $WHERE + qAccessLog.timeStamp.ge(pSyoriYmdFrom) +
            $AND + qAccessLog.timeStamp.le(pSyoriYmdTo) +
            $AND + qAccessLog.logKindCd.eq(C_AccessLogSyubetuKbn.ACTION_BEGIN) +
            $ORDER_BY(qAccessLog.timeStamp.asc());

        return em.createJPQL(queryStr).bind(qAccessLog).getResults();

    }
}