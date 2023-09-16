package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KykKihon;

/**
 * 契約基本バックアップテーブル(IT_BAK_KykKihonDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KykKihonDao extends AbstractDao<IT_BAK_KykKihon> {

    public IT_BAK_KykKihonDao() {
        super(IT_BAK_KykKihon.class);
    }

    public IT_BAK_KykKihon getBAKKykKihon(String pSyono, String pTrkssikibetukey) {
        IT_BAK_KykKihon iT_BAK_KykKihon =  new IT_BAK_KykKihon( pSyono,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_KykKihon);
    }
}
