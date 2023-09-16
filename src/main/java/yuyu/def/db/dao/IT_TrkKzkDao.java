package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.entity.IT_TrkKzk;

/**
 * 登録家族テーブル(IT_TrkKzkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TrkKzkDao extends AbstractDao<IT_TrkKzk> {

    public IT_TrkKzkDao() {
        super(IT_TrkKzk.class);
    }

    public IT_TrkKzk getTrkKzk(String pSyono, C_TrkKzkKbn pTrkkzkkbn) {
        IT_TrkKzk iT_TrkKzk =  new IT_TrkKzk( pSyono,  pTrkkzkkbn);
        return this.selectOne(iT_TrkKzk);
    }
}
