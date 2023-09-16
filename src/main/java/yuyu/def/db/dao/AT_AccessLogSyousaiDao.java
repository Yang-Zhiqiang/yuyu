package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.def.db.meta.QAT_AccessLogSyousai;

import com.google.common.collect.Ordering;

/**
 * アクセスログ詳細テーブル ( AT_AccessLogSyousai ) アクセス用の DAO クラスです。
 */
public class AT_AccessLogSyousaiDao extends AbstractDao<AT_AccessLogSyousai> {

    public AT_AccessLogSyousaiDao() {
        super(AT_AccessLogSyousai.class);
    }

    private static final Ordering<AT_AccessLogSyousai> pkOrder = new Ordering<AT_AccessLogSyousai>() {
        @Override
        public int compare(AT_AccessLogSyousai syousai1, AT_AccessLogSyousai syousai2) {
            int result = syousai1.getLogId().compareTo(syousai2.getLogId());
            if (result != 0) {
                return result;
            }
            return syousai1.getSyousaiEdaNo().compareTo(syousai2.getSyousaiEdaNo());
        }
    };

    public List<AT_AccessLogSyousai> getAccessLogSyousaisByLogIdEdaNoOrder(String pLogId) {

        QAT_AccessLogSyousai qAccessLogSyousai = new QAT_AccessLogSyousai();
        return em.createJPQL(
            $SELECT + qAccessLogSyousai +
            $FROM   + qAccessLogSyousai.AT_AccessLogSyousai() +
            $WHERE  + qAccessLogSyousai.logId.eq(pLogId) +
            $ORDER_BY(qAccessLogSyousai.syousaiEdaNo)
            ).bind(qAccessLogSyousai).getResultList();
    }
}
