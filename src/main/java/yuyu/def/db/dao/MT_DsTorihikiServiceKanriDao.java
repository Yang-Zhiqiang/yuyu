package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import java.util.List;

/**
 * ＤＳ取引サービス管理テーブル(MT_DsTorihikiServiceKanriDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsTorihikiServiceKanriDao extends AbstractDao<MT_DsTorihikiServiceKanri> {

    public MT_DsTorihikiServiceKanriDao() {
        super(MT_DsTorihikiServiceKanri.class);
    }

    @Deprecated
    public MT_DsTorihikiServiceKanri getDsTorihikiServiceKanri(String pDskokno, String pSyono) {
        MT_DsTorihikiServiceKanri mT_DsTorihikiServiceKanri =  new MT_DsTorihikiServiceKanri();
        mT_DsTorihikiServiceKanri.setDskokno(pDskokno);
        mT_DsTorihikiServiceKanri.setSyono(pSyono);
        return this.selectOne(mT_DsTorihikiServiceKanri);
    }

    @Override
    @Deprecated
    public List<MT_DsTorihikiServiceKanri> selectAll() {
        return super.selectAll();
    }
}
