package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhLincKihon;

/**
 * 契約保全ＬＩＮＣ基本バックアップテーブル(IT_BAK_KhLincKihonDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhLincKihonDao extends AbstractDao<IT_BAK_KhLincKihon> {

    public IT_BAK_KhLincKihonDao() {
        super(IT_BAK_KhLincKihon.class);
    }

    public IT_BAK_KhLincKihon getBAKKhLincKihon(String pSyono, String pTrkssikibetukey) {
        IT_BAK_KhLincKihon iT_BAK_KhLincKihon =  new IT_BAK_KhLincKihon( pSyono,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_KhLincKihon);
    }
}
