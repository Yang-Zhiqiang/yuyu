package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_SousaRireki;
import java.util.List;

/**
 * 操作履歴テーブル(MT_SousaRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class MT_SousaRirekiDao extends AbstractDao<MT_SousaRireki> {

    public MT_SousaRirekiDao() {
        super(MT_SousaRireki.class);
    }

    @Deprecated
    public MT_SousaRireki getSousaRireki(String pTtdksikibetuid) {
        MT_SousaRireki mT_SousaRireki =  new MT_SousaRireki();
        mT_SousaRireki.setTtdksikibetuid(pTtdksikibetuid);
        return this.selectOne(mT_SousaRireki);
    }

    @Override
    @Deprecated
    public List<MT_SousaRireki> selectAll() {
        return super.selectAll();
    }
}
