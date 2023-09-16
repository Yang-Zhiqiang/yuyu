package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BW_UserIdKanrenWk;

/**
 * ユーザーＩＤ関連ワークテーブル(BW_UserIdKanrenWkDao) アクセス用の DAO クラスです。<br />
 */
public class BW_UserIdKanrenWkDao extends AbstractDao<BW_UserIdKanrenWk> {

    public BW_UserIdKanrenWkDao() {
        super(BW_UserIdKanrenWk.class);
    }

    public BW_UserIdKanrenWk getUserIdKanrenWk(String pIdkbn, String pIdcd) {
        BW_UserIdKanrenWk bW_UserIdKanrenWk =  new BW_UserIdKanrenWk();
        bW_UserIdKanrenWk.setIdkbn(pIdkbn);
        bW_UserIdKanrenWk.setIdcd(pIdcd);
        return this.selectOne(bW_UserIdKanrenWk);
    }
}
