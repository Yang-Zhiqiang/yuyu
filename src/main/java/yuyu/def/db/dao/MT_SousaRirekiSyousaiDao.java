package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;
import java.util.List;

/**
 * 操作履歴詳細テーブル(MT_SousaRirekiSyousaiDao) アクセス用の DAO クラスです。<br />
 */
public class MT_SousaRirekiSyousaiDao extends AbstractDao<MT_SousaRirekiSyousai> {

    public MT_SousaRirekiSyousaiDao() {
        super(MT_SousaRirekiSyousai.class);
    }

    @Deprecated
    public MT_SousaRirekiSyousai getSousaRirekiSyousai(String pTtdksikibetuid, Integer pSousarirekirenno) {
        MT_SousaRirekiSyousai mT_SousaRirekiSyousai =  new MT_SousaRirekiSyousai();
        mT_SousaRirekiSyousai.setTtdksikibetuid(pTtdksikibetuid);
        mT_SousaRirekiSyousai.setSousarirekirenno(pSousarirekirenno);
        return this.selectOne(mT_SousaRirekiSyousai);
    }

    @Override
    @Deprecated
    public List<MT_SousaRirekiSyousai> selectAll() {
        return super.selectAll();
    }
}
