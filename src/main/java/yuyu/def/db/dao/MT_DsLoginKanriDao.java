package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_DsLoginKanri;
import java.util.List;

/**
 * ＤＳログイン管理テーブル(MT_DsLoginKanriDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsLoginKanriDao extends AbstractDao<MT_DsLoginKanri> {

    public MT_DsLoginKanriDao() {
        super(MT_DsLoginKanri.class);
    }

    @Deprecated
    public MT_DsLoginKanri getDsLoginKanri(String pDskokno) {
        MT_DsLoginKanri mT_DsLoginKanri =  new MT_DsLoginKanri();
        mT_DsLoginKanri.setDskokno(pDskokno);
        return this.selectOne(mT_DsLoginKanri);
    }

    @Override
    @Deprecated
    public List<MT_DsLoginKanri> selectAll() {
        return super.selectAll();
    }
}
