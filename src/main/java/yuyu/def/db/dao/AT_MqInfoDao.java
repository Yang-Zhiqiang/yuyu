package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_MqInfo;

/**
 * ＭＱ情報テーブル( AT_MqInfo ) に対するDB操作を提供する。
 */
public class AT_MqInfoDao extends AbstractDao<AT_MqInfo> {

    public AT_MqInfoDao() {
        super(AT_MqInfo.class);
    }

    public AT_MqInfo getAT_MqInfo(String pServerType) {
        AT_MqInfo condEntity = new AT_MqInfo();
        condEntity.setServerType(pServerType);
        return selectOne(condEntity);
    }
}