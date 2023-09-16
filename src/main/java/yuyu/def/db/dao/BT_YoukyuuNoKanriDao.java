package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;

/**
 * 要求通番管理テーブル(BT_YoukyuuNoKanriDao) アクセス用の DAO クラスです。<br />
 */
public class BT_YoukyuuNoKanriDao extends AbstractDao<BT_YoukyuuNoKanri> {

    public BT_YoukyuuNoKanriDao() {
        super(BT_YoukyuuNoKanri.class);
    }

    public BT_YoukyuuNoKanri getYoukyuuNoKanri(String pYoukyuuno){
        BT_YoukyuuNoKanri bT_YoukyuuNoKanri =  new BT_YoukyuuNoKanri();
        bT_YoukyuuNoKanri.setYoukyuuno(pYoukyuuno);
        return this.selectOne(bT_YoukyuuNoKanri);
    }
}
