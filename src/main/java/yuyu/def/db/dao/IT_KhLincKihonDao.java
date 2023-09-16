package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhLincKihon;

/**
 * 契約保全ＬＩＮＣ基本テーブル(IT_KhLincKihonDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhLincKihonDao extends AbstractDao<IT_KhLincKihon> {

    public IT_KhLincKihonDao() {
        super(IT_KhLincKihon.class);
    }

    public IT_KhLincKihon getKhLincKihon(String pSyono) {
        IT_KhLincKihon iT_KhLincKihon =  new IT_KhLincKihon( pSyono);
        return this.selectOne(iT_KhLincKihon);
    }
}
