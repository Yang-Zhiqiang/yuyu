package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.meta.QAS_KinouMode;

/**
 * 機能モード基幹TBL DAO クラス
 */
public class AS_KinouModeDao extends AbstractDao<AS_KinouMode> {

    public AS_KinouModeDao() {
        super(AS_KinouMode.class);
    }

    public List<AS_KinouMode> getKinouModesByKadouTimeGroup(String pKadouTimeGroupCd) {

        AS_KinouMode condEntity = new AS_KinouMode();
        condEntity.setKadouTimeGroupCd(pKadouTimeGroupCd);

        return select(condEntity);
    }

    public long getKinouModeByCountKadouTimeGroupCd(String pKadouTimeGroupCd) {

        QAS_KinouMode qKinouMode = new QAS_KinouMode();

        return  em.createJPQL(
            $SELECT + $COUNT(qKinouMode.kadouTimeGroupCd) +
            $FROM   + qKinouMode.AS_KinouMode() +
            $WHERE  + qKinouMode.kadouTimeGroupCd.eq(pKadouTimeGroupCd)
            ).bind(qKinouMode).<Long>getSingleResult().intValue();
    }
}