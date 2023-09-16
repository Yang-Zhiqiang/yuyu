package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.def.db.meta.QAT_UserHenkouRireki;

/**
 * ユーザー変更履歴(AT_UserHenkouRireki) テーブルアクセス用の DAO クラスです。
 *
 */
public class AT_UserHenkouRirekiDao extends AbstractDao<AT_UserHenkouRireki> {

    protected AT_UserHenkouRirekiDao() {
        super(AT_UserHenkouRireki.class);
    }

    public List<AT_UserHenkouRireki> getUserHenkouRirekis(String pUserId) {
        QAT_UserHenkouRireki qUserHenkouRireki = new QAT_UserHenkouRireki();
        return em.createJPQL(
            $SELECT + qUserHenkouRireki +
            $FROM   + qUserHenkouRireki.AT_UserHenkouRireki() +
            $WHERE  + qUserHenkouRireki.userId.eq(pUserId) +
            $ORDER_BY(qUserHenkouRireki.kousinTime, qUserHenkouRireki.uniqueId)
            ).bind(qUserHenkouRireki).getResultList();
    }

    public AT_UserHenkouRireki getUserHenkouRirekiByUniqueId(String pUniqueId) {

        AT_UserHenkouRireki aT_UserHenkouRireki = new AT_UserHenkouRireki();
        aT_UserHenkouRireki.setUniqueId(pUniqueId);

        return selectOne(aT_UserHenkouRireki);
    }
}
