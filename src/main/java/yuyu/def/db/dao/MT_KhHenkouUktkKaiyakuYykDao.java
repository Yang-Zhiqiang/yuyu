package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_KhHenkouUktkKaiyakuYyk;

/**
 * 契約保全変更受付内容（解約）予約テーブル(MT_KhHenkouUktkKaiyakuYykDao) アクセス用の DAO クラスです。<br />
 */
public class MT_KhHenkouUktkKaiyakuYykDao extends AbstractDao<MT_KhHenkouUktkKaiyakuYyk> {

    public MT_KhHenkouUktkKaiyakuYykDao() {
        super(MT_KhHenkouUktkKaiyakuYyk.class);
    }

    public MT_KhHenkouUktkKaiyakuYyk getKhHenkouUktkKaiyakuYyk(String pSyono, Integer pHozenhenkouuktkrenno) {
        MT_KhHenkouUktkKaiyakuYyk mT_KhHenkouUktkKaiyakuYyk =  new MT_KhHenkouUktkKaiyakuYyk( pSyono,  pHozenhenkouuktkrenno);
        return this.selectOne(mT_KhHenkouUktkKaiyakuYyk);
    }

}
