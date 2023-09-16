package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_CreditHnknTuuti;

/**
 * クレカ返金通知バックアップテーブル(IT_BAK_CreditHnknTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_CreditHnknTuutiDao extends AbstractDao<IT_BAK_CreditHnknTuuti> {

    public IT_BAK_CreditHnknTuutiDao() {
        super(IT_BAK_CreditHnknTuuti.class);
    }

    public IT_BAK_CreditHnknTuuti getBAKCreditHnknTuuti(String pSyono, String pTrkssikibetukey, String pDenrenno, Integer pEdano) {
        IT_BAK_CreditHnknTuuti iT_BAK_CreditHnknTuuti =  new IT_BAK_CreditHnknTuuti( pSyono,  pTrkssikibetukey,  pDenrenno,  pEdano);
        return this.selectOne(iT_BAK_CreditHnknTuuti);
    }
}
