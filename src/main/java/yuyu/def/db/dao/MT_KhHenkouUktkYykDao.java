package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;

/**
 * 契約保全変更受付予約テーブル(MT_KhHenkouUktkYykDao) アクセス用の DAO クラスです。<br />
 */
public class MT_KhHenkouUktkYykDao extends AbstractDao<MT_KhHenkouUktkYyk> {

    public MT_KhHenkouUktkYykDao() {
        super(MT_KhHenkouUktkYyk.class);
    }

    public MT_KhHenkouUktkYyk getKhHenkouUktkYyk(String pSyono, Integer pHozenhenkouuktkrenno) {
        MT_KhHenkouUktkYyk mT_KhHenkouUktkYyk =  new MT_KhHenkouUktkYyk( pSyono,  pHozenhenkouuktkrenno);
        return this.selectOne(mT_KhHenkouUktkYyk);
    }

}
