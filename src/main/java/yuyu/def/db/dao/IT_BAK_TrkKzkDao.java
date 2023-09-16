package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.entity.IT_BAK_TrkKzk;

/**
 * 登録家族バックアップテーブル(IT_BAK_TrkKzkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_TrkKzkDao extends AbstractDao<IT_BAK_TrkKzk> {

    public IT_BAK_TrkKzkDao() {
        super(IT_BAK_TrkKzk.class);
    }

    public IT_BAK_TrkKzk getBAKTrkKzk(String pSyono, String pTrkssikibetukey, C_TrkKzkKbn pTrkkzkkbn) {
        IT_BAK_TrkKzk iT_BAK_TrkKzk =  new IT_BAK_TrkKzk( pSyono,  pTrkssikibetukey,  pTrkkzkkbn);
        return this.selectOne(iT_BAK_TrkKzk);
    }
}
