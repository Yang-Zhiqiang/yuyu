package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_BAK_DsTorihikiServiceKanri;
import java.util.List;

/**
 * ＤＳ取引サービス管理バックアップテーブル(MT_BAK_DsTorihikiServiceKanriDao) アクセス用の DAO クラスです。<br />
 */
public class MT_BAK_DsTorihikiServiceKanriDao extends AbstractDao<MT_BAK_DsTorihikiServiceKanri> {

    public MT_BAK_DsTorihikiServiceKanriDao() {
        super(MT_BAK_DsTorihikiServiceKanri.class);
    }

    @Deprecated
    public MT_BAK_DsTorihikiServiceKanri getBAKDsTorihikiServiceKanri(String pDskokno, String pSyono, String pTrkssikibetukey) {
        MT_BAK_DsTorihikiServiceKanri mT_BAK_DsTorihikiServiceKanri =  new MT_BAK_DsTorihikiServiceKanri();
        mT_BAK_DsTorihikiServiceKanri.setDskokno(pDskokno);
        mT_BAK_DsTorihikiServiceKanri.setSyono(pSyono);
        mT_BAK_DsTorihikiServiceKanri.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(mT_BAK_DsTorihikiServiceKanri);
    }

    @Override
    @Deprecated
    public List<MT_BAK_DsTorihikiServiceKanri> selectAll() {
        return super.selectAll();
    }
}
