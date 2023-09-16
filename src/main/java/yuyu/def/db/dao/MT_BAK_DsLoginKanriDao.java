package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_BAK_DsLoginKanri;
import java.util.List;

/**
 * ＤＳログイン管理バックアップテーブル(MT_BAK_DsLoginKanriDao) アクセス用の DAO クラスです。<br />
 */
public class MT_BAK_DsLoginKanriDao extends AbstractDao<MT_BAK_DsLoginKanri> {

    public MT_BAK_DsLoginKanriDao() {
        super(MT_BAK_DsLoginKanri.class);
    }

    @Deprecated
    public MT_BAK_DsLoginKanri getBAKDsLoginKanri(String pDskokno, String pTrkssikibetukey) {
        MT_BAK_DsLoginKanri mT_BAK_DsLoginKanri =  new MT_BAK_DsLoginKanri();
        mT_BAK_DsLoginKanri.setDskokno(pDskokno);
        mT_BAK_DsLoginKanri.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(mT_BAK_DsLoginKanri);
    }

    @Override
    @Deprecated
    public List<MT_BAK_DsLoginKanri> selectAll() {
        return super.selectAll();
    }
}
