package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_UserIdKanren;

/**
 * ユーザーＩＤ関連テーブル(AT_UserIdKanrenDao) アクセス用の DAO クラスです。<br />
 */
public class AT_UserIdKanrenDao extends AbstractDao<AT_UserIdKanren> {

    public AT_UserIdKanrenDao() {
        super(AT_UserIdKanren.class);
    }

    public AT_UserIdKanren getUserIdKanren(String pIdkbn, String pIdcd) {
        AT_UserIdKanren aT_UserIdKanren =  new AT_UserIdKanren();
        aT_UserIdKanren.setIdkbn(pIdkbn);
        aT_UserIdKanren.setIdcd(pIdcd);
        return this.selectOne(aT_UserIdKanren);
    }
}
