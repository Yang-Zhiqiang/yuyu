package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.def.db.meta.QAT_TokuteibiKadouTime;

/**
 * 特定日稼働時間テーブル( AT_TokuteibiKadouTime ) に対するDB操作を提供する。
 */
public class AT_TokuteibiKadouTimeDao extends AbstractDao<AT_TokuteibiKadouTime> {

    protected AT_TokuteibiKadouTimeDao() {
        super(AT_TokuteibiKadouTime.class);
    }

    public AT_TokuteibiKadouTime getAT_TokuteibiKadouTime(String pKadouTimeGroupCd, BizDate pKadouTimeSiteiYmd) {
        AT_TokuteibiKadouTime condEntity = new AT_TokuteibiKadouTime();
        condEntity.setKadouTimeGroupCd(pKadouTimeGroupCd);
        condEntity.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd);
        return selectOne(condEntity);
    }

    public long getTokuteibiKadouTimeByCountKadouTimeGroupCd(String pKadouTimeGroupCd) {

        QAT_TokuteibiKadouTime qTokuteibiKadouTime = new QAT_TokuteibiKadouTime();

        return  em.createJPQL(
            $SELECT + $COUNT(qTokuteibiKadouTime.kadouTimeGroupCd) +
            $FROM   + qTokuteibiKadouTime.AT_TokuteibiKadouTime() +
            $WHERE  + qTokuteibiKadouTime.kadouTimeGroupCd.eq(pKadouTimeGroupCd)
            ).bind(qTokuteibiKadouTime).<Long>getSingleResult();
    }

}