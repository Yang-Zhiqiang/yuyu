package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_CreditHnknTuuti;

/**
 * クレカ返金通知テーブル(IT_CreditHnknTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_CreditHnknTuutiDao extends AbstractDao<IT_CreditHnknTuuti> {

    public IT_CreditHnknTuutiDao() {
        super(IT_CreditHnknTuuti.class);
    }

    public IT_CreditHnknTuuti getCreditHnknTuuti(String pSyono, String pDenrenno, Integer pEdano) {
        IT_CreditHnknTuuti iT_CreditHnknTuuti =  new IT_CreditHnknTuuti( pSyono,  pDenrenno,  pEdano);
        return this.selectOne(iT_CreditHnknTuuti);
    }
}
