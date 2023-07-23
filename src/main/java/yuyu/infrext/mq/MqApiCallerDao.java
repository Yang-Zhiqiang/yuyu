package yuyu.infrext.mq;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_MqInfo;

/**
 * ＭＱ情報テーブル( AT_MqInfo ) に対するDB操作を提供する。
 */
public class MqApiCallerDao extends AbstractDao<AT_MqInfo> {

    public MqApiCallerDao() {
        super(AT_MqInfo.class);
    }

    public AT_MqInfo getMqInfo(String pServerType){
        AT_MqInfo aT_MqInfo = new AT_MqInfo();
        aT_MqInfo.setServerType(pServerType);

        return selectOne(aT_MqInfo);
    }

}
