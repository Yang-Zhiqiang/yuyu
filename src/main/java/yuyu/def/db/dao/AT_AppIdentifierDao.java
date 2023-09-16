package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_AppIdentifier;

/**
 * アプリケーション識別子管理テーブル( AT_AppIdentifier ) に対するDB操作を提供する。
 */
public class AT_AppIdentifierDao extends AbstractDao<AT_AppIdentifier> {

    protected AT_AppIdentifierDao() {
        super(AT_AppIdentifier.class);
    }

    public AT_AppIdentifier getAppIdentifierByIdentifier(String pIdentifier){
        AT_AppIdentifier aT_AppIdentifier = new AT_AppIdentifier();
        aT_AppIdentifier.setIdentifier(pIdentifier);

        return selectOne(aT_AppIdentifier);
    }

}
