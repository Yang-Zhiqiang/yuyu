package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_KadouTimeGroup;

/**
 * 稼働時間グループテーブル( AT_KadouTimeGroup ) に対するDB操作を提供する。
 */
public class AT_KadouTimeGroupDao extends AbstractDao<AT_KadouTimeGroup> {

    protected AT_KadouTimeGroupDao() {
        super(AT_KadouTimeGroup.class);
    }

    public AT_KadouTimeGroup getAT_KadouTimeGroup(String pKadouTimeGroupCd) {
        AT_KadouTimeGroup condEntity = new AT_KadouTimeGroup();
        condEntity.setKadouTimeGroupCd(pKadouTimeGroupCd);
        return selectOne(condEntity);
    }

}