package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_UserSettei;

/**
 * ユーザー設定テーブル( AT_UserSettei ) に対するDB操作を提供する。
 */
public class AT_UserSetteiDao extends AbstractDao<AT_UserSettei> {

    protected AT_UserSetteiDao() {
        super(AT_UserSettei.class);
    }

    public AT_UserSettei getUserSettei(String pUserId){
        AT_UserSettei aT_UserSettei = new AT_UserSettei();
        aT_UserSettei.setUserId(pUserId);

        return selectOne(aT_UserSettei);
    }

}
